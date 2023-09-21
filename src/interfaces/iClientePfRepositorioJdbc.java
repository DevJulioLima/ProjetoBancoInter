package interfaces;

import entidades.ClientePf;

import java.sql.SQLException;

public interface iClientePfRepositorioJdbc {
    public ClientePf listarPorNome(String nome) throws SQLException;
    public ClientePf listaPorCpf(String cpf) throws SQLException;

}
