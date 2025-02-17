package com.jspiders.cardekho_with_servletsandjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity;
import com.jspiders.cardekho_with_servletsandjsp.jdbc.CarJDBC;

@WebServlet("/edit_car")
public class EditCar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	CarJDBC carJDBC=new CarJDBC();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CarEntity car = carJDBC.getCarById(id);
		req.setAttribute("car", car);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("update_car.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	

}
