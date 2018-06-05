package com.spring.web.board.dao;

import java.util.List;
import java.util.Map;

import com.spring.web.domain.BoardVO;
import com.spring.web.domain.Search;

public interface BoardDao {

	List<Map> boardList(Search search) throws Exception;

	void boardRegist(BoardVO vo) throws Exception;

	BoardVO boardView(BoardVO vo) throws Exception;

	void boardDelete(int bno)  throws Exception;

	List<Map> boardList2(BoardVO vo)  throws Exception;

	int pageCount(Search search)  throws Exception;

	void viewPoint(BoardVO vo) throws Exception;


}
