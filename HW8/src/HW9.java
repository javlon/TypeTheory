import Base.Expression;
import Types.Type;
import Types.TypeVariable;
import javafx.util.Pair;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by javlon on 10.12.15.
 */
public class HW9 {
    public static void main(String[] args) throws IOException {
        CharStream in = new ANTLRInputStream(new FileInputStream(args[0]));
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        Expression expression = parser.expression().exp;
        Pair<Map<TypeVariable, Type>, Type> ans = AlgorithmW.algoW(new HashMap<>(), expression);
        if(ans.getKey() == null && ans.getValue() == null){
            System.out.println("Лямбда-выражение не имеет типа.");
            return;
        }
        System.out.println(ans.getValue());
        for(TypeVariable tv : ans.getKey().keySet()){
            System.out.println(tv + " = " + ans.getKey().get(tv));
        }

    }
}
