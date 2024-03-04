package web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ImetierCatalogue;
import metier.MetierImpl;
import metier.Medecin;
@WebServlet (name="cs",urlPatterns= {"/controleur"})
public class ControleurServlet extends HttpServlet {
private ImetierCatalogue metier;
@Override
public void init() throws ServletException {
metier=new MetierImpl();
}
@Override
protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	String mc=request.getParameter("motCle");
	MedecinModele mod = new MedecinModele();
	mod.setMotCle(mc);
	List<Medecin> Medecins = metier.getMedecinsParMotCle(mc);
	mod.setMedecins(Medecins);
	request.setAttribute("modele", mod);
	request.getRequestDispatcher("MedecinsView.jsp").forward(request,response);
	}
}