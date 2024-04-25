<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登陆页面</title>
    <script src="js/Vue.js"></script>
    <script src="js/index.js"></script>
    <script src="js/axios.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <style>
        .el-form{
            width: 400px;
            height: 200px;
        }
        body{
            height: 700px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div id="box">
    <el-form ref="form" :rules="rules" :model="user" label-width="80px">
        <el-form-item prop="username" label="账号">
            <el-input v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码">
            <el-input v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="login">登陆</el-button>
            <el-button type="primary">取消</el-button>
            <el-button type="primary" @click="openRegisterPanel">注册</el-button>
        </el-form-item>
    </el-form>
    <el-dialog
            title="注册提示"
            :visible.sync="registerVisible"
            width="30%">
        <%--        内容部分--%>
        <el-form  :model="type"  label-width="100px" class="demo-ruleForm">
            <el-form-item prop="type" label="用户名">
                <el-input v-model="user.username"></el-input>
            </el-form-item>
            <el-form-item prop="type" label="密码">
                <el-input v-model="user.password"></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="registerVisible = false">取 消</el-button>
    <el-button type="primary" @click="register">确 定</el-button>
  </span>
    </el-dialog>
</div>
<script>
    const app = new Vue({
        el:"#box",
        data:{
            registerVisible:false,
            user:{
                username:'',
                password:''
            },
            rules:{
                username:[
                    {required:true,message:"请输入账号",trigger:'blur'},
                    {min:3,max:8,message:"长度在3到8个字符之间",trigger:'blur'}
                ],
                password:[
                    {required:true,message:"请输入密码",trigger:'blur'},
                    {min:3,max:8,message:"长度在3到8个字符之间",trigger:'blur'}
                ]
            }
        },
        methods:{
            login(){
                this.$refs.form.validate((isSuccess) =>{
                    if(isSuccess){
                        var username = this.user.username
                        var password = this.user.password
                        var that = this
                        axios.get("login?username="+username+"&password="+password).then(function(res){
                            console.log(res)
                            if (res.data.status){
                                location.href = "index.jsp"
                            }else {
                                that.$message(res.data.message)
                            }
                        })
                    }else{
                        this.$message("账号或密码输入格式不正确")
                    }
                })
            },
            openRegisterPanel(){
                this.registerVisible = true
            },
            register(){
                this.$refs.form.validate((isSuccess) =>{
                    if(isSuccess){
                        var username = this.user.username
                        var password = this.user.password
                        var that = this
                        axios.get("register?username="+username+"&password="+password).then(function(res){
                            console.log(res)
                            if (res.data.status){
                                that.$message("注册成功,已登录")
                                location.href = "index.jsp"
                            }else {
                                that.$message(res.data.message)
                            }
                        })
                    }else{
                        this.$message("账号或密码输入格式不正确")
                    }
                })
            }
        }
    })
</script>
</body>
</html>