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
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

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

	@Override
	public int insertLiList(List<LevelInfo> liList) throws SQLException {
		String sql ="insert into level_info(lliNum, liLevel, liName, LiDesc)"; 
		sql +="values(seq_liNum.nextval,?,?,?)";//물음표 사용자한테 받을 값
		PreparedStatement ps = con.prepareStatement(sql);
		int cnt =0;
		for(LevelInfo li:liList) {
			ps.setInt(1, li.getLiLevel());
			ps.setString(2, li.getLiName());
			ps.setString(3, li.getLiDesc());
			cnt+= ps.executeUpdate();
			
		}
		ps.close();//정석은 트라이캣치까지 써주는게 정석
		return cnt;
	}

	@Override
	public int deleteLiList(int[] liNums) throws SQLException {
	
		return 0;
	}

	@Override
	public int updateLiList(List<LevelInfo> liList) throws SQLException {
		String sql ="update level_info"; 
		sql +="set liLevel=?,";
		sql +="liName=?,";
		sql +="liDesc=?,";
		sql +="where liNum=?,";
		//물음표 사용자한테 받을 값
		PreparedStatement ps = con.prepareStatement(sql);
		int cnt =0;
		for(LevelInfo li:liList) {
			ps.setInt(1, li.getLiLevel());
			ps.setString(2, li.getLiName());
			ps.setString(3, li.getLiDesc());
			ps.setInt(4, li.getLiNum());
			cnt+= ps.executeUpdate();
			
		}
		ps.close();//정석은 트라이캣치까지 써주는게 정석
		return cnt;
		
	}
}
