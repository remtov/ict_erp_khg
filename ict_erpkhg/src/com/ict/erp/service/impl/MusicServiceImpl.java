package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicChart;

public class MusicServiceImpl implements MusicService {
	private MusicDAO mdao = new MusicDAOImpl();

	@Override
	public List<MusicChart> selectMusicList(MusicChart mc) throws SQLException {
		try {
			mdao.setConnection(DBCon.getCon());
			return mdao.selectMusicList(mc);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	}

	@Override
	public MusicChart selectMusic(MusicChart mc) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMusic(mc);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertMusic(MusicChart mc) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.insertMusic(mc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "노래 등록 실패");
			if(cnt==1) {
				rMap.put("msg", "노래 등록 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> updateMusic(MusicChart mc) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.updateMusic(mc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "노래 수정 실패");
			if(cnt==1) {
				rMap.put("msg", "노래 수정 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteMusic(MusicChart mc) throws SQLException {
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.deleteMusic(mc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "노래 삭제 실패");
			if(cnt==1) {
				rMap.put("msg", "노래 삭제 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
