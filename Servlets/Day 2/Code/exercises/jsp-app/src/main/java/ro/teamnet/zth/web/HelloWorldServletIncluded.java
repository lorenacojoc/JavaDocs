package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lorena on 7/13/2016.
 */
public class HelloWorldServletIncluded extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = "";
        req.setAttribute("Attribute", "Enjoy");
        String attribute = (String)req.getAttribute("Attribute");
        resp.getWriter().write("Hello <b>" + req.getParameter("user") + "" + attribute);
    }
}
