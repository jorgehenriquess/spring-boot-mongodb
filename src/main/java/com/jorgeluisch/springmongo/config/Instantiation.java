package com.jorgeluisch.springmongo.config;

import com.jorgeluisch.springmongo.domain.Post;
import com.jorgeluisch.springmongo.domain.User;
import com.jorgeluisch.springmongo.dto.AuthorDTO;
import com.jorgeluisch.springmongo.repository.PostRepository;
import com.jorgeluisch.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("30/06/2021"), "Teste1", "Resposta1", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("29/06/2021"), "Teste2", "Resposta2", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
