package com.friends.charity.view.template.admin.filter;

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
@WebFilter(urlPatterns = "/admin/")
public class AdminFilter implements Filter{
	@SuppressWarnings("unused")
	private FilterConfig filterConfig;
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
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}

}
