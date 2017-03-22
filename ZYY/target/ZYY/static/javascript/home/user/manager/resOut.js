/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#resOutTable').datagrid(
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
                    title: '入库时间',
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
                        if(Number(row.resnum)>0){
                            var confirm = '<button class="easyui-linkbutton" onclick="outRes('+row.resnum+","+row.id+')">出库</button>'
                            return confirm
                        }
                    }
                },
            ]],
        });
}

function outRes(resnum,id) {
    $('#outnum').val("");
    $('#resForm').form('clear');
    $('#resDlg').dialog('open').dialog('setTitle', '出库');
    $('#outnum').attr({max:resnum,min:1});
    $('#id').val(id);
    $('#resnum').val(resnum);
}

function addSuccess(data) {
    $('#resOutTable').datagrid('reload');
    $('#resDlg').dialog('close');
    showSuccessToast("出库成功");
}

function saveRes() {
    var resnum = Number($('#resnum').val());
    var mynum = Number($('#outnum').val(""));
    if(mynum>resnum){
        showWaringToast("库存不足");
        return
    }
    var url = base + '/res/outRes';
    doAjaxPost(url, $('#resForm'), addSuccess);
}

$(function () {
    init();
});