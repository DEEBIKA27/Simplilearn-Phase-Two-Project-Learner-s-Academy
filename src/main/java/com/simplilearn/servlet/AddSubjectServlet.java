package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-subject.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String shortCut = request.getParameter("shortCut");
		
		
		Subject sub = new Subject();
		sub.setName(name);
		sub.setShortCut(shortCut);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(sub);

		tx.commit();
		PrintWriter out = response.getWriter();
		out.println("Subject saved successfully");
	}

}
