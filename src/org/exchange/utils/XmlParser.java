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

public class XmlParser {

	private Map<String, String> rateOfUAh;

	public Map<String, String> getRatesOfUah(File file) {
		try {
			rateOfUAh = new LinkedHashMap<String, String>();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
		//	String nameOfBank = "ªÂÐÎ";
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("organization");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elementOrganization = (Element) nNode;
			//		if (currentBank.equals(nameOfBank)) {
						Element elementCurrencies = (Element) elementOrganization
								.getLastChild();
						NodeList listOfRates = elementCurrencies
								.getChildNodes();

						for (int i = 0; i < listOfRates.getLength(); i++) {
							Node rateNode = listOfRates.item(i);
							if (rateNode.getNodeType() == Node.ELEMENT_NODE) {
								Element elementC = (Element) rateNode;
								
								if (elementC.getAttribute("id").equals("USD")) {
									rateOfUAh.put(elementC.getAttribute("id"),
											elementC.getAttribute("br"));
								} else if (elementC.getAttribute("id").equals(
										"EUR")) {
									rateOfUAh.put(elementC.getAttribute("id"),
											elementC.getAttribute("br"));
								} else if (elementC.getAttribute("id").equals(
										"RUB")) {
									rateOfUAh.put(elementC.getAttribute("id"),
											elementC.getAttribute("br"));
								}
							}
						}
					//}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rateOfUAh;
	}

}
