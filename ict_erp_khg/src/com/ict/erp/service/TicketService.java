package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;


import com.ict.erp.vo.TicketMovie;

public interface TicketService {
	public List<TicketMovie> selectTicketList(TicketMovie ticket) throws SQLException;
	public TicketMovie selectTicket(TicketMovie ticket) throws SQLException;
	public int insertTicket(TicketMovie ticket) throws SQLException;
	public int updateTicket(TicketMovie ticket) throws SQLException;
	public int deleteTicket(TicketMovie ticket) throws SQLException;
}
