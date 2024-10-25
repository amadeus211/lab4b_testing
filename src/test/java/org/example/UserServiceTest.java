package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testCreateUser() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        UserService userService = new UserService(mockRepository);

        User user = new User(1L, "John Doe");

        userService.createUser(user);

        verify(mockRepository, times(1)).save(user);
    }
    @Test
    void testGetUserById() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        UserService userService = new UserService(mockRepository);

        User user = new User(1L, "John Doe");

        when(mockRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals(user, result);

        verify(mockRepository, times(1)).findById(1L);
    }
    @Test
    void testUpdateUser() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        UserService userService = new UserService(mockRepository);

        User user = new User(1L, "John Doe Updated");

        userService.updateUser(user);

        verify(mockRepository, times(1)).update(user);
    }


}


