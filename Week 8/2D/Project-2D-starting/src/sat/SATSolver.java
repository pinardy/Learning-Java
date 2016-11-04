package sat;

import immutable.EmptyImList;
import immutable.ImList;
import sat.env.Environment;
import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.PosLiteral;



/**
 * A simple DPLL SAT solver. See http://en.wikipedia.org/wiki/DPLL_algorithm
 */

public class SATSolver {
    /**
     * Solve the problem using a simple version of DPLL with backtracking and
     * unit propagation. The returned environment binds literals of class
     * bool.Variable rather than the special literals used in clausification of
     * class clausal.Literal, so that clients can more readily use it.
     * 
     * @return an environment for which the problem evaluates to Bool.TRUE, or
     *         null if no such environment exists.
     */
    public static Environment solve(Formula formula) {
        Environment e = new Environment();
        if (formula.getSize() == 0){
            return e;
        }

        ImList<Clause> f = formula.getClauses();
        return solve(f, e);
    }

    /**
     * Takes a partial assignment of variables to values, and recursively
     * searches for a complete satisfying assignment.
     *
     * @param clauses
     *            formula in conjunctive normal form
     * @param env
     *            assignment of some or all variables in clauses to true or
     *            false values.
     * @return an environment for which all the clauses evaluate to Bool.TRUE,
     *         or null if no such environment exists.
     */
    private static Environment solve(ImList<Clause> clauses, Environment env) {
        //System.out.println(clauses.size());
        int min = Integer.MAX_VALUE;
        Environment e = new Environment();
        if (clauses.size() == 0){
            //System.out.println("000");
            return env;
        }
        Clause c = new Clause();
        for (Clause cl: clauses) {
            if (cl.isEmpty()) {

                return null;
            }
            else {

                if (cl.size() < min) {
                    min = cl.size();
                    c = cl;
                }
            }
        }
        //System.out.println(c);
        //Clause c = mergeSort(clauses).first();
        Literal l = c.chooseLiteral();
        //System.out.println(l);
        if (c.isUnit()){
            if (!l.negates(PosLiteral.make(l.getVariable()))){
                e = solve(substitute(clauses, l), env.putTrue(l.getVariable()));
            }
            else {
                e = solve(substitute(clauses, l), env.putFalse(l.getVariable()));
            }
        }
        else {
            //System.out.println("hello");
            //System.out.println(l.getVariable());
            //System.out.println(substitute(clauses,l));
            if (!l.negates(PosLiteral.make(l.getVariable()))){
                e = solve(substitute(clauses, l), env.putTrue(l.getVariable()));
            }
            else {
                e = solve(substitute(clauses, l), env.putFalse(l.getVariable()));
            }
            if (solve(substitute(clauses,l), env.putTrue(l.getVariable())) == null) {
                e = solve(substitute(clauses,l.getNegation()), env.putFalse(l.getVariable()));
            }
        }
        return e;
    }

    /**
     * given a clause list and literal, produce a new list resulting from
     * setting that literal to true
     *
     * @param clauses
     *            , a list of clauses
     * @param l
     *            , a literal to set to true
     * @return a new list of clauses resulting from setting l to true
     */
    private static ImList<Clause> substitute(ImList<Clause> clauses, Literal l) {

        ImList<Clause> f = new EmptyImList<>();
        Clause clause = new Clause();
        for (Clause c : clauses){
            if (!c.isEmpty() && !(c == null)) {
                clause = c.reduce(l);
            }
            if (!(clause==null)) {
                f = f.add(clause);
            }
        }
        return f;
    }

    private static ImList<Clause> mergeSort(ImList<Clause> clauses){
        System.out.println(clauses);
        int l = clauses.size(); //2
        System.out.println("l:"+l);
        if (l == 1){
            return clauses;
        }
        ImList<Clause> f = new EmptyImList<>();
        for (int i = 0; i <= l / 2; i++){
            f = f.add(clauses.first());
            System.out.println(String.valueOf(i)+f);
            clauses = clauses.remove(clauses.first());
            System.out.println("remove"+clauses);
        }
        mergeSort(f);
        mergeSort(clauses);
        if (f.first().size() >= clauses.first().size()){
            return f.add(clauses.first());
        }
        return clauses.add(f.first());
    }
}