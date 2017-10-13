package com.accenture.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.service.FibonacciSequence;
import com.accenture.service.impl.FibonacciSequenceImpl;

/**
 * Servlet implementation class FibonacciServlet
 */

public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FibonacciServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		/*
		 * out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		 * "Transitional//EN\">\n" + "<HTML>\n" +
		 * "<HEAD><TITLE>Febonacci Sequence</TITLE></HEAD>\n" + "<BODY>\n" +
		 * "<H1>Fibonacci Sequence:</H1>\n" + "</BODY></HTML>");
		 */
		String fibonacciLength = request.getParameter("fibonaccilength");
		long fibolength = 0;
		String errorInfo = null;
		try {
			fibolength = Long.parseLong(fibonacciLength);
			FibonacciSequence fibo = new FibonacciSequenceImpl();
			List<Long> fibolist = fibo.fibonacci(fibolength);
			//request.setAttribute("fibolist",fibolist);
			session.setAttribute("fibolist", fibolist);
			response.sendRedirect("FibonacciResult.jsp");
		} catch (Exception e) {
		errorInfo=e.getMessage();
		session.removeAttribute("fibolist");
		session.setAttribute("errorInfo", errorInfo);
		 response.sendRedirect("FibonacciResult.jsp");
		}
		
	/*	FibonacciSequence fibo = new FibonacciSequenceImpl();
		List<Long> fibolist = fibo.fibonacci(fibolength);*/
		//session.setAttribute("FibonacciSequence", fibolist);
		// response.sendRedirect("FibonacciResult.jsp?errorinfo="+errorInfo);
		/*RequestDispatcher rd = request.getRequestDispatcher("FibonacciResult.jsp");
		rd.forward(request, response);*/

		/*
		 * out.println("<ul></ul>"); for (int i = 0; i < fibolist.size(); i++) {
		 * out.println("<li>"); out.println(fibolist.get(i));
		 * out.println("</li>"); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
