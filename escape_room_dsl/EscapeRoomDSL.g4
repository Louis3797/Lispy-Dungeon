grammar EscapeRoomDSL;

start
    : escape_room EOF
    ;

escape_room
    : 'escape_room:' metadata rooms? quizzes? items? npcs? player? logic? events?
    ;

metadata
    : 'metadata:'
      ('title:' STRING)?
      ('description:' STRING)?
      ('difficulty:' STRING)?
      ('max_time:' INT)?
      ('fog_of_war:' BOOLEAN)?
      ('view_distance:' INT)?
      ('camera_zoom:' FLOAT)?
    ;

rooms
    : 'rooms:' room+
    ;

room
    : ID ':'
      ('description:' STRING)?
      ('x:' INT)?
      ('y:' INT)?
      ('width:' INT)?
      ('height:' INT)?
      ('pattern:' multiline_string)?
      ('items:' array)?
      ('npcs:' array)?
      ('connections:' array)?
      ('locked_by:' ID)?
    ;

items
    : 'items:' item+
    ;

item
    : ID ':'
      item_property*
    ;

item_property
    : 'description:' STRING
    | 'type:' (ITEM_TYPE | STRING)
    | 'texture:' STRING
    | 'properties:' object
    | 'location:' ID
    | 'visible:' BOOLEAN
    | 'readable:' BOOLEAN
    | 'content:' STRING
    ;

npcs
    : 'npcs:' npc+
    ;

npc
    : ID ':'
      npc_property*
    ;

npc_property
    : 'description:' STRING
    | 'texture:' STRING
    | 'location:' ID
    | 'dialogue:' dialogue
    | 'gives_items:' array
    | 'requires_items:' array
    | 'start_x:' INT
    | 'start_y:' INT
    | 'hostile:' BOOLEAN
    | 'health:' INT
    | 'damage:' INT
    ;

dialogue
    : dialogue_property+
    ;

dialogue_property
    : 'default_text:' STRING
    | 'default:' STRING
    | 'conditions:' dialogue_conditions
    ;

dialogue_conditions
    : dialogue_condition+
    ;

dialogue_condition
    : ID ':' STRING
    ;

player
    : 'player:'
      ('class:' PLAYER_CLASS)?
      ('start_x:' INT)?
      ('start_y:' INT)?
      ('health:' INT)?
      ('mana:' INT)?
      ('stamina:' INT)?
      ('speed:' FLOAT)?
      ('mana_restore:' FLOAT)?
      ('stamina_restore:' FLOAT)?
    ;

quizzes
    : 'quizzes:' quiz+
    ;

quiz
    : ID ':'
      quiz_property+
    ;

quiz_property
    : 'type:' QUIZ_TYPE
    | 'question:' STRING
    | 'answers:' array
    | 'correct_answers:' array
    | 'explanation:' STRING
    | 'reward:' ID
    | 'attached_to:' ID
    ;

logic
    : 'logic:'
      ('win_condition:' logic_expr)?
      ('dependencies:' dependencies)?
      ('state_variables:' object)?
      ('timers:' object)?
     
    ;

logic_expr
    : logic_term (('AND' | 'OR') logic_term)*
    ;

logic_term
    : ID
    | '(' logic_expr ')'
    ;

dependencies
    : dependency+
    ;

dependency
    : ID ':' ID
    ;

events
    : 'events:' event+
    ;

event
    : event_trigger ':'
      'actions:' action+
     
    ;

event_trigger
    : 'on_puzzle_solved' ':' ID
    | 'on_item_collected' ':' ID
    | 'on_time_warning' ':' INT
    ;

action
    : action_type ':' value
    ;

action_type
    : 'unlock_door'
    | 'play_sound'
    | 'show_message'
    | 'trigger_puzzle'
    | 'update_state'
    ;

object
    : '{' pair+ '}'
    ;

pair
    : ID ':' value
    ;

array
    : '[' (value (',' value)*)? ']'
    ;

value
    : STRING
    | FLOAT
    | INT
    | BOOLEAN
    | ITEM_TYPE
    | QUIZ_TYPE
    | DIFFICULTY
    | ID
    | array
    | object
    ;

multiline_string
    : MULTILINE_STRING
    ;

// Lexer rules
QUIZ_TYPE
    : 'single_choice'
    | 'multiple_choice'
    | 'free_text'
    ;

DIFFICULTY
    : 'easy'
    | 'medium'
    | 'hard'
    ;

ITEM_TYPE
    : 'tool'
    | 'document'
    | 'decoration'
    ;

PLAYER_CLASS
    : 'wizard'
    | 'hunter'
    ;

BOOLEAN
    : 'true'
    | 'false'
    ;

ID
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

MULTILINE_STRING
    : '"""' .*? '"""'
    ;

FLOAT
    : '-'? [0-9]+ '.' [0-9]+
    ;

INT
    : '-'? [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;

// Keywords
AND : 'AND';
OR : 'OR';