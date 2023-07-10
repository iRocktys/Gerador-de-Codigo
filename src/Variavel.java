
public class Variavel {
	public String nome;
	public String tipo;
	public String valor;
	
	public static final String REAL = "float";
	public static final String INT = "int";
	
	public String generateCode() {
		String str;
		
		if(tipo.equals("int")) {
			str  = "\tint " + nome + ";\n";
		}else {
			str  = "\tfloat " + nome + ";\n";
		}
		
		return str;
	}
	
	public Variavel(String nome, String tipo, String valor) {
		this.nome = nome;
		this.valor = valor;
		if(tipo.equals("INT")) {
			this.tipo = INT;
		}else {
			this.tipo = REAL;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		
		return "[nome="+this.nome+"\t| Tipo="+this.tipo+"\t| valor="+this.valor+"]"; 
	}

}
