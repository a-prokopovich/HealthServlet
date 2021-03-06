package com.prokopovich.health;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;

@WebServlet("/health")
public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        var responseBody = new ResponseBody("UP");
        var responseJson = new Gson().toJson(responseBody);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        var writer = response.getWriter();
        writer.print(responseJson);
        writer.flush();
    }

    private class ResponseBody {
        private String status;

        ResponseBody(String status) {
            this.status = status;
        }
    }
}
