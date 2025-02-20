package Aula05;

import java.util.Locale;
import java.util.Scanner;

public class Aula05 {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ContaBanco p1 = null;

        while (true) {
            System.out.println("===== SEJA BEM VINDO =====");
            System.out.println("Digite o que deseja:  ");
            System.out.println("1 - abrir conta ");
            System.out.println("2 - fechar conta ");
            System.out.println("3 - depositar ");
            System.out.println("4 - sacar ");
            System.out.println("5 - pagamento mensal");
            System.out.println("6 - Dados");
            System.out.println("7 - Sair");
            System.out.println("=================");
            int opcao = sc.nextInt();


            if (opcao == 1) {
                sc.nextLine();
                System.out.println("Digite seu nome: ");
                String d = sc.nextLine();

                System.out.println("Digite o numero da conta: ");
                int c = sc.nextInt();

                sc.nextLine();

                System.out.println("Selecione o tipo da conta: 1 - CC(conta corrente) / 2 - CP(conta poupança)");
                String tipoEscolhido = sc.nextLine();

                String t = tipoEscolhido.equals("1") ? "CC" : "CP";

                p1 = new ContaBanco(d, c, t);
                p1.abrirConta(t);
                p1.estadoAtual();

            } else if (opcao == 2) {
                if (p1 != null) {
                    p1.fecharConta();
                } else {
                    System.out.println("Nenhuma conta encontrada no sistema!");
                }
            } else if (opcao == 3) {
                if (p1 != null) {
                    System.out.println("Digite o valor do deposito: ");
                    float v = sc.nextFloat();
                    p1.depositar(v);
                    p1.estadoAtual();
                } else {
                    System.out.println("Nehuma conta encontrada no sistema!");
                }
            } else if (opcao == 4) {
                if (p1 != null) {
                    System.out.println("Digite o valor de saque: ");
                    float v = sc.nextFloat();
                    p1.sacar(v);
                    p1.estadoAtual();
                } else {
                    System.out.println("Nenhuma conta encontrada no sistema! ");
                }
            } else if (opcao == 5) {
                if (p1 != null) {
                    p1.pagarMensal();
                    p1.estadoAtual();
                } else {
                    System.out.println("Nenhuma conta encontrada no sistema!");
                }
            } else if (opcao == 6) {
                if (p1 != null) {
                    p1.estadoAtual();
                    System.out.println("O que deseja? ");
                    System.out.println("1 - Trocar nome e Numero da conta / 2 - voltar para opções");
                    int escolha = sc.nextInt();

                    if (escolha == 1) {
                        System.out.println("Nome antigo da conta: " + p1.getNomeDono());
                        System.out.println("Numero antigo da conta: " + p1.getNumConta());
                        sc.nextLine();

                        System.out.println("Digite o novo nome: ");
                        String nomeDono = sc.nextLine();
                        p1.setNomeDono(nomeDono);

                        System.out.println("Digite o novo numero da conta: ");
                        int numConta = sc.nextInt();
                        p1.setNumConta(numConta);

                        System.out.println("Novo nome: " + p1.getNomeDono());
                        System.out.println("Novo numero: " + p1.getNomeDono());
                        p1.estadoAtual();

                    } else {
                        System.out.println("Voltando!");
                    }
                }
            } else if (opcao == 7) {
                System.out.println("Volte sempre!");
                break;
            }


        }
    }
}