import java.util.ArrayList;

public class ComandoCondicao extends Comando {

	private String condicao;
	private ArrayList<Comando> listaVerdade;
	private ArrayList<Comando> listaFalso;

	public ComandoCondicao(String condicao, ArrayList<Comando> listaVerdade, ArrayList<Comando> listaFalso) {
		this.condicao = condicao;
		this.listaVerdade = listaVerdade;
		this.listaFalso = listaFalso;
	}//constructor
	
	@Override
	public String generateCode() {
		String str = "\n\n\tif(" + this.condicao + "){";
		
		for(Comando cmd: listaVerdade) {
			//System.out.println(cmd);
			str +=  cmd.generateCode();
		}//for
		
		str += "\n\t}";
		
		if(!listaFalso.isEmpty()) {
			str += " else {";
			for(Comando cmd: listaFalso) {
				str += cmd.generateCode();
			}//for
			str += "\n\t}";
		}//if
		
		return str;
	}//generateCode

}//ComandoCondicao
