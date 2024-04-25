<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2023/6/3
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <el-button type="primary" @click="openAddPanel">新增</el-button>
    <el-table
            :data="typeList"
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
        </el-table-column>
        <el-table-column
                label="操作"
                align="center"
        >
            <template slot-scope="scope">
                <el-button type="text" size="small" @click="openLeasePanel(scope.row)">租赁</el-button>
                <el-button type="text" size="small" @click="openEditPanel(scope.row)">编辑</el-button>
                <el-button type="text" size="small" @click="openDelPanel(scope.row.number)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
<%--    删除提示--%>
    <el-dialog
            title="删除提示"
            :visible.sync="delVisible"
            width="30%">
        <span>确定删除吗？</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="delVisible = false">取 消</el-button>
    <el-button type="primary" @click="delType">确 定</el-button>
  </span>
    </el-dialog>
<%--    删除提示--%>
<%--    创建提示--%>
    <el-dialog
            title="创建提示"
            :visible.sync="addVisible"
            width="30%">
<%--        内容部分--%>
    <el-form  :model="type"  label-width="100px" class="demo-ruleForm">
        <el-form-item prop="type" label="车辆品牌">
            <el-input v-model="type.brand"></el-input>
        </el-form-item>
        <el-form-item prop="type" label="车辆型号">
            <el-input v-model="type.model"></el-input>
        </el-form-item>
        <el-form-item prop="type" label="租赁价格">
            <el-input v-model="type.price"></el-input>
        </el-form-item>
        <el-form-item prop="type" label="车辆编号">
            <el-input v-model="type.number"></el-input>
        </el-form-item>
        <el-form-item prop="type" label="车牌号码">
            <el-input v-model="type.license_plate"></el-input>
        </el-form-item>
    </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="addVisible = false">取 消</el-button>
    <el-button type="primary" @click="addType">确 定</el-button>
  </span>
    </el-dialog>
    <%--    创建提示--%>
    <%--    编辑提示--%>
    <el-dialog
            title="编辑提示"
            :visible.sync="editVisible"
            width="30%">
        <%--        内容部分--%>
        <el-form  :model="type"  label-width="100px" class="demo-ruleForm">
            <el-form-item prop="type" label="车辆品牌">
                <el-input v-model="type.brand"></el-input>
            </el-form-item>
            <el-form-item prop="type" label="车辆型号">
                <el-input v-model="type.model"></el-input>
            </el-form-item>
            <el-form-item prop="type" label="租赁价格">
                <el-input v-model="type.price"></el-input>
            </el-form-item>
            <el-form-item prop="type" label="车辆编号">
                <el-input v-model="type.number"></el-input>
            </el-form-item>
            <el-form-item prop="type" label="车牌号码">
                <el-input v-model="type.license_plate"></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="editVisible = false">取 消</el-button>
    <el-button type="primary" @click="editType">确 定</el-button>
  </span>
    </el-dialog>
    <%--    编辑提示--%>
    <el-dialog
            title="租赁提示"
            :visible.sync="leaseVisible"
            width="30%">
        <span>确定租赁吗？</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="leaseVisible = false">取 消</el-button>
    <el-button type="primary" @click="leaseType">确 定</el-button>
  </span>
    </el-dialog>
</div>
<script>
    new Vue({
        el:"#main",
        data: {
            delVisible: false,
            addVisible: false,
            editVisible: false,
            leaseVisible: false,
            type: {
                brand: "",
                price: "",
                model: "",
                number: "",
                license_plate: ""
            },
            typeList: [],
            userList: []
        },
        methods:{
            selectAllType(){
                var that = this;
                axios.get("selectAllType").then(function (res) {
                    console.log(res)
                    that.typeList = res.data.list;
                })
            },
            selectAllStaff() {
              var that =this;
              axios.get("selectAllStaffServlet").then(function (res){
                  console.log(res)
                  that.typeList=res.data.list;
                })
            },
            openDelPanel(number){
                this.delVisible = true
                this.number = number
            },
            delType(){
                var that = this
                var number = that.number
                axios.get("delType?number="+number).then(function (res) {
                    if (res.data.status){
                        that.delVisible = false
                        that.selectAllType();
                    }else {
                        that.delVisible = false
                        that.$message.warning(res.data.message);
                    }
                })
            },
            openAddPanel(){
                this.addVisible = true
            },
            addType(){
                var that = this;
                var brand = that.type.brand;
                var model = that.type.model;
                var price = that.type.price;
                var number = that.type.number;
                var license_plate = that.type.license_plate;
                axios.get("addType?brand="+brand+"&model="+model+"&price="+price+"&number="+number+"&license_plate="+license_plate).then(function (res) {
                    if (res.data.status){
                        that.addVisible = false
                        that.selectAllStaff()
                    }else {
                        that.addVisible = false
                        that.$message.warning(res.data.message)
                    }
                })
            },
            openEditPanel(row){
                this.editVisible = true
                this.type = row
            },
            editType(){
                var that = this;
                var brand = that.type.brand;
                var model = that.type.model;
                var price = that.type.price;
                var number = that.type.number;
                var license_plate = that.type.license_plate;
                axios.get("editType?brand="+brand+"&model="+model+"&price="+price+"&number="+number+"&license_plate="+license_plate).then(function (res) {
                    if (res.data.status){
                        that.editVisible = false
                        that.selectAllType()
                    }else {
                        that.editVisible = false
                        that.$message.warning(res.data.message)
                    }
                })
            },
            openLeasePanel(row){
                this.leaseVisible=true
                this.type=row
            },
            leaseType(){
                var that = this;
                var brand = that.type.brand;
                var model = that.type.model;
                var price = that.type.price;
                var number = that.type.number;
                var license_plate = that.type.license_plate;
                axios.get("leaseType?brand="+brand+"&model="+model+"&price="+price+"&number="+number+"&license_plate="+license_plate).then(function (res) {
                    if (res.data.status){
                        that.leaseVisible = false
                        that.selectAllStaff()
                    }else {
                        that.leaseVisible = false
                        that.$message.warning(res.data.message)
                    }
                })
            }
        },
        mounted(){
            this.selectAllType()
            this.selectAllStaff()
        }
    })
</script>
</body>
</html>
