package Models;

import java.time.LocalDateTime;

public class Reserva {
    public Pessoa pessoa;
    public Livro livro;
    public LocalDateTime horaIni;
    public LocalDateTime horaFim;
    private int numReservas;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(LocalDateTime horaIni) {
        this.horaIni = horaIni;
    }

    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    public int getNumReservas() {
        return numReservas;
    }

    private void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }
}
