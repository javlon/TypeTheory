grammar Grammar;

@header {
    import Base.*;
}

expression returns[Expression exp]
    :   LET VAR EQS (e1 = expression) IN (e2 = expression){
            $exp = new LetIn(new Variable($VAR.text), $e1.exp, $e2.exp);
        }
    |   abstraction{
            $exp = $abstraction.exp;
        }
    ;

abstraction returns[Expression exp]
    :   BSLASH VAR DOT a1 = abstraction{
            $exp = new Abstraction(new Variable($VAR.text), $a1.exp);
        }
    |   application{
            $exp = $application.exp;
        }
    ;

application returns[Expression exp]
    :   term a1 = abstraction {
            $exp = new Application($term.exp, $a1.exp);
        }
    |   term{
            $exp = $term.exp;
        }
    ;

term returns [Expression exp]
    :   LP abstraction RP{
            $exp = $abstraction.exp;
        }
    |   value{
            $exp = $value.exp;
        }
    ;

value returns [Expression exp]
    :   VAR{
            $exp = new Variable($VAR.text);
        }
    |   F{
            $exp = new SBoolean(false);
        }
    |   T{
            $exp = new SBoolean(true);
        }
    |   IF{
            $exp = new If();
        }
    |   Y{
            $exp = new Y();
        }
    |   PLUS{
            $exp = new Plus();
        }
    |   MINUS{
            $exp = new Minus();
        }
    |   EQ{
            $exp = new Eq();
        }
    |   NUMBER{
            $exp = new SNumber($NUMBER.text);
        }
    |   QLP a1 =abstraction COMMA a2 =abstraction QRP{
            $exp = new SPair($a1.exp, $a2.exp);
        }
    |   PRL{
            $exp = new Pr(true);
        }
    |   PRR{
            $exp = new Pr(false);
        }
    |   INL{
            $exp = new In(true);
        }
    |   INR{
            $exp = new In(false);
        }
    |   CASE{
            $exp = new Case();
        }
    ;


LET : 'let';
IN : 'in';
F : 'F';
T : 'T';
IF : 'If';
Y : 'Y';
PLUS : 'Plus';
MINUS : 'Minus';
EQ : 'Eq';
PRL : 'PrL';
PRR : 'PrR';
INL : 'InL';
INR : 'InR';
CASE : 'Case';
NUMBER : ('-')?[0-9]+;
VAR : [a-z][0-9]*('\'')*;
EQS : '=';
LP : '(';
RP : ')';
QLP : '<';
QRP : '>';
BSLASH : '\\';
COMMA : ',';
DOT : '.';


WS : [\t\r\n ]+ -> skip ;