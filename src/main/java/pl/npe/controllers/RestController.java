package pl.npe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pl.npe.models.User;
import pl.npe.repositories.UserRepository;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hi")
    public List<User> hi() {
        return userRepository.findAll();
    }

}
