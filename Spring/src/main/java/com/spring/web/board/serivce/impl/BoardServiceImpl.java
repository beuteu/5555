/*
 *------------------------------------------------------------------------------
 * AccCdServiceImpl.java
 * DESC : AccCdService Íµ¨ÌòÑ ?Å¥?ûò?ä§
 *
 * PROJ :  ?ù∏?Ç¨?öåÍ≥?
 * Copyright 2012 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                  Î≥?         Í≤?         ?Ç¨         ?ï≠
 *------------------------------------------------------------------------------
 *   DATE       AUTHOR                  DESCRIPTION
 * -----------    -----------  -------------------------------------------------
 * 2015. 08. 18.   Í≥†Ïù∏?ò∏     ÏµúÏ¥à ?îÑÎ°úÍ∑∏?û® ?ûë?Ñ±
 *------------------------------------------------------------------------------
 */
package com.spring.web.board.serivce.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.spring.web.board.dao.BoardDao;
import com.spring.web.board.serivce.BoardService;
import com.spring.web.domain.BoardVO;
import com.spring.web.domain.Search;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;


	@Override
	public List<Map> boardList(Search search) throws Exception {
		return boardDao.boardList(search);
	}
	
	@Override
	public List<Map> boardList2(BoardVO vo) throws Exception {
		return boardDao.boardList2(vo);
	}


	@Override
	public void boardRegist(BoardVO vo) throws Exception {
		boardDao.boardRegist(vo);
		
	}

	@Override
	public BoardVO boardView(BoardVO vo) throws Exception {
		return boardDao.boardView(vo);
	}


	@Override
	public void boardDelete(int bno) throws Exception {
		boardDao.boardDelete(bno);
		
	}

	@Override
	public int pageCount(Search search) throws Exception {
		return boardDao.pageCount(search);
	}

	@Override
	public void viewPoint(BoardVO vo) throws Exception {
		boardDao.viewPoint(vo);
		
	}

}
