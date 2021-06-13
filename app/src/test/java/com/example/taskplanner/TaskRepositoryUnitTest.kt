package com.example.taskplanner

import com.example.taskplanner.repository.model.dao.TaskDao
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.Task
import com.example.taskplanner.repository.remote.dto.TaskDto
import com.example.taskplanner.repository.remote.dto.UserDto
import com.example.taskplanner.repository.remote.task.TaskService
import com.example.taskplanner.repository.remote.user.UserService
import com.example.taskplanner.repository.repository.TaskRepository
import com.example.taskplanner.repository.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class TaskRepositoryUnitTest {


    lateinit var taskRepository: TaskRepository

    @Mock
    lateinit var taskService: TaskService

    @Mock
    lateinit var taskDao: TaskDao

    @Mock
    lateinit var response: Response<TaskDto>


    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun whenTaskIsCreatedThenTaskIsStoredOnLocalDBUsingTaskDao()= runBlocking{
        `when`(response.isSuccessful).thenReturn(true)
        val task = TaskDto("1023","Do laundry","David",
            "2021-06-07","To-do","1323056")
        `when`(response.body()).thenReturn(task)
        `when`(taskService.createTask(TaskDto(task.id,task.description,task.personResponsible,
            task.dueDate, task.status,task.userId))).thenReturn(response)
        taskRepository.syncData()
        verify(taskDao).save(Task(task))

    }

    @Test
    fun whenTaskIsUpdatedThenTaskIsUpdatedOnLocalDB()= runBlocking{
        `when`(response.isSuccessful).thenReturn(true)
        val task = TaskDto("1023","Do laundry","David",
            "2021-06-07","To-do","1323056")
        `when`(response.body()).thenReturn(task)
        `when`(taskService.createTask(TaskDto(task.id,task.description,task.personResponsible,
            task.dueDate, task.status,task.userId))).thenReturn(response)

        val updateTask = TaskDto("1023","Do laundry","David",
            "2021-06-07","Completed","1323056")
        `when`(taskService.updateTask(updateTask.id, TaskDto(updateTask.id,updateTask.description,
        updateTask.personResponsible,updateTask.dueDate,updateTask.status,updateTask.userId)
        ))
        verify(taskDao).findById(updateTask.id)


    }




}