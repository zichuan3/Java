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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserService();
    ResultMap resultMap=new ResultMap();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try{
            User user=userService.login(username,password);
            if(user==null){
                resultMap.setStatus(false);
                resultMap.setMessage("账户或密码错误");
            }else{
                resultMap.setStatus(true);
                resultMap.setMessage("账户和密码正确");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String json= JSON.toJSONString(resultMap);
        resp.setContentType("text/html;character=utf-8");
        resp.getWriter().println(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}