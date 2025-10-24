// package demoDungeon.level;

// import core.level.utils.DesignLabel;
// import dsl.DSLLevelBuilder;
// import dsl.EscapeRoomDefinition;
// import dsl.EscapeRoomParser;
// import dsl.ParseException;
// import java.io.IOException;
// import java.nio.file.Path;
// import java.nio.file.Paths;

// /** Demo level built from DSL. */
// public class DSLDemoLevel extends core.level.DungeonLevel {

// public DSLDemoLevel() {
// super(
// DSLLevelBuilder.generateLayout(parseDSL()),
// DesignLabel.DEFAULT,
// DSLLevelBuilder.generateCustomPoints(parseDSL()),
// "DSL Demo");
// }

// private static EscapeRoomDefinition parseDSL() {
// try {
// Path dslFile = Paths.get("escapeRoom/src/demoDungeon/level/demo_room.esc");
// EscapeRoomParser parser = new EscapeRoomParser(dslFile);
// return parser.parse();
// } catch (IOException | ParseException e) {
// System.err.println("Failed to load DSL: " + e.getMessage());
// return new EscapeRoomDefinition(); // Return empty definition as fallback
// }
// }

// @Override
// protected void onFirstTick() {
// DSLLevelBuilder.buildLevel(parseDSL());
// }
// }
