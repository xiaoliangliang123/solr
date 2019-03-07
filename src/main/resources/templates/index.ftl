<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试首页</title>
</head>
<body style="text-align: center">
<div>
    <form action="/serch" target="frame">

        <input name="keyword" type="text" placeholder="请输入搜索词"> <input type="submit" value="搜索">
        <br>检索字段：<input type="checkbox" name="fileds" value="id">ID|<input type="checkbox" name="fileds" value="username"> 用户名|<input type="checkbox" name="fileds" value="password">密码
    </form>
</div>
<div>
    <iframe width="100%;" height="600px" name="frame" style="border: none"></iframe>
</div>
</body>
</html>