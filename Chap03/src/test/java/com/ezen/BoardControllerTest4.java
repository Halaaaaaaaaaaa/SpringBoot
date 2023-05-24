package com.ezen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.ezen.domain.BoardVO;
import com.ezen.service.BoardService;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //웹서버를 사용하는 테스트
public class BoardControllerTest4 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	@Disabled
	public void testHello() throws Exception {
		mockMvc.perform(get("/test").param("name", "SeHyun"))
			.andExpect(status().isOk())	
			.andExpect(content().string("Test: SeHyun"))
			.andDo(print());
	}
	
	@Test
	@Disabled
	public void testHello2() throws Exception {
		System.out.println("===> testHello2() 실행");
		String result = restTemplate.getForObject("/test?name=SeHyun", String.class);
		
		//위의 url 요청에 대한 예상 결과
		//resutl : 컨트롤러로부터의 실제 결과
		assertEquals("Test: SeHyun", result); 	
	}
	
	// getBoard() 테스트
	@Test
	public void testGetBoard() throws Exception {
		System.out.println("===> testGetBoard() 실행");
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("게시글 제목", board.getTitle());
		assertEquals("작성자", board.getWriter());
		
	}
	
	
}
