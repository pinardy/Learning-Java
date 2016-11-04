package sat;

/*
import static org.junit.Assert.*;

import org.junit.Test;
*/

import sat.env.*;
import sat.formula.*;
import sat.SATSolver;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;


public class SATSolverTest {
    Literal a = PosLiteral.make("a");
    Literal b = PosLiteral.make("b");
    Literal c = PosLiteral.make("c");
    Literal na = a.getNegation();
    Literal nb = b.getNegation();
    Literal nc = c.getNegation();

    public void testSATSolver1(){    //void
    	// (a v b)
        Clause c1 = makeCl(a);
        Clause c2 = makeCl(b);
        Formula f1 = makeFm(c1,c2);

        Environment e = SATSolver.solve(f1);
/*
    	assertTrue( "one of the literals should be set to true",
    			Bool.TRUE == e.get(a.getVariable())  
    			|| Bool.TRUE == e.get(b.getVariable())	);
*/
    }
    
    
    public void testSATSolver2(){
    	// (~a)
    	Environment e = SATSolver.solve(makeFm(makeCl(na)));
/*
    	assertEquals( Bool.FALSE, e.get(na.getVariable()));
*/
        System.out.println(e);
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
    public static void main (String[] args) {
        SATSolverTest s1 = new SATSolverTest();
        //s1.testSATSolver2();

        try {
            // CNF files of different sizes of clauses were used as input
            // (ranging from 10 to 6000 clauses)
            File cnf = new File("C:\\Pinardy\\SUTD\\Term_4\\2D\\Project-2D-starting\\sampleCNF\\largeSat.cnf");

            BufferedReader buffer = new BufferedReader(new FileReader(cnf));
            buffer.readLine(); //read first line
            buffer.readLine(); //read second line
            StringBuffer stringBuffer = new StringBuffer();
            String lineFirst;
            while((lineFirst=buffer.readLine()) != null) {
                stringBuffer.append(lineFirst);
                stringBuffer.append(" ");
            }
            String expr = stringBuffer.toString();
            String[] expr1 = expr.split("\\s");
            //System.out.println(Arrays.deepToString(expr1));

            Formula f = new Formula();

            HashMap<Integer,Literal> literal = new HashMap<>();
            HashMap<Integer,Clause> clause = new HashMap<>();
            int j=1;
            for(int i=0;i<expr1.length;i++) {

                if (Integer.parseInt(expr1[i])>0) {

                    literal.put(Integer.parseInt(expr1[i]),PosLiteral.make("literal"+expr1[i]));
                }

                else if (Integer.parseInt(expr1[i])<0) {
                    Literal n = PosLiteral.make("literal"+abs(Integer.parseInt(expr1[i]))).getNegation();
                    literal.put(Integer.parseInt(expr1[i]),n);
                }

                else {
                    Clause c = new Clause();
                    for(Literal lt:literal.values()) {
                        c = c.add(lt);
                    }
                    clause.put(j,c);
                    j++;
                    literal.clear();
                }
            }
            for(Clause cl:clause.values()) {
                f=f.addClause(cl);
            }
            long started = System.nanoTime();
            Environment e = SATSolver.solve(f);
            long time = System.nanoTime();

            System.out.println(e);

            long timeTaken = time - started;
            System.out.println("Time:" + timeTaken / 1000000000.0 + "s");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}