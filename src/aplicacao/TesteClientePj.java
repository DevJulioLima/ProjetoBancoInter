package aplicacao;

import entidades.ClientePj;
import repositorios.ClientePjMysqlRepositorio;
import servicos.ClientePjServico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TesteClientePj {
    public static void main(String[] args) throws Exception {
        LocalDate d1 = LocalDate.parse("2001-06-25");
        Scanner sc = new Scanner(System.in);
        ClientePj clientePj = new ClientePj();
        ClientePjServico clientePjServico =  new ClientePjServico();
        ClientePjMysqlRepositorio clientePjMysqlRepositorio = new ClientePjMysqlRepositorio();

        // cadastrar
/*
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite O Cnpj: ");
        clientePj.setCnpj(sc.next());
        System.out.println("Digite A Inscricao Estadual: ");
        clientePj.setIe(sc.next());
        System.out.println("Digite O Nome Fantasia: ");
        clientePj.setNomeFantasia(sc.next());
        System.out.println("Digite O Estado De Origem: ");
        clientePj.setEstado(sc.next());

        clientePjServico.cadastrar(clientePj);

        // alterar cliente pessoa juridica

        clientePj.setIe("125");
        clientePj.setNomeFantasia("brinox");
        clientePj.setEstado("RJ");
        clientePj.setCnpj("54876541236547");

        clientePjServico.alterar(clientePj);


        // listar cliente pessoa juridica

        for(ClientePj c : clientePjMysqlRepositorio.getClientePj()){
            // listar nome fantasia
            System.out.println("Nome Fantasia: " + c.getNomeFantasia());
            // listar cnpj
            System.out.println("cnpj: " + c.getCnpj());
            // listar inscricao estadual
            System.out.println("Inscricao Estadual: " + c.getIe());
            // listar estado
            System.out.println("estado: " + c.getEstado());
            System.out.println();
        }


        // deletar cliente pessoa juridica

        System.out.println("Digite O Cnpj Para Deletar: ");
        clientePj.setCnpj(sc.next());
        clientePjServico.excluir(clientePj);

*/
        sc.close();
    }
}
