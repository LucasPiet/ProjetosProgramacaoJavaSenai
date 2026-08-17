package br.com.senai.controller;

import br.com.senai.model.Amigo;
import br.com.senai.model.AmigoDAO;

import java.sql.SQLException;
import java.util.List;

public class AmigoController {
    private final AmigoDAO AMIGO_DAO;

    public AmigoController(AmigoDAO AMIGO_DAO) {
        this.AMIGO_DAO = AMIGO_DAO;
    }

    public void cadastrarAmigo(Amigo amigo) throws SQLException {
        if (AMIGO_DAO.create(amigo)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o cadastro!");
        }
    }

    public void listarAmigos() throws SQLException {
        List<Amigo> amigos = AMIGO_DAO.read();
        if (amigos.isEmpty()) {
            System.out.println("Nenhum registro encontrado!");
        } else {
            System.out.println("Lista de amigos:");
            for (Amigo amigoTemp : amigos) {
                System.out.println(amigoTemp);
            }
        }
    }

    public void atualizarAmigo(Amigo amigo) throws SQLException {
        if (AMIGO_DAO.update(amigo)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao realizar a atualização!");
        }
    }

    public void excluirAmigo(Integer id) throws SQLException {
        if (AMIGO_DAO.delete(id)){
            System.out.println("Exclusão realizada com sucesso!");
        } else {
            System.out.println("Erro ao realizar a exclusão!");
        }
    }
    public void dethalarAmigo(Integer id) throws SQLException {
        List<Amigo> amigos = AMIGO_DAO.detalharAmigo(id);
        if (amigos.isEmpty()) {
            System.out.println("Nenhum registro encontrado!");
        } else {
            System.out.println("amigos:"+id);

            }
        }
    }
