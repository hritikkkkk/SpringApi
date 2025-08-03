package com.example.demo.controller;

// Model class representing the structure of a Post (id, title, body etc.)

import com.example.demo.model.Post;

// Service class containing business logic to fetch posts (usually from DB or API)
import com.example.demo.service.PostFetcherService;

// Spring annotations
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController is a specialized version of @Controller.
 * It combines @Controller and @ResponseBody, meaning:
 * - The class handles REST requests
 * - The return values of methods are written directly to the HTTP response body (usually as JSON)
 * What does it mean?
 * In a Spring Boot REST controller annotated with @RestController, when a method returns a Java object (like Post),
 * Spring Boot automatically converts that object into JSON format and writes it to the HTTP response body.
 * You don’t need to manually write code to convert it or send it in the response—it’s done automatically.
 *
 * So this eliminates the need to annotate every method with @ResponseBody.
 * Equivalent to:
 * @Controller
 * @ResponseBody
 */
@RestController

/**
 * @RequestMapping("/posts") maps all incoming requests starting with /posts
 * to this controller.
 * Example:
 *   /posts/1 → mapped to getPost(1)
 *   /posts   → mapped to getAllPosts()
 */
@RequestMapping("/posts")
public class PostController {

    /**
     * @Autowired automatically injects the bean (object) of PostFetcherService
     * from the Spring ApplicationContext (IoC container).
     * <p>
     * It is a way of *dependency injection* – you don't need to manually instantiate the service.
     * <p>
     * Example:
     * Instead of: PostFetcherService postFetcherService = new PostFetcherService();
     * Spring will do it for you.
     * <p>
     * Important: PostFetcherService must be annotated with @Service or @Component to be detected as a bean.
     */
    @Autowired
    private PostFetcherService postFetcherService;

    /**
     * @GetMapping("/{id}") maps GET HTTP requests to /posts/{id}
     * - {id} is a path variable (like /posts/5), captured into `int id`
     * @PathVariable binds the URL path variable to method parameter
     * So: /posts/7 → id = 7
     * <p>
     * The method returns a single Post object (automatically converted to JSON)
     */
    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id) {
        return postFetcherService.getPostById(id);
    }

    /**
     * @GetMapping (without a path) maps to GET /posts
     * <p>
     * Returns a list of all posts as JSON.
     * <p>
     * Spring Boot automatically converts Java objects into JSON using Jackson (library),
     * because of @RestController behavior.
     * <p>
     * Example return:
     * [
     * {"id":1, "title":"First Post", "body":"..."},
     * {"id":2, "title":"Second Post", "body":"..."}
     * ]
     */
    @GetMapping
    public List<Post> getAllPosts() {
        return postFetcherService.getAllPosts();
    }


}
