package org.exchange.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exchange.utils.Downloader;


public class DownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2125993471814833386L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		
		Downloader downloader = new Downloader();
		File file = downloader.downloadFile(url);
		
		request.setAttribute("file", file);
		
		String downloadComplete = "/downloadComplete.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(downloadComplete);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			 
		doPost(request, response);
	}
	
}
