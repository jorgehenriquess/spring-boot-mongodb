package com.jorgeluisch.springmongo.service;

import com.jorgeluisch.springmongo.domain.Post;
import com.jorgeluisch.springmongo.domain.User;
import com.jorgeluisch.springmongo.repository.PostRepository;
import com.jorgeluisch.springmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    /*
    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete (String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update (User obj){

        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }
    */
}
