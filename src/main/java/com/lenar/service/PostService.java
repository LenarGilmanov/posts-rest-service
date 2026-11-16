package com.lenar.service;

import com.lenar.dto.PostDto;
import com.lenar.dto.PostsContainerDto;
import com.lenar.dto.request.CreatePostRequest;
import com.lenar.dto.request.UpdatePostRequest;
import com.lenar.entity.Post;
import com.lenar.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostsContainerDto findAll() {
        List<PostDto> posts = postRepository.findAll()
                .stream()
                .map(Post::toDto)
                .collect(Collectors.toList());
        return new PostsContainerDto(posts);
    }

    public PostDto findById(int id) {
        return postRepository.findById(id)
                .map(post -> post.toDto())
                .orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " not found."));
    }

    public PostDto save(CreatePostRequest request) {
        Post post = request.toEntity();
        return postRepository.save(post).toDto();
    }

    public PostDto update(int id, UpdatePostRequest request) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    Post updatedPost = request.toEntity(existingPost.getId(), existingPost.getCreationDate());
                    return postRepository.save(updatedPost).toDto();
                }).orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " was not found"));
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }

}
