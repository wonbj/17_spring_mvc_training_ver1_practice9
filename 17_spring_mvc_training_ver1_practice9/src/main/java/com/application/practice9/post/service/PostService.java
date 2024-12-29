package com.application.practice9.post.service;

import java.util.List;

import com.application.practice9.post.dto.PostDTO;

public interface PostService {

	public List<PostDTO> getPostList();
	public void createPost(PostDTO postDTO);
	public Object getPostDetail(long postId, boolean isUpdateReadCnt);
	public boolean checkAuthenticationUser(PostDTO postDTO);
	public void updatePost(PostDTO postDTO);
	public void deletePost(long postId);

}
