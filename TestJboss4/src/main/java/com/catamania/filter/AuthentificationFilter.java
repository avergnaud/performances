package com.catamania.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthentificationFilter implements Filter {

	public void destroy() {	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession(false);
		String seConnecteURI = request.getContextPath() + "/index.jsp";
		
		String usr = (String) request.getParameter("user");
		String pwd = (String) request.getParameter("pwd");
		
		/* authentification */
		boolean seConnecte = request.getRequestURI().equals(seConnecteURI)
					&& "idValide".equals(usr)
					&& "mdpValide".equals(pwd);
		
		/* identification */
		Boolean estConnecte = Boolean.FALSE;
		if(session != null) {			
			estConnecte = (Boolean) session.getAttribute("AUTH_OK");
		}
		
		if(seConnecte) {
			/* authentification */
			session.setAttribute("AUTH_OK", Boolean.TRUE);
			chain.doFilter(arg0, arg1);;
		} else if(estConnecte != null && estConnecte) {
			/* identification */
			chain.doFilter(arg0, arg1);
		} else {
			response.sendRedirect(request.getContextPath() + "/authent/login.jsp");
		}

	}

	public void init(FilterConfig arg0) throws ServletException { }

}
