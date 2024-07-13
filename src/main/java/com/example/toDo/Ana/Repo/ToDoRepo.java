package com.example.toDo.Ana.Repo;

import com.example.toDo.Ana.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoRepo extends JpaRepository<ToDo, Long> {

    @Query(value = "SELECT * FROM to_do LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<ToDo> findToDosByPage(@Param("limit") int limit, @Param("offset") int offset);

}
