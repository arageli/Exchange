package org.exchange.utils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParserTest {
	
	public static void main(String[] args) {	
		try {
			Map<String, String> rateOfUAh = new LinkedHashMap<String, String>();
			String filePath = "D:/trainingWorkspace/Exchange/WebContent/resources/CurrencyRate/currencyRate.xml";
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			String nameOfBank = "CityCommerceBank";
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("organization");
			
			System.out.println("----------------------------");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elementOrganization = (Element) nNode;
					Element elementTitle = (Element) elementOrganization.getFirstChild();
					
					String currentBank = elementTitle.getAttribute("value");
					if (currentBank.equals(nameOfBank)) {
						Element elementCurrencies = (Element) elementOrganization.getLastChild();
						NodeList listOfRates = elementCurrencies.getChildNodes();
						System.out.println(listOfRates.getLength());
						
							for (int i=0; i<listOfRates.getLength(); i++) {
								Node rateNode = listOfRates.item(i);
								if (rateNode.getNodeType() == Node.ELEMENT_NODE) {
									Element elementC = (Element) rateNode;
									if (elementC.getAttribute("id").equals("USD")) {
										rateOfUAh.put(elementC.getAttribute("id"), elementC.getAttribute("br"));
									} else if (elementC.getAttribute("id").equals("EUR")) {
										rateOfUAh.put(elementC.getAttribute("id"), elementC.getAttribute("br"));
									}  else if (elementC.getAttribute("id").equals("RUB")) {
										rateOfUAh.put(elementC.getAttribute("id"), elementC.getAttribute("br"));
									}
								}
							}
							System.out.println(rateOfUAh.toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}