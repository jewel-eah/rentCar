package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.Customer;
import customer.controller.CustomerDao;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("log") != null) { 
			session.removeAttribute("log");
			response.sendRedirect("/");
		}
		else {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			System.out.println("id" + id);
			System.out.println("password" + password);
			CustomerDao customerDao = CustomerDao.getInstacne();
			Customer customer = customerDao.getCustomerById(id);
			
			if (customer != null && password.equals(customer.getPassword())) {
				session = request.getSession();
				session.setAttribute("log", customer);
				response.sendRedirect("/");
			}
			else {
				response.sendRedirect("login");
			}
		}
	}
}
