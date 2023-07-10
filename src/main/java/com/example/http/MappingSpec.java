package com.example.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MappingSpec extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MappingSpec Classes doGet() method called!");
        System.out.println("Context Path: " + req.getContextPath());
        System.out.println("Servlet Path: " + req.getServletPath());
        System.out.println("Path info: " + req.getPathInfo());
        System.out.println("Query String: " + req.getQueryString());
        System.out.println("Request URL: " + req.getRequestURL());
        System.out.println("Request URI: " + req.getRequestURI());
        System.out.println("Protocol: " + req.getProtocol());
        System.out.println("Scheme: " + req.getScheme());
        System.out.println("Remote Host : " + req.getRemoteHost());
        System.out.println("Remote Address : " + req.getRemoteAddr());
        System.out.println("Server Name : " + req.getServerName());
        System.out.println("Server Port : " + req.getServerPort());
        System.out.println("Local Name : " + req.getLocalName());
        System.out.println("Local Address : " + req.getLocalAddr());
        System.out.println("Local Port : " + req.getLocalPort());
        System.out.println("GET Method : "+req.getMethod());
    }
}
