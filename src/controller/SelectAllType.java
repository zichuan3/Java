package controller;
import bean.Type;
import com.alibaba.fastjson.JSON;
import service.TypeService;
import utils.ResultMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/selectAllType")
public class SelectAllType extends HttpServlet {
    TypeService typeService = new TypeService();
    ResultMap<Type> resultMap =  new ResultMap<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Type> list = typeService.selectAllType();
            resultMap.setStatus(true);
            resultMap.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
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
