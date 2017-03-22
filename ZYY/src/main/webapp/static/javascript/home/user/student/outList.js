/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#outListTable').datagrid(
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
            url: 'outList',
            columns: [[
                {
                    field: 'reason',
                    title: '离校理由',
                    width: 550,
                    align: 'center',
                },
                {
                    field: 'outDate',
                    title: '离校时间',
                    width: 150,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        return dateFormat(value,'yyyy-MM-dd',true);
                    }
                },
                {
                    field: 'inDate',
                    title: '预计返校时间',
                    width: 150,
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
                    width: 150,
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
                {
                    field: 'action',
                    title: '操作',
                    width: 100,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(row.tripstate=='0'){
                            var confirm = '<button class="easyui-linkbutton" onclick="back('+row.id+')">我已返校</button>'
                            return confirm
                        }
                    }
                },
            ]],
            onBeforeEdit: function (index, row) {
                row.editing = true;
                $('#outListTable').datagrid('refreshRow', index);
            },
            onAfterEdit: function (index, row) {
                row.editing = false;
                $('#outListTable').datagrid('refreshRow', index);
            },
            onCancelEdit: function (index, row) {
                row.editing = false;
                $('#outListTable').datagrid('refreshRow', index);
            }
        });
}


function addSuccess(data) {
    $('#outListTable').datagrid('reload');
    showSuccessToast("操作成功");
}


function back(id) {
    var data = {"id" :id};
    var url= base + '/trip/addBack';
    doAjaxPostData(url, data, addSuccess);
}

$(function () {
    init();
});