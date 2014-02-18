package org.exchange.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		double amountToConvert = Double.parseDouble(request.getParameter("amount"));
		
		DataAccess data = null;
		ArrayList<String> names = null;
		ArrayList<Double> rateOfUAH = null;

		data = new DataAccess();
		names = data.getCurrencyNames();

		rateOfUAH = data.ratesOfUAH();
		Currency currency = new Currency(names, rateOfUAH, amountToConvert);
		ArrayList<Double> results = new ArrayList<Double>();

		Converter conv = new Converter();
		results = conv.calculate(currency);
		DecimalFormat df = new DecimalFormat();
		
		
		
		String resultUSD = df.format(results.get(0));
		String resultEU = df.format(results.get(1));
		String resultRUB = df.format(results.get(2));
		
		StringBuilder str = new StringBuilder();
		str.append(resultUSD);
		str.append("|");
		str.append(resultEU);
		str.append("|");
		str.append(resultRUB);
		str.append("|");
		str.append(names.get(0));
		str.append("|");
		str.append(names.get(1));
		str.append("|");
		str.append(names.get(2));
		str.append("|");
		str.append(rateOfUAH.get(0));
		str.append("|");
		str.append(rateOfUAH.get(1));
		str.append("|");
		str.append(rateOfUAH.get(2));
		
		response.setContentType("text/html");
		response.getWriter().println(str);

		System.out.println(str);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
