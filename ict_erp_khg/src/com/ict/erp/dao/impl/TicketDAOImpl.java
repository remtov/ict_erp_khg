package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.TicketDAO;
import com.ict.erp.vo.TicketMovie;

public class TicketDAOImpl extends CommonDAOImpl implements TicketDAO {
	private static String SELECT_TM_LIST = "select * from ticket_movie ";
	@Override
	public List<TicketMovie> selectTmList(TicketMovie tm) throws SQLException {
		try {
			ps = con.prepareStatement(SELECT_TM_LIST);
			rs = ps.executeQuery();
			return IBean.convertList(rs, TicketMovie.class);
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
		// TODO Auto-generated method stub
		return 0;
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
