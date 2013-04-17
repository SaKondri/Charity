package com.friends.charity.business.service.model;

import java.util.HashMap;
import java.util.Map;

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

	public Login getCorrectUsername(String username) throws Exception {
		Login login = null;
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		login = getGeneralService().select("selectUsernamePassword", params);
		return login;
	}

	public Login getLoginTest(String username, String password)
			throws Exception {
		Login login;
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		login = getGeneralService().select("loginTest", params);
		return login;
	}

	public long selectfromId(long id) {
		Login login = null;
		login = getGeneralService().select("byId", id);
		return login.getId();
	}

}
