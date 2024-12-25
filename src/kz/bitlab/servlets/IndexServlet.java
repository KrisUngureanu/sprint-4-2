package kz.bitlab.servlets;

import kz.bitlab.models.DBManager;
import kz.bitlab.models.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Items> items = DBManager.getAllItems();
        System.out.println(items);
        req.setAttribute("items", items);

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
