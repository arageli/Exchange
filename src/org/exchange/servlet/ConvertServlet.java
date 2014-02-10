package org.exchange.servlet;

import java.io.IOException;

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
		double currencyRate = 0;
		switch (id) {
		case 1:
			data = new DataAccess();
			currencyName = data.getCurrencyName(id);
			currencyRate = data.getCurrencyRate(id);
			break;
		case 2:
			data = new DataAccess();
			currencyName = data.getCurrencyName(id);
			currencyRate = data.getCurrencyRate(id);
			break;
		case 3:
			data = new DataAccess();
			currencyName = data.getCurrencyName(id);
			currencyRate = data.getCurrencyRate(id);
			break;
		case 4:
			data = new DataAccess();
			currencyName = data.getCurrencyName(id);
			currencyRate = data.getCurrencyRate(id);
			break;
		}
		
		Currency currency = new Currency(id, currencyName, currencyRate, amountToConvert);
		double result;	
		Converter conv = new Converter();
		result = conv.calculate(currency);
		
		request.setAttribute("currency", currency);
		request.setAttribute("result", result);
		
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
