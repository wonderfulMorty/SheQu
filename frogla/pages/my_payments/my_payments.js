// pages/second_level/notice/notice.js
var app = getApp()
var uid;
Page({
  data: {
    
  },
  onLoad: function () {
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
      wx.request({
        url: app.getHeader() + '/SheQu/findPayByUid',
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8'//
        },
        data: { "uid": app.globalData.uid},
        success: function (res) {
          that.setData({
            list: res.data
          })
        },
        fail() {
          console.log('xxsad')
        }
      })
    }
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
})