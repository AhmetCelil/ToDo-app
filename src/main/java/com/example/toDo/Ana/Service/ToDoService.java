package com.example.toDo.Ana.Service;

import com.example.toDo.Ana.Entity.ToDo;
import com.example.toDo.Ana.Repo.ToDoRepo;
import com.example.toDo.Ana.dto.ToDoDTO;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
        if (toDo.getSure() != null && !toDo.getSure().isEmpty() && toDo.getTarih() != null  && toDo.getYapilacakIs() != null && !toDo.getYapilacakIs().isEmpty()) {
            return toDoRepo.save(toDo);
        }
        else return null;
    }

    public void deleteToDoById(Long id) {
        toDoRepo.deleteById(id);
    }

    public List<ToDo> getToDosByPage(int page, int size) {
        int offset = page * size;
        return toDoRepo.findToDosByPage(size, offset);
    }

    // DTO'yu alıp bir ToDo'ya çevirir ve kaydeder
    public ToDoDTO createToDoDTO(ToDoDTO toDoDTO) {
        ToDo todo = new ToDo();
        todo.setYapilacakIs(toDoDTO.getYapicalacakIs());
        todo.setSure(toDoDTO.getSure());
        todo.setTarih(Date.valueOf(toDoDTO.getTarih()));

        // ToDo kaydedilir (veritabanına veya başka bir katmana)
        toDoRepo.save(todo);

        // DTO olarak döndürülür
        return toDoDTO;
    }

}
