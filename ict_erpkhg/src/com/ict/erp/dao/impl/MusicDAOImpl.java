package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.MusicChart;

public class MusicDAOImpl extends CommonDAOImpl implements MusicDAO {
	private static String SELECT_MUSIC_LIST = "select * from music_chart";

	@Override
	public List<MusicChart> selectMusicList(MusicChart mc) throws SQLException {
		try {
			ps = con.prepareStatement(SELECT_MUSIC_LIST);
			rs = ps.executeQuery();
			return IBean.convertList(rs, MusicChart.class);
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public MusicChart selectMusic(MusicChart mc) throws SQLException {
		String sql = "select * from music_chart mc where mcNum=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mc.getMcNum());
			rs = ps.executeQuery();

			if (rs.next()) {
				MusicChart mc1 = new MusicChart();
				mc1.setMcNum(rs.getInt("mcNum"));
				mc1.setMcName(rs.getString("mcName"));
				mc1.setMcSinger(rs.getString("mcSinger"));
				mc1.setMcVendor(rs.getString("mcVendor"));
				mc1.setMcLike(rs.getInt("mcLike"));
				mc1.setMcDislike(rs.getInt("mcDislike"));
				mc1.setMcCredat(rs.getString("mcCredat"));
				mc1.setMcDesc(rs.getString("mcDesc"));
				return mc1;
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
		return null;
	}

	@Override
	public int insertMusic(MusicChart mc) throws SQLException {
		String sql = "insert into music_Chart (MCNUM, MCNAME, MCSINGER, MCVENDOR, MCLIKE, MCDISLIKE, MCCREDAT, MCDESC) values(seq_mcNum.nextval,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mc.getMcName());
			ps.setString(2, mc.getMcSinger());
			ps.setString(3, mc.getMcVendor());
			ps.setInt(4, mc.getMcLike());
			ps.setInt(5, mc.getMcDislike());
			ps.setString(6, mc.getMcCredat());
			ps.setString(7, mc.getMcDesc());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int updateMusic(MusicChart mc) throws SQLException {
		String sql = "update\r\n" + "    MUSIC_CHART\r\n" + "set\r\n" + "    MCNAME=?,\r\n" + "    MCSINGER=?,\r\n"
				+ "    MCVENDOR=?,\r\n" + "    MCLIKE=?,\r\n" + "    MCDISLIKE=?,\r\n" + "    MCCREDAT=?,\r\n"
				+ "    MCDESC=?\r\n" + "where\r\n" + "    MCNUM=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mc.getMcName());
			ps.setString(2, mc.getMcSinger());
			ps.setString(3, mc.getMcVendor());
			ps.setInt(4, mc.getMcLike());
			ps.setInt(5, mc.getMcDislike());
			ps.setString(6, mc.getMcCredat());
			ps.setString(7, mc.getMcDesc());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteMusic(MusicChart mc) throws SQLException {
		String sql = "delete from music_chart where mcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mc.getMcNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

}
