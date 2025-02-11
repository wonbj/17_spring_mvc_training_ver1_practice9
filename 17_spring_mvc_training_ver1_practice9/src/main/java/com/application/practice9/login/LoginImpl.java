package com.application.practice9.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.practice9.post.dao.PostDAO;
import com.application.practice9.post.dto.PostDTO;

@Service
public class LoginImpl implements Login {

	// 와따시는 A
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PostDAO postDAO;

	@Override
	public List<PostDTO> getPostList() {
		return null;
	}

	@Override
	public void createPost(PostDTO postDTO) {
		
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
		String encodedPasswd = postDAO.getPasswd(postDTO.getPostId());
		boolean isCheckedUser = passwordEncoder.matches(postDTO.getPasswd(), encodedPasswd);
		return isCheckedUser;
	}

	@Override
	public void updatePost(PostDTO postDTO) {
		postDAO.updatePost(postDTO);
	}

	@Override
	public void deletePost(long postId) {
		postDAO.deletePost(postId);
	}
	
}
