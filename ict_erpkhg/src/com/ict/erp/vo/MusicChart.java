package com.ict.erp.vo;

public class MusicChart {
	private Long mcNum;
	private String mcName;
	private String mcSinger;
	private String mcVendor;
	private Long mcLike;
	private Long mcDislike;
	private String mcCredat;
	private String mcDesc;

	private PageInfo pi;

	public PageInfo getPi() {
		return pi;
	}

	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	// private String[] tests;

	// public String[] getTests() {
	// return tests;
	// }
	// public void setTests(String[] tests) {
	// this.tests = tests;
	// }
	public MusicChart() {
	}

	public MusicChart(Long mcNum, String mcName, String mcSinger, String mcVendor, Long mcLike, Long mcDislike,
			String mcCredat, String mcDesc) {
		super();
		this.mcNum = mcNum;
		this.mcName = mcName;
		this.mcSinger = mcSinger;
		this.mcVendor = mcVendor;
		this.mcLike = mcLike;
		this.mcDislike = mcDislike;
		this.mcCredat = mcCredat;
		this.mcDesc = mcDesc;
	}

	public Long getMcNum() {
		return mcNum;
	}

	public void setMcNum(Long mcNum) {
		this.mcNum = mcNum;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getMcSinger() {
		return mcSinger;
	}

	public void setMcSinger(String mcSinger) {
		this.mcSinger = mcSinger;
	}

	public String getMcVendor() {
		return mcVendor;
	}

	public void setMcVendor(String mcVendor) {
		this.mcVendor = mcVendor;
	}

	public Long getMcLike() {
		return mcLike;
	}

	public void setMcLike(Long mcLike) {
		this.mcLike = mcLike;
	}

	public Long getMcDislike() {
		return mcDislike;
	}

	public void setMcDislike(Long mcDislike) {
		this.mcDislike = mcDislike;
	}

	public String getMcCredat() {
		return mcCredat;
	}

	public void setMcCredat(String mcCredat) {
		this.mcCredat = mcCredat;
	}

	public String getMcDesc() {
		return mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	@Override
	public String toString() {
		return "MusicChart [mcNum=" + mcNum + ", mcName=" + mcName + ", mcSinger=" + mcSinger + ", mcVendor=" + mcVendor
				+ ", mcLike=" + mcLike + ", mcDislike=" + mcDislike + ", mcCredat=" + mcCredat + ", mcDesc=" + mcDesc
				+ "]";
	}

	// + ", tests=" + Arrays.toString(tests)

}
