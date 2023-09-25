package servicos;

import entidades.ClientePj;
import interfaces.iClientePjServico;
import repositorios.ClientePjMysqlRepositorio;

import java.util.ArrayList;

public class ClientePjServico implements iClientePjServico {

    private ClientePjMysqlRepositorio repositorioClientePj = new ClientePjMysqlRepositorio();

    public ClientePjServico() {
        this.repositorioClientePj = repositorioClientePj;
    }

    @Override

    public void cadastrar(ClientePj clientePj) throws Exception {

        if (clientePj.getCnpj().length() != 14) {
            System.out.println("CNPJ INCORRETO!");
        } else {
            if (clientePj.getNomeFantasia().isBlank())
                System.out.println("NOME EM BRANCO!");
            else {
                if (clientePj.getNomeFantasia().isEmpty())
                    System.out.println("NOME VAZIO!");
                else {
                    if (clientePj.getNomeFantasia().length() <= 3)
                        System.out.println("DIGITE O NOME FANTASIA!");
                    if (clientePj.getEstado().isBlank())
                        System.out.println("ESTADO EM BRANCO");
                    else {
                        if (clientePj.getEstado().isEmpty())
                            System.out.println("ESTADO VAZIO!");
                        else {
                            if (clientePj.getEstado().length() <= 1)
                                System.out.println("DIGITE SEU ESTADO!");
                            else {
                                if (clientePj.getSenha().length() >= 20) {
                                    System.out.println("ATÉ 20 CARACTERES!");
                                }
                            }
                            if (clientePj.getSenha().isBlank()) {
                                System.out.println("SENHA EM BRANCO!");
                            } else {
                                repositorioClientePj.cadastrar(clientePj);
                                System.out.println("CLIENTE JURIDICA CADASTRADO COM SUCESSO!");
                            }
                        }
                    }
                }

            }
        }
    }


    @Override
    public void alterar(ClientePj clientePj) throws Exception {
        if (clientePj.getNomeFantasia().isBlank())
            System.out.println("NOME EM BRANCO!");
        else {
            if (clientePj.getNomeFantasia().isEmpty())
                System.out.println("NOME VAZIO!");
            else {
                if (clientePj.getNomeFantasia().length() <= 3)
                    System.out.println("DIGITE O NOME FANTASIA!");
                if (clientePj.getEstado().isBlank())
                    System.out.println("ESTADO EM BRANCO");
                else {
                    if (clientePj.getEstado().isEmpty())
                        System.out.println("ESTADO VAZIO!");
                    else {
                        if (clientePj.getEstado().length() <= 1)
                            System.out.println("DIGITE SEU ESTADO!");
                        else {
                            repositorioClientePj.alterar(clientePj);
                            System.out.println("CLIENTE ALTERADO COM SUCESSO!");
                        }
                    }
                }
            }
        }


    }

    @Override
    public ArrayList<ClientePj> pesquisar(String nome) {
        return null;
    }

    @Override
    public void excluir(ClientePj clientePj) throws Exception {
        if (clientePj.getCnpj().length() != 14) {
            System.out.println("CNPJ INCORRETO!");
        } else {
            repositorioClientePj.deletarByCNPJ(clientePj.getCnpj());
            System.out.println("CLIENTE DELETADO COM SUCESSO!");
        }
    }


}
