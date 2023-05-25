package com.ezen.persistence;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.domain.Board;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	public BoardRepository boardRepo;
	
	//데이터 insert test
	@Test
	@Disabled
	public void testInsertBoard() {
		System.out.println("===> testInsertBoard() board insert");
		
		Board board = new Board();
		
		board.setTitle("네코펀치");
		//board.setWriter("냥냥");
		board.setContent("집갈래...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		boardRepo.save(board);
	}
	
	//데이터 조회 test
	@Test
	@Disabled
	public void testGetBoard() {
		System.out.println("===> testGetBoard() getBoard");
		
		Board board = boardRepo.findById(4L).get();
		
		System.out.println(board.toString());
	}
	
	//데이터 update test
	@Test
	@Disabled
	public void testUpdateBoard() {
		System.out.println("===> testUpdateBoard() board update");
		
		Board board = boardRepo.findById(4L).get();
		
		board.setContent("수정입니당~");
		
		boardRepo.save(board);
	}
	
	//데이터 delete test
	@Test
	@Disabled
	public void testDeleteBoard() {
		System.out.println("===> testDeleteBoard() board delete");
		
		boardRepo.deleteById(4L);
		
	}
	
}
