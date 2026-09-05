package br.com.senai.cadastroamigos.Amigo;

public class Amigo {
    private Integer id;
    private String nome;
    private String telfone;
    private String email;


    public Amigo() {
    }

    public Amigo(Integer id, String nome, String telfone, String email) {
        this.id = id;
        this.nome = nome;
        this.telfone = telfone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelfone() {
        return telfone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telfone='" + telfone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
