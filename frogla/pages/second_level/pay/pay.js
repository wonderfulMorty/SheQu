var app = getApp();
Page({
  data: {
    // tab 切换
   
  },
  onLoad: function (option) {
    console.log("goodsid:"+option.id)
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
  pay:function(e){
    var uid = app.globalData.uid
    console.log("uid:" + uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      e.detail.value.uid = uid
      var json = JSON.stringify(e.detail.value)
      console.log("pay:" + json);
      wx.request({
        url: app.getHeader() + '/SheQu/insertPayment', // 拼接接口地址
        method: 'post',
        data: json,
        contentType: 'application/json',
        success(res) {
          console.log('res.data:' + res.data)
          if (res.data != "failure") {
            wx.showToast({
              title: '信息提交成功',
              icon: 'success',
              duration: 2000
            })
          } else {
            wx.showToast({
              title: '信息提交失败',
              duration: 1000,
              icon: 'none'
            })
          }
        }
      })
    }
  },
  showok: function () {
    wx.showToast({
      title: '信息提交成功',
      icon: 'success',
      duration: 2000
    })
  }
})



