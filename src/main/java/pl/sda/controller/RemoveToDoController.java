package pl.sda.controller;

import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/list/delete")
public class RemoveToDoController extends HttpServlet {
    ToDoService toDoService = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getSession().getAttribute("login");
        Long id = Long.parseLong(req.getParameter("id"));
        toDoService.remove(login, id);
        resp.sendRedirect("/to-do/list");
    }
}
