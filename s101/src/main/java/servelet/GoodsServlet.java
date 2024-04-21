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
        } else if ("addCar".equals(p)) {
            addCar(request, response);
        } else if ("findbyid".equals(p)) {
            findbyid(request, response);
        }else if ("del".equals(p)||"add1".equals(p)||"minus".equals(p)){
            editbyid(request,response);
        }
    }

    private void editbyid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String controls = request.getParameter("p");
        String goodsid = request.getParameter("id");
        Map<Integer,Goods> map= (Map<Integer,Goods>) request.getSession().getAttribute("map");
        Goods goods = map.get(Integer.parseInt(goodsid));
        if ("del".equals(controls)){
            map.remove(Integer.parseInt(goodsid));
        }else if ("add1".equals(controls)){
            int prenum = goods.getGoodscount();
            goods.setGoodscount(prenum+1);
        }else if ("minus".equals(controls)){
            int prenum = goods.getGoodscount();
            if (prenum==1){
                map.remove(Integer.parseInt(goodsid));
            }else
                goods.setGoodscount(prenum-1);
        }
        request.getSession().setAttribute("map",map);
        response.sendRedirect("showCar.jsp");
    }

    private void findbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        Goods goods = goodsDAO.findbyid(goodsid);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("showDetail.jsp").forward(request, response);
    }

    private void addCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        String numString = request.getParameter("num");
        Map<Integer, Goods> map = (Map<Integer, Goods>) request.getSession().getAttribute("map");
        if (map == null) {
            map = new HashMap<Integer, Goods>();
            System.out.println("添加购物车");
        }
        Goods goods = goodsDAO.findbyid(goodsid);//新加入购物车的商品根据goodsid找到对应的商品
        Goods goods1 = map.get(Integer.parseInt(goodsid));//根据goodsid键取出之前存在的商品对象
        if (goods1==null){
            System.out.println("当前商品id为："+goodsid);
            goods.setGoodscount(Integer.parseInt(numString));
            map.put(Integer.parseInt(goodsid),goods);
        }else if (Integer.parseInt(goodsid) == goods1.getGoodsid()){
            System.out.println("两次商品一样，进行叠加");
            Integer num = goods1.getGoodscount();//取出之前有的商品数量
            System.out.println("之前商品数量为：："+num);
            System.out.println("新增商品数量为："+numString);
            goods1.setGoodscount(num + Integer.parseInt(numString));
            System.out.println("当前商品数量为：："+goods1.getGoodscount());
            map.put(Integer.parseInt(goodsid), goods1);
        }else
            System.out.println("其他:::");
        request.getSession().setAttribute("map", map);
        // 避免数据的重复提交
        response.sendRedirect("showCar.jsp");
    }

    private void getpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageString = request.getParameter("page");
        if (pageString != null && pageString.trim().length() > 0) {
            page = Integer.parseInt(pageString);
//            System.out.println("page!=null,page="+page);
        }
        String sizeString = request.getParameter("size");
        if (sizeString != null && sizeString.trim().length() > 0) {
            size = Integer.parseInt(sizeString);
        }
        if (page < 1) {
//            System.out.println("page<1,当前页码为1");
            page = 1;
        }
        int count = goodsDAO.getcount();
        int pagecount = count % size == 0 ? count / size : count / size + 1;
        if (page > pagecount) {
//            System.out.println("page="+pagecount);
            page = pagecount;
        }
        List<Goods> list = goodsDAO.fenye(page, size);
        Map map = new HashMap();
        map.put("page", page);
        map.put("size", size);
        map.put("list", list);
        map.put("pagecount", pagecount);
        map.put("count", count);
        request.setAttribute("map", map);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    private void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = goodsDAO.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
