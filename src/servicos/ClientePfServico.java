package servicos;

import entidades.ClientePf;
import interfaces.iClientePfServico;
import repositorios.ClientePfMysqlRepositorio;

import java.util.ArrayList;

public class ClientePfServico {

    private ClientePfMysqlRepositorio repositorioClientePf = new ClientePfMysqlRepositorio();

//    public ClientePfServico(){
//        this.repositorioClientePf = repositorioClientePf;
//    }

    public void cadastrar(ClientePf clientePf) throws Exception {

       this.repositorioClientePf.cadastrar(clientePf);

    }



    }

