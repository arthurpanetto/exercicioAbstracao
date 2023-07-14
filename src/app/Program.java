package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Contribuintes> list = new ArrayList<>();

        System.out.print("Digite o Numero de Contribuintes: ");
        int contribuintes = scan.nextInt();

        for (int i = 1; i <= contribuintes; i++) {
            System.out.println("Pagador #" + i);
            System.out.print("Pessoa fisica ou juridica (f/j): ");
            char type = scan.next().charAt(0);
            System.out.print("Nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Renda Anual: R$");
            double renda = scan.nextDouble();
            if (type == 'j') {
                System.out.print("Quantos funcionarios sua empresa tem? ");
                int funcionarios = scan.nextInt();
                list.add(new PessoaJuridica(nome, renda, funcionarios));
            } else {
                System.out.print("Qual o gasto com saúde? R$");
                double gastoSaude = scan.nextDouble();
                list.add(new PessoaFisica(nome, renda, gastoSaude));
            }
        }
        double soma = 0.0;
        System.out.println();
        System.out.println("Taxas pagas:");
        for (Contribuintes cont : list) {
            double taxa = cont.calcImposto();
            System.out.println(cont.getNome() + ": R$" + String.format("%.2f", taxa));
            soma += taxa;

        }
        System.out.println();
        System.out.println("TOTAL: R$" + String.format("%.2f", soma));
        scan.close();
    }
}
