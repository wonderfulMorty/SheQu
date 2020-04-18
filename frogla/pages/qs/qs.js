//index.js
const app = getApp()
var su_id;
var mydata=[];
var results = new Array(5);
var uid
Page({
  data: {
    cidList:[],
    obj:{},
    problem: null,
    title:null,
    optionList:[],
    resu: results,
    check:false,
    dataList:[],
    dataobj : {},
  },

  onLoad: function (options) {
    console.log("qs---->" + options.title)
    console.log("qs---->" + options.id)
    su_id = options.id
    this.setData({//获取上一个界面传过来的值（login.js和register.js）
      title: decodeURIComponent(options.title),
    })
    this.findProblem();
  },

  radioChange: function (e) {
    var that = this
    var cid = e.detail.value;//获取index.wxml中的data-id数据
    console.log("cid"+cid)
    that.data.cidList.push(cid)
    var json = JSON.stringify(mydata)
    //console.log("json:" + json)
  },
  findProblem: function (e) {
   var  that = this;
    wx.request({
      url: app.getHeader() + '/SheQu/getQueAndOpt',
      method: 'POST',
      data: { "su_id": su_id},
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      contentType: 'application/json',
      success: function (res) {
        var json = JSON.stringify(res.data)
        //console.log("json:" + json)
        mydata = []
        for (var i = 0; i < res.data.length; i++) {
          mydata.push(res.data[i])
        }
        that.data.probelm = mydata
        that.setData({
          problem: mydata
        })
      },
      fail() {
        console.log('xxsad')
      }
    })
  },
  qs_submit:function(e){
    var that = this
    var target_data = []
    uid = app.globalData.uid
    console.log("cidList:" + that.data.cidList)
    if (uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
      for (var n = 0; n < that.data.cidList.length; n++) {
        for (var m = 0; m < mydata.length; m++) {
          for (var i = 0; i < 4; i++) {
            if (that.data.cidList[n] == mydata[m].queandopt[i].cid) {
              mydata[m].queandopt[i].su_id = su_id
              mydata[m].queandopt[i].uid = uid;
              target_data.push(mydata[m].queandopt[i])
              console.log("target_datapush了")
            }
          }
        }
      }
    }
    console.log("that.data.su_id:" + su_id)
    var json = JSON.stringify(target_data)
    console.log("json:" + json)
    wx.request({
      url: app.getHeader() + '/SheQu/getCheckedQueAndOpt', // 拼接接口地址
      method: 'post',
      data: json,
      contentType: 'application/json',
      success(res) {
        console.log('res:' + res.data)
        if (res.data == "success") {
          wx.showToast({
            title: '问卷提交成功',
            icon: 'success',
            duration: 2000
          })
        } else {
          wx.showToast({
            title: '问卷提交失败',
            duration: 1000,
            icon: 'none'
          })
        }
      }
    })
  }
})
