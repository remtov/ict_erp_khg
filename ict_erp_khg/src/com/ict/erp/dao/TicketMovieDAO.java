package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;


import com.ict.erp.vo.TicketMovie;

public interface TicketMovieDAO extends CommonDAO{
	public List<TicketMovie> selectTicketMovieList(TicketMovie ticket) throws SQLException;
	public TicketMovie selectMusic(TicketMovie ticket) throws SQLException;
	public int insertMusic(TicketMovie ticket) throws SQLException;
	public int updateMusic(TicketMovie ticket) throws SQLException;
	public int deleteMusic(TicketMovie ticket) throws SQLException;

}