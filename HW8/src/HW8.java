import Base.Expression;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by javlon on 10.12.15.
 */
public class HW8 {
    public static void main(String[] args) throws IOException {
        CharStream in = new ANTLRInputStream(new FileInputStream(args[0]));
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        Expression expression = parser.expression().exp;
        System.out.println("Expression: " + expression);
        System.out.println("Normal form: " + expression.reduction(false));

    }
}
