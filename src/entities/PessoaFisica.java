package entities;

public class PessoaFisica extends Contribuintes {
    private Double gastoSaude;

    public PessoaFisica(String nome, Double renda, Double gastoSaude) {
        super(nome, renda);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public Double calcImposto() {
        if (getRenda() < 20000.00) {
            return (getRenda() * 0.15 - gastoSaude * 0.5);
        }
        return getRenda() * 0.25 - gastoSaude * 0.5;
    }

}
