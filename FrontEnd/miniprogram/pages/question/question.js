Page({
  data:{
    questionList:[],
    rightAnswer:'A',
    select: '',
    title: '',
    answerA:'',
    answerB:'',
    answerC: '',
    answerD: '',
    currentId: 0,
    totalNumber: 0,
    correctUrl: '/images/0.png',
    correctNumber: 0,
    percent: 0,
    isSelected: false,
    imageList: ['/images/0.png','/images/1.png','/images/2.png','/images/3.png','/images/4.png','/images/5.png','/images/6.png','/images/7.png','/images/8.png','/images/9.png','/images/10.png',],
    questionVisible: true,
    returnVisible:false,
    resultInfo: '',
    infoList:['还需要多加了解哦~','加油！','再接再厉,离满分不远了！','真棒~全部都答对了！']
  },
  onLoad(){
    wx.cloud.callFunction({
      name: 'http'}).then(res =>{
        this.data.questionList = JSON.parse(res.result)
        //this.data.questionList = eval('(' + res.result + ')')
        this.setData({totalNumber:this.data.questionList.length})
        console.log(this.data.questionList)
        // 给出第一道题
        this.updateQuestion()
    }).catch(err =>{
      wx.switchTab({
        url: '/pages/index/index',
      })
      wx.showToast({
        icon:'error',
        title: '暂时不可以答题'
      })
    })
  },
  // 更新题目
  updateQuestion(){
    // 更新进度条
    this.setData({percent:this.data.currentId/this.data.totalNumber*100}) 
    //答题结束
    if (this.data.currentId == this.data.questionList.length){
      this.setData({questionVisible: false})
      this.setData({returnVisible: true})
      // 设置结果语言
      if(this.data.correctNumber <= this.data.totalNumber/3){
        this.setData({resultInfo : this.data.infoList[0]})
      } else if (this.data.correctNumber <= this.data.totalNumber/1.5){
        this.setData({resultInfo : this.data.infoList[1]})
      } else if (this.data.correctNumber == this.data.totalNumber){
        this.setData({resultInfo : this.data.infoList[3]})
      } else {
          this.setData({resultInfo : this.data.infoList[2]})
      }
      return
    }
    this.setData({title : this.data.questionList[this.data.currentId].title})
    this.setData({answerA : this.data.questionList[this.data.currentId].answerA})
    this.setData({answerB : this.data.questionList[this.data.currentId].answerB})
    this.setData({answerC : this.data.questionList[this.data.currentId].answerC})
    this.setData({answerD : this.data.questionList[this.data.currentId].answerD})
    this.setData({rightAnswer : this.data.questionList[this.data.currentId].correctAnswer})
    this.setData({currentId: this.data.currentId+1})
  },
  // 更新选项
  radioChange(e){
    let select = e.detail.value
    console.log("用户选择了：" + select)
    this.data.select = select
  },
  // 提交答题
  submit(){
    if (!this.data.select){
      wx.showToast({
        icon:'none',
        title: '请进行选择'
      })
    }
    else if(this.data.select == this.data.rightAnswer){
      console.log("回答正确")
      wx.showToast({
        title: '回答正确'
      })
      // 更新正确率
      this.setData({correctNumber: this.data.correctNumber + 1})
      this.setData({correctUrl: this.data.imageList[this.data.correctNumber]})
      // 下一题
      this.updateQuestion()
    } else {
      console.log("回答错误")
      wx.showToast({
        icon:'error',
        title: '回答错误'
      })
      // 下一题
      this.updateQuestion()
    }
    // 重置select的值
    this.setData({select : ''})
    this.setData({isSelected : false})
  },
  returnToIndex(){
    wx.switchTab({
      url: '/pages/index/index',
    })
  }
})