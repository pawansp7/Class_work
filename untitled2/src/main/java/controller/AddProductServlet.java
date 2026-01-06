package controller;

import dao.ProductDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AddProductServlet() {
        super();
        /* TODO Auto-generated constructor stub */
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String title = request.getParameter("title");
        String price = request.getParameter("price");


        Product p = new Product();
        p.setTitle(title);
        p.setPrice(Integer.parseInt(price));


        if(ProductDAO.addProduct(p))
            response.sendRedirect("add_product.html");
        else
            response.sendRedirect("error.html");
    }

}
