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
    public int getcount(){
        String sql = "select count(*) from goods";
        int count = DBUtil.uiniquecount(sql);
        return count;
    }
    public List<Goods> fenye(int page,int size){
        String sql = "select goodsid ,goodsname,goodsdesc,goodscount,goodsprice,goodspic from goods limit ?,?";
        List<Goods> list = DBUtil.query(sql,Goods.class,(page-1)*size,size);
        return list;
    }
    public Goods findbyid(String goodsid) {
        String sql = "select goodsid , goodsname , goodspic , goodsdesc , goodsprice ,goodscount from goods where goodsid = ? ";
        List<Goods> list = DBUtil.query(sql , Goods.class , goodsid );
        if(list.size()==0){
            return null;
        }
        return list.get(0);
    }

}
