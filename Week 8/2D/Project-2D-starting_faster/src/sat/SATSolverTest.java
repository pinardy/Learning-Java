package sat;

/*
import static org.junit.Assert.*;

import org.junit.Test;
*/

import sat.env.*;
import sat.formula.*;
import sat.SATSolver;


import java.io.*;
import java.util.*;

import static java.lang.Math.abs;


public class SATSolverTest {
    Literal a = PosLiteral.make("a");
    Literal b = PosLiteral.make("b");
    Literal c = PosLiteral.make("c");
    Literal na = a.getNegation();
    Literal nb = b.getNegation();
    Literal nc = c.getNegation();

    // TODO: add the main method that reads the .cnf file and calls SATSolver.solve to determine the satisfiability

    public void testSATSolver1() {
        // (a v b)
        Environment e = SATSolver.solve(makeFm(makeCl(a, b)));
/*
       assertTrue( "one of the literals should be set to true",
             Bool.TRUE == e.get(a.getVariable())
             || Bool.TRUE == e.get(b.getVariable()) );
*/
    }

    public void testSATSolver2() {
        // (~a)
        Environment e = SATSolver.solve(makeFm(makeCl(na)));
/*
       assertEquals( Bool.FALSE, e.get(na.getVariable()));
*/
    }

    private static Formula makeFm(Clause... e) {
        Formula f = new Formula();
        for (Clause c : e) {
            f = f.addClause(c);
        }
        return f;
    }

    private static Clause makeCl(Literal... e) {
        Clause c = new Clause();
        for (Literal l : e) {
            c = c.add(l);
        }
        return c;
    }

    public static void main(String[] args) {
        String result = "satisfiable";
        try {
            File cnf = new File("C:\\Pinardy\\SUTD\\Term_4\\2D\\Project-2D-starting_faster\\sampleCNF\\largesat10.cnf");
            BufferedReader buffer = new BufferedReader(new FileReader(cnf));
            buffer.readLine();
            buffer.readLine();
            StringBuilder stringbuilder = new StringBuilder();
            String lineFirst;
            while ((lineFirst = buffer.readLine()) != null) {
                if (!lineFirst.equals("")) {
                    stringbuilder.append(lineFirst);
                    stringbuilder.append(" ");
                }
            }
            String expr = stringbuilder.toString();
            String[] expr1 = expr.split("\\s");
            buffer.close();

            Formula f = new Formula();
            WeakHashMap<Integer, Literal> literal = new WeakHashMap<>();
            WeakHashMap<Integer, Clause> clause = new WeakHashMap<>();
            int j = 1;
            for (String s : expr1) {
                if (Integer.parseInt(s) > 0) {
                    literal.put(Integer.parseInt(s), PosLiteral.make("literal" + s));
                } else if (Integer.parseInt(s) < 0) {
                    Literal n = PosLiteral.make("literal" + abs(Integer.parseInt(s))).getNegation();
                    literal.put(Integer.parseInt(s), n);
                } else {
                    Clause c = new Clause(); //nullpointerexception?
                    for (Literal lt : literal.values()) {
                        c = c.add(lt);
                    }
                    clause.put(j, c);
                    j++;
                    literal.clear();
                }

            }

            for (Clause cl : clause.values()) {
                f = f.addClause(cl);
            }

            long started = System.nanoTime();
            Environment e = SATSolver.solve(f);
            long time = System.nanoTime();
            System.out.println("Time: " + (time - started) / 1000000000.0 + " s");
            if (e == null) {
                System.out.println("not" + result);
            } else {

                System.out.println(result);
                try {
                    File file = new File("C:\\Pinardy\\SUTD\\Term_4\\2D\\Project-2D-starting_faster\\src\\sat\\result.txt");
                    FileWriter write = new FileWriter(file);
                    BufferedWriter out = new BufferedWriter(write);

                    String newString = e.toString().replaceAll("->", ":");
                    String[] sep = newString.substring(13, newString.length() - 1).split(", ");

                    Arrays.sort(sep, new Comparator<String>() {
                        public int compare(String s1, String s2) {
                            return Integer.parseInt(s1.substring(7, s1.indexOf(":"))) - Integer.parseInt(s2.substring(7, s2.indexOf(":")));
                        }
                    });


                    //System.out.println(Arrays.deepToString(sep));


                    for (int i = 0; i < sep.length; i++) {
                        if (i != sep.length - 1) {
                            out.write(sep[i]);
                            out.newLine();
                        } else {
                            out.write(sep[i]);
                        }
                    }

                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}