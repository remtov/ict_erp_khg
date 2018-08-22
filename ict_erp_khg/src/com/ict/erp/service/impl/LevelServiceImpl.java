package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.dao.LevelDAO;
import com.ict.erp.dao.impl.LevelDAOImpl;
import com.ict.erp.service.LevelService;
import com.ict.erp.vo.LevelInfo;

public class LevelServiceImpl implements LevelService{
	private LevelDAO ldao = new LevelDAOImpl();
	@Override
	public List<LevelInfo> getLiList(LevelInfo li) throws SQLException {
		// TODO Auto-generated method stub
		return ldao.selectLiList(li);
	}

	public static void main(String[] args) {
		LevelService ls = new LevelServiceImpl();
		try {
			ls.getLiList(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
