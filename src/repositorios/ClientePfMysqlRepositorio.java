package repositorios;

import conexao.Conexao;
import entidades.ClientePf;
import interfaces.iClientePfRepositorioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static conexao.Conexao.conn;

public class ClientePfMysqlRepositorio implements iClientePfRepositorioJdbc{

   public void cadastrar (ClientePf clientePf) throws Exception {

        try{
            String sql_clientePf = "INSERT INTO tbpessoa_fisica"
                    +"(CPF, NOME,  RG, TELEFONE, EMAIL, SENHA)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql_clientePf);
            ps = Conexao.getConexao().prepareStatement(sql_clientePf);
            ps.setString(1, clientePf.getCpf());
            ps.setString(2 , clientePf.getNome());
            ps.setString(3, clientePf.getRg());
            //ps.setDate(4, clientePf.getDataDeNascimento());
            ps.setString(4, clientePf.getTelefone());
            ps.setString(5, clientePf.getEmail());
            ps.setString(6,clientePf.getSenha());

            // execução

            ps.execute();
            ps.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
   }
   public void alterar(ClientePf clientePf) throws Exception{

       String sql_clientepf_alterar = "UPDATE tbpessoa_fisica SET nome = ?, rg = ?, telefone = ?, email = ? "
               + "WHERE cpf = ?";

       PreparedStatement ps = null;

       try{
           ps = Conexao.getConexao().prepareStatement(sql_clientepf_alterar);
           ps.setString(1, clientePf.getNome());
           ps.setString(2, clientePf.getRg());
           //ps.setDate(3, clientePf.getDataDeNascimento());
           ps.setString(3, clientePf.getTelefone());
           ps.setString(4, clientePf.getEmail());

           // qual CPF que deseja atualizar
           ps.setString(5, clientePf.getCpf());

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

    public List<ClientePf> getClientesPf() throws Exception {

            String sql_lista_clientes_pf = "SELECT * FROM tbpessoa_fisica";

            Stack<ClientePf> clientePfs = new Stack<>();
            PreparedStatement ps = null;
            ResultSet rst = null;
            try{
             ps = Conexao.getConexao().prepareStatement(sql_lista_clientes_pf);
            rst = ps.executeQuery();
            while (rst.next()){
                ClientePf clientePf = new ClientePf();

                clientePf.setCpf(rst.getString("cpf"));
                clientePf.setNome(rst.getString("nome"));
                clientePf.setRg(rst.getString("rg"));
               // clientePf.setDataDeNascimento(rst.getDate("data_de_nascimento"));
                clientePf.setTelefone(rst.getString("telefone"));
                clientePf.setEmail(rst.getString("email"));

                clientePfs.push(clientePf);
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
        return clientePfs;
    }
   }

   public void deletarByCPF(String cpf) throws Exception{

       String sql_deletar_clientepf = "DELETE FROM tbpessoa_fisica WHERE cpf = ?";

       PreparedStatement  ps = null;

       try{
           ps = Conexao.getConexao().prepareStatement(sql_deletar_clientepf);

           ps.setString(1, cpf);

           ps.execute();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try{
           if(ps != null){
               ps.close();
           }
       }catch (SQLException e){
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

    public boolean validarUsuario(String cpf , String senha) throws SQLException
    {
        boolean ret = false;
        String sql = "SELECT * FROM tbpessoa_fisica WHERE CPF = ? AND SENHA = ?";
        PreparedStatement smt = Conexao.getConexao().prepareStatement(sql);

        smt.setString(1,cpf);
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

    public boolean validarcpf (String cpf) throws SQLException
    {
        boolean ret = false;
        String sql = "SELECT * FROM tbpessoa_fisica WHERE CPF = ?";
        PreparedStatement smt = Conexao.getConexao().prepareStatement(sql);

        smt.setString(1, cpf);


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
        String sql = "SELECT * FROM tbpessoa_fisica WHERE SENHA = ?";
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
