package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {
@InjectMocks
private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //given
        Task task = new Task(1L,"title","description");
        TaskDto taskDto = new TaskDto(1L,"titleDto","description");
        //when
        Task task1 = taskMapper.mapToTask(taskDto);
        //then
        assertEquals("titleDto",task1.getTitle());
    }

    @Test
    public void mapToTaskDtoTest() {
        //given
        Task task = new Task(1L,"title","description");
        TaskDto taskDto = new TaskDto(1L,"titleDto","description");
        //when
        TaskDto taskDto1 = taskMapper.mapToTaskDto(task);
        //then
        assertEquals("title",taskDto1.getTitle());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //given
        Task task = new Task(1L,"title","description");
        TaskDto taskDto = new TaskDto(1L,"titleDto","description");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(taskDto);
        //when
        List<TaskDto> list = taskMapper.mapToTaskDtoList(taskList);
        //then
        assertEquals(1,list.size());
    }
}
//given
//when
//then