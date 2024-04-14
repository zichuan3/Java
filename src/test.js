//author：奥里给小饼干
//site：hellodajun.cn
// 初始数据
const data = [
    {
        url: './images/banner01.jpg',
        title: '我是banner01',
        color: '#4e6acd'
    }, {
        url: './images/banner02.jpg',
        title: '我是banner02',
        color: '#fa8484'
    }, {
        url: './images/banner03.jpg',
        title: '我是banner03',
        color: '#ed8c03'
    }]
// 准备工作：先获取所有需要操作的元素
const next = document.querySelector('.next')
const img = document.querySelector('img')
const lis = document.querySelectorAll('ul li')
let i = 0 //下标从0开始计
//0、封装render函数提取公共代码
function render() {
    //0.1、 更换数组中第i个banner图
    img.src = data[i].url
    //0.2、 删除已有的 active
    document.querySelector('.active').classList.remove('active')
    // 0.3、添加的 active
    lis[i].classList.add('active')
}

// 1、按钮的注册点击事件
// 1.1 右侧的按钮点击事件->实现切换图片和圆点
next.addEventListener('click', function () {
    //1.2点击之后i每次加1
    i++
    //1.3大于等于数组长度(3) 的时候 下标从0开始
    if (i >= data.length) {
        i = 0
    }
    //渲染页面
    render()
})

// 2、 右侧的按钮点击事件->实现切换图片和圆点
const prev = document.querySelector('.prev')
prev.addEventListener('click', function () {
    //2.1、同理 每次点击i就减1
    i--
    //2.2、小于0 时， 下标从最后一位下标(data.length - 1)开始
    if (i < 0) {
        i = data.length - 1
    }
    //渲染一下
    render()

})

// 3、自动播放图片->定时器 —> 自动执行已经写好按钮点击事件
let timer = setInterval(function () {
    //3.1、 自动点击事件的方法 ！直接用就行
    next.click()
}, 1000)

// 4、 鼠标经过/离开 可以继续/暂停 播放
const slider = document.querySelector('.slider')
//4.1 给大盒子注册鼠标经过事件
slider.addEventListener('mouseenter', function () {
    //4.2 经过就清除定时器
    clearInterval(timer)
})

//5.1、鼠标离开事件
slider.addEventListener('mouseleave', function () {
    // 5.2鼠标离开就重新开启定时器
    timer = setInterval(function () {
        // 5.3 定时器中添加自动点击按钮
        next.click()
    }, 1000)
})

// 6、点击小圆点切换图片
// 6.1、遍历伪数组中的每一个DOM对象(li)
for (let j = 0; j < lis.length; j++) {
    // 6.2、给小圆点注册点击事件
    lis[j].addEventListener('click', function () {
        //6.3、跟i变量保持一致 点击第j个圆点就切换到第i个banner图
        i = j
        //渲染页面
        render()
    })
}
//author：奥里给小饼干
//site：hellodajun.cn