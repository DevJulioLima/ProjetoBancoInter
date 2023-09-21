package aplicacao;

import entidades.ClientePf;
import entidades.Pessoa;
import repositorios.ClientePfMysqlRepositorio;
import servicos.ClientePfServico;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws Exception {
        LocalDate d1 = LocalDate.parse("1997-06-14");
        Scanner sc = new Scanner(System.in);
        ClientePfServico clientePfServico = new ClientePfServico();
        ClientePf clientePf = new ClientePf();



        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        clientePf.setCpf(("16984"));
        clientePf.setNome("ze pilinta");
        clientePf.setRg(("10048529"));
        clientePf.setDataDeNascimento(Date.valueOf(d1));
        clientePf.setTelefone(("81984069184"));
        clientePf.setEmail("zepilintaal.com");
        clientePf.setTipoCliente(1);

        clientePfServico.cadastrar(clientePf);



        sc.close();
    }

    }

