package estacionamento;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
	
	private List<Vaga> vagas = new ArrayList<>();
    private List<String> historico = new ArrayList<>();

    public void adicionarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public boolean entradaVeiculo(String placa, String modelo, String tamanho, long horaEntrada) {
        Veiculo veiculo = new Veiculo(placa, modelo, tamanho, horaEntrada);
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(tamanho)) {
                return vaga.ocupar(veiculo);
            }
        }
        return false;
    }

    public void saidaVeiculo(String placa, long horaSaida) {
        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo != null && veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida(horaSaida);
                long horas = veiculo.getTempoPermanencia();
                double valor = calcularValor(horas);
                historico.add("Placa: " + veiculo.getPlaca() + ", Valor pago: R$ " + valor);
                vaga.liberar();
                System.out.println("Veículo " + placa + " saiu. Valor a pagar: R$ " + valor + ".");
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    private double calcularValor(long horas) {
        if (horas <= 1) return 5.00;
        if (horas <= 3) return 10.00;
        return 15.00;
    }

    public void relatorioVagasOcupadas() {
        System.out.println("VAGAS OCUPADAS:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga: " + vaga.getNumero() + ", Placa: " + vaga.getVeiculo().getPlaca()+ ", Tamanho: " + vaga.getTamanho());
            }
        }
    }

    public void relatorioHistorico() {
        System.out.println("HISTORICO DE CARROS QUE PASSOU PELO JÁ ESTACIONAMETO:");
        for (String registro : historico) {
            System.out.println(registro);
        }
    }
}
