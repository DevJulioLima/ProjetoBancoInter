package servicos;

import entidades.ClientePf;
import interfaces.iClientePfServico;
import repositorios.ClientePfMysqlRepositorio;

import java.util.ArrayList;

public class ClientePfServico implements iClientePfServico {

    private ClientePfMysqlRepositorio repositorioClientePf = null;

    public ClientePfServico(){
        this.repositorioClientePf = repositorioClientePf;
    }
    @Override
    public void cadastrar(ClientePf clientePf) throws Exception {
        repositorioClientePf.cadastrar(clientePf);

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
