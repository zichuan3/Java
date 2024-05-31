package DAO;

import pojo.Goods;
import servelet.GoodsServlet;
import util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    public List<Goods> findAll() {
        String sql = "select goodsid ,goodsname,goodsdesc,goodscount,goodsprice,goodspic from goods";
        List<Goods> list = DBUtil.query(sql, Goods.class);
        return list;
    }

    public int getcount(String goodsname, String bottom, String top) {
        String sql = "select count(*) from goods where 1=1";
        List values = new ArrayList();
        if (goodsname != null && goodsname.trim().length() > 0) {
            sql = sql + " and goodsname like ? ";
            values.add("%" + goodsname + "%");
        }

        if (bottom != null && bottom.trim().length() > 0) {
            sql = sql + " and goodsprice >= ? ";
            values.add(bottom);
        }

        if (top != null && top.trim().length() > 0) {
            sql = sql + " and goodsprice <= ? ";
            values.add(top);
        }
        int count = DBUtil.uniquecount(sql, values.toArray());
        return count;
    }

    public Goods findbyid(String goodsid) {
        String sql = "select goodsid , goodsname , goodspic , goodsdesc , goodsprice ,goodscount from goods where goodsid = ? ";
        List<Goods> list = DBUtil.query(sql, Goods.class, goodsid);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public List<Goods> query(String goodsname, String bottom, String top, int page, int size) {
        String sql = "select goodsid,goodsname,goodsprice,goodspic,goodscount,goodsdesc from goods where 1=1";
        List values = new ArrayList();
        if (goodsname != null && goodsname.trim().length() > 0) {
            sql = sql + " and goodsname like ? ";
            values.add("%" + goodsname + "%");
        }

        if (bottom != null && bottom.trim().length() > 0) {
            sql = sql + " and goodsprice >= ? ";
            values.add(bottom);
        }

        if (top != null && top.trim().length() > 0) {
            sql = sql + " and goodsprice <= ? ";
            values.add(top);
        }

        sql = sql + " limit ? , ? ";
        values.add((page - 1) * size);
        values.add(size);
        System.out.println(sql+page+size);
        List<Goods> list = DBUtil.query(sql, Goods.class, values.toArray());
        return list;
    }
}
