package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.dao.impl.TicketMovieDAOImpl;
import com.ict.erp.service.TicketService;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServiceImpl implements TicketService {
	private TicketMovieDAO tmdao = new TicketMovieDAOImpl();
	
	@Override
	public List<TicketMovie> selectTicketMoiveList(TicketMovie ticket) throws SQLException {
		try {
			tmdao.setConnection(DBCon.getCon());
			return tmdao.selectTicketMovieList(ticket);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public TicketMovie selectTicketMoive(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTicketMoive(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTicketMoive(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicketMoive(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
