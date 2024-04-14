package servelet;
import DAO.GoodsDAO;
import pojo.Goods;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
    private GoodsDAO goodsDAO = new GoodsDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if ("findall".equals(p)){
            findall(request, response);
        }
    }

    private void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Goods> list = goodsDAO.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
