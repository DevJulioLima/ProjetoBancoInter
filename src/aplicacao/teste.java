package aplicacao;
/*
import entidades.ClientePf;
import entidades.Pessoa;
import repositorios.ClientePfMysqlRepositorio;
import servicos.ClientePfServico;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws Exception {
        LocalDate d1 = LocalDate.parse("1997-06-14");
        Scanner sc = new Scanner(System.in);
        ClientePf clientePf = new ClientePf();
        ClientePfServico clientePfServico = new ClientePfServico();
        ClientePfMysqlRepositorio clientePfMysqlRepositorio = new ClientePfMysqlRepositorio();

        // cadastrar

       DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite Seu Cpf: ");
        clientePf.setCpf(sc.next());
        System.out.println("Digite Seu Nome: ");
        clientePf.setNome(sc.next());
        sc.nextLine();
        System.out.println("Digite O Numero Do Seu Rg: ");
        clientePf.setRg(sc.next());
        clientePf.setDataDeNascimento(Date.valueOf(d1));
        System.out.println("Digite O Numero Do Seu Cell: ");
        clientePf.setTelefone(sc.next());
        System.out.println("Digite Seu Email: ");
        clientePf.setEmail(sc.next());

        clientePfServico.cadastrar(clientePf);




        // listar

        for(ClientePf c : clientePfMysqlRepositorio.getClientesPf()){
            // listar por nome
            System.out.println("Cliente: " + c.getNome());
            // listar por cpf
            System.out.println("cpf: " + c.getCpf());
            // listar por rg
            System.out.println("rg: " + c.getRg());
            // listar por data de nascimento
            System.out.println("data de nascimento: " + c.getDataDeNascimento());
            // listar por telefone
            System.out.println("telefone: " + c.getTelefone());
            // listar por email
            System.out.println("email: " + c.getEmail());
            System.out.println();
        }



        // alterar cliente



        clientePf.setNome("roberto");
        clientePf.setRg("10048525");
        clientePf.setDataDeNascimento(Date.valueOf(d1));
        clientePf.setTelefone("81984069178");
        clientePf.setEmail("devjuliolima@gmail.com");
        clientePf.setCpf("70994090420");

        clientePfServico.alterar(clientePf);


        // deletar cliente pelo cpf

        System.out.println("digite o cpf para deletar: ");
        clientePf.setCpf(sc.next());
        clientePfServico.excluir(clientePf);



        sc.close();
    }

    }
*/
