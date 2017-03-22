/**
 * Created by Administrator on 2017/3/13.
 */
function init() {
    $('#dormitoryTable').datagrid(
        {
            view: detailview,
            detailFormatter:function(index,row){
                return '<div class="ddv" data-index="'+index+'"></div>';
            },
            onExpandRow: function(index,row){
                var detailContent = '<table class="easyui-datagrid students" id="students'+index+'"></table><div id="studentToolbar'+index+'"> <a href="#" class="easyui-linkbutton" iconCls="icon-add" data-dormitoryid="'+row.id+'" onclick="addRoomMate(this)">入宿</a></div>';
                var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
                ddv.panel({
                    border:false,
                    cache:true,
                    content:detailContent,
                    onLoad:function(){
                        $('#dormitoryTable').datagrid('fixDetailRowHeight',index);
                        $('#dormitoryTable').datagrid('selectRow',index);
                    },
                });
                $('#students'+index).datagrid({
                    idField: 'id',
                    toolbar: '#studentToolbar'+index,
                    url: 'getListByDormitoryId?id='+row.id,
                    columns: [[
                        {
                            field: 'username',
                            title: '学生姓名',
                            width: 200,
                            align: 'center',
                        },
                        {
                            field: 'telephone',
                            title: '联系方式',
                            width: 200,
                            align: 'center',
                        },
                        {
                            field: 'bed',
                            title: '床位',
                            width: 200,
                            align: 'center',
                        },
                        {
                            field: 'action',
                            title: '操作',
                            width: 200,
                            align: 'center',
                            formatter:function (value,row,index) {
                                var out = '<button class="easyui-linkbutton" onclick="out(this,'+row.id+","+row.dormitoryid+')">退宿</button>'
                                var leader = '<button class="easyui-linkbutton" onclick="leader(this,'+row.id+","+row.dormitoryid+')">设为寝室长</button>'
                                return out+leader;
                            }
                        },
                    ]],
                    onLoadSuccess:function(data){
                        $('#dormitoryTable').datagrid('fixDetailRowHeight',index);
                    }
                })
            },
            title: 'Dormitory List',
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
                    field: 'doorplate',
                    title: '寝室门牌号',
                    width: 150,
                    align: 'center',
                    editor: 'numberbox',
                },
                {
                    field: 'heathlevel',
                    title: '卫生等级',
                    width: 150,
                    align: 'center',
                    editor: {
                        type:'combobox',
                        name:'heathlevel',
                        options:{
                            valueField:'value',
                            textField:'text',
                            data:[{
                                value:'1',
                                text:'1'
                            },{
                                value:'2',
                                text:'2'
                            },{
                                value:'3',
                                text:'3'
                            },{
                                value:'4',
                                text:'4'
                            },{
                                value:'5',
                                text:'5'
                            }],
                            required:true,
                            panelHeight:150
                        }
                    },
                },
                {
                    field: 'electricityfees',
                    title: '剩余电费',
                    width: 200,
                    align: 'center',
                    editor:'numberbox',
                },
                {
                    field: 'waterfees',
                    title: '当月应缴水费',
                    width: 200,
                    align: 'center',
                    editor: 'numberbox',
                },
                {
                    field: 'leadername',
                    title: '寝室长',
                    width: 200,
                    align: 'center',
                },
                {
                    field: 'action',
                    title: '操作',
                    width: 200,
                    align: 'center',
                    formatter : function(value, row, index) {
                        if (row.editing) {
                            var s = '<button href="#" class="easyui-linkbutton" onclick="saverow(this)">保存</button> ';
                            var c = '<button href="#" class="easyui-linkbutton" onclick="cancelrow(this)">取消</button>';
                            return s + c;
                        } else {
                            var e = '<button href="#" class="easyui-linkbutton" onclick="editrow(this)">修改</button> ';
                            var d = '<button href="#" class="easyui-linkbutton" onclick="deleterow(this)">删除</button>';
                            return e + d;
                        }
                    }
                },
            ]],
            onBeforeEdit: function (index, row) {
                row.editing = true;
                $('#dormitoryTable').datagrid('refreshRow', index);
            },
            onAfterEdit: function (index, row) {
                updateDormitory(row);
                row.editing = false;
                $('#dormitoryTable').datagrid('refreshRow', index);
            },
            onCancelEdit: function (index, row) {
                row.editing = false;
                $('#dormitoryTable').datagrid('refreshRow', index);
            }
        });
}

