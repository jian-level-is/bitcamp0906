package guestbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.domain.LoginInfo;

public class GuestBookWriteService {

	private GuestBookWriteService () {};
	private static GuestBookWriteService service = new GuestBookWriteService();
	public static GuestBookWriteService getInstance() { return service; }
	
	
	public int insertGuestBook(HttpServletRequest req, HttpServletResponse res) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();

			int memberidx = GuestBookDao.getInstance().selectById(((LoginInfo) req.getSession().getAttribute("loginInfo")).getUserId(),conn);
			String subject = req.getParameter("subject");
			String content = req.getParameter("content");

			
			result = GuestBookDao.getInstance().insertGuestBook(conn, new GuestBook(subject, content, memberidx));
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
		
	};
	
	

	
	
	
	
}
