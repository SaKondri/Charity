package com.friends.charity.test;

import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.kheyrieConf.Address;

public class Main {

	public static void main(String[] args) throws Exception {
		Address address = new Address();
		address.setKheyriehAdr("slfjksljJ");
		GeneralDao.getGeneralDao().save(address);
	}
}