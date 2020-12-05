package com.crud.tasks.controller;
//29.3 zadanie
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @InjectMocks
    private TaskController taskController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DbService dbService;
    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldFetchEmptyTask()  throws Exception  {
        //given
        List<TaskDto> theTasksList = new ArrayList<>();
        when(taskMapper.mapToTaskDtoList(dbService.getAllTasks())).thenReturn(theTasksList);
        //when  //then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$",hasSize(0)));
    }

    @Test
    public void getTasksTest() throws Exception {
        //given
        List<TaskDto> theTasksList = new ArrayList<>();
        theTasksList.add(new TaskDto(1L,"test taskDto","content"));
        when(taskMapper.mapToTaskDtoList(dbService.getAllTasks())).thenReturn(theTasksList);
        //when        //then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].title",is("test taskDto")))
                .andExpect(jsonPath("$[0].content",is("content")));
    }
//    @Test
//    public void getTaskTest() throws Exception {
//        //given
//        Task task = new Task(1L,"test task","content");
//        TaskDto newTaskDto = new TaskDto(1L,"test taskDto","content");
//        List<TaskDto> theTasksList = new ArrayList<>();
//        theTasksList.add(new TaskDto(1L,"test taskListDto","content"));
//        //when(taskMapper.mapToTaskDtoList(dbService.getAllTasks())).thenReturn(theTasksList);
//        when(taskMapper.mapToTaskDto(dbService.getTask(1L)).thenReturn(newTaskDto);
//        //when        //then
//        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().is(200))
////                .andExpect(jsonPath("$",hasSize(1)))
//                .andExpect(jsonPath("$[0].id",is(1)))
//                .andExpect(jsonPath("$[0].title",is("test taskDto")))
//                .andExpect(jsonPath("$[0].content",is("content")));
//    }
    @Test
    public void createTaskTest() throws Exception  {
        //given
        Task newTask = new Task(1L,"tasks title","content");
        TaskDto newTaskDto = new TaskDto(1L,"tasksDto title","content");
        List<TaskDto> theTasksList = new ArrayList<>();
        theTasksList.add(newTaskDto);

 //      when(dbService.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(newTask);
       //when(dbService.saveTask(taskMapper.mapToTask(newTaskDto))).thenReturn(newTask);
//Gson gson = new Gson();
//String jsonContent = gson.toJson(newTaskDto);
//
//        //when        //then
//        mockMvc.perform(post("/v1/task/createTask")
//        .contentType(MediaType.APPLICATION_JSON)
//        .characterEncoding("UTF-8")
//        .content(jsonContent))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("tasks title")))
//                .andExpect(jsonPath("$.content", is("content")));
    }



    @Test
    public void deleteTask() {
        //given

        //when

        //then
    }

   }