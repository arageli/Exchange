package org.exchange.utils;

import java.io.IOException;

import org.exchange.dao.DataAccess;

public class TestDownload {

	public static void main(String[] args) throws IOException {

		String url = "http://resources.finance.ua/ua/public/currency-cash.xml";
		Downloader downloader = new Downloader();
		downloader.downloadFile(url);
		
		DataAccess data = new DataAccess();
		//data.outputRates();
	}
}
