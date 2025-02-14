package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductServices;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    private ProductServices productServices = new ProductServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productServices.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("add".equals(action)) {
            Product product = new Product(0, request.getParameter("pname"),
                    request.getParameter("pavatar"),
                    Integer.parseInt(request.getParameter("ptotal")),
                    Float.parseFloat(request.getParameter("price")),
                    request.getParameter("porigin"),
                    request.getParameter("category"),
                    request.getParameter("storage"),
                    request.getParameter("color"),
                    request.getParameter("description"));

            productServices.addProduct(product);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productServices.deleteProduct(id);
        } else if ("update".equals(action)) {
            Product product = new Product(Integer.parseInt(request.getParameter("id")),
                    request.getParameter("pname"),
                    request.getParameter("pavatar"),
                    Integer.parseInt(request.getParameter("ptotal")),
                    Float.parseFloat(request.getParameter("price")),
                    request.getParameter("porigin"),
                    request.getParameter("category"),
                    request.getParameter("storage"),
                    request.getParameter("color"),
                    request.getParameter("description"));

            productServices.updateProduct(product);
        }

        response.sendRedirect("product");
    }
}
