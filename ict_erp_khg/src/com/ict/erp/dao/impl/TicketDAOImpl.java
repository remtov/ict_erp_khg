package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.TicketDAO;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.TicketMovie;

public class TicketDAOImpl extends CommonDAOImpl implements TicketDAO {
	private static String SELECT_TM_LIST = "select * from ticket_movie ";
	
	@Override
	public List<TicketMovie> selectTmList(TicketMovie tm) throws SQLException {
		String sql = "select * from ticket_movie";
		List<TicketMovie> ticketList = new ArrayList<TicketMovie>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return IBean.convertList(rs,TicketMovie.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public TicketMovie selectTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTm(TicketMovie tm) throws SQLException {
	String sql = "insert into ticket_movie(tmNum, tmName, tmPrice,TMSTARTDAT, tmEnddat, tmCredat, tmDesc, tmImg)"
			+ "values(seq_tmNum.nextval,?,?,?,?,to_char(sysdate,'yyyymmdd'),?,?)";
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, tm.getTmName());
		ps.setInt(2, tm.getTmPrice());
		ps.setString(3, tm.getTmStartDat());
		ps.setString(4, tm.getTmEndDat());
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
	public int updateTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
