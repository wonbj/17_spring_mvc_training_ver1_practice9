package com.application.practice9.post.controller.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.practice9.post.dto.PostDTO;
import com.application.practice9.post.service.PostService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/postList")
	public String postList(Model model) {
		model.addAttribute("postList", postService.getPostList());
		return "/post/postList";
	}
	
	
	@GetMapping("/createPost")
	public String createPost() {
		return "/post/createPost";
	}
	
	
	@PostMapping("/createPost")
	@ResponseBody
	public String createPost(@ModelAttribute PostDTO postDTO) {
		
		postService.createPost(postDTO);
		
		String jsScript = """
				<script>
					alert('게시글이 작성되었습니다.');
					location.href='/post/postList';
				</script>
				""";
		
		return jsScript;
			
	}
	
	
	@GetMapping("/postDetail")
	public String postDetail(Model model, @RequestParam("postId") long postId) {
		model.addAttribute("postDTO", postService.getPostDetail(postId, true));
		return "/post/postDetail";
	}
	
	
	@GetMapping("/authentication")
	public String authentication(Model model, @RequestParam("postId") long postId, @RequestParam("menu") String menu) {
		model.addAttribute("postDTO", postService.getPostDetail(postId, false));
		model.addAttribute("menu", menu);
		return "/post/authentication";
	}
	
	
	@PostMapping("/authentication")
	@ResponseBody
	public String authentication(@ModelAttribute PostDTO postDTO, @RequestParam("menu") String menu) {
		
		boolean isCheckedUser = postService.checkAuthenticationUser(postDTO);
		
		String jsScript = "";
		if (isCheckedUser) {
			
			if (menu.equals("update")) {
				jsScript = "<script>";
				jsScript += "location.href='/post/updatePost?postId=" + postDTO.getPostId() +"'";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript = "<script>";
				jsScript += "location.href='/post/deletePost?postId=" + postDTO.getPostId() +"'";
				jsScript += "</script>";
			}
			
		}
		else {
			
			jsScript = """
					<script>
						alert('패스워드를 확인해주세요.');
						history.go(-1);
					</script>
					""";
			
		}
		
		return jsScript;
		
	}
	
	
	@GetMapping("/updatePost")
	public String updatePost(Model model, @RequestParam("postId") long postId) {
		model.addAttribute("postDTO", postService.getPostDetail(postId, false));
		return "/post/updatePost";
	}
	
	
	@PostMapping("/updatePost")
	@ResponseBody
	public String updatePost(@ModelAttribute PostDTO postDTO) {
		
		postService.updatePost(postDTO);
		
		String jsScript = """
				<script>
					alert('게시글이 수정되었습니다.');
					location.href='/post/postList';
				</script>
				""";
		
		return jsScript;
		
	}
	
	
	@GetMapping("/deletePost")
	public String deletePost(Model model, @RequestParam("postId") long postId) {
		model.addAttribute("postId", postId);
		return "/post/deletePost";
	}
	
	
	@PostMapping("/deletePost")
	@ResponseBody
	public String deletePost(@RequestParam("postId") long postId) {
		
		postService.deletePost(postId);
		
		String jsScript = """
				<script>
					alert('게시글이 삭제되었습니다.');
					location.href='/post/postList';
				</script>
				""";
		
		return jsScript;
		
	}
	
}
