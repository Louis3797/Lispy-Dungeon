package starter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import core.Game;
import core.utils.logging.CustomLogLevel;
import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;

/**
 * Main class to parse and run the Escape Room DSL.
 */
public class DSLParserMain {

    private static final Logger LOGGER = Logger.getLogger(DSLParserMain.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        Game.initBaseLogger(CustomLogLevel.DEBUG);

        if (args.length < 1) {
            LOGGER.warning("Usage: java DSLParserMain <dsl-file>");
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

        System.out.println("DSL parsing and interpretation complete!");
    }
}