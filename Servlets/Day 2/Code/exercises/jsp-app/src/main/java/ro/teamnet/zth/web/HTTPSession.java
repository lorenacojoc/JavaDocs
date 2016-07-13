package ro.teamnet.zth.web;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/**
 * Created by Lorena on 7/13/2016.
 */
public class HTTPSession extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set the response type
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie[] cookies = req.getCookies();
        if(username.equals("admin") && password.equals("admin")){
            resp.getWriter().write("Welcome back! Username:[" + " " + username + "]");

            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                resp.getWriter().write("cookie name" + name + "cookie value" + value);
            }
        }else{

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/loginFail.jsp");
            req.setAttribute("user", username);
            req.setAttribute("session", req.getSession());
            req.getSession().setAttribute("user", username);
            req.getSession().setAttribute("session", req.getSession());

            requestDispatcher.forward(req, resp);
        }
    }



}

