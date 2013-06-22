package com.friends.charity.model;

public enum NiazMotaghazii {
	ETC("غیره"), MASKAN("مسکن"), BIMARI("بیماری"), JAHIZIYEH("جهیزیه"), KASREHKHARJ(
			"کسر خرج"), VAM("وام");

	private String type;

	private NiazMotaghazii(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
