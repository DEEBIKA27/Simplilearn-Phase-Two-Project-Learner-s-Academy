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

import com.simplilearn.entity.ClassReport;
import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadClassReportServlet
 */
@WebServlet("/view-report")
public class ReadClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadClassReportServlet() {
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
		List<ClassReport> reports = session.createQuery("from ClassReport").list();

		out.print("<h1> Class Report :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid blue;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Serial No</th>");
		out.print("<th> Section</th>");
		out.print("<th> Name of the student</th>");
		out.print("<th> Name of the teacher</th>");
		out.print("<th> Name of the subject</th>");
		out.print("</tr>");

		for (ClassReport report : reports) {
			out.print("<tr>");
			out.print("<td>" + report.getSerNo() + "</td>");
			out.print("<td>" + report.getSection() + "</td>");
			out.print("<td>" + report.getStudentName() + "</td>");
			out.print("<td>" + report.getTeacherName() + "</td>");
			out.print("<td>" + report.getSubjectName() + "</td>");
			
			
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
