package com.example.toDo.Ana.Service;

import com.example.toDo.Ana.Entity.ToDo;
import com.example.toDo.Ana.Repo.ToDoRepo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> getAllToDo() {
        return toDoRepo.findAll();
    }

    public ToDo getToDoById(Long id) {
        return toDoRepo.findById(id).orElse(null);
    }

    public ToDo saveToDo(ToDo toDo) {
        return toDoRepo.save(toDo);    //kayıt
    }

    public void deleteToDoById(Long id) {
        toDoRepo.deleteById(id);
    }

    public List<ToDo> getToDosByPage(int page, int size) {
        int offset = page * size;
        return toDoRepo.findToDosByPage(size, offset);
    }
}
