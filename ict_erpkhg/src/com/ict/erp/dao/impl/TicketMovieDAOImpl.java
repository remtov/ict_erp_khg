package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieDAOImpl extends CommonDAOImpl implements TicketMovieDAO {

	@Override
	public List<TicketMovie> selectTicketMovieList(TicketMovie tm) throws SQLException {
		String sql = "select * from ticket_movie";
		List<TicketMovie> tmList = new ArrayList<TicketMovie>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			return ICTUtils.parseList(rs, TicketMovie.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public TicketMovie selectTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "SELECT * from "
				+ " TICKET_MOVIE tm"
				+ " where tmNum=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, tm.getTmNum());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				TicketMovie tm1 = new TicketMovie();
				tm1.setTmNum(rs.getInt("tmNum"));
				tm1.setTmName(rs.getString("tmName"));
				tm1.setTmPrice(rs.getInt("tmPrice"));
				tm1.setTmStartdat(rs.getString("tmStartdat"));
				tm1.setTmEnddat(rs.getString("tmEnddat"));
				tm1.setTmCredat(rs.getString("tmCredat"));
				tm1.setTmDesc(rs.getString("tmDesc"));
				tm1.setTmCnt(rs.getInt("tmCnt"));
				tm1.setTmImg(rs.getString("tmImg"));

				return tm1; 

			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return null;
	}

	@Override
	public int insertTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "insert into ticket_movie(tmNum, tmName, tmPrice, "
				+ "tmStartdat, \r\n" + 
				"tmEnddat, tmCredat, tmDesc,tmImg)\r\n" + 
				"values(seq_tmNum.nextval,?,?,?,?,"
				+ "to_char(sysdate,'YYYYMMDD'),?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tm.getTmName());
			ps.setInt(2, tm.getTmPrice());
			ps.setString(3, tm.getTmStartdat().replace("-", ""));
			ps.setString(4, tm.getTmEnddat().replace("-", ""));
			ps.setString(5, tm.getTmDesc());
			ps.setString(6, tm.getTmImg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int updateTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "update ticket_movie set\r\n" + 
				"    TMNAME=?,\r\n" + 
				"    TMPRICE=?,\r\n" + 
				"    TMSTARTDAT=?,\r\n" + 
				"    TMENDDAT=?,\r\n" + 
				"    TMCREDAT=?,\r\n" + 
				"    TMDESC=?,\r\n" + 
				"    TMCNT=?,\r\n" + 
				"    TMIMG=?,\r\n" + 
				"where\r\n" + 
				"    TMNUM=?";
		

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tm.getTmName());
			ps.setInt(2, tm.getTmPrice());
			ps.setString(3, tm.getTmStartdat().replace("-", ""));
			ps.setString(4, tm.getTmEnddat().replace("-", ""));
			ps.setString(5, tm.getTmCredat());
			ps.setString(6, tm.getTmDesc());
			ps.setInt(7, tm.getTmCnt());
			ps.setString(8, tm.getTmImg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int deleteTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "delete from ticket_movie where tmNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, tm.getTmNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}


}
