package com.example.toDo.Ana.Controller;

import com.example.toDo.Ana.Entity.ToDo;
import com.example.toDo.Ana.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //restfull web servisi olduğunu gösterir
@RequestMapping("/api/to_do") //isteklerin yönlenmesi için
public class ToDoController {
    @Autowired
    private ToDoService todoservice;


    /////////////////////////GET ISLEMLERIı

    @GetMapping // veri tabnında bulunan nesneleri listelemek için kullanılır
    public List<ToDo> getAlltoDo() {
        System.out.println("VERİLER LİSTELENDİ...");
        return todoservice.getAllToDo();
    }
    @GetMapping("/{id}")  //id ile çağırma işlemi için kullanılır
    public ToDo getToDoById(@PathVariable Long id) {
        return todoservice.getToDoById(id);
    }
    @GetMapping("/page")
    public List<ToDo> getToDosByPage(@RequestParam int page, @RequestParam int size) {
        return todoservice.getToDosByPage(page, size);
    }

    ////////////////////////POST ISLEMLERI
    @PostMapping
    public ToDo CreateToDo(@RequestBody ToDo todo) {
        System.out.println("veri eklendi...\nID numarası: "+ todo.getId());
        if(todo.getTarih() != null && !todo.getTarih().isEmpty()&& todo.getSure() != null && todo.getYapilacakIs() != null){
            return todoservice.saveToDo(todo);
        }
        return null;
    }

    ///////////////////////GUNCELLEME ISLEMLERI
    @PutMapping("/{id}")
    public ToDo UpdateToDo(@PathVariable Long id, @RequestBody ToDo todo) {
        return todoservice.saveToDo(todo);

    }


    ////////////////////////DELETE ISLEMLERI
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        todoservice.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }

}
