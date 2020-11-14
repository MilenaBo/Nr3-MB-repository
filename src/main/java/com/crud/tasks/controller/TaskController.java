package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//mod20str57
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    //mod 22.4 s 42
//    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
//    public  List<TrelloBoardDto> getTrelloBoards() {
//        return trelloClient.getTrelloBoards();
//    }

    @RequestMapping(method = RequestMethod.GET,value = "getTasks")
    public List<TaskDto>    getTasks()     { return  taskMapper.mapToTaskDtoList(service.getAllTasks());}

    @RequestMapping(method = RequestMethod.GET,value = "getTask")
    public TaskDto          getTask(@RequestParam Long taskId) throws  TaskNotFoundException    {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }
    @RequestMapping(method = RequestMethod.GET,value = "get19_2Task")
    public TaskDto          get19_2Task(Long id) { return new TaskDto(1L,"title","test content");}

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteTask")
    public  void            deleteTask(@RequestParam Long taskId)  throws TaskNotFoundException  {
        taskMapper.mapToTaskDto(service.delTask(taskId));}

    @RequestMapping(method = RequestMethod.PUT,value = "updateTask")
    public  TaskDto         updateTask(TaskDto taskDto)  { return new TaskDto(1L,"Edited title","Edited content");}

    @RequestMapping(method = RequestMethod.POST,value = "createTask", consumes = APPLICATION_JSON_VALUE)
    public void             createTask(@RequestBody TaskDto taskDto)  { service.saveTask(taskMapper.mapToTask(taskDto));}

}