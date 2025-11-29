// Generated from c:/Users/kaist/Documents/IDE-workspaces/vs-workspace/Louis/Lispy-Dungeon/escape_room_dsl/EscapeRoomDSL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EscapeRoomDSLParser}.
 */
public interface EscapeRoomDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(EscapeRoomDSLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(EscapeRoomDSLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#escape_room}.
	 * @param ctx the parse tree
	 */
	void enterEscape_room(EscapeRoomDSLParser.Escape_roomContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#escape_room}.
	 * @param ctx the parse tree
	 */
	void exitEscape_room(EscapeRoomDSLParser.Escape_roomContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#metadata}.
	 * @param ctx the parse tree
	 */
	void enterMetadata(EscapeRoomDSLParser.MetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#metadata}.
	 * @param ctx the parse tree
	 */
	void exitMetadata(EscapeRoomDSLParser.MetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#metadata_property}.
	 * @param ctx the parse tree
	 */
	void enterMetadata_property(EscapeRoomDSLParser.Metadata_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#metadata_property}.
	 * @param ctx the parse tree
	 */
	void exitMetadata_property(EscapeRoomDSLParser.Metadata_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#title_property}.
	 * @param ctx the parse tree
	 */
	void enterTitle_property(EscapeRoomDSLParser.Title_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#title_property}.
	 * @param ctx the parse tree
	 */
	void exitTitle_property(EscapeRoomDSLParser.Title_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#description_property}.
	 * @param ctx the parse tree
	 */
	void enterDescription_property(EscapeRoomDSLParser.Description_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#description_property}.
	 * @param ctx the parse tree
	 */
	void exitDescription_property(EscapeRoomDSLParser.Description_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#difficulty_property}.
	 * @param ctx the parse tree
	 */
	void enterDifficulty_property(EscapeRoomDSLParser.Difficulty_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#difficulty_property}.
	 * @param ctx the parse tree
	 */
	void exitDifficulty_property(EscapeRoomDSLParser.Difficulty_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#max_time_property}.
	 * @param ctx the parse tree
	 */
	void enterMax_time_property(EscapeRoomDSLParser.Max_time_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#max_time_property}.
	 * @param ctx the parse tree
	 */
	void exitMax_time_property(EscapeRoomDSLParser.Max_time_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#fog_of_war_property}.
	 * @param ctx the parse tree
	 */
	void enterFog_of_war_property(EscapeRoomDSLParser.Fog_of_war_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#fog_of_war_property}.
	 * @param ctx the parse tree
	 */
	void exitFog_of_war_property(EscapeRoomDSLParser.Fog_of_war_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#view_distance_property}.
	 * @param ctx the parse tree
	 */
	void enterView_distance_property(EscapeRoomDSLParser.View_distance_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#view_distance_property}.
	 * @param ctx the parse tree
	 */
	void exitView_distance_property(EscapeRoomDSLParser.View_distance_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#camera_zoom_property}.
	 * @param ctx the parse tree
	 */
	void enterCamera_zoom_property(EscapeRoomDSLParser.Camera_zoom_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#camera_zoom_property}.
	 * @param ctx the parse tree
	 */
	void exitCamera_zoom_property(EscapeRoomDSLParser.Camera_zoom_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#rooms}.
	 * @param ctx the parse tree
	 */
	void enterRooms(EscapeRoomDSLParser.RoomsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#rooms}.
	 * @param ctx the parse tree
	 */
	void exitRooms(EscapeRoomDSLParser.RoomsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room}.
	 * @param ctx the parse tree
	 */
	void enterRoom(EscapeRoomDSLParser.RoomContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room}.
	 * @param ctx the parse tree
	 */
	void exitRoom(EscapeRoomDSLParser.RoomContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_property(EscapeRoomDSLParser.Room_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_property(EscapeRoomDSLParser.Room_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_description_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_description_property(EscapeRoomDSLParser.Room_description_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_description_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_description_property(EscapeRoomDSLParser.Room_description_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_x_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_x_property(EscapeRoomDSLParser.Room_x_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_x_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_x_property(EscapeRoomDSLParser.Room_x_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_y_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_y_property(EscapeRoomDSLParser.Room_y_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_y_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_y_property(EscapeRoomDSLParser.Room_y_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_width_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_width_property(EscapeRoomDSLParser.Room_width_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_width_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_width_property(EscapeRoomDSLParser.Room_width_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_height_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_height_property(EscapeRoomDSLParser.Room_height_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_height_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_height_property(EscapeRoomDSLParser.Room_height_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_pattern_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_pattern_property(EscapeRoomDSLParser.Room_pattern_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_pattern_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_pattern_property(EscapeRoomDSLParser.Room_pattern_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_items_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_items_property(EscapeRoomDSLParser.Room_items_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_items_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_items_property(EscapeRoomDSLParser.Room_items_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_npcs_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_npcs_property(EscapeRoomDSLParser.Room_npcs_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_npcs_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_npcs_property(EscapeRoomDSLParser.Room_npcs_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_connections_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_connections_property(EscapeRoomDSLParser.Room_connections_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_connections_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_connections_property(EscapeRoomDSLParser.Room_connections_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#room_locked_by_property}.
	 * @param ctx the parse tree
	 */
	void enterRoom_locked_by_property(EscapeRoomDSLParser.Room_locked_by_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#room_locked_by_property}.
	 * @param ctx the parse tree
	 */
	void exitRoom_locked_by_property(EscapeRoomDSLParser.Room_locked_by_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#items}.
	 * @param ctx the parse tree
	 */
	void enterItems(EscapeRoomDSLParser.ItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#items}.
	 * @param ctx the parse tree
	 */
	void exitItems(EscapeRoomDSLParser.ItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(EscapeRoomDSLParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(EscapeRoomDSLParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_property(EscapeRoomDSLParser.Item_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_property(EscapeRoomDSLParser.Item_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_description_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_description_property(EscapeRoomDSLParser.Item_description_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_description_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_description_property(EscapeRoomDSLParser.Item_description_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_type_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_type_property(EscapeRoomDSLParser.Item_type_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_type_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_type_property(EscapeRoomDSLParser.Item_type_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_texture_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_texture_property(EscapeRoomDSLParser.Item_texture_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_texture_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_texture_property(EscapeRoomDSLParser.Item_texture_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_properties_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_properties_property(EscapeRoomDSLParser.Item_properties_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_properties_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_properties_property(EscapeRoomDSLParser.Item_properties_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_location_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_location_property(EscapeRoomDSLParser.Item_location_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_location_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_location_property(EscapeRoomDSLParser.Item_location_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_visible_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_visible_property(EscapeRoomDSLParser.Item_visible_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_visible_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_visible_property(EscapeRoomDSLParser.Item_visible_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_readable_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_readable_property(EscapeRoomDSLParser.Item_readable_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_readable_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_readable_property(EscapeRoomDSLParser.Item_readable_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#item_content_property}.
	 * @param ctx the parse tree
	 */
	void enterItem_content_property(EscapeRoomDSLParser.Item_content_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#item_content_property}.
	 * @param ctx the parse tree
	 */
	void exitItem_content_property(EscapeRoomDSLParser.Item_content_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npcs}.
	 * @param ctx the parse tree
	 */
	void enterNpcs(EscapeRoomDSLParser.NpcsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npcs}.
	 * @param ctx the parse tree
	 */
	void exitNpcs(EscapeRoomDSLParser.NpcsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc}.
	 * @param ctx the parse tree
	 */
	void enterNpc(EscapeRoomDSLParser.NpcContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc}.
	 * @param ctx the parse tree
	 */
	void exitNpc(EscapeRoomDSLParser.NpcContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_property(EscapeRoomDSLParser.Npc_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_property(EscapeRoomDSLParser.Npc_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_description_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_description_property(EscapeRoomDSLParser.Npc_description_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_description_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_description_property(EscapeRoomDSLParser.Npc_description_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_texture_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_texture_property(EscapeRoomDSLParser.Npc_texture_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_texture_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_texture_property(EscapeRoomDSLParser.Npc_texture_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_location_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_location_property(EscapeRoomDSLParser.Npc_location_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_location_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_location_property(EscapeRoomDSLParser.Npc_location_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_dialogue_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_dialogue_property(EscapeRoomDSLParser.Npc_dialogue_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_dialogue_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_dialogue_property(EscapeRoomDSLParser.Npc_dialogue_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_gives_items_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_gives_items_property(EscapeRoomDSLParser.Npc_gives_items_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_gives_items_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_gives_items_property(EscapeRoomDSLParser.Npc_gives_items_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_requires_items_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_requires_items_property(EscapeRoomDSLParser.Npc_requires_items_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_requires_items_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_requires_items_property(EscapeRoomDSLParser.Npc_requires_items_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_start_x_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_start_x_property(EscapeRoomDSLParser.Npc_start_x_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_start_x_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_start_x_property(EscapeRoomDSLParser.Npc_start_x_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_start_y_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_start_y_property(EscapeRoomDSLParser.Npc_start_y_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_start_y_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_start_y_property(EscapeRoomDSLParser.Npc_start_y_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_hostile_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_hostile_property(EscapeRoomDSLParser.Npc_hostile_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_hostile_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_hostile_property(EscapeRoomDSLParser.Npc_hostile_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_health_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_health_property(EscapeRoomDSLParser.Npc_health_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_health_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_health_property(EscapeRoomDSLParser.Npc_health_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#npc_damage_property}.
	 * @param ctx the parse tree
	 */
	void enterNpc_damage_property(EscapeRoomDSLParser.Npc_damage_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#npc_damage_property}.
	 * @param ctx the parse tree
	 */
	void exitNpc_damage_property(EscapeRoomDSLParser.Npc_damage_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dialogue}.
	 * @param ctx the parse tree
	 */
	void enterDialogue(EscapeRoomDSLParser.DialogueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dialogue}.
	 * @param ctx the parse tree
	 */
	void exitDialogue(EscapeRoomDSLParser.DialogueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dialogue_property}.
	 * @param ctx the parse tree
	 */
	void enterDialogue_property(EscapeRoomDSLParser.Dialogue_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dialogue_property}.
	 * @param ctx the parse tree
	 */
	void exitDialogue_property(EscapeRoomDSLParser.Dialogue_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dialogue_conditions}.
	 * @param ctx the parse tree
	 */
	void enterDialogue_conditions(EscapeRoomDSLParser.Dialogue_conditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dialogue_conditions}.
	 * @param ctx the parse tree
	 */
	void exitDialogue_conditions(EscapeRoomDSLParser.Dialogue_conditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dialogue_condition}.
	 * @param ctx the parse tree
	 */
	void enterDialogue_condition(EscapeRoomDSLParser.Dialogue_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dialogue_condition}.
	 * @param ctx the parse tree
	 */
	void exitDialogue_condition(EscapeRoomDSLParser.Dialogue_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player}.
	 * @param ctx the parse tree
	 */
	void enterPlayer(EscapeRoomDSLParser.PlayerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player}.
	 * @param ctx the parse tree
	 */
	void exitPlayer(EscapeRoomDSLParser.PlayerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_property(EscapeRoomDSLParser.Player_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_property(EscapeRoomDSLParser.Player_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_class_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_class_property(EscapeRoomDSLParser.Player_class_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_class_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_class_property(EscapeRoomDSLParser.Player_class_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_start_x_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_start_x_property(EscapeRoomDSLParser.Player_start_x_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_start_x_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_start_x_property(EscapeRoomDSLParser.Player_start_x_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_start_y_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_start_y_property(EscapeRoomDSLParser.Player_start_y_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_start_y_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_start_y_property(EscapeRoomDSLParser.Player_start_y_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_health_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_health_property(EscapeRoomDSLParser.Player_health_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_health_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_health_property(EscapeRoomDSLParser.Player_health_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_mana_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_mana_property(EscapeRoomDSLParser.Player_mana_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_mana_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_mana_property(EscapeRoomDSLParser.Player_mana_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_stamina_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_stamina_property(EscapeRoomDSLParser.Player_stamina_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_stamina_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_stamina_property(EscapeRoomDSLParser.Player_stamina_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_speed_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_speed_property(EscapeRoomDSLParser.Player_speed_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_speed_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_speed_property(EscapeRoomDSLParser.Player_speed_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_mana_restore_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_mana_restore_property(EscapeRoomDSLParser.Player_mana_restore_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_mana_restore_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_mana_restore_property(EscapeRoomDSLParser.Player_mana_restore_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#player_stamina_restore_property}.
	 * @param ctx the parse tree
	 */
	void enterPlayer_stamina_restore_property(EscapeRoomDSLParser.Player_stamina_restore_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#player_stamina_restore_property}.
	 * @param ctx the parse tree
	 */
	void exitPlayer_stamina_restore_property(EscapeRoomDSLParser.Player_stamina_restore_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quizzes}.
	 * @param ctx the parse tree
	 */
	void enterQuizzes(EscapeRoomDSLParser.QuizzesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quizzes}.
	 * @param ctx the parse tree
	 */
	void exitQuizzes(EscapeRoomDSLParser.QuizzesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz}.
	 * @param ctx the parse tree
	 */
	void enterQuiz(EscapeRoomDSLParser.QuizContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz}.
	 * @param ctx the parse tree
	 */
	void exitQuiz(EscapeRoomDSLParser.QuizContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_property(EscapeRoomDSLParser.Quiz_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_property(EscapeRoomDSLParser.Quiz_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_type_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_type_property(EscapeRoomDSLParser.Quiz_type_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_type_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_type_property(EscapeRoomDSLParser.Quiz_type_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_question_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_question_property(EscapeRoomDSLParser.Quiz_question_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_question_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_question_property(EscapeRoomDSLParser.Quiz_question_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_answers_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_answers_property(EscapeRoomDSLParser.Quiz_answers_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_answers_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_answers_property(EscapeRoomDSLParser.Quiz_answers_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_correct_answers_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_correct_answers_property(EscapeRoomDSLParser.Quiz_correct_answers_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_correct_answers_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_correct_answers_property(EscapeRoomDSLParser.Quiz_correct_answers_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_explanation_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_explanation_property(EscapeRoomDSLParser.Quiz_explanation_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_explanation_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_explanation_property(EscapeRoomDSLParser.Quiz_explanation_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_reward_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_reward_property(EscapeRoomDSLParser.Quiz_reward_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_reward_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_reward_property(EscapeRoomDSLParser.Quiz_reward_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#quiz_attached_to_property}.
	 * @param ctx the parse tree
	 */
	void enterQuiz_attached_to_property(EscapeRoomDSLParser.Quiz_attached_to_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#quiz_attached_to_property}.
	 * @param ctx the parse tree
	 */
	void exitQuiz_attached_to_property(EscapeRoomDSLParser.Quiz_attached_to_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(EscapeRoomDSLParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(EscapeRoomDSLParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic_expr(EscapeRoomDSLParser.Logic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic_expr(EscapeRoomDSLParser.Logic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#logic_term}.
	 * @param ctx the parse tree
	 */
	void enterLogic_term(EscapeRoomDSLParser.Logic_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#logic_term}.
	 * @param ctx the parse tree
	 */
	void exitLogic_term(EscapeRoomDSLParser.Logic_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dependencies}.
	 * @param ctx the parse tree
	 */
	void enterDependencies(EscapeRoomDSLParser.DependenciesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dependencies}.
	 * @param ctx the parse tree
	 */
	void exitDependencies(EscapeRoomDSLParser.DependenciesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#dependency}.
	 * @param ctx the parse tree
	 */
	void enterDependency(EscapeRoomDSLParser.DependencyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#dependency}.
	 * @param ctx the parse tree
	 */
	void exitDependency(EscapeRoomDSLParser.DependencyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#events}.
	 * @param ctx the parse tree
	 */
	void enterEvents(EscapeRoomDSLParser.EventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#events}.
	 * @param ctx the parse tree
	 */
	void exitEvents(EscapeRoomDSLParser.EventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(EscapeRoomDSLParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(EscapeRoomDSLParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#event_trigger}.
	 * @param ctx the parse tree
	 */
	void enterEvent_trigger(EscapeRoomDSLParser.Event_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#event_trigger}.
	 * @param ctx the parse tree
	 */
	void exitEvent_trigger(EscapeRoomDSLParser.Event_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(EscapeRoomDSLParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(EscapeRoomDSLParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#action_type}.
	 * @param ctx the parse tree
	 */
	void enterAction_type(EscapeRoomDSLParser.Action_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#action_type}.
	 * @param ctx the parse tree
	 */
	void exitAction_type(EscapeRoomDSLParser.Action_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(EscapeRoomDSLParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(EscapeRoomDSLParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(EscapeRoomDSLParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(EscapeRoomDSLParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(EscapeRoomDSLParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(EscapeRoomDSLParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(EscapeRoomDSLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(EscapeRoomDSLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EscapeRoomDSLParser#multiline_string}.
	 * @param ctx the parse tree
	 */
	void enterMultiline_string(EscapeRoomDSLParser.Multiline_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link EscapeRoomDSLParser#multiline_string}.
	 * @param ctx the parse tree
	 */
	void exitMultiline_string(EscapeRoomDSLParser.Multiline_stringContext ctx);
}