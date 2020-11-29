package fr.catalogue.global;


import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import java.rmi.Naming;
import java.util.Hashtable;

public class AppContext {

    public static final String appName = "CatalogueEAR";
    public static final String moduleName = "CatalogueEJB";
    public static final String beanName = "CatalogueJNDI";

    public static CategorieRemote getCategorieRemote() {
        // Categorie Remote
        CategorieRemote remote = null;
        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String viewClassName = CategorieRemote.class.getName();

            remote = (CategorieRemote) context.lookup("ejb:"+ AppContext.appName +"/"+ AppContext.moduleName +"/"+ AppContext.beanName +"!" + viewClassName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return remote;
    }

    public static Object getRemote(Class<?> cls) {
        Object remote = null;
        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String viewClassName = cls.getName();

            remote = context.lookup("ejb:"+ AppContext.appName +"/"+ AppContext.moduleName +"/ProduitEJB!" + viewClassName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return remote;
    }
}
