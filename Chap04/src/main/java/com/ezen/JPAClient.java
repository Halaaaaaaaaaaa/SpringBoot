package com.ezen;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ezen.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Chap04");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/*
		// 데이터 insert 
		try {
			tx.begin();
			
			Board board = new Board();
			
			//board.setSeq(1);
			board.setTitle("춘배찡 울지마");
			board.setWriter("바보야");
			board.setContent("난 정말 괜차나");
			board.setCreateDate(new Date());
			board.setCnt(0);
			
		    em.persist(board); // 분리된 엔티티를 병합하여 영속 상태의 엔티티를 반환
		    tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		
		//게시글 조회
		try {
			Board board = em.find(Board.class, 3);
			System.out.println("===> " + board);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		
		//게시글 수정
		try{
			tx.begin();
			
			Board board = em.find(Board.class, 1);
			board.setContent("쪼물쪼물");
			//em.merge(board); // 기존 엔티티를 업데이트

		    tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		*/
		
		//글 목록 조회
		try {
			String jpql = "SELECT b FROM Board b ORDER BY b.seq DESC"; //객체를 통해 조회(일반 sql문은 테이블을 통해 조회)
			
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board board : boardList) {
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
		/*
		//게시글 삭제
		try {
			tx.begin();
			Board board = em.find(Board.class, 1);
			
			board.setSeq(1); //삭제할 키 지정
			
			em.remove(board);
			
			tx.rollback();
		
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		*/
		
	}
}
