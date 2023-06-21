package laboratorio;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        int condicao1 = pessoa.getCpf().compareTo(this.cpf);

        if (condicao1 != 0){
            return condicao1;
        } else {
            return pessoa.getNome().compareTo(this.nome);
        }
    }

}
