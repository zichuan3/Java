package dao;
import bean.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
    public User login(String username,String password) throws SQLException{
        String sql="select * from t1 where username=? and password=? ";
        Object[] obj={username,password};
        User user;
        try (ResultSet rs = JdbcBase.querySql(sql, obj)) {
            user = null;
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }
        return user;
    }
    public List<User> selectAllStaff() throws SQLException {
        String sql = "select * from cars1";
        Object[] obj = {};
        List<User> list;
        try (ResultSet rs = JdbcBase.querySql(sql, obj)) {
            list = new ArrayList<>();
            User user ;
            while (rs.next()) {
                user = new User();
                user.setBrand(rs.getString("brand"));
                user.setModel(rs.getString("model"));
                user.setPrice(rs.getInt("price"));
                user.setNumber(rs.getInt("number"));
                user.setLicense_plate(rs.getString("license_plate"));
                list.add(user);
            }
        }
        return list;
    }
    public int leaseType(String brand, String model,int price,int number,String license_plate) {
        String sql = "insert into cars1 values(?,?,?,?,?)";
        Object[] obj = {brand,model,price,number,license_plate};
        return JdbcBase.updateSql(sql,obj);
    }
    public int disType(int number) {
        String sql = "delete from cars1 where number = ?";
        Object[] obj = {number};
        return JdbcBase.updateSql(sql,obj);
    }
}
