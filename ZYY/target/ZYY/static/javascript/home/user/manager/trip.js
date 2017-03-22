/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#allTripTable').datagrid(
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
                        $('#allTripTable').datagrid('fixDetailRowHeight',index);
                        $('#allTripTable').datagrid('selectRow',index);
                    },
                    content:row.reason
                });
                $('#dg').datagrid('fixDetailRowHeight',index);
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
            url: 'list',
            toolbar: '#toolbar',
            columns: [[
                {
                    field: 'username',
                    title: '学生姓名',
                    width: 200,
                    align: 'center',
                },
                {
                    field: 'telephone',
                    title: '学生联系方式',
                    width: 200,
                    align: 'center',
                },
                {
                    field: 'outDate',
                    title: '离校时间',
                    width: 200,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        return dateFormat(value,'yyyy-MM-dd hh:mm',true);
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
                {
                    field: 'action',
                    title: '操作',
                    width: 100,
                    align: 'center',
                    editor: 'text',
                    formatter:function (value,row,index) {
                        if(row.tripstate=='0'){
                            var confirm = '<button class="easyui-linkbutton" onclick="back('+row.id+')">已返校</button>'
                            return confirm
                        }
                    }
                },
            ]],
        });
}

function doSearch() {
    var tripstate = $('#tripstate').combobox('getValue');
    // var inDate = dateFormat($('#inDate').datebox('getValue'),'yyyy-MM-dd',true);
    // var outDate = dateFormat($('#outDate').datebox('getValue'),'yyyy-MM-dd',true);
    $('#allTripTable').datagrid('load',{
        "tripstate":tripstate,
        // "in_date":inDate,
        // "out_date":outDate,
    });
}

function addSuccess(data) {
    $('#allTripTable').datagrid('reload');
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