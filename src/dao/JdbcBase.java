package dao;
import java.sql.*;
public class JdbcBase {
    static Connection conn;
    static ResultSet rs;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?userSSL=true&userUnicode=true&characterEncoding=utf-8","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static ResultSet querySql(String sql,Object[] obj){
        conn = getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (obj != null){
                for (int i=0;i<obj.length;i++){
                    pstm.setObject(i+1,obj[i]);
                }
            }
            rs =  pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int updateSql(String sql,Object[] obj){
        int num = 0;
        conn = getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (obj != null){
                for (int i=0;i<obj.length;i++){
                    pstm.setObject(i+1,obj[i]);
                }
            }
            num = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
