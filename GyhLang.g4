grammar GyhLang;

@header{
	//Fazer importacoes
	import java.util.*;
}

@members{
	private String _varNome;
	private String _varTipo;
	private String _varValor;
	private Variavel _varVariavel;
	private String _varEscrita;
	private String _varLeitura;
	private String _expVar;
	private String _expConteudo;
	private String _varCondicao;
	private String _varId;
	private String _auxRepeticao;
	
	// -----
	private TabelaVariavel _varTabela = new TabelaVariavel();
	private GyhProgram program = new GyhProgram();
	
	// -----
	private ArrayList<Comando> _listaVerdade = new ArrayList<Comando>();
	private ArrayList<Comando> _listaFalso = new ArrayList<Comando>();
	private ArrayList<Comando> _listaRepeticao = new ArrayList<Comando>();
	private ArrayList<Comando> _listaSubAlgoritmo = new ArrayList<Comando>();
	private ArrayList<Comando> _listaComandos = new ArrayList<Comando>();
	private ArrayList<Comando> _listaComandosAux = new ArrayList<Comando>();
	
	public void generateCommand(){
		program.generateTarget();
	}
	
	public void addTabelaVariavel(String nome, String tipo, String valor){
		_varVariavel = new Variavel(nome, tipo, valor);
			
		if(_varTabela.contem(nome)){
			System.out.println("Erro semantico, variavel já declarada"+ _varVariavel);
		}else{
			_varTabela.addVariavel(_varVariavel);
		}
	}// addTabelaVariavel
}

// ------------------------------------------------
// ------  ANALISE SEMANTICA / SINTATICA ----------
// ------------------------------------------------

programa: Delim PCDec listaDeclaracoes Delim PCProg listaComandos
	{program.setVarTabela(_varTabela);
	program.setComando(_listaComandos);
	program.generateTarget();
};

listaDeclaracoes:(declaracao)+;

declaracao: Var Delim tipoVar{
								_varNome = _input.LT(-3).getText();
								_varTipo = _input.LT(-1).getText();
								_varValor = null;
								//System.out.println(_varTipo);
								
								_varVariavel = new Variavel(_varNome, _varTipo, _varValor);
								//System.out.println(_varVariavel);
								
								// Adicionar as variaveis em uma tabela caso nao existirem
								if(!_varTabela.contem(_varNome)){
									_varTabela.addVariavel(_varVariavel);
								}else{
									System.out.println("Error 420: Variavel <" + _varNome+"> ja existe");
									System.exit(1);
								}
							}; 

tipoVar: PCInt | PCReal;

listaComandos: (comando
					{
						_listaComandos.addAll(_listaComandosAux);
						_listaComandosAux.removeAll(_listaComandosAux);
						
					}
				)+;

comando: 	comandoAtribuicao 
		| 	comandoEntrada 
		| 	comandoRepeticao 
		| 	comandoSaida 
		| 	comandoCondicao 
		| 	comandoCadeia;

comandoAtribuicao: Var {	
							// Verificacao se as variaveis utilizadas estao declaradas						
							if(!_varTabela.contem(_input.LT(-1).getText())) {
					   			System.out.println("Error 420: Variavel <"+ _input.LT(-1).getText()+"> nao declarada");
					   			System.exit(1);
					   		}
							_varId = _input.LT(-1).getText();
					   		_expVar = "";
						}
						Atrib expressaoAritmetica
						{
							ComandoAtribuicao cmd = new ComandoAtribuicao(_varId, _expVar);
							_listaComandosAux.add(cmd);							
						};

comandoEntrada: PCLer Var {	
							// Acessar o conteudo da classe de TabelaVariavel
							HashMap<String, Variavel> variaveis = _varTabela.getTabela();
							
							// objeto coleta o tipo da variavel, e coloca em _varTipo
					        Variavel objeto = variaveis.get(_input.LT(-1).getText());
					        _varTipo = objeto.getTipo();
							_varLeitura = _input.LT(-1).getText();
							
						    ComandoLeitura cmd = new ComandoLeitura(_varLeitura, _varTipo);
							_listaComandosAux.add(cmd);
						  };

comandoSaida: PCImprimir Var {  											
								// Acessar o conteudo da classe de TabelaVariavel
								HashMap<String, Variavel> variaveis = _varTabela.getTabela();
								
								// objeto coleta o tipo da variavel, e coloca em _varTipo
						        Variavel objeto = variaveis.get(_input.LT(-1).getText());
						        _varTipo = objeto.getTipo();						
								_varEscrita = _input.LT(-1).getText();	
																						
							  	ComandoEscrita cmd = new ComandoEscrita(_varEscrita, _varTipo);
							  	_listaComandosAux.add(cmd);
							 };
							 
comandoCadeia: PCImprimir Cadeia {
									ComandoCadeia cmd = new ComandoCadeia(_input.LT(-1).getText());							
									_listaComandosAux.add(cmd);
								 };						 
		
