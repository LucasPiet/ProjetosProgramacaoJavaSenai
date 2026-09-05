package br.com.senai.cadastroamigos.Amigo;

public record DadosDetalhamentoAmigo (
        Integer id,
        String nome,
        String telefone,
        String email
)
{
    public DadosDetalhamentoAmigo (Amigo amigo){
        this(
                amigo.getId(),
                amigo.getNome(),
                amigo.getEmail(),
                amigo.getTelfone()
        );
}
}
