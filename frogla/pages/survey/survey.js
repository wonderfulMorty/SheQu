var app = getApp();
var uid;
Page({
  data: {
    // tab 切换
    surveyArray: [],
    idList:"",
    index:0
  },
  changeSurvey: function (e) {
    this.setData({
      index: e.detail.value,
    })
  },
  onLoad: function () {
    var that = this
    var idArr = []
    var surveyArr = []
    wx.request({
      url: app.getHeader() + '/SheQu/getAllSurvey',
      method: 'POST',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      contentType: 'application/json',
      success: function (res) {
        var json = JSON.stringify(res.data)
        console.log("surveyArray:" + json)
        for (var i = 0; i < res.data.length;i++){
          surveyArr.push(res.data[i])
          idArr.push(res.data[i].id)
        }
        console.log("surveyArr:" + idArr[0])
        that.setData({
          surveyArray: surveyArr,
          idList: idArr
        })
      },
      fail() {
        console.log('xxsad')
      }
    })
  },
  submitSurvey:function(e){
    var that = this
    var id = that.data.idList[e.detail.value.id]
    var title = that.data.surveyArray[e.detail.value.id].title
    console.log("title:" + title)
    //参数值太长要编码解码传递和接受：encodeURIComponent(title)
    uid = app.globalData.uid
    console.log("uid:" + uid)
    if (uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else{
      wx.navigateTo({
        url: '../qs/qs?id=' + id + '&title=' + encodeURIComponent(title),
      })
    }
  }
})



