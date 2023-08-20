package org.zerock.java_web_practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet", urlPatterns = "/my") // 브라우저의 경로와 해당 서블릿을 연결하는 설정
public class MyServlet extends HttpServlet {

    @Override
    // 브라우저의 주소를 직접 변경해서 접근하는 경우에 호출되는 메소드 : doGet
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter(); // 일반적인 자바에서 System.out.println을 이용하던 것. 서블릿에서는 PrintWriter를 이용하여 브라우저쪽으로 출력
        out.println("<html><body>");
        out.println("<h1>MyServlet</h1>");
        out.print("</body></html>");
    }
}
