package com.friends.charity.view.template.general.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friends.charity.business.service.model.LoginService;
import com.friends.charity.model.Login;

@WebFilter(urlPatterns = "/pages/private/*")
public class LoginFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig filterConfig;
	private LoginService loginService;

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long result;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Login login = (Login) req.getSession().getAttribute("login");
		if (login == null) {
			resp.sendRedirect(req.getContextPath() + "/pages/home.xhtml");
		} else if (login != null) {
			long id = login.getId();
			result = getLoginService().selectfromId(id);
			if (id != result) {
				resp.sendRedirect(req.getContextPath() + "/pages/home.xhtml");
				return;
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public LoginService getLoginService() {
		if (loginService == null) {
			loginService = new LoginService();
		}
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
