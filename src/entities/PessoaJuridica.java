package entities;

public class PessoaJuridica extends Contribuintes {
    private int funcionarios;

    public PessoaJuridica(String nome, Double renda, int funcionarios) {
        super(nome, renda);
        this.funcionarios = funcionarios;
    }

    public int getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public Double calcImposto() {
        if (funcionarios > 10) {
            return (getRenda() * 0.14);
        }
        return (getRenda() * 0.16);
    }

}
