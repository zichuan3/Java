package com.test;
import DAO.DepDAO;
import pojo.Dep;
import java.util.List;

public class JavaToJson {
    public static void main(String[] args) {
        DepDAO depDAO = new DepDAO();
        List<Dep> list = depDAO.findall();
        StringBuffer sb = new StringBuffer("[");
        // '[{"depid":"1" , "depname":"小卖部"},{"depid":"2" , "depname":"宣传部"}]'
        for(Dep dep : list) {
            sb.append("{\"depid\":\"").append(dep.getDepid()).append("\",\"depname\":\"").append(dep.getDepname()).append("\"},");
        }
        String json = sb.replace(sb.length()-1 , sb.length() , "]").toString();
    }
}
