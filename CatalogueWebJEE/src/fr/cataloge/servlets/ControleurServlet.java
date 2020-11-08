package fr.cataloge.servlets;

import fr.cataloge.enums.CatalogueURI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ShopController",
        urlPatterns = {"home"})
public class ControleurServlet extends HttpServlet {

    private static final long serialVersionUID = 4214547814660559772L;

    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals(CatalogueURI.INDEX.getUri())) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
