package com.friends.charity.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.business.service.model.LoginService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.Login;
import com.friends.charity.model.User;
import com.friends.charity.model.UsernamePassword;
import com.friends.charity.view.template.general.menu.right.about.TariekhcheShow;

@WebListener
public class TL implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	//	new TariekhcheShow();
		
	}


}
