package starter;

import dsl.parser.EscapeRoomDSLLexer;
import dsl.parser.EscapeRoomDSLParser;
import dsl.EscapeRoomInterpreter;
import org.antlr.v4.runtime.*;

import core.Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class to parse and run the Escape Room DSL.
 */
public class DSLParserMain {

    private static final Logger LOGGER = Logger.getLogger(DSLParserMain.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        Game.initBaseLogger(Level.INFO);

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
        LOGGER.info("=== Parse Tree ===");
        LOGGER.info(tree.toStringTree(parser));

        // Interpret the parsed tree (ANTLR approach - has indentation issues)
        LOGGER.info("=== ANTLR Interpreter (may have issues) ===");
        Object definition = EscapeRoomInterpreter.interpret(tree);
        LOGGER.info(definition.toString());

        // Use simple text parser as a workaround
        LOGGER.info("=== Simple Text Parser (working) ===");
        Object simpleDef = dsl.SimpleEscapeRoomParser.parse(input);
        LOGGER.info(simpleDef.toString());

        LOGGER.info("DSL parsing and interpretation complete!");
    }
}