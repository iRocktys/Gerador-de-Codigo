import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GyhProgram {
	private TabelaVariavel varTabela;
	private ArrayList<Comando> comando;

	public TabelaVariavel getVarTabela() {
		return varTabela;
	}//getVarTabela

	public void setVarTabela(TabelaVariavel varTabela) {
		this.varTabela = varTabela;
	}//setVarTabela
	
	public ArrayList<Comando> getComando() {
		return comando;
	}

	public void setComando(ArrayList<Comando> comando) {
		this.comando = comando;
	}

	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		
		str.append("#include <stdio.h>\n");
		str.append("#include <stdlib.h>\n");
		str.append("#include <stdbool.h>\n");
		str.append("#include <string.h>\n");
		str.append("\n\nint main(){\n");
		
		for(Variavel Variavel: varTabela.getAll()) {
			str.append(Variavel.generateCode());
			//System.out.println(str);
		}
		
		for(Comando cmd: comando) {
			
			str.append(cmd.generateCode());
			
		}
		
		str.append("\n\n\treturn 0;\n");
		str.append("}\n");
		
		FileWriter file;
		try {
			file = new FileWriter(new File("codigo.c"));
			file.write(str.toString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//generateTarget
	


} //GyhProgram
