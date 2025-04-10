package com.example.biblioteca.model;
import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 20, unique = true)
    private String tel;
    @Column(nullable = false, length = 200)
    private String endereco;


    public Pessoa(String nome, String email, String tel, String endereco) {
        this.nome = nome;
        this.email = email;
        this.tel = tel;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toSpring(){
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", endereco=" + endereco +
                '}';
    }
}
