package com.bitcamp.myapp.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.member.dao.MemberDao;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.MemberLoginRequest;
import com.bitcamp.myapp.member.exception.LoginInvalidException;

@Service
public class MemberLoginService {

	public MemberDao dao;
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
	
	public String login(MemberLoginRequest loginRequest, HttpSession session, HttpServletResponse response)	throws Exception {

		String viewName = null;
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member member = dao.selectByIdPw(loginRequest.getLoginParam());

		if (member == null) throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");

		// 세션에 유저정보 저장
		session.setAttribute("loginInfo", member.getLoginInfo());

		// 아이디 저장 -> 쿠키 저장
		if (loginRequest.getSaveid() != null && loginRequest.getSaveid().equals("on")) {
			Cookie c = new Cookie("saveId", loginRequest.getUserid());
			response.addCookie(c);
		}

		
		if (loginRequest.getUrl().length() > 0) {
			viewName = "redirect:" + loginRequest.getUrl();
		} else {
			viewName = "redirect:/";
		}

		return viewName;
	}

}