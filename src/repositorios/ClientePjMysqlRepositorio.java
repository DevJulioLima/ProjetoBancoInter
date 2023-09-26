package repositorios;

import conexao.Conexao;
import entidades.ClientePf;
import entidades.ClientePj;
import entidades.Pessoa;
import interfaces.iClientePfRepositorioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClientePjMysqlRepositorio implements iClientePfRepositorioJdbc {

    public void cadastrar(ClientePj clientePj) throws Exception{

        try{
            String sql_clientepj = "INSERT INTO tbpessoa_juridica"
                    +"(CNPJ, INSCRICAO_ESTADUAL, NOME_FANTASIA, ESTADO, SENHA)"
                    +"VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql_clientepj);
            ps = Conexao.getConexao().prepareStatement(sql_clientepj);
            ps.setString(1, clientePj.getCnpj());
            ps.setString(2, clientePj.getIe());
            ps.setString(3,clientePj.getNomeFantasia());
            ps.setString(4, clientePj.getEstado());
            ps.setString(5, clientePj.getSenha());

            // Execuçao

            ps.execute();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(ClientePj clientePj) throws Exception {

        String sql_clientepj_alterar = "UPDATE tbpessoa_juridica SET inscricao_estadual = ?, nome_fantasia = ?, estado = ? "
                + "WHERE cnpj = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql_clientepj_alterar);
            ps.setString(1, clientePj.getIe());
            ps.setString(2, clientePj.getNomeFantasia());
            ps.setString(3, clientePj.getEstado());

            // qual cnpj que deseja atualizar
            ps.setString(4, clientePj.getCnpj());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public Stack<ClientePj> getClientePj() throws Exception{

        String sql_lista_ClientePj = "SELECT * FROM tbpessoa_juridica";

        Stack<ClientePj> clientePjs = new Stack<>();
        PreparedStatement ps = null;
        ResultSet rst = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql_lista_ClientePj);
            rst = ps.executeQuery();
            while (rst.next()){
                ClientePj clientePj = new ClientePj();

                clientePj.setCnpj(rst.getString("cnpj"));
                clientePj.setIe(rst.getString("inscricao_estadual"));
                clientePj.setNomeFantasia(rst.getString("nome_fantasia"));
                clientePj.setEstado(rst.getString("estado"));

                clientePjs.push(clientePj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rst != null){
                    rst.close();
                }
                if(ps != null){
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return clientePjs;
        }
    }

    public void deletarByCNPJ(String cnpj) throws Exception{

        String sql_deletar_clientepj = "DELETE FROM tbpessoa_juridica WHERE cnpj = ?";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql_deletar_clientepj);

            ps.setString(1, cnpj);

            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ps != null){
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
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

    public boolean validarUsuario(String cnpj , String senha) throws SQLException
    {
        boolean ret = false;
        String sql = "SELECT * FROM tbpessoa_juridica WHERE CNPJ = ? AND SENHA = ?";
        PreparedStatement smt = Conexao.getConexao().prepareStatement(sql);

        smt.setString(1,cnpj);
        smt.setString(2,senha);

        ResultSet rs = smt.executeQuery();

        if(rs.next())
        {

            ret = true;

        }
        rs.close();
        smt.close();
        return ret;
    }

    public boolean validarcnpj (String cnpj) throws SQLException
    {
        boolean ret = false;
        String sql = "SELECT * FROM tbpessoa_juridica WHERE CNPJ = ?";
        PreparedStatement smt = Conexao.getConexao().prepareStatement(sql);

        smt.setString(1, cnpj);


        ResultSet rs = smt.executeQuery();

        if (rs.next()) {

            System.out.println("Existe no banco!");
            ret = true;
            rs.close();
            smt.close();

        }else {
            System.out.println("Não existe no banco!");
            rs.close();
            smt.close();
        }

        return ret;
    }
    public boolean validarsenha (String senha) throws SQLException
    {
        boolean ret = false;
        String sql = "SELECT * FROM tbpessoa_juridica WHERE SENHA = ?";
        PreparedStatement smt = Conexao.getConexao().prepareStatement(sql);

        smt.setString(1, senha);


        ResultSet rs = smt.executeQuery();

        if (rs.next()) {


            ret = true;
            rs.close();
            smt.close();

        }else {
            System.out.println("Senha incorreta!");
            rs.close();
            smt.close();
        }

        return ret;
    }
}
