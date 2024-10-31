package estacionamento;

import java.util.Scanner;

public class Sistema {
	   
	 public static void main(String[] args) {
	        Estacionamento estacionamento = new Estacionamento();
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("SISTEMA DE UM GERENCIAMENTO DE ESTACIONAMENTO");
	      
	        
	        estacionamento.adicionarVaga(1, "pequeno");
	        estacionamento.adicionarVaga(2, "médio");
	        estacionamento.adicionarVaga(3, "grande");
	        System.out.println();
	        
	        System.out.println("TEMOS A VAGA 1, 2 E 3 Já  ESTA CADASTRADA EM NOSSO SISTEMA");
	        System.out.println("1- Pequena");
	        System.out.println("2- Media");
	        System.out.println("3- Grande");
	        
	      
	        while (true) {
	        	System.out.println("\nESCOLHA A OPÇÃO DESEJADA: ");
	            System.out.println("1. Entrada de veículo");
	            System.out.println("2. Saída de veículo");
	            System.out.println("3. Relatório de vagas ocupadas");
	            System.out.println("4. Relatório de histórico");
	            System.out.println("0. Sair");
	            System.out.println("DIGITE O NÚMERO DA OPÇÃO DESEJADA:");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            if (opcao == 1) {
	                System.out.print("\nPlaca do veículo: ");
	                String placa = scanner.nextLine();
	                System.out.print("Modelo do veículo: ");
	                String modelo = scanner.nextLine();

	                System.out.print("Digite a hora de entrada (formato HH:mm): ");
	                String horaEntradaStr = scanner.nextLine();
	                long horaEntrada = converterParaMilissegundos(horaEntradaStr);

	                System.out.println("Escolha o tamanho do veículo:");
	                System.out.println("1. Pequeno");
	                System.out.println("2. Médio");
	                System.out.println("3. Grande");
	                int tamanhoVeiculoEscolhido = scanner.nextInt();
	                String tamanhoVeiculo;
	                switch (tamanhoVeiculoEscolhido) {
	                    case 1:
	                        tamanhoVeiculo = "pequeno";
	                        break;
	                    case 2:
	                        tamanhoVeiculo = "médio";
	                        break;
	                    case 3:
	                        tamanhoVeiculo = "grande";
	                        break;
	                    default:
	                        System.out.println("Tamanho inválido. Usando 'pequeno' como padrão.");
	                        tamanhoVeiculo = "pequeno";
	                }

	                if (!estacionamento.entradaVeiculo(placa, modelo, tamanhoVeiculo, horaEntrada)) {
	                    System.out.println("Nenhuma vaga disponível para o tamanho " + tamanhoVeiculo + ".");
	                }
	                System.out.println("Cadastro do veiculo realizado com sucesso.");
	                
	            } else if (opcao == 2) {
	                System.out.print("\nPlaca do veículo: ");
	                String placa = scanner.nextLine();

	                System.out.print("Digite a hora de saída (formato HH:mm): ");
	                String horaSaidaStr = scanner.nextLine();
	                long horaSaida = converterParaMilissegundos(horaSaidaStr);
	                estacionamento.saidaVeiculo(placa, horaSaida);
	                System.out.println("Cadastro de saida do veiculo realizado com sucesso.");
	            } else if (opcao == 3) {
	            	System.out.println();
	                estacionamento.relatorioVagasOcupadas();
	            } else if (opcao == 4) {
	            	System.out.println();
	                estacionamento.relatorioHistorico();
	            } else if (opcao == 0) {
	            	System.out.println("EXECUÇÃO ENCERRADA");
	                break;
	            } else {
	                System.out.println("OPÇÃO INVALIDA");
	            }
	        }
	        scanner.close();
	    }

	    private static long converterParaMilissegundos(String hora) {
	        String[] partes = hora.split(":");
	        int horas = Integer.parseInt(partes[0]);
	        int minutos = Integer.parseInt(partes[1]);
	        long agora = System.currentTimeMillis();
	        long milissegundos = agora - (agora % (1000 * 60 * 60)); 

	        return milissegundos + (horas * 3600000) + (minutos * 60000);
	    }
	}