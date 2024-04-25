package service;
import bean.Type;
import dao.TypeDao;
import java.sql.SQLException;
import java.util.List;
public class TypeService {
    TypeDao typeDao = new TypeDao();
    public List<Type> selectAllType() throws SQLException {
        return typeDao.selectAllType();
    }
    public void delType(int number){
        int num = typeDao.delType(number);
        if (num == 0){
            System.out.println("删除失败");
        }
    }
    public void addType(String brand, String model,int price,int number,String license_plate){
        int num = typeDao.addType(brand,model,price,number,license_plate);
        if (num == 0){
            System.out.println("创建失败");
        }
    }
    public void editType(String brand, String model,int price,int number,String license_plate){
        int num = typeDao.editType(brand,model,price,number,license_plate);
        if (num == 0){
            System.out.println("编辑失败");
        }
    }
}
