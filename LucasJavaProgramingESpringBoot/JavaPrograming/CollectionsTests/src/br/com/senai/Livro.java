package br.com.senai;

public class Livro {
    private String titulo;
    private String autor;
    private long codigo;

    public Livro() {

    }

    public Livro(long codigo,String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setAutor(String autor) {

        this.autor = autor;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public void setCodigo(long codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\n" +" " +
                "codigo= " + codigo+" - " +
                "autor= " + autor + " - "+
                "titulo= " + titulo

                ;
    }
}


