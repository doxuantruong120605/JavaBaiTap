package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import model.UserServices;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, email, password );
        UserServices userServices = new UserServices();

        if(userServices.registerUser(user)) {
            resp.sendRedirect("login.jsp");
        } else {
            req.setAttribute("errorRgis", "User already exists");
            resp.sendRedirect("login.jsp?error=exists");
        }


    }

}
