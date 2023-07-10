
public class ComandoAtribuicao extends Comando {

	private String id;
	private String exp;
	
	public ComandoAtribuicao(String id, String exp) {
		this.id = id;
		this.exp = exp;
		
	}//constructor 

	@Override
	public String generateCode() {	
		return  "\n\t"+ this.id + " = " + this.exp  + ";"; // id = exp;
	}//generateCode

	public String getId() {
		return id;
	}//getId

	public void setId(String id) {
		this.id = id;
	}//setID
	
	@Override
	public String toString() {
		
		return "[variavel="+this.id+"\t | Atribuicao="+this.exp +"]"; 
	}
}//ComandoAtribuicao
