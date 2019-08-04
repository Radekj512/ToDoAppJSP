package pl.sda.controller;

import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-do/list/markAsDone")
public class MarkAsDoneController extends HttpServlet {
    ToDoService service = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String login = (String)req.getSession().getAttribute("login");
        service.markAsDone(login,id);
        resp.sendRedirect("/to-do/list");
    }
}
