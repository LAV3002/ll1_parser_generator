// Generated from D:/mt/lab4/src/RulesParser/Rules.g4 by ANTLR 4.13.1
package RulesParser;

    import org.antlr.v4.runtime.*;
    import java.util.*;
    import java.lang.*;
    import Symbol.*;
    import Rules.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RulesParser}.
 */
public interface RulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RulesParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RulesParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RulesParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(RulesParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(RulesParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#nonterminalsDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterNonterminalsDeclarations(RulesParser.NonterminalsDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#nonterminalsDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitNonterminalsDeclarations(RulesParser.NonterminalsDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#nonterminalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNonterminalDeclaration(RulesParser.NonterminalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#nonterminalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNonterminalDeclaration(RulesParser.NonterminalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#varsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarsDeclaration(RulesParser.VarsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#varsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarsDeclaration(RulesParser.VarsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(RulesParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(RulesParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(RulesParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(RulesParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(RulesParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(RulesParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#symbols}.
	 * @param ctx the parse tree
	 */
	void enterSymbols(RulesParser.SymbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#symbols}.
	 * @param ctx the parse tree
	 */
	void exitSymbols(RulesParser.SymbolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(RulesParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(RulesParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(RulesParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(RulesParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(RulesParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(RulesParser.ArgContext ctx);
}