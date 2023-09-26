package entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Stack;

public class ClientePj extends Pessoa{
    private String cnpj;
    private String ie;
    private String nomeFantasia;
    private String estado;

    private Stack<ClientePj> clientePj = new Stack<>();

    public ClientePj() {
    }

    public ClientePj(int id, int tipoCliente, String nome, String email, String telefone, String senha) {
        super(id, tipoCliente, nome, email, telefone, senha);

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
