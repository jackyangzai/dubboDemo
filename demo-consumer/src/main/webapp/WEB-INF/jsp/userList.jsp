<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息列表</title>
    <script src="../../scripts/jquery-1.4.3.js" type="text/javascript"></script>
    <link href="../../scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />
    <script src="../../scripts/miniui/miniui.js" type="text/javascript"></script>
    <script src="../../scripts/boot.js" type="text/javascript"></script>
</head>
<body>
<h1>用户管理</h1>
<div style="width:1000px;">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="addRow()" plain="true">增加</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>
                    <span class="separator"></span>
                    <a class="mini-button" iconCls="icon-save" onclick="saveData()" plain="true">保存</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="key" class="mini-textbox" emptyText="请输入员工账号" style="width:150px;" onenter="onKeyEnter"/>
                    <a class="mini-button" onclick="search()">查询</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:1000px;height:280px;"  allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     editNextOnEnterKey="true"  url = "/getUserData.do" pageSize="20">
    <div property="columns">
        <div type="checkcolumn"></div>
        <div field="ID" allowResize="true" width="120" headerAlign="center" allowSort="true">ID
            <input property="editor" class="mini-textbox" style="width:100%;" />
        </div>
        <div field="LOGINNAME" allowResize="false" width="120" headerAlign="center" allowSort="true">员工帐号
            <input property="editor" class="mini-textbox" style="width:100%;" />
        </div>
        <div field="USERNAME" width="100" allowSort="true" headerAlign="center">登录名
            <input property="editor" class="mini-textbox"  style="width:100%;"/>
        </div>
        <div field="PASSWORD" width="120" headerAlign="center">密码
            <input property="editor" class="mini-textbox" style="width:100%;" minHeight="50"/>
        </div>
        <div type="comboboxcolumn"  field="ROLE" width="100"  align="center" headerAlign="center">角色
            <input property="editor" class="mini-combobox" style="width:100%;" data="Roles" />
        </div>
        <div type="comboboxcolumn" field="STATUS" width="100" headerAlign="center" >状态
            <input property="editor" class="mini-combobox" style="width:100%;" data="Status" />
        </div>

    </div>
</div>
<script type="text/javascript">
    var Roles = [{ id: 1, text: '管理员' }, { id: 2, text: '药库人员'}];
    var Status = [{ id:'Y',text:'启用'},{id:'N',text:'停用'}];
    mini.parse();
    var grid = mini.get("datagrid1");
    grid.load();
    //查询方法
    function search() {
        var key = mini.get("key").getValue();
        grid.load({ key: key });
    }
    //新增
    function addRow() {
        var newRow = { name: "New Row" };
        grid.addRow(newRow, 0);
    }
    function removeRow() {
        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            grid.removeRows(rows, true);
        }
    }
    function saveData() {
        var data = grid.getChanges();
        var json = mini.encode(data);
        grid.loading("保存中，请稍后......");
        $.ajax({
            url: "/emp/saveData.do",
            data: { data: json },
            type: "post",
            success: function (text) {
                grid.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

</script>
</body>
</html>
