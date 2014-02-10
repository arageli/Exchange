package org.exchange.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exchange.dao.DataAccess;
import org.exchange.entity.Currency;
import org.exchange.service.Converter;

public class ConvertServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3278467812448483146L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double amountToConvert = Double.parseDouble(request.getParameter("amount"));
		int id = Integer.parseInt(request.getParameter("currencyForExchange"));
		
		DataAccess data = null;
		String currencyName = "";
		ArrayList<Double> rateOfUAH = null;

			data = new DataAccess();
			currencyName = data.getCurrencyName(id);
			rateOfUAH = data.ratesOfUAH();

		Currency currency = new Currency(id, currencyName, rateOfUAH, amountToConvert);
		
		System.out.println(currency.getId() + " " + currency.getName() + " " + currency.getRateOfUAH().toString() + " " + currency.getAmount());
		
		ArrayList<Double> results = new ArrayList<Double>();
		Converter conv = new Converter();
		
		results = conv.calculate(currency);
		System.out.println(results.toString());
		
		request.setAttribute("rateOfUAH", rateOfUAH);
		request.setAttribute("currency", currency);
		request.setAttribute("results", results);
		
		String url = "/result.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
}
