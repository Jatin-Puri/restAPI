package com.niit.myblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.myblog.model.Blog;
import com.niit.myblog.model.BlogMockedData;

@RestController
public class BlogController {
 
	BlogMockedData blogMockedData =BlogMockedData.getInstance();
	
	@GetMapping("/blog")
	public List<Blog> index()
	{
		return blogMockedData.fetchBlogs();
	}
	
	@GetMapping("/blog/{id}")
	public Blog show(@PathVariable String id){
	int blogId = Integer.parseInt(id);
	return blogMockedData.getBlogById(blogId);
	}
	
	@PostMapping("/blog/search")
	public List<Blog> search(@RequestBody Map<String, String> body){
	String searchTerm = body.get("text");
	return blogMockedData.searchBlogs(searchTerm);
	}
	
	@PostMapping("/blog")
	public Blog create(@RequestBody Map<String, String> body){
	int id = Integer.parseInt(body.get("id"));
	String title = body.get("title");
	String content = body.get("content");
	return blogMockedData.createBlog(id, title, content);
	}
	
}
