package in.co.rays.project0.ctl;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Main Controller performs session checking and logging operations before
 * calling any application controller. It prevents any user to access
 * application without loginersion 1.0 Copyright (c) Facade
 */
public class FrontCtl extends HandlerInterceptorAdapter 
{
	@Autowired
   private MessageSource messSource; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
	  HttpSession session = request.getSession();
	  
	  if(session.getAttribute("user")==null)
	  {
		  Locale locale=null;
		  
		  String msg = messSource.getMessage("message.session", null, locale);
		  request.setAttribute("error", msg);
		  String str = request.getRequestURI();
		  request.setAttribute("uri", str);
		  RequestDispatcher rd = request.getRequestDispatcher("/Login");
          rd.forward(request, response);
          return false;
	  }
		return true;
	}
}

