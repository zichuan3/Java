function checkAll() {
    var chks = document.getElementsByClassName("chk")
    for (let i = 0; i < chks.length; i++) {
        chks[i].checked = true;
    }
    bigCount();
}

function cancelAll() {
    var chks = document.getElementsByClassName("chk")
    for (let i = 0; i < chks.length; i++) {
        chks[i].checked = false;
    }
    bigCount();
}

function addRow(a) {
    a.parentNode.childNodes[3].value = a.parentNode.childNodes[3].value * 1 + 1;
    smallCount(a);
    bigCount();
}

function delRow(a) {

    if (a.parentNode.childNodes[3].value == 1) {
        if (confirm("是否删除")) {
            a.parentNode.parentNode.remove()
        }
        return
    }
    a.parentNode.childNodes[3].value = a.parentNode.childNodes[3].value * 1 - 1;
    smallCount(a);
    bigCount();
}

function smallCount(a) {
    var price = a.parentNode.parentNode.childNodes[9].innerText;
    var count = a.parentNode.childNodes[3].value * 1 ;
    a.parentNode.parentNode.childNodes[13].innerText = price * count;
}
function bigCount(){
    var count = 0;
    for (let i = 0;i<document.getElementsByClassName("small_count").length;i++){
        if (document.getElementsByClassName("chk")[i].checked){
            count += document.getElementsByClassName("small_count")[i].innerText * 1
        }
    }
    document.getElementsByClassName("big_count")[0].innerText = "合计"+count+"元";
}