package cotroller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerRequestDto;
import customer.controller.CustomerDao;

public class JoinAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// join.jsp input type=hidden 들고오게됨 )
		
		String code = request.getParameter("cuscode");
		int cuscode = 1;
		if(code != null) {
			cuscode = Integer.parseInt(code);
			String cusname = request.getParameter("cusname");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			int age = Integer.parseInt(request.getParameter("age"));
			String joindate = request.getParameter("joindate");
			
			CustomerRequestDto customerDto = new CustomerRequestDto(cuscode, cusname, contact, email, id, password, age, joindate);
			CustomerDao customerDao = CustomerDao.getInstacne();
			customerDao.createCustomer(customerDto);
			
			response.sendRedirect("/");
		}
	}
}
