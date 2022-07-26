package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String passwd=request.getParameter("passwd");
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		MemberService service = new MemberService();
		MemberDTO dto =service.login(map);
		System.out.println(dto);
		String nextPage= null;
		
		if (dto != null) {  //인증완료
			nextPage= "main.jsp";
			HttpSession session =request.getSession();
			session.setAttribute("login", dto);	//인증정보 저장 후 회원전용페이지에서 활용
			session.setMaxInactiveInterval(60*60);
		} else {  //회원아닌 경우
			nextPage= "LoginUIServlet"; //controller에 재요청
		}
		response.sendRedirect(nextPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
