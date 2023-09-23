package aplicacao;

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
        ClientePfServico clientePfServico = new ClientePfServico();
        ClientePf clientePf = new ClientePf();
        ClientePfMysqlRepositorio clientePfMysqlRepositorio = new ClientePfMysqlRepositorio();

        // cadastrar

       /* DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
        clientePf.setTipoCliente(1);

        clientePfServico.cadastrar(clientePf);*/



        // listar

        for(ClientePf c : clientePfMysqlRepositorio.getClientesPf()){
            System.out.println("Cliente: " + c.getNome());
        }

        sc.close();
    }

    }

