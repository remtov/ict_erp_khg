package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LevelDAO;
import com.ict.erp.vo.LevelInfo;

public class LevelDAOImpl implements LevelDAO{

	@Override
	public List<LevelInfo> selectLiList(LevelInfo li) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select liNum, liLevel, liName, liDesc from Level_Info";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<LevelInfo> liList = new ArrayList<LevelInfo>();
		while(rs.next()) {
			li = new LevelInfo(rs.getInt("liNum"), rs.getInt("liLevel"),rs.getString("liName"), rs.getString("liDesc"));
			liList.add(li);
		}
		DBCon.close();
		return liList;
	}
}
