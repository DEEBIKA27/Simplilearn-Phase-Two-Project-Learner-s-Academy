package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadTeacherServlet
 */
@WebServlet("/read-teacher")
public class ReadTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Teacher> teachers = session.createQuery("from Teacher").list();

		out.print("<h1> Teachers List :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid blue;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Teacher Id</th>");
		out.print("<th> Teacher First Name</th>");
		out.print("<th> Teacher Last Name</th>");
		out.print("<th> Teacher Experience in years</th>");
		out.print("</tr>");

		for (Teacher teacher : teachers) {
			out.print("<tr>");
			out.print("<td>" + teacher.getId() + "</td>");
			out.print("<td>" + teacher.getFirstName() + "</td>");
			out.print("<td>" + teacher.getLastName() + "</td>");
			out.print("<td>" + teacher.getExperience() + "</td>");
			
			out.print("</tr>");
		}

		out.println("</table> </body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
