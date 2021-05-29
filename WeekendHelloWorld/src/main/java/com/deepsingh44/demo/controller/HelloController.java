package com.deepsingh44.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deepsingh44.demo.dao.PostDao;
import com.deepsingh44.demo.model.Post;

@RestController
public class HelloController {

	@Autowired
	private PostDao postDao;

	@PostMapping("/addpost")
	public String hello(@RequestBody Post post) {
		postDao.save(post);
		return "Successfully Added";
	}

	@GetMapping("/posts")
	public List<Post> getAllPost() {
		return postDao.findAll();
	}

	// @PathVariable("id") int postid
	@GetMapping("/find/{id}")
	public Post getPostById(@PathVariable int id) {
		Optional<Post> opt = postDao.findById(id);
		return (!opt.isEmpty()) ? opt.get() : new Post();
	}

	@DeleteMapping("/delete")
	public String deletePostById(@RequestParam int id) {
		Post post = getPostById(id);
		if (post.getId() == 0) {
			return "Deleted Failed";
		} else {
			postDao.delete(post);
			return "Successfully Deleted";
		}

	}

	@PutMapping("/update")
	public Post updatePost(@RequestBody Post mypost) {
		Post post = getPostById(mypost.getId());
		System.out.println(post);
		if (post.getId() == 0) {
			System.out.println("hello1");
			return post;
		} else {
			System.out.println("hello");
			return postDao.save(mypost);

		}
	}

}
