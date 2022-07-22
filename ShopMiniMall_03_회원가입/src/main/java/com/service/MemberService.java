package com.service;

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

}
