package Sample.General;

public enum Role {
    USER("Usuario","Ler;Editar"),
    ADMIN("Admin","Ler;Edtirar;Deletar;Criar"),
    OWNER("Proprietario","Ler; Cria; Promover"),
    TEMP("Temporario","Ler"),
    READ ("Visitante", "Ler com restrições");

    String nome;
    String permissoes;

    Role(String nome, String permissoes){
        this.nome = nome;
        this.permissoes = permissoes;
    }
}
