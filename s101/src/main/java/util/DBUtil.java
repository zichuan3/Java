package util;

import pojo.Userinfo;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DBUtil {
    public static Vector<Connection> pool = new Vector<Connection>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 5; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s101", "root", "123456");
                pool.add(conn);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection conn = pool.get(0);
        pool.remove(0);
        return conn;
    }

    public static void release(Connection conn) {
        pool.add(conn);
    }

    public static int zsg(String sql, Object... p) {
        Connection conn = getConnection();
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (p != null) {
                for (int i = 0; i < p.length; i++) {
                    ps.setObject(i + 1, p[i]);
                }
            }
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(conn);
        }
        return n;
    }

    public static List query(String sql, Class c, Object... p) {
        List<Object> list = new ArrayList();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (p != null) {
                for (int i = 0; i < p.length; i++) {
                    ps.setObject(i + 1, p[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            while (rs.next()) {
                Object objs = c.newInstance();
                for (int i = 1; i <= count; i++) {
                    String filedName = rsmd.getColumnLabel(i);
                    Field field = c.getDeclaredField(filedName);
                    field.setAccessible(true);
                    field.set(objs, rs.getObject(i));
                }
                list.add(objs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(conn);
        }
        return list;
    }

    public static int uiniquecount(String sql, Object... p) {
        int count = 0;
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            release(conn);
        }
        return count;
    }

    public static void main(String[] args) {
        List<Userinfo> list = DBUtil.query("select username , password from userinfo", Userinfo.class);
        for (Userinfo userInfo : list) {
            System.out.println(userInfo);
        }
    }
}
