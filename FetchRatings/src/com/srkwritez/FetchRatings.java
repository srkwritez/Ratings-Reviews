package com.srkwritez;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class FetchRatings
 */
@WebServlet("/FetchRatings")
public class FetchRatings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchRatings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("Received");
		//Send_HTTP_Request2 postman = new Send_HTTP_Request2();
		try
		{
		String responseString=Postman.callAPI();
		
		JSONObject jsonResponse = new JSONObject(responseString);
		//JSONObject review = jsonResponse.getJSONObject("Results");
		
		out.println("Rating : "+jsonResponse.getString("Results"));
		
		}
		catch(Exception e)
		{
			out.println(e);
		}
		finally
		{
			out.println("API call Completed");
		}
		
		
		
		
	}

}
