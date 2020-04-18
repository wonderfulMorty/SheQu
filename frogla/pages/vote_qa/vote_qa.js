var app = getApp();
Page({
  data: {
    optionList: [
      {
        icon: ''
      },
      {
        icon: ''
      }
    ],

    // tab 切换
    tabArr: {
      curHdIndex: 1,
      curBdIndex: 1
    },

    buildingArray: [],
    buildingIndex: 0,
    unitArray: [],
    unitIndex: 0,
    roomArray: [],
    roomIndex: 0,
    showAddBtn: 1,
    votepack: {
      uid:"",
      title: "",
      text: "",
      options: "",
      optionCount:""
    },
  },
  onLoad: function () {


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
  //tab切换
  tab: function (e) {
    //var dataId = e.currentTarget.dataset.id;
    var dataId = e.currentTarget.id;
    var obj = {};
    obj.curHdIndex = dataId;
    obj.curBdIndex = dataId;
    this.setData({
      tabArr: obj
    })
    console.log(obj);
  },
  recordValue: function (e) {
    let _optionList = this.data.optionList;
    let _index = e.target.dataset.index;
    let value = e.detail.value;
    _optionList[_index].value = value;

    this.setData({ optionList: _optionList });
  },
  addOption: function (e) {
    let _optionList = this.data.optionList;
    _optionList.push({ icon: '../../images/5.png' })
    this.setData({ optionList: _optionList });
    // 选项大于15个后移除添加按钮
    if (_optionList.length >= 5) {
      this.setData({ showAddBtn: 0 });
      wx.showToast({
        title: '最多只能添加5个选项',
        icon: 'none',
        duration: 2000
      })
    }
  },
  delOption: function (e) {
    let _index = e.target.dataset.index;
    let _optionList = this.data.optionList;
    _optionList.splice(_index, 1);
    this.setData({ optionList: _optionList });
  },
  //设置title内容
  set_title_text: function (e) {
    var title = e.detail.value;
    this.setData({
      'votepack.title': title,
    })
  },
  //设置描述内容
  set_content: function (e) {
    var content = e.detail.value;
    this.setData({
      'votepack.text': content,
    })
  },
  saveVote: function () {
    console.log("xxxdbja:" + app.globalData.uid)
    var uid = app.globalData.uid
    if (uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
      var optionList = this.data.optionList;
      var votepack = this.data.votepack;
      votepack.optionCount = optionList.length
      votepack.options = optionList
      votepack.uid = uid
      var votepackJson = JSON.stringify(votepack)
      console.log("votepack:" + votepackJson)
      wx.request({
        url: app.getHeader() + '/SheQu/insertVote', // 拼接接口地址
        method: 'post',
        data: votepackJson,
        contentType: 'application/json',
        success(res) {
          console.log('res:' + res)
          if (res.data == "success") {
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



