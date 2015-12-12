// Generated from /home/javlon/code/java/TT (another copy)/Grammar.g4 by ANTLR 4.5

    import Base.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(@NotNull GrammarParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(@NotNull GrammarParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#application}.
	 * @param ctx the parse tree
	 */
	void enterApplication(@NotNull GrammarParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#application}.
	 * @param ctx the parse tree
	 */
	void exitApplication(@NotNull GrammarParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull GrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull GrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull GrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull GrammarParser.ValueContext ctx);
}