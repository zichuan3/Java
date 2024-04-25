package DAO;

import pojo.Emp;
import util.DBUtil;

import java.util.List;

public class EmpDAO {

    public List<Emp> findEmpByDepid(String depid){
        String sql = "select empid , empname from emp where did = ?" ;
        List<Emp> list = DBUtil.query(sql , Emp.class , depid);
        return list ;
    }

}