$(function () {
    $("#dataTable").bootstrapTable({
        url: '/roles',
        column:[
            {field: 'id', title: 'id'},
            {field: 'role', title: '角色'},
            {field: 'roleName', title: '角色名'},
            {field: 'roleNote', title: '备注'},
            {field: 'orderNum', title: '顺序'},
        ]
    });
});