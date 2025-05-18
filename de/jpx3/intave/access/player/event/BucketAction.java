package de.jpx3.intave.access.player.event;

public enum BucketAction {
   public static final BucketAction FILL_BUCKET = new BucketAction();
   public static final BucketAction EMPTY_BUCKET = new BucketAction();
   private static final BucketAction[] a = new BucketAction[]{FILL_BUCKET, EMPTY_BUCKET};
}
