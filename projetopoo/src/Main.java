import Models.Livro;

public class Main {
    public static void main(String[] args) {
        Livro l = new Livro();
        l.titulo = "Rápido e Devagar";
        l.subtitulo = "Duas formas de pensar";
        l.autor = "Daniel Keneman";
        l.edicao = 1;
        l.ano = 2012;


        System.out.println("Livro: " + l.titulo);

    }
}