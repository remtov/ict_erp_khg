package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;


import com.ict.erp.vo.TicketMovie;

public interface TicketDAO extends CommonDAO{
	public List<TicketMovie> selectTicketMovieList(TicketMovie ti) throws SQLException;
	public TicketMovie selectMovie(TicketMovie ti) throws SQLException;
	public int insertMovie(TicketMovie ti) throws SQLException;
	public int updateMovie(TicketMovie ti) throws SQLException;
	public int deleteMovie(TicketMovie ti) throws SQLException;

}