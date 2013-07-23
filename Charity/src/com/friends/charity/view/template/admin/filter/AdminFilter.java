package com.friends.charity.view.template.admin.filter;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friends.charity.business.logic.Utils;
@WebFilter(urlPatterns = "/admin/")
@Named
public class AdminFilter implements Filter{
	@SuppressWarnings("unused")
	private FilterConfig filterConfig;
	private boolean isSessionAdmin;
	
	@Override
	public void destroy() {
		this.filterConfig =null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("admin") == null){
			
			req.getRequestDispatcher("/pages/home.xhtml").forward(req, resp);
			setSessionAdmin(false);
		}
		if(Utils.getSession("admin") != null){
			setSessionAdmin(true);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}
	public boolean isSessionAdmin() {
		return isSessionAdmin;
	}
	public void setSessionAdmin(boolean isSessionAdmin) {
		this.isSessionAdmin = isSessionAdmin;
	}
	
}
