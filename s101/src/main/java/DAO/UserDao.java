package DAO;
import pojo.Userinfo;
import util.DBUtil;
import java.util.List;

public class UserDao {
    public List<Userinfo> findAll() {
        String sql = "select username , password from userinfo";
        List<Userinfo> list = DBUtil.query(sql, Userinfo.class);
        return list;
    }
    public int delByUsername(String username) {
        String sql = "delete from userinfo where username = ? ";
        int n = DBUtil.zsg(sql, username);
        return n;
    }
    public Userinfo login(String username, String password){
        String sql = "select username,password from userinfo where username=? and password=?";
        List<Userinfo> list = DBUtil.query(sql, Userinfo.class, username, password);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }
    public int register(String username,String password){
        String sql = "insert into userinfo(username,password) values(?,?)";
        int n = DBUtil.zsg(sql, username, password);
        return n;
    }
    public int collection_goods(String username,int goodsid){
        String sql = "insert into user_collection(username,goodsid) values(?,?)";
        int n = DBUtil.zsg(sql, username, goodsid);
        return n;
    }
}
