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
        } else if ("addCar".equals(p)){
            addCar(request,response);
        }else if ("findbyid".equals(p)){
            findbyid(request,response);
        }
    }

    private void findbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        Goods goods = goodsDAO.findbyid(goodsid);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("showDetail.jsp").forward(request, response);
    }

    private void addCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        String numString =request.getParameter("num");
        Map<Goods,Integer> map = (Map<Goods, Integer>) request.getSession().getAttribute("map");
        if (map==null){
            map = new HashMap<Goods,Integer>();
            System.out.println("添加购物车");
        }
        Goods goods = goodsDAO.findbyid(goodsid);
        System.out.println("当前的goods值为"+goods);
        System.out.println("当前商品id为"+goods.getGoodsid());
        Integer num = map.get(goods.getGoodsid());//根据键取值
        if (num == null) {
            System.out.println("新增商品");
            map.put(goods, Integer.parseInt(numString));
        } else {
            System.out.println(num+"是目前的商品数量");
            System.out.println("商品数量+1");
            map.put(goods, num + Integer.parseInt(numString));
        }
        request.getSession().setAttribute("map" , map);
        // 避免数据的重复提交
        response.sendRedirect("showCar.jsp");
    }

    private void getpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageString =request.getParameter("page");
        if (pageString!=null && pageString.trim().length()>0){
            page = Integer.parseInt(pageString);
//            System.out.println("page!=null,page="+page);
        }
        String sizeString =request.getParameter("size");
        if (sizeString!= null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }
        if (page<1){
//            System.out.println("page<1,当前页码为1");
            page=1;
        }
        int count = goodsDAO.getcount();
        int pagecount = count % size == 0? count/size:count/size+1;
        if (page>pagecount){
//            System.out.println("page="+pagecount);
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
