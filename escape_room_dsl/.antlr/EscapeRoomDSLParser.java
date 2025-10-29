// Generated from /Users/louis/Documents/repos/Lispy-Dungeon/escape_room_dsl/EscapeRoomDSL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EscapeRoomDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, QUIZ_TYPE=75, DIFFICULTY=76, ITEM_TYPE=77, PLAYER_CLASS=78, 
		BOOLEAN=79, ID=80, STRING=81, MULTILINE_STRING=82, FLOAT=83, INT=84, WS=85, 
		COMMENT=86, AND=87, OR=88;
	public static final int
		RULE_start = 0, RULE_escape_room = 1, RULE_metadata = 2, RULE_metadata_property = 3, 
		RULE_title_property = 4, RULE_description_property = 5, RULE_difficulty_property = 6, 
		RULE_max_time_property = 7, RULE_fog_of_war_property = 8, RULE_view_distance_property = 9, 
		RULE_camera_zoom_property = 10, RULE_rooms = 11, RULE_room = 12, RULE_room_property = 13, 
		RULE_room_description_property = 14, RULE_room_x_property = 15, RULE_room_y_property = 16, 
		RULE_room_width_property = 17, RULE_room_height_property = 18, RULE_room_pattern_property = 19, 
		RULE_room_items_property = 20, RULE_room_npcs_property = 21, RULE_room_connections_property = 22, 
		RULE_room_locked_by_property = 23, RULE_items = 24, RULE_item = 25, RULE_item_property = 26, 
		RULE_item_description_property = 27, RULE_item_type_property = 28, RULE_item_texture_property = 29, 
		RULE_item_properties_property = 30, RULE_item_location_property = 31, 
		RULE_item_visible_property = 32, RULE_item_readable_property = 33, RULE_item_content_property = 34, 
		RULE_npcs = 35, RULE_npc = 36, RULE_npc_property = 37, RULE_npc_description_property = 38, 
		RULE_npc_texture_property = 39, RULE_npc_location_property = 40, RULE_npc_dialogue_property = 41, 
		RULE_npc_gives_items_property = 42, RULE_npc_requires_items_property = 43, 
		RULE_npc_start_x_property = 44, RULE_npc_start_y_property = 45, RULE_npc_hostile_property = 46, 
		RULE_npc_health_property = 47, RULE_npc_damage_property = 48, RULE_dialogue = 49, 
		RULE_dialogue_property = 50, RULE_dialogue_conditions = 51, RULE_dialogue_condition = 52, 
		RULE_player = 53, RULE_player_property = 54, RULE_player_class_property = 55, 
		RULE_player_start_x_property = 56, RULE_player_start_y_property = 57, 
		RULE_player_health_property = 58, RULE_player_mana_property = 59, RULE_player_stamina_property = 60, 
		RULE_player_speed_property = 61, RULE_player_mana_restore_property = 62, 
		RULE_player_stamina_restore_property = 63, RULE_quizzes = 64, RULE_quiz = 65, 
		RULE_quiz_property = 66, RULE_quiz_type_property = 67, RULE_quiz_question_property = 68, 
		RULE_quiz_answers_property = 69, RULE_quiz_correct_answers_property = 70, 
		RULE_quiz_explanation_property = 71, RULE_quiz_reward_property = 72, RULE_quiz_attached_to_property = 73, 
		RULE_logic = 74, RULE_logic_expr = 75, RULE_logic_term = 76, RULE_dependencies = 77, 
		RULE_dependency = 78, RULE_events = 79, RULE_event = 80, RULE_event_trigger = 81, 
		RULE_action = 82, RULE_action_type = 83, RULE_object = 84, RULE_pair = 85, 
		RULE_array = 86, RULE_value = 87, RULE_multiline_string = 88;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "escape_room", "metadata", "metadata_property", "title_property", 
			"description_property", "difficulty_property", "max_time_property", "fog_of_war_property", 
			"view_distance_property", "camera_zoom_property", "rooms", "room", "room_property", 
			"room_description_property", "room_x_property", "room_y_property", "room_width_property", 
			"room_height_property", "room_pattern_property", "room_items_property", 
			"room_npcs_property", "room_connections_property", "room_locked_by_property", 
			"items", "item", "item_property", "item_description_property", "item_type_property", 
			"item_texture_property", "item_properties_property", "item_location_property", 
			"item_visible_property", "item_readable_property", "item_content_property", 
			"npcs", "npc", "npc_property", "npc_description_property", "npc_texture_property", 
			"npc_location_property", "npc_dialogue_property", "npc_gives_items_property", 
			"npc_requires_items_property", "npc_start_x_property", "npc_start_y_property", 
			"npc_hostile_property", "npc_health_property", "npc_damage_property", 
			"dialogue", "dialogue_property", "dialogue_conditions", "dialogue_condition", 
			"player", "player_property", "player_class_property", "player_start_x_property", 
			"player_start_y_property", "player_health_property", "player_mana_property", 
			"player_stamina_property", "player_speed_property", "player_mana_restore_property", 
			"player_stamina_restore_property", "quizzes", "quiz", "quiz_property", 
			"quiz_type_property", "quiz_question_property", "quiz_answers_property", 
			"quiz_correct_answers_property", "quiz_explanation_property", "quiz_reward_property", 
			"quiz_attached_to_property", "logic", "logic_expr", "logic_term", "dependencies", 
			"dependency", "events", "event", "event_trigger", "action", "action_type", 
			"object", "pair", "array", "value", "multiline_string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'escape_room:'", "'metadata:'", "'title:'", "'description:'", 
			"'difficulty:'", "'max_time:'", "'fog_of_war:'", "'view_distance:'", 
			"'camera_zoom:'", "'rooms:'", "':'", "'x:'", "'y:'", "'width:'", "'height:'", 
			"'pattern:'", "'items:'", "'npcs:'", "'connections:'", "'locked_by:'", 
			"'type:'", "'texture:'", "'properties:'", "'location:'", "'visible:'", 
			"'readable:'", "'content:'", "'dialogue:'", "'gives_items:'", "'requires_items:'", 
			"'start_x:'", "'start_y:'", "'hostile:'", "'health:'", "'damage:'", "'default_text:'", 
			"'default:'", "'conditions:'", "'player:'", "'class:'", "'mana:'", "'stamina:'", 
			"'speed:'", "'mana_restore:'", "'stamina_restore:'", "'quizzes:'", "'question:'", 
			"'answers:'", "'correct_answers:'", "'explanation:'", "'reward:'", "'attached_to:'", 
			"'logic:'", "'win_condition:'", "'dependencies:'", "'state_variables:'", 
			"'timers:'", "'('", "')'", "'events:'", "'actions:'", "'on_puzzle_solved'", 
			"'on_item_collected'", "'on_time_warning'", "'unlock_door'", "'play_sound'", 
			"'show_message'", "'trigger_puzzle'", "'update_state'", "'{'", "'}'", 
			"'['", "','", "']'", null, null, null, null, null, null, null, null, 
			null, null, null, null, "'AND'", "'OR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "QUIZ_TYPE", "DIFFICULTY", "ITEM_TYPE", "PLAYER_CLASS", 
			"BOOLEAN", "ID", "STRING", "MULTILINE_STRING", "FLOAT", "INT", "WS", 
			"COMMENT", "AND", "OR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EscapeRoomDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EscapeRoomDSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public Escape_roomContext escape_room() {
			return getRuleContext(Escape_roomContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EscapeRoomDSLParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			escape_room();
			setState(179);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Escape_roomContext extends ParserRuleContext {
		public MetadataContext metadata() {
			return getRuleContext(MetadataContext.class,0);
		}
		public RoomsContext rooms() {
			return getRuleContext(RoomsContext.class,0);
		}
		public QuizzesContext quizzes() {
			return getRuleContext(QuizzesContext.class,0);
		}
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public NpcsContext npcs() {
			return getRuleContext(NpcsContext.class,0);
		}
		public PlayerContext player() {
			return getRuleContext(PlayerContext.class,0);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public EventsContext events() {
			return getRuleContext(EventsContext.class,0);
		}
		public Escape_roomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape_room; }
	}

	public final Escape_roomContext escape_room() throws RecognitionException {
		Escape_roomContext _localctx = new Escape_roomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_escape_room);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__0);
			setState(182);
			metadata();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(183);
				rooms();
				}
			}

			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(186);
				quizzes();
				}
			}

			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(189);
				items();
				}
			}

			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(192);
				npcs();
				}
			}

			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(195);
				player();
				}
			}

			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__52) {
				{
				setState(198);
				logic();
				}
			}

			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(201);
				events();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MetadataContext extends ParserRuleContext {
		public List<Metadata_propertyContext> metadata_property() {
			return getRuleContexts(Metadata_propertyContext.class);
		}
		public Metadata_propertyContext metadata_property(int i) {
			return getRuleContext(Metadata_propertyContext.class,i);
		}
		public MetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata; }
	}

	public final MetadataContext metadata() throws RecognitionException {
		MetadataContext _localctx = new MetadataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_metadata);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__1);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0)) {
				{
				{
				setState(205);
				metadata_property();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Metadata_propertyContext extends ParserRuleContext {
		public Title_propertyContext title_property() {
			return getRuleContext(Title_propertyContext.class,0);
		}
		public Description_propertyContext description_property() {
			return getRuleContext(Description_propertyContext.class,0);
		}
		public Difficulty_propertyContext difficulty_property() {
			return getRuleContext(Difficulty_propertyContext.class,0);
		}
		public Max_time_propertyContext max_time_property() {
			return getRuleContext(Max_time_propertyContext.class,0);
		}
		public Fog_of_war_propertyContext fog_of_war_property() {
			return getRuleContext(Fog_of_war_propertyContext.class,0);
		}
		public View_distance_propertyContext view_distance_property() {
			return getRuleContext(View_distance_propertyContext.class,0);
		}
		public Camera_zoom_propertyContext camera_zoom_property() {
			return getRuleContext(Camera_zoom_propertyContext.class,0);
		}
		public Metadata_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata_property; }
	}

	public final Metadata_propertyContext metadata_property() throws RecognitionException {
		Metadata_propertyContext _localctx = new Metadata_propertyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_metadata_property);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				title_property();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				description_property();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				difficulty_property();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				max_time_property();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				fog_of_war_property();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
				view_distance_property();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(217);
				camera_zoom_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Title_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Title_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title_property; }
	}

	public final Title_propertyContext title_property() throws RecognitionException {
		Title_propertyContext _localctx = new Title_propertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_title_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__2);
			setState(221);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Description_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Description_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description_property; }
	}

	public final Description_propertyContext description_property() throws RecognitionException {
		Description_propertyContext _localctx = new Description_propertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__3);
			setState(224);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Difficulty_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Difficulty_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difficulty_property; }
	}

	public final Difficulty_propertyContext difficulty_property() throws RecognitionException {
		Difficulty_propertyContext _localctx = new Difficulty_propertyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_difficulty_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__4);
			setState(227);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Max_time_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Max_time_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_time_property; }
	}

	public final Max_time_propertyContext max_time_property() throws RecognitionException {
		Max_time_propertyContext _localctx = new Max_time_propertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_max_time_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__5);
			setState(230);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fog_of_war_propertyContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public Fog_of_war_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fog_of_war_property; }
	}

	public final Fog_of_war_propertyContext fog_of_war_property() throws RecognitionException {
		Fog_of_war_propertyContext _localctx = new Fog_of_war_propertyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fog_of_war_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__6);
			setState(233);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class View_distance_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public View_distance_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_distance_property; }
	}

	public final View_distance_propertyContext view_distance_property() throws RecognitionException {
		View_distance_propertyContext _localctx = new View_distance_propertyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_view_distance_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__7);
			setState(236);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Camera_zoom_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public Camera_zoom_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_camera_zoom_property; }
	}

	public final Camera_zoom_propertyContext camera_zoom_property() throws RecognitionException {
		Camera_zoom_propertyContext _localctx = new Camera_zoom_propertyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_camera_zoom_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__8);
			setState(239);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoomsContext extends ParserRuleContext {
		public List<RoomContext> room() {
			return getRuleContexts(RoomContext.class);
		}
		public RoomContext room(int i) {
			return getRuleContext(RoomContext.class,i);
		}
		public RoomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rooms; }
	}

	public final RoomsContext rooms() throws RecognitionException {
		RoomsContext _localctx = new RoomsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rooms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__9);
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				room();
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public List<Room_propertyContext> room_property() {
			return getRuleContexts(Room_propertyContext.class);
		}
		public Room_propertyContext room_property(int i) {
			return getRuleContext(Room_propertyContext.class,i);
		}
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_room);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(ID);
			setState(248);
			match(T__10);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(249);
					room_property();
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_propertyContext extends ParserRuleContext {
		public Room_description_propertyContext room_description_property() {
			return getRuleContext(Room_description_propertyContext.class,0);
		}
		public Room_x_propertyContext room_x_property() {
			return getRuleContext(Room_x_propertyContext.class,0);
		}
		public Room_y_propertyContext room_y_property() {
			return getRuleContext(Room_y_propertyContext.class,0);
		}
		public Room_width_propertyContext room_width_property() {
			return getRuleContext(Room_width_propertyContext.class,0);
		}
		public Room_height_propertyContext room_height_property() {
			return getRuleContext(Room_height_propertyContext.class,0);
		}
		public Room_pattern_propertyContext room_pattern_property() {
			return getRuleContext(Room_pattern_propertyContext.class,0);
		}
		public Room_items_propertyContext room_items_property() {
			return getRuleContext(Room_items_propertyContext.class,0);
		}
		public Room_npcs_propertyContext room_npcs_property() {
			return getRuleContext(Room_npcs_propertyContext.class,0);
		}
		public Room_connections_propertyContext room_connections_property() {
			return getRuleContext(Room_connections_propertyContext.class,0);
		}
		public Room_locked_by_propertyContext room_locked_by_property() {
			return getRuleContext(Room_locked_by_propertyContext.class,0);
		}
		public Room_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_property; }
	}

	public final Room_propertyContext room_property() throws RecognitionException {
		Room_propertyContext _localctx = new Room_propertyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_room_property);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				room_description_property();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				room_x_property();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				room_y_property();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(258);
				room_width_property();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				room_height_property();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
				room_pattern_property();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				setState(261);
				room_items_property();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 8);
				{
				setState(262);
				room_npcs_property();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 9);
				{
				setState(263);
				room_connections_property();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 10);
				{
				setState(264);
				room_locked_by_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_description_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Room_description_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_description_property; }
	}

	public final Room_description_propertyContext room_description_property() throws RecognitionException {
		Room_description_propertyContext _localctx = new Room_description_propertyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_room_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__3);
			setState(268);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_x_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Room_x_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_x_property; }
	}

	public final Room_x_propertyContext room_x_property() throws RecognitionException {
		Room_x_propertyContext _localctx = new Room_x_propertyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_room_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__11);
			setState(271);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_y_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Room_y_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_y_property; }
	}

	public final Room_y_propertyContext room_y_property() throws RecognitionException {
		Room_y_propertyContext _localctx = new Room_y_propertyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_room_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(T__12);
			setState(274);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_width_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Room_width_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_width_property; }
	}

	public final Room_width_propertyContext room_width_property() throws RecognitionException {
		Room_width_propertyContext _localctx = new Room_width_propertyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_room_width_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__13);
			setState(277);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_height_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Room_height_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_height_property; }
	}

	public final Room_height_propertyContext room_height_property() throws RecognitionException {
		Room_height_propertyContext _localctx = new Room_height_propertyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_room_height_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__14);
			setState(280);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_pattern_propertyContext extends ParserRuleContext {
		public Multiline_stringContext multiline_string() {
			return getRuleContext(Multiline_stringContext.class,0);
		}
		public Room_pattern_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_pattern_property; }
	}

	public final Room_pattern_propertyContext room_pattern_property() throws RecognitionException {
		Room_pattern_propertyContext _localctx = new Room_pattern_propertyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_room_pattern_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__15);
			setState(283);
			multiline_string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_items_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Room_items_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_items_property; }
	}

	public final Room_items_propertyContext room_items_property() throws RecognitionException {
		Room_items_propertyContext _localctx = new Room_items_propertyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_room_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__16);
			setState(286);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_npcs_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Room_npcs_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_npcs_property; }
	}

	public final Room_npcs_propertyContext room_npcs_property() throws RecognitionException {
		Room_npcs_propertyContext _localctx = new Room_npcs_propertyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_room_npcs_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__17);
			setState(289);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_connections_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Room_connections_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_connections_property; }
	}

	public final Room_connections_propertyContext room_connections_property() throws RecognitionException {
		Room_connections_propertyContext _localctx = new Room_connections_propertyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_room_connections_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__18);
			setState(292);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Room_locked_by_propertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Room_locked_by_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_locked_by_property; }
	}

	public final Room_locked_by_propertyContext room_locked_by_property() throws RecognitionException {
		Room_locked_by_propertyContext _localctx = new Room_locked_by_propertyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_room_locked_by_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__19);
			setState(295);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemsContext extends ParserRuleContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public ItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items; }
	}

	public final ItemsContext items() throws RecognitionException {
		ItemsContext _localctx = new ItemsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__16);
			setState(299); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(298);
				item();
				}
				}
				setState(301); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public List<Item_propertyContext> item_property() {
			return getRuleContexts(Item_propertyContext.class);
		}
		public Item_propertyContext item_property(int i) {
			return getRuleContext(Item_propertyContext.class,i);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(ID);
			setState(304);
			match(T__10);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266338320L) != 0)) {
				{
				{
				setState(305);
				item_property();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_propertyContext extends ParserRuleContext {
		public Item_description_propertyContext item_description_property() {
			return getRuleContext(Item_description_propertyContext.class,0);
		}
		public Item_type_propertyContext item_type_property() {
			return getRuleContext(Item_type_propertyContext.class,0);
		}
		public Item_texture_propertyContext item_texture_property() {
			return getRuleContext(Item_texture_propertyContext.class,0);
		}
		public Item_properties_propertyContext item_properties_property() {
			return getRuleContext(Item_properties_propertyContext.class,0);
		}
		public Item_location_propertyContext item_location_property() {
			return getRuleContext(Item_location_propertyContext.class,0);
		}
		public Item_visible_propertyContext item_visible_property() {
			return getRuleContext(Item_visible_propertyContext.class,0);
		}
		public Item_readable_propertyContext item_readable_property() {
			return getRuleContext(Item_readable_propertyContext.class,0);
		}
		public Item_content_propertyContext item_content_property() {
			return getRuleContext(Item_content_propertyContext.class,0);
		}
		public Item_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_property; }
	}

	public final Item_propertyContext item_property() throws RecognitionException {
		Item_propertyContext _localctx = new Item_propertyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_item_property);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				item_description_property();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				item_type_property();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				item_texture_property();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 4);
				{
				setState(314);
				item_properties_property();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 5);
				{
				setState(315);
				item_location_property();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 6);
				{
				setState(316);
				item_visible_property();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 7);
				{
				setState(317);
				item_readable_property();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 8);
				{
				setState(318);
				item_content_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_description_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Item_description_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_description_property; }
	}

	public final Item_description_propertyContext item_description_property() throws RecognitionException {
		Item_description_propertyContext _localctx = new Item_description_propertyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_item_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(T__3);
			setState(322);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_type_propertyContext extends ParserRuleContext {
		public TerminalNode ITEM_TYPE() { return getToken(EscapeRoomDSLParser.ITEM_TYPE, 0); }
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Item_type_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_type_property; }
	}

	public final Item_type_propertyContext item_type_property() throws RecognitionException {
		Item_type_propertyContext _localctx = new Item_type_propertyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_item_type_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__20);
			setState(325);
			_la = _input.LA(1);
			if ( !(_la==ITEM_TYPE || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_texture_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Item_texture_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_texture_property; }
	}

	public final Item_texture_propertyContext item_texture_property() throws RecognitionException {
		Item_texture_propertyContext _localctx = new Item_texture_propertyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_item_texture_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(T__21);
			setState(328);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_properties_propertyContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Item_properties_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_properties_property; }
	}

	public final Item_properties_propertyContext item_properties_property() throws RecognitionException {
		Item_properties_propertyContext _localctx = new Item_properties_propertyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_item_properties_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(T__22);
			setState(331);
			object();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_location_propertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Item_location_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_location_property; }
	}

	public final Item_location_propertyContext item_location_property() throws RecognitionException {
		Item_location_propertyContext _localctx = new Item_location_propertyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_item_location_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(T__23);
			setState(334);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_visible_propertyContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public Item_visible_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_visible_property; }
	}

	public final Item_visible_propertyContext item_visible_property() throws RecognitionException {
		Item_visible_propertyContext _localctx = new Item_visible_propertyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_item_visible_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(T__24);
			setState(337);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_readable_propertyContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public Item_readable_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_readable_property; }
	}

	public final Item_readable_propertyContext item_readable_property() throws RecognitionException {
		Item_readable_propertyContext _localctx = new Item_readable_propertyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_item_readable_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(T__25);
			setState(340);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_content_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Item_content_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_content_property; }
	}

	public final Item_content_propertyContext item_content_property() throws RecognitionException {
		Item_content_propertyContext _localctx = new Item_content_propertyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_item_content_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(T__26);
			setState(343);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NpcsContext extends ParserRuleContext {
		public List<NpcContext> npc() {
			return getRuleContexts(NpcContext.class);
		}
		public NpcContext npc(int i) {
			return getRuleContext(NpcContext.class,i);
		}
		public NpcsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npcs; }
	}

	public final NpcsContext npcs() throws RecognitionException {
		NpcsContext _localctx = new NpcsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_npcs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__17);
			setState(347); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(346);
				npc();
				}
				}
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NpcContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public List<Npc_propertyContext> npc_property() {
			return getRuleContexts(Npc_propertyContext.class);
		}
		public Npc_propertyContext npc_property(int i) {
			return getRuleContext(Npc_propertyContext.class,i);
		}
		public NpcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc; }
	}

	public final NpcContext npc() throws RecognitionException {
		NpcContext _localctx = new NpcContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_npc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(ID);
			setState(352);
			match(T__10);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68472012816L) != 0)) {
				{
				{
				setState(353);
				npc_property();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_propertyContext extends ParserRuleContext {
		public Npc_description_propertyContext npc_description_property() {
			return getRuleContext(Npc_description_propertyContext.class,0);
		}
		public Npc_texture_propertyContext npc_texture_property() {
			return getRuleContext(Npc_texture_propertyContext.class,0);
		}
		public Npc_location_propertyContext npc_location_property() {
			return getRuleContext(Npc_location_propertyContext.class,0);
		}
		public Npc_dialogue_propertyContext npc_dialogue_property() {
			return getRuleContext(Npc_dialogue_propertyContext.class,0);
		}
		public Npc_gives_items_propertyContext npc_gives_items_property() {
			return getRuleContext(Npc_gives_items_propertyContext.class,0);
		}
		public Npc_requires_items_propertyContext npc_requires_items_property() {
			return getRuleContext(Npc_requires_items_propertyContext.class,0);
		}
		public Npc_start_x_propertyContext npc_start_x_property() {
			return getRuleContext(Npc_start_x_propertyContext.class,0);
		}
		public Npc_start_y_propertyContext npc_start_y_property() {
			return getRuleContext(Npc_start_y_propertyContext.class,0);
		}
		public Npc_hostile_propertyContext npc_hostile_property() {
			return getRuleContext(Npc_hostile_propertyContext.class,0);
		}
		public Npc_health_propertyContext npc_health_property() {
			return getRuleContext(Npc_health_propertyContext.class,0);
		}
		public Npc_damage_propertyContext npc_damage_property() {
			return getRuleContext(Npc_damage_propertyContext.class,0);
		}
		public Npc_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_property; }
	}

	public final Npc_propertyContext npc_property() throws RecognitionException {
		Npc_propertyContext _localctx = new Npc_propertyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_npc_property);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				npc_description_property();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				npc_texture_property();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				npc_location_property();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				npc_dialogue_property();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 5);
				{
				setState(363);
				npc_gives_items_property();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 6);
				{
				setState(364);
				npc_requires_items_property();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 7);
				{
				setState(365);
				npc_start_x_property();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 8);
				{
				setState(366);
				npc_start_y_property();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 9);
				{
				setState(367);
				npc_hostile_property();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 10);
				{
				setState(368);
				npc_health_property();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 11);
				{
				setState(369);
				npc_damage_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_description_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Npc_description_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_description_property; }
	}

	public final Npc_description_propertyContext npc_description_property() throws RecognitionException {
		Npc_description_propertyContext _localctx = new Npc_description_propertyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_npc_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__3);
			setState(373);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_texture_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Npc_texture_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_texture_property; }
	}

	public final Npc_texture_propertyContext npc_texture_property() throws RecognitionException {
		Npc_texture_propertyContext _localctx = new Npc_texture_propertyContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_npc_texture_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(T__21);
			setState(376);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_location_propertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Npc_location_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_location_property; }
	}

	public final Npc_location_propertyContext npc_location_property() throws RecognitionException {
		Npc_location_propertyContext _localctx = new Npc_location_propertyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_npc_location_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(T__23);
			setState(379);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_dialogue_propertyContext extends ParserRuleContext {
		public DialogueContext dialogue() {
			return getRuleContext(DialogueContext.class,0);
		}
		public Npc_dialogue_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_dialogue_property; }
	}

	public final Npc_dialogue_propertyContext npc_dialogue_property() throws RecognitionException {
		Npc_dialogue_propertyContext _localctx = new Npc_dialogue_propertyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_npc_dialogue_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__27);
			setState(382);
			dialogue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_gives_items_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Npc_gives_items_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_gives_items_property; }
	}

	public final Npc_gives_items_propertyContext npc_gives_items_property() throws RecognitionException {
		Npc_gives_items_propertyContext _localctx = new Npc_gives_items_propertyContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_npc_gives_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(T__28);
			setState(385);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_requires_items_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Npc_requires_items_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_requires_items_property; }
	}

	public final Npc_requires_items_propertyContext npc_requires_items_property() throws RecognitionException {
		Npc_requires_items_propertyContext _localctx = new Npc_requires_items_propertyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_npc_requires_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__29);
			setState(388);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_start_x_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Npc_start_x_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_start_x_property; }
	}

	public final Npc_start_x_propertyContext npc_start_x_property() throws RecognitionException {
		Npc_start_x_propertyContext _localctx = new Npc_start_x_propertyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_npc_start_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__30);
			setState(391);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_start_y_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Npc_start_y_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_start_y_property; }
	}

	public final Npc_start_y_propertyContext npc_start_y_property() throws RecognitionException {
		Npc_start_y_propertyContext _localctx = new Npc_start_y_propertyContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_npc_start_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(T__31);
			setState(394);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_hostile_propertyContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public Npc_hostile_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_hostile_property; }
	}

	public final Npc_hostile_propertyContext npc_hostile_property() throws RecognitionException {
		Npc_hostile_propertyContext _localctx = new Npc_hostile_propertyContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_npc_hostile_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(T__32);
			setState(397);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_health_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Npc_health_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_health_property; }
	}

	public final Npc_health_propertyContext npc_health_property() throws RecognitionException {
		Npc_health_propertyContext _localctx = new Npc_health_propertyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_npc_health_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(T__33);
			setState(400);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Npc_damage_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Npc_damage_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_damage_property; }
	}

	public final Npc_damage_propertyContext npc_damage_property() throws RecognitionException {
		Npc_damage_propertyContext _localctx = new Npc_damage_propertyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_npc_damage_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(T__34);
			setState(403);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DialogueContext extends ParserRuleContext {
		public List<Dialogue_propertyContext> dialogue_property() {
			return getRuleContexts(Dialogue_propertyContext.class);
		}
		public Dialogue_propertyContext dialogue_property(int i) {
			return getRuleContext(Dialogue_propertyContext.class,i);
		}
		public DialogueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dialogue; }
	}

	public final DialogueContext dialogue() throws RecognitionException {
		DialogueContext _localctx = new DialogueContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_dialogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(405);
				dialogue_property();
				}
				}
				setState(408); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dialogue_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Dialogue_conditionsContext dialogue_conditions() {
			return getRuleContext(Dialogue_conditionsContext.class,0);
		}
		public Dialogue_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dialogue_property; }
	}

	public final Dialogue_propertyContext dialogue_property() throws RecognitionException {
		Dialogue_propertyContext _localctx = new Dialogue_propertyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_dialogue_property);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(T__35);
				setState(411);
				match(STRING);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(T__36);
				setState(413);
				match(STRING);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				match(T__37);
				setState(415);
				dialogue_conditions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dialogue_conditionsContext extends ParserRuleContext {
		public List<Dialogue_conditionContext> dialogue_condition() {
			return getRuleContexts(Dialogue_conditionContext.class);
		}
		public Dialogue_conditionContext dialogue_condition(int i) {
			return getRuleContext(Dialogue_conditionContext.class,i);
		}
		public Dialogue_conditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dialogue_conditions; }
	}

	public final Dialogue_conditionsContext dialogue_conditions() throws RecognitionException {
		Dialogue_conditionsContext _localctx = new Dialogue_conditionsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_dialogue_conditions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(418);
					dialogue_condition();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(421); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dialogue_conditionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Dialogue_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dialogue_condition; }
	}

	public final Dialogue_conditionContext dialogue_condition() throws RecognitionException {
		Dialogue_conditionContext _localctx = new Dialogue_conditionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_dialogue_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(ID);
			setState(424);
			match(T__10);
			setState(425);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlayerContext extends ParserRuleContext {
		public List<Player_propertyContext> player_property() {
			return getRuleContexts(Player_propertyContext.class);
		}
		public Player_propertyContext player_property(int i) {
			return getRuleContext(Player_propertyContext.class,i);
		}
		public PlayerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player; }
	}

	public final PlayerContext player() throws RecognitionException {
		PlayerContext _localctx = new PlayerContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_player);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(T__38);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69292854870016L) != 0)) {
				{
				{
				setState(428);
				player_property();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_propertyContext extends ParserRuleContext {
		public Player_class_propertyContext player_class_property() {
			return getRuleContext(Player_class_propertyContext.class,0);
		}
		public Player_start_x_propertyContext player_start_x_property() {
			return getRuleContext(Player_start_x_propertyContext.class,0);
		}
		public Player_start_y_propertyContext player_start_y_property() {
			return getRuleContext(Player_start_y_propertyContext.class,0);
		}
		public Player_health_propertyContext player_health_property() {
			return getRuleContext(Player_health_propertyContext.class,0);
		}
		public Player_mana_propertyContext player_mana_property() {
			return getRuleContext(Player_mana_propertyContext.class,0);
		}
		public Player_stamina_propertyContext player_stamina_property() {
			return getRuleContext(Player_stamina_propertyContext.class,0);
		}
		public Player_speed_propertyContext player_speed_property() {
			return getRuleContext(Player_speed_propertyContext.class,0);
		}
		public Player_mana_restore_propertyContext player_mana_restore_property() {
			return getRuleContext(Player_mana_restore_propertyContext.class,0);
		}
		public Player_stamina_restore_propertyContext player_stamina_restore_property() {
			return getRuleContext(Player_stamina_restore_propertyContext.class,0);
		}
		public Player_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_property; }
	}

	public final Player_propertyContext player_property() throws RecognitionException {
		Player_propertyContext _localctx = new Player_propertyContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_player_property);
		try {
			setState(443);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				player_class_property();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				player_start_x_property();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				player_start_y_property();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				player_health_property();
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				player_mana_property();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 6);
				{
				setState(439);
				player_stamina_property();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 7);
				{
				setState(440);
				player_speed_property();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 8);
				{
				setState(441);
				player_mana_restore_property();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 9);
				{
				setState(442);
				player_stamina_restore_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_class_propertyContext extends ParserRuleContext {
		public TerminalNode PLAYER_CLASS() { return getToken(EscapeRoomDSLParser.PLAYER_CLASS, 0); }
		public Player_class_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_class_property; }
	}

	public final Player_class_propertyContext player_class_property() throws RecognitionException {
		Player_class_propertyContext _localctx = new Player_class_propertyContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_player_class_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(T__39);
			setState(446);
			match(PLAYER_CLASS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_start_x_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_start_x_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_start_x_property; }
	}

	public final Player_start_x_propertyContext player_start_x_property() throws RecognitionException {
		Player_start_x_propertyContext _localctx = new Player_start_x_propertyContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_player_start_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(T__30);
			setState(449);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_start_y_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_start_y_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_start_y_property; }
	}

	public final Player_start_y_propertyContext player_start_y_property() throws RecognitionException {
		Player_start_y_propertyContext _localctx = new Player_start_y_propertyContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_player_start_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(T__31);
			setState(452);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_health_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_health_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_health_property; }
	}

	public final Player_health_propertyContext player_health_property() throws RecognitionException {
		Player_health_propertyContext _localctx = new Player_health_propertyContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_player_health_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(T__33);
			setState(455);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_mana_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_mana_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_mana_property; }
	}

	public final Player_mana_propertyContext player_mana_property() throws RecognitionException {
		Player_mana_propertyContext _localctx = new Player_mana_propertyContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_player_mana_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(T__40);
			setState(458);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_stamina_propertyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_stamina_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_stamina_property; }
	}

	public final Player_stamina_propertyContext player_stamina_property() throws RecognitionException {
		Player_stamina_propertyContext _localctx = new Player_stamina_propertyContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_player_stamina_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(T__41);
			setState(461);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_speed_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public Player_speed_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_speed_property; }
	}

	public final Player_speed_propertyContext player_speed_property() throws RecognitionException {
		Player_speed_propertyContext _localctx = new Player_speed_propertyContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_player_speed_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__42);
			setState(464);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_mana_restore_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public Player_mana_restore_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_mana_restore_property; }
	}

	public final Player_mana_restore_propertyContext player_mana_restore_property() throws RecognitionException {
		Player_mana_restore_propertyContext _localctx = new Player_mana_restore_propertyContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_player_mana_restore_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(T__43);
			setState(467);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Player_stamina_restore_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public Player_stamina_restore_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_stamina_restore_property; }
	}

	public final Player_stamina_restore_propertyContext player_stamina_restore_property() throws RecognitionException {
		Player_stamina_restore_propertyContext _localctx = new Player_stamina_restore_propertyContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_player_stamina_restore_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(T__44);
			setState(470);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuizzesContext extends ParserRuleContext {
		public List<QuizContext> quiz() {
			return getRuleContexts(QuizContext.class);
		}
		public QuizContext quiz(int i) {
			return getRuleContext(QuizContext.class,i);
		}
		public QuizzesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quizzes; }
	}

	public final QuizzesContext quizzes() throws RecognitionException {
		QuizzesContext _localctx = new QuizzesContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_quizzes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(T__45);
			setState(474); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(473);
				quiz();
				}
				}
				setState(476); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuizContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public List<Quiz_propertyContext> quiz_property() {
			return getRuleContexts(Quiz_propertyContext.class);
		}
		public Quiz_propertyContext quiz_property(int i) {
			return getRuleContext(Quiz_propertyContext.class,i);
		}
		public QuizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz; }
	}

	public final QuizContext quiz() throws RecognitionException {
		QuizContext _localctx = new QuizContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_quiz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(ID);
			setState(479);
			match(T__10);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866461768482816L) != 0)) {
				{
				{
				setState(480);
				quiz_property();
				}
				}
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_propertyContext extends ParserRuleContext {
		public Quiz_type_propertyContext quiz_type_property() {
			return getRuleContext(Quiz_type_propertyContext.class,0);
		}
		public Quiz_question_propertyContext quiz_question_property() {
			return getRuleContext(Quiz_question_propertyContext.class,0);
		}
		public Quiz_answers_propertyContext quiz_answers_property() {
			return getRuleContext(Quiz_answers_propertyContext.class,0);
		}
		public Quiz_correct_answers_propertyContext quiz_correct_answers_property() {
			return getRuleContext(Quiz_correct_answers_propertyContext.class,0);
		}
		public Quiz_explanation_propertyContext quiz_explanation_property() {
			return getRuleContext(Quiz_explanation_propertyContext.class,0);
		}
		public Quiz_reward_propertyContext quiz_reward_property() {
			return getRuleContext(Quiz_reward_propertyContext.class,0);
		}
		public Quiz_attached_to_propertyContext quiz_attached_to_property() {
			return getRuleContext(Quiz_attached_to_propertyContext.class,0);
		}
		public Quiz_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_property; }
	}

	public final Quiz_propertyContext quiz_property() throws RecognitionException {
		Quiz_propertyContext _localctx = new Quiz_propertyContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_quiz_property);
		try {
			setState(493);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				quiz_type_property();
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				quiz_question_property();
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
				setState(488);
				quiz_answers_property();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 4);
				{
				setState(489);
				quiz_correct_answers_property();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 5);
				{
				setState(490);
				quiz_explanation_property();
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 6);
				{
				setState(491);
				quiz_reward_property();
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 7);
				{
				setState(492);
				quiz_attached_to_property();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_type_propertyContext extends ParserRuleContext {
		public TerminalNode QUIZ_TYPE() { return getToken(EscapeRoomDSLParser.QUIZ_TYPE, 0); }
		public Quiz_type_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_type_property; }
	}

	public final Quiz_type_propertyContext quiz_type_property() throws RecognitionException {
		Quiz_type_propertyContext _localctx = new Quiz_type_propertyContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_quiz_type_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(T__20);
			setState(496);
			match(QUIZ_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_question_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Quiz_question_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_question_property; }
	}

	public final Quiz_question_propertyContext quiz_question_property() throws RecognitionException {
		Quiz_question_propertyContext _localctx = new Quiz_question_propertyContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_quiz_question_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(T__46);
			setState(499);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_answers_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Quiz_answers_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_answers_property; }
	}

	public final Quiz_answers_propertyContext quiz_answers_property() throws RecognitionException {
		Quiz_answers_propertyContext _localctx = new Quiz_answers_propertyContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_quiz_answers_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__47);
			setState(502);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_correct_answers_propertyContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Quiz_correct_answers_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_correct_answers_property; }
	}

	public final Quiz_correct_answers_propertyContext quiz_correct_answers_property() throws RecognitionException {
		Quiz_correct_answers_propertyContext _localctx = new Quiz_correct_answers_propertyContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_quiz_correct_answers_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(T__48);
			setState(505);
			array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_explanation_propertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Quiz_explanation_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_explanation_property; }
	}

	public final Quiz_explanation_propertyContext quiz_explanation_property() throws RecognitionException {
		Quiz_explanation_propertyContext _localctx = new Quiz_explanation_propertyContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_quiz_explanation_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__49);
			setState(508);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_reward_propertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Quiz_reward_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_reward_property; }
	}

	public final Quiz_reward_propertyContext quiz_reward_property() throws RecognitionException {
		Quiz_reward_propertyContext _localctx = new Quiz_reward_propertyContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_quiz_reward_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(T__50);
			setState(511);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quiz_attached_to_propertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Quiz_attached_to_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_attached_to_property; }
	}

	public final Quiz_attached_to_propertyContext quiz_attached_to_property() throws RecognitionException {
		Quiz_attached_to_propertyContext _localctx = new Quiz_attached_to_propertyContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_quiz_attached_to_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__51);
			setState(514);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicContext extends ParserRuleContext {
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public DependenciesContext dependencies() {
			return getRuleContext(DependenciesContext.class,0);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(T__52);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(517);
				match(T__53);
				setState(518);
				logic_expr();
				}
			}

			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__54) {
				{
				setState(521);
				match(T__54);
				setState(522);
				dependencies();
				}
			}

			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__55) {
				{
				setState(525);
				match(T__55);
				setState(526);
				object();
				}
			}

			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__56) {
				{
				setState(529);
				match(T__56);
				setState(530);
				object();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_exprContext extends ParserRuleContext {
		public List<Logic_termContext> logic_term() {
			return getRuleContexts(Logic_termContext.class);
		}
		public Logic_termContext logic_term(int i) {
			return getRuleContext(Logic_termContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(EscapeRoomDSLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(EscapeRoomDSLParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(EscapeRoomDSLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(EscapeRoomDSLParser.OR, i);
		}
		public Logic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expr; }
	}

	public final Logic_exprContext logic_expr() throws RecognitionException {
		Logic_exprContext _localctx = new Logic_exprContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_logic_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			logic_term();
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(534);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(535);
				logic_term();
				}
				}
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_termContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public Logic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_term; }
	}

	public final Logic_termContext logic_term() throws RecognitionException {
		Logic_termContext _localctx = new Logic_termContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_logic_term);
		try {
			setState(546);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(541);
				match(ID);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 2);
				{
				setState(542);
				match(T__57);
				setState(543);
				logic_expr();
				setState(544);
				match(T__58);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DependenciesContext extends ParserRuleContext {
		public List<DependencyContext> dependency() {
			return getRuleContexts(DependencyContext.class);
		}
		public DependencyContext dependency(int i) {
			return getRuleContext(DependencyContext.class,i);
		}
		public DependenciesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencies; }
	}

	public final DependenciesContext dependencies() throws RecognitionException {
		DependenciesContext _localctx = new DependenciesContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_dependencies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(548);
				dependency();
				}
				}
				setState(551); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DependencyContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EscapeRoomDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EscapeRoomDSLParser.ID, i);
		}
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(ID);
			setState(554);
			match(T__10);
			setState(555);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventsContext extends ParserRuleContext {
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public EventsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_events; }
	}

	public final EventsContext events() throws RecognitionException {
		EventsContext _localctx = new EventsContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_events);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(T__59);
			setState(559); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(558);
				event();
				}
				}
				setState(561); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 7L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventContext extends ParserRuleContext {
		public Event_triggerContext event_trigger() {
			return getRuleContext(Event_triggerContext.class,0);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_event);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			event_trigger();
			setState(564);
			match(T__10);
			setState(565);
			match(T__60);
			setState(567); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(566);
				action();
				}
				}
				setState(569); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 31L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Event_triggerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_trigger; }
	}

	public final Event_triggerContext event_trigger() throws RecognitionException {
		Event_triggerContext _localctx = new Event_triggerContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_event_trigger);
		try {
			setState(580);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__61:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				match(T__61);
				setState(572);
				match(T__10);
				setState(573);
				match(ID);
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 2);
				{
				setState(574);
				match(T__62);
				setState(575);
				match(T__10);
				setState(576);
				match(ID);
				}
				break;
			case T__63:
				enterOuterAlt(_localctx, 3);
				{
				setState(577);
				match(T__63);
				setState(578);
				match(T__10);
				setState(579);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public Action_typeContext action_type() {
			return getRuleContext(Action_typeContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			action_type();
			setState(583);
			match(T__10);
			setState(584);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Action_typeContext extends ParserRuleContext {
		public Action_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_type; }
	}

	public final Action_typeContext action_type() throws RecognitionException {
		Action_typeContext _localctx = new Action_typeContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_action_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectContext extends ParserRuleContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(T__69);
			setState(590); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(589);
				pair();
				}
				}
				setState(592); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(594);
			match(T__70);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(ID);
			setState(597);
			match(T__10);
			setState(598);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(T__71);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 28389L) != 0)) {
				{
				setState(601);
				value();
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__72) {
					{
					{
					setState(602);
					match(T__72);
					setState(603);
					value();
					}
					}
					setState(608);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(611);
			match(T__73);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public TerminalNode ITEM_TYPE() { return getToken(EscapeRoomDSLParser.ITEM_TYPE, 0); }
		public TerminalNode QUIZ_TYPE() { return getToken(EscapeRoomDSLParser.QUIZ_TYPE, 0); }
		public TerminalNode DIFFICULTY() { return getToken(EscapeRoomDSLParser.DIFFICULTY, 0); }
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_value);
		try {
			setState(623);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(614);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(615);
				match(INT);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(616);
				match(BOOLEAN);
				}
				break;
			case ITEM_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(617);
				match(ITEM_TYPE);
				}
				break;
			case QUIZ_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(618);
				match(QUIZ_TYPE);
				}
				break;
			case DIFFICULTY:
				enterOuterAlt(_localctx, 7);
				{
				setState(619);
				match(DIFFICULTY);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(620);
				match(ID);
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 9);
				{
				setState(621);
				array();
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 10);
				{
				setState(622);
				object();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiline_stringContext extends ParserRuleContext {
		public TerminalNode MULTILINE_STRING() { return getToken(EscapeRoomDSLParser.MULTILINE_STRING, 0); }
		public Multiline_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline_string; }
	}

	public final Multiline_stringContext multiline_string() throws RecognitionException {
		Multiline_stringContext _localctx = new Multiline_stringContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_multiline_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(MULTILINE_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001X\u0274\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b9\b\u0001"+
		"\u0001\u0001\u0003\u0001\u00bc\b\u0001\u0001\u0001\u0003\u0001\u00bf\b"+
		"\u0001\u0001\u0001\u0003\u0001\u00c2\b\u0001\u0001\u0001\u0003\u0001\u00c5"+
		"\b\u0001\u0001\u0001\u0003\u0001\u00c8\b\u0001\u0001\u0001\u0003\u0001"+
		"\u00cb\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002\u00cf\b\u0002\n\u0002"+
		"\f\u0002\u00d2\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00db\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0004\u000b\u00f4\b\u000b\u000b\u000b\f\u000b\u00f5\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00fb\b\f\n\f\f\f\u00fe\t\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u010a\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0004\u0018\u012c\b\u0018\u000b\u0018"+
		"\f\u0018\u012d\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0133\b"+
		"\u0019\n\u0019\f\u0019\u0136\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0140\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 "+
		"\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0004#\u015c"+
		"\b#\u000b#\f#\u015d\u0001$\u0001$\u0001$\u0005$\u0163\b$\n$\f$\u0166\t"+
		"$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u0173\b%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001.\u0001"+
		".\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00010\u00011\u00041\u0197"+
		"\b1\u000b1\f1\u0198\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u01a1"+
		"\b2\u00013\u00043\u01a4\b3\u000b3\f3\u01a5\u00014\u00014\u00014\u0001"+
		"4\u00015\u00015\u00055\u01ae\b5\n5\f5\u01b1\t5\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00036\u01bc\b6\u00017\u00017\u0001"+
		"7\u00018\u00018\u00018\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		";\u0001;\u0001;\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001>\u0001"+
		">\u0001>\u0001?\u0001?\u0001?\u0001@\u0001@\u0004@\u01db\b@\u000b@\f@"+
		"\u01dc\u0001A\u0001A\u0001A\u0005A\u01e2\bA\nA\fA\u01e5\tA\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0003B\u01ee\bB\u0001C\u0001C\u0001"+
		"C\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001"+
		"G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001J\u0001"+
		"J\u0001J\u0003J\u0208\bJ\u0001J\u0001J\u0003J\u020c\bJ\u0001J\u0001J\u0003"+
		"J\u0210\bJ\u0001J\u0001J\u0003J\u0214\bJ\u0001K\u0001K\u0001K\u0005K\u0219"+
		"\bK\nK\fK\u021c\tK\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u0223\bL"+
		"\u0001M\u0004M\u0226\bM\u000bM\fM\u0227\u0001N\u0001N\u0001N\u0001N\u0001"+
		"O\u0001O\u0004O\u0230\bO\u000bO\fO\u0231\u0001P\u0001P\u0001P\u0001P\u0004"+
		"P\u0238\bP\u000bP\fP\u0239\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0003Q\u0245\bQ\u0001R\u0001R\u0001R\u0001R\u0001S\u0001"+
		"S\u0001T\u0001T\u0004T\u024f\bT\u000bT\fT\u0250\u0001T\u0001T\u0001U\u0001"+
		"U\u0001U\u0001U\u0001V\u0001V\u0001V\u0001V\u0005V\u025d\bV\nV\fV\u0260"+
		"\tV\u0003V\u0262\bV\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0001W\u0003W\u0270\bW\u0001X\u0001X\u0001X\u0000"+
		"\u0000Y\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u0000\u0003\u0002\u0000MMQQ\u0001\u0000WX\u0001\u0000AE\u0274\u0000\u00b2"+
		"\u0001\u0000\u0000\u0000\u0002\u00b5\u0001\u0000\u0000\u0000\u0004\u00cc"+
		"\u0001\u0000\u0000\u0000\u0006\u00da\u0001\u0000\u0000\u0000\b\u00dc\u0001"+
		"\u0000\u0000\u0000\n\u00df\u0001\u0000\u0000\u0000\f\u00e2\u0001\u0000"+
		"\u0000\u0000\u000e\u00e5\u0001\u0000\u0000\u0000\u0010\u00e8\u0001\u0000"+
		"\u0000\u0000\u0012\u00eb\u0001\u0000\u0000\u0000\u0014\u00ee\u0001\u0000"+
		"\u0000\u0000\u0016\u00f1\u0001\u0000\u0000\u0000\u0018\u00f7\u0001\u0000"+
		"\u0000\u0000\u001a\u0109\u0001\u0000\u0000\u0000\u001c\u010b\u0001\u0000"+
		"\u0000\u0000\u001e\u010e\u0001\u0000\u0000\u0000 \u0111\u0001\u0000\u0000"+
		"\u0000\"\u0114\u0001\u0000\u0000\u0000$\u0117\u0001\u0000\u0000\u0000"+
		"&\u011a\u0001\u0000\u0000\u0000(\u011d\u0001\u0000\u0000\u0000*\u0120"+
		"\u0001\u0000\u0000\u0000,\u0123\u0001\u0000\u0000\u0000.\u0126\u0001\u0000"+
		"\u0000\u00000\u0129\u0001\u0000\u0000\u00002\u012f\u0001\u0000\u0000\u0000"+
		"4\u013f\u0001\u0000\u0000\u00006\u0141\u0001\u0000\u0000\u00008\u0144"+
		"\u0001\u0000\u0000\u0000:\u0147\u0001\u0000\u0000\u0000<\u014a\u0001\u0000"+
		"\u0000\u0000>\u014d\u0001\u0000\u0000\u0000@\u0150\u0001\u0000\u0000\u0000"+
		"B\u0153\u0001\u0000\u0000\u0000D\u0156\u0001\u0000\u0000\u0000F\u0159"+
		"\u0001\u0000\u0000\u0000H\u015f\u0001\u0000\u0000\u0000J\u0172\u0001\u0000"+
		"\u0000\u0000L\u0174\u0001\u0000\u0000\u0000N\u0177\u0001\u0000\u0000\u0000"+
		"P\u017a\u0001\u0000\u0000\u0000R\u017d\u0001\u0000\u0000\u0000T\u0180"+
		"\u0001\u0000\u0000\u0000V\u0183\u0001\u0000\u0000\u0000X\u0186\u0001\u0000"+
		"\u0000\u0000Z\u0189\u0001\u0000\u0000\u0000\\\u018c\u0001\u0000\u0000"+
		"\u0000^\u018f\u0001\u0000\u0000\u0000`\u0192\u0001\u0000\u0000\u0000b"+
		"\u0196\u0001\u0000\u0000\u0000d\u01a0\u0001\u0000\u0000\u0000f\u01a3\u0001"+
		"\u0000\u0000\u0000h\u01a7\u0001\u0000\u0000\u0000j\u01ab\u0001\u0000\u0000"+
		"\u0000l\u01bb\u0001\u0000\u0000\u0000n\u01bd\u0001\u0000\u0000\u0000p"+
		"\u01c0\u0001\u0000\u0000\u0000r\u01c3\u0001\u0000\u0000\u0000t\u01c6\u0001"+
		"\u0000\u0000\u0000v\u01c9\u0001\u0000\u0000\u0000x\u01cc\u0001\u0000\u0000"+
		"\u0000z\u01cf\u0001\u0000\u0000\u0000|\u01d2\u0001\u0000\u0000\u0000~"+
		"\u01d5\u0001\u0000\u0000\u0000\u0080\u01d8\u0001\u0000\u0000\u0000\u0082"+
		"\u01de\u0001\u0000\u0000\u0000\u0084\u01ed\u0001\u0000\u0000\u0000\u0086"+
		"\u01ef\u0001\u0000\u0000\u0000\u0088\u01f2\u0001\u0000\u0000\u0000\u008a"+
		"\u01f5\u0001\u0000\u0000\u0000\u008c\u01f8\u0001\u0000\u0000\u0000\u008e"+
		"\u01fb\u0001\u0000\u0000\u0000\u0090\u01fe\u0001\u0000\u0000\u0000\u0092"+
		"\u0201\u0001\u0000\u0000\u0000\u0094\u0204\u0001\u0000\u0000\u0000\u0096"+
		"\u0215\u0001\u0000\u0000\u0000\u0098\u0222\u0001\u0000\u0000\u0000\u009a"+
		"\u0225\u0001\u0000\u0000\u0000\u009c\u0229\u0001\u0000\u0000\u0000\u009e"+
		"\u022d\u0001\u0000\u0000\u0000\u00a0\u0233\u0001\u0000\u0000\u0000\u00a2"+
		"\u0244\u0001\u0000\u0000\u0000\u00a4\u0246\u0001\u0000\u0000\u0000\u00a6"+
		"\u024a\u0001\u0000\u0000\u0000\u00a8\u024c\u0001\u0000\u0000\u0000\u00aa"+
		"\u0254\u0001\u0000\u0000\u0000\u00ac\u0258\u0001\u0000\u0000\u0000\u00ae"+
		"\u026f\u0001\u0000\u0000\u0000\u00b0\u0271\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0003\u0002\u0001\u0000\u00b3\u00b4\u0005\u0000\u0000\u0001\u00b4"+
		"\u0001\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0001\u0000\u0000\u00b6"+
		"\u00b8\u0003\u0004\u0002\u0000\u00b7\u00b9\u0003\u0016\u000b\u0000\u00b8"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bb\u0001\u0000\u0000\u0000\u00ba\u00bc\u0003\u0080@\u0000\u00bb\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bf\u00030\u0018\u0000\u00be\u00bd\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c2\u0003F#\u0000\u00c1\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c5\u0003j5\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c8\u0003\u0094J\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00cb"+
		"\u0003\u009eO\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u0003\u0001\u0000\u0000\u0000\u00cc\u00d0\u0005"+
		"\u0002\u0000\u0000\u00cd\u00cf\u0003\u0006\u0003\u0000\u00ce\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u0005\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00db\u0003"+
		"\b\u0004\u0000\u00d4\u00db\u0003\n\u0005\u0000\u00d5\u00db\u0003\f\u0006"+
		"\u0000\u00d6\u00db\u0003\u000e\u0007\u0000\u00d7\u00db\u0003\u0010\b\u0000"+
		"\u00d8\u00db\u0003\u0012\t\u0000\u00d9\u00db\u0003\u0014\n\u0000\u00da"+
		"\u00d3\u0001\u0000\u0000\u0000\u00da\u00d4\u0001\u0000\u0000\u0000\u00da"+
		"\u00d5\u0001\u0000\u0000\u0000\u00da\u00d6\u0001\u0000\u0000\u0000\u00da"+
		"\u00d7\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u0007\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0003\u0000\u0000\u00dd\u00de\u0005Q\u0000\u0000\u00de\t"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0004\u0000\u0000\u00e0\u00e1"+
		"\u0005Q\u0000\u0000\u00e1\u000b\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0005\u0000\u0000\u00e3\u00e4\u0005Q\u0000\u0000\u00e4\r\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0005\u0006\u0000\u0000\u00e6\u00e7\u0005T\u0000"+
		"\u0000\u00e7\u000f\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005\u0007\u0000"+
		"\u0000\u00e9\u00ea\u0005O\u0000\u0000\u00ea\u0011\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0005\b\u0000\u0000\u00ec\u00ed\u0005T\u0000\u0000\u00ed"+
		"\u0013\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\t\u0000\u0000\u00ef\u00f0"+
		"\u0005S\u0000\u0000\u00f0\u0015\u0001\u0000\u0000\u0000\u00f1\u00f3\u0005"+
		"\n\u0000\u0000\u00f2\u00f4\u0003\u0018\f\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u0017\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0005P\u0000\u0000\u00f8\u00fc\u0005\u000b\u0000"+
		"\u0000\u00f9\u00fb\u0003\u001a\r\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0019\u0001\u0000\u0000\u0000"+
		"\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u010a\u0003\u001c\u000e\u0000"+
		"\u0100\u010a\u0003\u001e\u000f\u0000\u0101\u010a\u0003 \u0010\u0000\u0102"+
		"\u010a\u0003\"\u0011\u0000\u0103\u010a\u0003$\u0012\u0000\u0104\u010a"+
		"\u0003&\u0013\u0000\u0105\u010a\u0003(\u0014\u0000\u0106\u010a\u0003*"+
		"\u0015\u0000\u0107\u010a\u0003,\u0016\u0000\u0108\u010a\u0003.\u0017\u0000"+
		"\u0109\u00ff\u0001\u0000\u0000\u0000\u0109\u0100\u0001\u0000\u0000\u0000"+
		"\u0109\u0101\u0001\u0000\u0000\u0000\u0109\u0102\u0001\u0000\u0000\u0000"+
		"\u0109\u0103\u0001\u0000\u0000\u0000\u0109\u0104\u0001\u0000\u0000\u0000"+
		"\u0109\u0105\u0001\u0000\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000"+
		"\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000"+
		"\u010a\u001b\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u0004\u0000\u0000"+
		"\u010c\u010d\u0005Q\u0000\u0000\u010d\u001d\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0005\f\u0000\u0000\u010f\u0110\u0005T\u0000\u0000\u0110\u001f"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0005\r\u0000\u0000\u0112\u0113\u0005"+
		"T\u0000\u0000\u0113!\u0001\u0000\u0000\u0000\u0114\u0115\u0005\u000e\u0000"+
		"\u0000\u0115\u0116\u0005T\u0000\u0000\u0116#\u0001\u0000\u0000\u0000\u0117"+
		"\u0118\u0005\u000f\u0000\u0000\u0118\u0119\u0005T\u0000\u0000\u0119%\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0005\u0010\u0000\u0000\u011b\u011c\u0003"+
		"\u00b0X\u0000\u011c\'\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u0011"+
		"\u0000\u0000\u011e\u011f\u0003\u00acV\u0000\u011f)\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0005\u0012\u0000\u0000\u0121\u0122\u0003\u00acV\u0000\u0122"+
		"+\u0001\u0000\u0000\u0000\u0123\u0124\u0005\u0013\u0000\u0000\u0124\u0125"+
		"\u0003\u00acV\u0000\u0125-\u0001\u0000\u0000\u0000\u0126\u0127\u0005\u0014"+
		"\u0000\u0000\u0127\u0128\u0005P\u0000\u0000\u0128/\u0001\u0000\u0000\u0000"+
		"\u0129\u012b\u0005\u0011\u0000\u0000\u012a\u012c\u00032\u0019\u0000\u012b"+
		"\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"1\u0001\u0000\u0000\u0000\u012f\u0130\u0005P\u0000\u0000\u0130\u0134\u0005"+
		"\u000b\u0000\u0000\u0131\u0133\u00034\u001a\u0000\u0132\u0131\u0001\u0000"+
		"\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u01353\u0001\u0000\u0000"+
		"\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u0140\u00036\u001b\u0000"+
		"\u0138\u0140\u00038\u001c\u0000\u0139\u0140\u0003:\u001d\u0000\u013a\u0140"+
		"\u0003<\u001e\u0000\u013b\u0140\u0003>\u001f\u0000\u013c\u0140\u0003@"+
		" \u0000\u013d\u0140\u0003B!\u0000\u013e\u0140\u0003D\"\u0000\u013f\u0137"+
		"\u0001\u0000\u0000\u0000\u013f\u0138\u0001\u0000\u0000\u0000\u013f\u0139"+
		"\u0001\u0000\u0000\u0000\u013f\u013a\u0001\u0000\u0000\u0000\u013f\u013b"+
		"\u0001\u0000\u0000\u0000\u013f\u013c\u0001\u0000\u0000\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u01405\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0005\u0004\u0000\u0000\u0142\u0143\u0005"+
		"Q\u0000\u0000\u01437\u0001\u0000\u0000\u0000\u0144\u0145\u0005\u0015\u0000"+
		"\u0000\u0145\u0146\u0007\u0000\u0000\u0000\u01469\u0001\u0000\u0000\u0000"+
		"\u0147\u0148\u0005\u0016\u0000\u0000\u0148\u0149\u0005Q\u0000\u0000\u0149"+
		";\u0001\u0000\u0000\u0000\u014a\u014b\u0005\u0017\u0000\u0000\u014b\u014c"+
		"\u0003\u00a8T\u0000\u014c=\u0001\u0000\u0000\u0000\u014d\u014e\u0005\u0018"+
		"\u0000\u0000\u014e\u014f\u0005P\u0000\u0000\u014f?\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0005\u0019\u0000\u0000\u0151\u0152\u0005O\u0000\u0000\u0152"+
		"A\u0001\u0000\u0000\u0000\u0153\u0154\u0005\u001a\u0000\u0000\u0154\u0155"+
		"\u0005O\u0000\u0000\u0155C\u0001\u0000\u0000\u0000\u0156\u0157\u0005\u001b"+
		"\u0000\u0000\u0157\u0158\u0005Q\u0000\u0000\u0158E\u0001\u0000\u0000\u0000"+
		"\u0159\u015b\u0005\u0012\u0000\u0000\u015a\u015c\u0003H$\u0000\u015b\u015a"+
		"\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015b"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015eG\u0001"+
		"\u0000\u0000\u0000\u015f\u0160\u0005P\u0000\u0000\u0160\u0164\u0005\u000b"+
		"\u0000\u0000\u0161\u0163\u0003J%\u0000\u0162\u0161\u0001\u0000\u0000\u0000"+
		"\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0001\u0000\u0000\u0000\u0165I\u0001\u0000\u0000\u0000\u0166"+
		"\u0164\u0001\u0000\u0000\u0000\u0167\u0173\u0003L&\u0000\u0168\u0173\u0003"+
		"N\'\u0000\u0169\u0173\u0003P(\u0000\u016a\u0173\u0003R)\u0000\u016b\u0173"+
		"\u0003T*\u0000\u016c\u0173\u0003V+\u0000\u016d\u0173\u0003X,\u0000\u016e"+
		"\u0173\u0003Z-\u0000\u016f\u0173\u0003\\.\u0000\u0170\u0173\u0003^/\u0000"+
		"\u0171\u0173\u0003`0\u0000\u0172\u0167\u0001\u0000\u0000\u0000\u0172\u0168"+
		"\u0001\u0000\u0000\u0000\u0172\u0169\u0001\u0000\u0000\u0000\u0172\u016a"+
		"\u0001\u0000\u0000\u0000\u0172\u016b\u0001\u0000\u0000\u0000\u0172\u016c"+
		"\u0001\u0000\u0000\u0000\u0172\u016d\u0001\u0000\u0000\u0000\u0172\u016e"+
		"\u0001\u0000\u0000\u0000\u0172\u016f\u0001\u0000\u0000\u0000\u0172\u0170"+
		"\u0001\u0000\u0000\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0173K\u0001"+
		"\u0000\u0000\u0000\u0174\u0175\u0005\u0004\u0000\u0000\u0175\u0176\u0005"+
		"Q\u0000\u0000\u0176M\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u0016\u0000"+
		"\u0000\u0178\u0179\u0005Q\u0000\u0000\u0179O\u0001\u0000\u0000\u0000\u017a"+
		"\u017b\u0005\u0018\u0000\u0000\u017b\u017c\u0005P\u0000\u0000\u017cQ\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0005\u001c\u0000\u0000\u017e\u017f\u0003"+
		"b1\u0000\u017fS\u0001\u0000\u0000\u0000\u0180\u0181\u0005\u001d\u0000"+
		"\u0000\u0181\u0182\u0003\u00acV\u0000\u0182U\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0005\u001e\u0000\u0000\u0184\u0185\u0003\u00acV\u0000\u0185W\u0001"+
		"\u0000\u0000\u0000\u0186\u0187\u0005\u001f\u0000\u0000\u0187\u0188\u0005"+
		"T\u0000\u0000\u0188Y\u0001\u0000\u0000\u0000\u0189\u018a\u0005 \u0000"+
		"\u0000\u018a\u018b\u0005T\u0000\u0000\u018b[\u0001\u0000\u0000\u0000\u018c"+
		"\u018d\u0005!\u0000\u0000\u018d\u018e\u0005O\u0000\u0000\u018e]\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0005\"\u0000\u0000\u0190\u0191\u0005T"+
		"\u0000\u0000\u0191_\u0001\u0000\u0000\u0000\u0192\u0193\u0005#\u0000\u0000"+
		"\u0193\u0194\u0005T\u0000\u0000\u0194a\u0001\u0000\u0000\u0000\u0195\u0197"+
		"\u0003d2\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000"+
		"\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000"+
		"\u0000\u0000\u0199c\u0001\u0000\u0000\u0000\u019a\u019b\u0005$\u0000\u0000"+
		"\u019b\u01a1\u0005Q\u0000\u0000\u019c\u019d\u0005%\u0000\u0000\u019d\u01a1"+
		"\u0005Q\u0000\u0000\u019e\u019f\u0005&\u0000\u0000\u019f\u01a1\u0003f"+
		"3\u0000\u01a0\u019a\u0001\u0000\u0000\u0000\u01a0\u019c\u0001\u0000\u0000"+
		"\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1e\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a4\u0003h4\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6"+
		"\u0001\u0000\u0000\u0000\u01a6g\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005"+
		"P\u0000\u0000\u01a8\u01a9\u0005\u000b\u0000\u0000\u01a9\u01aa\u0005Q\u0000"+
		"\u0000\u01aai\u0001\u0000\u0000\u0000\u01ab\u01af\u0005\'\u0000\u0000"+
		"\u01ac\u01ae\u0003l6\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ae\u01b1"+
		"\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01af\u01b0"+
		"\u0001\u0000\u0000\u0000\u01b0k\u0001\u0000\u0000\u0000\u01b1\u01af\u0001"+
		"\u0000\u0000\u0000\u01b2\u01bc\u0003n7\u0000\u01b3\u01bc\u0003p8\u0000"+
		"\u01b4\u01bc\u0003r9\u0000\u01b5\u01bc\u0003t:\u0000\u01b6\u01bc\u0003"+
		"v;\u0000\u01b7\u01bc\u0003x<\u0000\u01b8\u01bc\u0003z=\u0000\u01b9\u01bc"+
		"\u0003|>\u0000\u01ba\u01bc\u0003~?\u0000\u01bb\u01b2\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b3\u0001\u0000\u0000\u0000\u01bb\u01b4\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b5\u0001\u0000\u0000\u0000\u01bb\u01b6\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b7\u0001\u0000\u0000\u0000\u01bb\u01b8\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000"+
		"\u0000\u01bcm\u0001\u0000\u0000\u0000\u01bd\u01be\u0005(\u0000\u0000\u01be"+
		"\u01bf\u0005N\u0000\u0000\u01bfo\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005"+
		"\u001f\u0000\u0000\u01c1\u01c2\u0005T\u0000\u0000\u01c2q\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0005 \u0000\u0000\u01c4\u01c5\u0005T\u0000\u0000\u01c5"+
		"s\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005\"\u0000\u0000\u01c7\u01c8"+
		"\u0005T\u0000\u0000\u01c8u\u0001\u0000\u0000\u0000\u01c9\u01ca\u0005)"+
		"\u0000\u0000\u01ca\u01cb\u0005T\u0000\u0000\u01cbw\u0001\u0000\u0000\u0000"+
		"\u01cc\u01cd\u0005*\u0000\u0000\u01cd\u01ce\u0005T\u0000\u0000\u01cey"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005+\u0000\u0000\u01d0\u01d1\u0005"+
		"S\u0000\u0000\u01d1{\u0001\u0000\u0000\u0000\u01d2\u01d3\u0005,\u0000"+
		"\u0000\u01d3\u01d4\u0005S\u0000\u0000\u01d4}\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d6\u0005-\u0000\u0000\u01d6\u01d7\u0005S\u0000\u0000\u01d7\u007f\u0001"+
		"\u0000\u0000\u0000\u01d8\u01da\u0005.\u0000\u0000\u01d9\u01db\u0003\u0082"+
		"A\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000"+
		"\u0000\u01dd\u0081\u0001\u0000\u0000\u0000\u01de\u01df\u0005P\u0000\u0000"+
		"\u01df\u01e3\u0005\u000b\u0000\u0000\u01e0\u01e2\u0003\u0084B\u0000\u01e1"+
		"\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000\u0000\u0000\u01e3"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4"+
		"\u0083\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e6"+
		"\u01ee\u0003\u0086C\u0000\u01e7\u01ee\u0003\u0088D\u0000\u01e8\u01ee\u0003"+
		"\u008aE\u0000\u01e9\u01ee\u0003\u008cF\u0000\u01ea\u01ee\u0003\u008eG"+
		"\u0000\u01eb\u01ee\u0003\u0090H\u0000\u01ec\u01ee\u0003\u0092I\u0000\u01ed"+
		"\u01e6\u0001\u0000\u0000\u0000\u01ed\u01e7\u0001\u0000\u0000\u0000\u01ed"+
		"\u01e8\u0001\u0000\u0000\u0000\u01ed\u01e9\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ec\u0001\u0000\u0000\u0000\u01ee\u0085\u0001\u0000\u0000\u0000\u01ef"+
		"\u01f0\u0005\u0015\u0000\u0000\u01f0\u01f1\u0005K\u0000\u0000\u01f1\u0087"+
		"\u0001\u0000\u0000\u0000\u01f2\u01f3\u0005/\u0000\u0000\u01f3\u01f4\u0005"+
		"Q\u0000\u0000\u01f4\u0089\u0001\u0000\u0000\u0000\u01f5\u01f6\u00050\u0000"+
		"\u0000\u01f6\u01f7\u0003\u00acV\u0000\u01f7\u008b\u0001\u0000\u0000\u0000"+
		"\u01f8\u01f9\u00051\u0000\u0000\u01f9\u01fa\u0003\u00acV\u0000\u01fa\u008d"+
		"\u0001\u0000\u0000\u0000\u01fb\u01fc\u00052\u0000\u0000\u01fc\u01fd\u0005"+
		"Q\u0000\u0000\u01fd\u008f\u0001\u0000\u0000\u0000\u01fe\u01ff\u00053\u0000"+
		"\u0000\u01ff\u0200\u0005P\u0000\u0000\u0200\u0091\u0001\u0000\u0000\u0000"+
		"\u0201\u0202\u00054\u0000\u0000\u0202\u0203\u0005P\u0000\u0000\u0203\u0093"+
		"\u0001\u0000\u0000\u0000\u0204\u0207\u00055\u0000\u0000\u0205\u0206\u0005"+
		"6\u0000\u0000\u0206\u0208\u0003\u0096K\u0000\u0207\u0205\u0001\u0000\u0000"+
		"\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u020b\u0001\u0000\u0000"+
		"\u0000\u0209\u020a\u00057\u0000\u0000\u020a\u020c\u0003\u009aM\u0000\u020b"+
		"\u0209\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c"+
		"\u020f\u0001\u0000\u0000\u0000\u020d\u020e\u00058\u0000\u0000\u020e\u0210"+
		"\u0003\u00a8T\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u020f\u0210\u0001"+
		"\u0000\u0000\u0000\u0210\u0213\u0001\u0000\u0000\u0000\u0211\u0212\u0005"+
		"9\u0000\u0000\u0212\u0214\u0003\u00a8T\u0000\u0213\u0211\u0001\u0000\u0000"+
		"\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u0095\u0001\u0000\u0000"+
		"\u0000\u0215\u021a\u0003\u0098L\u0000\u0216\u0217\u0007\u0001\u0000\u0000"+
		"\u0217\u0219\u0003\u0098L\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0219"+
		"\u021c\u0001\u0000\u0000\u0000\u021a\u0218\u0001\u0000\u0000\u0000\u021a"+
		"\u021b\u0001\u0000\u0000\u0000\u021b\u0097\u0001\u0000\u0000\u0000\u021c"+
		"\u021a\u0001\u0000\u0000\u0000\u021d\u0223\u0005P\u0000\u0000\u021e\u021f"+
		"\u0005:\u0000\u0000\u021f\u0220\u0003\u0096K\u0000\u0220\u0221\u0005;"+
		"\u0000\u0000\u0221\u0223\u0001\u0000\u0000\u0000\u0222\u021d\u0001\u0000"+
		"\u0000\u0000\u0222\u021e\u0001\u0000\u0000\u0000\u0223\u0099\u0001\u0000"+
		"\u0000\u0000\u0224\u0226\u0003\u009cN\u0000\u0225\u0224\u0001\u0000\u0000"+
		"\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000"+
		"\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u009b\u0001\u0000\u0000"+
		"\u0000\u0229\u022a\u0005P\u0000\u0000\u022a\u022b\u0005\u000b\u0000\u0000"+
		"\u022b\u022c\u0005P\u0000\u0000\u022c\u009d\u0001\u0000\u0000\u0000\u022d"+
		"\u022f\u0005<\u0000\u0000\u022e\u0230\u0003\u00a0P\u0000\u022f\u022e\u0001"+
		"\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u022f\u0001"+
		"\u0000\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000\u0232\u009f\u0001"+
		"\u0000\u0000\u0000\u0233\u0234\u0003\u00a2Q\u0000\u0234\u0235\u0005\u000b"+
		"\u0000\u0000\u0235\u0237\u0005=\u0000\u0000\u0236\u0238\u0003\u00a4R\u0000"+
		"\u0237\u0236\u0001\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000"+
		"\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000"+
		"\u023a\u00a1\u0001\u0000\u0000\u0000\u023b\u023c\u0005>\u0000\u0000\u023c"+
		"\u023d\u0005\u000b\u0000\u0000\u023d\u0245\u0005P\u0000\u0000\u023e\u023f"+
		"\u0005?\u0000\u0000\u023f\u0240\u0005\u000b\u0000\u0000\u0240\u0245\u0005"+
		"P\u0000\u0000\u0241\u0242\u0005@\u0000\u0000\u0242\u0243\u0005\u000b\u0000"+
		"\u0000\u0243\u0245\u0005T\u0000\u0000\u0244\u023b\u0001\u0000\u0000\u0000"+
		"\u0244\u023e\u0001\u0000\u0000\u0000\u0244\u0241\u0001\u0000\u0000\u0000"+
		"\u0245\u00a3\u0001\u0000\u0000\u0000\u0246\u0247\u0003\u00a6S\u0000\u0247"+
		"\u0248\u0005\u000b\u0000\u0000\u0248\u0249\u0003\u00aeW\u0000\u0249\u00a5"+
		"\u0001\u0000\u0000\u0000\u024a\u024b\u0007\u0002\u0000\u0000\u024b\u00a7"+
		"\u0001\u0000\u0000\u0000\u024c\u024e\u0005F\u0000\u0000\u024d\u024f\u0003"+
		"\u00aaU\u0000\u024e\u024d\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000"+
		"\u0000\u0000\u0250\u024e\u0001\u0000\u0000\u0000\u0250\u0251\u0001\u0000"+
		"\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0253\u0005G\u0000"+
		"\u0000\u0253\u00a9\u0001\u0000\u0000\u0000\u0254\u0255\u0005P\u0000\u0000"+
		"\u0255\u0256\u0005\u000b\u0000\u0000\u0256\u0257\u0003\u00aeW\u0000\u0257"+
		"\u00ab\u0001\u0000\u0000\u0000\u0258\u0261\u0005H\u0000\u0000\u0259\u025e"+
		"\u0003\u00aeW\u0000\u025a\u025b\u0005I\u0000\u0000\u025b\u025d\u0003\u00ae"+
		"W\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u0260\u0001\u0000\u0000"+
		"\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000"+
		"\u0000\u025f\u0262\u0001\u0000\u0000\u0000\u0260\u025e\u0001\u0000\u0000"+
		"\u0000\u0261\u0259\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000"+
		"\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263\u0264\u0005J\u0000\u0000"+
		"\u0264\u00ad\u0001\u0000\u0000\u0000\u0265\u0270\u0005Q\u0000\u0000\u0266"+
		"\u0270\u0005S\u0000\u0000\u0267\u0270\u0005T\u0000\u0000\u0268\u0270\u0005"+
		"O\u0000\u0000\u0269\u0270\u0005M\u0000\u0000\u026a\u0270\u0005K\u0000"+
		"\u0000\u026b\u0270\u0005L\u0000\u0000\u026c\u0270\u0005P\u0000\u0000\u026d"+
		"\u0270\u0003\u00acV\u0000\u026e\u0270\u0003\u00a8T\u0000\u026f\u0265\u0001"+
		"\u0000\u0000\u0000\u026f\u0266\u0001\u0000\u0000\u0000\u026f\u0267\u0001"+
		"\u0000\u0000\u0000\u026f\u0268\u0001\u0000\u0000\u0000\u026f\u0269\u0001"+
		"\u0000\u0000\u0000\u026f\u026a\u0001\u0000\u0000\u0000\u026f\u026b\u0001"+
		"\u0000\u0000\u0000\u026f\u026c\u0001\u0000\u0000\u0000\u026f\u026d\u0001"+
		"\u0000\u0000\u0000\u026f\u026e\u0001\u0000\u0000\u0000\u0270\u00af\u0001"+
		"\u0000\u0000\u0000\u0271\u0272\u0005R\u0000\u0000\u0272\u00b1\u0001\u0000"+
		"\u0000\u0000(\u00b8\u00bb\u00be\u00c1\u00c4\u00c7\u00ca\u00d0\u00da\u00f5"+
		"\u00fc\u0109\u012d\u0134\u013f\u015d\u0164\u0172\u0198\u01a0\u01a5\u01af"+
		"\u01bb\u01dc\u01e3\u01ed\u0207\u020b\u020f\u0213\u021a\u0222\u0227\u0231"+
		"\u0239\u0244\u0250\u025e\u0261\u026f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}