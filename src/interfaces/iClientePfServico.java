package interfaces;

import entidades.ClientePf;

import java.util.ArrayList;

public interface iClientePfServico {
    public void cadastrar(ClientePf clientePf) throws Exception;
    public void alterar(ClientePf clientePf) throws Exception;
    public ArrayList<ClientePf> pesquisar(String nome) throws Exception;
    public void excluir(ClientePf clientePf) throws Exception;

}
