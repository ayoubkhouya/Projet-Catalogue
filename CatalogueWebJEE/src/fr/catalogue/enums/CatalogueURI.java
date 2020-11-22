package fr.catalogue.enums;

public enum CatalogueURI {

    INDEX("/home");

    private String uri;

    CatalogueURI(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
