package com.jspiders.cardekho_with_servletsandjsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity;
import com.jspiders.cardekho_with_servletsandjsp.jdbc.CarJDBC;
@WebServlet("/search_cars")
public class SearchAllCars extends HttpServlet {
	 CarJDBC carJDBC=new CarJDBC();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CarEntity> cars = carJDBC.getAllCars();
		req.setAttribute("cars", cars);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("search_cars.jsp");
		requestDispatcher.forward(req, resp);
	}

}
