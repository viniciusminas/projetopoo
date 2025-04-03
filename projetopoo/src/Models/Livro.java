package Models;

public class Livro {
    private boolean reservado;
    public String  titulo;
    public String  subtitulo;
    public String  autor;
    public int     ano;
    public int     edicao;

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isReservado() {
        return reservado;
    }

    private void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void reservar() {
        if (!this.reservado) {
            setReservado(true);
            return;
        }


    }

}
