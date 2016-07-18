package ro.teamnet.zth;

import jdk.nashorn.internal.parser.JSONParser;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lorena on 7/17/2016.
 */
public class EmployeeForm extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("fname");
        String password = req.getParameter("lname");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String phone = req.getParameter("phone");
        String jobid = req.getParameter("jobid");
        String salary = req.getParameter("salary");
        String commission = req.getParameter("commission");
        String managerID = req.getParameter("mid");
        String departmentID = req.getParameter("depid");


        resp.setContentType("application/json");

        JSONObject obj = new JSONObject();

        try {
            obj.put("firstName", req.getParameter("fname"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            obj.put("lastName", req.getParameter("lname"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            obj.put("email", req.getParameter("email"));
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("phonenumber", req.getParameter("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("hireDate", req.getParameter("date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("jobId", req.getParameter("jobid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("salary", req.getParameter("salary"));
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("commissionPct",req.getParameter("commission") );
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("managerId",req.getParameter("mid") );
        } catch (JSONException e) {
            e.printStackTrace();
        }try {
            obj.put("departmentId",req.getParameter("depid") );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        PrintWriter printWriter = resp.getWriter();
        printWriter.printf(obj.toString());


    }
}
