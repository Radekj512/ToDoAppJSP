package pl.sda.repository;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoRepository {

    private static Map<String, ArrayList<ToDoModel>> notes = loadMockData();

    public static List<ToDoModel> getToDoList(String login) {
        return notes.get(login);
    }

    public void addToDoList(String login, ToDoModel note) {
        List<ToDoModel> userList = notes.get(login);
        userList.add(note);
        notes.put(login, (ArrayList<ToDoModel>) userList);
    }

    public void removeToDo(String login, Long id) {
        List<ToDoModel> list = notes.get(login);
        ToDoModel toDoModel = list.stream().filter(n -> n.getId().equals(id)).findFirst().orElse(null);
        list.remove(toDoModel);
    }

    public void markAsDone(String login, Long id) {
        List<ToDoModel> list = notes.get(login);
        Optional<ToDoModel> todo = list.stream().filter(n -> n.getId().equals(id)).findFirst();
        if (todo.isPresent()) {
            todo.get().setDone(true);
        }
    }

    public ToDoModel getToDoById(String login, Long id) {
        return notes.get(login).stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public void saveToDo(String login, Long id, ToDoModel newTodo) {
        notes.get(login).stream().filter(t -> t.getId().equals(id)).map(t -> t = newTodo).collect(Collectors.toList());
    }

    private static Map<String, ArrayList<ToDoModel>> loadMockData() {
        Map<String, ArrayList<ToDoModel>> map = new HashMap<>();
        ToDoModel note = new ToDoModel(SequenceGenerator.getNextValue(), Category.HOME, "Test", "title", LocalDate.now(), LocalDate.now().plusDays(7L), false);
        ToDoModel note2 = new ToDoModel(SequenceGenerator.getNextValue(), Category.HOME, "Test2", "title2", LocalDate.now(), LocalDate.now().plusMonths(1L), false);
        map.put("kowalski", new ArrayList<>(Arrays.asList(note, note2)));
        return map;
    }
}
