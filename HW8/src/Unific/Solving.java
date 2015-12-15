package Unific;

import Types.TypeVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javlon on 14.11.14.
 */
public class Solving {

    public static void delete(List<Equation> equations){
        for(int i = 0; i < equations.size(); ++i){
            if(equations.get(i).symmetric()){
                equations.remove(i--);
            }
        }
    }
    public static void decompose(List<Equation> equations){
        List<Equation> de = new ArrayList<Equation>();
        for(int i = 0; i < equations.size();++i){
            if(equations.get(i).sameFunctions()){
                de.addAll(equations.get(i).decompose());
                equations.remove(i--);
            }
        }
        equations.addAll(de);
    }
    public static boolean conflict(List<Equation> equations){
        for(int i = 0; i < equations.size(); ++i){
            if(equations.get(i).diffFunctions()){
                return true;
            }
        }
        return false;
    }
    public static void swap(List<Equation> equations){
        for(int i = 0; i < equations.size(); ++i){
            equations.get(i).swap();
        }
    }
    public static void eliminate(List<Equation> equations){
        for(int i = 0; i < equations.size(); ++i){
            if(equations.get(i).leftVariable()){
                if(!equations.get(i).leftInRight()){
                    TypeVariable tv = (TypeVariable) equations.get(i).getLeft();
                    for(int j = 0; j < equations.size(); ++j){
                        if(j == i) continue;
                        if(equations.get(j).hasThisVar(tv)){
                            equations.get(j).eliminate(equations.get(i));
                        }
                    }
                }
            }
        }
    }
    public static boolean inconsistent(List<Equation> equations){
        for(int i = 0; i < equations.size(); ++i){
            if(equations.get(i).leftVariable()){
                if(equations.get(i).leftInRight()){
                    return true;
                }
            }
            if(equations.get(i).badPrimaryType()){
                return true;
            }
        }
        return false;
    }
    private static boolean solvedForm(final List<Equation> equations){
        List<TypeVariable> vars = new ArrayList<>();
        for(int i = 0; i < equations.size(); ++i){
            if(!equations.get(i).leftVariable()){
                return false;
            }else if(vars.contains((TypeVariable) equations.get(i).getLeft())){
                return false;
            }
            vars.add((TypeVariable) equations.get(i).getLeft());
        }
        for(int i = 0; i < equations.size(); ++i){
            if(equations.get(i).belongAnyOfLeft(vars)){
                return false;
            }
        }
        return true;
    }
    public static boolean solving(List<Equation> equations){
        delete(equations);
        while (true) {
            decompose(equations);
            if(conflict(equations)){
                return false;
            }
            swap(equations);
            eliminate(equations);
            delete(equations);
            if(inconsistent(equations)){
                return false;
            }
            if(solvedForm(equations)){
                return true;
            }
        }
    }
}
