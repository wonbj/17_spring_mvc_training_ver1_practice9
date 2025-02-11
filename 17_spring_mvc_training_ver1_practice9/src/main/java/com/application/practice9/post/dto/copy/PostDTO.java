package com.application.practice9.post.dto.copy;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {

	private long postId;
	private String passwd;
	private String writer;
	private String subject;
	private String content;
	private long readCnt;
	private Date enrollAt;
	private Date updateAt;
	
}
