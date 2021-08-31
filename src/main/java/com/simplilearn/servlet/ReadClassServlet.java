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

import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadClass
 */
@WebServlet("/read-class")
public class ReadClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Classes> classes = session.createQuery("from Classes").list();

		out.print("<h1> Classes List :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid blue;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Section</th>");
		out.print("<th> Subject Name</th>");
		out.print("<th> Teacher Name</th>");
		out.print("</tr>");

		for (Classes c : classes) {
			out.print("<tr>");
			out.print("<td>" + c.getSection() + "</td>");
			out.print("<td>" + c.getSubjectName() + "</td>");
			out.print("<td>" + c.getTeacherName() + "</td>");
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
