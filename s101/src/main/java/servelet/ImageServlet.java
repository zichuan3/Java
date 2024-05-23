package servelet;

import javax.imageio.ImageIO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet("/image.do")
public class ImageServlet extends HttpServlet {
    static String code;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("x")!=null)
            doProduce(request,response);
        else
            doVerify(request,response);
    }
    private void doProduce(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();
        String s = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(26);
            char ch = s.charAt(index);
            sb.append(ch);
        }
        code = sb.toString();
        System.out.println(code);
        BufferedImage bufferedImage = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 100, 40);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 30));
        for (int i = 0; i < 4; i++) {
            graphics.drawLine(random.nextInt(100), random.nextInt(40), random.nextInt(100), random.nextInt(40));
        }
        for (int i = 0; i < 4; i++) {
            graphics.drawString(code.charAt(i) + "", i * 20, 30 - i);
        }
        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "jpg", os);
        os.close();
    }
    private void doVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String clientCode = request.getParameter("captcha");
        System.out.println("clientcode:::"+clientCode);
        response.setContentType("application/json; charset=UTF-8");
        if (clientCode.equals(code)){
            response.getWriter().println("{\"success\":true}");
        }else
            response.getWriter().println("{\"success\":false, \"message\":\"验证码错误\",\"error\":\"thisiserror\"}");

    }

}
