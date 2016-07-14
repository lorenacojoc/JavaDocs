package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lorena on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {

    //rol de registru
    //key : url
    //value : methodAttributes
    Map<String,MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        // find all classes in the package
        try {
            Iterable<Class>  controllers  = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if(controller.isAnnotationPresent(MyController.class)){
                    MyController controllerAnnotation = (MyController)controller.getAnnotation(MyController.class);
                    String controllerUrlPath = controllerAnnotation.urlPath();
                    Method[] methods = controller.getMethods();
                    for (Method method : methods) {
                        if(method.isAnnotationPresent(MyRequestMethod.class)){
                            MyRequestMethod methodAnnotation = method.getAnnotation(MyRequestMethod.class);
                            String methodUrlPath = methodAnnotation.urlPath();

                            //construiesc cheia pt HashMap
                            String urlPath = controllerUrlPath + methodUrlPath;

                            //construiesc valoarea
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(methodAnnotation.methodType());
                            methodAttributes.setMethodName(method.getName());

                            allowedMethods.put(urlPath, methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req,resp);
        dispatchReply("GET",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req,resp);
        dispatchReply("POST",req,resp);
    }

    public void dispatchReply(String identif ,HttpServletRequest request,HttpServletResponse response){

        Object result = null;
        try {
            result = dispatch(request, response);}
        catch (Exception e){
            sendExceptionError(e,request,response);
        }
        try {
            reply(result,request,response);
        } catch (IOException e) {
            sendExceptionError(e,request,response);
        }

    }

    private void sendExceptionError(Exception e, HttpServletRequest request, HttpServletResponse response) {
    }

    private void reply(Object result, HttpServletRequest request, HttpServletResponse response) throws IOException {

            PrintWriter printWriter = response.getWriter();
            printWriter.printf(result.toString());

    }

    private Object dispatch(HttpServletRequest request, HttpServletResponse response) {

        EmployeeController employee = new EmployeeController();
        DepartmentController dep = new DepartmentController();

        String pathInfo = request.getPathInfo();
//        if(pathInfo.startsWith("/employees")){
//            String result = employee.getAllEmployees();
//            return result;
//        }else if(pathInfo.startsWith("/departments")){
//            String result = dep.getAllDepartments();
//            return result;
//        }


        MethodAttributes methodAttributes = allowedMethods.get(pathInfo);
        if(methodAttributes == null)
        {
            //nu putem procesa url-ul
            return  "hello";
        }

        String controllerName = methodAttributes.getControllerClass();
        try {
            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method = controllerClass.getMethod(methodAttributes.getMethodName());
            Object result = method.invoke(controllerInstance);

            return result;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "hello";
    }


}
