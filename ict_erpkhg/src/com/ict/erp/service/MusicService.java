package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MusicChart;

public interface MusicService {
	public List<MusicChart> selectMusicList(MusicChart mc) throws SQLException;
	public MusicChart selectMusic(MusicChart mc) throws SQLException;
	public Map<String, Object> insertMusic(MusicChart mc) throws SQLException;
	public Map<String, Object> updateMusic(MusicChart mc) throws SQLException;
	public Map<String, Object> deleteMusic(MusicChart mc) throws SQLException;
}
