//index.js
Page({
  data: {
    //轮播图配置
    autoplay: true,
    interval: 4500,
    duration: 1600
  },
  onLoad: function () {
    let that = this; 
    let data = {
      "datas": [
        {
          "id": 1,
          "imgurl": "/images/river-logo.jpeg"
        },
        {
          "id": 2,
          "imgurl": "/images/river1.jpg"
        },
        {
          "id": 3,
          "imgurl": "/images/river2.jpg"
        }
      ]
    }; 
    that.setData({
      lunboData: data.datas
    })
  },
  goToQuestionPage(){
    wx.navigateTo({
      url: '/pages/question/question',
    })
  }
})