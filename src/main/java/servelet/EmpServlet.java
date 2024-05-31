package servelet;
import DAO.EmpDAO;
import pojo.Emp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/emp.do")
public class EmpServlet extends HttpServlet {
    private EmpDAO empDAO = new EmpDAO();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("p");
        if("findEmpByDepid".equals(p)){
            doFindEmpByDepid(request , response);
        }
    }
    private void doFindEmpByDepid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String depid = request.getParameter("depid");
        List<Emp> list = empDAO.findEmpByDepid(depid);
        if(list.size()==0){
            response.getWriter().println("[]");
            return;
        }
        StringBuffer sb = new StringBuffer("[");
        for (Emp emp : list) {
            sb.append("{\"empid\":\"").append(emp.getEmpid()).append("\",\"empname\":\"").append(emp.getEmpname()).append("\"},");
        }
        String json = sb.replace(sb.length()-1 , sb.length() , "]").toString();
        response.getWriter().println(json);
    }
}
