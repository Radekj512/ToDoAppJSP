package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;
import pl.sda.repository.SequenceGenerator;
import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/to-do/list/add")
public class AddToDoController extends HttpServlet {

    ToDoService service = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        String title = req.getParameter("title");
        String category = req.getParameter("category");
        String deadline = req.getParameter("deadline"); //2019-08-09T12:03
        String description = req.getParameter("description");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate dateTime = LocalDate.parse(deadline, formatter);


        ToDoModel newToDo = new ToDoModel(SequenceGenerator.getNextValue(), Category.valueOf(category), description, title, LocalDate.now(), dateTime, false);

        service.addToDo(login, newToDo);
        resp.sendRedirect("/to-do/list");

    }
}
