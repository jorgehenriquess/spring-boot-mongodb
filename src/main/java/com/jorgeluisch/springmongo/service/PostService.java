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

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchTitle(String text) {
        return repo.seachTitle(text);
    }
}
