package aplicacao;

import entidades.*;
import repositorios.*;
import servicos.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class mainAplicacao {
    public static void main(String[] args) throws Exception {

        LocalDate d1 = LocalDate.parse("2001-06-25");
        Scanner sc = new Scanner(System.in);
        ClientePj clientePj = new ClientePj();
        ClientePjServico clientePjServico = new ClientePjServico();
        ClientePjMysqlRepositorio clientePjMysqlRepositorio = new ClientePjMysqlRepositorio();
        ClientePf clientePf = new ClientePf();
        ClientePjServico clientePjServico1 = new ClientePjServico();
        ClientePfMysqlRepositorio clientePfMysqlRepositorio = new ClientePfMysqlRepositorio();



        System.out.println("***** APLICATIVO INICIADO ***** \n\n");

        int loop1 = 1;
        while (loop1 == 1) {
            System.out.println("***** QUAL TIPO DE CONTA DESEJA UTILIZAR? *****\n");
            System.out.println("\n 1 - Conta de Pessoa Jurídica\n 2 - Conta de Pessoa Física\n 3 - Sair do Programa " +
                    "\n Digite a opção desejada:");

            int opcao1 = sc.nextInt();
            int loop2 = 1;

            while (loop2 == 1) {
                switch (opcao1) {
                    case 1:
                        System.out.println("\n OPÇÕES DE CONTA JURÍDICA: \n 1 - Criar Conta\n 2 - Alterar Dados da" +
                                " sua conta\n 3 - Deletar Conta\n 4 - Entrar na conta\n 5 - Voltar ao menu anterior");
                        int opcao2 = sc.nextInt();

                        switch (opcao2) {

                            case 1:


                                //DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                System.out.println("\n ***** VERIFICAÇÃO DE CONTA ***** \n INSIRA SEU CNPJ: ");
                                if (clientePjMysqlRepositorio.validarcnpj(sc.next())) {
                                    break;
                                }
                                ;

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

                                break;

                            case 2:
                                System.out.println("\n ***** ENTRE NA SUA CONTA ***** \n\n INSIRA SEU CNPJ E SUA SENHA:");
                                clientePjMysqlRepositorio.validarUsuario(sc.next(), sc.next());

                                System.out.println("O que deseja alterar? \n\n 1 - CNPJ \n 2 - Senha \n 3 - Inscrição Estdual" +
                                        "\n 4 - Nome Fantasia \n 5 - Estado \n 6 - Voltar ao menu anterior");
                                int opcao3 = sc.nextInt();

//                            switch (opcao3) {
//                                case 1:
//                                    System.out.println("\nDigite o novo número de cnpj: \n");
//                                    if (clientePjMysqlRepositorio.validarcnpj(sc.next())) {
//                                        break;
//                                    } else {
//                                        clientePj.setCnpj(sc.next());
//                                        System.out.println("\nCnpj alterado com sucesso!\n");
//                                    }
//
//                                case 2:
//                                    System.out.println("\nDigite sua nova senha: ");
//                                    clientePj.setSenha(sc.next());
//
//                                case 3:
//                                    System.out.println("\nDigite a nova Inscrição Estadual: ");
//                                    clientePj.setIe(sc.next());
//
//                                case 4:
//                                    System.out.println("\n Digite seu novo Nome Fantasia: ");
//                                    clientePj.setNomeFantasia(sc.next());
//
//                                case 5:
//                                    System.out.println("\n Digite seu novo Estado: ");
//                                    clientePj.setEstado(sc.next());
//                                case 6:
//                                        break;
//                            }
                                clientePjServico.alterar(clientePj);

                            case 3:
                                System.out.println("\n ***** VERIFICAÇÃO DE CONTA ***** \n INSIRA SEU CNPJ: ");
                                if (!(clientePjMysqlRepositorio.validarcnpj(sc.next()))) {
                                    break;
                                }
                                ;
                                System.out.println("\n INISIRA SUA SENHA: ");
                                if (!(clientePjMysqlRepositorio.validarsenha(sc.next()))) {
                                    break;
                                }
                                System.out.println("Digite o Cnpj Para Deletar: ");
                                clientePj.setCnpj(sc.next());
                                clientePjServico.excluir(clientePj);

                                break;

                            case 4:
                                System.out.println("\n ***** LOGIN ***** \n\n INSIRA SEU CNPJ: ");
                                if (!(clientePjMysqlRepositorio.validarcnpj(sc.next()))) {
                                    break;
                                }
                                System.out.println("\n INISIRA SUA SENHA: ");
                                if (!(clientePjMysqlRepositorio.validarsenha(sc.next()))) {
                                    break;
                                }
                                System.out.println("LOGIN EFETUADO COM SUCESSO! \n\n ***** MENU DA CONTA BANCÁRIA *****" +
                                        "\n\n 1 - Transferência Pix \n 2 - Depósito \n 3 - Extrato \n 4 - Pagar Conta " +
                                        " \n 5 - Voltar ao menu anterior");
                                int opcao4 = sc.nextInt();

                                switch (opcao4) {
                                    case 1:
                                        //Método de transferência

                                    case 2:
                                        // Método de depósito

                                    case 3:
                                        // método de extrato

                                    case 4:
                                        // método de pagar conta

                                    case 5:
                                        System.out.println("\n\nDeslogado com sucesso!");
                                }

                            case 5:
                                System.out.println("\nVOLTANDO...\n");

                        }
                    case 2:
                        System.out.println("\n OPÇÕES DE CONTA: \n 1 - Criar Conta\n 2 - Alterar Dados da" +
                                " sua conta\n 3 - Deletar Conta\n 4 - Entrar na conta\n 5 - Voltar ao menu anterior");


                        int opcao5 = sc.nextInt();

                        switch (opcao5) {

                            case 1:

                                System.out.println("\n ***** VERIFICAÇÃO DE CONTA ***** \n INSIRA SEU CPF: ");
                                if (clientePjMysqlRepositorio.validarcnpj(sc.next())) {
                                    break;
                                }

//                                DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                System.out.println("Digite Seu Cpf: ");
                                clientePf.setCpf(sc.next());
                                System.out.println("Digite Seu Nome: ");
                                clientePf.setNome(sc.next());
                                System.out.println("Digite O Numero Do Seu Rg: ");
                                clientePf.setRg(sc.next());
//                                System.out.println("Insira a sua data de nascimento (dd/mm/yyyy): ");
//                                clientePf.setDataDeNascimento(Date.valueOf(sc.next()));
                                System.out.println("Digite O Numero Do Seu Cell: ");
                                clientePf.setTelefone(sc.next());
                                System.out.println("Digite Seu Email: ");
                                clientePf.setEmail(sc.next());
                                System.out.println("Digite sua senha: ");
                                clientePf.setSenha(sc.next());

                                clientePfMysqlRepositorio.cadastrar(clientePf);

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
