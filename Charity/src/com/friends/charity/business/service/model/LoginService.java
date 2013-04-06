package com.friends.charity.business.service.model;

import java.util.ArrayList;
import java.util.List;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.model.Login;

public class LoginService {
	private GeneralService generalService;

	private GeneralService getGeneralService() {
		if (generalService == null) {
			generalService = new GeneralService();
		}
		return generalService;
	}

	public List<Login> getCorrectUsername(String username) {
		List<Login> login = new ArrayList<>();
		login = getGeneralService().selectList("u", null);
		return login;
	}

}
