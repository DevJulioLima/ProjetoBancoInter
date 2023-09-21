package interfaces;

import entidades.ClientePj;

import java.sql.SQLException;

public interface iClientePjRepositorioJdbc {
    public ClientePj listaPorNome(String nome) throws SQLException;
    public ClientePj listaPorCnpj(String cnpj) throws SQLException;
    public ClientePj listaPorNomeFantasia(String nomeFantasia) throws SQLException;
}
