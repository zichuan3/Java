package DAO;

import pojo.Goods;
import util.DBUtil;

import java.util.List;

public class GoodsDAO {
    public List<Goods> findAll(){
        String sql = "select goodsid ,goodsname,goodsdesc,goodscount,goodsprice,goodspic from goods";
        List<Goods> list = DBUtil.query(sql,Goods.class);
        return list;
    }
}
