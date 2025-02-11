package com.application.practice9.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.practice9.post.dao.PostDAO;
import com.application.practice9.post.dto.PostDTO;

@Service
public class LoginImpl implements Login {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PostDAO postDAO;

	// 와따시는 bbbbbbb
	@Override
	public List<PostDTO> getPostList() {
		return postDAO.getPostList();
	}

	@Override
	public void createPost(PostDTO postDTO) {
		postDTO.setPasswd(passwordEncoder.encode(postDTO.getPasswd()));
		postDAO.createPost(postDTO);
	}

	@Override
	public Object getPostDetail(long postId, boolean isUpdateReadCnt) {
		if (isUpdateReadCnt) {
			postDAO.updateReadCnt(postId);
		}
		return postDAO.getPostDetail(postId);
	}

	@Override
	public boolean checkAuthenticationUser(PostDTO postDTO) {
		return true;
	}

	@Override
	public void updatePost(PostDTO postDTO) {
	}

	@Override
	public void deletePost(long postId) {
		postDAO.deletePost(postId);
	}
	
}
