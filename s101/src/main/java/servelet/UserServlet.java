package servelet;
import DAO.UserDao;
import pojo.Userinfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("p");
        if ("findall".equals(method)) {
            doFindAll(request, response);
        } else if ("delbyusername".equals(method)) {
            doDelByUsername(request, response);
        }else if ("login".equals(method)){
            doLogin(request,response);
        }else if ("register".equals(method)){
            doRegister(request,response);
        }
    }


    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userDao.register(username,password);
        response.sendRedirect("index.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Userinfo userinfo = userDao.login(username, password);
        if (userinfo == null){
            response.sendRedirect("login.jsp");
        }else {
            request.getSession().setAttribute("userinfo",userinfo);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }

    }

    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Userinfo> list = userDao.findAll();
        request.setAttribute("list", list);// 存
        //跳转到show.jsp
        request.getRequestDispatcher("show.jsp").forward(request, response);

    }

    private void doDelByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int n = userDao.delByUsername(username);// 删除成功
        doFindAll(request, response);
    }
}
