package fr.catalogue.global;

public enum EnumEJB {

    PRODUITEJB("ProduitEJB"),
    CATEGORIEEJB(""),
    COMMANDEEJB(""),
    PANIER("PanierEJB"),
    CLIENTEJB("ClientEJB");

    private final String ejbName;

    EnumEJB(String ejbName) {
        this.ejbName = ejbName;
    }

    public String getEjbName() {
        return this.ejbName;
    }
}
