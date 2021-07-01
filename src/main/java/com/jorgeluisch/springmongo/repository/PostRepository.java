package com.jorgeluisch.springmongo.repository;

import com.jorgeluisch.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query( "{ 'title' : { $regex: ?0, $options: 'i' } } ")
    List<Post> seachTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

}

