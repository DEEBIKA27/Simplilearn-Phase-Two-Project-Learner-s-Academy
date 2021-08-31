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

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-student")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudentServlet() {
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
		List<Student> students = session.createQuery("from Student").list();

		out.print("<h1> Student List :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid blue;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Student Id</th>");
		out.print("<th> Student First Name</th>");
		out.print("<th> Student Last Name</th>");
		out.print("<th> Student Mail ID</th>");
		out.print("</tr>");

		for (Student student : students) {
			out.print("<tr>");
			out.print("<td>" + student.getId() + "</td>");
			out.print("<td>" + student.getFirstName() + "</td>");
			out.print("<td>" + student.getLastName() + "</td>");
			out.print("<td>" + student.getEmail() + "</td>");
			
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
