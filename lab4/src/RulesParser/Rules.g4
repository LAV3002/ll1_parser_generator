grammar Rules;

@header {
    import org.antlr.v4.runtime.*;
    import java.util.*;
    import java.lang.*;
    import Symbol.*;
    import Rules.*;
}

start : declaration rules EOF;

declaration returns [List<NonterminalDeclaration> res]
 : 'declaration' '{' nonterminalsDeclarations '}' { $res = $nonterminalsDeclarations.res; };


nonterminalsDeclarations returns [List<NonterminalDeclaration> res]
@init{
    $res = new ArrayList<>();
} :
  | nd=nonterminalDeclaration { $res.add($nd.res); }
  | nd=nonterminalDeclaration nds=nonterminalsDeclarations {
                                                             $res.add($nd.res);
                                                             $res.addAll($nds.res);
                                                           };


nonterminalDeclaration returns [NonterminalDeclaration res]
 : nt=STRING '(' inh=varsDeclaration ')' '->' '(' synt=varsDeclaration ')'
 { $res = new NonterminalDeclaration($nt.text, $inh.res, $synt.res); };


varsDeclaration returns [List<VarDeclaration> res]
@init{
    $res = new ArrayList<>();
}
    :
    | vd=varDeclaration { $res.add($vd.res); }
    | vd=varDeclaration ',' vds=varsDeclaration {
                                                 $res.add($vd.res);
                                                 $res.addAll($vds.res);
                                                };


varDeclaration returns [VarDeclaration res] : f=STRING s=STRING { $res = new VarDeclaration($f.text, $s.text); };

rules returns [List<Rule> res]
@init{
    $res = new ArrayList<>();
}
    : rl=rule { $res.add($rl.res); }
    | rl=rule rls=rules { $res.add($rl.res); $res.addAll($rls.res); };


rule returns [Rule res]
    : left=STRING '->' right=symbols { $res = new Rule($left.text, $right.res); };


symbols returns [List<Symbol> res]
@init{
    $res = new ArrayList<>();
}
    : symb=symbol { $res.add($symb.res); }
    | symb=symbol symbs=symbols { $res.add($symb.res); $res.addAll($symbs.res); };


symbol returns [Symbol res]
    : t=TERMINAL {
                    String term = $t.text;
                    term = term.substring(1, term.length() - 1);
                    $res = new TerminalSymbol(term);
                 }
    | s=STRING '(' ar=args  ')' { $res = new NonterminalSymbol($s.text, $ar.res); }
    | '{' c=CODE '}' { $res = new BroadcastingSymbol($c.text); };


args returns [List<String> res]
@init{
    $res = new ArrayList<>();
}
    :
    | ar=arg { $res.add($ar.text); }
    | ar=arg ',' argsp=args { $res.add($ar.text); $res.addAll($argsp.res); };

arg returns [String res]
    : '$' f=STRING  '.' s=STRING { $res = "$" + $f.text + "." + $s.text; }
    | f=STRING { $res = $f.text; }
    | t=TERMINAL { $res = $t.text; };


STRING : [A-Za-z0-9_]+;
TERMINAL : '"' ~'"'* '"';
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
CODE : '~'~'~'*'~';