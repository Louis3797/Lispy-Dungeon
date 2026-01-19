grammar EscapeRoomDSL;

start: escape_room EOF;

escape_room:
	'escape_room:' metadata variables_block? rooms? quizzes? items? npcs? player? triggers_block?
		logic? events?;

// ============================================================================ TIER 1: Variables
// Block ============================================================================
variables_block: 'variables:' variable_def*;

variable_def: ID ':' expression;

// ============================================================================ TIER 2: Expressions
// (with precedence) ============================================================================
expression:
	primary_expression										# PrimaryExpr
	| expression '.' ID										# PropertyAccessExpr
	| ID '(' (expression (',' expression)*)? ')'			# FunctionCallExpr
	| ('!' | '-') expression								# UnaryExpr
	| expression op = ('*' | '/' | '%') expression			# MulDivExpr
	| expression op = ('+' | '-') expression				# AddSubExpr
	| expression op = ('<' | '>' | '<=' | '>=') expression	# CompareExpr
	| expression op = ('==' | '!=') expression				# EqualityExpr
	| expression '&&' expression							# AndExpr
	| expression '||' expression							# OrExpr
	| 'if' '(' expression ')' expression 'else' expression	# TernaryExpr;

primary_expression:
	INT						# IntLiteral
	| FLOAT					# FloatLiteral
	| STRING				# StringLiteral
	| BOOLEAN				# BoolLiteral
	| ID					# IdentifierExpr
	| '(' expression ')'	# ParenExpr
	| array					# ArrayLiteral;

// ============================================================================ TIER 3: Triggers
// Block (Global Conditions)
// ============================================================================
triggers_block: 'triggers:' trigger_def*;

trigger_def: 'when' '(' expression ')' statement_block;

// ============================================================================ TIER 3: Statements &
// Event Handlers ============================================================================
statement_block: '{' statement* '}';

statement:
	assignment_statement
	| function_call_statement
	| if_statement
	| repeat_statement;

assignment_statement: (ID | property_access) op = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
	) expression;

property_access: ID ('.' ID)+;

// Allow calling built-in keyword-like actions (e.g., show_message, unlock) as statements. These are
// currently tokenized as fixed literals by the lexer, so we must accept them here.
function_call_statement:
	(
		ID
		| SHOW_MESSAGE
		| UNLOCK
		| LOCK
		| VICTORY
		| GAME_OVER
		| SPAWN
		| SPAWN_MONSTER
		| GIVE_ITEM
		| PRINT
		| PLAY_SOUND
	) '(' (expression (',' expression)*)? ')';

if_statement:
	'if' '(' expression ')' statement_block (
		'else' (if_statement | statement_block)
	)?;

repeat_statement:
	'repeat' INT statement_block									# RepeatCount
	| 'repeat' ID 'from' expression 'to' expression statement_block	# RepeatRange;

// ============================================================================ TIER 3: Event
// Handlers (for rooms, items, npcs)
// ============================================================================
event_handler:
	'on_enter' statement_block
	| 'on_exit' statement_block
	| 'on_first_enter' statement_block
	| 'on_clear' statement_block
	| 'on_pickup' statement_block
	| 'on_use' statement_block
	| 'on_drop' statement_block
	| 'on_interact' statement_block
	| 'on_death' statement_block
	| 'on_correct' statement_block
	| 'on_wrong' statement_block;

metadata: 'metadata:' metadata_property*;

metadata_property:
	title_property
	| description_property
	| difficulty_property
	| max_time_property
	| fog_of_war_property
	| view_distance_property
	| camera_zoom_property;

title_property: 'title:' STRING;
description_property: 'description:' STRING;
difficulty_property: 'difficulty:' STRING;
max_time_property: 'max_time:' INT;
fog_of_war_property: 'fog_of_war:' BOOLEAN;
view_distance_property: 'view_distance:' INT;
camera_zoom_property: 'camera_zoom:' FLOAT;

rooms: 'rooms:' room+;

room: ID ':' room_property*;

room_property:
	room_description_property
	| room_x_property
	| room_y_property
	| room_width_property
	| room_height_property
	| room_pattern_property
	| room_items_property
	| room_npcs_property
	| room_connections_property
	| room_locked_by_property
	| event_handler; // TIER 3: Rooms can have event handlers

room_description_property: 'description:' STRING;
room_x_property: 'x:' INT;
room_y_property: 'y:' INT;
room_width_property: 'width:' INT;
room_height_property: 'height:' INT;
room_pattern_property: 'pattern:' multiline_string;
room_items_property: 'items:' array;
room_npcs_property: 'npcs:' array;
room_connections_property: 'connections:' array;
room_locked_by_property: 'locked_by:' ID;

items: 'items:' item+;

item: ID ':' item_property*;

item_property:
	item_description_property
	| item_type_property
	| item_texture_property
	| item_properties_property
	| item_location_property
	| item_visible_property
	| item_readable_property
	| item_content_property
	| event_handler; // TIER 3: Items can have event handlers

item_description_property: 'description:' STRING;
item_type_property: 'type:' (ITEM_TYPE | STRING);
item_texture_property: 'texture:' STRING;
item_properties_property: 'properties:' object;
item_location_property: 'location:' ID;
item_visible_property: 'visible:' BOOLEAN;
item_readable_property: 'readable:' BOOLEAN;
item_content_property: 'content:' STRING;

npcs: 'npcs:' npc+;

npc: ID ':' npc_property*;

