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

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-student.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = request.getParameterValues(id);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student s = new Student();
		s.setFirstName(firstName);
		s.setLastName(lastName);
		//s.setId(id);
		s.setEmail(email);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		//SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(s);

		tx.commit();
		PrintWriter out = response.getWriter();
		out.println("Student saved successfully");
	}

}
