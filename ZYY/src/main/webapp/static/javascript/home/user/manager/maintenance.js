/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#maintenanceTable').datagrid(
        {
            view: detailview,
            detailFormatter:function(index,row){
                return '<div class="ddv"></div>';
            },
            onExpandRow: function(index,row){
                var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
                ddv.panel({
                    border:false,
                    cache:true,
                    onLoad:function(){
                        $('#maintenanceTable').datagrid('fixDetailRowHeight',index);
                        $('#maintenanceTable').datagrid('selectRow',index);
                    },
                    content:row.description
                });
                $('#maintenanceTable').datagrid('fixDetailRowHeight',index);
            },
            title: 'Trip List',
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
                    field: 'doorplate',
                    title: '寝室门牌号',
                    width: 100,
                    align: 'center',
                },
                {
                    field: 'username',
                    title: '学生姓名',
                    width: 150,
                    align: 'center',
                },
                {
                    field: 'telephone',
                    title: '联系方式',
                    width: 200,
                    align: 'center',
                },
                {
                    field: 'startdate',
                    title: '申报时间',
                    width: 150,
                    align: 'center',
                    formatter:function (value,row,index) {
                        return dateFormat(value,'yyyy-MM-dd hh:mm',true);
                    }
                },
                {
                    field: 'enddate',
                    title: '结束时间',
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
                    field: 'repairstate',
                    title: '当前状态',
                    width: 150,
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
                {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(row.repairstate=='0'){
                            var confirm = '<button class="easyui-linkbutton" onclick="repair('+row.id+')">维修已完成</button>'
                            return confirm
                        }
                    }
                },
            ]],
        });
}

function doSearch() {
    var repairstate = $('#repairstate').combobox('getValue');
    $('#maintenanceTable').datagrid('load',{
        "repairstate":repairstate
    });
}

function addSuccess(data) {
    $('#maintenanceTable').datagrid('reload');
    showSuccessToast("操作成功");
}

function repair(id) {
    var data = {"id" :id};
    var url= base + '/maintenance/finishRepair';
    doAjaxPostData(url, data, addSuccess);
}

$(function () {
    init();
});