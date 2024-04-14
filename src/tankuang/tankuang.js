/**
 * 显示对话框的函数
 * 创建并显示一个包含小盒子和关闭按钮的大盒子。
 */
function showDialog() {
    // 创建大盒子并添加到页面
    let bigBox = document.createElement('div');
    bigBox.id = 'bigBox';
    document.body.append(bigBox);

    // 创建小盒子并添加到大盒子中
    let smallBox = document.createElement('div');
    smallBox.id = 'smallBox'
    bigBox.append(smallBox);

    // 创建关闭按钮，添加到小盒子中，并添加点击事件关闭大盒子
    let closeBtn = document.createElement('div');
    closeBtn.id = 'closeBtn';
    closeBtn.innerText = 'x';
    closeBtn.addEventListener('click', function () {
        bigBox.remove();
    })
    smallBox.append(closeBtn);
}