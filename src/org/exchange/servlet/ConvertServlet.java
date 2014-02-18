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
		StringBuilder str = new StringBuilder();
		
		countResultStr(results, df, str);
		
		getCurrencyNamesStr(names, results, str);
		
		getRateOfUahStr(rateOfUAH, results, str);
		
		response.setContentType("text/html");
		response.getWriter().println(str);

		System.out.println(str);
	}

	private void getRateOfUahStr(ArrayList<Double> rateOfUAH,
			ArrayList<Double> results, StringBuilder str) {
		for (int i=0; i<results.size()-1;i++) {
			str.append(rateOfUAH.get(i));
			str.append("|");
		}
	}

	private void getCurrencyNamesStr(ArrayList<String> names,
			ArrayList<Double> results, StringBuilder str) {
		for (int i=0; i<results.size()-1;i++) {
			str.append(names.get(i));
			str.append("|");
		}
	}

	private void countResultStr(ArrayList<Double> results, DecimalFormat df,
			StringBuilder str) {
		for (int i=0; i<results.size()-1;i++) {
			str.append(df.format(results.get(i)));
			str.append("|");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
