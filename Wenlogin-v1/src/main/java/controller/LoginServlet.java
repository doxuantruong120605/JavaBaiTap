package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.UserDAO;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.loginUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    //step 1 : nhaanj dl tuw form gui len
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
    //step 2 : goọi ínstance cua JavaBean
//        User user = new User();
//        boolean isValid = user.validation(username, password);

    //step 3 : điêu hướng sang view
//        if(isValid){
//            req.setAttribute("username", username);
//
//            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
//    }else {
//            req.setAttribute("error", "Invalid username or password");
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
//    }
//    }
}
