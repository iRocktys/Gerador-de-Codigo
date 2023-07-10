// Generated from GyhLang.g4 by ANTLR 4.7.2

	//Fazer importacoes
	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Atrib=1, Delim=2, PCProg=3, PCDec=4, PCIni=5, PCFim=6, PCInt=7, PCReal=8, 
		PCLer=9, PCImprimir=10, PCSe=11, PCEntao=12, PCEnqto=13, PCSenao=14, Cadeia=15, 
		Var=16, NUMReal=17, NUMInt=18, AbrePar=19, FechaPar=20, OpBoolE=21, OpBoolOu=22, 
		OpArit=23, OpRel=24, Comment=25, WS=26;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_tipoVar = 3, 
		RULE_listaComandos = 4, RULE_comando = 5, RULE_comandoAtribuicao = 6, 
		RULE_comandoEntrada = 7, RULE_comandoSaida = 8, RULE_comandoCadeia = 9, 
		RULE_comandoCondicao = 10, RULE_comandoRepeticao = 11, RULE_expressaoAritmetica = 12, 
		RULE_termoAritmetico = 13, RULE_fatorAritmetico = 14, RULE_expressaoRelacional = 15, 
		RULE_termoRelacional = 16, RULE_subAlgoritmo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "tipoVar", "listaComandos", 
			"comando", "comandoAtribuicao", "comandoEntrada", "comandoSaida", "comandoCadeia", 
			"comandoCondicao", "comandoRepeticao", "expressaoAritmetica", "termoAritmetico", 
			"fatorAritmetico", "expressaoRelacional", "termoRelacional", "subAlgoritmo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "':'", "'PROG'", "'DEC'", "'INI'", "'FIM'", "'INT'", "'REAL'", 
			"'LER'", "'IMPRIMIR'", "'SE'", "'ENTAO'", "'ENQTO'", "'SENAO'", null, 
			null, null, null, "'('", "')'", "'E'", "'OU'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Atrib", "Delim", "PCProg", "PCDec", "PCIni", "PCFim", "PCInt", 
			"PCReal", "PCLer", "PCImprimir", "PCSe", "PCEntao", "PCEnqto", "PCSenao", 
			"Cadeia", "Var", "NUMReal", "NUMInt", "AbrePar", "FechaPar", "OpBoolE", 
			"OpBoolOu", "OpArit", "OpRel", "Comment", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GyhLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public GyhLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public List<TerminalNode> Delim() { return getTokens(GyhLangParser.Delim); }
		public TerminalNode Delim(int i) {
			return getToken(GyhLangParser.Delim, i);
		}
		public TerminalNode PCDec() { return getToken(GyhLangParser.PCDec, 0); }
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public TerminalNode PCProg() { return getToken(GyhLangParser.PCProg, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(Delim);
			setState(37);
			match(PCDec);
			setState(38);
			listaDeclaracoes();
			setState(39);
			match(Delim);
			setState(40);
			match(PCProg);
			setState(41);
			listaComandos();
			program.setVarTabela(_varTabela);
				program.setComando(_listaComandos);
				program.generateTarget();

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitListaDeclaracoes(this);
		}
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaDeclaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				declaracao();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Var );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhLangParser.Var, 0); }
		public TerminalNode Delim() { return getToken(GyhLangParser.Delim, 0); }
		public TipoVarContext tipoVar() {
			return getRuleContext(TipoVarContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(Var);
			setState(50);
			match(Delim);
			setState(51);
			tipoVar();

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
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoVarContext extends ParserRuleContext {
		public TerminalNode PCInt() { return getToken(GyhLangParser.PCInt, 0); }
		public TerminalNode PCReal() { return getToken(GyhLangParser.PCReal, 0); }
		public TipoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterTipoVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitTipoVar(this);
		}
	}

	public final TipoVarContext tipoVar() throws RecognitionException {
		TipoVarContext _localctx = new TipoVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipoVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==PCInt || _la==PCReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitListaComandos(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				comando();

										_listaComandos.addAll(_listaComandosAux);
										_listaComandosAux.removeAll(_listaComandosAux);
										
									
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCEnqto) | (1L << Var))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public ComandoAtribuicaoContext comandoAtribuicao() {
			return getRuleContext(ComandoAtribuicaoContext.class,0);
		}
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoCondicaoContext comandoCondicao() {
			return getRuleContext(ComandoCondicaoContext.class,0);
		}
		public ComandoCadeiaContext comandoCadeia() {
			return getRuleContext(ComandoCadeiaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comando);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				comandoAtribuicao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				comandoEntrada();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				comandoRepeticao();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				comandoSaida();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				comandoCondicao();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				comandoCadeia();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoAtribuicaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhLangParser.Var, 0); }
		public TerminalNode Atrib() { return getToken(GyhLangParser.Atrib, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ComandoAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoAtribuicao(this);
		}
	}

	public final ComandoAtribuicaoContext comandoAtribuicao() throws RecognitionException {
		ComandoAtribuicaoContext _localctx = new ComandoAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(Var);
				
										// Verificacao se as variaveis utilizadas estao declaradas						
										if(!_varTabela.contem(_input.LT(-1).getText())) {
								   			System.out.println("Error 420: Variavel <"+ _input.LT(-1).getText()+"> nao declarada");
								   			System.exit(1);
								   		}
										_varId = _input.LT(-1).getText();
								   		_expVar = "";
									
			setState(73);
			match(Atrib);
			setState(74);
			expressaoAritmetica();

										ComandoAtribuicao cmd = new ComandoAtribuicao(_varId, _expVar);
										_listaComandosAux.add(cmd);							
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode PCLer() { return getToken(GyhLangParser.PCLer, 0); }
		public TerminalNode Var() { return getToken(GyhLangParser.Var, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoEntrada(this);
		}
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(PCLer);
			setState(78);
			match(Var);
				
										// Acessar o conteudo da classe de TabelaVariavel
										HashMap<String, Variavel> variaveis = _varTabela.getTabela();
										
										// objeto coleta o tipo da variavel, e coloca em _varTipo
								        Variavel objeto = variaveis.get(_input.LT(-1).getText());
								        _varTipo = objeto.getTipo();
										_varLeitura = _input.LT(-1).getText();
										
									    ComandoLeitura cmd = new ComandoLeitura(_varLeitura, _varTipo);
										_listaComandosAux.add(cmd);
									  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GyhLangParser.PCImprimir, 0); }
		public TerminalNode Var() { return getToken(GyhLangParser.Var, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoSaida(this);
		}
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comandoSaida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(PCImprimir);
			setState(82);
			match(Var);
			  											
											// Acessar o conteudo da classe de TabelaVariavel
											HashMap<String, Variavel> variaveis = _varTabela.getTabela();
											
											// objeto coleta o tipo da variavel, e coloca em _varTipo
									        Variavel objeto = variaveis.get(_input.LT(-1).getText());
									        _varTipo = objeto.getTipo();						
											_varEscrita = _input.LT(-1).getText();	
																									
										  	ComandoEscrita cmd = new ComandoEscrita(_varEscrita, _varTipo);
										  	_listaComandosAux.add(cmd);
										 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoCadeiaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GyhLangParser.PCImprimir, 0); }
		public TerminalNode Cadeia() { return getToken(GyhLangParser.Cadeia, 0); }
		public ComandoCadeiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCadeia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoCadeia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoCadeia(this);
		}
	}

	public final ComandoCadeiaContext comandoCadeia() throws RecognitionException {
		ComandoCadeiaContext _localctx = new ComandoCadeiaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comandoCadeia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(PCImprimir);
			setState(86);
			match(Cadeia);

												ComandoCadeia cmd = new ComandoCadeia(_input.LT(-1).getText());							
												_listaComandosAux.add(cmd);
											 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoCondicaoContext extends ParserRuleContext {
		public TerminalNode PCSe() { return getToken(GyhLangParser.PCSe, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GyhLangParser.PCEntao, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode PCSenao() { return getToken(GyhLangParser.PCSenao, 0); }
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoCondicao(this);
		}
	}

	public final ComandoCondicaoContext comandoCondicao() throws RecognitionException {
		ComandoCondicaoContext _localctx = new ComandoCondicaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comandoCondicao);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(PCSe);
				_expVar = "";_varCondicao = "";
				setState(91);
				expressaoRelacional();
				setState(92);
				match(PCEntao);
				setState(93);
				comando();

								 			
								 			_listaVerdade.addAll(_listaComandosAux);				 	
								 			_listaComandosAux.removeAll(_listaComandosAux);
								 		
								 		
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(95);
					match(PCSenao);
					setState(96);
					comando();

									 			_listaFalso.addAll(_listaComandosAux);
									 			_listaComandosAux.removeAll(_listaComandosAux);				 
									 		
					}
					break;
				}
							 			
								 			ComandoCondicao cmd = new ComandoCondicao(_varCondicao, _listaVerdade, _listaFalso);
								 			_listaComandosAux.add(cmd);				 			
								 			
								 		
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(PCSe);
				_expVar = "";_varCondicao = "";_listaVerdade.removeAll(_listaVerdade);
				setState(105);
				expressaoRelacional();
				setState(106);
				match(PCEntao);
				setState(107);
				subAlgoritmo();
								
								 			_listaSubAlgoritmo.addAll(_listaComandosAux);				 	
								 			_listaComandosAux.removeAll(_listaComandosAux);
								 		
								 		
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(109);
					match(PCSenao);
					setState(110);
					comando();

									 			_listaFalso.addAll(_listaComandosAux);
									 			_listaComandosAux.removeAll(_listaComandosAux);				 
									 		
					}
					break;
				}
							 			
								 			ComandoCondicao cmd = new ComandoCondicao(_varCondicao, _listaVerdade, _listaFalso);
								 			_listaComandosAux.add(cmd);				 			
								 			
								 		
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public TerminalNode PCEnqto() { return getToken(GyhLangParser.PCEnqto, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitComandoRepeticao(this);
		}
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comandoRepeticao);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(PCEnqto);
				_expVar = ""; _varCondicao = "";
				setState(121);
				expressaoRelacional();
				setState(122);
				comando();
								
										
									 	_listaRepeticao.addAll(_listaComandosAux);			 	
							   		 	_listaComandosAux.removeAll(_listaComandosAux);	
							   		 	
										ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _listaRepeticao);
										_listaComandosAux.add(cmd);		
											
									
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(PCEnqto);
				_expVar = ""; _varCondicao = "";
				setState(127);
				expressaoRelacional();
				setState(128);
				subAlgoritmo();
								
										
									 	_listaRepeticao.addAll(_listaComandosAux);		 	
							   		 	_listaComandosAux.removeAll(_listaComandosAux);	
										
										_expVar = _input.LT(-1).getText();	
										if(_expVar.equals("FIM")){
											ComandoRepeticao cmd = new ComandoRepeticao(_varCondicao, _listaRepeticao);
											_listaComandosAux.add(cmd);
										}
										
									
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public List<TermoAritmeticoContext> termoAritmetico() {
			return getRuleContexts(TermoAritmeticoContext.class);
		}
		public TermoAritmeticoContext termoAritmetico(int i) {
			return getRuleContext(TermoAritmeticoContext.class,i);
		}
		public List<TerminalNode> OpArit() { return getTokens(GyhLangParser.OpArit); }
		public TerminalNode OpArit(int i) {
			return getToken(GyhLangParser.OpArit, i);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitExpressaoAritmetica(this);
		}
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressaoAritmetica);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(133);
					termoAritmetico();
					setState(134);
					match(OpArit);
					 _expVar += _input.LT(-1).getText();
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(142);
			termoAritmetico();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoAritmeticoContext extends ParserRuleContext {
		public List<FatorAritmeticoContext> fatorAritmetico() {
			return getRuleContexts(FatorAritmeticoContext.class);
		}
		public FatorAritmeticoContext fatorAritmetico(int i) {
			return getRuleContext(FatorAritmeticoContext.class,i);
		}
		public List<TerminalNode> OpArit() { return getTokens(GyhLangParser.OpArit); }
		public TerminalNode OpArit(int i) {
			return getToken(GyhLangParser.OpArit, i);
		}
		public TermoAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterTermoAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitTermoAritmetico(this);
		}
	}

	public final TermoAritmeticoContext termoAritmetico() throws RecognitionException {
		TermoAritmeticoContext _localctx = new TermoAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termoAritmetico);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					fatorAritmetico();
					setState(145);
					match(OpArit);
					 _expVar += _input.LT(-1).getText();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(153);
			fatorAritmetico();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorAritmeticoContext extends ParserRuleContext {
		public TerminalNode NUMInt() { return getToken(GyhLangParser.NUMInt, 0); }
		public TerminalNode NUMReal() { return getToken(GyhLangParser.NUMReal, 0); }
		public TerminalNode Var() { return getToken(GyhLangParser.Var, 0); }
		public TerminalNode AbrePar() { return getToken(GyhLangParser.AbrePar, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhLangParser.FechaPar, 0); }
		public FatorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterFatorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitFatorAritmetico(this);
		}
	}

	public final FatorAritmeticoContext fatorAritmetico() throws RecognitionException {
		FatorAritmeticoContext _localctx = new FatorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fatorAritmetico);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(NUMInt);
				 _expVar += _input.LT(-1).getText();
				}
				break;
			case NUMReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(NUMReal);
				 _expVar += _input.LT(-1).getText();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(Var);
				_expVar += _input.LT(-1).getText();
				}
				break;
			case AbrePar:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				match(AbrePar);
				 _expVar += "(";
				setState(163);
				expressaoAritmetica();
				setState(164);
				match(FechaPar);
				 _expVar += ")";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public List<TermoRelacionalContext> termoRelacional() {
			return getRuleContexts(TermoRelacionalContext.class);
		}
		public TermoRelacionalContext termoRelacional(int i) {
			return getRuleContext(TermoRelacionalContext.class,i);
		}
		public List<TerminalNode> OpBoolE() { return getTokens(GyhLangParser.OpBoolE); }
		public TerminalNode OpBoolE(int i) {
			return getToken(GyhLangParser.OpBoolE, i);
		}
		public List<TerminalNode> OpBoolOu() { return getTokens(GyhLangParser.OpBoolOu); }
		public TerminalNode OpBoolOu(int i) {
			return getToken(GyhLangParser.OpBoolOu, i);
		}
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitExpressaoRelacional(this);
		}
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressaoRelacional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					termoRelacional();
					setState(174);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OpBoolE:
						{
						setState(170);
						match(OpBoolE);
						 _varCondicao += " && ";
						}
						break;
					case OpBoolOu:
						{
						setState(172);
						match(OpBoolOu);
						 _varCondicao += " || ";
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(181);
			termoRelacional();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public TerminalNode OpRel() { return getToken(GyhLangParser.OpRel, 0); }
		public TerminalNode AbrePar() { return getToken(GyhLangParser.AbrePar, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhLangParser.FechaPar, 0); }
		public TermoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterTermoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitTermoRelacional(this);
		}
	}

	public final TermoRelacionalContext termoRelacional() throws RecognitionException {
		TermoRelacionalContext _localctx = new TermoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_termoRelacional);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				expressaoAritmetica();
				_varCondicao += _expVar; _expVar = "";
				setState(185);
				match(OpRel);
				_varCondicao += _input.LT(-1).getText();
				setState(187);
				expressaoAritmetica();
				_varCondicao += _expVar; _expVar = "";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(AbrePar);
				_varCondicao = "(";
				setState(192);
				expressaoRelacional();
				setState(193);
				match(FechaPar);
				_varCondicao = ")";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubAlgoritmoContext extends ParserRuleContext {
		public TerminalNode PCIni() { return getToken(GyhLangParser.PCIni, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode PCFim() { return getToken(GyhLangParser.PCFim, 0); }
		public SubAlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).enterSubAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhLangListener ) ((GyhLangListener)listener).exitSubAlgoritmo(this);
		}
	}

	public final SubAlgoritmoContext subAlgoritmo() throws RecognitionException {
		SubAlgoritmoContext _localctx = new SubAlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subAlgoritmo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(PCIni);
			setState(199);
			listaComandos();

								//System.out.println(_input.LT(-1).getText());
								SubAlgoritmo cmd = new SubAlgoritmo(_listaComandosAux);
								_listaComandosAux.add(cmd);
							
			setState(201);
			match(PCFim);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00ce\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\60\n\3\r\3\16\3\61"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\6\6>\n\6\r\6\16\6?\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\ff\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\ft\n\f\3\f"+
		"\3\f\5\fx\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0086"+
		"\n\r\3\16\3\16\3\16\3\16\7\16\u008c\n\16\f\16\16\16\u008f\13\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\7\17\u0097\n\17\f\17\16\17\u009a\13\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00aa"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00b1\n\21\7\21\u00b3\n\21\f\21\16"+
		"\21\u00b6\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00c7\n\22\3\23\3\23\3\23\3\23\3\23\3\23\2\2"+
		"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\t\n\2\u00ce\2&"+
		"\3\2\2\2\4/\3\2\2\2\6\63\3\2\2\2\b8\3\2\2\2\n=\3\2\2\2\fG\3\2\2\2\16I"+
		"\3\2\2\2\20O\3\2\2\2\22S\3\2\2\2\24W\3\2\2\2\26w\3\2\2\2\30\u0085\3\2"+
		"\2\2\32\u008d\3\2\2\2\34\u0098\3\2\2\2\36\u00a9\3\2\2\2 \u00b4\3\2\2\2"+
		"\"\u00c6\3\2\2\2$\u00c8\3\2\2\2&\'\7\4\2\2\'(\7\6\2\2()\5\4\3\2)*\7\4"+
		"\2\2*+\7\5\2\2+,\5\n\6\2,-\b\2\1\2-\3\3\2\2\2.\60\5\6\4\2/.\3\2\2\2\60"+
		"\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\64\7\22\2\2\64\65"+
		"\7\4\2\2\65\66\5\b\5\2\66\67\b\4\1\2\67\7\3\2\2\289\t\2\2\29\t\3\2\2\2"+
		":;\5\f\7\2;<\b\6\1\2<>\3\2\2\2=:\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2"+
		"@\13\3\2\2\2AH\5\16\b\2BH\5\20\t\2CH\5\30\r\2DH\5\22\n\2EH\5\26\f\2FH"+
		"\5\24\13\2GA\3\2\2\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2"+
		"H\r\3\2\2\2IJ\7\22\2\2JK\b\b\1\2KL\7\3\2\2LM\5\32\16\2MN\b\b\1\2N\17\3"+
		"\2\2\2OP\7\13\2\2PQ\7\22\2\2QR\b\t\1\2R\21\3\2\2\2ST\7\f\2\2TU\7\22\2"+
		"\2UV\b\n\1\2V\23\3\2\2\2WX\7\f\2\2XY\7\21\2\2YZ\b\13\1\2Z\25\3\2\2\2["+
		"\\\7\r\2\2\\]\b\f\1\2]^\5 \21\2^_\7\16\2\2_`\5\f\7\2`e\b\f\1\2ab\7\20"+
		"\2\2bc\5\f\7\2cd\b\f\1\2df\3\2\2\2ea\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\f"+
		"\1\2hx\3\2\2\2ij\7\r\2\2jk\b\f\1\2kl\5 \21\2lm\7\16\2\2mn\5$\23\2ns\b"+
		"\f\1\2op\7\20\2\2pq\5\f\7\2qr\b\f\1\2rt\3\2\2\2so\3\2\2\2st\3\2\2\2tu"+
		"\3\2\2\2uv\b\f\1\2vx\3\2\2\2w[\3\2\2\2wi\3\2\2\2x\27\3\2\2\2yz\7\17\2"+
		"\2z{\b\r\1\2{|\5 \21\2|}\5\f\7\2}~\b\r\1\2~\u0086\3\2\2\2\177\u0080\7"+
		"\17\2\2\u0080\u0081\b\r\1\2\u0081\u0082\5 \21\2\u0082\u0083\5$\23\2\u0083"+
		"\u0084\b\r\1\2\u0084\u0086\3\2\2\2\u0085y\3\2\2\2\u0085\177\3\2\2\2\u0086"+
		"\31\3\2\2\2\u0087\u0088\5\34\17\2\u0088\u0089\7\31\2\2\u0089\u008a\b\16"+
		"\1\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0091\5\34\17\2\u0091\33\3\2\2\2\u0092\u0093\5\36\20\2\u0093"+
		"\u0094\7\31\2\2\u0094\u0095\b\17\1\2\u0095\u0097\3\2\2\2\u0096\u0092\3"+
		"\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\36\20\2\u009c\35\3\2"+
		"\2\2\u009d\u009e\7\24\2\2\u009e\u00aa\b\20\1\2\u009f\u00a0\7\23\2\2\u00a0"+
		"\u00aa\b\20\1\2\u00a1\u00a2\7\22\2\2\u00a2\u00aa\b\20\1\2\u00a3\u00a4"+
		"\7\25\2\2\u00a4\u00a5\b\20\1\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7\7\26"+
		"\2\2\u00a7\u00a8\b\20\1\2\u00a8\u00aa\3\2\2\2\u00a9\u009d\3\2\2\2\u00a9"+
		"\u009f\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a3\3\2\2\2\u00aa\37\3\2\2"+
		"\2\u00ab\u00b0\5\"\22\2\u00ac\u00ad\7\27\2\2\u00ad\u00b1\b\21\1\2\u00ae"+
		"\u00af\7\30\2\2\u00af\u00b1\b\21\1\2\u00b0\u00ac\3\2\2\2\u00b0\u00ae\3"+
		"\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00b8\5\"\22\2\u00b8!\3\2\2\2\u00b9\u00ba\5\32\16\2\u00ba\u00bb"+
		"\b\22\1\2\u00bb\u00bc\7\32\2\2\u00bc\u00bd\b\22\1\2\u00bd\u00be\5\32\16"+
		"\2\u00be\u00bf\b\22\1\2\u00bf\u00c7\3\2\2\2\u00c0\u00c1\7\25\2\2\u00c1"+
		"\u00c2\b\22\1\2\u00c2\u00c3\5 \21\2\u00c3\u00c4\7\26\2\2\u00c4\u00c5\b"+
		"\22\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00b9\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c7"+
		"#\3\2\2\2\u00c8\u00c9\7\7\2\2\u00c9\u00ca\5\n\6\2\u00ca\u00cb\b\23\1\2"+
		"\u00cb\u00cc\7\b\2\2\u00cc%\3\2\2\2\17\61?Gesw\u0085\u008d\u0098\u00a9"+
		"\u00b0\u00b4\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}