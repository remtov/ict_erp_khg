package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketDAO;

import com.ict.erp.dao.impl.TicketDAOImpl;
import com.ict.erp.service.TicketService;
import com.ict.erp.vo.TicketMovie;

public class TicketServiceImpl implements TicketService {
	private TicketDAO tmdao = new TicketDAOImpl();
	
	@Override
	public List<TicketMovie> selectTicketList(TicketMovie ticket) throws SQLException {
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
	public TicketMovie selectTicket(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTicket(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTicket(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicket(TicketMovie ticket) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
