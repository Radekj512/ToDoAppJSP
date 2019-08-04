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

@WebServlet("/to-do/list/edit")
public class EditController extends HttpServlet {
    private ToDoService service = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        Long id = Long.parseLong(req.getParameter("id"));
        ToDoModel toEdit = service.getToDoById(login, id);
        req.setAttribute("todo", toEdit);
        req.setAttribute("categories", Category.values());
        req.getRequestDispatcher("/WEB-INF/view/editForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String category = req.getParameter("category");
        String deadline = req.getParameter("deadline"); //2019-08-09T12:03
        String description = req.getParameter("description");
        String isdone = req.getParameter("isdone");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate dateTime = LocalDate.parse(deadline, formatter);

        ToDoModel editedToDo = service.getToDoById(login, id);
        editedToDo.setCategory(Category.valueOf(category));
        editedToDo.setDeadlineDate(dateTime);
        editedToDo.setDescription(description);
        editedToDo.setTitle(title);
        if (isdone != null && isdone.equals("on")) {
            editedToDo.setDone(true);
        } else {
            editedToDo.setDone(false);
        }

        resp.sendRedirect("/to-do/list");
    }
}
