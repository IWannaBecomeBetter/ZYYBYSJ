/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#resInTable').datagrid(
        {
            title: 'Res List',
            iconCls: 'icon-edit',
            pagination: true, //显示分页
            pageSize: 10, //页大小
            pageList: [10, 20, 30, 40], //页大小下拉选项此项各value是pageSize的倍数
            fit: true, //datagrid自适应宽度
            fitColumn: true, //列自适应宽度
            singleSelect: true,
            idField: 'id',
            url: 'inList',
            toolbar: '#toolbar',
            columns: [[
                {
                    field: 'resname',
                    title: '物品名称',
                    width: 500,
                    align: 'center',
                },
                {
                    field: 'resnum',
                    title: '物品数量',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                },
                {
                    field: 'updatedate',
                    title: '最近操作时间',
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
                    field: 'resstate',
                    title: '状态',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(value=='1'){
                            return '入库'
                        }else if(value=='0'){
                            return '出库'
                        }
                    }
                },
            ]],
        });
}

function inRes() {
    $('#resDlg').dialog('open').dialog('setTitle', '入库');
    $('#resForm').form('clear');
}

function addSuccess(data) {
    $('#resInTable').datagrid('reload');
    $('#resDlg').dialog('close');
    showSuccessToast("入库成功");
}

function saveRes() {
    if ($('#resname').val().trim() === '') {
        showWaringToast('物品名称不能为空');
        return;
    }
    if($('#resnum').val()===''){
        showWaringToast('请选择正确的物品数量');
        return;
    }

    var url = base + '/res/addRes';
    doAjaxPost(url, $('#resForm'), addSuccess);
}

$(function () {
    init();
});