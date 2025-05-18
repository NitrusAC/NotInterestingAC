package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.hY;
import de.jpx3.intave.unknown.Unknown137;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown35;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class Am35 {
   public static final String[] f = new String[]{"", "", "", "", "T_BOOLEAN", "T_CHAR", "T_FLOAT", "T_DOUBLE", "T_BYTE", "T_SHORT", "T_INT", "T_LONG"};
   public static final String[] h = new String[]{
      "NOP",
      "ACONST_NULL",
      "ICONST_M1",
      "ICONST_0",
      "ICONST_1",
      "ICONST_2",
      "ICONST_3",
      "ICONST_4",
      "ICONST_5",
      "LCONST_0",
      "LCONST_1",
      "FCONST_0",
      "FCONST_1",
      "FCONST_2",
      "DCONST_0",
      "DCONST_1",
      "BIPUSH",
      "SIPUSH",
      "LDC",
      "LDC_W",
      "LDC2_W",
      "ILOAD",
      "LLOAD",
      "FLOAD",
      "DLOAD",
      "ALOAD",
      "ILOAD_0",
      "ILOAD_1",
      "ILOAD_2",
      "ILOAD_3",
      "LLOAD_0",
      "LLOAD_1",
      "LLOAD_2",
      "LLOAD_3",
      "FLOAD_0",
      "FLOAD_1",
      "FLOAD_2",
      "FLOAD_3",
      "DLOAD_0",
      "DLOAD_1",
      "DLOAD_2",
      "DLOAD_3",
      "ALOAD_0",
      "ALOAD_1",
      "ALOAD_2",
      "ALOAD_3",
      "IALOAD",
      "LALOAD",
      "FALOAD",
      "DALOAD",
      "AALOAD",
      "BALOAD",
      "CALOAD",
      "SALOAD",
      "ISTORE",
      "LSTORE",
      "FSTORE",
      "DSTORE",
      "ASTORE",
      "ISTORE_0",
      "ISTORE_1",
      "ISTORE_2",
      "ISTORE_3",
      "LSTORE_0",
      "LSTORE_1",
      "LSTORE_2",
      "LSTORE_3",
      "FSTORE_0",
      "FSTORE_1",
      "FSTORE_2",
      "FSTORE_3",
      "DSTORE_0",
      "DSTORE_1",
      "DSTORE_2",
      "DSTORE_3",
      "ASTORE_0",
      "ASTORE_1",
      "ASTORE_2",
      "ASTORE_3",
      "IASTORE",
      "LASTORE",
      "FASTORE",
      "DASTORE",
      "AASTORE",
      "BASTORE",
      "CASTORE",
      "SASTORE",
      "POP",
      "POP2",
      "DUP",
      "DUP_X1",
      "DUP_X2",
      "DUP2",
      "DUP2_X1",
      "DUP2_X2",
      "SWAP",
      "IADD",
      "LADD",
      "FADD",
      "DADD",
      "ISUB",
      "LSUB",
      "FSUB",
      "DSUB",
      "IMUL",
      "LMUL",
      "FMUL",
      "DMUL",
      "IDIV",
      "LDIV",
      "FDIV",
      "DDIV",
      "IREM",
      "LREM",
      "FREM",
      "DREM",
      "INEG",
      "LNEG",
      "FNEG",
      "DNEG",
      "ISHL",
      "LSHL",
      "ISHR",
      "LSHR",
      "IUSHR",
      "LUSHR",
      "IAND",
      "LAND",
      "IOR",
      "LOR",
      "IXOR",
      "LXOR",
      "IINC",
      "I2L",
      "I2F",
      "I2D",
      "L2I",
      "L2F",
      "L2D",
      "F2I",
      "F2L",
      "F2D",
      "D2I",
      "D2L",
      "D2F",
      "I2B",
      "I2C",
      "I2S",
      "LCMP",
      "FCMPL",
      "FCMPG",
      "DCMPL",
      "DCMPG",
      "IFEQ",
      "IFNE",
      "IFLT",
      "IFGE",
      "IFGT",
      "IFLE",
      "IF_ICMPEQ",
      "IF_ICMPNE",
      "IF_ICMPLT",
      "IF_ICMPGE",
      "IF_ICMPGT",
      "IF_ICMPLE",
      "IF_ACMPEQ",
      "IF_ACMPNE",
      "GOTO",
      "JSR",
      "RET",
      "TABLESWITCH",
      "LOOKUPSWITCH",
      "IRETURN",
      "LRETURN",
      "FRETURN",
      "DRETURN",
      "ARETURN",
      "RETURN",
      "GETSTATIC",
      "PUTSTATIC",
      "GETFIELD",
      "PUTFIELD",
      "INVOKEVIRTUAL",
      "INVOKESPECIAL",
      "INVOKESTATIC",
      "INVOKEINTERFACE",
      "INVOKEDYNAMIC",
      "NEW",
      "NEWARRAY",
      "ANEWARRAY",
      "ARRAYLENGTH",
      "ATHROW",
      "CHECKCAST",
      "INSTANCEOF",
      "MONITORENTER",
      "MONITOREXIT",
      "WIDE",
      "MULTIANEWARRAY",
      "IFNULL",
      "IFNONNULL"
   };
   public static final String[] e = new String[]{
      "",
      "H_GETFIELD",
      "H_GETSTATIC",
      "H_PUTFIELD",
      "H_PUTSTATIC",
      "H_INVOKEVIRTUAL",
      "H_INVOKESTATIC",
      "H_INVOKESPECIAL",
      "H_NEWINVOKESPECIAL",
      "H_INVOKEINTERFACE"
   };
   protected final StringBuilder c;
   protected final int b;
   public final List a;
   private static final String d;

   public abstract void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4);

   public abstract Am35 a(int var1, String var2, String var3, String var4, String[] var5);

   public abstract void d(Unknown35 var1);

   public void a(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   static void a(String[] var0, String var1, Am35 var2, PrintWriter var3, PrintWriter var4) {
      if (var0.length >= 1 && var0.length <= 2 && (!var0[0].equals("-debug") || var0.length == 2)) {
         hY var8 = new hY(null, var2, var3);
         String var9;
         byte var10;
         if (var0[0].equals("-debug")) {
            var9 = var0[1];
            var10 = 2;
         } else {
            var9 = var0[0];
            var10 = 0;
         }

         if (!var9.endsWith(".class") && var9.indexOf(92) == -1 && var9.indexOf(47) == -1) {
            new Asm37(var9).a(var8, var10);
         } else {
            FileInputStream var11 = new FileInputStream(var9);
            new Asm37((InputStream)var11).a(var8, var10);
         }

      } else {
         var4.println(var1);
      }
   }

   public abstract void a(int var1);

   @Deprecated
   public void c(Unknown35 var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void b(Unknown35 var1);

   public void g(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(String var1, String var2, String var3);

   protected Am35(int var1) {
      this.b = var1;
      this.c = new StringBuilder();
      this.a = new ArrayList();
   }

   public abstract void c(int var1, int var2);

   public abstract void a(int var1, int var2);

   public abstract Am35 a(int var1, String var2, boolean var3);

   @Deprecated
   public Am35 a(String var1, boolean var2) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public Am35 a(String var1, int var2, String var3) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract Am35 d(String var1, boolean var2);

   public void a(String var1, String[] var2) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public void b(String var1, int var2, String var3) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(String var1, String var2, String var3, int var4);

   public abstract void a(Unknown246 var1);

   public abstract Am35 a(int var1, String var2, String var3, String var4, Object var5);

   public void e() {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(int var1, int var2, Unknown246 var3, Unknown246[] var4);

   public abstract void g();

   public abstract void a(int var1, int var2, Object[] var3, int var4, Object[] var5);

   public abstract void a(Unknown246 var1, int[] var2, Unknown246[] var3);

   public abstract void b();

   @Deprecated
   public void c() {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public Am35 a(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void i();

   public abstract void a(int var1, int var2, String var3, String var4, String var5, String[] var6);

   public Am35 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(int var1, Unknown246 var2);

   public abstract void a(Object var1);

   @Deprecated
   public void d(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public void a(int var1, String var2, String var3, String var4, boolean var5) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract Am35 c(String var1, boolean var2);

   public abstract void a(String var1, String var2);

   static void a(PrintWriter var0, List var1) {
      for(Object var6 : var1) {
         if (var6 instanceof List) {
            a(var0, (List)var6);
         } else {
            var0.print(var6.toString());
         }
      }

   }

   public Am35 a(int var1, boolean var2) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public Am35 b(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void c(int var1, String var2, String var3, String var4);

   @Deprecated
   public void a(int var1, String var2, String var3, String var4) {
      this.a(var1, var2, var3, var4, var1 == 185);
   }

   public List a() {
      return this.a;
   }

   public abstract void a(Unknown35 var1);

   public abstract void a(int var1, String var2);

   public Am35 e(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   @Deprecated
   public Am35 d(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public void b(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void b(String var1, String var2, String var3);

   public abstract void a(String var1, String var2, Unknown137 var3, Object[] var4);

   public abstract void b(int var1, int var2);

   public abstract Am35 b(String var1, boolean var2);

   public void a(String var1, int var2, String[] var3) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract Am35 b(String var1, String var2);

   public abstract void a(String var1, int var2);

   public void b(String var1, int var2, String[] var3) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void d();

   public abstract void f();

   public void e(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public Am35 c(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public void b(String var1, int var2) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(String var1, Object var2);

   public static void a(StringBuilder var0, String var1) {
      var0.append('"');

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         char var6 = var1.charAt(var5);
         if (var6 == '\n') {
            var0.append("\\n");
         } else if (var6 == '\r') {
            var0.append("\\r");
         } else if (var6 == '\\') {
            var0.append("\\\\");
         } else if (var6 == '"') {
            var0.append("\\\"");
         } else if (var6 >= ' ' && var6 <= 127) {
            var0.append(var6);
         } else {
            var0.append("\\u");
            if (var6 < 16) {
               var0.append("000");
            } else if (var6 < 256) {
               var0.append("00");
            } else if (var6 < 4096) {
               var0.append('0');
            }

            var0.append(Integer.toString(var6, 16));
         }
      }

      var0.append('"');
   }

   public abstract void b(int var1, Unknown246 var2);

   public abstract void d(int var1, int var2);

   public abstract Am35 h(String var1);

   public void c(String var1) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public Am35 f(int var1, Unknown186 var2, String var3, boolean var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   @Deprecated
   public Am35 b(int var1, String var2, String var3, String var4) {
      throw new UnsupportedOperationException("Must be overridden");
   }

   public abstract void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6);

   public abstract Am35 j();

   public void a(PrintWriter var1) {
      a(var1, this.a);
   }
}