/**
 * 列表操作
 * @param target
 * @returns {Number}
 */
function getRowIndex(target) {
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}

function getRow(index) {
    var row = $('#dormitoryTable').datagrid('getData').rows[index];
    return row;
}
function editrow(target) {
    $('#dormitoryTable').datagrid('beginEdit', getRowIndex(target));
}
function deleterow(target) {
    $.messager.confirm('Confirm', 'Are you sure?', function(r) {
        if (r) {
            var rows = $('#dormitoryTable').datagrid('getRows');
            var row = rows[getRowIndex(target)];
            $.ajax({
                cache : true,
                type : "POST",
                url : 'IPServlet?method=delete',
                data : {
                    id : row.id
                },
                async : false,
                error : function(data) {
                    alert(data.message);
                },
                success : function(data) {
                    $('#tt').datagrid('deleteRow', getRowIndex(target));
                    $('#tt').datagrid('reload');
                }
            });
        }
    });
}

function saverow(target) {
    // updateDormitory(target);
    $('#dormitoryTable').datagrid('endEdit', getRowIndex(target));
    // updateDormitory(target);
}
function cancelrow(target) {
    $('#dormitoryTable').datagrid('cancelEdit', getRowIndex(target));
}


function doSearch() {
    var tripstate = $('#tripstate').combobox('getValue');
    $('#dormitoryTable').datagrid('load',{
        "tripstate":tripstate,
    });
}

/**
 * 新增寝室
 */
function addDormitory() {
    $('#dormitoryDlg').dialog('open').dialog('setTitle', '新增宿舍');
    $('#dormitoryForm').form('clear');
}

/**
 * 新增室友
 */
function addRoomMate(that) {
    $('#studentDlg').dialog('open').dialog('setTitle', '新增成员');
    $('#studentForm').form('clear');
    $('#dormitoryId').val($(that).attr('data-dormitoryid'));
    $('#roomMate').combobox({
        url:base + 'getWithOutDormitory',
        valueField:'usercode',
        textField:'username',
        onSelect:function (recoder) {
            $('#studentId').val(recoder.id);
            $('#studentName').val(recoder.username);
            $('#studentTelephone').val(recoder.telephone);
            $('#studentCode').val(recoder.usercode);
        }
    })
}

function saveDormitory() {
    var url = base + 'addDormitory'
    doAjaxPost(url,$('#dormitoryForm'),updateSuccess)
}

function updateSuccess(data) {
    $('#dormitoryDlg').dialog('close');
    $('#dormitoryTable').datagrid('reload');
    $('#students').datagrid('reload');
    showSuccessToast("操作成功");
}

/**
 * 更新宿舍信息
 * @param row
 */
function updateDormitory(row) {
    var url = base + 'updateDormitory'
    var data = {
        "id":row.id,
        "heathlevel":row.heathlevel,
        "electricityfees":row.electricityfees,
        "waterfees":row.waterfees,
        "doorplate":row.doorplate,
        "leadercode":row.leadercode
    }
    doAjaxPostData(url,data,updateSuccess);
}

/**
 * 退宿成功只刷新students
 * @param data
 */
function outsuccess(that){
    $('#studentDlg').dialog('close');
    var index = $(that).closest('.ddv').attr('data-index');
    // $('#dormitoryTable').datagrid('refreshRow', index);
    $('.students').datagrid('reload');
    showSuccessToast("操作成功");
}

/**
 * 退宿
 * @param id
 * @param dormitoryid
 */
function out(that,id,dormitoryid){//学生编号和寝室编号
    var data = {
        "id":id,
        "dormitoryid":dormitoryid,
    };
    var url = base + 'outDormitory'
    doAjaxPostData(url,data,outsuccess(that))
}

/**
 * 设置寝室长
 * @param id
 * @param dormitoryid
 */
function leader(that,id,dormitoryid){//学生编号和寝室编号
    var data = {
        "id":id,
        "dormitoryid":dormitoryid,
    };
    var url = base + 'leaderDormitory'
    doAjaxPostData(url,data,updateSuccess(that))
}

/**
 * 入宿
 */
function inDormitory() {
    var url = base + 'inDormitory'
    doAjaxPost(url,$('#studentForm'),outsuccess)
}

$(function () {
    init();
});


