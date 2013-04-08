package com.friends.charity.business.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public Login getCorrectUsername(String username) {
		Login login = null;
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		login = getGeneralService().select("selectUsernamePassword", params);
		return login;
	}

}
