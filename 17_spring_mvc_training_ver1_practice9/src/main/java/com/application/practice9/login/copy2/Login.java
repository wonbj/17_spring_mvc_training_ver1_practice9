package com.application.practice9.login.copy2;

import java.util.List;

import com.application.practice9.post.dto.PostDTO;

public interface Login {

	public List<PostDTO> getPostList();
	public void createPost(PostDTO postDTO);
	public Object getPostDetail(long postId, boolean isUpdateReadCnt);
	public boolean checkAuthenticationUser(PostDTO postDTO);
	public void updatePost(PostDTO postDTO);
	public void deletePost(long postId);

}
