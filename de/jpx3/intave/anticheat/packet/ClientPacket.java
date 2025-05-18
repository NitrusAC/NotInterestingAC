package de.jpx3.intave.anticheat.packet;

public enum ClientPacket {
   public static final ClientPacket UPDATE_SIGN = new ClientPacket("UPDATE_SIGN");
   public static final ClientPacket CLOSE_WINDOW = new ClientPacket("CLOSE_WINDOW");
   public static final ClientPacket ADVANCEMENTS = new ClientPacket("ADVANCEMENTS");
   public static final ClientPacket CLIENT_COMMAND = new ClientPacket("CLIENT_COMMAND");
   public static final ClientPacket BEACON = new ClientPacket("BEACON");
   public static final ClientPacket VEHICLE_MOVE = new ClientPacket("VEHICLE_MOVE");
   public static final ClientPacket USE_ENTITY = new ClientPacket("USE_ENTITY");
   public static final ClientPacket KEEP_ALIVE = new ClientPacket("KEEP_ALIVE");
   public static final ClientPacket SET_CREATIVE_SLOT = new ClientPacket("SET_CREATIVE_SLOT");
   public static final ClientPacket SET_JIGSAW = new ClientPacket("SET_JIGSAW");
   public static final ClientPacket PICK_ITEM = new ClientPacket("PICK_ITEM");
   public static final ClientPacket PONG = new ClientPacket("PONG");
   public static final ClientPacket POSITION_LOOK = new ClientPacket("POSITION_LOOK");
   public static final ClientPacket DIFFICULTY_LOCK = new ClientPacket("DIFFICULTY_LOCK");
   public static final ClientPacket STEER_VEHICLE = new ClientPacket("STEER_VEHICLE");
   public static final ClientPacket SPECTATE = new ClientPacket("SPECTATE");
   public static final ClientPacket TR_SEL = new ClientPacket("TR_SEL");
   private static final ClientPacket[] values = new ClientPacket[]{
      ClientPacket.ALL,
      ClientPacket.ABILITIES,
      ADVANCEMENTS,
      ClientPacket.ARM_ANIMATION,
      ClientPacket.AUTO_RECIPE,
      BEACON,
      ClientPacket.BLOCK_DIG,
      ClientPacket.BLOCK_PLACE,
      ClientPacket.BOAT_MOVE,
      ClientPacket.B_EDIT,
      ClientPacket.CHAT,
      CLIENT_COMMAND,
      CLOSE_WINDOW,
      ClientPacket.CUSTOM_PAYLOAD,
      ClientPacket.DIFFICULTY_CHANGE,
      DIFFICULTY_LOCK,
      ClientPacket.ENCHANT_ITEM,
      ClientPacket.ENTITY_ACTION,
      ClientPacket.ENTITY_NBT_QUERY,
      ClientPacket.FLYING,
      ClientPacket.HELD_ITEM_SLOT,
      ClientPacket.ITEM_NAME,
      ClientPacket.JIGSAW_GENERATE,
      KEEP_ALIVE,
      ClientPacket.LOOK,
      PICK_ITEM,
      PONG,
      ClientPacket.POSITION,
      POSITION_LOOK,
      ClientPacket.RECIPE_DISPLAYED,
      ClientPacket.RECIPE_SETTINGS,
      ClientPacket.RESOURCE_PACK_STATUS,
      ClientPacket.SETTINGS,
      ClientPacket.SET_COMMAND_BLOCK,
      ClientPacket.SET_COMMAND_MINECART,
      SET_CREATIVE_SLOT,
      SET_JIGSAW,
      SPECTATE,
      STEER_VEHICLE,
      ClientPacket.STRUCT,
      ClientPacket.TAB_COMPLETE,
      ClientPacket.TELEPORT_ACCEPT,
      ClientPacket.TITLE_NBT_QUERY,
      ClientPacket.TRANSACTION,
      TR_SEL,
      UPDATE_SIGN,
      USE_ENTITY,
      ClientPacket.USE_ITEM,
      VEHICLE_MOVE,
      ClientPacket.WINDOW_CLICK
   };
   public static final ClientPacket ENCHANT_ITEM = new ClientPacket("ENCHANT_ITEM");
   public static final ClientPacket ABILITIES = new ClientPacket("ABILITIES");
   public static final ClientPacket TITLE_NBT_QUERY = new ClientPacket("TILE_NBT_QUERY");
   public static final ClientPacket JIGSAW_GENERATE = new ClientPacket("JIGSAW_GENERATE");
   public static final ClientPacket LOOK = new ClientPacket("LOOK");
   public static final ClientPacket DIFFICULTY_CHANGE = new ClientPacket("DIFFICULTY_CHANGE");
   public static final ClientPacket POSITION = new ClientPacket("POSITION");
   public static final ClientPacket FLYING = new ClientPacket("FLYING");
   public static final ClientPacket CUSTOM_PAYLOAD = new ClientPacket("CUSTOM_PAYLOAD");
   public static final ClientPacket RECIPE_DISPLAYED = new ClientPacket("RECIPE_DISPLAYED");
   public static final ClientPacket ENTITY_NBT_QUERY = new ClientPacket("ENTITY_NBT_QUERY");
   @Deprecated
   public static final ClientPacket TRANSACTION = new ClientPacket("TRANSACTION");
   public static final ClientPacket SET_COMMAND_BLOCK = new ClientPacket("SET_COMMAND_BLOCK");
   public static final ClientPacket SETTINGS = new ClientPacket("SETTINGS");
   @Deprecated
   public static final ClientPacket ALL = new ClientPacket("*");
   public static final ClientPacket RECIPE_SETTINGS = new ClientPacket("RECIPE_SETTINGS");
   public static final ClientPacket BLOCK_PLACE = new ClientPacket("BLOCK_PLACE");
   public static final ClientPacket RESOURCE_PACK_STATUS = new ClientPacket("RESOURCE_PACK_STATUS");
   public static final ClientPacket STRUCT = new ClientPacket("STRUCT");
   public static final ClientPacket TAB_COMPLETE = new ClientPacket("TAB_COMPLETE");
   public static final ClientPacket AUTO_RECIPE = new ClientPacket("AUTO_RECIPE");
   public static final ClientPacket CHAT = new ClientPacket("CHAT");
   public static final ClientPacket TELEPORT_ACCEPT = new ClientPacket("TELEPORT_ACCEPT");
   public static final ClientPacket USE_ITEM = new ClientPacket("USE_ITEM");
   public static final ClientPacket ITEM_NAME = new ClientPacket("ITEM_NAME");
   public static final ClientPacket B_EDIT = new ClientPacket("B_EDIT");
   public static final ClientPacket HELD_ITEM_SLOT = new ClientPacket("HELD_ITEM_SLOT");
   private final String type;
   public static final ClientPacket BOAT_MOVE = new ClientPacket("BOAT_MOVE");
   public static final ClientPacket ENTITY_ACTION = new ClientPacket("ENTITY_ACTION");
   public static final ClientPacket SET_COMMAND_MINECART = new ClientPacket("SET_COMMAND_MINECART");
   public static final ClientPacket ARM_ANIMATION = new ClientPacket("ARM_ANIMATION");
   public static final ClientPacket BLOCK_DIG = new ClientPacket("BLOCK_DIG");
   public static final ClientPacket WINDOW_CLICK = new ClientPacket("WINDOW_CLICK");

   private ClientPacket(String var3) {
      this.type = var3;
   }

   public String getType() {
      return this.type;
   }
}
