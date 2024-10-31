package estacionamento;

public class Veiculo {
	
	  private String placa;
	    private String modelo;
	    private String tamanho;
	    private long horaEntrada;  
	    private long horaSaida;    

	    public Veiculo(String placa, String modelo, String tamanho, long horaEntrada) {
	        this.placa = placa;
	        this.modelo = modelo;
	        this.tamanho = tamanho;
	        this.horaEntrada = horaEntrada;
	    }

	    public String getPlaca() {
	        return placa;
	    }

	    public String getTamanho() {
	        return tamanho;
	    }

	    public void setHoraSaida(long horaSaida) {
	        this.horaSaida = horaSaida;
	    }

	    public long getTempoPermanencia() {
	        return (horaSaida - horaEntrada) / (1000 * 60 * 60);
	    }
	}
