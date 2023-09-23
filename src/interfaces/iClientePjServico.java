package interfaces;

import entidades.ClientePj;

import java.util.ArrayList;

public interface iClientePjServico {
    public void cadastrar(ClientePj clientePj) throws Exception;
    public void alterar(ClientePj clientePj) throws Exception;
    public ArrayList<ClientePj> pesquisar(String nome);
    public void excluir(ClientePj clientePj) throws Exception;
}
