package fr.catalogue.global;

public enum EnumEJB {

    PRODUITEJB("ProduitEJB"),
    CATEGORIEEJB(""),
    COMMANDEEJB("");

    private final String ejbName;

    EnumEJB(String ejbName) {
        this.ejbName = ejbName;
    }

    public String getEjbName() {
        return this.ejbName;
    }
}
