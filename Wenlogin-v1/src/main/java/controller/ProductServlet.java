package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("add".equals(action)) {
            Product product = new Product(0, request.getParameter("pname"),
                    request.getParameter("pavarta"),
                    Float.parseFloat(request.getParameter("ptotal")),
                    request.getParameter("porigin"),
                    request.getParameter("discription"));

            productDAO.addProduct(product);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productDAO.deleteProduct(id);
        } else if ("update".equals(action)) {
            Product product = new Product(Integer.parseInt(request.getParameter("id")),
                    request.getParameter("pname"),
                    request.getParameter("pavarta"),
                    Float.parseFloat(request.getParameter("ptotal")),
                    request.getParameter("porigin"),
                    request.getParameter("discription"));

            productDAO.updateProduct(product);
        }
        response.sendRedirect("product");
    }


}
