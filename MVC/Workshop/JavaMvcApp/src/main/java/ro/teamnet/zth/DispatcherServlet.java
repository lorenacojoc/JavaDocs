package ro.teamnet.zth;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.appl.domain.Employee;
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
import java.lang.reflect.Parameter;
import java.util.*;

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
                            String urlPath = controllerUrlPath + methodUrlPath + methodAnnotation.methodType();

                            //construiesc valoarea
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(methodAnnotation.methodType());
                            methodAttributes.setMethodName(method.getName());
                            methodAttributes.setParameterTypes(method.getParameterTypes());

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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("PUT", req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
        dispatchReply("DELETE",req,resp);
    }

    public void dispatchReply(String identif ,HttpServletRequest request,HttpServletResponse response){

        Object result = null;
        try {
            result = dispatch(identif,request, response);}
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
            //printWriter.printf(result.toString());

            ObjectMapper objectMapper = new ObjectMapper();
            String object = (String)objectMapper.writeValueAsString(result);
            EmployeeController empl = new EmployeeController();
            printWriter.printf(object);


    }

    private Object dispatch(String methodtype, HttpServletRequest request, HttpServletResponse response) {

        EmployeeController employee = new EmployeeController();
        DepartmentController dep = new DepartmentController();

        String pathInfo = request.getPathInfo() + methodtype;
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
           return "no attributes";
        }

        String controllerName = methodAttributes.getControllerClass();
        try {
            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method = controllerClass.getMethod(methodAttributes.getMethodName(),
                    methodAttributes.getParameterTypes());
            List<Object> paramValues = new ArrayList<>();
            Parameter[] params = method.getParameters();
            for (Parameter param : params){
                if(param.isAnnotationPresent(MyRequestParam.class)){
                MyRequestParam annotation = param.getAnnotation(MyRequestParam.class);
                String name = annotation.name();
                    String  requestParamValue = request.getParameter(name);
                    Class<?> type = param.getType();
                    Object requestParamObject;
                    if (type.equals(String.class)){
                        requestParamObject = requestParamValue;
                    }else {
                        requestParamObject = new ObjectMapper().readValue(requestParamValue,type);
                    }
                    paramValues.add(requestParamObject);

                }
            }

            request.getParameter("id");
            Object result = method.invoke(controllerInstance, paramValues.toArray());


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
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }




}
