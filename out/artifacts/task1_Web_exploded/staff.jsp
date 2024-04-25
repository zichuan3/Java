<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2023/6/3
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="js/Vue.js"></script>
    <script src="js/index.js"></script>
    <script src="js/axios.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <style>

    </style>
</head>
<body>
<div id="main">
    <el-table
            :data="staffList"
            align="center"
            style="width: 100%">
        <el-table-column
                prop="brand"
                label="车辆品牌"
                align="center"
        >
        </el-table-column>
        <el-table-column
                prop="model"
                label="车辆型号"
                align="center"
        >
        </el-table-column>
        <el-table-column
                prop="price"
                label="租赁价格"
                align="center"
        >
        </el-table-column>
        <el-table-column
                prop="number"
                label="车辆编号"
                align="center"
        >
        </el-table-column>
        <el-table-column
                prop="license_plate"
                label="车牌号码"
                align="center"
        >
            <template slot-scope="scope">
            <el-button type="text" size="small" @click="openDisPanel(scope.row.number)">取消租赁</el-button>
        </template>
        </el-table-column>
    </el-table>
    <el-dialog
            title="取消租赁提示"
            :visible.sync="disVisible"
            width="30%">
        <span>确定取消吗？</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="disVisible = false">返回</el-button>
    <el-button type="primary" @click="disType">确 定</el-button>
  </span>
    </el-dialog>
</div>
<script>
    new Vue({
        el:"#main",
        data:{
            disVisible:false,
            num:"",
            staffList:[]
        },
        methods:{
            selectAllStaff(){
                var that = this;
                axios.get("selectAllStaffServlet").then(function (res) {
                    console.log(res)
                    that.staffList = res.data.list;
                })
            },
            openDisPanel(number){
                this.disVisible = true
                this.number = number
            },
            disType(){
                var that = this
                var number = that.number
                axios.get("disType?number="+number).then(function (res) {
                    if (res.data.status){
                        that.disVisible = false
                        that.selectAllStaff();
                    }else {
                        that.disVisible = false
                        that.$message.warning(res.data.message);
                    }
                })
            },
        },
        mounted(){
            this.selectAllStaff()
        }
    })
</script>
</body>
</html>
