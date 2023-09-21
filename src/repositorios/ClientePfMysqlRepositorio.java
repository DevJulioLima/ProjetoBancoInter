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

   public void cadastrar (ClientePf clientePf) throws Exception {

        try{
            String sql_clientePf = "INSERT INTO tbpessoa"
                    +"(CPF, NOME,  RG,  DATA_DE_NASCIMENTO, TELEFONE, EMAIL, CLIENTE)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql_clientePf);
            ps = Conexao.getConexao().prepareStatement(sql_clientePf);
            ps.setString(1, clientePf.getCpf());
            ps.setString(2 , clientePf.getNome());
            ps.setString(3, clientePf.getRg());
            ps.setDate(4, clientePf.getDataDeNascimento());
            ps.setString(5, clientePf.getTelefone());
            ps.setString(6, clientePf.getEmail());
            ps.setInt(7, clientePf.getTipoCliente());

            // execução

            ps.execute();
            ps.close();

        } catch (SQLException e){
            e.printStackTrace();
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
