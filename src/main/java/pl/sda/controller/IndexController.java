package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean authenticated = AuthenticationService.authenticate(req);
        if(authenticated){
            String username = req.getParameter("username");
            req.getSession().setAttribute("login", username);
            req.getSession().setAttribute("isLogin", true);
            req.setAttribute("categories", Category.values());
            resp.sendRedirect("/to-do/list");
        }else{
            req.setAttribute("wrongLogin", true);
            req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
        }


    }
}
