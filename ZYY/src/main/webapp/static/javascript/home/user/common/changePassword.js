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
        $('#changePassword').click();
    }
}

// 修改密码
function changePassword() {
    var oldPassword = $('#oldPassword').val().trim();
    var newPassword = $('#newPassword').val().trim();
    var confirmPassword = $('#confirmPassword').val().trim();
    debugger;
    if (oldPassword === '') {
        showWaringToast('原密码不能为空');
        return;
    }else if (newPassword === '') {
        showWaringToast('新密码不能为空');
        return;
    }else if (!(newPassword == confirmPassword)) {
        showWaringToast('两次密码不一致请重试');
        return;
    }else{
        var url = base + '/changePassword';
        doAjaxPost(url, $('#changePasswordForm'), changeSuccess);
    }

}

function changeSuccess(data) {
    showSuccessToast("修改成功");
}

$(function () {
    init();
});