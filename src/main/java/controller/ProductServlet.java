package controller;

import dao.ProductDao;
import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/list","/admin/add","/admin/edit","/admin/delete","/admin/save"})
public class ProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getServletPath();
        switch (action){
            case "/admin/save":
                saveProdct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getServletPath();
        switch (action){
            case "/admin/list":
                getList(request, response);
                break;
            case "/admin/add":
                getAddPage(request, response);
                break;
            case "/admin/edit":
                getEditPage(request, response);
                break;
            case "/admin/delete":
                deleteProduct(request, response);
                break;
        }
    }

    public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDao.getList();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("listProduct.jsp");
        dispatcher.forward(request, response);
    }

    public void getAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    public void getEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDao.getProduct(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    public void saveProdct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String detail = request.getParameter("detail");
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
        product.setDetail(detail);
        Boolean check = productDao.save(product);
        response.sendRedirect("list");
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Boolean check = productDao.delete(id);
        getList(request, response);
    }


}
