package com.example.http;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonTypeHandle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getContentType()==null|| req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        //Reading the JSON data from the request body.
        JsonReader reader = Json.createReader(req.getInputStream());
        //Creating the JSON object model from the JSON data.
        JsonObject jsonObject = reader.readObject();
        //Getting the values from the JSON object
        String name = jsonObject.getString("name");
        System.out.println("Name:"+name);
    }
}
