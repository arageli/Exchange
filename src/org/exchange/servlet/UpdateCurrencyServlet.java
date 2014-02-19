package org.exchange.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exchange.dao.DataAccess;
import org.exchange.utils.Downloader;
import org.exchange.utils.XmlParser;

public class UpdateCurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCurrencyServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("updateCurrencyRates");
		System.out.println(answer);
		
		Downloader downloader = new Downloader();
		XmlParser xmlParser = new XmlParser();
		DataAccess data = new DataAccess();
		
		boolean updateCurrencyRates = false;
		if (request.getParameter("updateCurrencyRates").equals("Update")) {
			updateCurrencyRates = true;
		}
		
		String url = "http://resources.finance.ua/ua/public/currency-cash.xml";
		
		if (updateCurrencyRates == true) {
			File file = downloader.downloadFile(url);
			Map<String, String> rates = xmlParser.getRatesOfUah(file);
//			data.outputRates(rates);
			data.updateCurrencysList(rates);
			
		}
	}
}
