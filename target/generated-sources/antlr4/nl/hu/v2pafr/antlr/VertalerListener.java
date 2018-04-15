// Generated from Vertaler.g4 by ANTLR 4.4
package nl.hu.v2pafr.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VertalerParser}.
 */
public interface VertalerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VertalerParser#lidwoord}.
	 * @param ctx the parse tree
	 */
	void enterLidwoord(@NotNull VertalerParser.LidwoordContext ctx);
	/**
	 * Exit a parse tree produced by {@link VertalerParser#lidwoord}.
	 * @param ctx the parse tree
	 */
	void exitLidwoord(@NotNull VertalerParser.LidwoordContext ctx);
	/**
	 * Enter a parse tree produced by {@link VertalerParser#zelfstandig_naamwoord}.
	 * @param ctx the parse tree
	 */
	void enterZelfstandig_naamwoord(@NotNull VertalerParser.Zelfstandig_naamwoordContext ctx);
	/**
	 * Exit a parse tree produced by {@link VertalerParser#zelfstandig_naamwoord}.
	 * @param ctx the parse tree
	 */
	void exitZelfstandig_naamwoord(@NotNull VertalerParser.Zelfstandig_naamwoordContext ctx);
	/**
	 * Enter a parse tree produced by {@link VertalerParser#naamwoordelijk_deel}.
	 * @param ctx the parse tree
	 */
	void enterNaamwoordelijk_deel(@NotNull VertalerParser.Naamwoordelijk_deelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VertalerParser#naamwoordelijk_deel}.
	 * @param ctx the parse tree
	 */
	void exitNaamwoordelijk_deel(@NotNull VertalerParser.Naamwoordelijk_deelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VertalerParser#werkwoordelijk_deel}.
	 * @param ctx the parse tree
	 */
	void enterWerkwoordelijk_deel(@NotNull VertalerParser.Werkwoordelijk_deelContext ctx);
	/**
	 * Exit a parse tree produced by {@link VertalerParser#werkwoordelijk_deel}.
	 * @param ctx the parse tree
	 */
	void exitWerkwoordelijk_deel(@NotNull VertalerParser.Werkwoordelijk_deelContext ctx);
	/**
	 * Enter a parse tree produced by {@link VertalerParser#eenvoudigezin}.
	 * @param ctx the parse tree
	 */
	void enterEenvoudigezin(@NotNull VertalerParser.EenvoudigezinContext ctx);
	/**
	 * Exit a parse tree produced by {@link VertalerParser#eenvoudigezin}.
	 * @param ctx the parse tree
	 */
	void exitEenvoudigezin(@NotNull VertalerParser.EenvoudigezinContext ctx);
}