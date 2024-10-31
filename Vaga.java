package estacionamento;

public class Vaga {
	
	 private int numero;
	    private String tamanho;
	    private boolean disponivel;
	    private Veiculo veiculo;

	    public Vaga(int numero, String tamanho) {
	        this.numero = numero;
	        this.tamanho = tamanho;
	        this.disponivel = true;
	    }

	    public boolean ocupar(Veiculo veiculo) {
	        if (disponivel && this.tamanho.equals(veiculo.getTamanho())) {
	            this.veiculo = veiculo;
	            this.disponivel = false;
	            return true;
	        }
	        return false;
	    }

	    public void liberar() {
	        this.veiculo = null;
	        this.disponivel = true;
	    }

	    public boolean isDisponivel() {
	        return disponivel;
	    }

	    public Veiculo getVeiculo() {
	        return veiculo;
	    }

	    public String getTamanho() {
	        return tamanho;
	    }

	    public int getNumero() {
	        return numero;
	    }
	}