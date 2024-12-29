package com.application.practice9.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.practice9.post.dto.PostDTO;

@Mapper
public interface PostDAO {

	public List<PostDTO> getPostList();
	public void createPost(PostDTO postDTO);
	public void updateReadCnt(long postId);
	public PostDTO getPostDetail(long postId);
	public String getPasswd(long postId);
	public void updatePost(PostDTO postDTO);
	public void deletePost(long postId);

}
