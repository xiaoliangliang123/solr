<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="text-align: center">
<div>
    查询结果总数:${count}
</div>
<#if smlist??>
<#list smlist as sm>
<div>
    id:${sm.id}|
    username:${sm.username}|
    password:${sm.password}
</div>
<hr>
</#list>
</#if>
</body>
</html>