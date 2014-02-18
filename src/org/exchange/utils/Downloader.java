package org.exchange.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Downloader {
	
	private String fileName = "currencyRate";

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Downloader() {
	}

	public File downloadFile(String url) throws IOException {
		
		String dir = "D:/trainingWorkspace/Exchange/WebContent/resources/CurrencyRate/";
		System.out.println("Start download");
		BufferedInputStream inputStream = null;
		FileOutputStream outputFile = null;

		File file = null;

		if (file == null) {
			file = new File(dir + fileName + ".xml");
		}
		
		inputStream = new BufferedInputStream(new URL(url).openStream());
		
		outputFile = new FileOutputStream(file);

		byte data[] = new byte[1024];
		int count;

		while ((count = inputStream.read(data, 0, 1024)) != -1) {
			outputFile.write(data, 0, count);
		}
		
		outputFile.flush();
		outputFile.close();
		System.out.println("Finish download");
		return file;
		}
	}

