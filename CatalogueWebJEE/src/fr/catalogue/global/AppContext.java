package fr.catalogue.global;


import fr.catalogue.ejb.interfaces.remote.CategorieRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
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

    public static Object getRemote(Class<?> cls, String module) {
        Object remote = null;
        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String viewClassName = cls.getName();

            remote = context.lookup("ejb:"+ AppContext.appName +"/"+ AppContext.moduleName +"/" + module + "!" + viewClassName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return remote;
    }

    public static long getRandomNoConfirmation() {
        // longeur de 10
        String plage = "0123456789";
        StringBuilder noConf = new StringBuilder(10);

        for (int i = 0; i < 10; i ++) {
            int index = (int) (plage.length() * Math.random());
            noConf.append(plage.charAt(index));
        }

        return Long.parseLong(String.valueOf(noConf));
    }
}
