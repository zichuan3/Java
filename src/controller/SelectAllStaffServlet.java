package controller;
import bean.User;
import com.alibaba.fastjson.JSON;
import service.UserService;
import utils.ResultMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/selectAllStaffServlet")
public class SelectAllStaffServlet extends HttpServlet {
    UserService userService = new UserService();
    ResultMap<User> resultMap = new ResultMap<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> list = userService.selectAllStaff();
            resultMap.setList(list);
            resultMap.setStatus(true);
        } catch (SQLException e) {
            e.printStackTrace();
            resultMap.setStatus(false);
            resultMap.setMessage("没有查询到数据");
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
