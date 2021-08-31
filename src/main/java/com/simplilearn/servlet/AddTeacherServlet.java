package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/add-teacher")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-teacher.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String experience = request.getParameter("experience");
		
		Teacher t = new Teacher();
		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setExperience(experience);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(t);

		tx.commit();
		PrintWriter out = response.getWriter();
		out.println("Teacher saved successfully");
	}

}
