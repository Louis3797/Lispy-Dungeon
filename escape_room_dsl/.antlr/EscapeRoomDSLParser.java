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
		T__73=74, T__74=75, T__75=76, T__76=77, IF=78, ELSE=79, WHEN=80, REPEAT=81, 
		FROM=82, TO=83, AND=84, OR=85, SHOW_MESSAGE=86, UNLOCK=87, LOCK=88, VICTORY=89, 
		GAME_OVER=90, SPAWN=91, SPAWN_MONSTER=92, GIVE_ITEM=93, PRINT=94, PLAY_SOUND=95, 
		QUIZ_TYPE=96, DIFFICULTY=97, ITEM_TYPE=98, PLAYER_CLASS=99, BOOLEAN=100, 
		PLUS=101, MINUS=102, STAR=103, SLASH=104, PERCENT=105, EQ=106, NEQ=107, 
		LT=108, GT=109, LTE=110, GTE=111, AND_OP=112, OR_OP=113, NOT=114, ASSIGN=115, 
		PLUS_ASSIGN=116, MINUS_ASSIGN=117, STAR_ASSIGN=118, SLASH_ASSIGN=119, 
		LPAREN=120, RPAREN=121, LBRACE=122, RBRACE=123, LBRACKET=124, RBRACKET=125, 
		COLON=126, COMMA=127, DOT=128, ID=129, STRING=130, MULTILINE_STRING=131, 
		FLOAT=132, INT=133, WS=134, COMMENT=135;
	public static final int
		RULE_start = 0, RULE_escape_room = 1, RULE_variables_block = 2, RULE_variable_def = 3, 
		RULE_expression = 4, RULE_primary_expression = 5, RULE_triggers_block = 6, 
		RULE_trigger_def = 7, RULE_statement_block = 8, RULE_statement = 9, RULE_assignment_statement = 10, 
		RULE_property_access = 11, RULE_function_call_statement = 12, RULE_if_statement = 13, 
		RULE_repeat_statement = 14, RULE_event_handler = 15, RULE_metadata = 16, 
		RULE_metadata_property = 17, RULE_title_property = 18, RULE_description_property = 19, 
		RULE_difficulty_property = 20, RULE_max_time_property = 21, RULE_fog_of_war_property = 22, 
		RULE_view_distance_property = 23, RULE_camera_zoom_property = 24, RULE_rooms = 25, 
		RULE_room = 26, RULE_room_property = 27, RULE_room_description_property = 28, 
		RULE_room_x_property = 29, RULE_room_y_property = 30, RULE_room_width_property = 31, 
		RULE_room_height_property = 32, RULE_room_pattern_property = 33, RULE_room_items_property = 34, 
		RULE_room_npcs_property = 35, RULE_room_connections_property = 36, RULE_room_locked_by_property = 37, 
		RULE_items = 38, RULE_item = 39, RULE_item_property = 40, RULE_item_description_property = 41, 
		RULE_item_type_property = 42, RULE_item_texture_property = 43, RULE_item_properties_property = 44, 
		RULE_item_location_property = 45, RULE_item_visible_property = 46, RULE_item_readable_property = 47, 
		RULE_item_content_property = 48, RULE_npcs = 49, RULE_npc = 50, RULE_npc_property = 51, 
		RULE_npc_description_property = 52, RULE_npc_texture_property = 53, RULE_npc_location_property = 54, 
		RULE_npc_dialogue_property = 55, RULE_npc_gives_items_property = 56, RULE_npc_requires_items_property = 57, 
		RULE_npc_start_x_property = 58, RULE_npc_start_y_property = 59, RULE_npc_hostile_property = 60, 
		RULE_npc_health_property = 61, RULE_npc_damage_property = 62, RULE_dialogue = 63, 
		RULE_dialogue_property = 64, RULE_dialogue_conditions = 65, RULE_dialogue_condition = 66, 
		RULE_player = 67, RULE_player_property = 68, RULE_player_class_property = 69, 
		RULE_player_start_x_property = 70, RULE_player_start_y_property = 71, 
		RULE_player_health_property = 72, RULE_player_mana_property = 73, RULE_player_stamina_property = 74, 
		RULE_player_speed_property = 75, RULE_player_mana_restore_property = 76, 
		RULE_player_stamina_restore_property = 77, RULE_quizzes = 78, RULE_quiz = 79, 
		RULE_quiz_property = 80, RULE_quiz_type_property = 81, RULE_quiz_question_property = 82, 
		RULE_quiz_answers_property = 83, RULE_quiz_correct_answers_property = 84, 
		RULE_quiz_explanation_property = 85, RULE_quiz_reward_property = 86, RULE_quiz_attached_to_property = 87, 
		RULE_logic = 88, RULE_logic_expr = 89, RULE_logic_term = 90, RULE_dependencies = 91, 
		RULE_dependency = 92, RULE_events = 93, RULE_event = 94, RULE_event_trigger = 95, 
		RULE_action = 96, RULE_action_type = 97, RULE_object = 98, RULE_pair = 99, 
		RULE_array = 100, RULE_value = 101, RULE_multiline_string = 102;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "escape_room", "variables_block", "variable_def", "expression", 
			"primary_expression", "triggers_block", "trigger_def", "statement_block", 
			"statement", "assignment_statement", "property_access", "function_call_statement", 
			"if_statement", "repeat_statement", "event_handler", "metadata", "metadata_property", 
			"title_property", "description_property", "difficulty_property", "max_time_property", 
			"fog_of_war_property", "view_distance_property", "camera_zoom_property", 
			"rooms", "room", "room_property", "room_description_property", "room_x_property", 
			"room_y_property", "room_width_property", "room_height_property", "room_pattern_property", 
			"room_items_property", "room_npcs_property", "room_connections_property", 
			"room_locked_by_property", "items", "item", "item_property", "item_description_property", 
			"item_type_property", "item_texture_property", "item_properties_property", 
			"item_location_property", "item_visible_property", "item_readable_property", 
			"item_content_property", "npcs", "npc", "npc_property", "npc_description_property", 
			"npc_texture_property", "npc_location_property", "npc_dialogue_property", 
			"npc_gives_items_property", "npc_requires_items_property", "npc_start_x_property", 
			"npc_start_y_property", "npc_hostile_property", "npc_health_property", 
			"npc_damage_property", "dialogue", "dialogue_property", "dialogue_conditions", 
			"dialogue_condition", "player", "player_property", "player_class_property", 
			"player_start_x_property", "player_start_y_property", "player_health_property", 
			"player_mana_property", "player_stamina_property", "player_speed_property", 
			"player_mana_restore_property", "player_stamina_restore_property", "quizzes", 
			"quiz", "quiz_property", "quiz_type_property", "quiz_question_property", 
			"quiz_answers_property", "quiz_correct_answers_property", "quiz_explanation_property", 
			"quiz_reward_property", "quiz_attached_to_property", "logic", "logic_expr", 
			"logic_term", "dependencies", "dependency", "events", "event", "event_trigger", 
			"action", "action_type", "object", "pair", "array", "value", "multiline_string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'escape_room:'", "'variables:'", "'triggers:'", "'on_enter'", 
			"'on_exit'", "'on_first_enter'", "'on_clear'", "'on_pickup'", "'on_use'", 
			"'on_drop'", "'on_interact'", "'on_death'", "'on_correct'", "'on_wrong'", 
			"'metadata:'", "'title:'", "'description:'", "'difficulty:'", "'max_time:'", 
			"'fog_of_war:'", "'view_distance:'", "'camera_zoom:'", "'rooms:'", "'x:'", 
			"'y:'", "'width:'", "'height:'", "'pattern:'", "'items:'", "'npcs:'", 
			"'connections:'", "'locked_by:'", "'type:'", "'texture:'", "'properties:'", 
			"'location:'", "'visible:'", "'readable:'", "'content:'", "'dialogue:'", 
			"'gives_items:'", "'requires_items:'", "'start_x:'", "'start_y:'", "'hostile:'", 
			"'health:'", "'damage:'", "'default_text:'", "'default:'", "'conditions:'", 
			"'player:'", "'class:'", "'mana:'", "'stamina:'", "'speed:'", "'mana_restore:'", 
			"'stamina_restore:'", "'quizzes:'", "'question:'", "'answers:'", "'correct_answers:'", 
			"'explanation:'", "'reward:'", "'attached_to:'", "'logic:'", "'win_condition:'", 
			"'dependencies:'", "'state_variables:'", "'timers:'", "'events:'", "'actions:'", 
			"'on_puzzle_solved'", "'on_item_collected'", "'on_time_warning'", "'unlock_door'", 
			"'trigger_puzzle'", "'update_state'", "'if'", "'else'", "'when'", "'repeat'", 
			"'from'", "'to'", "'AND'", "'OR'", "'show_message'", "'unlock'", "'lock'", 
			"'victory'", "'game_over'", "'spawn'", "'spawn_monster'", "'give_item'", 
			"'print'", "'play_sound'", null, null, null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", 
			"'||'", "'!'", "'='", "'+='", "'-='", "'*='", "'/='", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "':'", "','", "'.'"
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
			null, null, null, null, null, null, "IF", "ELSE", "WHEN", "REPEAT", "FROM", 
			"TO", "AND", "OR", "SHOW_MESSAGE", "UNLOCK", "LOCK", "VICTORY", "GAME_OVER", 
			"SPAWN", "SPAWN_MONSTER", "GIVE_ITEM", "PRINT", "PLAY_SOUND", "QUIZ_TYPE", 
			"DIFFICULTY", "ITEM_TYPE", "PLAYER_CLASS", "BOOLEAN", "PLUS", "MINUS", 
			"STAR", "SLASH", "PERCENT", "EQ", "NEQ", "LT", "GT", "LTE", "GTE", "AND_OP", 
			"OR_OP", "NOT", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", 
			"SLASH_ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"COLON", "COMMA", "DOT", "ID", "STRING", "MULTILINE_STRING", "FLOAT", 
			"INT", "WS", "COMMENT"
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
			setState(206);
			escape_room();
			setState(207);
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
		public Variables_blockContext variables_block() {
			return getRuleContext(Variables_blockContext.class,0);
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
		public Triggers_blockContext triggers_block() {
			return getRuleContext(Triggers_blockContext.class,0);
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
			setState(209);
			match(T__0);
			setState(210);
			metadata();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(211);
				variables_block();
				}
			}

			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(214);
				rooms();
				}
			}

			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__57) {
				{
				setState(217);
				quizzes();
				}
			}

			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(220);
				items();
				}
			}

			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(223);
				npcs();
				}
			}

			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(226);
				player();
				}
			}

			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(229);
				triggers_block();
				}
			}

			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(232);
				logic();
				}
			}

			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__69) {
				{
				setState(235);
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
	public static class Variables_blockContext extends ParserRuleContext {
		public List<Variable_defContext> variable_def() {
			return getRuleContexts(Variable_defContext.class);
		}
		public Variable_defContext variable_def(int i) {
			return getRuleContext(Variable_defContext.class,i);
		}
		public Variables_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables_block; }
	}

	public final Variables_blockContext variables_block() throws RecognitionException {
		Variables_blockContext _localctx = new Variables_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variables_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__1);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(239);
				variable_def();
				}
				}
				setState(244);
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
	public static class Variable_defContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Variable_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_def; }
	}

	public final Variable_defContext variable_def() throws RecognitionException {
		Variable_defContext _localctx = new Variable_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(ID);
			setState(246);
			match(COLON);
			setState(247);
			expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND_OP() { return getToken(EscapeRoomDSLParser.AND_OP, 0); }
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EscapeRoomDSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EscapeRoomDSLParser.COMMA, i);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(EscapeRoomDSLParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(EscapeRoomDSLParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(EscapeRoomDSLParser.PERCENT, 0); }
		public MulDivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(EscapeRoomDSLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(EscapeRoomDSLParser.NEQ, 0); }
		public EqualityExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(EscapeRoomDSLParser.LT, 0); }
		public TerminalNode GT() { return getToken(EscapeRoomDSLParser.GT, 0); }
		public TerminalNode LTE() { return getToken(EscapeRoomDSLParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(EscapeRoomDSLParser.GTE, 0); }
		public CompareExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ExpressionContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(EscapeRoomDSLParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(EscapeRoomDSLParser.MINUS, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(EscapeRoomDSLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(EscapeRoomDSLParser.MINUS, 0); }
		public AddSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(EscapeRoomDSLParser.DOT, 0); }
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public PropertyAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends ExpressionContext {
		public TerminalNode IF() { return getToken(EscapeRoomDSLParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public TerminalNode ELSE() { return getToken(EscapeRoomDSLParser.ELSE, 0); }
		public TernaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR_OP() { return getToken(EscapeRoomDSLParser.OR_OP, 0); }
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(250);
				primary_expression();
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(ID);
				setState(252);
				match(LPAREN);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 60873430500638721L) != 0)) {
					{
					setState(253);
					expression(0);
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(254);
						match(COMMA);
						setState(255);
						expression(0);
						}
						}
						setState(260);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(263);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(265);
				expression(8);
				}
				break;
			case 4:
				{
				_localctx = new TernaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(IF);
				setState(267);
				match(LPAREN);
				setState(268);
				expression(0);
				setState(269);
				match(RPAREN);
				setState(270);
				expression(0);
				setState(271);
				match(ELSE);
				setState(272);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(277);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & 7L) != 0)) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(280);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(281);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(283);
						((CompareExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 15L) != 0)) ) {
							((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(286);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(287);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(289);
						match(AND_OP);
						setState(290);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(292);
						match(OR_OP);
						setState(293);
						expression(3);
						}
						break;
					case 7:
						{
						_localctx = new PropertyAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(295);
						match(DOT);
						setState(296);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primary_expressionContext extends ParserRuleContext {
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
	 
		public Primary_expressionContext() { }
		public void copyFrom(Primary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends Primary_expressionContext {
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public StringLiteralContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolLiteralContext extends Primary_expressionContext {
		public TerminalNode BOOLEAN() { return getToken(EscapeRoomDSLParser.BOOLEAN, 0); }
		public BoolLiteralContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralContext extends Primary_expressionContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public FloatLiteralContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends Primary_expressionContext {
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public IdentifierExprContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends Primary_expressionContext {
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public IntLiteralContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends Primary_expressionContext {
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public ParenExprContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends Primary_expressionContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayLiteralContext(Primary_expressionContext ctx) { copyFrom(ctx); }
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primary_expression);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				match(STRING);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new IdentifierExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(306);
				match(ID);
				}
				break;
			case LPAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(307);
				match(LPAREN);
				setState(308);
				expression(0);
				setState(309);
				match(RPAREN);
				}
				break;
			case LBRACKET:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(311);
				array();
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
	public static class Triggers_blockContext extends ParserRuleContext {
		public List<Trigger_defContext> trigger_def() {
			return getRuleContexts(Trigger_defContext.class);
		}
		public Trigger_defContext trigger_def(int i) {
			return getRuleContext(Trigger_defContext.class,i);
		}
		public Triggers_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggers_block; }
	}

	public final Triggers_blockContext triggers_block() throws RecognitionException {
		Triggers_blockContext _localctx = new Triggers_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_triggers_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__2);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHEN) {
				{
				{
				setState(315);
				trigger_def();
				}
				}
				setState(320);
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
	public static class Trigger_defContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(EscapeRoomDSLParser.WHEN, 0); }
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Trigger_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_def; }
	}

	public final Trigger_defContext trigger_def() throws RecognitionException {
		Trigger_defContext _localctx = new Trigger_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_trigger_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(WHEN);
			setState(322);
			match(LPAREN);
			setState(323);
			expression(0);
			setState(324);
			match(RPAREN);
			setState(325);
			statement_block();
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
	public static class Statement_blockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(EscapeRoomDSLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EscapeRoomDSLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(LBRACE);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 2251799813947145L) != 0)) {
				{
				{
				setState(328);
				statement();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334);
			match(RBRACE);
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
	public static class StatementContext extends ParserRuleContext {
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public Function_call_statementContext function_call_statement() {
			return getRuleContext(Function_call_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Repeat_statementContext repeat_statement() {
			return getRuleContext(Repeat_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				assignment_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				function_call_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				if_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(339);
				repeat_statement();
				}
				break;
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
	public static class Assignment_statementContext extends ParserRuleContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public Property_accessContext property_access() {
			return getRuleContext(Property_accessContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EscapeRoomDSLParser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(EscapeRoomDSLParser.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(EscapeRoomDSLParser.MINUS_ASSIGN, 0); }
		public TerminalNode STAR_ASSIGN() { return getToken(EscapeRoomDSLParser.STAR_ASSIGN, 0); }
		public TerminalNode SLASH_ASSIGN() { return getToken(EscapeRoomDSLParser.SLASH_ASSIGN, 0); }
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(342);
				match(ID);
				}
				break;
			case 2:
				{
				setState(343);
				property_access();
				}
				break;
			}
			setState(346);
			((Assignment_statementContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 31L) != 0)) ) {
				((Assignment_statementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(347);
			expression(0);
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
	public static class Property_accessContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EscapeRoomDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EscapeRoomDSLParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(EscapeRoomDSLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(EscapeRoomDSLParser.DOT, i);
		}
		public Property_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_access; }
	}

	public final Property_accessContext property_access() throws RecognitionException {
		Property_accessContext _localctx = new Property_accessContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_property_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(ID);
			setState(352); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(350);
				match(DOT);
				setState(351);
				match(ID);
				}
				}
				setState(354); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
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
	public static class Function_call_statementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode SHOW_MESSAGE() { return getToken(EscapeRoomDSLParser.SHOW_MESSAGE, 0); }
		public TerminalNode UNLOCK() { return getToken(EscapeRoomDSLParser.UNLOCK, 0); }
		public TerminalNode LOCK() { return getToken(EscapeRoomDSLParser.LOCK, 0); }
		public TerminalNode VICTORY() { return getToken(EscapeRoomDSLParser.VICTORY, 0); }
		public TerminalNode GAME_OVER() { return getToken(EscapeRoomDSLParser.GAME_OVER, 0); }
		public TerminalNode SPAWN() { return getToken(EscapeRoomDSLParser.SPAWN, 0); }
		public TerminalNode SPAWN_MONSTER() { return getToken(EscapeRoomDSLParser.SPAWN_MONSTER, 0); }
		public TerminalNode GIVE_ITEM() { return getToken(EscapeRoomDSLParser.GIVE_ITEM, 0); }
		public TerminalNode PRINT() { return getToken(EscapeRoomDSLParser.PRINT, 0); }
		public TerminalNode PLAY_SOUND() { return getToken(EscapeRoomDSLParser.PLAY_SOUND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EscapeRoomDSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EscapeRoomDSLParser.COMMA, i);
		}
		public Function_call_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_statement; }
	}

	public final Function_call_statementContext function_call_statement() throws RecognitionException {
		Function_call_statementContext _localctx = new Function_call_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 8796093023231L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(357);
			match(LPAREN);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 60873430500638721L) != 0)) {
				{
				setState(358);
				expression(0);
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(359);
					match(COMMA);
					setState(360);
					expression(0);
					}
					}
					setState(365);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(368);
			match(RPAREN);
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(EscapeRoomDSLParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(EscapeRoomDSLParser.ELSE, 0); }
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(IF);
			setState(371);
			match(LPAREN);
			setState(372);
			expression(0);
			setState(373);
			match(RPAREN);
			setState(374);
			statement_block();
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(375);
				match(ELSE);
				setState(378);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
					{
					setState(376);
					if_statement();
					}
					break;
				case LBRACE:
					{
					setState(377);
					statement_block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class Repeat_statementContext extends ParserRuleContext {
		public Repeat_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat_statement; }
	 
		public Repeat_statementContext() { }
		public void copyFrom(Repeat_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatRangeContext extends Repeat_statementContext {
		public TerminalNode REPEAT() { return getToken(EscapeRoomDSLParser.REPEAT, 0); }
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode FROM() { return getToken(EscapeRoomDSLParser.FROM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(EscapeRoomDSLParser.TO, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public RepeatRangeContext(Repeat_statementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatCountContext extends Repeat_statementContext {
		public TerminalNode REPEAT() { return getToken(EscapeRoomDSLParser.REPEAT, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public RepeatCountContext(Repeat_statementContext ctx) { copyFrom(ctx); }
	}

	public final Repeat_statementContext repeat_statement() throws RecognitionException {
		Repeat_statementContext _localctx = new Repeat_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_repeat_statement);
		try {
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new RepeatCountContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(REPEAT);
				setState(383);
				match(INT);
				setState(384);
				statement_block();
				}
				break;
			case 2:
				_localctx = new RepeatRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				match(REPEAT);
				setState(386);
				match(ID);
				setState(387);
				match(FROM);
				setState(388);
				expression(0);
				setState(389);
				match(TO);
				setState(390);
				expression(0);
				setState(391);
				statement_block();
				}
				break;
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
	public static class Event_handlerContext extends ParserRuleContext {
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Event_handlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_handler; }
	}

	public final Event_handlerContext event_handler() throws RecognitionException {
		Event_handlerContext _localctx = new Event_handlerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_event_handler);
		try {
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				match(T__3);
				setState(396);
				statement_block();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(T__4);
				setState(398);
				statement_block();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(399);
				match(T__5);
				setState(400);
				statement_block();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(401);
				match(T__6);
				setState(402);
				statement_block();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(403);
				match(T__7);
				setState(404);
				statement_block();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(405);
				match(T__8);
				setState(406);
				statement_block();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 7);
				{
				setState(407);
				match(T__9);
				setState(408);
				statement_block();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 8);
				{
				setState(409);
				match(T__10);
				setState(410);
				statement_block();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 9);
				{
				setState(411);
				match(T__11);
				setState(412);
				statement_block();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 10);
				{
				setState(413);
				match(T__12);
				setState(414);
				statement_block();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 11);
				{
				setState(415);
				match(T__13);
				setState(416);
				statement_block();
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
		enterRule(_localctx, 32, RULE_metadata);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(T__14);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8323072L) != 0)) {
				{
				{
				setState(420);
				metadata_property();
				}
				}
				setState(425);
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
		enterRule(_localctx, 34, RULE_metadata_property);
		try {
			setState(433);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				title_property();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				description_property();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(428);
				difficulty_property();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(429);
				max_time_property();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(430);
				fog_of_war_property();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 6);
				{
				setState(431);
				view_distance_property();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 7);
				{
				setState(432);
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
		enterRule(_localctx, 36, RULE_title_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(T__15);
			setState(436);
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
		enterRule(_localctx, 38, RULE_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(T__16);
			setState(439);
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
		enterRule(_localctx, 40, RULE_difficulty_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(T__17);
			setState(442);
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
		enterRule(_localctx, 42, RULE_max_time_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(T__18);
			setState(445);
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
		enterRule(_localctx, 44, RULE_fog_of_war_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(T__19);
			setState(448);
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
		enterRule(_localctx, 46, RULE_view_distance_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(T__20);
			setState(451);
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
		enterRule(_localctx, 48, RULE_camera_zoom_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(T__21);
			setState(454);
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
		enterRule(_localctx, 50, RULE_rooms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(T__22);
			setState(458); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(457);
				room();
				}
				}
				setState(460); 
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 52, RULE_room);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(ID);
			setState(463);
			match(COLON);
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(464);
					room_property();
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		public Event_handlerContext event_handler() {
			return getRuleContext(Event_handlerContext.class,0);
		}
		public Room_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_property; }
	}

	public final Room_propertyContext room_property() throws RecognitionException {
		Room_propertyContext _localctx = new Room_propertyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_room_property);
		try {
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				room_description_property();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				room_x_property();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(472);
				room_y_property();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(473);
				room_width_property();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 5);
				{
				setState(474);
				room_height_property();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(475);
				room_pattern_property();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 7);
				{
				setState(476);
				room_items_property();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 8);
				{
				setState(477);
				room_npcs_property();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 9);
				{
				setState(478);
				room_connections_property();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 10);
				{
				setState(479);
				room_locked_by_property();
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 11);
				{
				setState(480);
				event_handler();
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
		enterRule(_localctx, 56, RULE_room_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(T__16);
			setState(484);
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
		enterRule(_localctx, 58, RULE_room_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(T__23);
			setState(487);
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
		enterRule(_localctx, 60, RULE_room_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(T__24);
			setState(490);
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
		enterRule(_localctx, 62, RULE_room_width_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			match(T__25);
			setState(493);
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
		enterRule(_localctx, 64, RULE_room_height_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(T__26);
			setState(496);
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
		enterRule(_localctx, 66, RULE_room_pattern_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(T__27);
			setState(499);
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
		enterRule(_localctx, 68, RULE_room_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__28);
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
		enterRule(_localctx, 70, RULE_room_npcs_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(T__29);
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
		enterRule(_localctx, 72, RULE_room_connections_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__30);
			setState(508);
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
		enterRule(_localctx, 74, RULE_room_locked_by_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(T__31);
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
		enterRule(_localctx, 76, RULE_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__28);
			setState(515); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(514);
				item();
				}
				}
				setState(517); 
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 78, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(ID);
			setState(520);
			match(COLON);
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1090921857008L) != 0)) {
				{
				{
				setState(521);
				item_property();
				}
				}
				setState(526);
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
		public Event_handlerContext event_handler() {
			return getRuleContext(Event_handlerContext.class,0);
		}
		public Item_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_property; }
	}

	public final Item_propertyContext item_property() throws RecognitionException {
		Item_propertyContext _localctx = new Item_propertyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_item_property);
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				item_description_property();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				item_type_property();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(529);
				item_texture_property();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 4);
				{
				setState(530);
				item_properties_property();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 5);
				{
				setState(531);
				item_location_property();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(532);
				item_visible_property();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 7);
				{
				setState(533);
				item_readable_property();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 8);
				{
				setState(534);
				item_content_property();
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 9);
				{
				setState(535);
				event_handler();
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
		enterRule(_localctx, 82, RULE_item_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			match(T__16);
			setState(539);
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
		enterRule(_localctx, 84, RULE_item_type_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(T__32);
			setState(542);
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
		enterRule(_localctx, 86, RULE_item_texture_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(T__33);
			setState(545);
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
		enterRule(_localctx, 88, RULE_item_properties_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(T__34);
			setState(548);
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
		enterRule(_localctx, 90, RULE_item_location_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(T__35);
			setState(551);
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
		enterRule(_localctx, 92, RULE_item_visible_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(T__36);
			setState(554);
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
		enterRule(_localctx, 94, RULE_item_readable_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(T__37);
			setState(557);
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
		enterRule(_localctx, 96, RULE_item_content_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(T__38);
			setState(560);
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
		enterRule(_localctx, 98, RULE_npcs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(T__29);
			setState(564); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(563);
				npc();
				}
				}
				setState(566); 
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 100, RULE_npc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(ID);
			setState(569);
			match(COLON);
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 280461364592624L) != 0)) {
				{
				{
				setState(570);
				npc_property();
				}
				}
				setState(575);
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
		public Event_handlerContext event_handler() {
			return getRuleContext(Event_handlerContext.class,0);
		}
		public Npc_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_npc_property; }
	}

	public final Npc_propertyContext npc_property() throws RecognitionException {
		Npc_propertyContext _localctx = new Npc_propertyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_npc_property);
		try {
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				npc_description_property();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				npc_texture_property();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(578);
				npc_location_property();
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 4);
				{
				setState(579);
				npc_dialogue_property();
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 5);
				{
				setState(580);
				npc_gives_items_property();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 6);
				{
				setState(581);
				npc_requires_items_property();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 7);
				{
				setState(582);
				npc_start_x_property();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 8);
				{
				setState(583);
				npc_start_y_property();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 9);
				{
				setState(584);
				npc_hostile_property();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 10);
				{
				setState(585);
				npc_health_property();
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 11);
				{
				setState(586);
				npc_damage_property();
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 12);
				{
				setState(587);
				event_handler();
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
		enterRule(_localctx, 104, RULE_npc_description_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(T__16);
			setState(591);
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
		enterRule(_localctx, 106, RULE_npc_texture_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(T__33);
			setState(594);
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
		enterRule(_localctx, 108, RULE_npc_location_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(T__35);
			setState(597);
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
		enterRule(_localctx, 110, RULE_npc_dialogue_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(T__39);
			setState(600);
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
		enterRule(_localctx, 112, RULE_npc_gives_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(T__40);
			setState(603);
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
		enterRule(_localctx, 114, RULE_npc_requires_items_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(T__41);
			setState(606);
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
		enterRule(_localctx, 116, RULE_npc_start_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(T__42);
			setState(609);
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
		enterRule(_localctx, 118, RULE_npc_start_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(T__43);
			setState(612);
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
		enterRule(_localctx, 120, RULE_npc_hostile_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(T__44);
			setState(615);
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
		enterRule(_localctx, 122, RULE_npc_health_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(T__45);
			setState(618);
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
		enterRule(_localctx, 124, RULE_npc_damage_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(T__46);
			setState(621);
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
		enterRule(_localctx, 126, RULE_dialogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(623);
				dialogue_property();
				}
				}
				setState(626); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1970324836974592L) != 0) );
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
		enterRule(_localctx, 128, RULE_dialogue_property);
		try {
			setState(634);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
				enterOuterAlt(_localctx, 1);
				{
				setState(628);
				match(T__47);
				setState(629);
				match(STRING);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(630);
				match(T__48);
				setState(631);
				match(STRING);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 3);
				{
				setState(632);
				match(T__49);
				setState(633);
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
		enterRule(_localctx, 130, RULE_dialogue_conditions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(637); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(636);
					dialogue_condition();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(639); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(EscapeRoomDSLParser.STRING, 0); }
		public Dialogue_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dialogue_condition; }
	}

	public final Dialogue_conditionContext dialogue_condition() throws RecognitionException {
		Dialogue_conditionContext _localctx = new Dialogue_conditionContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_dialogue_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(ID);
			setState(642);
			match(COLON);
			setState(643);
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
		enterRule(_localctx, 134, RULE_player);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			match(T__50);
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 283823533547585536L) != 0)) {
				{
				{
				setState(646);
				player_property();
				}
				}
				setState(651);
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
		enterRule(_localctx, 136, RULE_player_property);
		try {
			setState(661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				player_class_property();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 2);
				{
				setState(653);
				player_start_x_property();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 3);
				{
				setState(654);
				player_start_y_property();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 4);
				{
				setState(655);
				player_health_property();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 5);
				{
				setState(656);
				player_mana_property();
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 6);
				{
				setState(657);
				player_stamina_property();
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 7);
				{
				setState(658);
				player_speed_property();
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 8);
				{
				setState(659);
				player_mana_restore_property();
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 9);
				{
				setState(660);
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
		enterRule(_localctx, 138, RULE_player_class_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(T__51);
			setState(664);
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
		enterRule(_localctx, 140, RULE_player_start_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(T__42);
			setState(667);
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
		enterRule(_localctx, 142, RULE_player_start_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			match(T__43);
			setState(670);
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
		enterRule(_localctx, 144, RULE_player_health_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(T__45);
			setState(673);
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
		enterRule(_localctx, 146, RULE_player_mana_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(T__52);
			setState(676);
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
		enterRule(_localctx, 148, RULE_player_stamina_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(T__53);
			setState(679);
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
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_speed_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_speed_property; }
	}

	public final Player_speed_propertyContext player_speed_property() throws RecognitionException {
		Player_speed_propertyContext _localctx = new Player_speed_propertyContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_player_speed_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			match(T__54);
			setState(682);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
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
	public static class Player_mana_restore_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_mana_restore_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_mana_restore_property; }
	}

	public final Player_mana_restore_propertyContext player_mana_restore_property() throws RecognitionException {
		Player_mana_restore_propertyContext _localctx = new Player_mana_restore_propertyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_player_mana_restore_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			match(T__55);
			setState(685);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
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
	public static class Player_stamina_restore_propertyContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(EscapeRoomDSLParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Player_stamina_restore_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player_stamina_restore_property; }
	}

	public final Player_stamina_restore_propertyContext player_stamina_restore_property() throws RecognitionException {
		Player_stamina_restore_propertyContext _localctx = new Player_stamina_restore_propertyContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_player_stamina_restore_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			match(T__56);
			setState(688);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
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
		enterRule(_localctx, 156, RULE_quizzes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(T__57);
			setState(692); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(691);
				quiz();
				}
				}
				setState(694); 
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 158, RULE_quiz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(ID);
			setState(697);
			match(COLON);
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 2269814212731602943L) != 0)) {
				{
				{
				setState(698);
				quiz_property();
				}
				}
				setState(703);
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
		public Event_handlerContext event_handler() {
			return getRuleContext(Event_handlerContext.class,0);
		}
		public Quiz_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz_property; }
	}

	public final Quiz_propertyContext quiz_property() throws RecognitionException {
		Quiz_propertyContext _localctx = new Quiz_propertyContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_quiz_property);
		try {
			setState(712);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(704);
				quiz_type_property();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(705);
				quiz_question_property();
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 3);
				{
				setState(706);
				quiz_answers_property();
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 4);
				{
				setState(707);
				quiz_correct_answers_property();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 5);
				{
				setState(708);
				quiz_explanation_property();
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 6);
				{
				setState(709);
				quiz_reward_property();
				}
				break;
			case T__63:
				enterOuterAlt(_localctx, 7);
				{
				setState(710);
				quiz_attached_to_property();
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 8);
				{
				setState(711);
				event_handler();
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
		enterRule(_localctx, 162, RULE_quiz_type_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(T__32);
			setState(715);
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
		enterRule(_localctx, 164, RULE_quiz_question_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			match(T__58);
			setState(718);
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
		enterRule(_localctx, 166, RULE_quiz_answers_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			match(T__59);
			setState(721);
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
		enterRule(_localctx, 168, RULE_quiz_correct_answers_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			match(T__60);
			setState(724);
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
		enterRule(_localctx, 170, RULE_quiz_explanation_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			match(T__61);
			setState(727);
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
		enterRule(_localctx, 172, RULE_quiz_reward_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			match(T__62);
			setState(730);
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
		enterRule(_localctx, 174, RULE_quiz_attached_to_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(T__63);
			setState(733);
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
		enterRule(_localctx, 176, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(T__64);
			setState(738);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__65) {
				{
				setState(736);
				match(T__65);
				setState(737);
				logic_expr();
				}
			}

			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__66) {
				{
				setState(740);
				match(T__66);
				setState(741);
				dependencies();
				}
			}

			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__67) {
				{
				setState(744);
				match(T__67);
				setState(745);
				object();
				}
			}

			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(748);
				match(T__68);
				setState(749);
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
		enterRule(_localctx, 178, RULE_logic_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			logic_term();
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(753);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(754);
				logic_term();
				}
				}
				setState(759);
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
		public TerminalNode LPAREN() { return getToken(EscapeRoomDSLParser.LPAREN, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EscapeRoomDSLParser.RPAREN, 0); }
		public Logic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_term; }
	}

	public final Logic_termContext logic_term() throws RecognitionException {
		Logic_termContext _localctx = new Logic_termContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_logic_term);
		try {
			setState(765);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(760);
				match(ID);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(761);
				match(LPAREN);
				setState(762);
				logic_expr();
				setState(763);
				match(RPAREN);
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
		enterRule(_localctx, 182, RULE_dependencies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(767);
				dependency();
				}
				}
				setState(770); 
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(ID);
			setState(773);
			match(COLON);
			setState(774);
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
		enterRule(_localctx, 186, RULE_events);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			match(T__69);
			setState(778); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(777);
				event();
				}
				}
				setState(780); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 7L) != 0) );
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 188, RULE_event);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
			event_trigger();
			setState(783);
			match(COLON);
			setState(784);
			match(T__70);
			setState(786); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(785);
				action();
				}
				}
				setState(788); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 1050631L) != 0) );
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public TerminalNode INT() { return getToken(EscapeRoomDSLParser.INT, 0); }
		public Event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_trigger; }
	}

	public final Event_triggerContext event_trigger() throws RecognitionException {
		Event_triggerContext _localctx = new Event_triggerContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_event_trigger);
		try {
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__71:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				match(T__71);
				setState(791);
				match(COLON);
				setState(792);
				match(ID);
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 2);
				{
				setState(793);
				match(T__72);
				setState(794);
				match(COLON);
				setState(795);
				match(ID);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 3);
				{
				setState(796);
				match(T__73);
				setState(797);
				match(COLON);
				setState(798);
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 192, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			action_type();
			setState(802);
			match(COLON);
			setState(803);
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
		public TerminalNode PLAY_SOUND() { return getToken(EscapeRoomDSLParser.PLAY_SOUND, 0); }
		public TerminalNode SHOW_MESSAGE() { return getToken(EscapeRoomDSLParser.SHOW_MESSAGE, 0); }
		public Action_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_type; }
	}

	public final Action_typeContext action_type() throws RecognitionException {
		Action_typeContext _localctx = new Action_typeContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_action_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			_la = _input.LA(1);
			if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 1050631L) != 0)) ) {
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
		public TerminalNode LBRACE() { return getToken(EscapeRoomDSLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EscapeRoomDSLParser.RBRACE, 0); }
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
		enterRule(_localctx, 196, RULE_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(LBRACE);
			setState(809); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(808);
				pair();
				}
				}
				setState(811); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(813);
			match(RBRACE);
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
		public TerminalNode COLON() { return getToken(EscapeRoomDSLParser.COLON, 0); }
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
		enterRule(_localctx, 198, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			match(ID);
			setState(816);
			match(COLON);
			setState(817);
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
		public TerminalNode LBRACKET() { return getToken(EscapeRoomDSLParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(EscapeRoomDSLParser.RBRACKET, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EscapeRoomDSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EscapeRoomDSLParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			match(LBRACKET);
			setState(828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & 232263778327L) != 0)) {
				{
				setState(820);
				value();
				setState(825);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(821);
					match(COMMA);
					setState(822);
					value();
					}
					}
					setState(827);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(830);
			match(RBRACKET);
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
		enterRule(_localctx, 202, RULE_value);
		try {
			setState(842);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(832);
				match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(833);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(834);
				match(INT);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(835);
				match(BOOLEAN);
				}
				break;
			case ITEM_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(836);
				match(ITEM_TYPE);
				}
				break;
			case QUIZ_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(837);
				match(QUIZ_TYPE);
				}
				break;
			case DIFFICULTY:
				enterOuterAlt(_localctx, 7);
				{
				setState(838);
				match(DIFFICULTY);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(839);
				match(ID);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 9);
				{
				setState(840);
				array();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 10);
				{
				setState(841);
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
		enterRule(_localctx, 204, RULE_multiline_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0087\u034f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00d5\b\u0001\u0001"+
		"\u0001\u0003\u0001\u00d8\b\u0001\u0001\u0001\u0003\u0001\u00db\b\u0001"+
		"\u0001\u0001\u0003\u0001\u00de\b\u0001\u0001\u0001\u0003\u0001\u00e1\b"+
		"\u0001\u0001\u0001\u0003\u0001\u00e4\b\u0001\u0001\u0001\u0003\u0001\u00e7"+
		"\b\u0001\u0001\u0001\u0003\u0001\u00ea\b\u0001\u0001\u0001\u0003\u0001"+
		"\u00ed\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002\u00f1\b\u0002\n\u0002"+
		"\f\u0002\u00f4\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u0101\b\u0004\n\u0004\f\u0004\u0104\t\u0004\u0003"+
		"\u0004\u0106\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u0113\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u012a\b\u0004\n\u0004\f\u0004\u012d\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0139\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u013d\b\u0006\n\u0006\f\u0006\u0140\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0005\b\u014a\b\b\n\b\f\b\u014d\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0155\b\t\u0001\n\u0001\n\u0003\n\u0159\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0161"+
		"\b\u000b\u000b\u000b\f\u000b\u0162\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u016a\b\f\n\f\f\f\u016d\t\f\u0003\f\u016f\b\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u017b\b\r\u0003\r\u017d\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u018a\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u01a2\b\u000f\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u01a6\b\u0010\n\u0010\f\u0010\u01a9\t\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u01b2\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0004\u0019\u01cb\b\u0019\u000b\u0019\f\u0019\u01cc\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u01d2\b\u001a\n\u001a\f\u001a\u01d5\t\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u01e2\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\""+
		"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0004&\u0204\b&\u000b&\f&\u0205\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u020b\b\'\n\'\f\'\u020e\t\'\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0003(\u0219\b(\u0001)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00011\u00011\u00041\u0235\b1\u000b1\f1\u0236\u00012\u00012\u00012\u0005"+
		"2\u023c\b2\n2\f2\u023f\t2\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00033\u024d\b3\u00014\u00014\u0001"+
		"4\u00015\u00015\u00015\u00016\u00016\u00016\u00017\u00017\u00017\u0001"+
		"8\u00018\u00018\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001>\u0001>\u0001"+
		">\u0001?\u0004?\u0271\b?\u000b?\f?\u0272\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0003@\u027b\b@\u0001A\u0004A\u027e\bA\u000bA\fA\u027f\u0001"+
		"B\u0001B\u0001B\u0001B\u0001C\u0001C\u0005C\u0288\bC\nC\fC\u028b\tC\u0001"+
		"D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0003D\u0296"+
		"\bD\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001"+
		"H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001K\u0001"+
		"K\u0001K\u0001L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001N\u0001N\u0004"+
		"N\u02b5\bN\u000bN\fN\u02b6\u0001O\u0001O\u0001O\u0005O\u02bc\bO\nO\fO"+
		"\u02bf\tO\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0003"+
		"P\u02c9\bP\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001S\u0001S\u0001"+
		"S\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001V\u0001V\u0001V\u0001"+
		"W\u0001W\u0001W\u0001X\u0001X\u0001X\u0003X\u02e3\bX\u0001X\u0001X\u0003"+
		"X\u02e7\bX\u0001X\u0001X\u0003X\u02eb\bX\u0001X\u0001X\u0003X\u02ef\b"+
		"X\u0001Y\u0001Y\u0001Y\u0005Y\u02f4\bY\nY\fY\u02f7\tY\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0003Z\u02fe\bZ\u0001[\u0004[\u0301\b[\u000b[\f[\u0302"+
		"\u0001\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0004]\u030b\b]\u000b]"+
		"\f]\u030c\u0001^\u0001^\u0001^\u0001^\u0004^\u0313\b^\u000b^\f^\u0314"+
		"\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0003"+
		"_\u0320\b_\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001b\u0001b\u0004"+
		"b\u032a\bb\u000bb\fb\u032b\u0001b\u0001b\u0001c\u0001c\u0001c\u0001c\u0001"+
		"d\u0001d\u0001d\u0001d\u0005d\u0338\bd\nd\fd\u033b\td\u0003d\u033d\bd"+
		"\u0001d\u0001d\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001"+
		"e\u0001e\u0001e\u0003e\u034b\be\u0001f\u0001f\u0001f\u0000\u0001\bg\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4"+
		"\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc"+
		"\u0000\u000b\u0002\u0000ffrr\u0001\u0000gi\u0001\u0000ef\u0001\u0000l"+
		"o\u0001\u0000jk\u0001\u0000sw\u0002\u0000V_\u0081\u0081\u0002\u0000bb"+
		"\u0082\u0082\u0001\u0000\u0084\u0085\u0001\u0000TU\u0003\u0000KMVV__\u0370"+
		"\u0000\u00ce\u0001\u0000\u0000\u0000\u0002\u00d1\u0001\u0000\u0000\u0000"+
		"\u0004\u00ee\u0001\u0000\u0000\u0000\u0006\u00f5\u0001\u0000\u0000\u0000"+
		"\b\u0112\u0001\u0000\u0000\u0000\n\u0138\u0001\u0000\u0000\u0000\f\u013a"+
		"\u0001\u0000\u0000\u0000\u000e\u0141\u0001\u0000\u0000\u0000\u0010\u0147"+
		"\u0001\u0000\u0000\u0000\u0012\u0154\u0001\u0000\u0000\u0000\u0014\u0158"+
		"\u0001\u0000\u0000\u0000\u0016\u015d\u0001\u0000\u0000\u0000\u0018\u0164"+
		"\u0001\u0000\u0000\u0000\u001a\u0172\u0001\u0000\u0000\u0000\u001c\u0189"+
		"\u0001\u0000\u0000\u0000\u001e\u01a1\u0001\u0000\u0000\u0000 \u01a3\u0001"+
		"\u0000\u0000\u0000\"\u01b1\u0001\u0000\u0000\u0000$\u01b3\u0001\u0000"+
		"\u0000\u0000&\u01b6\u0001\u0000\u0000\u0000(\u01b9\u0001\u0000\u0000\u0000"+
		"*\u01bc\u0001\u0000\u0000\u0000,\u01bf\u0001\u0000\u0000\u0000.\u01c2"+
		"\u0001\u0000\u0000\u00000\u01c5\u0001\u0000\u0000\u00002\u01c8\u0001\u0000"+
		"\u0000\u00004\u01ce\u0001\u0000\u0000\u00006\u01e1\u0001\u0000\u0000\u0000"+
		"8\u01e3\u0001\u0000\u0000\u0000:\u01e6\u0001\u0000\u0000\u0000<\u01e9"+
		"\u0001\u0000\u0000\u0000>\u01ec\u0001\u0000\u0000\u0000@\u01ef\u0001\u0000"+
		"\u0000\u0000B\u01f2\u0001\u0000\u0000\u0000D\u01f5\u0001\u0000\u0000\u0000"+
		"F\u01f8\u0001\u0000\u0000\u0000H\u01fb\u0001\u0000\u0000\u0000J\u01fe"+
		"\u0001\u0000\u0000\u0000L\u0201\u0001\u0000\u0000\u0000N\u0207\u0001\u0000"+
		"\u0000\u0000P\u0218\u0001\u0000\u0000\u0000R\u021a\u0001\u0000\u0000\u0000"+
		"T\u021d\u0001\u0000\u0000\u0000V\u0220\u0001\u0000\u0000\u0000X\u0223"+
		"\u0001\u0000\u0000\u0000Z\u0226\u0001\u0000\u0000\u0000\\\u0229\u0001"+
		"\u0000\u0000\u0000^\u022c\u0001\u0000\u0000\u0000`\u022f\u0001\u0000\u0000"+
		"\u0000b\u0232\u0001\u0000\u0000\u0000d\u0238\u0001\u0000\u0000\u0000f"+
		"\u024c\u0001\u0000\u0000\u0000h\u024e\u0001\u0000\u0000\u0000j\u0251\u0001"+
		"\u0000\u0000\u0000l\u0254\u0001\u0000\u0000\u0000n\u0257\u0001\u0000\u0000"+
		"\u0000p\u025a\u0001\u0000\u0000\u0000r\u025d\u0001\u0000\u0000\u0000t"+
		"\u0260\u0001\u0000\u0000\u0000v\u0263\u0001\u0000\u0000\u0000x\u0266\u0001"+
		"\u0000\u0000\u0000z\u0269\u0001\u0000\u0000\u0000|\u026c\u0001\u0000\u0000"+
		"\u0000~\u0270\u0001\u0000\u0000\u0000\u0080\u027a\u0001\u0000\u0000\u0000"+
		"\u0082\u027d\u0001\u0000\u0000\u0000\u0084\u0281\u0001\u0000\u0000\u0000"+
		"\u0086\u0285\u0001\u0000\u0000\u0000\u0088\u0295\u0001\u0000\u0000\u0000"+
		"\u008a\u0297\u0001\u0000\u0000\u0000\u008c\u029a\u0001\u0000\u0000\u0000"+
		"\u008e\u029d\u0001\u0000\u0000\u0000\u0090\u02a0\u0001\u0000\u0000\u0000"+
		"\u0092\u02a3\u0001\u0000\u0000\u0000\u0094\u02a6\u0001\u0000\u0000\u0000"+
		"\u0096\u02a9\u0001\u0000\u0000\u0000\u0098\u02ac\u0001\u0000\u0000\u0000"+
		"\u009a\u02af\u0001\u0000\u0000\u0000\u009c\u02b2\u0001\u0000\u0000\u0000"+
		"\u009e\u02b8\u0001\u0000\u0000\u0000\u00a0\u02c8\u0001\u0000\u0000\u0000"+
		"\u00a2\u02ca\u0001\u0000\u0000\u0000\u00a4\u02cd\u0001\u0000\u0000\u0000"+
		"\u00a6\u02d0\u0001\u0000\u0000\u0000\u00a8\u02d3\u0001\u0000\u0000\u0000"+
		"\u00aa\u02d6\u0001\u0000\u0000\u0000\u00ac\u02d9\u0001\u0000\u0000\u0000"+
		"\u00ae\u02dc\u0001\u0000\u0000\u0000\u00b0\u02df\u0001\u0000\u0000\u0000"+
		"\u00b2\u02f0\u0001\u0000\u0000\u0000\u00b4\u02fd\u0001\u0000\u0000\u0000"+
		"\u00b6\u0300\u0001\u0000\u0000\u0000\u00b8\u0304\u0001\u0000\u0000\u0000"+
		"\u00ba\u0308\u0001\u0000\u0000\u0000\u00bc\u030e\u0001\u0000\u0000\u0000"+
		"\u00be\u031f\u0001\u0000\u0000\u0000\u00c0\u0321\u0001\u0000\u0000\u0000"+
		"\u00c2\u0325\u0001\u0000\u0000\u0000\u00c4\u0327\u0001\u0000\u0000\u0000"+
		"\u00c6\u032f\u0001\u0000\u0000\u0000\u00c8\u0333\u0001\u0000\u0000\u0000"+
		"\u00ca\u034a\u0001\u0000\u0000\u0000\u00cc\u034c\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0003\u0002\u0001\u0000\u00cf\u00d0\u0005\u0000\u0000\u0001"+
		"\u00d0\u0001\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0001\u0000\u0000"+
		"\u00d2\u00d4\u0003 \u0010\u0000\u00d3\u00d5\u0003\u0004\u0002\u0000\u00d4"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d8\u00032\u0019\u0000\u00d7\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00da"+
		"\u0001\u0000\u0000\u0000\u00d9\u00db\u0003\u009cN\u0000\u00da\u00d9\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dd\u0001"+
		"\u0000\u0000\u0000\u00dc\u00de\u0003L&\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000"+
		"\u0000\u00df\u00e1\u0003b1\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e4\u0003\u0086C\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e7"+
		"\u0003\f\u0006\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00ea\u0003"+
		"\u00b0X\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00ed\u0003\u00ba"+
		"]\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u0003\u0001\u0000\u0000\u0000\u00ee\u00f2\u0005\u0002\u0000"+
		"\u0000\u00ef\u00f1\u0003\u0006\u0003\u0000\u00f0\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u0005\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0081\u0000"+
		"\u0000\u00f6\u00f7\u0005~\u0000\u0000\u00f7\u00f8\u0003\b\u0004\u0000"+
		"\u00f8\u0007\u0001\u0000\u0000\u0000\u00f9\u00fa\u0006\u0004\uffff\uffff"+
		"\u0000\u00fa\u0113\u0003\n\u0005\u0000\u00fb\u00fc\u0005\u0081\u0000\u0000"+
		"\u00fc\u0105\u0005x\u0000\u0000\u00fd\u0102\u0003\b\u0004\u0000\u00fe"+
		"\u00ff\u0005\u007f\u0000\u0000\u00ff\u0101\u0003\b\u0004\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0106"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u00fd"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0001\u0000\u0000\u0000\u0107\u0113\u0005y\u0000\u0000\u0108\u0109\u0007"+
		"\u0000\u0000\u0000\u0109\u0113\u0003\b\u0004\b\u010a\u010b\u0005N\u0000"+
		"\u0000\u010b\u010c\u0005x\u0000\u0000\u010c\u010d\u0003\b\u0004\u0000"+
		"\u010d\u010e\u0005y\u0000\u0000\u010e\u010f\u0003\b\u0004\u0000\u010f"+
		"\u0110\u0005O\u0000\u0000\u0110\u0111\u0003\b\u0004\u0001\u0111\u0113"+
		"\u0001\u0000\u0000\u0000\u0112\u00f9\u0001\u0000\u0000\u0000\u0112\u00fb"+
		"\u0001\u0000\u0000\u0000\u0112\u0108\u0001\u0000\u0000\u0000\u0112\u010a"+
		"\u0001\u0000\u0000\u0000\u0113\u012b\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\n\u0007\u0000\u0000\u0115\u0116\u0007\u0001\u0000\u0000\u0116\u012a\u0003"+
		"\b\u0004\b\u0117\u0118\n\u0006\u0000\u0000\u0118\u0119\u0007\u0002\u0000"+
		"\u0000\u0119\u012a\u0003\b\u0004\u0007\u011a\u011b\n\u0005\u0000\u0000"+
		"\u011b\u011c\u0007\u0003\u0000\u0000\u011c\u012a\u0003\b\u0004\u0006\u011d"+
		"\u011e\n\u0004\u0000\u0000\u011e\u011f\u0007\u0004\u0000\u0000\u011f\u012a"+
		"\u0003\b\u0004\u0005\u0120\u0121\n\u0003\u0000\u0000\u0121\u0122\u0005"+
		"p\u0000\u0000\u0122\u012a\u0003\b\u0004\u0004\u0123\u0124\n\u0002\u0000"+
		"\u0000\u0124\u0125\u0005q\u0000\u0000\u0125\u012a\u0003\b\u0004\u0003"+
		"\u0126\u0127\n\n\u0000\u0000\u0127\u0128\u0005\u0080\u0000\u0000\u0128"+
		"\u012a\u0005\u0081\u0000\u0000\u0129\u0114\u0001\u0000\u0000\u0000\u0129"+
		"\u0117\u0001\u0000\u0000\u0000\u0129\u011a\u0001\u0000\u0000\u0000\u0129"+
		"\u011d\u0001\u0000\u0000\u0000\u0129\u0120\u0001\u0000\u0000\u0000\u0129"+
		"\u0123\u0001\u0000\u0000\u0000\u0129\u0126\u0001\u0000\u0000\u0000\u012a"+
		"\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\t\u0001\u0000\u0000\u0000\u012d\u012b"+
		"\u0001\u0000\u0000\u0000\u012e\u0139\u0005\u0085\u0000\u0000\u012f\u0139"+
		"\u0005\u0084\u0000\u0000\u0130\u0139\u0005\u0082\u0000\u0000\u0131\u0139"+
		"\u0005d\u0000\u0000\u0132\u0139\u0005\u0081\u0000\u0000\u0133\u0134\u0005"+
		"x\u0000\u0000\u0134\u0135\u0003\b\u0004\u0000\u0135\u0136\u0005y\u0000"+
		"\u0000\u0136\u0139\u0001\u0000\u0000\u0000\u0137\u0139\u0003\u00c8d\u0000"+
		"\u0138\u012e\u0001\u0000\u0000\u0000\u0138\u012f\u0001\u0000\u0000\u0000"+
		"\u0138\u0130\u0001\u0000\u0000\u0000\u0138\u0131\u0001\u0000\u0000\u0000"+
		"\u0138\u0132\u0001\u0000\u0000\u0000\u0138\u0133\u0001\u0000\u0000\u0000"+
		"\u0138\u0137\u0001\u0000\u0000\u0000\u0139\u000b\u0001\u0000\u0000\u0000"+
		"\u013a\u013e\u0005\u0003\u0000\u0000\u013b\u013d\u0003\u000e\u0007\u0000"+
		"\u013c\u013b\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000\u0000\u0000"+
		"\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000"+
		"\u013f\r\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0005P\u0000\u0000\u0142\u0143\u0005x\u0000\u0000\u0143\u0144\u0003"+
		"\b\u0004\u0000\u0144\u0145\u0005y\u0000\u0000\u0145\u0146\u0003\u0010"+
		"\b\u0000\u0146\u000f\u0001\u0000\u0000\u0000\u0147\u014b\u0005z\u0000"+
		"\u0000\u0148\u014a\u0003\u0012\t\u0000\u0149\u0148\u0001\u0000\u0000\u0000"+
		"\u014a\u014d\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000"+
		"\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014e\u0001\u0000\u0000\u0000"+
		"\u014d\u014b\u0001\u0000\u0000\u0000\u014e\u014f\u0005{\u0000\u0000\u014f"+
		"\u0011\u0001\u0000\u0000\u0000\u0150\u0155\u0003\u0014\n\u0000\u0151\u0155"+
		"\u0003\u0018\f\u0000\u0152\u0155\u0003\u001a\r\u0000\u0153\u0155\u0003"+
		"\u001c\u000e\u0000\u0154\u0150\u0001\u0000\u0000\u0000\u0154\u0151\u0001"+
		"\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0153\u0001"+
		"\u0000\u0000\u0000\u0155\u0013\u0001\u0000\u0000\u0000\u0156\u0159\u0005"+
		"\u0081\u0000\u0000\u0157\u0159\u0003\u0016\u000b\u0000\u0158\u0156\u0001"+
		"\u0000\u0000\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0007\u0005\u0000\u0000\u015b\u015c\u0003"+
		"\b\u0004\u0000\u015c\u0015\u0001\u0000\u0000\u0000\u015d\u0160\u0005\u0081"+
		"\u0000\u0000\u015e\u015f\u0005\u0080\u0000\u0000\u015f\u0161\u0005\u0081"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0017\u0001\u0000\u0000\u0000\u0164\u0165\u0007\u0006"+
		"\u0000\u0000\u0165\u016e\u0005x\u0000\u0000\u0166\u016b\u0003\b\u0004"+
		"\u0000\u0167\u0168\u0005\u007f\u0000\u0000\u0168\u016a\u0003\b\u0004\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u016a\u016d\u0001\u0000\u0000\u0000"+
		"\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000"+
		"\u016c\u016f\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000"+
		"\u016e\u0166\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0005y\u0000\u0000\u0171"+
		"\u0019\u0001\u0000\u0000\u0000\u0172\u0173\u0005N\u0000\u0000\u0173\u0174"+
		"\u0005x\u0000\u0000\u0174\u0175\u0003\b\u0004\u0000\u0175\u0176\u0005"+
		"y\u0000\u0000\u0176\u017c\u0003\u0010\b\u0000\u0177\u017a\u0005O\u0000"+
		"\u0000\u0178\u017b\u0003\u001a\r\u0000\u0179\u017b\u0003\u0010\b\u0000"+
		"\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u0179\u0001\u0000\u0000\u0000"+
		"\u017b\u017d\u0001\u0000\u0000\u0000\u017c\u0177\u0001\u0000\u0000\u0000"+
		"\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u001b\u0001\u0000\u0000\u0000"+
		"\u017e\u017f\u0005Q\u0000\u0000\u017f\u0180\u0005\u0085\u0000\u0000\u0180"+
		"\u018a\u0003\u0010\b\u0000\u0181\u0182\u0005Q\u0000\u0000\u0182\u0183"+
		"\u0005\u0081\u0000\u0000\u0183\u0184\u0005R\u0000\u0000\u0184\u0185\u0003"+
		"\b\u0004\u0000\u0185\u0186\u0005S\u0000\u0000\u0186\u0187\u0003\b\u0004"+
		"\u0000\u0187\u0188\u0003\u0010\b\u0000\u0188\u018a\u0001\u0000\u0000\u0000"+
		"\u0189\u017e\u0001\u0000\u0000\u0000\u0189\u0181\u0001\u0000\u0000\u0000"+
		"\u018a\u001d\u0001\u0000\u0000\u0000\u018b\u018c\u0005\u0004\u0000\u0000"+
		"\u018c\u01a2\u0003\u0010\b\u0000\u018d\u018e\u0005\u0005\u0000\u0000\u018e"+
		"\u01a2\u0003\u0010\b\u0000\u018f\u0190\u0005\u0006\u0000\u0000\u0190\u01a2"+
		"\u0003\u0010\b\u0000\u0191\u0192\u0005\u0007\u0000\u0000\u0192\u01a2\u0003"+
		"\u0010\b\u0000\u0193\u0194\u0005\b\u0000\u0000\u0194\u01a2\u0003\u0010"+
		"\b\u0000\u0195\u0196\u0005\t\u0000\u0000\u0196\u01a2\u0003\u0010\b\u0000"+
		"\u0197\u0198\u0005\n\u0000\u0000\u0198\u01a2\u0003\u0010\b\u0000\u0199"+
		"\u019a\u0005\u000b\u0000\u0000\u019a\u01a2\u0003\u0010\b\u0000\u019b\u019c"+
		"\u0005\f\u0000\u0000\u019c\u01a2\u0003\u0010\b\u0000\u019d\u019e\u0005"+
		"\r\u0000\u0000\u019e\u01a2\u0003\u0010\b\u0000\u019f\u01a0\u0005\u000e"+
		"\u0000\u0000\u01a0\u01a2\u0003\u0010\b\u0000\u01a1\u018b\u0001\u0000\u0000"+
		"\u0000\u01a1\u018d\u0001\u0000\u0000\u0000\u01a1\u018f\u0001\u0000\u0000"+
		"\u0000\u01a1\u0191\u0001\u0000\u0000\u0000\u01a1\u0193\u0001\u0000\u0000"+
		"\u0000\u01a1\u0195\u0001\u0000\u0000\u0000\u01a1\u0197\u0001\u0000\u0000"+
		"\u0000\u01a1\u0199\u0001\u0000\u0000\u0000\u01a1\u019b\u0001\u0000\u0000"+
		"\u0000\u01a1\u019d\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000"+
		"\u0000\u01a2\u001f\u0001\u0000\u0000\u0000\u01a3\u01a7\u0005\u000f\u0000"+
		"\u0000\u01a4\u01a6\u0003\"\u0011\u0000\u01a5\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8!\u0001\u0000\u0000\u0000\u01a9"+
		"\u01a7\u0001\u0000\u0000\u0000\u01aa\u01b2\u0003$\u0012\u0000\u01ab\u01b2"+
		"\u0003&\u0013\u0000\u01ac\u01b2\u0003(\u0014\u0000\u01ad\u01b2\u0003*"+
		"\u0015\u0000\u01ae\u01b2\u0003,\u0016\u0000\u01af\u01b2\u0003.\u0017\u0000"+
		"\u01b0\u01b2\u00030\u0018\u0000\u01b1\u01aa\u0001\u0000\u0000\u0000\u01b1"+
		"\u01ab\u0001\u0000\u0000\u0000\u01b1\u01ac\u0001\u0000\u0000\u0000\u01b1"+
		"\u01ad\u0001\u0000\u0000\u0000\u01b1\u01ae\u0001\u0000\u0000\u0000\u01b1"+
		"\u01af\u0001\u0000\u0000\u0000\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b2"+
		"#\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005\u0010\u0000\u0000\u01b4\u01b5"+
		"\u0005\u0082\u0000\u0000\u01b5%\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005"+
		"\u0011\u0000\u0000\u01b7\u01b8\u0005\u0082\u0000\u0000\u01b8\'\u0001\u0000"+
		"\u0000\u0000\u01b9\u01ba\u0005\u0012\u0000\u0000\u01ba\u01bb\u0005\u0082"+
		"\u0000\u0000\u01bb)\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u0013\u0000"+
		"\u0000\u01bd\u01be\u0005\u0085\u0000\u0000\u01be+\u0001\u0000\u0000\u0000"+
		"\u01bf\u01c0\u0005\u0014\u0000\u0000\u01c0\u01c1\u0005d\u0000\u0000\u01c1"+
		"-\u0001\u0000\u0000\u0000\u01c2\u01c3\u0005\u0015\u0000\u0000\u01c3\u01c4"+
		"\u0005\u0085\u0000\u0000\u01c4/\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005"+
		"\u0016\u0000\u0000\u01c6\u01c7\u0005\u0084\u0000\u0000\u01c71\u0001\u0000"+
		"\u0000\u0000\u01c8\u01ca\u0005\u0017\u0000\u0000\u01c9\u01cb\u00034\u001a"+
		"\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cd3\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005\u0081\u0000\u0000"+
		"\u01cf\u01d3\u0005~\u0000\u0000\u01d0\u01d2\u00036\u001b\u0000\u01d1\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000\u0000\u0000\u01d3\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d45\u0001"+
		"\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d6\u01e2\u0003"+
		"8\u001c\u0000\u01d7\u01e2\u0003:\u001d\u0000\u01d8\u01e2\u0003<\u001e"+
		"\u0000\u01d9\u01e2\u0003>\u001f\u0000\u01da\u01e2\u0003@ \u0000\u01db"+
		"\u01e2\u0003B!\u0000\u01dc\u01e2\u0003D\"\u0000\u01dd\u01e2\u0003F#\u0000"+
		"\u01de\u01e2\u0003H$\u0000\u01df\u01e2\u0003J%\u0000\u01e0\u01e2\u0003"+
		"\u001e\u000f\u0000\u01e1\u01d6\u0001\u0000\u0000\u0000\u01e1\u01d7\u0001"+
		"\u0000\u0000\u0000\u01e1\u01d8\u0001\u0000\u0000\u0000\u01e1\u01d9\u0001"+
		"\u0000\u0000\u0000\u01e1\u01da\u0001\u0000\u0000\u0000\u01e1\u01db\u0001"+
		"\u0000\u0000\u0000\u01e1\u01dc\u0001\u0000\u0000\u0000\u01e1\u01dd\u0001"+
		"\u0000\u0000\u0000\u01e1\u01de\u0001\u0000\u0000\u0000\u01e1\u01df\u0001"+
		"\u0000\u0000\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e27\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e4\u0005\u0011\u0000\u0000\u01e4\u01e5\u0005\u0082"+
		"\u0000\u0000\u01e59\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005\u0018\u0000"+
		"\u0000\u01e7\u01e8\u0005\u0085\u0000\u0000\u01e8;\u0001\u0000\u0000\u0000"+
		"\u01e9\u01ea\u0005\u0019\u0000\u0000\u01ea\u01eb\u0005\u0085\u0000\u0000"+
		"\u01eb=\u0001\u0000\u0000\u0000\u01ec\u01ed\u0005\u001a\u0000\u0000\u01ed"+
		"\u01ee\u0005\u0085\u0000\u0000\u01ee?\u0001\u0000\u0000\u0000\u01ef\u01f0"+
		"\u0005\u001b\u0000\u0000\u01f0\u01f1\u0005\u0085\u0000\u0000\u01f1A\u0001"+
		"\u0000\u0000\u0000\u01f2\u01f3\u0005\u001c\u0000\u0000\u01f3\u01f4\u0003"+
		"\u00ccf\u0000\u01f4C\u0001\u0000\u0000\u0000\u01f5\u01f6\u0005\u001d\u0000"+
		"\u0000\u01f6\u01f7\u0003\u00c8d\u0000\u01f7E\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0005\u001e\u0000\u0000\u01f9\u01fa\u0003\u00c8d\u0000\u01faG\u0001"+
		"\u0000\u0000\u0000\u01fb\u01fc\u0005\u001f\u0000\u0000\u01fc\u01fd\u0003"+
		"\u00c8d\u0000\u01fdI\u0001\u0000\u0000\u0000\u01fe\u01ff\u0005 \u0000"+
		"\u0000\u01ff\u0200\u0005\u0081\u0000\u0000\u0200K\u0001\u0000\u0000\u0000"+
		"\u0201\u0203\u0005\u001d\u0000\u0000\u0202\u0204\u0003N\'\u0000\u0203"+
		"\u0202\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205"+
		"\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000\u0000\u0206"+
		"M\u0001\u0000\u0000\u0000\u0207\u0208\u0005\u0081\u0000\u0000\u0208\u020c"+
		"\u0005~\u0000\u0000\u0209\u020b\u0003P(\u0000\u020a\u0209\u0001\u0000"+
		"\u0000\u0000\u020b\u020e\u0001\u0000\u0000\u0000\u020c\u020a\u0001\u0000"+
		"\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020dO\u0001\u0000\u0000"+
		"\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020f\u0219\u0003R)\u0000\u0210"+
		"\u0219\u0003T*\u0000\u0211\u0219\u0003V+\u0000\u0212\u0219\u0003X,\u0000"+
		"\u0213\u0219\u0003Z-\u0000\u0214\u0219\u0003\\.\u0000\u0215\u0219\u0003"+
		"^/\u0000\u0216\u0219\u0003`0\u0000\u0217\u0219\u0003\u001e\u000f\u0000"+
		"\u0218\u020f\u0001\u0000\u0000\u0000\u0218\u0210\u0001\u0000\u0000\u0000"+
		"\u0218\u0211\u0001\u0000\u0000\u0000\u0218\u0212\u0001\u0000\u0000\u0000"+
		"\u0218\u0213\u0001\u0000\u0000\u0000\u0218\u0214\u0001\u0000\u0000\u0000"+
		"\u0218\u0215\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000"+
		"\u0218\u0217\u0001\u0000\u0000\u0000\u0219Q\u0001\u0000\u0000\u0000\u021a"+
		"\u021b\u0005\u0011\u0000\u0000\u021b\u021c\u0005\u0082\u0000\u0000\u021c"+
		"S\u0001\u0000\u0000\u0000\u021d\u021e\u0005!\u0000\u0000\u021e\u021f\u0007"+
		"\u0007\u0000\u0000\u021fU\u0001\u0000\u0000\u0000\u0220\u0221\u0005\""+
		"\u0000\u0000\u0221\u0222\u0005\u0082\u0000\u0000\u0222W\u0001\u0000\u0000"+
		"\u0000\u0223\u0224\u0005#\u0000\u0000\u0224\u0225\u0003\u00c4b\u0000\u0225"+
		"Y\u0001\u0000\u0000\u0000\u0226\u0227\u0005$\u0000\u0000\u0227\u0228\u0005"+
		"\u0081\u0000\u0000\u0228[\u0001\u0000\u0000\u0000\u0229\u022a\u0005%\u0000"+
		"\u0000\u022a\u022b\u0005d\u0000\u0000\u022b]\u0001\u0000\u0000\u0000\u022c"+
		"\u022d\u0005&\u0000\u0000\u022d\u022e\u0005d\u0000\u0000\u022e_\u0001"+
		"\u0000\u0000\u0000\u022f\u0230\u0005\'\u0000\u0000\u0230\u0231\u0005\u0082"+
		"\u0000\u0000\u0231a\u0001\u0000\u0000\u0000\u0232\u0234\u0005\u001e\u0000"+
		"\u0000\u0233\u0235\u0003d2\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0235"+
		"\u0236\u0001\u0000\u0000\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u0001\u0000\u0000\u0000\u0237c\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0005\u0081\u0000\u0000\u0239\u023d\u0005~\u0000\u0000\u023a\u023c\u0003"+
		"f3\u0000\u023b\u023a\u0001\u0000\u0000\u0000\u023c\u023f\u0001\u0000\u0000"+
		"\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000"+
		"\u0000\u023ee\u0001\u0000\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000"+
		"\u0240\u024d\u0003h4\u0000\u0241\u024d\u0003j5\u0000\u0242\u024d\u0003"+
		"l6\u0000\u0243\u024d\u0003n7\u0000\u0244\u024d\u0003p8\u0000\u0245\u024d"+
		"\u0003r9\u0000\u0246\u024d\u0003t:\u0000\u0247\u024d\u0003v;\u0000\u0248"+
		"\u024d\u0003x<\u0000\u0249\u024d\u0003z=\u0000\u024a\u024d\u0003|>\u0000"+
		"\u024b\u024d\u0003\u001e\u000f\u0000\u024c\u0240\u0001\u0000\u0000\u0000"+
		"\u024c\u0241\u0001\u0000\u0000\u0000\u024c\u0242\u0001\u0000\u0000\u0000"+
		"\u024c\u0243\u0001\u0000\u0000\u0000\u024c\u0244\u0001\u0000\u0000\u0000"+
		"\u024c\u0245\u0001\u0000\u0000\u0000\u024c\u0246\u0001\u0000\u0000\u0000"+
		"\u024c\u0247\u0001\u0000\u0000\u0000\u024c\u0248\u0001\u0000\u0000\u0000"+
		"\u024c\u0249\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000\u0000\u0000"+
		"\u024c\u024b\u0001\u0000\u0000\u0000\u024dg\u0001\u0000\u0000\u0000\u024e"+
		"\u024f\u0005\u0011\u0000\u0000\u024f\u0250\u0005\u0082\u0000\u0000\u0250"+
		"i\u0001\u0000\u0000\u0000\u0251\u0252\u0005\"\u0000\u0000\u0252\u0253"+
		"\u0005\u0082\u0000\u0000\u0253k\u0001\u0000\u0000\u0000\u0254\u0255\u0005"+
		"$\u0000\u0000\u0255\u0256\u0005\u0081\u0000\u0000\u0256m\u0001\u0000\u0000"+
		"\u0000\u0257\u0258\u0005(\u0000\u0000\u0258\u0259\u0003~?\u0000\u0259"+
		"o\u0001\u0000\u0000\u0000\u025a\u025b\u0005)\u0000\u0000\u025b\u025c\u0003"+
		"\u00c8d\u0000\u025cq\u0001\u0000\u0000\u0000\u025d\u025e\u0005*\u0000"+
		"\u0000\u025e\u025f\u0003\u00c8d\u0000\u025fs\u0001\u0000\u0000\u0000\u0260"+
		"\u0261\u0005+\u0000\u0000\u0261\u0262\u0005\u0085\u0000\u0000\u0262u\u0001"+
		"\u0000\u0000\u0000\u0263\u0264\u0005,\u0000\u0000\u0264\u0265\u0005\u0085"+
		"\u0000\u0000\u0265w\u0001\u0000\u0000\u0000\u0266\u0267\u0005-\u0000\u0000"+
		"\u0267\u0268\u0005d\u0000\u0000\u0268y\u0001\u0000\u0000\u0000\u0269\u026a"+
		"\u0005.\u0000\u0000\u026a\u026b\u0005\u0085\u0000\u0000\u026b{\u0001\u0000"+
		"\u0000\u0000\u026c\u026d\u0005/\u0000\u0000\u026d\u026e\u0005\u0085\u0000"+
		"\u0000\u026e}\u0001\u0000\u0000\u0000\u026f\u0271\u0003\u0080@\u0000\u0270"+
		"\u026f\u0001\u0000\u0000\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272"+
		"\u0270\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000\u0000\u0273"+
		"\u007f\u0001\u0000\u0000\u0000\u0274\u0275\u00050\u0000\u0000\u0275\u027b"+
		"\u0005\u0082\u0000\u0000\u0276\u0277\u00051\u0000\u0000\u0277\u027b\u0005"+
		"\u0082\u0000\u0000\u0278\u0279\u00052\u0000\u0000\u0279\u027b\u0003\u0082"+
		"A\u0000\u027a\u0274\u0001\u0000\u0000\u0000\u027a\u0276\u0001\u0000\u0000"+
		"\u0000\u027a\u0278\u0001\u0000\u0000\u0000\u027b\u0081\u0001\u0000\u0000"+
		"\u0000\u027c\u027e\u0003\u0084B\u0000\u027d\u027c\u0001\u0000\u0000\u0000"+
		"\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u027d\u0001\u0000\u0000\u0000"+
		"\u027f\u0280\u0001\u0000\u0000\u0000\u0280\u0083\u0001\u0000\u0000\u0000"+
		"\u0281\u0282\u0005\u0081\u0000\u0000\u0282\u0283\u0005~\u0000\u0000\u0283"+
		"\u0284\u0005\u0082\u0000\u0000\u0284\u0085\u0001\u0000\u0000\u0000\u0285"+
		"\u0289\u00053\u0000\u0000\u0286\u0288\u0003\u0088D\u0000\u0287\u0286\u0001"+
		"\u0000\u0000\u0000\u0288\u028b\u0001\u0000\u0000\u0000\u0289\u0287\u0001"+
		"\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u0087\u0001"+
		"\u0000\u0000\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028c\u0296\u0003"+
		"\u008aE\u0000\u028d\u0296\u0003\u008cF\u0000\u028e\u0296\u0003\u008eG"+
		"\u0000\u028f\u0296\u0003\u0090H\u0000\u0290\u0296\u0003\u0092I\u0000\u0291"+
		"\u0296\u0003\u0094J\u0000\u0292\u0296\u0003\u0096K\u0000\u0293\u0296\u0003"+
		"\u0098L\u0000\u0294\u0296\u0003\u009aM\u0000\u0295\u028c\u0001\u0000\u0000"+
		"\u0000\u0295\u028d\u0001\u0000\u0000\u0000\u0295\u028e\u0001\u0000\u0000"+
		"\u0000\u0295\u028f\u0001\u0000\u0000\u0000\u0295\u0290\u0001\u0000\u0000"+
		"\u0000\u0295\u0291\u0001\u0000\u0000\u0000\u0295\u0292\u0001\u0000\u0000"+
		"\u0000\u0295\u0293\u0001\u0000\u0000\u0000\u0295\u0294\u0001\u0000\u0000"+
		"\u0000\u0296\u0089\u0001\u0000\u0000\u0000\u0297\u0298\u00054\u0000\u0000"+
		"\u0298\u0299\u0005c\u0000\u0000\u0299\u008b\u0001\u0000\u0000\u0000\u029a"+
		"\u029b\u0005+\u0000\u0000\u029b\u029c\u0005\u0085\u0000\u0000\u029c\u008d"+
		"\u0001\u0000\u0000\u0000\u029d\u029e\u0005,\u0000\u0000\u029e\u029f\u0005"+
		"\u0085\u0000\u0000\u029f\u008f\u0001\u0000\u0000\u0000\u02a0\u02a1\u0005"+
		".\u0000\u0000\u02a1\u02a2\u0005\u0085\u0000\u0000\u02a2\u0091\u0001\u0000"+
		"\u0000\u0000\u02a3\u02a4\u00055\u0000\u0000\u02a4\u02a5\u0005\u0085\u0000"+
		"\u0000\u02a5\u0093\u0001\u0000\u0000\u0000\u02a6\u02a7\u00056\u0000\u0000"+
		"\u02a7\u02a8\u0005\u0085\u0000\u0000\u02a8\u0095\u0001\u0000\u0000\u0000"+
		"\u02a9\u02aa\u00057\u0000\u0000\u02aa\u02ab\u0007\b\u0000\u0000\u02ab"+
		"\u0097\u0001\u0000\u0000\u0000\u02ac\u02ad\u00058\u0000\u0000\u02ad\u02ae"+
		"\u0007\b\u0000\u0000\u02ae\u0099\u0001\u0000\u0000\u0000\u02af\u02b0\u0005"+
		"9\u0000\u0000\u02b0\u02b1\u0007\b\u0000\u0000\u02b1\u009b\u0001\u0000"+
		"\u0000\u0000\u02b2\u02b4\u0005:\u0000\u0000\u02b3\u02b5\u0003\u009eO\u0000"+
		"\u02b4\u02b3\u0001\u0000\u0000\u0000\u02b5\u02b6\u0001\u0000\u0000\u0000"+
		"\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000\u0000"+
		"\u02b7\u009d\u0001\u0000\u0000\u0000\u02b8\u02b9\u0005\u0081\u0000\u0000"+
		"\u02b9\u02bd\u0005~\u0000\u0000\u02ba\u02bc\u0003\u00a0P\u0000\u02bb\u02ba"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bf\u0001\u0000\u0000\u0000\u02bd\u02bb"+
		"\u0001\u0000\u0000\u0000\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u009f"+
		"\u0001\u0000\u0000\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000\u02c0\u02c9"+
		"\u0003\u00a2Q\u0000\u02c1\u02c9\u0003\u00a4R\u0000\u02c2\u02c9\u0003\u00a6"+
		"S\u0000\u02c3\u02c9\u0003\u00a8T\u0000\u02c4\u02c9\u0003\u00aaU\u0000"+
		"\u02c5\u02c9\u0003\u00acV\u0000\u02c6\u02c9\u0003\u00aeW\u0000\u02c7\u02c9"+
		"\u0003\u001e\u000f\u0000\u02c8\u02c0\u0001\u0000\u0000\u0000\u02c8\u02c1"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c2\u0001\u0000\u0000\u0000\u02c8\u02c3"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c4\u0001\u0000\u0000\u0000\u02c8\u02c5"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000\u02c8\u02c7"+
		"\u0001\u0000\u0000\u0000\u02c9\u00a1\u0001\u0000\u0000\u0000\u02ca\u02cb"+
		"\u0005!\u0000\u0000\u02cb\u02cc\u0005`\u0000\u0000\u02cc\u00a3\u0001\u0000"+
		"\u0000\u0000\u02cd\u02ce\u0005;\u0000\u0000\u02ce\u02cf\u0005\u0082\u0000"+
		"\u0000\u02cf\u00a5\u0001\u0000\u0000\u0000\u02d0\u02d1\u0005<\u0000\u0000"+
		"\u02d1\u02d2\u0003\u00c8d\u0000\u02d2\u00a7\u0001\u0000\u0000\u0000\u02d3"+
		"\u02d4\u0005=\u0000\u0000\u02d4\u02d5\u0003\u00c8d\u0000\u02d5\u00a9\u0001"+
		"\u0000\u0000\u0000\u02d6\u02d7\u0005>\u0000\u0000\u02d7\u02d8\u0005\u0082"+
		"\u0000\u0000\u02d8\u00ab\u0001\u0000\u0000\u0000\u02d9\u02da\u0005?\u0000"+
		"\u0000\u02da\u02db\u0005\u0081\u0000\u0000\u02db\u00ad\u0001\u0000\u0000"+
		"\u0000\u02dc\u02dd\u0005@\u0000\u0000\u02dd\u02de\u0005\u0081\u0000\u0000"+
		"\u02de\u00af\u0001\u0000\u0000\u0000\u02df\u02e2\u0005A\u0000\u0000\u02e0"+
		"\u02e1\u0005B\u0000\u0000\u02e1\u02e3\u0003\u00b2Y\u0000\u02e2\u02e0\u0001"+
		"\u0000\u0000\u0000\u02e2\u02e3\u0001\u0000\u0000\u0000\u02e3\u02e6\u0001"+
		"\u0000\u0000\u0000\u02e4\u02e5\u0005C\u0000\u0000\u02e5\u02e7\u0003\u00b6"+
		"[\u0000\u02e6\u02e4\u0001\u0000\u0000\u0000\u02e6\u02e7\u0001\u0000\u0000"+
		"\u0000\u02e7\u02ea\u0001\u0000\u0000\u0000\u02e8\u02e9\u0005D\u0000\u0000"+
		"\u02e9\u02eb\u0003\u00c4b\u0000\u02ea\u02e8\u0001\u0000\u0000\u0000\u02ea"+
		"\u02eb\u0001\u0000\u0000\u0000\u02eb\u02ee\u0001\u0000\u0000\u0000\u02ec"+
		"\u02ed\u0005E\u0000\u0000\u02ed\u02ef\u0003\u00c4b\u0000\u02ee\u02ec\u0001"+
		"\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000\u02ef\u00b1\u0001"+
		"\u0000\u0000\u0000\u02f0\u02f5\u0003\u00b4Z\u0000\u02f1\u02f2\u0007\t"+
		"\u0000\u0000\u02f2\u02f4\u0003\u00b4Z\u0000\u02f3\u02f1\u0001\u0000\u0000"+
		"\u0000\u02f4\u02f7\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001\u0000\u0000"+
		"\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000\u02f6\u00b3\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f5\u0001\u0000\u0000\u0000\u02f8\u02fe\u0005\u0081\u0000"+
		"\u0000\u02f9\u02fa\u0005x\u0000\u0000\u02fa\u02fb\u0003\u00b2Y\u0000\u02fb"+
		"\u02fc\u0005y\u0000\u0000\u02fc\u02fe\u0001\u0000\u0000\u0000\u02fd\u02f8"+
		"\u0001\u0000\u0000\u0000\u02fd\u02f9\u0001\u0000\u0000\u0000\u02fe\u00b5"+
		"\u0001\u0000\u0000\u0000\u02ff\u0301\u0003\u00b8\\\u0000\u0300\u02ff\u0001"+
		"\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0300\u0001"+
		"\u0000\u0000\u0000\u0302\u0303\u0001\u0000\u0000\u0000\u0303\u00b7\u0001"+
		"\u0000\u0000\u0000\u0304\u0305\u0005\u0081\u0000\u0000\u0305\u0306\u0005"+
		"~\u0000\u0000\u0306\u0307\u0005\u0081\u0000\u0000\u0307\u00b9\u0001\u0000"+
		"\u0000\u0000\u0308\u030a\u0005F\u0000\u0000\u0309\u030b\u0003\u00bc^\u0000"+
		"\u030a\u0309\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000"+
		"\u030c\u030a\u0001\u0000\u0000\u0000\u030c\u030d\u0001\u0000\u0000\u0000"+
		"\u030d\u00bb\u0001\u0000\u0000\u0000\u030e\u030f\u0003\u00be_\u0000\u030f"+
		"\u0310\u0005~\u0000\u0000\u0310\u0312\u0005G\u0000\u0000\u0311\u0313\u0003"+
		"\u00c0`\u0000\u0312\u0311\u0001\u0000\u0000\u0000\u0313\u0314\u0001\u0000"+
		"\u0000\u0000\u0314\u0312\u0001\u0000\u0000\u0000\u0314\u0315\u0001\u0000"+
		"\u0000\u0000\u0315\u00bd\u0001\u0000\u0000\u0000\u0316\u0317\u0005H\u0000"+
		"\u0000\u0317\u0318\u0005~\u0000\u0000\u0318\u0320\u0005\u0081\u0000\u0000"+
		"\u0319\u031a\u0005I\u0000\u0000\u031a\u031b\u0005~\u0000\u0000\u031b\u0320"+
		"\u0005\u0081\u0000\u0000\u031c\u031d\u0005J\u0000\u0000\u031d\u031e\u0005"+
		"~\u0000\u0000\u031e\u0320\u0005\u0085\u0000\u0000\u031f\u0316\u0001\u0000"+
		"\u0000\u0000\u031f\u0319\u0001\u0000\u0000\u0000\u031f\u031c\u0001\u0000"+
		"\u0000\u0000\u0320\u00bf\u0001\u0000\u0000\u0000\u0321\u0322\u0003\u00c2"+
		"a\u0000\u0322\u0323\u0005~\u0000\u0000\u0323\u0324\u0003\u00cae\u0000"+
		"\u0324\u00c1\u0001\u0000\u0000\u0000\u0325\u0326\u0007\n\u0000\u0000\u0326"+
		"\u00c3\u0001\u0000\u0000\u0000\u0327\u0329\u0005z\u0000\u0000\u0328\u032a"+
		"\u0003\u00c6c\u0000\u0329\u0328\u0001\u0000\u0000\u0000\u032a\u032b\u0001"+
		"\u0000\u0000\u0000\u032b\u0329\u0001\u0000\u0000\u0000\u032b\u032c\u0001"+
		"\u0000\u0000\u0000\u032c\u032d\u0001\u0000\u0000\u0000\u032d\u032e\u0005"+
		"{\u0000\u0000\u032e\u00c5\u0001\u0000\u0000\u0000\u032f\u0330\u0005\u0081"+
		"\u0000\u0000\u0330\u0331\u0005~\u0000\u0000\u0331\u0332\u0003\u00cae\u0000"+
		"\u0332\u00c7\u0001\u0000\u0000\u0000\u0333\u033c\u0005|\u0000\u0000\u0334"+
		"\u0339\u0003\u00cae\u0000\u0335\u0336\u0005\u007f\u0000\u0000\u0336\u0338"+
		"\u0003\u00cae\u0000\u0337\u0335\u0001\u0000\u0000\u0000\u0338\u033b\u0001"+
		"\u0000\u0000\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u0339\u033a\u0001"+
		"\u0000\u0000\u0000\u033a\u033d\u0001\u0000\u0000\u0000\u033b\u0339\u0001"+
		"\u0000\u0000\u0000\u033c\u0334\u0001\u0000\u0000\u0000\u033c\u033d\u0001"+
		"\u0000\u0000\u0000\u033d\u033e\u0001\u0000\u0000\u0000\u033e\u033f\u0005"+
		"}\u0000\u0000\u033f\u00c9\u0001\u0000\u0000\u0000\u0340\u034b\u0005\u0082"+
		"\u0000\u0000\u0341\u034b\u0005\u0084\u0000\u0000\u0342\u034b\u0005\u0085"+
		"\u0000\u0000\u0343\u034b\u0005d\u0000\u0000\u0344\u034b\u0005b\u0000\u0000"+
		"\u0345\u034b\u0005`\u0000\u0000\u0346\u034b\u0005a\u0000\u0000\u0347\u034b"+
		"\u0005\u0081\u0000\u0000\u0348\u034b\u0003\u00c8d\u0000\u0349\u034b\u0003"+
		"\u00c4b\u0000\u034a\u0340\u0001\u0000\u0000\u0000\u034a\u0341\u0001\u0000"+
		"\u0000\u0000\u034a\u0342\u0001\u0000\u0000\u0000\u034a\u0343\u0001\u0000"+
		"\u0000\u0000\u034a\u0344\u0001\u0000\u0000\u0000\u034a\u0345\u0001\u0000"+
		"\u0000\u0000\u034a\u0346\u0001\u0000\u0000\u0000\u034a\u0347\u0001\u0000"+
		"\u0000\u0000\u034a\u0348\u0001\u0000\u0000\u0000\u034a\u0349\u0001\u0000"+
		"\u0000\u0000\u034b\u00cb\u0001\u0000\u0000\u0000\u034c\u034d\u0005\u0083"+
		"\u0000\u0000\u034d\u00cd\u0001\u0000\u0000\u0000<\u00d4\u00d7\u00da\u00dd"+
		"\u00e0\u00e3\u00e6\u00e9\u00ec\u00f2\u0102\u0105\u0112\u0129\u012b\u0138"+
		"\u013e\u014b\u0154\u0158\u0162\u016b\u016e\u017a\u017c\u0189\u01a1\u01a7"+
		"\u01b1\u01cc\u01d3\u01e1\u0205\u020c\u0218\u0236\u023d\u024c\u0272\u027a"+
		"\u027f\u0289\u0295\u02b6\u02bd\u02c8\u02e2\u02e6\u02ea\u02ee\u02f5\u02fd"+
		"\u0302\u030c\u0314\u031f\u032b\u0339\u033c\u034a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}