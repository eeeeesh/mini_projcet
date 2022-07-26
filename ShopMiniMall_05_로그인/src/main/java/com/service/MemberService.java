package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	MemberDAO dao;
	
	public MemberService() {
		dao= new MemberDAO();
	}

	public int memberAdd(MemberDTO dto) {
		SqlSession session= MySqlSessionFactory.getSession();
		int num=0;
		try {
			num= dao.memberAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	public int idCheck(String userid) {
		SqlSession session= MySqlSessionFactory.getSession();
		int num=0;
		try {
			num= dao.idCheck(session, userid);
		} finally {
			session.close();
		}
		return num;
	}

	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session= MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto= dao.login(session, map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}

}//end class
