package com.github.com.ludmilareis.TodoList.Repository;

import com.github.com.ludmilareis.TodoList.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //anotação pra classe responsável por repositiry
public interface TaskRepository extends JpaRepository<Task, Long> {
}
