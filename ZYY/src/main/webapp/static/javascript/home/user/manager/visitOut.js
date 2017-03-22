/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#visitInTable').datagrid(
        {
            title: 'visit List',
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
                    field: 'visitorname',
                    title: '访客姓名',
                    width: 150,
                    align: 'center',
                },
                {
                    field: 'visitortelephone',
                    title: '联系方式',
                    width: 200,
                    align: 'center',
                },
                {
                    field: 'visitobject',
                    title: '访问对象',
                    width: 300,
                    align: 'center',
                },
                {
                    field: 'inDate',
                    title: '来访时间',
                    width: 150,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value!==null&&value!==''){
                            return dateFormat(value,'yyyy-MM-dd hh:mm',true);
                        }
                    }
                },
                {
                    field: 'outDate',
                    title: '离开时间',
                    width: 150,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value!==null&&value!==''){
                            return dateFormat(value,'yyyy-MM-dd hh:mm',true);
                        }
                    }
                },
                {
                    field: 'visitstate',
                    title: '当前状态',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        var confirm = '<button class="easyui-linkbutton" onclick="outVisit('+row.id+')">离开</button>'
                        return confirm
                    }
                },
            ]],
        });
}



function addSuccess(data) {
    $('#visitInTable').datagrid('reload');
    $('#visitDlg').dialog('close');
    showSuccessToast("操作成功");
}

function outVisit(id) {
    var data = {"id":id};
    var url= base + '/visit/visitOut';
    doAjaxPostData(url, data, addSuccess);
}

$(function () {
    init();
});