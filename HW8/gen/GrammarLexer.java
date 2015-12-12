// Generated from /home/javlon/code/java/TT (another copy)/Grammar.g4 by ANTLR 4.5

    import Base.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IN=2, F=3, T=4, IF=5, Y=6, PLUS=7, MINUS=8, EQ=9, PRL=10, PRR=11, 
		INL=12, INR=13, CASE=14, NUMBER=15, VAR=16, EQS=17, LP=18, RP=19, QLP=20, 
		QRP=21, BSLASH=22, COMMA=23, DOT=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LET", "IN", "F", "T", "IF", "Y", "PLUS", "MINUS", "EQ", "PRL", "PRR", 
		"INL", "INR", "CASE", "NUMBER", "VAR", "EQS", "LP", "RP", "QLP", "QRP", 
		"BSLASH", "COMMA", "DOT", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\5\20j\n\20\3\20\6\20m\n\20\r\20\16\20n\3"+
		"\21\3\21\7\21s\n\21\f\21\16\21v\13\21\3\21\7\21y\n\21\f\21\16\21|\13\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\6\32\u008f\n\32\r\32\16\32\u0090\3\32\3\32\2\2\33\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\5\3\2\62;\3\2c|\5\2"+
		"\13\f\17\17\"\"\u0098\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\59\3\2"+
		"\2\2\7<\3\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21J\3\2"+
		"\2\2\23P\3\2\2\2\25S\3\2\2\2\27W\3\2\2\2\31[\3\2\2\2\33_\3\2\2\2\35c\3"+
		"\2\2\2\37i\3\2\2\2!p\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0081\3\2\2\2)\u0083"+
		"\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2/\u0089\3\2\2\2\61\u008b\3\2\2\2"+
		"\63\u008e\3\2\2\2\65\66\7n\2\2\66\67\7g\2\2\678\7v\2\28\4\3\2\2\29:\7"+
		"k\2\2:;\7p\2\2;\6\3\2\2\2<=\7H\2\2=\b\3\2\2\2>?\7V\2\2?\n\3\2\2\2@A\7"+
		"K\2\2AB\7h\2\2B\f\3\2\2\2CD\7[\2\2D\16\3\2\2\2EF\7R\2\2FG\7n\2\2GH\7w"+
		"\2\2HI\7u\2\2I\20\3\2\2\2JK\7O\2\2KL\7k\2\2LM\7p\2\2MN\7w\2\2NO\7u\2\2"+
		"O\22\3\2\2\2PQ\7G\2\2QR\7s\2\2R\24\3\2\2\2ST\7R\2\2TU\7t\2\2UV\7N\2\2"+
		"V\26\3\2\2\2WX\7R\2\2XY\7t\2\2YZ\7T\2\2Z\30\3\2\2\2[\\\7K\2\2\\]\7p\2"+
		"\2]^\7N\2\2^\32\3\2\2\2_`\7K\2\2`a\7p\2\2ab\7T\2\2b\34\3\2\2\2cd\7E\2"+
		"\2de\7c\2\2ef\7u\2\2fg\7g\2\2g\36\3\2\2\2hj\7/\2\2ih\3\2\2\2ij\3\2\2\2"+
		"jl\3\2\2\2km\t\2\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o \3\2\2\2"+
		"pt\t\3\2\2qs\t\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uz\3\2\2\2"+
		"vt\3\2\2\2wy\7)\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\"\3\2\2\2"+
		"|z\3\2\2\2}~\7?\2\2~$\3\2\2\2\177\u0080\7*\2\2\u0080&\3\2\2\2\u0081\u0082"+
		"\7+\2\2\u0082(\3\2\2\2\u0083\u0084\7>\2\2\u0084*\3\2\2\2\u0085\u0086\7"+
		"@\2\2\u0086,\3\2\2\2\u0087\u0088\7^\2\2\u0088.\3\2\2\2\u0089\u008a\7."+
		"\2\2\u008a\60\3\2\2\2\u008b\u008c\7\60\2\2\u008c\62\3\2\2\2\u008d\u008f"+
		"\t\4\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\32\2\2\u0093\64\3\2\2"+
		"\2\b\2intz\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}