package br.com.senai;

public class Email {
    private String endereco;

    public Email() {
    }

    public Email(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Email{" +
                "endereco='" + endereco + '\'' +
                '}';
    }
}
