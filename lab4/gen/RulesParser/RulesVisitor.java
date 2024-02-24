// Generated from D:/mt/lab4/src/RulesParser/Rules.g4 by ANTLR 4.13.1
package RulesParser;

    import org.antlr.v4.runtime.*;
    import java.util.*;
    import java.lang.*;
    import Symbol.*;
    import Rules.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RulesParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RulesParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(RulesParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#nonterminalsDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonterminalsDeclarations(RulesParser.NonterminalsDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#nonterminalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonterminalDeclaration(RulesParser.NonterminalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#varsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarsDeclaration(RulesParser.VarsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(RulesParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(RulesParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(RulesParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#symbols}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbols(RulesParser.SymbolsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(RulesParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(RulesParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(RulesParser.ArgContext ctx);
}