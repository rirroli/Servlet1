package com.djp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取servletContext对象
        // 方法一
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        System.out.println("这个web应用的servletContext是："+servletContext);

        //方法二
        ServletContext servletContext1 = this.getServletContext();
        System.out.println("这是用servlet直接获取的servletContext...");

        // 用servletContext来获取初始化参数
        System.out.println(servletContext1.getInitParameter("driver"));

        // 用servletContext来获取资源的绝对路径
        System.out.println(servletContext1.getRealPath("/web.xml"));

        // 获取web项目的名称
        System.out.println(servletContext1.getContextPath());

        // 获取web项目中某一个资源对应的输入流（web目录下的资源）
        System.out.println(servletContext1.getResourceAsStream("/index.jsp"));
        // 结果为java.io.ByteArrayInputStream@c6607f

        // 用类加载器的方式获取一个资源对应的输入流获取（src下的资源）
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader.getResourceAsStream("/db.properties"));
        // 结果是null
    }
}
