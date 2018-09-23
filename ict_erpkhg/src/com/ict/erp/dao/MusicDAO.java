package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicChart;

public interface MusicDAO extends CommonDAO{
	public List<MusicChart> selectMusicList(MusicChart mc) throws SQLException;
	public MusicChart selectMusic(MusicChart mc) throws SQLException;
	public int insertMusic(MusicChart mc) throws SQLException;
	public int updateMusic(MusicChart mc) throws SQLException;
	public int deleteMusic(MusicChart mc) throws SQLException;

}
