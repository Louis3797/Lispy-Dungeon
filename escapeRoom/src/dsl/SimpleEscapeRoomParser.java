package dsl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

/**
 * Simple text-based parser for the Escape Room DSL.
 * This bypasses ANTLR indentation issues by parsing the text directly.
 */
public class SimpleEscapeRoomParser {

    public static EscapeRoomDefinition parse(Path filePath) throws IOException {
        String content = Files.readString(filePath);
        return parse(content);
    }

    public static EscapeRoomDefinition parse(String content) {
        EscapeRoomDefinition def = new EscapeRoomDefinition();
        String[] lines = content.split("\n");

        String currentSection = null;
        String currentId = null;
        Room currentRoom = null;
        Item currentItem = null;
        NPC currentNPC = null;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String trimmed = line.trim();

            if (trimmed.isEmpty())
                continue;

            // Section headers
            if (trimmed.equals("metadata:")) {
                currentSection = "metadata";
                def.metadata = new Metadata();
            } else if (trimmed.equals("rooms:")) {
                currentSection = "rooms";
                def.rooms = new HashMap<>();
            } else if (trimmed.equals("items:")) {
                currentSection = "items";
                def.items = new HashMap<>();
            } else if (trimmed.equals("npcs:")) {
                currentSection = "npcs";
                def.npcs = new HashMap<>();
            }
            // Metadata fields
            else if (currentSection != null && currentSection.equals("metadata")) {
                if (trimmed.startsWith("title:")) {
                    def.metadata.title = extractString(trimmed);
                } else if (trimmed.startsWith("description:")) {
                    def.metadata.description = extractString(trimmed);
                } else if (trimmed.startsWith("difficulty:")) {
                    def.metadata.difficulty = extractString(trimmed);
                } else if (trimmed.startsWith("max_time:")) {
                    def.metadata.maxTime = extractInt(trimmed);
                }
            }
            // Room definitions
            else if (currentSection != null && currentSection.equals("rooms")) {
                if (trimmed.matches("\\w+:") && !trimmed.contains("description") && !trimmed.contains("items")) {
                    currentId = trimmed.replace(":", "");
                    currentRoom = new Room();
                    def.rooms.put(currentId, currentRoom);
                } else if (currentRoom != null) {
                    if (trimmed.startsWith("description:")) {
                        currentRoom.description = extractString(trimmed);
                    } else if (trimmed.startsWith("x:")) {
                        currentRoom.x = extractInt(trimmed);
                    } else if (trimmed.startsWith("y:")) {
                        currentRoom.y = extractInt(trimmed);
                    } else if (trimmed.startsWith("width:")) {
                        currentRoom.width = extractInt(trimmed);
                    } else if (trimmed.startsWith("height:")) {
                        currentRoom.height = extractInt(trimmed);
                    } else if (trimmed.startsWith("items:")) {
                        currentRoom.items = extractArray(trimmed);
                    }
                }
            }
            // Item definitions
            else if (currentSection != null && currentSection.equals("items")) {
                if (trimmed.matches("\\w+:") && !trimmed.contains("description") && !trimmed.contains("type")) {
                    currentId = trimmed.replace(":", "");
                    currentItem = new Item();
                    def.items.put(currentId, currentItem);
                } else if (currentItem != null) {
                    if (trimmed.startsWith("description:")) {
                        currentItem.description = extractString(trimmed);
                    } else if (trimmed.startsWith("type:")) {
                        currentItem.type = extractString(trimmed);
                    } else if (trimmed.startsWith("texture:")) {
                        currentItem.texture = extractString(trimmed);
                    } else if (trimmed.startsWith("visible:")) {
                        currentItem.visible = extractBoolean(trimmed);
                    } else if (trimmed.startsWith("readable:")) {
                        currentItem.readable = extractBoolean(trimmed);
                    } else if (trimmed.startsWith("content:")) {
                        currentItem.content = extractString(trimmed);
                    }
                }
            }
            // NPC definitions
            else if (currentSection != null && currentSection.equals("npcs")) {
                if (trimmed.matches("\\w+:") && !trimmed.contains("description") && !trimmed.contains("texture")) {
                    currentId = trimmed.replace(":", "");
                    currentNPC = new NPC();
                    currentNPC.dialogue = new HashMap<>();
                    def.npcs.put(currentId, currentNPC);
                } else if (currentNPC != null) {
                    if (trimmed.startsWith("description:")) {
                        currentNPC.description = extractString(trimmed);
                    } else if (trimmed.startsWith("texture:")) {
                        currentNPC.texture = extractString(trimmed);
                    } else if (trimmed.startsWith("location:")) {
                        currentNPC.location = extractValue(trimmed);
                    } else if (trimmed.startsWith("default_text:")) {
                        currentNPC.dialogue.put("default", extractString(trimmed));
                    }
                }
            }
        }

        return def;
    }

    private static String extractString(String line) {
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(line);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    private static String extractValue(String line) {
        int colonIndex = line.indexOf(':');
        if (colonIndex >= 0 && colonIndex < line.length() - 1) {
            return line.substring(colonIndex + 1).trim();
        }
        return "";
    }

    private static int extractInt(String line) {
        String value = extractValue(line);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static boolean extractBoolean(String line) {
        String value = extractValue(line);
        return value.equalsIgnoreCase("true");
    }

    private static List<String> extractArray(String line) {
        List<String> result = new ArrayList<>();
        Pattern p = Pattern.compile("\\[([^\\]]*)\\]");
        Matcher m = p.matcher(line);
        if (m.find()) {
            String content = m.group(1);
            String[] items = content.split(",");
            for (String item : items) {
                result.add(item.trim());
            }
        }
        return result;
    }
}
