package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MusicChart;

public interface MusicDAO extends CommonDAO {
	List<MusicChart> selectMcList(MusicChart mc) throws SQLException;

	public MusicChart selectMusicChart(MusicChart mc) throws SQLException;

	public int insertMc(MusicChart mc) throws SQLException;

	public int updateMc(MusicChart mc) throws SQLException;

	public int deleteMc(MusicChart mc) throws SQLException;


}
