package servicos;

import entidades.ClientePf;
import interfaces.iClientePfServico;
import repositorios.ClientePfMysqlRepositorio;

import java.util.ArrayList;

public class ClientePfServico implements iClientePfServico{

    private ClientePfMysqlRepositorio repositorioClientePf = new ClientePfMysqlRepositorio();

    public ClientePfServico(){
       this.repositorioClientePf = repositorioClientePf;
    }

    public void cadastrar(ClientePf clientePf) throws Exception {
        if(clientePf.getCpf().length() != 11)
            System.out.println("CPF INCORRETO!");
            else{
                if(clientePf.getNome().isBlank())
                    System.out.println("NOME EM BRANCO!");
                else{
                    if(clientePf.getNome().isEmpty())
                        System.out.println("NOME VAZIO!");
                    else{
                        if(clientePf.getNome().length() <= 3)
                            System.out.println("DIGITE SEU NOME COMPLETO!");
                        else{
                            if(clientePf.getRg().length() != 8)
                                System.out.println("RG INCORRETO!");
                            else{
                                if(clientePf.getTelefone().length() != 11)
                                    System.out.println("DIGITE UM NUMERO DE TELEFONE VALIDO! APENAS NUMEROS!");
                                else{
                                    if(clientePf.getEmail().length() <= 10)
                                        System.out.println("DIGITE UM EMAIL VALIDO!");
                                    else{
                                        repositorioClientePf.cadastrar(clientePf);
                                        System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    @Override
    public void cadastrar(String nome) {

    }

    @Override
    public void alterar(ClientePf clientePf) {

    }

    @Override
    public ArrayList<ClientePf> pesquisar(String nome) {
        return null;
    }

    @Override
    public void excluir(ClientePf clientePf) {

    }


}

