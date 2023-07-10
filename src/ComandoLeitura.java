
public class ComandoLeitura extends Comando {
	
	private String id;
	private String tipo;
	
	public ComandoLeitura(String id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	@Override
	public String generateCode() {
		if(tipo.equals("int")) {
			String str = "\n\tscanf(\"%d\", &" + this.id + ");";
			return str;
		}else {
			String str = "\n\tscanf(\"%f\", &" + this.id + ");";
			return str;
		}
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
