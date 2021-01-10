package com.mathBlog.mathBlog.models.repo;

import com.mathBlog.mathBlog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>
{

}
