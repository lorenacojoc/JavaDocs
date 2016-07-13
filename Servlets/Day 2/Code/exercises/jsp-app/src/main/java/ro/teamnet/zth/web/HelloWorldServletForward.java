package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lorena on 7/13/2016.
 */
public class HelloWorldServletForward extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/forward");
        req.setAttribute("testAttribute", "Enjoy Z2H");
        requestDispatcher.forward(req,resp);

        String attribute = (String)req.getAttribute("testAttribute");
        resp.getWriter().write("Hello <b>"+ req.getParameter("user")+ " " + "</b> from the Forward Servlet" + " " + attribute );
    }
}
