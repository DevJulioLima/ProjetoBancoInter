package aplicacao;

import entidades.*;
import repositorios.*;
import servicos.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class mainAplicacao {
    public static void main(String[] args) throws Exception {

        LocalDate d1 = LocalDate.parse("2001-06-25");
        Scanner sc = new Scanner(System.in);
        ClientePj clientePj = new ClientePj();
        ClientePjServico clientePjServico =  new ClientePjServico();
        ClientePjMysqlRepositorio clientePjMysqlRepositorio = new ClientePjMysqlRepositorio();
        ClientePf clientePf =  new ClientePf();
        ClientePjServico clientePjServico1 =  new ClientePjServico();
        ClientePfMysqlRepositorio clientePfMysqlRepositorio = new ClientePfMysqlRepositorio();


        System.out.println( "***** APLICATIVO INICIADO ***** \n\n");

        int loop1 = 1;
        while (loop1 == 1) {
            System.out.println("***** QUAL TIPO DE CONTA DESEJA UTILIZAR? *****\n");
            System.out.println("\n 1 - Conta de Pessoa Jurídica\n 2 - Conta de Pessoa Física\n 3 - Sair do Programa " +
                    "\n Digite a opção desejada:");

            int opcao1 = sc.nextInt();
            int loop2 = 1;

            while (loop2 == 1){
            switch (opcao1) {
                case 1:
                    System.out.println("\n OPÇÕES DE CONTA JURÍDICA: \n 1 - Criar Conta\n 2 - " +
                            "\n 3 - Voltar ao menu anterior");
                    int opcao2 = sc.nextInt();

                    switch (opcao2){

                        case 1:


                            //DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            System.out.println("\n ***** VERIFICAÇÃO DE CONTA ***** \n INSIRA SEU CNPJ: ");
                            if (clientePjMysqlRepositorio.validarcnpj(sc.next())){
                                break;
                            };

                            System.out.println("Digite o cnpj: ");
                            clientePj.setCnpj(sc.next());
                            System.out.println("Digite a inscricao estadual: ");
                            clientePj.setIe(sc.next());
                            System.out.println("Digite o nome fantasia: ");
                            clientePj.setNomeFantasia(sc.next());
                            System.out.println("Digite o estado de origem: ");
                            clientePj.setEstado(sc.next());
                            System.out.println("Crie uma senha (Até 20 caracteres):");
                            clientePj.setSenha(sc.next());

                             clientePjServico.cadastrar(clientePj);


                        case 2:

                            clientePjMysqlRepositorio.validarUsuario(sc.next(), sc.next());
                            System.out.println("");
                            clientePj.setCnpj(sc.next());
                            clientePj.setIe(sc.next());
                            clientePj.setNomeFantasia(sc.next());
                            clientePj.setEstado(sc.next());


                            clientePjServico.alterar(clientePj);


                    }
            }
            }
        }


        // alterar cliente pessoa juridica
/*
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
