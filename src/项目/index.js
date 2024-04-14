onscroll = function () {
    if (window.scrollY >= 10) {
        document.getElementById("s6").style.position = "fixed";
        document.getElementById("s6").style.top = "0px";
    }

    if (window.scrollY <= 10) {
        document.getElementById("s6").style.position = "relative";
        document.getElementById("s6").style.top = "0px";
    }
}
const data = [
    {
        url: "../img/1.jpg",
        title: "第一张图"
    },
    {
        url: "../img/2.jpg",
        title: "第二张图"
    },
    {
        url: "../img/6.jpg",
        title: "第三张图"
    },
    {
        url: "../img/4.jpg",
        title: "第四张图"
    }
]
const next = document.querySelector(".next")
const img = document.querySelector(".slides>img")
const lis = document.querySelectorAll("#s4>div>div")
let i = 0;

function render() {
    img.src = data[i].url;
    document.querySelector(".active").classList.remove("active")
    lis[i].classList.add("active")
}

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
const prev = document.querySelector(".prev")
prev.addEventListener("click", function () {
    i--;
    if (i < 0) {
        i = data.length - 1;
    }
    render()
})
let timer = setInterval(function () {
    next.click()
}, 2000)
const slider = document.querySelector(".slider")
slider.addEventListener("mouseleave",function (){
    timer = setInterval(function () {
        next.click()
    }, 2000)
})
slider.addEventListener("mouseenter",function (){
    clearInterval(timer);
})
for (let j = 0;j<lis.length;j++){
    lis[j].addEventListener("click",function (){
        i=j;
        render();
    })
}