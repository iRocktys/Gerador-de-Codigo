
public class ComandoCadeia extends Comando{
	
	private String cadeia;
	
	public ComandoCadeia(String cadeia) {
		this.cadeia = cadeia;
	}
	
	
	
	@Override
	public String generateCode() {
		
		String str = "\n\tprintf(" + this.cadeia + ");";
		
		return str;
	}



	public String getCadeia() {
		return cadeia;
	}

	public void setCadeia(String cadeia) {
		this.cadeia = cadeia;
	}
}
