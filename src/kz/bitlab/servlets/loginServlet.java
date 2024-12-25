package kz.bitlab.servlets;

import kz.bitlab.models.DBManager;
import kz.bitlab.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        Users user = DBManager.getUser(email, pass);
        if (user != null){
            resp.sendRedirect("hellouser.jsp?id=" + user.getId());
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }

    }
}
