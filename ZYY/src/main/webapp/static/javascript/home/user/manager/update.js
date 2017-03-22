/**
 * Created by Administrator on 2017/3/13.
 */
function init() {

}

/**
 * 回车点击事件
 */
function loginKeydown() {
    if (event.keyCode == 13) {
        event.preventDefault();
        $('#update').click();
    }
}

// 修改
function update() {
    var username = $('#username').val().trim();
    var telephone = $('#telephone').val().trim();
    if (username === '') {
        showWaringToast('姓名不能为空');
        return;
    }else if (telephone === '') {
        showWaringToast('联系方式不能为空');
        return;
    }else{
        var url = base + '/manager_update';
        doAjaxPost(url, $('#updateForm'), changeSuccess);
    }

}

function changeSuccess(data) {
    showSuccessToast("修改成功");
}

$(function () {
    init();
});