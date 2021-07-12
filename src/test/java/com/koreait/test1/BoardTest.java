package com.koreait.test1;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfiguration;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})
public class BoardTest {
	
	@Autowired
	private SqlSession sqlSession;
	private BoardDAO dao;
	private BoardDTO dto;
	
	@Test
	public void insertTest() {
		int count = dao.insertBoard("테스터", "테스트제목", "테스트 내용");
		assertEquals("게시글 추가 실패", 1, count);
	}
	
	@Test
	public void selectTest() {
		BoardDTO dto = dao.selectBybIdx(9999);
		assertEquals("게시글 찾기 실패", 1, dto);
	}
	
	@Test
	public void updateTest() {
		int count = dao.updateBoard("변경공지사항제목", "변경공지사항내용", 9999);
		assertEquals("게시글 변경 실패", 1, count);
	}
	
	@Test
	public void deleteTest() {
		int count = dao.deleteBoard(9999);
		assertEquals("게시글 삭제실패", 1, count);
	}
	

}
