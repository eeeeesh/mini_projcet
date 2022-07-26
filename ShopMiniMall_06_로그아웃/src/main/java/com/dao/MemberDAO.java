package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int memberAdd(SqlSession session, MemberDTO dto) {
		int num =session.insert("memberAdd", dto);
		return num;
	}

	public int idCheck(SqlSession session, String userid) {
		int count = session.selectOne("MemberMapper.idCheck", userid);
		return count;
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto= session.selectOne("MemberMapper.login", map);
		return dto;
	}

}
