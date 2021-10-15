package com.github.com.ludmilareis.TodoList.Controller;


import com.github.com.ludmilareis.TodoList.Model.Task;
import com.github.com.ludmilareis.TodoList.Service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

    TaskService taskService;
    @ApiOperation(value = "Criando uma nova tarefa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informações")

    })

    //Endpoint
    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask (@RequestBody Task task){
        log.info("Criando uma nova tarefa  com as informações [{}]", task);
        return taskService.createTask(task);
    }
    @ApiOperation(value = "Listando todas as tarefas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tarefa listada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao listar as tarefas, verifique as informações")

    })

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
        public List<Task> getAllTasks(){
        log.info("Listando todas as tarefas cadastradas");
        return taskService.listAllTasks();
    }

    @ApiOperation(value = "Listando as tarefas por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tarefa encontrada com sucesso"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhuma tarefa com esse id")

    })

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTasksById(@PathVariable (value = "id")Long id){
        log.info("Buscando as tarefas por id [{}]", id);
        return taskService.findTaskById(id);
    }
    @ApiOperation(value = "Atualizando uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
            @ApiResponse(code = 404, message = "Não foi possivel atualizar essa tarefa, tarefa não encontrada")

    })

    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTasksById(@PathVariable (value = "id")Long id, @RequestBody Task task){
        log.info("Atualizando as tarefas por id [{}] as novas informações", id, task);
        return taskService.updateTaskById(task, id);
    }
    @ApiOperation(value = "Excluindo uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Tarefa excluida com sucesso"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir essa tarefa, tarefa não existe")

    })

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTasksById(@PathVariable (value = "id")Long id) {
        log.info("Deletando as tarefas por id");
        return taskService.deleteById(id);
    }

}