npc_property:
	npc_description_property
	| npc_texture_property
	| npc_location_property
	| npc_dialogue_property
	| npc_gives_items_property
	| npc_requires_items_property
	| npc_start_x_property
	| npc_start_y_property
	| npc_hostile_property
	| npc_health_property
	| npc_damage_property
	| event_handler; // TIER 3: NPCs can have event handlers

npc_description_property: 'description:' STRING;
npc_texture_property: 'texture:' STRING;
npc_location_property: 'location:' ID;
npc_dialogue_property: 'dialogue:' dialogue;
npc_gives_items_property: 'gives_items:' array;
npc_requires_items_property: 'requires_items:' array;
npc_start_x_property: 'start_x:' INT;
npc_start_y_property: 'start_y:' INT;
npc_hostile_property: 'hostile:' BOOLEAN;
npc_health_property: 'health:' INT;
npc_damage_property: 'damage:' INT;

dialogue: dialogue_property+;

dialogue_property:
	'default_text:' STRING
	| 'default:' STRING
	| 'conditions:' dialogue_conditions;

dialogue_conditions: dialogue_condition+;

dialogue_condition: ID ':' STRING;

player: 'player:' player_property*;

player_property:
	player_class_property
	| player_start_x_property
	| player_start_y_property
	| player_health_property
	| player_mana_property
	| player_stamina_property
	| player_speed_property
	| player_mana_restore_property
	| player_stamina_restore_property;

player_class_property: 'class:' PLAYER_CLASS;
player_start_x_property: 'start_x:' INT;
player_start_y_property: 'start_y:' INT;
player_health_property: 'health:' INT;
player_mana_property: 'mana:' INT;
player_stamina_property: 'stamina:' INT;
player_speed_property: 'speed:' (FLOAT | INT);
player_mana_restore_property: 'mana_restore:' (FLOAT | INT);
player_stamina_restore_property:
	'stamina_restore:' (FLOAT | INT);

quizzes: 'quizzes:' quiz+;

quiz: ID ':' quiz_property*;

quiz_property:
	quiz_type_property
	| quiz_question_property
	| quiz_answers_property
	| quiz_correct_answers_property
	| quiz_explanation_property
	| quiz_reward_property
	| quiz_attached_to_property
	| event_handler; // TIER 3: Quizzes can have event handlers

quiz_type_property: 'type:' QUIZ_TYPE;
quiz_question_property: 'question:' STRING;
quiz_answers_property: 'answers:' array;
quiz_correct_answers_property: 'correct_answers:' array;
quiz_explanation_property: 'explanation:' STRING;
quiz_reward_property: 'reward:' ID;
quiz_attached_to_property: 'attached_to:' ID;

logic:
	'logic:' ('win_condition:' logic_expr)? (
		'dependencies:' dependencies
	)? ('state_variables:' object)? ('timers:' object)?;

logic_expr: logic_term (('AND' | 'OR') logic_term)*;

logic_term: ID | '(' logic_expr ')';

dependencies: dependency+;

dependency: ID ':' ID;

events: 'events:' event+;

event: event_trigger ':' 'actions:' action+;

event_trigger:
	'on_puzzle_solved' ':' ID
	| 'on_item_collected' ':' ID
	| 'on_time_warning' ':' INT;

action: action_type ':' value;

action_type:
	'unlock_door'
	| 'play_sound'
	| 'show_message'
	| 'trigger_puzzle'
	| 'update_state';

object: '{' pair+ '}';

pair: ID ':' value;

array: '[' (value (',' value)*)? ']';

value:
	STRING
	| FLOAT
	| INT
	| BOOLEAN
	| ITEM_TYPE
	| QUIZ_TYPE
	| DIFFICULTY
	| ID
	| array
	| object;

multiline_string: MULTILINE_STRING;

// ============================================================================ Lexer rules
// ============================================================================

// Keywords (must come before ID)
IF: 'if';
ELSE: 'else';
WHEN: 'when';
REPEAT: 'repeat';
FROM: 'from';
TO: 'to';
AND: 'AND';
OR: 'OR';

SHOW_MESSAGE: 'show_message';
UNLOCK: 'unlock';
LOCK: 'lock';
VICTORY: 'victory';
GAME_OVER: 'game_over';
SPAWN: 'spawn';
SPAWN_MONSTER: 'spawn_monster';
GIVE_ITEM: 'give_item';
PRINT: 'print';
PLAY_SOUND: 'play_sound';

// Types
QUIZ_TYPE: 'single_choice' | 'multiple_choice' | 'free_text';
DIFFICULTY: 'easy' | 'medium' | 'hard';
ITEM_TYPE: 'tool' | 'document' | 'decoration';
PLAYER_CLASS: 'wizard' | 'hunter';
BOOLEAN: 'true' | 'false';

// Operators (for expressions)
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
PERCENT: '%';
EQ: '==';
NEQ: '!=';
LT: '<';
GT: '>';
LTE: '<=';
GTE: '>=';
AND_OP: '&&';
OR_OP: '||';
NOT: '!';
ASSIGN: '=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
STAR_ASSIGN: '*=';
SLASH_ASSIGN: '/=';

// Punctuation
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';
COLON: ':';
COMMA: ',';
DOT: '.';

// Identifiers and literals
ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'';
MULTILINE_STRING: '"""' .*? '"""';
FLOAT: '-'? [0-9]+ '.' [0-9]+;
INT: '-'? [0-9]+;

// Whitespace and comments
WS: [ \t\r\n]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;