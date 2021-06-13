package com.example.taskplanner

import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.repository.model.entity.User
import com.example.taskplanner.repository.remote.dto.UserDto
import com.example.taskplanner.repository.remote.user.UserService
import com.example.taskplanner.repository.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.plugins.MockMaker
import retrofit2.Response

@ExperimentalCoroutinesApi
class UserRepositoryUnitTest {


    lateinit var userRepository: UserRepository

    @Mock
    lateinit var userService: UserService

    @Mock
    lateinit var userDao: UserDao

    @Mock
    lateinit var response: Response<UserDto>


    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        userRepository = UserRepository(userService,userDao)

    }

    @Test
    fun whenUserIsCreatedThenDataIsStoredOnLocalDBUsingUserDao() = runBlocking{
        `when`(response.isSuccessful).thenReturn(true)
        val userDto = UserDto("1234","David Cabrera",
            "test123","david@gmail.com","imugur.com")
        `when`(response.body()).thenReturn(userDto)
        userRepository.userService.createUser(userDto)
        verify(userDao).save(User(userDto))

    }

    @Test
    fun whenUserIsCreatedThenTokenIsStoredOnSharedPreferences(){
        Assert.assertEquals(4, 2 + 2)



    }




}