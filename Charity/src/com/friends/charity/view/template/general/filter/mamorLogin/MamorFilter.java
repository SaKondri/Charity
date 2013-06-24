package com.friends.charity.view.template.general.filter.mamorLogin;

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

@WebFilter(urlPatterns = "/pages/mamorTahghigh/*")
public class MamorFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig config;
	private LoginService service;

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Login login;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		login = (Login) req.getSession().getAttribute("mamorLogin");
		if (login == null) {
			resp.sendRedirect(req.getContextPath() + "/pages/home.xhtml");
		} else if (login != null) {
			long id = login.getId();
			long check = getService().selectfromId(id);
			if (id != check) {
				resp.sendRedirect(req.getContextPath() + "/pages/home.xhtml");
				return;
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	public LoginService getService() {
		if (service == null) {
			service = new LoginService();
		}
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}

}
