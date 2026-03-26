package com;

import com.domain.cliente.Cliente;
import com.domain.cliente.ClienteDAO;
import com.domain.livro.Categoria;
import com.domain.livro.Livro;
import com.domain.livro.LivroDAO;
import com.exception.RegraDeNegocioException;

import java.util.List;
import java.util.Scanner;


public class BookFlowApplication {

    private static final Scanner leitor = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        int opcao = exibirMenu();

        while (opcao != 13){
            try{
                switch (opcao){
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        cadastrarLivro();
                        break;
                    case 3:
                        listarLivros();
                        break;
                    case 4:
                        listarLivrosDisponiveis();
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
                        break;
                    case 13:
                        System.out.println("[Encerrando programa...]");
                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("[Clique ENTER para voltar ao menu...]");
                leitor.next();
            }
            opcao = exibirMenu();
        }

    }

    private static int exibirMenu() {
        System.out.println("__________________________________");
        System.out.println("|"+" ".repeat(32)+"|");
        System.out.println("|            BookFlow            |");
        System.out.println("|--------------------------------|");
        System.out.println("| Digite a opção desejada:       |");
        System.out.println("|                                |");
        System.out.println("| 1 - Cadastrar cliente          |");
        System.out.println("| 2 - Cadastrar livro            |");
        System.out.println("| 3 - Listar livros              |");
        System.out.println("| 4 - Listar livros disponíveis  |");
        System.out.println("| 5 - Buscar cliente             |");
        System.out.println("| 6 - Buscar livro               |");
        System.out.println("| 7 - Editar livro               |");
        System.out.println("| 8 - Editar cliente             |");
        System.out.println("| 9 - Deletar livro              |");
        System.out.println("| 10 - Deletar cliente           |");
        System.out.println("| 11 - Emprestar livro           |");
        System.out.println("| 12 - Pagar multa               |");
        System.out.println("| 13 - Encerrar programa         |");
        System.out.println("|--------------------------------|");

        return leitor.nextInt();

    }

    private static void cadastrarCliente(){
        System.out.println("|--------------------------------|");
        System.out.println("|       Cadastrar Cliente        |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Nome: ");
        String nome = leitor.next();
        System.out.print("| * E-mail: ");
        String email = leitor.next();
        System.out.println("|--------------------------------|");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);

        ClienteDAO dao = new ClienteDAO();
        dao.salvar(cliente);

        System.out.println("\n[Novo cliente cadastrado com sucesso!!]\n");

    }
    private static void cadastrarLivro(){
        System.out.println("|--------------------------------|");
        System.out.println("|        Cadastrar Livro         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Título: ");
        String titulo = leitor.next();
        System.out.print("| * Autor: ");
        String autor = leitor.next();
        System.out.print("| * Ano: ");
        int ano = leitor.nextInt();
        System.out.println("| - Lista:");
        exibirMenuCategorias();
        System.out.print("| * Nº da categoria: ");
        int categoria = leitor.nextInt();
        System.out.println("|--------------------------------|");

        Categoria categoriaLivro;
        switch (categoria){
            case 1:
                categoriaLivro = Categoria.TERROR;
                break;
            case 2:
                categoriaLivro = Categoria.ROMANCE;
                break;
            case 3:
                categoriaLivro = Categoria.AVENTURA;
                break;
            case 4:
                categoriaLivro = Categoria.FICCAO;
                break;
            case 5:
                categoriaLivro = Categoria.COMEDIA;
                break;
            case 6:
                categoriaLivro = Categoria.TEOLOGICO;
                break;
            case 7:
                categoriaLivro = Categoria.TECNICO;
                break;
            default:
                throw new RegraDeNegocioException("[Número da categoria inválido!]");
        }

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(ano);
        livro.setDisponivel(true);
        livro.setCategoria(categoriaLivro);

        LivroDAO dao = new LivroDAO();
        dao.salvar(livro);

        System.out.println("\n[Novo livro cadastrado com sucesso!!]\n");

    }

    private static void exibirMenuCategorias() {
        System.out.println("|             |----Categorias----|");
        System.out.println("|             | 1 - TERROR       |");
        System.out.println("|             | 2 - ROMANCE      |");
        System.out.println("|             | 3 - AVENTURA     |");
        System.out.println("|             | 4 - FICCAO       |");
        System.out.println("|             | 5 - COMEDIA      |");
        System.out.println("|             | 6 - TEOLOGICO    |");
        System.out.println("|             | 7 - TECNICO      |");
        System.out.println("|             |------------------|");

    }

    private static void listarLivros(){

        LivroDAO dao = new LivroDAO();
        List<Livro> listaLivros = dao.listarTodos(Livro.class);

        System.out.println("|--------------------------------|");
        System.out.println("|        Lista de Livros         |");
        System.out.println("|--------------------------------|");

        listaLivros.forEach(System.out::println);

    }
    private static void listarLivrosDisponiveis(){
        LivroDAO dao = new LivroDAO();
        List<Livro> listaLivrosDisponiveis = dao.listarLivrosDisponiveis();

        System.out.println("|--------------------------------|");
        System.out.println("|       Livros Disponíveis       |");
        System.out.println("|--------------------------------|");

        listaLivrosDisponiveis.forEach(System.out::println);

    }
    private static void buscarCliente(){

    }
    private static void buscarLivro(){

    }
    private static void editarLivro(){

    }
    private static void editarCliente(){

    }
    private static void deletarLivro(){

    }
    private static void deletarCliente(){

    }
    private static void emprestarLivro(){

    }
    private static void pagarMulta(){

    }
}
