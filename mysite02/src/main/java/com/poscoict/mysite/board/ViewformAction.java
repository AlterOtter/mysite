package com.poscoict.mysite.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.mysite.dao.BoardDao;
import com.poscoict.web.mvc.Action;
import com.poscoict.web.util.MvcUtil;

public class ViewformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		String board_num = request.getParameter("board_sn");
		if(board_num==null) {
			MvcUtil.redirect("/mysite02/board", request, response);
			return;
		}
		
		Integer sn = Integer.valueOf(board_num);
		request.setAttribute("content", new BoardDao().readContent(sn));
		
		
		
		MvcUtil.forward("board/view.jsp", request, response);

	}

}
