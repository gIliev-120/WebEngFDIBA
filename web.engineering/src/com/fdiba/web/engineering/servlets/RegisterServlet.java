package com.fdiba.web.engineering.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdiba.web.eng.model.UserModel;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String PERSISTANCE_UNIT_MAIN = "todos";
	private static EntityManagerFactory factory;

	public RegisterServlet() {
		super(); //call the parent constructor
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		//TODO HASH PASSWORD	
		UserModel user = new UserModel(req.getParameter("username"),req.getParameter("firstname"),req.getParameter("lastname"),password);
		
		factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_MAIN);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		Query q = em.createQuery("Select u from UserModel u");
		List<UserModel> result = q.getResultList();
		for(UserModel u : result) {
			System.out.println(u.toString());
		}
		
		em.close();
	}
	
	
	
	

	
}

//http://localhost:8080/web.engineering/register.html
