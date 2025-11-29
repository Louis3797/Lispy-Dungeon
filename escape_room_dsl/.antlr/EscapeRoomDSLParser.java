// Generated from c:/Users/kaist/Documents/IDE-workspaces/vs-workspace/Louis/Lispy-Dungeon/escape_room_dsl/EscapeRoomDSL.g4 by ANTLR 4.13.1
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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, PLAYER_CLASS=31, 
		BOOLEAN=32, ID=33, STRING=34, MULTILINE_STRING=35, FLOAT=36, INT=37, WS=38, 
		COMMENT=39;
	public static final int
		RULE_start = 0, RULE_escape_room = 1, RULE_metadata = 2, RULE_metadata_property = 3, 
		RULE_title_property = 4, RULE_description_property = 5, RULE_difficulty_property = 6, 
		RULE_max_time_property = 7, RULE_fog_of_war_property = 8, RULE_view_distance_property = 9, 
		RULE_camera_zoom_property = 10, RULE_rooms = 11, RULE_room = 12, RULE_room_property = 13, 
		RULE_room_description_property = 14, RULE_room_x_property = 15, RULE_room_y_property = 16, 
		RULE_room_width_property = 17, RULE_room_height_property = 18, RULE_room_pattern_property = 19, 
		RULE_room_connections_property = 20, RULE_player = 21, RULE_player_property = 22, 
		RULE_player_class_property = 23, RULE_player_start_x_property = 24, RULE_player_start_y_property = 25, 
		RULE_player_health_property = 26, RULE_player_mana_property = 27, RULE_player_stamina_property = 28, 
		RULE_player_speed_property = 29, RULE_player_mana_restore_property = 30, 
		RULE_player_stamina_restore_property = 31, RULE_array = 32, RULE_value = 33, 
		RULE_multiline_string = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "escape_room", "metadata", "metadata_property", "title_property", 
			"description_property", "difficulty_property", "max_time_property", "fog_of_war_property", 
			"view_distance_property", "camera_zoom_property", "rooms", "room", "room_property", 
			"room_description_property", "room_x_property", "room_y_property", "room_width_property", 
			"room_height_property", "room_pattern_property", "room_connections_property", 
			"player", "player_property", "player_class_property", "player_start_x_property", 
			"player_start_y_property", "player_health_property", "player_mana_property", 
			"player_stamina_property", "player_speed_property", "player_mana_restore_property", 
			"player_stamina_restore_property", "array", "value", "multiline_string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'escape_room:'", "'metadata:'", "'title:'", "'description:'", 
			"'difficulty:'", "'max_time:'", "'fog_of_war:'", "'view_distance:'", 
			"'camera_zoom:'", "'rooms:'", "':'", "'x:'", "'y:'", "'width:'", "'height:'", 
			"'pattern:'", "'connections:'", "'player:'", "'class:'", "'start_x:'", 
			"'start_y:'", "'health:'", "'mana:'", "'stamina:'", "'speed:'", "'mana_restore:'", 
			"'stamina_restore:'", "'['", "','", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "PLAYER_CLASS", "BOOLEAN", 
			"ID", "STRING", "MULTILINE_STRING", "FLOAT", "INT", "WS", "COMMENT"
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
			setState(70);
			escape_room();
			setState(71);
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
		public PlayerContext player() {
			return getRuleContext(PlayerContext.class,0);
		}
		public Escape_roomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape_room; }
	}

	public final Escape_roomContext escape_room() throws RecognitionException {
		Escape_roomContext _localctx = new Escape_roomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_escape_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__0);
			setState(74);
			metadata();
			setState(75);
			rooms();
			setState(76);
			player();
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
			setState(78);
			match(T__1);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0)) {
				{
				{
				setState(79);
				metadata_property();
				}
				}
				setState(84);
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
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				title_property();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				description_property();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				difficulty_property();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				max_time_property();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				fog_of_war_property();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				view_distance_property();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(91);
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
			setState(94);
			match(T__2);
			setState(95);
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
			setState(97);
			match(T__3);
			setState(98);
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
			setState(100);
			match(T__4);
			setState(101);
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
			setState(103);
			match(T__5);
			setState(104);
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
			setState(106);
			match(T__6);
			setState(107);
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
			setState(109);
			match(T__7);
			setState(110);
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
			setState(112);
			match(T__8);
			setState(113);
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
			setState(115);
			match(T__9);
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				room();
				}
				}
				setState(119); 
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(ID);
			setState(122);
			match(T__10);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 258064L) != 0)) {
				{
				{
				setState(123);
				room_property();
				}
				}
				setState(128);
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
		public Room_connections_propertyContext room_connections_property() {
			return getRuleContext(Room_connections_propertyContext.class,0);
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
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				room_description_property();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				room_x_property();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				room_y_property();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				room_width_property();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				room_height_property();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(134);
				room_pattern_property();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				room_connections_property();
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
			setState(138);
			match(T__3);
			setState(139);
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
			setState(141);
			match(T__11);
			setState(142);
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
			setState(144);
			match(T__12);
			setState(145);
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
			setState(147);
			match(T__13);
			setState(148);
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
			setState(150);
			match(T__14);
			setState(151);
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
			setState(153);
			match(T__15);
			setState(154);
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
		enterRule(_localctx, 40, RULE_room_connections_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__16);
			setState(157);
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
		enterRule(_localctx, 42, RULE_player);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__17);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 267911168L) != 0)) {
				{
				{
				setState(160);
				player_property();
				}
				}
				setState(165);
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
		enterRule(_localctx, 44, RULE_player_property);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				player_class_property();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				player_start_x_property();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				player_start_y_property();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				player_health_property();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(170);
				player_mana_property();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				player_stamina_property();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 7);
				{
				setState(172);
				player_speed_property();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 8);
				{
				setState(173);
				player_mana_restore_property();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 9);
				{
				setState(174);
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
		enterRule(_localctx, 46, RULE_player_class_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__18);
			setState(178);
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
		enterRule(_localctx, 48, RULE_player_start_x_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__19);
			setState(181);
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
		enterRule(_localctx, 50, RULE_player_start_y_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__20);
			setState(184);
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
		enterRule(_localctx, 52, RULE_player_health_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__21);
			setState(187);
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
		enterRule(_localctx, 54, RULE_player_mana_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__22);
			setState(190);
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
		enterRule(_localctx, 56, RULE_player_stamina_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__23);
			setState(193);
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
		enterRule(_localctx, 58, RULE_player_speed_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__24);
			setState(196);
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
		enterRule(_localctx, 60, RULE_player_mana_restore_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__25);
			setState(199);
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
		enterRule(_localctx, 62, RULE_player_stamina_restore_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__26);
			setState(202);
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
		enterRule(_localctx, 64, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__27);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 236491636736L) != 0)) {
				{
				setState(205);
				value();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__28) {
					{
					{
					setState(206);
					match(T__28);
					setState(207);
					value();
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(215);
			match(T__29);
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
		public TerminalNode ID() { return getToken(EscapeRoomDSLParser.ID, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_value);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(INT);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(BOOLEAN);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
				match(ID);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(222);
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
	public static class Multiline_stringContext extends ParserRuleContext {
		public TerminalNode MULTILINE_STRING() { return getToken(EscapeRoomDSLParser.MULTILINE_STRING, 0); }
		public Multiline_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline_string; }
	}

	public final Multiline_stringContext multiline_string() throws RecognitionException {
		Multiline_stringContext _localctx = new Multiline_stringContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_multiline_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
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
		"\u0004\u0001\'\u00e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002Q\b\u0002\n\u0002"+
		"\f\u0002T\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0004\u000bv\b\u000b\u000b\u000b\f\u000bw\u0001\f\u0001\f\u0001"+
		"\f\u0005\f}\b\f\n\f\f\f\u0080\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0089\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u00a2\b\u0015\n\u0015\f\u0015\u00a5"+
		"\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00b0\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0005 \u00d1"+
		"\b \n \f \u00d4\t \u0003 \u00d6\b \u0001 \u0001 \u0001!\u0001!\u0001!"+
		"\u0001!\u0001!\u0001!\u0003!\u00e0\b!\u0001\"\u0001\"\u0001\"\u0000\u0000"+
		"#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0000\u00df\u0000F\u0001\u0000"+
		"\u0000\u0000\u0002I\u0001\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000"+
		"\u0006\\\u0001\u0000\u0000\u0000\b^\u0001\u0000\u0000\u0000\na\u0001\u0000"+
		"\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000"+
		"\u0010j\u0001\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014p"+
		"\u0001\u0000\u0000\u0000\u0016s\u0001\u0000\u0000\u0000\u0018y\u0001\u0000"+
		"\u0000\u0000\u001a\u0088\u0001\u0000\u0000\u0000\u001c\u008a\u0001\u0000"+
		"\u0000\u0000\u001e\u008d\u0001\u0000\u0000\u0000 \u0090\u0001\u0000\u0000"+
		"\u0000\"\u0093\u0001\u0000\u0000\u0000$\u0096\u0001\u0000\u0000\u0000"+
		"&\u0099\u0001\u0000\u0000\u0000(\u009c\u0001\u0000\u0000\u0000*\u009f"+
		"\u0001\u0000\u0000\u0000,\u00af\u0001\u0000\u0000\u0000.\u00b1\u0001\u0000"+
		"\u0000\u00000\u00b4\u0001\u0000\u0000\u00002\u00b7\u0001\u0000\u0000\u0000"+
		"4\u00ba\u0001\u0000\u0000\u00006\u00bd\u0001\u0000\u0000\u00008\u00c0"+
		"\u0001\u0000\u0000\u0000:\u00c3\u0001\u0000\u0000\u0000<\u00c6\u0001\u0000"+
		"\u0000\u0000>\u00c9\u0001\u0000\u0000\u0000@\u00cc\u0001\u0000\u0000\u0000"+
		"B\u00df\u0001\u0000\u0000\u0000D\u00e1\u0001\u0000\u0000\u0000FG\u0003"+
		"\u0002\u0001\u0000GH\u0005\u0000\u0000\u0001H\u0001\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0001\u0000\u0000JK\u0003\u0004\u0002\u0000KL\u0003\u0016"+
		"\u000b\u0000LM\u0003*\u0015\u0000M\u0003\u0001\u0000\u0000\u0000NR\u0005"+
		"\u0002\u0000\u0000OQ\u0003\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000"+
		"QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000S\u0005\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000U]\u0003"+
		"\b\u0004\u0000V]\u0003\n\u0005\u0000W]\u0003\f\u0006\u0000X]\u0003\u000e"+
		"\u0007\u0000Y]\u0003\u0010\b\u0000Z]\u0003\u0012\t\u0000[]\u0003\u0014"+
		"\n\u0000\\U\u0001\u0000\u0000\u0000\\V\u0001\u0000\u0000\u0000\\W\u0001"+
		"\u0000\u0000\u0000\\X\u0001\u0000\u0000\u0000\\Y\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]\u0007\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0003\u0000\u0000_`\u0005\"\u0000\u0000`\t\u0001"+
		"\u0000\u0000\u0000ab\u0005\u0004\u0000\u0000bc\u0005\"\u0000\u0000c\u000b"+
		"\u0001\u0000\u0000\u0000de\u0005\u0005\u0000\u0000ef\u0005\"\u0000\u0000"+
		"f\r\u0001\u0000\u0000\u0000gh\u0005\u0006\u0000\u0000hi\u0005%\u0000\u0000"+
		"i\u000f\u0001\u0000\u0000\u0000jk\u0005\u0007\u0000\u0000kl\u0005 \u0000"+
		"\u0000l\u0011\u0001\u0000\u0000\u0000mn\u0005\b\u0000\u0000no\u0005%\u0000"+
		"\u0000o\u0013\u0001\u0000\u0000\u0000pq\u0005\t\u0000\u0000qr\u0005$\u0000"+
		"\u0000r\u0015\u0001\u0000\u0000\u0000su\u0005\n\u0000\u0000tv\u0003\u0018"+
		"\f\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0017\u0001\u0000\u0000\u0000"+
		"yz\u0005!\u0000\u0000z~\u0005\u000b\u0000\u0000{}\u0003\u001a\r\u0000"+
		"|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0019\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0089\u0003\u001c\u000e\u0000"+
		"\u0082\u0089\u0003\u001e\u000f\u0000\u0083\u0089\u0003 \u0010\u0000\u0084"+
		"\u0089\u0003\"\u0011\u0000\u0085\u0089\u0003$\u0012\u0000\u0086\u0089"+
		"\u0003&\u0013\u0000\u0087\u0089\u0003(\u0014\u0000\u0088\u0081\u0001\u0000"+
		"\u0000\u0000\u0088\u0082\u0001\u0000\u0000\u0000\u0088\u0083\u0001\u0000"+
		"\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0088\u0085\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u001b\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0004"+
		"\u0000\u0000\u008b\u008c\u0005\"\u0000\u0000\u008c\u001d\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e\u008f\u0005%\u0000\u0000"+
		"\u008f\u001f\u0001\u0000\u0000\u0000\u0090\u0091\u0005\r\u0000\u0000\u0091"+
		"\u0092\u0005%\u0000\u0000\u0092!\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"\u000e\u0000\u0000\u0094\u0095\u0005%\u0000\u0000\u0095#\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005\u000f\u0000\u0000\u0097\u0098\u0005%\u0000\u0000"+
		"\u0098%\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0010\u0000\u0000\u009a"+
		"\u009b\u0003D\"\u0000\u009b\'\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"\u0011\u0000\u0000\u009d\u009e\u0003@ \u0000\u009e)\u0001\u0000\u0000"+
		"\u0000\u009f\u00a3\u0005\u0012\u0000\u0000\u00a0\u00a2\u0003,\u0016\u0000"+
		"\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4+\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6"+
		"\u00b0\u0003.\u0017\u0000\u00a7\u00b0\u00030\u0018\u0000\u00a8\u00b0\u0003"+
		"2\u0019\u0000\u00a9\u00b0\u00034\u001a\u0000\u00aa\u00b0\u00036\u001b"+
		"\u0000\u00ab\u00b0\u00038\u001c\u0000\u00ac\u00b0\u0003:\u001d\u0000\u00ad"+
		"\u00b0\u0003<\u001e\u0000\u00ae\u00b0\u0003>\u001f\u0000\u00af\u00a6\u0001"+
		"\u0000\u0000\u0000\u00af\u00a7\u0001\u0000\u0000\u0000\u00af\u00a8\u0001"+
		"\u0000\u0000\u0000\u00af\u00a9\u0001\u0000\u0000\u0000\u00af\u00aa\u0001"+
		"\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000\u0000\u00af\u00ac\u0001"+
		"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0-\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0013"+
		"\u0000\u0000\u00b2\u00b3\u0005\u001f\u0000\u0000\u00b3/\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005\u0014\u0000\u0000\u00b5\u00b6\u0005%\u0000\u0000"+
		"\u00b61\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0015\u0000\u0000\u00b8"+
		"\u00b9\u0005%\u0000\u0000\u00b93\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005"+
		"\u0016\u0000\u0000\u00bb\u00bc\u0005%\u0000\u0000\u00bc5\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0005\u0017\u0000\u0000\u00be\u00bf\u0005%\u0000\u0000"+
		"\u00bf7\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0018\u0000\u0000\u00c1"+
		"\u00c2\u0005%\u0000\u0000\u00c29\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"\u0019\u0000\u0000\u00c4\u00c5\u0005$\u0000\u0000\u00c5;\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005\u001a\u0000\u0000\u00c7\u00c8\u0005$\u0000\u0000"+
		"\u00c8=\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u001b\u0000\u0000\u00ca"+
		"\u00cb\u0005$\u0000\u0000\u00cb?\u0001\u0000\u0000\u0000\u00cc\u00d5\u0005"+
		"\u001c\u0000\u0000\u00cd\u00d2\u0003B!\u0000\u00ce\u00cf\u0005\u001d\u0000"+
		"\u0000\u00cf\u00d1\u0003B!\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d5\u00cd\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0005\u001e\u0000\u0000\u00d8A\u0001\u0000\u0000\u0000\u00d9\u00e0"+
		"\u0005\"\u0000\u0000\u00da\u00e0\u0005$\u0000\u0000\u00db\u00e0\u0005"+
		"%\u0000\u0000\u00dc\u00e0\u0005 \u0000\u0000\u00dd\u00e0\u0005!\u0000"+
		"\u0000\u00de\u00e0\u0003@ \u0000\u00df\u00d9\u0001\u0000\u0000\u0000\u00df"+
		"\u00da\u0001\u0000\u0000\u0000\u00df\u00db\u0001\u0000\u0000\u0000\u00df"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0C\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0005#\u0000\u0000\u00e2E\u0001\u0000\u0000\u0000\nR\\w~\u0088\u00a3"+
		"\u00af\u00d2\u00d5\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}