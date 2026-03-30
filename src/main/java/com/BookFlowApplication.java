package com;

import com.domain.cliente.Cliente;
import com.domain.cliente.ClienteDAO;
import com.domain.emprestimo.Emprestimo;
import com.domain.emprestimo.EmprestimoDAO;
import com.domain.livro.Categoria;
import com.domain.livro.Livro;
import com.domain.livro.LivroDAO;
import com.exception.RegraDeNegocioException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;


public class BookFlowApplication {

    private static final Scanner leitor = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        int opcao = exibirMenu();

        while (opcao != 16){
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
                        buscarCliente();
                        break;
                    case 6:
                        buscarLivro();
                        break;
                    case 7:
                        editarLivro();
                        break;
                    case 8:
                        editarCliente();
                        break;
                    case 9:
                        deletarLivro();
                        break;
                    case 10:
                        deletarCliente();
                        break;
                    case 11:
                        emprestarLivro();
                        break;
                    case 12:
                        devolverLivro();
                        break;
                    case 13:
                        renovarLivro();
                        break;
                    case 14:
                        listarClientes();
                        break;
                    case 15:
                        listarEmprestimos();
                        break;
                    case 16:
                        System.out.println("[Encerrando programa...]");
                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("\nErro: " + e.getMessage() + "\n");
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
        System.out.println("| 12 - Devolver livro            |");
        System.out.println("| 13 - Renovar emprestimo        |");
        System.out.println("| 14 - Listar clientes           |");
        System.out.println("| 15 - Listar emprestimos        |");
        System.out.println("| 16 - Encerrar programa         |");
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
        cliente.setAtivo(true);

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
        livro.setAtivo(true);
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

        System.out.println("|--------------------------------|");
        System.out.println("|         Buscar Cliente         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do cliente: ");
        Long id = leitor.nextLong();

        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.buscarPorId(Cliente.class, id);

        EmprestimoDAO empDAO = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimoCliente = empDAO.listarEmprestimosPorCliente(cliente);

        System.out.println("|--------------------------------|");
        System.out.println("|          Dados Cliente         |");
        System.out.println("|--------------------------------|");
        System.out.println(cliente);

        System.out.println("|      Histórico Empréstimos     |");
        System.out.println("|--------------------------------|");
        if (!listaEmprestimoCliente.isEmpty()){
            listaEmprestimoCliente.forEach(System.out::println);
        }else {
            System.out.println("| [Não possuí empréstimos]       |");
        }

    }
    private static void buscarLivro(){

        System.out.println("|--------------------------------|");
        System.out.println("|          Buscar Livro          |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long id = leitor.nextLong();

        LivroDAO dao = new LivroDAO();
        Livro livro = dao.buscarPorId(Livro.class, id);

        System.out.println("|--------------------------------|");
        System.out.println("|           Dados Livro          |");
        System.out.println("|--------------------------------|");
        System.out.println(livro);

    }
    private static void editarLivro(){

        System.out.println("|--------------------------------|");
        System.out.println("|          Buscar Livro          |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long id = leitor.nextLong();

        LivroDAO dao = new LivroDAO();
        Livro livro = dao.buscarPorId(Livro.class, id);

        if (livro == null){
            throw new RegraDeNegocioException("[Livro com ID desejado não encontrado!]");
        }

        System.out.println("|--------------------------------|");
        System.out.println("|          Editar Livro          |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Título: ");
        String titulo = leitor.next();
        System.out.print("| * Autor: ");
        String autor = leitor.next();
        System.out.print("| * Ano: ");
        int ano = leitor.nextInt();
        System.out.print("| * Ativo(s/n): ");
        boolean ativo = (leitor.next().equalsIgnoreCase("s"));
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

        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(ano);
        livro.setCategoria(categoriaLivro);
        livro.setAtivo(ativo);

        dao.atualizar(livro);

        System.out.println("\n[Livro editado com sucesso!!]\n");

    }
    private static void editarCliente(){

        System.out.println("|--------------------------------|");
        System.out.println("|         Buscar Cliente         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do cliente: ");
        Long id = leitor.nextLong();

        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.buscarPorId(Cliente.class, id);

        if(cliente == null){
            throw new RegraDeNegocioException("[Não existe nenhum cliente com esse ID!]");
        }

        System.out.println("|--------------------------------|");
        System.out.println("|         Editar Cliente         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Nome: ");
        String nome = leitor.next();
        System.out.print("| * E-mail: ");
        String email = leitor.next();
        System.out.print("| * Ativo(s/n): ");
        boolean ativo = (leitor.next().equalsIgnoreCase("s"));
        System.out.println("|--------------------------------|");

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setAtivo(ativo);

        dao.atualizar(cliente);

        System.out.println("\n[Cliente editado com sucesso!!]\n");

    }
    private static void deletarLivro(){

        System.out.println("|--------------------------------|");
        System.out.println("|          Deletar Livro         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long id = leitor.nextLong();

        LivroDAO dao = new LivroDAO();
        Livro livro = dao.buscarPorId(Livro.class, id);

        if (livro == null){
            throw new RegraDeNegocioException("[Livro com ID desejado não encontrado!]");
        }
        System.out.println("| - Confirma a exclusão? (s/n)   |");
        String confirmacao = leitor.next().toLowerCase();

        if(confirmacao.equals("s")){
            livro.setAtivo(false);
            dao.atualizar(livro);
            System.out.println("[Livro deletado com sucesso!]");
        } else if (confirmacao.equals("n")) {
            System.out.println("[Exclusão cancelada pelo usuário!]");
        }else{
            throw new RegraDeNegocioException("[Digite uma letra válida!]");
        }

    }
    private static void deletarCliente(){

        System.out.println("|--------------------------------|");
        System.out.println("|         Deletar Cliente        |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do cliente: ");
        Long id = leitor.nextLong();

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarPorId(Cliente.class, id);

        if (cliente == null){
            throw new RegraDeNegocioException("[Cliente com ID desejado não encontrado!]");
        }
        System.out.println("| - Confirma a exclusão? (s/n)   |");
        String confirmacao = leitor.next().toLowerCase();

        if(confirmacao.equals("s")){
            cliente.setAtivo(false);
            cliDAO.atualizar(cliente);
            System.out.println("[Cliente deletado com sucesso!]");
        } else if (confirmacao.equals("n")) {
            System.out.println("[Exclusão cancelada pelo usuário!]");
        }else{
            throw new RegraDeNegocioException("[Digite uma letra válida!]");
        }

    }
    private static void emprestarLivro(){
        System.out.println("|--------------------------------|");
        System.out.println("|       Emprestimo de Livro      |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long livroId = leitor.nextLong();
        System.out.print("| * Digite o ID do cliente: ");
        Long clienteId = leitor.nextLong();

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.buscarPorId(Livro.class, livroId);

        if (livro == null){
            throw new RegraDeNegocioException("\n[O livro com ID desejado não existe!]\n");
        }

        if(!livro.isDisponivel()){
            throw new RegraDeNegocioException("\n[O Livro desejado não está disponível para empréstimo!]\n");
        }

        if (!livro.isAtivo()){
            throw new RegraDeNegocioException("\n[O livro está inativo no sistema, não é possível empresta-lo]\n");
        }

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorId(Cliente.class, clienteId);

        if (cliente == null){
            throw new RegraDeNegocioException("\n[Não existe nenhum cliente com esse ID!]\n");
        }

        if (!cliente.isAtivo()){
            throw new RegraDeNegocioException("\n[O cliente está inativo no sistema, não é possivel utiliza-lo]\n");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setCliente(cliente);
        emprestimo.setDataInicioEmprestimo(LocalDate.now());
        emprestimo.setMultaPaga(false);
        emprestimo.setAtivo(true);
        emprestimo.setDataFinalEmprestimo(emprestimo.getDataInicioEmprestimo().plusMonths(3));

        EmprestimoDAO empreDAO = new EmprestimoDAO();
        empreDAO.salvar(emprestimo);
        livro.setDisponivel(false);
        livroDAO.atualizar(livro);

        System.out.println("\n[Novo emprestimo cadastrado com sucesso!!]\n");

    }

    public static void devolverLivro(){

        System.out.println("|--------------------------------|");
        System.out.println("|         Devolver Livro         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long livroId = leitor.nextLong();

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.buscarPorId(Livro.class, livroId);

        if (livro == null){
            throw new RegraDeNegocioException("[Não existe um livro com esse ID!]");
        }

        EmprestimoDAO empDAO = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimos = empDAO.listarEmprestimosPorLivroAtivos(livro);

        if (listaEmprestimos == null){
            throw new RegraDeNegocioException("[Não há nenhum emprestimo ativo com esse livro!]");
        }

        Emprestimo emprestimo = listaEmprestimos.get(0);

        double multa = calcMulta(emprestimo.getDataFinalEmprestimo());
        boolean prosseguir = true;

        if (multa > 0){
            System.out.printf("[O usuário deverá pagar uma multa de R$ %.2f reais, confirme o pagamento para prosseguir (s/n)]%n", multa);
            prosseguir = (leitor.next().equalsIgnoreCase("s"));
        }

        if (prosseguir){
            emprestimo.setAtivo(false);
            emprestimo.setMultaPaga((multa > 0));
            livro.setDisponivel(true);

            livroDAO.atualizar(livro);
            empDAO.atualizar(emprestimo);

            System.out.println("[Livro devolvido com sucesso]");

        }



    }

    private static double calcMulta(LocalDate diaFinalEmprestimo){
        LocalDate dataHoje = LocalDate.now();
       if(dataHoje.isAfter(diaFinalEmprestimo)){
           long dias = ChronoUnit.DAYS.between(diaFinalEmprestimo, dataHoje);
           return dias * 0.5;
       }
        return 0;
    }

    private static void listarClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = dao.listarTodos(Cliente.class);

        System.out.println("|--------------------------------|");
        System.out.println("|       Lista de Clientes        |");
        System.out.println("|--------------------------------|");

        listaClientes.forEach(System.out::println);
    }

    private static void renovarLivro(){
        System.out.println("|--------------------------------|");
        System.out.println("|          Renovar Livro         |");
        System.out.println("|--------------------------------|");
        System.out.print("| * Digite o ID do livro: ");
        Long livroId = leitor.nextLong();

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.buscarPorId(Livro.class, livroId);

        if (livro == null){
            throw new RegraDeNegocioException("[Não existe um livro com esse ID!]");
        }

        EmprestimoDAO empDAO = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimos = empDAO.listarEmprestimosPorLivroAtivos(livro);

        if (listaEmprestimos == null){
            throw new RegraDeNegocioException("[Não há nenhum emprestimo ativo com esse livro!]");
        }

        Emprestimo emprestimo = listaEmprestimos.get(0);

        double multa = calcMulta(emprestimo.getDataFinalEmprestimo());
        boolean prosseguir = true;

        if (multa > 0){
            System.out.printf("[O usuário deverá pagar uma multa de R$ %.2f reais, confirme o pagamento para prosseguir (s/n)]%n", multa);
            prosseguir = (leitor.next().equalsIgnoreCase("s"));
        }

        if (prosseguir){
            emprestimo.setMultaPaga((multa > 0));
            emprestimo.setDataFinalEmprestimo(LocalDate.now().plusMonths(3));

            empDAO.atualizar(emprestimo);

            System.out.println("[Empréstimo renovado com sucesso]");

        }
    }

    private static void listarEmprestimos() {

        EmprestimoDAO dao = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimos = dao.listarTodos(Emprestimo.class);

        System.out.println("|--------------------------------|");
        System.out.println("|      Lista de Emprestimos      |");
        System.out.println("|--------------------------------|");

        listaEmprestimos.forEach(System.out::println);

    }
}
