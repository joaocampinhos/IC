import java.io.*;
import java.util.*;

public class Main {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static void main(String args[]) throws IOException, ParseException, TypeError, UndefinedField{

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
            System.out.println (ANSI_RED + "Undeclared id." + ANSI_RESET);
          }
          catch (Env.IdentifierDeclaredTwice e) {
            System.out.println (ANSI_RED + "Id declared twice." + ANSI_RESET);
          }
          catch (TypeError e) {
            System.out.println (ANSI_RED + "Unexpected operand type.!" + ANSI_RESET);
          }
          catch (UndefinedField e) {
            System.out.println (ANSI_RED + "Undefined field on the Record" + ANSI_RESET);
          }
          catch (ParseException e) {
            System.out.println (ANSI_RED + "Syntax error." + ANSI_RESET);
          }

        } else { // Sem ficheiro
          parser = new Parser(System.in);

          while (true) {
            System.out.print("> ");
            try {
              exp = parser.Prog();
              System.out.println("-> "+exp.typeCheck(new TypeEnv()));
              System.out.println(ANSI_YELLOW + exp.eval(new Env()) + ANSI_RESET);
            }
            catch (Env.UndeclaredIdentifier e) {
              System.out.println (ANSI_RED + "Undeclared id." + ANSI_RESET);
              parser.ReInit(System.in);
            }
            catch (Env.IdentifierDeclaredTwice e) {
              System.out.println (ANSI_RED + "Id declared twice." + ANSI_RESET);
              parser.ReInit(System.in);
            }
            catch (TypeError e) {
              System.out.println (ANSI_RED + "Unexpected operand type.!" + ANSI_RESET);
              parser.ReInit(System.in);
            }
            catch (UndefinedField e) {
              System.out.println (ANSI_RED + "Undefined field on the Record" + ANSI_RESET);
            }
            catch (ParseException e) {
              System.out.println (ANSI_RED + "Syntax error." + ANSI_RESET);
              parser.ReInit(System.in);
            }
          }
        }
      } else if (args[0].equals("c")) {

        //Compilador

        CodeBlock c;
        if (args.length > 0){
          c = new CodeBlock();
          Parser parser = new Parser(new FileInputStream(args[1]));
          ASTNode exp = parser.Prog();
          exp.compile(c);
          FileWriter writer = new FileWriter(new File("ctmp"), false);
          writer.write(c.print());
          writer.close();
        }
      }
    }
  }
}
