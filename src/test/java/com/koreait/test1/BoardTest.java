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
		int count = dao.insertBoard("�׽���", "�׽�Ʈ����", "�׽�Ʈ ����");
		assertEquals("�Խñ� �߰� ����", 1, count);
	}
	
	@Test
	public void selectTest() {
		BoardDTO dto = dao.selectBybIdx(9999);
		assertEquals("�Խñ� ã�� ����", 1, dto);
	}
	
	@Test
	public void updateTest() {
		int count = dao.updateBoard("���������������", "����������׳���", 9999);
		assertEquals("�Խñ� ���� ����", 1, count);
	}
	
	@Test
	public void deleteTest() {
		int count = dao.deleteBoard(9999);
		assertEquals("�Խñ� ��������", 1, count);
	}
	

}
