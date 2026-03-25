package com;

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
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static int exibirMenu() {
    }
}
