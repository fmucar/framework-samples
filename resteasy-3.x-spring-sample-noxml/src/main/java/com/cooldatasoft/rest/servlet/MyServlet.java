package com.cooldatasoft.rest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;

/**
 * Created by fmucar on 25/09/15.
 */
@WebServlet(name="myServlet", urlPatterns={"/v1/*"}, loadOnStartup = 1
//        ,initParams={ @WebInitParam(name="simpleParam", value="paramValue") }
)
public class MyServlet extends HttpServlet30Dispatcher {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        doGet(request,response);
//    }
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        ServletContext sc = request.getServletContext();
//        System.out.println("Path:"+ sc.getAttribute("filePath"));
//        System.out.println("Mode:"+ sc.getAttribute("fileMode"));
//        PrintWriter out = response.getWriter();
//        out.println("Hello World!");
//    }
}
