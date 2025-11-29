grammar EscapeRoomDSL;

start: escape_room EOF;

escape_room: 'escape_room:' metadata rooms player;

metadata: 'metadata:' metadata_property*;

metadata_property:
	title_property
	| description_property
	| max_time_property
	| fog_of_war_property
	| view_distance_property
	| camera_zoom_property;

title_property: 'title:' STRING;
description_property: 'description:' STRING;
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
	| room_connections_property;

room_description_property: 'description:' STRING;
room_x_property: 'x:' INT;
room_y_property: 'y:' INT;
room_width_property: 'width:' INT;
room_height_property: 'height:' INT;
room_pattern_property: 'pattern:' multiline_string;
room_connections_property: 'connections:' array;

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

array: '[' (value (',' value)*)? ']';

value: STRING | FLOAT | INT | BOOLEAN | ID | array;

multiline_string: MULTILINE_STRING;

// Lexer rules
PLAYER_CLASS: 'wizard' | 'hunter';

BOOLEAN: 'true' | 'false';

ID: [a-zA-Z_][a-zA-Z0-9_]*;

STRING: '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'';

MULTILINE_STRING: '"""' .*? '"""';

FLOAT: '-'? [0-9]+ '.' [0-9]+;

INT: '-'? [0-9]+;

WS: [ \t\r\n]+ -> skip;

COMMENT: '#' ~[\r\n]* -> skip;