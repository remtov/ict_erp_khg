package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicChart;

public interface MusicService {
	public List<MusicChart> selectMusicList(MusicChart music) throws SQLException;
	public MusicChart selectMusic(MusicChart music) throws SQLException;
	public int insertMusic(MusicChart music) throws SQLException;
	public int updateMusic(MusicChart music) throws SQLException;
	public int deleteMusic(MusicChart music) throws SQLException;
}
