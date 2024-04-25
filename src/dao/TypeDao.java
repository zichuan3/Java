package dao;
import bean.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TypeDao {
    public List<Type> selectAllType() throws SQLException {
        String sql = "select * from cars";
        Object[] obj = {};
        List<Type> list;
        try (ResultSet rs = JdbcBase.querySql(sql, obj)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Type type = new Type();
                type.setBrand(rs.getString("brand"));
                type.setModel(rs.getString("model"));
                type.setPrice(rs.getInt("price"));
                type.setNumber(rs.getInt("number"));
                type.setLicense_plate(rs.getString("license_plate"));
                list.add(type);
            }
        }
        return list;
    }
    public int delType(int number){
        String sql = "delete from cars where number = ?";
        Object[] obj = {number};
        return JdbcBase.updateSql(sql,obj);
    }
    public int addType(String brand, String model,int price,int number,String license_plate){
        String sql = "insert into cars values (?,?,?,?,?)";
        Object[] obj = {brand,model,price,number,license_plate};
        return JdbcBase.updateSql(sql,obj);
    }
    public int editType(String brand, String model,int price,int number,String license_plate){
        String sql = "update cars set brand=?,model=?,price=?,number=?,license_plate=? where number=?";
        Object[] obj = {brand,model,price,number,license_plate,number};
        return JdbcBase.updateSql(sql,obj);
    }
}
