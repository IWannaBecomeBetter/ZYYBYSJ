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
            url: 'list',
            toolbar: '#toolbar',
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
                    width: 180,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value=='1'){
                            return '访问中'
                        }else if(value=='0'){
                            return '已离开'
                        }
                    }
                },
            ]],
        });
}


function addVist() {
    $('#visitDlg').dialog('open').dialog('setTitle', '访客登记');
    $('#visitForm').form('clear');
}

function doSearch() {
    var visitstate = $('#visitstate').combobox('getValue');
    // var inDate = dateFormat($('#inDate').datebox('getValue'),'yyyy-MM-dd',true);
    // var outDate = dateFormat($('#outDate').datebox('getValue'),'yyyy-MM-dd',true);
    $('#visitInTable').datagrid('load',{
        "visitstate":visitstate,
        // "in_date":inDate,
        // "out_date":outDate,
    });
}

function addSuccess(data) {
    $('#visitInTable').datagrid('reload');
    $('#visitDlg').dialog('close');
    showSuccessToast("操作成功");
}

function saveVisit() {
    var url= base + '/visit/addVisit';
    doAjaxPost(url, $('#visitDlgForm'), addSuccess);
}

$(function () {
    init();
});