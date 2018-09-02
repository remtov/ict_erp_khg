package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;


import com.ict.erp.vo.TicketMovie;

public interface TicketService {
	public List<TicketMovie> selectTicketMoiveList(TicketMovie ticket) throws SQLException;
	public TicketMovie selectTicketMoive(TicketMovie ticket) throws SQLException;
	public int insertTicketMoive(TicketMovie ticket) throws SQLException;
	public int updateTicketMoive(TicketMovie ticket) throws SQLException;
	public int deleteTicketMoive(TicketMovie ticket) throws SQLException;
}
