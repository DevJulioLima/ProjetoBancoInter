package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class ClientePf extends Pessoa{
    private float rendaMensal;

    private ArrayList<ClientePf> clientePf = new ArrayList<>();

    public ClientePf() {
    }

    public ClientePf(int id, int tipoCliente, String nome, String email, Date dataDeNascimento, String telefone, String rg, String cpf, String senha) {
        super(id, tipoCliente, nome, email, telefone, rg, cpf, senha);

        this.rendaMensal = rendaMensal;
    }

    public float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
