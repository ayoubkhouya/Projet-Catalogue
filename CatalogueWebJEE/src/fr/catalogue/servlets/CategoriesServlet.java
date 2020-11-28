package fr.catalogue.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.catalogue.interfaces.CategorieMethodes;
import fr.catalogue.beans.Categorie;
import fr.catalogue.global.AppContext;
import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet implements CategorieMethodes {

	private static final long serialVersionUID = -8349070857739843763L;

    private CategorieRemote categorieRemote;

	public CategoriesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Session
        HttpSession session = request.getSession(true);

        Map<String, String[]> mapParams = request.getParameterMap();

        if (mapParams.isEmpty()) {
            List<Categorie> categories = getCategories();
            session.setAttribute("categories", categories);
            request.getRequestDispatcher("/pages/categorie.jsp").forward(request, response);
        }
        if (mapParams.containsKey("id")) {
            Categorie categorie = getCategorieById(Integer.parseInt(mapParams.get("id")[0]));
            session.setAttribute("categorie", categorie);
            request.getRequestDispatcher("/pages/categorie.jsp").forward(request, response);
        }
        if (mapParams.containsKey("name")) {
            Categorie categorie = getCategorieByName(mapParams.get("name")[0]);
            session.setAttribute("categorie", categorie);
            request.getRequestDispatcher("/pages/categorie.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public List<Categorie> getCategories() {
        categorieRemote = AppContext.getCategorieRemote();
        return categorieRemote.getAllCategories();
    }

    @Override
    public Categorie getCategorieById(int id) {
        categorieRemote = AppContext.getCategorieRemote();
        return categorieRemote.getCategoryById(id);
    }

    @Override
    public Categorie getCategorieByName(String name) {
        categorieRemote = AppContext.getCategorieRemote();
        return categorieRemote.getCategoryByName(name);
    }
}
