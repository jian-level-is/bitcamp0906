package com.bitcamp.myapp.member.service;

import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.MemberDao;
import com.bitcamp.myapp.jdbc.ConnectionProvider;
import com.bitcamp.myapp.jdbc.JdbcUtil;
import com.bitcamp.myapp.member.domain.Member;
import com.bitcamp.myapp.member.domain.MemberLoginRequest;
import com.bitcamp.myapp.member.exception.LoginInvalidException;

@Service
public class MemberLoginService {

	@Autowired
	private MemberDao dao;

	public String login(MemberLoginRequest loginRequest, HttpSession session, HttpServletResponse response)
			throws Exception {

		String viewName = null;
		Connection conn = null;
		Member member = null;

		try {
			conn = ConnectionProvider.getConnection();

			member = dao.selectByIdPw(conn, loginRequest.getUserid(), loginRequest.getPw());

			if (member == null) {
				throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
			}

			// 로그인 처리와 viewName 정의, 쿠키 처리
			// 로그인 : session 속성에 데이터 저장
			session.setAttribute("loginInfo", member.getLoginInfo());

			// id 저장하기 체크 처리 : checked 상태 -> "on" -> 쿠키 저장
			if (loginRequest.getSaveid() != null && loginRequest.getSaveid().equals("on")) {

				Cookie c = new Cookie("saveId", loginRequest.getUserid());
				response.addCookie(c);

			}

			if (loginRequest.getUrl().length() > 0) {
				viewName = "redirect:" + loginRequest.getUrl();
			} else {
				viewName = "redirect:/";
			}

		} finally {
			JdbcUtil.close(conn);
		}

		return viewName;
	}

}