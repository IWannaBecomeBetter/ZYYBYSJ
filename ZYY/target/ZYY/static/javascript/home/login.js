// 登录页面

function init() {

}

/**
 * 回车点击事件
 */
function loginKeydown() {
    if (event.keyCode == 13) {
        event.preventDefault();
        $('#loginbtn').click();
    }
}

// 登录
function loginIn() {

    if ($('#usercode').val().trim() === '') {
        showWaringToast('用户代码不能为空');
        return;
    }

    if ($('#password').val().trim() === '') {
        showWaringToast('密码不能为空');
        return;
    }

    var url = base + '/login';
    doAjaxPost(url, $('#loginForm'), loginSuccess);
}

function loginSuccess(data) {
    if(data.usertype =='0'){//学生
        gotoPage('student_index');
    }else{
        gotoPage('manager_index');
    }
}

$(function () {
    init();
});