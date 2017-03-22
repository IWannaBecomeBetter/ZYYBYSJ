/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#maintenanceTable').datagrid(
        {
            title: 'Repair List',
            iconCls: 'icon-edit',
            pagination: true, //显示分页
            pageSize: 10, //页大小
            pageList: [10, 20, 30, 40], //页大小下拉选项此项各value是pageSize的倍数
            fit: true, //datagrid自适应宽度
            fitColumn: true, //列自适应宽度
            singleSelect: true,
            idField: 'id',
            url: 'maintenance/list',
            toolbar: '#toolbar',
            columns: [[
                {
                    field: 'description',
                    title: '维修信息',
                    width: 500,
                    align: 'center',
                },
                {
                    field: 'startdate',
                    title: '申报时间',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        return dateFormat(value,'yyyy-MM-dd hh:mm',true);
                    }
                },
                {
                    field: 'enddate',
                    title: '结束时间',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value!==null&&value!==''){
                            return dateFormat(value,'yyyy-MM-dd hh:mm',true);
                        }
                    }
                },
                {
                    field: 'repairstate',
                    title: '当前状态',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value=='0'){
                            return '申报维修中'
                        }else if(value=='1'){
                            return '维修完成'
                        }
                    }
                },
            ]],
        });
}

function addRepair() {
    $('#maintenanceDlg').dialog('open').dialog('setTitle', '维修申报');
    $('#repairForm').form('clear');
}

function addSuccess(data) {
    $('#maintenanceTable').datagrid('reload');
    $('#maintenanceDlg').dialog('close');
    showSuccessToast("申报成功");
}

function saveRepair() {
    if ($('#description').val().trim() === '') {
        showWaringToast('申报内容不能为空');
        return;
    }

    var url = base + '/maintenance/addRepair';
    doAjaxPost(url, $('#repairForm'), addSuccess);
}

$(function () {
    init();
});