package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.entity.ClassReport;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddClassrReportServlet
 */
@WebServlet("/update-report")
public class AddClassrReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassrReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("update-report.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String section = request.getParameter("section");
		String studentName = request.getParameter("studentName");
		String teacherName = request.getParameter("teacherName");
		String subjectName = request.getParameter("subjectName");
		
		
		ClassReport r = new ClassReport();
		r.setSection(section);
		r.setStudentName(studentName);
		r.setTeacherName(teacherName);
		r.setSubjectName(subjectName);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(r);

		tx.commit();
		PrintWriter out = response.getWriter();
		out.println("Report updated successfully");
	}

}
