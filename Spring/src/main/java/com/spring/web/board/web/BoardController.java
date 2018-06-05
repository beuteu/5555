package com.spring.web.board.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.board.serivce.BoardService;
import com.spring.web.domain.BoardVO;
import com.spring.web.domain.PageMaker;
import com.spring.web.domain.Search;
import com.spring.web.factory.ContextFactory;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService service;

	/*
	 * ����Ʈ ������ 20180601 ������
	 */
	@RequestMapping(value = "/list")
	public ModelAndView boardList(@ModelAttribute("search") Search search, Integer page) throws Exception {

		ModelAndView mv = new ModelAndView();

		int total = service.pageCount(search);
		
		System.out.println("total" + total);
		System.out.println("search" + search);
		System.out.println("page" + page);
		
		page = (page == null ? 1 : page);
		int curpage = page - 1;

		search.setBno(curpage * 10);
		
		mv.addObject("page", new PageMaker(page, total));
		mv.addObject("list", service.boardList(search));
		mv.addObject("pageNum", page);
		mv.addObject("search", search);
		mv.addObject("total", total);
		
		mv.setViewName("/board/list");
		return mv;
	}

	/*
	 * ���GET ������ 20180601 ������
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView boardRegister(BoardVO vo) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/register");
		return mv;
	}

	/*
	 * ���POST ������ 20180601 ������
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String boardRegister2(BoardVO vo) throws Exception {

		service.boardRegist(vo);

		return "redirect:/board/list";

	}

	/*
	 * ���� ������ 20180601 ������
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) throws Exception {

		String[] bno = request.getParameter("bno").toString().split(",");

		for (int i = 0; i < bno.length; i++) {
			service.boardDelete(Integer.parseInt(bno[i]));
			System.out.println(Integer.parseInt(bno[i]));
		}

		return "redirect:/board/list";

	}

	/*
	 * �������� ������ 20180601 ������
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView boardView(BoardVO vo) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		service.viewPoint(vo);

		mv.addObject("view", service.boardView(vo));
		mv.setViewName("/board/view");
		return mv;
	}

	/*
	 * ����ƮJOSN 20180601 ������
	 */
	@RequestMapping(value = "/listAjax.do")
	public @ResponseBody Map<String, Object> getJsonByMap(BoardVO vo, Integer page, Search search) throws Exception {
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		 
		System.out.println("JSON VO���԰� VO���:" + vo);
		System.out.println("JSON page���԰� page���:" + page);

		int total = service.pageCount(search);

		page = (page == null ? 1 : page);
		int curpage = page - 1;

		search.setBno(curpage * 10);
		
		jsonObject.put("list", service.boardList(search));
		jsonObject.put("pageMaker",  new PageMaker(page, total));
		jsonObject.put("page", page);
		

		return jsonObject;

	}

	/*
	 * ����ƮJOSN 20180601 ������
	 */
	@RequestMapping(value = "/listAjax")
	public ModelAndView boardListAjax() throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("/board/listAjax");
		return mv;
	}

}
