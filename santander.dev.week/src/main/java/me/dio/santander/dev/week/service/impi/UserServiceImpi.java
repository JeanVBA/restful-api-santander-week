package me.dio.santander.dev.week.service.impi;

import me.dio.santander.dev.week.model.User;
import me.dio.santander.dev.week.repository.UserRepository;
import me.dio.santander.dev.week.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpi implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpi(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
       if(userRepository.existsByAccountNumber(user.getAccount().getNumber()) && user.getId() != null)
           throw new IllegalArgumentException("User already exist");
        return userRepository.save(user);
    }
}
