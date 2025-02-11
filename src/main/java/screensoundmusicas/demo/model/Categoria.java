package screensoundmusicas.demo.model;

public enum Categoria {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String categoria;

    Categoria(String categoria){this.categoria = categoria;}

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
