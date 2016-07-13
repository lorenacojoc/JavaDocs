package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Lorena on 7/12/2016.
 */
public class InfoHttpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        Enumeration headers = req.getHeaderNames();
        String method = req.getMethod();
        String queryString = req.getQueryString();
        Cookie[] cookies = req.getCookies();
        Map parameters = req.getParameterMap();


        String response = " <table border = \"1px solid black\"> "
                + "<tr>" +
                "<th>Header name</th>" +
                "<th>value name</th>" +
                "</tr>";
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            String headerValue = req.getHeader(headerName);

            response += "<tr>" +
                    "<td>" + headerName + "</td>" +
                    "<td>" + headerValue + "</td>" +
                    "</tr>";
        }

        response += "</table>";

        response += "<p> Method: " + method + "</p>";
        response += "<p> Query String: " + queryString + "</p>";

        if (cookies != null) {

            response += "<table> " +
                    "<tr> " +
                    "<th>Cookie name</th>" +
                    "<th>Cookie value</th>" +
                    "</tr>";
            for (Cookie cookie : cookies) {
                response += "<tr>" +
                        "<td>" + cookie.getName() + "</td>" +
                        "<td>" + cookie.getValue() + "</td>" +
                        "</tr>";
            }
            response += "</table>";

        }else{
            response += "<p> No cookies found </p>";
        }

        if(!parameters.isEmpty()){

            response += "<table> " +
                    "<tr> " +
                    "<th>Parameter name</th>" +
                    "<th>Parameter value</th>" +
                    "</tr>";

            Iterator entries = parameters.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String value = req.getParameter((String) entry.getKey());

                response += "<tr>" +
                        "<td>" + entry.getKey() + "</td>" +
                        "<td>" + value + "</td>" +
                        "</tr>";
            }
            response += "</table>";

        }else {
            response += "no params found";
        }

        resp.getWriter().write(response);
    }

}


