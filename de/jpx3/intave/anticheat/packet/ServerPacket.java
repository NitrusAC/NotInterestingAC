package de.jpx3.intave.anticheat.packet;

public enum ServerPacket {
   public static final ServerPacket UPDATE_SIGN = new ServerPacket("UPDATE_SIGN");
   public static final ServerPacket ENTITY_EQUIPMENT = new ServerPacket("ENTITY_EQUIPMENT");
   public static final ServerPacket ENTITY = new ServerPacket("ENTITY");
   public static final ServerPacket SPAWN_ENTITY_PAINTING = new ServerPacket("SPAWN_ENTITY_PAINTING");
   public static final ServerPacket SCOREBOARD_TEAM = new ServerPacket("SCOREBOARD_TEAM");
   public static final ServerPacket TILE_ENTITY_DATA = new ServerPacket("TILE_ENTITY_DATA");
   public static final ServerPacket SET_COOLDOWN = new ServerPacket("SET_COOLDOWN");
   public static final ServerPacket ATTACH_ENTITY = new ServerPacket("ATTACH_ENTITY");
   public static final ServerPacket CRAFT_PROGRESS_BAR = new ServerPacket("CRAFT_PROGRESS_BAR");
   public static final ServerPacket EXPLOSION = new ServerPacket("EXPLOSION");
   public static final ServerPacket AUTO_RECIPE = new ServerPacket("AUTO_RECIPE");
   public static final ServerPacket LIGHT_UPDATE = new ServerPacket("LIGHT_UPDATE");
   public static final ServerPacket SPAWN_POSITION = new ServerPacket("SPAWN_POSITION");
   public static final ServerPacket TAB_COMPLETE = new ServerPacket("TAB_COMPLETE");
   public static final ServerPacket MAP_CHUNK = new ServerPacket("MAP_CHUNK");
   public static final ServerPacket BLOCK_CHANGE = new ServerPacket("BLOCK_CHANGE");
   public static final ServerPacket OPEN_SIGN_EDITOR = new ServerPacket("OPEN_SIGN_EDITOR");
   public static final ServerPacket COMMANDS = new ServerPacket("COMMANDS");
   public static final ServerPacket GAME_STATE_CHANGE = new ServerPacket("GAME_STATE_CHANGE");
   public static final ServerPacket OPEN_WINDOW_MERCHANT = new ServerPacket("OPEN_WINDOW_MERCHANT");
   public static final ServerPacket COLLECT = new ServerPacket("COLLECT");
   public static final ServerPacket EXPERIENCE = new ServerPacket("EXPERIENCE");
   public static final ServerPacket SERVER_DIFFICULTY = new ServerPacket("SERVER_DIFFICULTY");
   public static final ServerPacket UNLOAD_CHUNK = new ServerPacket("UNLOAD_CHUNK");
   public static final ServerPacket TITLE = new ServerPacket("TITLE");
   public static final ServerPacket RECIPES = new ServerPacket("RECIPES");
   public static final ServerPacket REL_ENTITY_MOVE = new ServerPacket("REL_ENTITY_MOVE");
   public static final ServerPacket BLOCK_BREAK_ANIMATION = new ServerPacket("BLOCK_BREAK_ANIMATION");
   public static final ServerPacket USE_BED = new ServerPacket("USE_BED");
   public static final ServerPacket WORLD_PARTICLES = new ServerPacket("WORLD_PARTICLES");
   public static final ServerPacket MAP = new ServerPacket("MAP");
   public static final ServerPacket ENTITY_TELEPORT = new ServerPacket("ENTITY_TELEPORT");
   public static final ServerPacket RESPAWN = new ServerPacket("RESPAWN");
   public static final ServerPacket ENTITY_VELOCITY = new ServerPacket("ENTITY_VELOCITY");
   public static final ServerPacket WINDOW_DATA = new ServerPacket("WINDOW_DATA");
   private static final ServerPacket[] values = new ServerPacket[]{
      ServerPacket.ALL,
      ServerPacket.ABILITIES,
      ServerPacket.ADVANCEMENTS,
      ServerPacket.ANIMATION,
      ATTACH_ENTITY,
      AUTO_RECIPE,
      ServerPacket.BED,
      ServerPacket.BLOCK_ACTION,
      ServerPacket.BLOCK_BREAK,
      BLOCK_BREAK_ANIMATION,
      BLOCK_CHANGE,
      ServerPacket.BOSS,
      ServerPacket.CAMERA,
      ServerPacket.CHAT,
      ServerPacket.CLOSE_WINDOW,
      COLLECT,
      ServerPacket.COMBAT_EVENT,
      COMMANDS,
      CRAFT_PROGRESS_BAR,
      ServerPacket.CUSTOM_PAYLOAD,
      ServerPacket.CUSTOM_SOUND_EFFECT,
      ENTITY,
      ServerPacket.ENTITY_DESTROY,
      ServerPacket.ENTITY_EFFECT,
      ENTITY_EQUIPMENT,
      ServerPacket.ENTITY_HEAD_ROTATION,
      ServerPacket.ENTITY_LOOK,
      ServerPacket.ENTITY_METADATA,
      ServerPacket.ENTITY_MOVE_LOOK,
      ServerPacket.ENTITY_SOUND,
      ServerPacket.ENTITY_STATUS,
      ENTITY_TELEPORT,
      ENTITY_VELOCITY,
      EXPERIENCE,
      EXPLOSION,
      GAME_STATE_CHANGE,
      ServerPacket.HELD_ITEM_SLOT,
      ServerPacket.KEEP_ALIVE,
      ServerPacket.KICK_DISCONNECT,
      LIGHT_UPDATE,
      ServerPacket.LOGIN,
      ServerPacket.LOOK_AT,
      MAP,
      MAP_CHUNK,
      ServerPacket.MAP_CHUNK_BULK,
      ServerPacket.MOUNT,
      ServerPacket.MULTI_BLOCK_CHANGE,
      ServerPacket.NAMED_ENTITY_SPAWN,
      ServerPacket.NAMED_SOUND_EFFECT,
      ServerPacket.NBT_QUERY,
      ServerPacket.OPEN_BOOK,
      OPEN_SIGN_EDITOR,
      ServerPacket.OPEN_SIGN_ENTITY,
      ServerPacket.OPEN_WINDOW,
      ServerPacket.OPEN_WINDOW_HORSE,
      OPEN_WINDOW_MERCHANT,
      ServerPacket.PING,
      ServerPacket.PLAYER_INFO,
      ServerPacket.PLAYER_LIST_HEADER_FOOTER,
      ServerPacket.POSITION,
      RECIPES,
      ServerPacket.RECIPE_UPDATE,
      REL_ENTITY_MOVE,
      ServerPacket.REL_ENTITY_MOVE_LOOK,
      ServerPacket.REMOVE_ENTITY_EFFECT,
      ServerPacket.RESOURCE_PACK_SEND,
      RESPAWN,
      ServerPacket.SCOREBOARD_DISPLAY_OBJECTIVE,
      ServerPacket.SCOREBOARD_OBJECTIVE,
      ServerPacket.SCOREBOARD_SCORE,
      SCOREBOARD_TEAM,
      ServerPacket.SELECT_ADVANCEMENT_TAB,
      SERVER_DIFFICULTY,
      ServerPacket.SET_COMPRESSION,
      SET_COOLDOWN,
      ServerPacket.SET_SLOT,
      ServerPacket.SPAWN_ENTITY,
      ServerPacket.SPAWN_ENTITY_EXPERIENCE_ORB,
      ServerPacket.SPAWN_ENTITY_LIVING,
      SPAWN_ENTITY_PAINTING,
      ServerPacket.SPAWN_ENTITY_WEATHER,
      SPAWN_POSITION,
      ServerPacket.STATISTIC,
      ServerPacket.STATISTICS,
      ServerPacket.STOP_SOUND,
      TAB_COMPLETE,
      ServerPacket.TAGS,
      TILE_ENTITY_DATA,
      TITLE,
      ServerPacket.TRANSACTION,
      UNLOAD_CHUNK,
      ServerPacket.UPDATE_ATTRIBUTES,
      ServerPacket.UPDATE_ENTITY_NBT,
      ServerPacket.UPDATE_HEALTH,
      UPDATE_SIGN,
      ServerPacket.UPDATE_TIME,
      USE_BED,
      ServerPacket.VEHICLE_MOVE,
      ServerPacket.VIEW_CENTRE,
      ServerPacket.VIEW_DISTANCE,
      WINDOW_DATA,
      ServerPacket.WINDOW_ITEMS,
      ServerPacket.WORLD_BORDER,
      ServerPacket.WORLD_EVENT,
      WORLD_PARTICLES
   };
   public static final ServerPacket VIEW_DISTANCE = new ServerPacket("VIEW_DISTANCE");
   public static final ServerPacket ENTITY_LOOK = new ServerPacket("ENTITY_LOOK");
   public static final ServerPacket WINDOW_ITEMS = new ServerPacket("WINDOW_ITEMS");
   public static final ServerPacket TAGS = new ServerPacket("TAGS");
   private final String name;
   public static final ServerPacket SPAWN_ENTITY = new ServerPacket("SPAWN_ENTITY");
   public static final ServerPacket SPAWN_ENTITY_LIVING = new ServerPacket("SPAWN_ENTITY_LIVING");
   public static final ServerPacket ENTITY_STATUS = new ServerPacket("ENTITY_STATUS");
   public static final ServerPacket ANIMATION = new ServerPacket("ANIMATION");
   public static final ServerPacket VEHICLE_MOVE = new ServerPacket("VEHICLE_MOVE");
   public static final ServerPacket SCOREBOARD_SCORE = new ServerPacket("SCOREBOARD_SCORE");
   public static final ServerPacket PING = new ServerPacket("PING");
   public static final ServerPacket POSITION = new ServerPacket("POSITION");
   public static final ServerPacket NBT_QUERY = new ServerPacket("NBT_QUERY");
   public static final ServerPacket VIEW_CENTRE = new ServerPacket("VIEW_CENTRE");
   public static final ServerPacket ABILITIES = new ServerPacket("ABILITIES");
   public static final ServerPacket KICK_DISCONNECT = new ServerPacket("KICK_DISCONNECT");
   public static final ServerPacket BOSS = new ServerPacket("BOSS");
   public static final ServerPacket REL_ENTITY_MOVE_LOOK = new ServerPacket("REL_ENTITY_MOVE_LOOK");
   public static final ServerPacket UPDATE_ENTITY_NBT = new ServerPacket("UPDATE_ENTITY_NBT");
   public static final ServerPacket ADVANCEMENTS = new ServerPacket("ADVANCEMENTS");
   public static final ServerPacket STATISTICS = new ServerPacket("STATISTICS");
   public static final ServerPacket SET_SLOT = new ServerPacket("SET_SLOT");
   public static final ServerPacket PLAYER_INFO = new ServerPacket("PLAYER_INFO");
   public static final ServerPacket REMOVE_ENTITY_EFFECT = new ServerPacket("REMOVE_ENTITY_EFFECT");
   public static final ServerPacket OPEN_BOOK = new ServerPacket("OPEN_BOOK");
   public static final ServerPacket SPAWN_ENTITY_WEATHER = new ServerPacket("SPAWN_ENTITY_WEATHER");
   public static final ServerPacket BLOCK_BREAK = new ServerPacket("BLOCK_BREAK");
   public static final ServerPacket OPEN_WINDOW_HORSE = new ServerPacket("OPEN_WINDOW_HORSE");
   public static final ServerPacket LOGIN = new ServerPacket("LOGIN");
   public static final ServerPacket ENTITY_METADATA = new ServerPacket("ENTITY_METADATA");
   public static final ServerPacket WORLD_EVENT = new ServerPacket("WORLD_EVENT");
   @Deprecated
   public static final ServerPacket ALL = new ServerPacket("*");
   public static final ServerPacket SCOREBOARD_OBJECTIVE = new ServerPacket("SCOREBOARD_OBJECTIVE");
   public static final ServerPacket SET_COMPRESSION = new ServerPacket("SET_COMPRESSION");
   public static final ServerPacket OPEN_SIGN_ENTITY = new ServerPacket("OPEN_SIGN_ENTITY");
   public static final ServerPacket ENTITY_MOVE_LOOK = new ServerPacket("ENTITY_MOVE_LOOK");
   public static final ServerPacket ENTITY_HEAD_ROTATION = new ServerPacket("ENTITY_HEAD_ROTATION");
   public static final ServerPacket ENTITY_DESTROY = new ServerPacket("ENTITY_DESTROY");
   public static final ServerPacket UPDATE_HEALTH = new ServerPacket("UPDATE_HEALTH");
   public static final ServerPacket RESOURCE_PACK_SEND = new ServerPacket("RESOURCE_PACK_SEND");
   public static final ServerPacket SPAWN_ENTITY_EXPERIENCE_ORB = new ServerPacket("SPAWN_ENTITY_EXPERIENCE_ORB");
   public static final ServerPacket WORLD_BORDER = new ServerPacket("WORLD_BORDER");
   public static final ServerPacket HELD_ITEM_SLOT = new ServerPacket("HELD_ITEM_SLOT");
   public static final ServerPacket ENTITY_SOUND = new ServerPacket("ENTITY_SOUND");
   public static final ServerPacket LOOK_AT = new ServerPacket("LOOK_AT");
   public static final ServerPacket PLAYER_LIST_HEADER_FOOTER = new ServerPacket("PLAYER_LIST_HEADER_FOOTER");
   public static final ServerPacket NAMED_ENTITY_SPAWN = new ServerPacket("NAMED_ENTITY_SPAWN");
   public static final ServerPacket BLOCK_ACTION = new ServerPacket("BLOCK_ACTION");
   public static final ServerPacket NAMED_SOUND_EFFECT = new ServerPacket("NAMED_SOUND_EFFECT");
   public static final ServerPacket CUSTOM_SOUND_EFFECT = new ServerPacket("CUSTOM_SOUND_EFFECT");
   public static final ServerPacket ENTITY_EFFECT = new ServerPacket("ENTITY_EFFECT");
   public static final ServerPacket CUSTOM_PAYLOAD = new ServerPacket("CUSTOM_PAYLOAD");
   public static final ServerPacket MAP_CHUNK_BULK = new ServerPacket("MAP_CHUNK_BULK");
   public static final ServerPacket KEEP_ALIVE = new ServerPacket("KEEP_ALIVE");
   public static final ServerPacket RECIPE_UPDATE = new ServerPacket("RECIPE_UPDATE");
   public static final ServerPacket CLOSE_WINDOW = new ServerPacket("CLOSE_WINDOW");
   public static final ServerPacket STOP_SOUND = new ServerPacket("STOP_SOUND");
   public static final ServerPacket BED = new ServerPacket("BED");
   public static final ServerPacket OPEN_WINDOW = new ServerPacket("OPEN_WINDOW");
   public static final ServerPacket COMBAT_EVENT = new ServerPacket("COMBAT_EVENT");
   public static final ServerPacket CAMERA = new ServerPacket("CAMERA");
   public static final ServerPacket SCOREBOARD_DISPLAY_OBJECTIVE = new ServerPacket("SCOREBOARD_DISPLAY_OBJECTIVE");
   @Deprecated
   public static final ServerPacket TRANSACTION = new ServerPacket("TRANSACTION");
   public static final ServerPacket SELECT_ADVANCEMENT_TAB = new ServerPacket("SELECT_ADVANCEMENT_TAB");
   public static final ServerPacket STATISTIC = new ServerPacket("STATISTIC");
   public static final ServerPacket CHAT = new ServerPacket("CHAT");
   public static final ServerPacket UPDATE_TIME = new ServerPacket("UPDATE_TIME");
   public static final ServerPacket MULTI_BLOCK_CHANGE = new ServerPacket("MULTI_BLOCK_CHANGE");
   public static final ServerPacket MOUNT = new ServerPacket("MOUNT");
   public static final ServerPacket UPDATE_ATTRIBUTES = new ServerPacket("UPDATE_ATTRIBUTES");

   public String getName() {
      return this.name;
   }

   private ServerPacket(String var3) {
      this.name = var3;
   }
}
