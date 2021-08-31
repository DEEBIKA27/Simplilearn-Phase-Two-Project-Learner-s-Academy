package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Classes;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/add-class")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-class.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName = request.getParameter("subjectName");
		String teacherName = request.getParameter("teacherName");
		
		
		Classes c = new Classes();
		c.setSubjectName(subjectName);
		c.setTeacherName(teacherName);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(c);

		tx.commit();
		PrintWriter out = response.getWriter();
		out.println("Class saved successfully");
	}

}
