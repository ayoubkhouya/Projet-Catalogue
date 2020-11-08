package fr.cataloge.servlets;

import fr.catalogue.beans.CategorieBean;
import fr.catalogue.ejb.CatalogueRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet("/categorie")
public class CategoriesServlet extends HttpServlet {

	private static final long serialVersionUID = -8349070857739843763L;

	public CategoriesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //request.getRequestDispatcher("/pages/categorie.jsp").forward(request, response);


        // TODO Auto-generated method stub
        HttpSession session = request.getSession(true);
        String type = request.getParameter("type");
        CategorieBean categorieBean = null;

        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String appName = "CatalogueEAR";
            final String moduleName = "CatalogueWebEJB";
            final String beanName = "CatalogueJNDI";
            final String viewClassName = CatalogueRemote.class.getName();
            CatalogueRemote remote =
                    (CatalogueRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
            categorieBean = remote.getCategory("dvd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("categorie", categorieBean.getName());
        response.sendRedirect("/pages/categorie.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
