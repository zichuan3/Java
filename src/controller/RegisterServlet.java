package controller;
import com.alibaba.fastjson.JSON;
import dao.JdbcBase;
import utils.ResultMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    ResultMap resultMap=new ResultMap();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sql = "insert into t1(id,username,password) values(2,?,?)";
        Object[] obj = {username,password};
        int num = JdbcBase.updateSql(sql,obj);
        if(num==1){
            resultMap.setStatus(true);
            resultMap.setMessage("注册成功");
        }else{
            resultMap.setStatus(false);
            resultMap.setMessage("该用户已存在，请重新注册");
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