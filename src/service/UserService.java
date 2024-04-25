package service;
import bean.User;
import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
public class UserService {
    UserDao userDao = new UserDao();
    public List<User> selectAllStaff() throws SQLException {
        return userDao.selectAllStaff();
    }
    public User login(String username,String password) throws SQLException{
        return userDao.login(username,password);
    }
    public void leaseType(String brand, String model,int price,int number,String license_plate){
        int num = userDao.leaseType(brand,model,price,number,license_plate);
        if (num == 0){
            System.out.println("租赁失败");
        }
    }
    public void disType(int number) {
        int num = userDao.disType(number);
        if (num == 0){
            System.out.println("删除失败");
        }
    }
}