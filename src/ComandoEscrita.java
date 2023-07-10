
public class ComandoEscrita extends Comando {
	private String id;
	private String tipo;
	
	public ComandoEscrita(String id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	@Override
	public String generateCode() {
		if(tipo.equals("int")) {
			String str = "\n\tprintf(\"%d\", " + this.id + ");";
			return str;
		}else {
			String str = "\n\tprintf(\"%f\", " + this.id + ");";
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
