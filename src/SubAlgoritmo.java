import java.util.ArrayList;

public class SubAlgoritmo extends Comando{
private ArrayList<Comando> listaSubAlgoritmo;
	
	public SubAlgoritmo(ArrayList<Comando> listaSubAlgoritmo) {
		this.listaSubAlgoritmo = listaSubAlgoritmo;
	}
	

	@Override
	public String generateCode() {
		String str = "";
		
		for(Comando cmd: listaSubAlgoritmo) {
			 str += cmd.generateCode();
		}//for
		return str;
	}

}
