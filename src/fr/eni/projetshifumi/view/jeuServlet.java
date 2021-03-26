package fr.eni.projetshifumi.view;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jeuServlet
 */
@WebServlet("/jeuServlet")
public class jeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jeuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.getRequestDispatcher("/WebContent/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Random random = new Random();
		int aleatoire = random.nextInt(3);
		String valeur = null;
	  String choice = request.getParameter("bouton");
		 String message = null;
	    
		switch(aleatoire) {
		case 0:
			valeur = "pierre";
			break;
		case 1:
			valeur = "feuille";
			break;
		case 2:
			valeur = "ciseaux";
			break;
			
		}
		System.out.println(aleatoire);
		 System.out.println("Ordi" +valeur);
		 System.out.println("Moi" +choice);
		// pierre
		if("pierre".equals(choice) && valeur.equals("pierre"))  {
			message = "egalite";
			}
		else if ("pierre".equals(choice) && valeur.equals("feuille"))  {
		    message = "defaite";
			}
		else  {
				message = "victoire";
			}
		// feuille
		 if("feuille".equals(choice) && valeur.equals("feuille"))  {
			 message = "egalite";
				}
		 else if("feuille".equals(choice) && valeur.equals("ciseaux"))  {
			 message = "defaite";
				}
		 else {
			 message = "victoire";
				}
		// ciseaux
	     if("ciseaux".equals(choice) && valeur.equals("ciseaux"))  {
	    	 message = "egalite";
				}
	     else if ("ciseaux".equals(choice) && valeur.equals("pierre"))  {
	    	 message = "defaite";
				}
	     else  {
	    	 message = "victoire";	
				}
		
		request.setAttribute("choiceUser", choice);
		request.setAttribute("choiceIA", valeur);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/resultat.jsp");
		rd.forward(request, response);
	}
	
}
