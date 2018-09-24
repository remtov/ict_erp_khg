package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MusicChart;

public class MusicDAOImpl extends CommonDAOImpl implements MusicDAO {

	@Override
	public List<MusicChart> selectMcList(MusicChart mc) throws SQLException {
		String sql = "select mc.* from MUSIC_CHART mc";
		List<MusicChart> mcList = new ArrayList<MusicChart>();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MusicChart mc2 = new MusicChart();
				mc2.setMcNum(rs.getLong("mcNum"));
				mc2.setMcName(rs.getString("mcName"));
				mc2.setMcSinger(rs.getString("mcSinger"));
				mc2.setMcVendor(rs.getString("mcVendor"));
				mc2.setMcLike(rs.getLong("mcLike"));
				mc2.setMcDislike(rs.getLong("mcDislike"));
				mc2.setMcCredat(rs.getString("mcCredat"));
				mc2.setMcDesc(rs.getString("mcDesc"));

				mcList.add(mc2);
			}
			return mcList;

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int insertMc(MusicChart mc) throws SQLException {
		String sql = "insert into music_chart(MCNUM,MCNAME,MCSINGER,MCVENDOR,MCLIKE,MCDISLIKE,MCCREDAT,MCDESC) values(seq_MCNUM.nextval,?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mc.getMcName());
			ps.setString(2, mc.getMcSinger());
			ps.setString(3, mc.getMcVendor());
			ps.setLong(4, mc.getMcLike());
			ps.setLong(5, mc.getMcDislike());
			ps.setString(6, mc.getMcCredat());
			ps.setString(7, mc.getMcDesc());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public int updateMc(MusicChart mc) throws SQLException {
		String sql = "UPDATE music_chart SET MCNAME=?,MCSINGER=?,MCVENDOR=?,\r\n"
				+ "MCLIKE=?,MCDISLIKE=?,MCCREDAT=?,MCDESC=? WHERE MCNUM=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mc.getMcName());
			ps.setString(2, mc.getMcSinger());
			ps.setString(3, mc.getMcVendor());
			ps.setLong(4, mc.getMcLike());
			ps.setLong(5, mc.getMcDislike());
			ps.setString(6, mc.getMcCredat());
			ps.setString(7, mc.getMcDesc());
			ps.setLong(8, mc.getMcNum());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public int deleteMc(MusicChart mc) throws SQLException {
		String sql = "delete from music_chart where mcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mc.getMcNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public MusicChart selectMusicChart(MusicChart mc) throws SQLException {
		String sql = "select mc.* from MUSIC_CHART mc where mcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mc.getMcNum());

			rs = ps.executeQuery();
			while (rs.next()) {
				MusicChart mc2 = new MusicChart();
				mc2.setMcNum(rs.getLong("mcNum"));
				mc2.setMcName(rs.getString("mcName"));
				mc2.setMcSinger(rs.getString("mcSinger"));
				mc2.setMcVendor(rs.getString("mcVendor"));
				mc2.setMcLike(rs.getLong("mcLike"));
				mc2.setMcDislike(rs.getLong("mcDislike"));
				mc2.setMcCredat(rs.getString("mcCredat"));
				mc2.setMcDesc(rs.getString("mcDesc"));
				return mc2;
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
		return null;
	}

}

/*
 * private static String SELECT_MUSIC_LIST =
 * "select * from music_chart"; @Override public List<MusicChart>
 * selectMusicList(MusicChart mc) throws SQLException { try { ps =
 * con.prepareStatement(SELECT_MUSIC_LIST); rs = ps.executeQuery(); return
 * IBean.convertList(rs, MusicChart.class); } catch (SQLException e) { throw e;
 * } finally { close(); }
 * 
 * }
 * 
 * @Override public MusicChart selectMusic(MusicChart mc) throws SQLException {
 * String sql = "select * from music_chart mc where mcNum=?";
 * 
 * try { ps = con.prepareStatement(sql); ps.setInt(1, mc.getMcNum()); rs =
 * ps.executeQuery();
 * 
 * if (rs.next()) { MusicChart mc1 = new MusicChart();
 * mc1.setMcNum(rs.getInt("mcNum")); mc1.setMcName(rs.getString("mcName"));
 * mc1.setMcSinger(rs.getString("mcSinger"));
 * mc1.setMcVendor(rs.getString("mcVendor"));
 * mc1.setMcLike(rs.getInt("mcLike")); mc1.setMcDislike(rs.getInt("mcDislike"));
 * mc1.setMcCredat(rs.getString("mcCredat"));
 * mc1.setMcDesc(rs.getString("mcDesc")); return mc1; }
 * 
 * } catch (SQLException e) { throw e; } finally { close(); } return null; }
 * 
 * @Override public int insertMusic(MusicChart mc) throws SQLException { String
 * sql =
 * "insert into music_Chart (MCNUM, MCNAME, MCSINGER, MCVENDOR, MCLIKE, MCDISLIKE, MCCREDAT, MCDESC) values(seq_mcNum.nextval,?,?,?,?,?,?,?)"
 * ; try { ps = con.prepareStatement(sql); ps.setString(1, mc.getMcName());
 * ps.setString(2, mc.getMcSinger()); ps.setString(3, mc.getMcVendor());
 * ps.setInt(4, mc.getMcLike()); ps.setInt(5, mc.getMcDislike());
 * ps.setString(6, mc.getMcCredat()); ps.setString(7, mc.getMcDesc());
 * 
 * return ps.executeUpdate(); } catch (SQLException e) { throw e; } finally {
 * close(); } }
 * 
 * @Override public int updateMusic(MusicChart mc) throws SQLException { String
 * sql = "update\r\n" + "    MUSIC_CHART\r\n" + "set\r\n" + "    MCNAME=?,\r\n"
 * + "    MCSINGER=?,\r\n" + "    MCVENDOR=?,\r\n" + "    MCLIKE=?,\r\n" +
 * "    MCDISLIKE=?,\r\n" + "    MCCREDAT=?,\r\n" + "    MCDESC=?\r\n" +
 * "where\r\n" + "    MCNUM=?;\r\n" + ""; try { ps = con.prepareStatement(sql);
 * ps.setString(1, mc.getMcName()); ps.setString(2, mc.getMcSinger());
 * ps.setString(3, mc.getMcVendor()); ps.setLong(4, mc.getMcLike());
 * ps.setLong(5, mc.getMcDislike()); ps.setString(6, mc.getMcCredat());
 * ps.setString(7, mc.getMcDesc()); ps.setLong(8, mc.getMcNum());
 * 
 * return ps.executeUpdate(); } catch (SQLException e) { throw e; } finally {
 * close(); } }
 * 
 * @Override public int deleteMusic(MusicChart mc) throws SQLException { String
 * sql = "delete from music_chart where mcNum=?"; try { ps =
 * con.prepareStatement(sql); ps.setLong(1, mc.getMcNum()); return
 * ps.executeUpdate(); } catch (SQLException e) { throw e; } finally { close();
 * } }
 * 
 * }
 */