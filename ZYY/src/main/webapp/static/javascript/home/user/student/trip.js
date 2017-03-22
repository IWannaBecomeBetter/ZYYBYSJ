/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#tripTable').datagrid(
        {
            title: 'Trip List',
            iconCls: 'icon-edit',
            pagination: true, //显示分页
            pageSize: 10, //页大小
            pageList: [10, 20, 30, 40], //页大小下拉选项此项各value是pageSize的倍数
            fit: true, //datagrid自适应宽度
            fitColumn: true, //列自适应宽度
            singleSelect: true,
            idField: 'id',
            url: 'myList',
            toolbar: '#toolbar',
            columns: [[
                {
                    field: 'reason',
                    title: '离校理由',
                    width: 500,
                    align: 'center',
                },
                {
                    field: 'outDate',
                    title: '离校时间',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        return dateFormat(value,'yyyy-MM-dd',true);
                    }
                },
                {
                    field: 'inDate',
                    title: '预计返校时间',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value!==null&&value!==''){
                            return dateFormat(value,'yyyy-MM-dd',true);
                        }
                    }
                },
                {
                    field: 'tripstate',
                    title: '当前状态',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value=='0'){
                            return '离校中'
                        }else if(value=='1'){
                            return '已返校'
                        }
                    }
                },
            ]],
            onBeforeEdit: function (index, row) {
                row.editing = true;
                $('#tripfm').datagrid('refreshRow', index);
            },
            onAfterEdit: function (index, row) {
                row.editing = false;
                update(row);
                $('#tripfm').datagrid('refreshRow', index);
            },
            onCancelEdit: function (index, row) {
                row.editing = false;
                $('#tripfm').datagrid('refreshRow', index);
            }
        });
}

function addTrip() {
    $('#tripDlg').dialog('open').dialog('setTitle', '离校申请');
    $('#tripForm').form('clear');
}

function addSuccess(data) {
    $('#tripTable').datagrid('reload');
    $('#tripDlg').dialog('close');
    showSuccessToast("申请成功");
}

function saveTrip() {
    if ($('#reason').val().trim() === '') {
        showWaringToast('原因内容不能为空');
        return;
    }
    if($('#outdate').val()===''){
        showWaringToast('离校时间不能为空');
        return;
    }

    var url = base + '/trip/addTrip';
    doAjaxPost(url, $('#tripForm'), addSuccess);
}

$(function () {
    init();
});