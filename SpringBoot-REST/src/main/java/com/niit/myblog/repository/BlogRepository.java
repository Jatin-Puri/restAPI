package com.niit.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.myblog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> 
{
	
	// custom query to search to blog post by title or content
	List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}
