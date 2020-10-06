package pe.com.tradia.user.service;

import org.springframework.stereotype.Service;
import pe.com.tradia.user.User;

@Service
public class MockUserService implements UserService {

    @Override
    public User getById(Long idUser) {
        return User.builder().id(idUser).username("username@gmail.com").displayName("Usuario de prueba").build();
    }
}
