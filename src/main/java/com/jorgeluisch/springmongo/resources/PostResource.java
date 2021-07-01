package com.jorgeluisch.springmongo.resources;


import com.jorgeluisch.springmongo.domain.Post;
import com.jorgeluisch.springmongo.resources.util.URL;
import com.jorgeluisch.springmongo.service.PostService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.decodeURL(text);
        List<Post> obj = service.findByTitle(text);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/searchtitle")
    public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.decodeURL(text);
        List<Post> obj = service.searchTitle(text);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text",defaultValue = "") String text,
            @RequestParam(value = "minData",defaultValue = "") String minDate,
            @RequestParam(value = "maxData",defaultValue = "") String maxDate) {

        text = URL.decodeURL(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
