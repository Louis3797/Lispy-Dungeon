package starter;

import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;
import dsl.EscapeRoomInterpreter;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Main class to parse and run the Escape Room DSL.
 */
public class DSLParserMain {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java DSLParserMain <dsl-file>");
            System.exit(1);
        }

        String dslFile = args[0];
        String input = Files.readString(Paths.get(dslFile));

        // Create ANTLR input stream
        CharStream inputStream = CharStreams.fromString(input);

        // Create lexer
        EscapeRoomDSLLexer lexer = new EscapeRoomDSLLexer(inputStream);

        // Create token stream
        CommonTokenStream tokens = new CommonTokenStream(lexer); // Create parser
        EscapeRoomDSLParser parser = new EscapeRoomDSLParser(tokens);

        // Parse the input starting from the 'start' rule
        EscapeRoomDSLParser.StartContext tree = parser.start();

        // Print the parse tree (for debugging)
        System.out.println("=== Parse Tree ===");
        System.out.println(tree.toStringTree(parser));
        System.out.println();

        // Interpret the parsed tree (ANTLR approach - has indentation issues)
        System.out.println("=== ANTLR Interpreter (may have issues) ===");
        Object definition = EscapeRoomInterpreter.interpret(tree);
        System.out.println(definition);
        System.out.println();

        // Use simple text parser as a workaround
        System.out.println("=== Simple Text Parser (working) ===");
        Object simpleDef = dsl.SimpleEscapeRoomParser.parse(input);
        System.out.println(simpleDef);
        System.out.println();

        System.out.println("[OK] DSL parsing and interpretation complete!");
    }
}