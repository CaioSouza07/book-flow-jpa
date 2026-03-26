package com;

import com.domain.cliente.ClienteDAO;
import com.domain.livro.Livro;
import com.domain.livro.LivroDAO;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    private static Scanner leitor = new Scanner(System.in);

    public static void main( String[] args ) {

        int opcao = exibirMenu();

        while (opcao != 10){
            try{
               switch (opcao){
                   case 1:
                       // cadastrar um livro
               }

            } catch (RegraDeNegocio e){
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Clique ENTER para voltar ao menu...");
                leitor.next();
            }
            opcao = exibirMenu();
        }
        
    }

    private static int exibirMenu() {
    }
}
