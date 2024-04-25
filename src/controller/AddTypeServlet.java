package controller;
import com.alibaba.fastjson.JSON;
import service.TypeService;
import utils.ResultMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addType")
public class AddTypeServlet  extends HttpServlet {
    TypeService typeService = new TypeService();
    ResultMap resultMap = new ResultMap();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String brand = req.getParameter("brand");
            String model = req.getParameter("model");
            int price = Integer.parseInt(req.getParameter("price"));
            int number = Integer.parseInt(req.getParameter("number"));
            String license_plate = req.getParameter("license_plate");
            typeService.addType(brand,model,price,number,license_plate);
            resultMap.setStatus(true);
        }catch (Exception e){
            resultMap.setStatus(false);
            resultMap.setMessage(e.getMessage());
        }
        String json = JSON.toJSONString(resultMap);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
