package screensoundmusicas.demo.model;

public enum Tipo {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String categoria;

    Tipo(String categoria){this.categoria = categoria;}

    public static Tipo fromString(String text) {
        for (Tipo categoria : Tipo.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma tipo encontrada para a string fornecida: " + text);
    }
}
