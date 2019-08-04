package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;
import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/to-do/list")
public class ToDoListController extends HttpServlet {
    ToDoService service = new ToDoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        List<ToDoModel> list = service.getToDoList(login);
        req.getSession().setAttribute("todolist", list);
        req.setAttribute("categories", Category.values());
        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,resp);
    }
}
