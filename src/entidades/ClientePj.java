package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class ClientePj extends Pessoa{
    private String cnpj;
    private String ie;
    private String nomeFantasia;
    private String estado;

    private ArrayList<ClientePj> clientePj = new ArrayList<>();

    public ClientePj() {
    }

    public ClientePj(int id, int tipoCliente, String nome, String email, Date dataDeNascimento, String telefone, String senha) {
        super(id, tipoCliente, nome, email, dataDeNascimento, telefone, senha);

        this.cnpj = cnpj;
        this.ie = ie;
        this.nomeFantasia = nomeFantasia;
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
}
