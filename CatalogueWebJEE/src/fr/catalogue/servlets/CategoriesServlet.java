package fr.catalogue.servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.catalogue.beans.Categorie;
import fr.catalogue.global.AppContext;
import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

@WebServlet("/categorie")
public class CategoriesServlet extends HttpServlet {

	private static final long serialVersionUID = -8349070857739843763L;

	public CategoriesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
        HttpSession session = request.getSession(true);
        List<Categorie> categories = null;
        Categorie categorie = null;

        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String viewClassName = CategorieRemote.class.getName();

            CategorieRemote remote =
                    (CategorieRemote) context.lookup("ejb:"+ AppContext.appName +"/"+ AppContext.moduleName +"/"+ AppContext.beanName +"!" + viewClassName);

            categories = remote.getAllCategories();

        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("categories", categories);
        response.sendRedirect("/pages/categorie.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
