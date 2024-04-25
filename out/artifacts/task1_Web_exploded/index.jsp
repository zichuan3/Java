<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2023/5/26
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <title>汽车租赁管理系统</title>
  <script src="js/Vue.js"></script>
  <script src="js/index.js"></script>
  <script src="js/axios.js"></script>
  <link rel="stylesheet" href="css/index.css">
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    html,body,#box,.el-container,.el-menu{
      height: 100%;
    }
    .el-header, .el-footer {
      background-color: #B3C0D1;
      color: #333;
      text-align: center;
      line-height: 60px;
    }

    .el-aside {
      background-color: #D3DCE6;
      color: #333;
      text-align: center;
      line-height: 200px;
    }

    .el-main {
      background-color: #E9EEF3;
      color: #333;
      text-align: center;
      line-height: 160px;
    }
  </style>
</head>
<body>
<div id="main">
  <el-container>
    <el-header>汽车管理系统</el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu  class="el-menu-vertical-demo">
          <el-menu-item index="1">
            <i class="el-icon-menu"></i>
            <a target="main" href="welcome.jsp">
            <span slot="title">欢迎页</span>
              </a>
          </el-menu-item>
          <el-menu-item index="2">
            <a target="main" href="staff.jsp">
            <i class="el-icon-document"></i>
            <span slot="title">当前租赁的车辆</span>
          </a>
          </el-menu-item>
          <el-menu-item index="3">
            <a href="type.jsp" target="main">
              <i class="el-icon-tableware"></i>
              <span slot="title">当前系统车辆管理</span>
            </a>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <iframe name="main" src="" width="100%" height="700px"></iframe>
      </el-main>
    </el-container>
  </el-container>
</div>
<script>
  const app = new Vue({
    el:"#main",
    data:{

    }
  })
</script>
</body>
</html>