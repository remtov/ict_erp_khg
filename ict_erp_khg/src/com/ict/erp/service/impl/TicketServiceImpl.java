package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketDAO;
import com.ict.erp.dao.impl.TicketDAOImpl;
import com.ict.erp.service.TicketService;
import com.ict.erp.vo.TicketMovie;

public class TicketServiceImpl implements TicketService {
	private TicketDAO tdao = new TicketDAOImpl();
	@Override
	public List<TicketMovie> selectTmList(TicketMovie tm) throws SQLException {
		try {
			tdao.setConnection(DBCon.getCon());
			return tdao.selectTmList(null);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public TicketMovie selectTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTm(TicketMovie tm) throws SQLException {
		tdao.setConnection(DBCon.getCon());
		try {
			return tdao.insertTm(tm);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
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

