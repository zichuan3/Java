package servelet;

import DAO.GoodsDAO;
import pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
    private GoodsDAO goodsDAO = new GoodsDAO();
    static int page = 1;
    static int size = 4;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if ("findall".equals(p)) {
            findall(request, response);
        } else if ("getpage".equals(p)) {
            getpage(request, response);
        }
    }

    private void getpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageString =request.getParameter("page");
        if (pageString!=null && pageString.trim().length()>0){
            page = Integer.parseInt(pageString);
            System.out.println("page!=null,page="+page);
        }
        String sizeString =request.getParameter("size");
        if (sizeString!= null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }
        if (page<1){
            System.out.println("page<1,当前页码为1");
            page=1;
        }
        int count = goodsDAO.getcount();
        int pagecount = count % size == 0? count/size:count/size+1;
        if (page>pagecount){
            System.out.println("page="+pagecount);
            page = pagecount;
        }
        List<Goods> list = goodsDAO.fenye(page, size);
        Map map = new HashMap();
        map.put("page",page);
        map.put("size",size);
        map.put("list",list);
        map.put("pagecount",pagecount);
        map.put("count",count);
        request.setAttribute("map",map);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    private void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = goodsDAO.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
