# Escape Room DSL Extension

Syntax highlighting for Escape Room DSL (`.esc`) files.

## Features

-   Syntax highlighting for:
    -   Keywords: `escape_room`
    -   Section headers: `metadata`, `rooms`, `items`, `npcs`, `quizzes`, `player`, etc.
    -   Properties: `title`, `description`, `x`, `y`, `width`, `height`, etc.
    -   Strings (single and triple-quoted)
    -   Numbers (integers and floats)
    -   Booleans (`true`, `false`)
    -   Arrays
    -   Comments

## Installation

1. Copy this folder to your VS Code extensions directory:

    - **macOS/Linux**: `~/.vscode/extensions/`
    - **Windows**: `%USERPROFILE%\.vscode\extensions\`

2. Reload VS Code

3. Open any `.esc` file to see syntax highlighting

## Manual Installation from Workspace

```bash
# From the project root
cp -r .vscode-esc-extension ~/.vscode/extensions/escape-room-dsl-0.1.0
```

Then reload VS Code.

## Development

To modify the syntax highlighting:

1. Edit `syntaxes/esc.tmLanguage.json`
2. Reload VS Code (Cmd+R / Ctrl+R in Extension Development Host)
3. Test with your `.esc` files

## License

Same as Lispy-Dungeon project
