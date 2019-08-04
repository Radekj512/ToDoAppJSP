package pl.sda.service;

import pl.sda.model.ToDoModel;
import pl.sda.repository.ToDoRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoService {

    private ToDoRepository toDoRepository = new ToDoRepository();

    public void addToDo(String login, ToDoModel note){
        toDoRepository.addToDoList(login, note);
    }

    public ToDoModel getToDoById(String login, Long id){
        return toDoRepository.getToDoById(login, id);
    }

    public List<ToDoModel> getToDoList(String login){
        return ToDoRepository.getToDoList(login);
    }

    public void remove(String login, Long id) {
        toDoRepository.removeToDo(login, id);
    }
    public void markAsDone(String login, Long id){
        toDoRepository.markAsDone(login,id);
    }
    public void saveToDo(String login, Long id, ToDoModel newTodo){
        toDoRepository.saveToDo(login, id, newTodo);
    }
}
