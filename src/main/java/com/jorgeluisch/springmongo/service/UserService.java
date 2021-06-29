package com.jorgeluisch.springmongo.service;

import com.jorgeluisch.springmongo.domain.User;
import com.jorgeluisch.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
