package com.visa.prj.web;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductRepo;
import com.visa.prj.dao.ProductRepoSqlImpl;
import com.visa.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // MIME application/json image/gif image/png text/xml
        ProductRepo productRepo = new ProductRepoSqlImpl();

        PrintWriter out = resp.getWriter(); // Character stream
//        ServletOutputStream out = resp.getOutputStream(); // binary
        out.print("<html><body>");
        out.print("<table border=\"1\">");
        out.println("<tr>");
            out.print("<th>ID</th><th>Name</th><th>Price</th>");
        out.print("</tr>");

        try {
            List<Product> products = productRepo.getProducts();
            for(Product p : products) {
               out.println("<tr>");
                out.print("<td>");
                    out.print(p.getId());
                    out.print("</td>");
                out.print("<td>");
                     out.print(p.getName());
                out.print("</td>");
                out.print("<td>");
                        out.print(p.getPrice());
                out.print("</td>");
               out.print("</tr>");
            }
        } catch (FetchException e) {
            e.printStackTrace();
        }
        out.print("</table>");
        out.print("</body></html>");
    }
}
