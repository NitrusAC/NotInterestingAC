package org.ow2.asm;

import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.asm.Asm1;
import java.util.Map;

public class MethodInsnNode extends Asm1 {
   public String name;
   public boolean itf;
   public String desc;
   public String owner;

   @Override
   public Asm1 a(Map var1) {
      return new MethodInsnNode(this.w, this.owner, this.name, this.desc, this.itf).a(this);
   }

   public void a(int var1) {
      this.w = var1;
   }

   public String toString() {
      return "MethodInsnNode{owner='" + this.owner + '\'' + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", itf=" + this.itf + '}';
   }

   @Override
   public int d() {
      return 5;
   }

   public MethodInsnNode(int var1, String var2, String var3, String var4) {
      this(var1, var2, var3, var4, var1 == 185);
   }

   public MethodInsnNode(int var1, String var2, String var3, String var4, boolean var5) {
      super(var1);
      this.owner = var2;
      this.name = var3;
      this.desc = var4;
      this.itf = var5;
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.visit(this.w, this.owner, this.name, this.desc, this.itf);
      this.visit(var1);
   }
}
