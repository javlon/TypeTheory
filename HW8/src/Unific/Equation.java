package Unific;

import Types.Type;
import Types.TypeVariable;

import java.util.List;
import java.util.Set;

/**
 * Created by javlon on 14.11.14.
 */
public class Equation {
    private Type left;
    private Type right;

    public Equation(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    public Type getLeft() {
        return left;
    }

    public Type getRight() {
        return right;
    }

    public boolean symmetric() {
        return left.equals(right);
    }

    public boolean sameFunctions() {
        return left.sameFunction(right);
    }

    public List<Equation> decompose() {
        return left.decompose(right);
    }

    public boolean diffFunctions() {
        if (!left.sameFunction(right)) {
            if (!(left instanceof TypeVariable) && !(right instanceof TypeVariable))
                return true;
        }
        return false;
    }

    public void swap() {
        if (left instanceof TypeVariable && right instanceof TypeVariable) {
            if (((TypeVariable) left).isPrimaryType()) {
                Type tmp = left;
                left = right;
                right = tmp;
            }
        }
        if (!(left instanceof TypeVariable) && right instanceof TypeVariable) {
            Type tmp = left;
            left = right;
            right = tmp;
        }
    }

    public boolean leftVariable() {
        return left instanceof TypeVariable;
    }

    public boolean leftInRight() {
        if (left instanceof TypeVariable) {
            return right.freeTypeVar().contains(left);
        }
        throw new IllegalArgumentException();
    }

    public boolean hasThisVar(Type t) {
        Set<TypeVariable> set = left.freeTypeVar();
        set.addAll(right.freeTypeVar());
        return set.contains(t);
    }

    public void eliminate(Equation e) {
        left = left.substitution((TypeVariable) e.left, e.right);
        right = right.substitution((TypeVariable) e.left, e.right);

    }

    public boolean belongAnyOfLeft(List<TypeVariable> list) {
        Set<TypeVariable> set = right.freeTypeVar();
        for (TypeVariable tv : list) {
            if (set.contains(tv))
                return true;
        }
        return false;
    }

    public boolean badPrimaryType() {
        if (left instanceof TypeVariable && right instanceof TypeVariable) {
            if (((TypeVariable) left).isPrimaryType() && ((TypeVariable) right).isPrimaryType()) {
                return !left.equals(right);
            }
        } else if (left instanceof TypeVariable) {
            if (((TypeVariable) left).isPrimaryType()) return true;
        } else if (right instanceof TypeVariable) {
            if (((TypeVariable) right).isPrimaryType()) return true;
        }
        return false;

    }
}
