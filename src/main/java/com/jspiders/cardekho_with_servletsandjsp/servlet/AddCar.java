package com.jspiders.cardekho_with_servletsandjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekho_with_servletsandjsp.jdbc.CarJDBC;

@WebServlet("/add_car")
public class AddCar extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CarJDBC carJDBC = new CarJDBC();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("enterred in post method");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		System.out.println("before jdbc");
		int res = carJDBC.addCar(id, name, brand, price);
		System.out.println("after jdbc");
		if (res == 1) {
			req.setAttribute("message", "car added");
		} else {
			req.setAttribute("message", "car not added ");
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add_car.jsp");
		requestDispatcher.forward(req, resp);

	}

}
