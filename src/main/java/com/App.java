package com;

import com.domain.cliente.Cliente;
import com.domain.cliente.ClienteDAO;
import com.domain.livro.Livro;
import com.domain.livro.LivroDAO;

import java.util.Scanner;


public class App {

    private static Scanner leitor = new Scanner(System.in);

    public static void main( String[] args ) {

        int opcao = exibirMenu();

        while (opcao != 10){
            try{
                switch (opcao){
                    case 1:
                        // aqui vou cadastrar um cliente
                        break;
                    case 2:
                        // aqui vou cadastrar um livro
                        break;
                    case 3:
                        // aqui vou listar livros
                        break;
                    case 4:
                        // aqui vou listar os livros disponiveis
                        break;
                    case 5:
                        // aqui vou buscar o cliente pelo id
                        break;
                    case 6:
                        // aqui vou buscar o livro pelo id
                        break;
                    case 7:
                        // aqui vou editar o livro
                        break;
                    case 8:
                        // aqui vou editar o cliente
                        break;
                    case 9:
                        // aqui vou deletar um livro
                        break;
                    case 10:
                        // aqui vou deletar um cliente
                        break;
                    case 11:
                        // aqui vou emprestar um livro
                        break;
                    case 12:
                        // aqui vou pagar a multa
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static int exibirMenu() {
        return 1;
    }
}
