//index.js
const app = getApp()
var su_id;
var mydata=[];
var results = new Array(5);
var uid;
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
    var that = this
    console.log('notices.js----->openid:' + app.globalData.openid)
    uid = app.globalData.uid
    console.log("uid:" + app.globalData.uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
      that.setData({//获取上一个界面传过来的值（login.js和register.js）
        title: decodeURIComponent(options.title),
      })
      that.findProblem();
    }
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
    uid = app.globalData.uid
    console.log("uid:" + app.globalData.uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      wx.request({
        url: app.getHeader() + '/SheQu/findUserQueAndOpt',
        method: 'POST',
        data: { "uid": app.globalData.uid },
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8' //
        },
        success: function (res) {
          var json = JSON.stringify(res.data)
          //console.log("json:" + json)
          that.setData({
            problem: res.data
          })
        },
        fail() {
          console.log('xxsad')
        }
      })
    }
  },
})
