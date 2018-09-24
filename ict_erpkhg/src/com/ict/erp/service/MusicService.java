package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MusicChart;

public interface MusicService {
	public List<MusicChart> selectMcList(MusicChart mc) throws SQLException;

	public MusicChart selectMc(MusicChart mc) throws SQLException;

	public Map<String, Object> insertMc(MusicChart mc) throws SQLException;

	public Map<String, Object> updateMc(MusicChart mc) throws SQLException;

	public Map<String, Object> deleteMc(MusicChart mc) throws SQLException;
}
