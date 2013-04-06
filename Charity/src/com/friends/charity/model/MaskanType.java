package com.friends.charity.model;

public enum MaskanType {
	NULL("--نوع مسکن را وارد کنید--"), SHAKHSI("شخصی"), ESTIJARI("استیجاری"), RAHN(
			"رهن");

	private String type;

	private MaskanType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}