comandoCondicao: 	PCSe {_expVar = "";_varCondicao = "";}
				 	expressaoRelacional 			 
				 	PCEntao comando
				 		{
				 			
				 			_listaVerdade.addAll(_listaComandosAux);				 	
				 			_listaComandosAux.removeAll(_listaComandosAux);
				 		
				 		}
				 	(PCSenao comando
				 		{
				 			_listaFalso.addAll(_listaComandosAux);
				 			_listaComandosAux.removeAll(_listaComandosAux);				 
				 		}			 
				 	)?
				 		{			 			
				 			ComandoCondicao cmd = new ComandoCondicao(_varCondicao, _listaVerdade, _listaFalso);
				 			_listaComandosAux.add(cmd);				 			
				 			
				 		}
				 |	PCSe {_expVar = "";_varCondicao = "";_listaVerdade.removeAll(_listaVerdade);}
				 	expressaoRelacional 			 
				 	PCEntao subAlgoritmo
				 		{				
				 			_listaSubAlgoritmo.addAll(_listaComandosAux);				 	
				 			_listaComandosAux.removeAll(_listaComandosAux);
				 		
				 		}
				 	(PCSenao comando
				 		{
				 			_listaFalso.addAll(_listaComandosAux);
				 			_listaComandosAux.removeAll(_listaComandosAux);				 
				 		}			 
				 	)?
				 		{			 			
				 			ComandoCondicao cmd = new ComandoCondicao(_varCondicao, _listaVerdade, _listaFalso);
				 			_listaComandosAux.add(cmd);				 			
				 			
				 		}
				 	;

comandoRepeticao: 	PCEnqto {_expVar = ""; _varCondicao = "";}
					expressaoRelacional 
					comando {				
						
					 	_listaRepeticao.addAll(_listaComandosAux);			 	
			   		 	_listaComandosAux.removeAll(_listaComandosAux);	
			   		 	
						ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _listaRepeticao);
						_listaComandosAux.add(cmd);		
							
					}
					
				|	PCEnqto {_expVar = ""; _varCondicao = "";}
					expressaoRelacional 
					subAlgoritmo {				
						
					 	_listaRepeticao.addAll(_listaComandosAux);		 	
			   		 	_listaComandosAux.removeAll(_listaComandosAux);	
						
						_expVar = _input.LT(-1).getText();	
						if(_expVar.equals("FIM")){
							ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _listaRepeticao);
							_listaComandosAux.add(cmd);
						}
						
					};

expressaoAritmetica: (termoAritmetico OpArit { _expVar += _input.LT(-1).getText();})* termoAritmetico;

termoAritmetico: (fatorAritmetico OpArit { _expVar += _input.LT(-1).getText();})* fatorAritmetico;

fatorAritmetico: NUMInt { _expVar += _input.LT(-1).getText();}					
 			   | NUMReal { _expVar += _input.LT(-1).getText();}
 			   | Var {_expVar += _input.LT(-1).getText();}
 			   | AbrePar { _expVar += "(";}
 			     expressaoAritmetica
 			     FechaPar { _expVar += ")";};

expressaoRelacional: (termoRelacional (OpBoolE { _varCondicao += " && ";}| OpBoolOu { _varCondicao += " || ";}))* termoRelacional ;

termoRelacional: expressaoAritmetica {_varCondicao += _expVar; _expVar = "";} 
				 OpRel				 {_varCondicao += _input.LT(-1).getText();}
				 expressaoAritmetica {_varCondicao += _expVar; _expVar = "";} | 
				 AbrePar 			 {_varCondicao = "(";} 
				 expressaoRelacional 
				 FechaPar			 {_varCondicao = ")";};
				 

subAlgoritmo: 	PCIni listaComandos 
				{
					//System.out.println(_input.LT(-1).getText());
					SubAlgoritmo cmd = new SubAlgoritmo(_listaComandosAux);
					_listaComandosAux.add(cmd);
				} PCFim;



// ------------------------------------------------
// ----------------- ANALISE LEXICA ---------------
// ------------------------------------------------

Atrib: ':=';		// Comando de atribuição
Delim: ':';			// Delimitador
PCProg: 'PROG';		// Iniciação do programa
PCDec: 'DEC';		// Inicialização das variáveis

// Comando SubAlgoritmo
PCIni: 'INI';	
PCFim: 'FIM';	

// Tipo de variável
PCInt: 'INT';
PCReal: 'REAL';

// Comandos de escrita e leitura
PCLer: 'LER';
PCImprimir: 'IMPRIMIR';

// Comandos de condição
PCSe: 'SE';
PCEntao: 'ENTAO';
PCEnqto: 'ENQTO';
PCSenao: 'SENAO';

Cadeia: '"' ~('\n')* '"';
Var: [a-z] ( [a-z] | [A-Z] | [0-9] )*;

NUMReal: [0-9]*'.'[0-9]+;
NUMInt: [0-9]+;

AbrePar: '(';
FechaPar: ')';

OpBoolE: 'E';
OpBoolOu: 'OU';

OpArit: '+' | '-' | '*' | '/';
OpRel: '>=' | '<=' | '==' | '>' |'<' | '!=';

Comment: '#' ~('\n')* '\n' -> skip;
WS: (' ' | '\n' | '\t' | '\r') -> skip;


//Codigo para contar declaracoes (Comentado)
/*listaDeclaracoes return [int qtdDec]: {$qtdDec=0;} 
				  (declaracao
				  {$qtdDec++;})+
				  {System.out.println("Declaracoes: " + $qtdDec);};*/
