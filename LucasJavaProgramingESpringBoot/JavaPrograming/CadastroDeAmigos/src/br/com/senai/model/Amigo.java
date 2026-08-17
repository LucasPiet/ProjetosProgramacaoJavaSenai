package br.com.senai.model;

import java.sql.Date;

public class Amigo {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private Date data_nascimento;
    private Genero genero;
    private boolean ativo;

    public Amigo (){

    }
    public Amigo(int id, String nome, String telefone) {
    }

    public Amigo(
            Integer id,
            String nome,
            String telefone,
            String email,
            Date data_nascimento,
            Genero genero,
            Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.ativo = ativo;
    }

    public Amigo(
            Integer id,
            String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    public String getTelefone() {

        return telefone;
    }

    public String getEmail() {

        return email;
    }

    public Date getData_nascimento() {

        return data_nascimento;
    }

    public Genero getGenero() {

        return genero;
    }

    public boolean getAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "Amigo: " + id +
                "\n Nome: " + nome +
                "\n Telefone: " + telefone +
                "\n Email: " + email +
                "\n Aniversário: " + data_nascimento.toString() +
                "\n Gênero: " + genero.name() + "\n" +
                "\n Ativo: " + ativo;
    }
}