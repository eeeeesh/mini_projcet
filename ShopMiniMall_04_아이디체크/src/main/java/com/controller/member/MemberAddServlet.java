package com.controller.member;

import java.io.IOException;

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
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid =request.getParameter("userid");
		String passwd =request.getParameter("passwd");
		String username =request.getParameter("username");
		String post =request.getParameter("post");
		String addr1 =request.getParameter("addr1");
		String addr2 =request.getParameter("addr2");
		String phone1 =request.getParameter("phone1");
		String phone2 =request.getParameter("phone2");
		String phone3 =request.getParameter("phone3");
		String email1 =request.getParameter("email1");
		String email2 =request.getParameter("email2");
		
		MemberDTO dto= new MemberDTO(userid, passwd, username, post, addr1, addr2, 
				phone1, phone2, phone3, email1, email2);
		System.out.println(dto);
		
		MemberService service= new MemberService();
		int num =service.memberAdd(dto);
		System.out.println("insert:"+num);
		
		HttpSession session= request.getSession();
		session.setAttribute("memberAdd", userid+"님 회원가입성공"); //굳이 session에 저장할 필요x, request에 담아서 포워딩 시키는게 제일 좋음
		session.setMaxInactiveInterval(60*30);
		response.sendRedirect("main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
