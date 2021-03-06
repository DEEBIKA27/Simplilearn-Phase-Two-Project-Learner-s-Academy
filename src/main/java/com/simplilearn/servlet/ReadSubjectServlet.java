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

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadSubjectServlet
 */
@WebServlet("/read-subject")
public class ReadSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadSubjectServlet() {
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
		List<Subject> subjects = session.createQuery("from Subject").list();

		out.print("<h1> Subjects List :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid blue;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Serial No</th>");
		out.print("<th> Name</th>");
		out.print("<th> Shortcut</th>");
		out.print("</tr>");

		for (Subject subject : subjects) {
			out.print("<tr>");
			out.print("<td>" + subject.getSerNo() + "</td>");
			out.print("<td>" + subject.getName() + "</td>");
			out.print("<td>" + subject.getShortCut() + "</td>");
			
			
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
