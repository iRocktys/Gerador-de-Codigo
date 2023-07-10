import java.util.ArrayList;

public class ComandoRepeticao extends Comando{
	private String repeticao;
	private ArrayList<Comando> listaRepeticao;
	
	
	public ComandoRepeticao(String repeticao, ArrayList<Comando> listaRepeticao) {
		this.repeticao = repeticao;
		this.listaRepeticao = listaRepeticao;
	}
	
	@Override
	public String generateCode() {
		String str = "\n\n\twhile(" + this.repeticao + "){";
		for(Comando cmd: listaRepeticao) {
			str += cmd.generateCode();
		}//for

		str += "\n\t}";
		return str;
	}//generateCode

	public String getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(String repeticao) {
		this.repeticao = repeticao;
	}

	public ArrayList<Comando> getListaRepeticao() {
		return listaRepeticao;
	}

	public void setListaRepeticao(ArrayList<Comando> listaRepeticao) {
		this.listaRepeticao = listaRepeticao;
	}

	@Override
	public String toString() {
		
		return "[nome="+this.repeticao+"]"; 
	}
}
