import java.io.*;
import java.util.*;

public class Main {

  public static void main(String args[]) throws IOException, ParseException, TypeError {

    if (args.length > 0) {

      String type = args[0];

      if (args[0].equals("i")) {

        //Interpretador

        ASTNode exp;
        Parser parser;

        if (args.length > 1) { // ficheiro de input
          parser = new Parser(new FileInputStream(args[1]));

          try {
            exp = parser.Prog();
            exp.eval(new Env());
          }
          catch (Env.UndeclaredIdentifier e) {
            System.out.println ("Undeclared id.");
          }
          catch (Env.IdentifierDeclaredTwice e) {
            System.out.println ("Id declared twice.");
          }
          catch (TypeError e) {
            System.out.println ("Unexpected operand type.!");
          }
          catch (ParseException e) {
            System.out.println ("Syntax error.");
          }

        } else { // Sem ficheiro
          parser = new Parser(System.in);

          while (true) {
            try {
              exp = parser.Prog();
              System.out.println("-> "+exp.eval(new Env()));
            }
            catch (Env.UndeclaredIdentifier e) {
              System.out.println ("Undeclared id.");
              parser.ReInit(System.in);
            }
            catch (Env.IdentifierDeclaredTwice e) {
              System.out.println ("Id declared twice.");
              parser.ReInit(System.in);
            }
            catch (TypeError e) {
              System.out.println ("Unexpected operand type.!");
              parser.ReInit(System.in);
            }
            catch (ParseException e) {
              System.out.println ("Syntax error.");
              parser.ReInit(System.in);
            }
          }
        }
      } else if (args[0].equals("c")) {

        //Compilador
        /*
        CodeBlock c;
        if (args.length > 0){
        c = new CodeBlock();
        Parser parser = new Parser(new FileInputStream(args[0]));
        ASTNode exp = parser.Prog();
        exp.compile(c);
        FileWriter writer = new FileWriter(new File("ctmp"), false);
        writer.write(c.print());
        writer.close();
        */

      }
    }
  }
}
