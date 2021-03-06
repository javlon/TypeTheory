// Generated from /home/javlon/code/java/TypeTheory/HW8/Grammar.g4 by ANTLR 4.5

    import base.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IN=2, F=3, T=4, IF=5, Y=6, PLUS=7, MINUS=8, EQ=9, PRL=10, PRR=11, 
		INL=12, INR=13, CASE=14, NUMBER=15, VAR=16, EQS=17, LP=18, RP=19, QLP=20, 
		QRP=21, BSLASH=22, COMMA=23, DOT=24, WS=25;
	public static final int
		RULE_expression = 0, RULE_abstraction = 1, RULE_application = 2, RULE_term = 3, 
		RULE_value = 4;
	public static final String[] ruleNames = {
		"expression", "abstraction", "application", "term", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'in'", "'F'", "'T'", "'If'", "'Y'", "'Plus'", "'Minus'", 
		"'Eq'", "'PrL'", "'PrR'", "'InL'", "'InR'", "'Case'", null, null, "'='", 
		"'('", "')'", "'<'", "'>'", "'\\'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LET", "IN", "F", "T", "IF", "Y", "PLUS", "MINUS", "EQ", "PRL", 
		"PRR", "INL", "INR", "CASE", "NUMBER", "VAR", "EQS", "LP", "RP", "QLP", 
		"QRP", "BSLASH", "COMMA", "DOT", "WS"
	};
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public Expression exp;
		public Token VAR;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public AbstractionContext abstraction;
		public TerminalNode LET() { return getToken(GrammarParser.LET, 0); }
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public TerminalNode EQS() { return getToken(GrammarParser.EQS, 0); }
		public TerminalNode IN() { return getToken(GrammarParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(21);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(10); 
				match(LET);
				setState(11); 
				((ExpressionContext)_localctx).VAR = match(VAR);
				setState(12); 
				match(EQS);
				{
				setState(13); 
				((ExpressionContext)_localctx).e1 = expression();
				}
				setState(14); 
				match(IN);
				{
				setState(15); 
				((ExpressionContext)_localctx).e2 = expression();
				}

				            ((ExpressionContext)_localctx).exp =  new LetIn(new Variable((((ExpressionContext)_localctx).VAR!=null?((ExpressionContext)_localctx).VAR.getText():null)), ((ExpressionContext)_localctx).e1.exp, ((ExpressionContext)_localctx).e2.exp);
				        
				}
				break;
			case F:
			case T:
			case IF:
			case Y:
			case PLUS:
			case MINUS:
			case EQ:
			case PRL:
			case PRR:
			case INL:
			case INR:
			case CASE:
			case NUMBER:
			case VAR:
			case LP:
			case QLP:
			case BSLASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(18); 
				((ExpressionContext)_localctx).abstraction = abstraction();

				            ((ExpressionContext)_localctx).exp =  ((ExpressionContext)_localctx).abstraction.exp;
				        
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

	public static class AbstractionContext extends ParserRuleContext {
		public Expression exp;
		public Token VAR;
		public AbstractionContext a1;
		public ApplicationContext application;
		public TerminalNode BSLASH() { return getToken(GrammarParser.BSLASH, 0); }
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public TerminalNode DOT() { return getToken(GrammarParser.DOT, 0); }
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public AbstractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAbstraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAbstraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractionContext abstraction() throws RecognitionException {
		AbstractionContext _localctx = new AbstractionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_abstraction);
		try {
			setState(32);
			switch (_input.LA(1)) {
			case BSLASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(23); 
				match(BSLASH);
				setState(24); 
				((AbstractionContext)_localctx).VAR = match(VAR);
				setState(25); 
				match(DOT);
				setState(26); 
				((AbstractionContext)_localctx).a1 = abstraction();

				            ((AbstractionContext)_localctx).exp =  new Abstraction(new Variable((((AbstractionContext)_localctx).VAR!=null?((AbstractionContext)_localctx).VAR.getText():null)), ((AbstractionContext)_localctx).a1.exp);
				        
				}
				break;
			case F:
			case T:
			case IF:
			case Y:
			case PLUS:
			case MINUS:
			case EQ:
			case PRL:
			case PRR:
			case INL:
			case INR:
			case CASE:
			case NUMBER:
			case VAR:
			case LP:
			case QLP:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); 
				((AbstractionContext)_localctx).application = application(0);

				            ((AbstractionContext)_localctx).exp =  ((AbstractionContext)_localctx).application.exp;
				        
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

	public static class ApplicationContext extends ParserRuleContext {
		public Expression exp;
		public ApplicationContext a1;
		public TermContext term;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		return application(0);
	}

	private ApplicationContext application(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ApplicationContext _localctx = new ApplicationContext(_ctx, _parentState);
		ApplicationContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_application, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(35); 
			((ApplicationContext)_localctx).term = term();

			            ((ApplicationContext)_localctx).exp =  ((ApplicationContext)_localctx).term.exp;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ApplicationContext(_parentctx, _parentState);
					_localctx.a1 = _prevctx;
					_localctx.a1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_application);
					setState(38);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(39); 
					((ApplicationContext)_localctx).term = term();

					                      ((ApplicationContext)_localctx).exp =  new Application(((ApplicationContext)_localctx).a1.exp, ((ApplicationContext)_localctx).term.exp);
					                  
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Expression exp;
		public AbstractionContext abstraction;
		public ValueContext value;
		public TerminalNode LP() { return getToken(GrammarParser.LP, 0); }
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public TerminalNode RP() { return getToken(GrammarParser.RP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case LP:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); 
				match(LP);
				setState(48); 
				((TermContext)_localctx).abstraction = abstraction();
				setState(49); 
				match(RP);

				            ((TermContext)_localctx).exp =  ((TermContext)_localctx).abstraction.exp;
				        
				}
				break;
			case F:
			case T:
			case IF:
			case Y:
			case PLUS:
			case MINUS:
			case EQ:
			case PRL:
			case PRR:
			case INL:
			case INR:
			case CASE:
			case NUMBER:
			case VAR:
			case QLP:
				enterOuterAlt(_localctx, 2);
				{
				setState(52); 
				((TermContext)_localctx).value = value();

				            ((TermContext)_localctx).exp =  ((TermContext)_localctx).value.exp;
				        
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

	public static class ValueContext extends ParserRuleContext {
		public Expression exp;
		public Token VAR;
		public Token NUMBER;
		public AbstractionContext a1;
		public AbstractionContext a2;
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public TerminalNode F() { return getToken(GrammarParser.F, 0); }
		public TerminalNode T() { return getToken(GrammarParser.T, 0); }
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode Y() { return getToken(GrammarParser.Y, 0); }
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public TerminalNode NUMBER() { return getToken(GrammarParser.NUMBER, 0); }
		public TerminalNode QLP() { return getToken(GrammarParser.QLP, 0); }
		public TerminalNode COMMA() { return getToken(GrammarParser.COMMA, 0); }
		public TerminalNode QRP() { return getToken(GrammarParser.QRP, 0); }
		public List<AbstractionContext> abstraction() {
			return getRuleContexts(AbstractionContext.class);
		}
		public AbstractionContext abstraction(int i) {
			return getRuleContext(AbstractionContext.class,i);
		}
		public TerminalNode PRL() { return getToken(GrammarParser.PRL, 0); }
		public TerminalNode PRR() { return getToken(GrammarParser.PRR, 0); }
		public TerminalNode INL() { return getToken(GrammarParser.INL, 0); }
		public TerminalNode INR() { return getToken(GrammarParser.INR, 0); }
		public TerminalNode CASE() { return getToken(GrammarParser.CASE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(57); 
				((ValueContext)_localctx).VAR = match(VAR);

				            ((ValueContext)_localctx).exp =  new Variable((((ValueContext)_localctx).VAR!=null?((ValueContext)_localctx).VAR.getText():null));
				        
				}
				break;
			case F:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); 
				match(F);

				            ((ValueContext)_localctx).exp =  new SBoolean(false);
				        
				}
				break;
			case T:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); 
				match(T);

				            ((ValueContext)_localctx).exp =  new SBoolean(true);
				        
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(63); 
				match(IF);

				            ((ValueContext)_localctx).exp =  new If();
				        
				}
				break;
			case Y:
				enterOuterAlt(_localctx, 5);
				{
				setState(65); 
				match(Y);

				            ((ValueContext)_localctx).exp =  new Y();
				        
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 6);
				{
				setState(67); 
				match(PLUS);

				            ((ValueContext)_localctx).exp =  new Plus();
				        
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 7);
				{
				setState(69); 
				match(MINUS);

				            ((ValueContext)_localctx).exp =  new Minus();
				        
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 8);
				{
				setState(71); 
				match(EQ);

				            ((ValueContext)_localctx).exp =  new Eq();
				        
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 9);
				{
				setState(73); 
				((ValueContext)_localctx).NUMBER = match(NUMBER);

				            ((ValueContext)_localctx).exp =  new SNumber((((ValueContext)_localctx).NUMBER!=null?((ValueContext)_localctx).NUMBER.getText():null));
				        
				}
				break;
			case QLP:
				enterOuterAlt(_localctx, 10);
				{
				setState(75); 
				match(QLP);
				setState(76); 
				((ValueContext)_localctx).a1 = abstraction();
				setState(77); 
				match(COMMA);
				setState(78); 
				((ValueContext)_localctx).a2 = abstraction();
				setState(79); 
				match(QRP);

				            ((ValueContext)_localctx).exp =  new SPair(((ValueContext)_localctx).a1.exp, ((ValueContext)_localctx).a2.exp);
				        
				}
				break;
			case PRL:
				enterOuterAlt(_localctx, 11);
				{
				setState(82); 
				match(PRL);

				            ((ValueContext)_localctx).exp =  new Pr(true);
				        
				}
				break;
			case PRR:
				enterOuterAlt(_localctx, 12);
				{
				setState(84); 
				match(PRR);

				            ((ValueContext)_localctx).exp =  new Pr(false);
				        
				}
				break;
			case INL:
				enterOuterAlt(_localctx, 13);
				{
				setState(86); 
				match(INL);

				            ((ValueContext)_localctx).exp =  new In(true);
				        
				}
				break;
			case INR:
				enterOuterAlt(_localctx, 14);
				{
				setState(88); 
				match(INR);

				            ((ValueContext)_localctx).exp =  new In(false);
				        
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 15);
				{
				setState(90); 
				match(CASE);

				            ((ValueContext)_localctx).exp =  new Case();
				        
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: 
			return application_sempred((ApplicationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean application_sempred(ApplicationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33a\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\30\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6_\n\6\3\6\2\3\6\7\2\4\6\b\n\2\2m\2\27\3\2\2\2\4\""+
		"\3\2\2\2\6$\3\2\2\2\b9\3\2\2\2\n^\3\2\2\2\f\r\7\3\2\2\r\16\7\22\2\2\16"+
		"\17\7\23\2\2\17\20\5\2\2\2\20\21\7\4\2\2\21\22\5\2\2\2\22\23\b\2\1\2\23"+
		"\30\3\2\2\2\24\25\5\4\3\2\25\26\b\2\1\2\26\30\3\2\2\2\27\f\3\2\2\2\27"+
		"\24\3\2\2\2\30\3\3\2\2\2\31\32\7\30\2\2\32\33\7\22\2\2\33\34\7\32\2\2"+
		"\34\35\5\4\3\2\35\36\b\3\1\2\36#\3\2\2\2\37 \5\6\4\2 !\b\3\1\2!#\3\2\2"+
		"\2\"\31\3\2\2\2\"\37\3\2\2\2#\5\3\2\2\2$%\b\4\1\2%&\5\b\5\2&\'\b\4\1\2"+
		"\'.\3\2\2\2()\f\4\2\2)*\5\b\5\2*+\b\4\1\2+-\3\2\2\2,(\3\2\2\2-\60\3\2"+
		"\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60.\3\2\2\2\61\62\7\24\2\2\62\63\5"+
		"\4\3\2\63\64\7\25\2\2\64\65\b\5\1\2\65:\3\2\2\2\66\67\5\n\6\2\678\b\5"+
		"\1\28:\3\2\2\29\61\3\2\2\29\66\3\2\2\2:\t\3\2\2\2;<\7\22\2\2<_\b\6\1\2"+
		"=>\7\5\2\2>_\b\6\1\2?@\7\6\2\2@_\b\6\1\2AB\7\7\2\2B_\b\6\1\2CD\7\b\2\2"+
		"D_\b\6\1\2EF\7\t\2\2F_\b\6\1\2GH\7\n\2\2H_\b\6\1\2IJ\7\13\2\2J_\b\6\1"+
		"\2KL\7\21\2\2L_\b\6\1\2MN\7\26\2\2NO\5\4\3\2OP\7\31\2\2PQ\5\4\3\2QR\7"+
		"\27\2\2RS\b\6\1\2S_\3\2\2\2TU\7\f\2\2U_\b\6\1\2VW\7\r\2\2W_\b\6\1\2XY"+
		"\7\16\2\2Y_\b\6\1\2Z[\7\17\2\2[_\b\6\1\2\\]\7\20\2\2]_\b\6\1\2^;\3\2\2"+
		"\2^=\3\2\2\2^?\3\2\2\2^A\3\2\2\2^C\3\2\2\2^E\3\2\2\2^G\3\2\2\2^I\3\2\2"+
		"\2^K\3\2\2\2^M\3\2\2\2^T\3\2\2\2^V\3\2\2\2^X\3\2\2\2^Z\3\2\2\2^\\\3\2"+
		"\2\2_\13\3\2\2\2\7\27\".9^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}