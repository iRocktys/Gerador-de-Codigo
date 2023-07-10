import java.util.ArrayList;
import java.util.HashMap;

public class TabelaVariavel {
	private HashMap<String, Variavel> tabela;
	
	public ArrayList<Variavel> getAll(){
		ArrayList<Variavel> lista = new ArrayList<Variavel>();
		for(Variavel Variavel: tabela.values()) {
			lista.add(Variavel);
		}
		return lista;
	}
	
	public TabelaVariavel() {
		this.tabela = new HashMap<String, Variavel>();
	}

	public HashMap<String, Variavel> getTabela() {
		return tabela;
	}

	public void setTabela(HashMap<String, Variavel> tabela) {
		this.tabela = tabela;
	}
	
	
	public void addVariavel(Variavel Variavel) {
		this.tabela.put(Variavel.getNome(), Variavel);	
	}
	
	public boolean contem(String nome) {
		return this.tabela.get(nome) != null;
	}
}
