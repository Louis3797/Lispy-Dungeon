grammar EscapeRoomDSL;

start: escape_room EOF;

escape_room:
	'escape_room:' metadata rooms? quizzes? items? npcs? player? logic? events?;

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
	| room_locked_by_property;

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
	| item_content_property;

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
	| npc_damage_property;

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
player_speed_property: 'speed:' FLOAT;
player_mana_restore_property: 'mana_restore:' FLOAT;
player_stamina_restore_property: 'stamina_restore:' FLOAT;

quizzes: 'quizzes:' quiz+;

quiz: ID ':' quiz_property*;

quiz_property:
	quiz_type_property
	| quiz_question_property
	| quiz_answers_property
	| quiz_correct_answers_property
	| quiz_explanation_property
	| quiz_reward_property
	| quiz_attached_to_property;

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

// Lexer rules
QUIZ_TYPE: 'single_choice' | 'multiple_choice' | 'free_text';

DIFFICULTY: 'easy' | 'medium' | 'hard';

ITEM_TYPE: 'tool' | 'document' | 'decoration';

PLAYER_CLASS: 'wizard' | 'hunter';

BOOLEAN: 'true' | 'false';

ID: [a-zA-Z_][a-zA-Z0-9_]*;

STRING: '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'';

MULTILINE_STRING: '"""' .*? '"""';

FLOAT: '-'? [0-9]+ '.' [0-9]+;

INT: '-'? [0-9]+;

WS: [ \t\r\n]+ -> skip;

COMMENT: '#' ~[\r\n]* -> skip;

// Keywords
AND: 'AND';
OR: 'OR';