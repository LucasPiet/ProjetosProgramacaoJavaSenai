package br.com.senai.view;

import br.com.senai.controller.AmigoController;
import br.com.senai.driver.MySQLConnect;
import br.com.senai.model.Amigo;
import br.com.senai.model.AmigoDAO;
import br.com.senai.model.Genero;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class AmigoView {
    public static void mostrarMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        MySQLConnect dbConnect = new MySQLConnect();
        if (!dbConnect.openConnect()) {
            System.out.println("O sistema não está conecatado com o banco de dados!");
            return;
        }
        AmigoDAO amigoDAO = new AmigoDAO(dbConnect);
        AmigoController amigoController = new AmigoController(amigoDAO);

        while (true) {
            System.out.println("Cadastro de Amigos");
            System.out.println("Menu:");
            System.out.println("0 - Sair do Programa");
            System.out.println("1 - Cadastrar Amigo");
            System.out.println("2 - Listar Amigos");
            System.out.println("3 - Detalhar amigo");
            System.out.println("4 - Atualizar Dados");
            System.out.println("5 - Excluir Amigo");

            System.out.println("Digite sua opção:");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 0 -> {
                    System.out.println("Programa finalizado!");
                    dbConnect.closeConnect();
                    sc.close();
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("Informe o nome do amigo:");
                    String nome = sc.nextLine();

                    System.out.println("Informe o telefone do amigo:");
                    String telefone = sc.nextLine();

                    System.out.println("Informe o email do amigo:");
                    String email = sc.next();
                    sc.nextLine();

                    System.out.println("Informe a data de nascimento do amigo: (yyyy-MM-dd)");
                    Date dataNascimento = Date.valueOf(sc.next());
                    sc.nextLine();

                    System.out.println("Informe o gênero do amigo: (MASCULINO/FEMININO)");
                    Genero genero = Genero.valueOf(sc.next().toUpperCase());
                    sc.nextLine();

                    Amigo amigo = new Amigo(null, nome, telefone, email, dataNascimento, genero,true);
                    amigoController.cadastrarAmigo(amigo);
                }
                case 2 -> amigoController.listarAmigos();
                case 3 -> {
                    System.out.println("Digite o id do amigo que desejas ver");
                    Integer id = sc.nextInt();
                    amigoController.dethalarAmigo(id);
                }
                case 4 -> {
                    System.out.println("Informe o id do amigo que deseja atualizar:");
                    Integer id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Atualize o nome do amigo:");
                    String nome = sc.nextLine();

                    System.out.println("Atualize o telefone do amigo:");
                    String telefone = sc.nextLine();

                    System.out.println("Atualize o email do amigo:");
                    String email = sc.next();
                    sc.nextLine();

                    System.out.println("Atualize a data de nascimento do amigo: (yyyy-MM-dd)");
                    Date dataNascimento = Date.valueOf(sc.next());
                    sc.nextLine();

                    System.out.println("Atualize o gênero do amigo: (MASCULINO/FEMININO)");
                    Genero genero = Genero.valueOf(sc.next().toUpperCase());
                    sc.nextLine();

                    Amigo amigo = new Amigo(id, nome, telefone, email, dataNascimento, genero,true);
                    amigoController.atualizarAmigo(amigo);
                }
                case 5 -> {
                    System.out.println("Informe o id do amigo que deseja excluir:");
                    Integer id = sc.nextInt();
                    sc.nextLine();

                    amigoController.excluirAmigo(id);
                }
            }
        }
    }
}