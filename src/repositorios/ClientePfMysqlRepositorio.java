package repositorios;

import conexao.Conexao;
import entidades.ClientePf;
import interfaces.iClientePfRepositorioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static conexao.Conexao.conn;

public class ClientePfMysqlRepositorio implements iClientePfRepositorioJdbc{

    public long cadastrar (ClientePf clientePf) throws Exception {

        try{
            String sql_clientePf = "INSERT INTO tbpessoa"
                    +"(CPF, NOME,  RG,  DATA_DE_NASCIMENTO, TELEFONE, EMAIL, CLIENTE)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql_clientePf , Statement.RETURN_GENERATED_KEYS);
            ps = Conexao.getConexao().prepareStatement(sql_clientePf);
            ps.setString(1, clientePf.getCpf());
            ps.setString(2 , clientePf.getNome());
            ps.setString(3, clientePf.getRg());
            ps.setDate(4, clientePf.getDataDeNascimento());
            ps.setString(5, clientePf.getTelefone());
            ps.setString(6, clientePf.getEmail());
            ps.setInt(7, clientePf.getTipoCliente());

            // execução

            int retorno = ps.executeUpdate();
            System.out.println("Salvo com sucesso!");
            if (retorno == 0){
                throw new SQLException("persistencia do CLIENTEPF falhou , ID do CLIENTEPF não foi gerado.");
            }
            try (ResultSet generatedkeys = ps.getGeneratedKeys()){
                if (generatedkeys.next()){
                    return generatedkeys.getLong(1);
                }else{
                    throw new SQLException("persistencia do CLIENTEPF falhou , ID do CLIENTEPF não foi gerado.");
                }
            }
        } catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("persistencia do CLIENTEPF falhou");
        }
    }
    @Override
    public ClientePf listarPorNome(String nome) throws SQLException {
        return null;
    }

    @Override
    public ClientePf listaPorCpf(String cpf) throws SQLException {
        return null;
    }
}

