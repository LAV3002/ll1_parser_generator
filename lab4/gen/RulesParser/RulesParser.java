// Generated from D:/mt/lab4/src/RulesParser/Rules.g4 by ANTLR 4.13.1
package RulesParser;

    import org.antlr.v4.runtime.*;
    import java.util.*;
    import java.lang.*;
    import Symbol.*;
    import Rules.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STRING=10, TERMINAL=11, WS=12, CODE=13;
	public static final int
		RULE_start = 0, RULE_declaration = 1, RULE_nonterminalsDeclarations = 2, 
		RULE_nonterminalDeclaration = 3, RULE_varsDeclaration = 4, RULE_varDeclaration = 5, 
		RULE_rules = 6, RULE_rule = 7, RULE_symbols = 8, RULE_symbol = 9, RULE_args = 10, 
		RULE_arg = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "declaration", "nonterminalsDeclarations", "nonterminalDeclaration", 
			"varsDeclaration", "varDeclaration", "rules", "rule", "symbols", "symbol", 
			"args", "arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'declaration'", "'{'", "'}'", "'('", "')'", "'->'", "','", "'$'", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "STRING", 
			"TERMINAL", "WS", "CODE"
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
	public String getGrammarFileName() { return "Rules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RulesParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			declaration();
			setState(25);
			rules();
			setState(26);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public List<NonterminalDeclaration> res;
		public NonterminalsDeclarationsContext nonterminalsDeclarations;
		public NonterminalsDeclarationsContext nonterminalsDeclarations() {
			return getRuleContext(NonterminalsDeclarationsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			match(T__1);
			setState(30);
			((DeclarationContext)_localctx).nonterminalsDeclarations = nonterminalsDeclarations();
			setState(31);
			match(T__2);
			 ((DeclarationContext)_localctx).res =  ((DeclarationContext)_localctx).nonterminalsDeclarations.res; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class NonterminalsDeclarationsContext extends ParserRuleContext {
		public List<NonterminalDeclaration> res;
		public NonterminalDeclarationContext nd;
		public NonterminalsDeclarationsContext nds;
		public NonterminalDeclarationContext nonterminalDeclaration() {
			return getRuleContext(NonterminalDeclarationContext.class,0);
		}
		public NonterminalsDeclarationsContext nonterminalsDeclarations() {
			return getRuleContext(NonterminalsDeclarationsContext.class,0);
		}
		public NonterminalsDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminalsDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterNonterminalsDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitNonterminalsDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitNonterminalsDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonterminalsDeclarationsContext nonterminalsDeclarations() throws RecognitionException {
		NonterminalsDeclarationsContext _localctx = new NonterminalsDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nonterminalsDeclarations);

		    ((NonterminalsDeclarationsContext)_localctx).res =  new ArrayList<>();

		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				((NonterminalsDeclarationsContext)_localctx).nd = nonterminalDeclaration();
				 _localctx.res.add(((NonterminalsDeclarationsContext)_localctx).nd.res); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				((NonterminalsDeclarationsContext)_localctx).nd = nonterminalDeclaration();
				setState(39);
				((NonterminalsDeclarationsContext)_localctx).nds = nonterminalsDeclarations();

				                                                             _localctx.res.add(((NonterminalsDeclarationsContext)_localctx).nd.res);
				                                                             _localctx.res.addAll(((NonterminalsDeclarationsContext)_localctx).nds.res);
				                                                           
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

	@SuppressWarnings("CheckReturnValue")
	public static class NonterminalDeclarationContext extends ParserRuleContext {
		public NonterminalDeclaration res;
		public Token nt;
		public VarsDeclarationContext inh;
		public VarsDeclarationContext synt;
		public TerminalNode STRING() { return getToken(RulesParser.STRING, 0); }
		public List<VarsDeclarationContext> varsDeclaration() {
			return getRuleContexts(VarsDeclarationContext.class);
		}
		public VarsDeclarationContext varsDeclaration(int i) {
			return getRuleContext(VarsDeclarationContext.class,i);
		}
		public NonterminalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterNonterminalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitNonterminalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitNonterminalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonterminalDeclarationContext nonterminalDeclaration() throws RecognitionException {
		NonterminalDeclarationContext _localctx = new NonterminalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nonterminalDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			((NonterminalDeclarationContext)_localctx).nt = match(STRING);
			setState(45);
			match(T__3);
			setState(46);
			((NonterminalDeclarationContext)_localctx).inh = varsDeclaration();
			setState(47);
			match(T__4);
			setState(48);
			match(T__5);
			setState(49);
			match(T__3);
			setState(50);
			((NonterminalDeclarationContext)_localctx).synt = varsDeclaration();
			setState(51);
			match(T__4);
			 ((NonterminalDeclarationContext)_localctx).res =  new NonterminalDeclaration((((NonterminalDeclarationContext)_localctx).nt!=null?((NonterminalDeclarationContext)_localctx).nt.getText():null), ((NonterminalDeclarationContext)_localctx).inh.res, ((NonterminalDeclarationContext)_localctx).synt.res); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarsDeclarationContext extends ParserRuleContext {
		public List<VarDeclaration> res;
		public VarDeclarationContext vd;
		public VarsDeclarationContext vds;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarsDeclarationContext varsDeclaration() {
			return getRuleContext(VarsDeclarationContext.class,0);
		}
		public VarsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterVarsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitVarsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitVarsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsDeclarationContext varsDeclaration() throws RecognitionException {
		VarsDeclarationContext _localctx = new VarsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varsDeclaration);

		    ((VarsDeclarationContext)_localctx).res =  new ArrayList<>();

		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				((VarsDeclarationContext)_localctx).vd = varDeclaration();
				 _localctx.res.add(((VarsDeclarationContext)_localctx).vd.res); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				((VarsDeclarationContext)_localctx).vd = varDeclaration();
				setState(59);
				match(T__6);
				setState(60);
				((VarsDeclarationContext)_localctx).vds = varsDeclaration();

				                                                 _localctx.res.add(((VarsDeclarationContext)_localctx).vd.res);
				                                                 _localctx.res.addAll(((VarsDeclarationContext)_localctx).vds.res);
				                                                
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration res;
		public Token f;
		public Token s;
		public List<TerminalNode> STRING() { return getTokens(RulesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RulesParser.STRING, i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((VarDeclarationContext)_localctx).f = match(STRING);
			setState(66);
			((VarDeclarationContext)_localctx).s = match(STRING);
			 ((VarDeclarationContext)_localctx).res =  new VarDeclaration((((VarDeclarationContext)_localctx).f!=null?((VarDeclarationContext)_localctx).f.getText():null), (((VarDeclarationContext)_localctx).s!=null?((VarDeclarationContext)_localctx).s.getText():null)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class RulesContext extends ParserRuleContext {
		public List<Rule> res;
		public RuleContext rl;
		public RulesContext rls;
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rules);

		    ((RulesContext)_localctx).res =  new ArrayList<>();

		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((RulesContext)_localctx).rl = rule_();
				 _localctx.res.add(((RulesContext)_localctx).rl.res); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((RulesContext)_localctx).rl = rule_();
				setState(73);
				((RulesContext)_localctx).rls = rules();
				 _localctx.res.add(((RulesContext)_localctx).rl.res); _localctx.res.addAll(((RulesContext)_localctx).rls.res); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public Rule res;
		public Token left;
		public SymbolsContext right;
		public TerminalNode STRING() { return getToken(RulesParser.STRING, 0); }
		public SymbolsContext symbols() {
			return getRuleContext(SymbolsContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((RuleContext)_localctx).left = match(STRING);
			setState(79);
			match(T__5);
			setState(80);
			((RuleContext)_localctx).right = symbols();
			 ((RuleContext)_localctx).res =  new Rule((((RuleContext)_localctx).left!=null?((RuleContext)_localctx).left.getText():null), ((RuleContext)_localctx).right.res); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolsContext extends ParserRuleContext {
		public List<Symbol> res;
		public SymbolContext symb;
		public SymbolsContext symbs;
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public SymbolsContext symbols() {
			return getRuleContext(SymbolsContext.class,0);
		}
		public SymbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterSymbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitSymbols(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitSymbols(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolsContext symbols() throws RecognitionException {
		SymbolsContext _localctx = new SymbolsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_symbols);

		    ((SymbolsContext)_localctx).res =  new ArrayList<>();

		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				((SymbolsContext)_localctx).symb = symbol();
				 _localctx.res.add(((SymbolsContext)_localctx).symb.res); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((SymbolsContext)_localctx).symb = symbol();
				setState(87);
				((SymbolsContext)_localctx).symbs = symbols();
				 _localctx.res.add(((SymbolsContext)_localctx).symb.res); _localctx.res.addAll(((SymbolsContext)_localctx).symbs.res); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolContext extends ParserRuleContext {
		public Symbol res;
		public Token t;
		public Token s;
		public ArgsContext ar;
		public Token c;
		public TerminalNode TERMINAL() { return getToken(RulesParser.TERMINAL, 0); }
		public TerminalNode STRING() { return getToken(RulesParser.STRING, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode CODE() { return getToken(RulesParser.CODE, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_symbol);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((SymbolContext)_localctx).t = match(TERMINAL);

				                    String term = (((SymbolContext)_localctx).t!=null?((SymbolContext)_localctx).t.getText():null);
				                    term = term.substring(1, term.length() - 1);
				                    ((SymbolContext)_localctx).res =  new TerminalSymbol(term);
				                 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((SymbolContext)_localctx).s = match(STRING);
				setState(95);
				match(T__3);
				setState(96);
				((SymbolContext)_localctx).ar = args();
				setState(97);
				match(T__4);
				 ((SymbolContext)_localctx).res =  new NonterminalSymbol((((SymbolContext)_localctx).s!=null?((SymbolContext)_localctx).s.getText():null), ((SymbolContext)_localctx).ar.res); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(T__1);
				setState(101);
				((SymbolContext)_localctx).c = match(CODE);
				setState(102);
				match(T__2);
				 ((SymbolContext)_localctx).res =  new BroadcastingSymbol((((SymbolContext)_localctx).c!=null?((SymbolContext)_localctx).c.getText():null)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<String> res;
		public ArgContext ar;
		public ArgsContext argsp;
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_args);

		    ((ArgsContext)_localctx).res =  new ArrayList<>();

		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				((ArgsContext)_localctx).ar = arg();
				 _localctx.res.add((((ArgsContext)_localctx).ar!=null?_input.getText(((ArgsContext)_localctx).ar.start,((ArgsContext)_localctx).ar.stop):null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				((ArgsContext)_localctx).ar = arg();
				setState(111);
				match(T__6);
				setState(112);
				((ArgsContext)_localctx).argsp = args();
				 _localctx.res.add((((ArgsContext)_localctx).ar!=null?_input.getText(((ArgsContext)_localctx).ar.start,((ArgsContext)_localctx).ar.stop):null)); _localctx.res.addAll(((ArgsContext)_localctx).argsp.res); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public String res;
		public Token f;
		public Token s;
		public Token t;
		public List<TerminalNode> STRING() { return getTokens(RulesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RulesParser.STRING, i);
		}
		public TerminalNode TERMINAL() { return getToken(RulesParser.TERMINAL, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arg);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(T__7);
				setState(118);
				((ArgContext)_localctx).f = match(STRING);
				setState(119);
				match(T__8);
				setState(120);
				((ArgContext)_localctx).s = match(STRING);
				 ((ArgContext)_localctx).res =  "$" + (((ArgContext)_localctx).f!=null?((ArgContext)_localctx).f.getText():null) + "." + (((ArgContext)_localctx).s!=null?((ArgContext)_localctx).s.getText():null); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				((ArgContext)_localctx).f = match(STRING);
				 ((ArgContext)_localctx).res =  (((ArgContext)_localctx).f!=null?((ArgContext)_localctx).f.getText():null); 
				}
				break;
			case TERMINAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				((ArgContext)_localctx).t = match(TERMINAL);
				 ((ArgContext)_localctx).res =  (((ArgContext)_localctx).t!=null?((ArgContext)_localctx).t.getText():null); 
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

	public static final String _serializedATN =
		"\u0004\u0001\r\u0081\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002+\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004@\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006M\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b[\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\ti\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\nt\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u007f\b\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u0080\u0000"+
		"\u0018\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004"+
		"*\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b?\u0001\u0000"+
		"\u0000\u0000\nA\u0001\u0000\u0000\u0000\fL\u0001\u0000\u0000\u0000\u000e"+
		"N\u0001\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012h\u0001"+
		"\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016~\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0003\f\u0006\u0000"+
		"\u001a\u001b\u0005\u0000\u0000\u0001\u001b\u0001\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0005\u0001\u0000\u0000\u001d\u001e\u0005\u0002\u0000\u0000"+
		"\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0005\u0003\u0000\u0000 !"+
		"\u0006\u0001\uffff\uffff\u0000!\u0003\u0001\u0000\u0000\u0000\"+\u0001"+
		"\u0000\u0000\u0000#$\u0003\u0006\u0003\u0000$%\u0006\u0002\uffff\uffff"+
		"\u0000%+\u0001\u0000\u0000\u0000&\'\u0003\u0006\u0003\u0000\'(\u0003\u0004"+
		"\u0002\u0000()\u0006\u0002\uffff\uffff\u0000)+\u0001\u0000\u0000\u0000"+
		"*\"\u0001\u0000\u0000\u0000*#\u0001\u0000\u0000\u0000*&\u0001\u0000\u0000"+
		"\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0005\n\u0000\u0000-.\u0005\u0004"+
		"\u0000\u0000./\u0003\b\u0004\u0000/0\u0005\u0005\u0000\u000001\u0005\u0006"+
		"\u0000\u000012\u0005\u0004\u0000\u000023\u0003\b\u0004\u000034\u0005\u0005"+
		"\u0000\u000045\u0006\u0003\uffff\uffff\u00005\u0007\u0001\u0000\u0000"+
		"\u00006@\u0001\u0000\u0000\u000078\u0003\n\u0005\u000089\u0006\u0004\uffff"+
		"\uffff\u00009@\u0001\u0000\u0000\u0000:;\u0003\n\u0005\u0000;<\u0005\u0007"+
		"\u0000\u0000<=\u0003\b\u0004\u0000=>\u0006\u0004\uffff\uffff\u0000>@\u0001"+
		"\u0000\u0000\u0000?6\u0001\u0000\u0000\u0000?7\u0001\u0000\u0000\u0000"+
		"?:\u0001\u0000\u0000\u0000@\t\u0001\u0000\u0000\u0000AB\u0005\n\u0000"+
		"\u0000BC\u0005\n\u0000\u0000CD\u0006\u0005\uffff\uffff\u0000D\u000b\u0001"+
		"\u0000\u0000\u0000EF\u0003\u000e\u0007\u0000FG\u0006\u0006\uffff\uffff"+
		"\u0000GM\u0001\u0000\u0000\u0000HI\u0003\u000e\u0007\u0000IJ\u0003\f\u0006"+
		"\u0000JK\u0006\u0006\uffff\uffff\u0000KM\u0001\u0000\u0000\u0000LE\u0001"+
		"\u0000\u0000\u0000LH\u0001\u0000\u0000\u0000M\r\u0001\u0000\u0000\u0000"+
		"NO\u0005\n\u0000\u0000OP\u0005\u0006\u0000\u0000PQ\u0003\u0010\b\u0000"+
		"QR\u0006\u0007\uffff\uffff\u0000R\u000f\u0001\u0000\u0000\u0000ST\u0003"+
		"\u0012\t\u0000TU\u0006\b\uffff\uffff\u0000U[\u0001\u0000\u0000\u0000V"+
		"W\u0003\u0012\t\u0000WX\u0003\u0010\b\u0000XY\u0006\b\uffff\uffff\u0000"+
		"Y[\u0001\u0000\u0000\u0000ZS\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000"+
		"\u0000[\u0011\u0001\u0000\u0000\u0000\\]\u0005\u000b\u0000\u0000]i\u0006"+
		"\t\uffff\uffff\u0000^_\u0005\n\u0000\u0000_`\u0005\u0004\u0000\u0000`"+
		"a\u0003\u0014\n\u0000ab\u0005\u0005\u0000\u0000bc\u0006\t\uffff\uffff"+
		"\u0000ci\u0001\u0000\u0000\u0000de\u0005\u0002\u0000\u0000ef\u0005\r\u0000"+
		"\u0000fg\u0005\u0003\u0000\u0000gi\u0006\t\uffff\uffff\u0000h\\\u0001"+
		"\u0000\u0000\u0000h^\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000"+
		"i\u0013\u0001\u0000\u0000\u0000jt\u0001\u0000\u0000\u0000kl\u0003\u0016"+
		"\u000b\u0000lm\u0006\n\uffff\uffff\u0000mt\u0001\u0000\u0000\u0000no\u0003"+
		"\u0016\u000b\u0000op\u0005\u0007\u0000\u0000pq\u0003\u0014\n\u0000qr\u0006"+
		"\n\uffff\uffff\u0000rt\u0001\u0000\u0000\u0000sj\u0001\u0000\u0000\u0000"+
		"sk\u0001\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000t\u0015\u0001\u0000"+
		"\u0000\u0000uv\u0005\b\u0000\u0000vw\u0005\n\u0000\u0000wx\u0005\t\u0000"+
		"\u0000xy\u0005\n\u0000\u0000y\u007f\u0006\u000b\uffff\uffff\u0000z{\u0005"+
		"\n\u0000\u0000{\u007f\u0006\u000b\uffff\uffff\u0000|}\u0005\u000b\u0000"+
		"\u0000}\u007f\u0006\u000b\uffff\uffff\u0000~u\u0001\u0000\u0000\u0000"+
		"~z\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0017\u0001"+
		"\u0000\u0000\u0000\u0007*?LZhs~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}