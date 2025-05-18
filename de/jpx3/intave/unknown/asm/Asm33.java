package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.fJ;
import de.jpx3.intave.p8;
import de.jpx3.intave.pE;
import de.jpx3.intave.unknown.Unknown137;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.Unknown357;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Relocate
public class Asm33 extends Am35 {
   private int v;
   public static final int i = 0;
   public static final int l = 2;
   public static final int t = 5;
   private static final String A;
   private static final String w;
   private static final String y;
   private static final String o;
   private int z;
   public static final int p = 3;
   protected Map x;
   protected String r;
   protected String q;
   private static final List j = Collections.unmodifiableList(Arrays.asList("T", "I", "F", "D", "J", "N", "U"));
   protected String u = "  ";
   public static final int n = 9;
   public static final int s = 4;
   public static final int m = 1;
   protected String k;

   protected Asm33 a() {
      return new Asm33(this.b);
   }

   private void h(String var1) {
      a(this.c, var1);
   }

   @Override
   public void a(int var1) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(String var1, boolean var2) {
      return this.e(var1, var2);
   }

   @Override
   public void a(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      if ((var2 & 32768) == 0) {
         this.v = var2;
         int var9 = var1 & 65535;
         int var10 = var1 >>> 16;
         this.c.setLength(0);
         this.c.append("// class version ").append(var9).append('.').append(var10).append(" (").append(var1).append(")\n");
         if ((var2 & 131072) != 0) {
            this.c.append("// DEPRECATED\n");
         }

         this.e(var2);
         this.b(5, var4);
         if (var4 != null) {
            this.b(var3, var4);
         }

         this.c(var2 & -32801);
         if ((var2 & 8192) != 0) {
            this.c.append("@interface ");
         } else if ((var2 & 512) != 0) {
            this.c.append("interface ");
         } else if ((var2 & 16384) == 0) {
            this.c.append("class ");
         }

         this.b(0, var3);
         if (var5 != null && !"java/lang/Object".equals(var5)) {
            this.c.append(" extends ");
            this.b(0, var5);
         }

         if (var6 != null && var6.length > 0) {
            this.c.append(" implements ");

            for(int var11 = 0; var11 < var6.length; ++var11) {
               this.b(0, var6[var11]);
               if (var11 != var6.length - 1) {
                  this.c.append(' ');
               }
            }
         }

         this.c.append(" {\n\n");
         this.a.add(this.c.toString());
      }
   }

   @Override
   public void a(String var1, Object var2) {
      this.j(var1);
      if (var2 instanceof String) {
         this.h((String)var2);
      } else if (var2 instanceof Unknown357) {
         this.a((Unknown357)var2);
      } else if (var2 instanceof Byte) {
         this.a((Byte)var2);
      } else if (var2 instanceof Boolean) {
         this.a((Boolean)var2);
      } else if (var2 instanceof Short) {
         this.a((Short)var2);
      } else if (var2 instanceof Character) {
         this.a((Character)var2);
      } else if (var2 instanceof Integer) {
         this.f((Integer)var2);
      } else if (var2 instanceof Float) {
         this.a((Float)var2);
      } else if (var2 instanceof Long) {
         this.a((Long)var2);
      } else if (var2 instanceof Double) {
         this.a((Double)var2);
      } else if (var2.getClass().isArray()) {
         this.c.append('{');
         if (var2 instanceof byte[]) {
            byte[] var11 = (byte[])var2;

            for(int var18 = 0; var18 < var11.length; ++var18) {
               this.d(var18);
               this.a(var11[var18]);
            }
         } else if (var2 instanceof boolean[]) {
            boolean[] var10 = (boolean[])var2;

            for(int var17 = 0; var17 < var10.length; ++var17) {
               this.d(var17);
               this.a(var10[var17]);
            }
         } else if (var2 instanceof short[]) {
            short[] var9 = (short[])var2;

            for(int var16 = 0; var16 < var9.length; ++var16) {
               this.d(var16);
               this.a(var9[var16]);
            }
         } else if (var2 instanceof char[]) {
            char[] var8 = (char[])var2;

            for(int var15 = 0; var15 < var8.length; ++var15) {
               this.d(var15);
               this.a(var8[var15]);
            }
         } else if (var2 instanceof int[]) {
            int[] var7 = (int[])var2;

            for(int var14 = 0; var14 < var7.length; ++var14) {
               this.d(var14);
               this.f(var7[var14]);
            }
         } else if (var2 instanceof long[]) {
            long[] var6 = (long[])var2;

            for(int var13 = 0; var13 < var6.length; ++var13) {
               this.d(var13);
               this.a(var6[var13]);
            }
         } else if (var2 instanceof float[]) {
            float[] var5 = (float[])var2;

            for(int var12 = 0; var12 < var5.length; ++var12) {
               this.d(var12);
               this.a(var5[var12]);
            }
         } else if (var2 instanceof double[]) {
            double[] var3 = (double[])var2;

            for(int var4 = 0; var4 < var3.length; ++var4) {
               this.d(var4);
               this.a(var3[var4]);
            }
         }

         this.c.append('}');
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void a(Unknown35 var1) {
      this.e(var1);
   }

   @Override
   public void a(int var1, String var2, String var3, String var4, boolean var5) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ');
      this.b(0, var2);
      this.c.append('.').append(var3).append(' ');
      this.b(3, var4);
      if (var5) {
         this.c.append(" (itf)");
      }

      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void c() {
   }

   public Asm33 e(String var1, boolean var2) {
      return this.c(var1, var2);
   }

   @Override
   public Am35 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      this.c.setLength(0);
      this.c.append(this.q).append("LOCALVARIABLE @");
      this.b(1, var6);
      this.c.append('(');
      this.a.add(this.c.toString());
      this.c.setLength(0);
      this.c.append(") : ");
      this.b(var1);
      this.c.append(", ").append(var2);

      for(int var10 = 0; var10 < var3.length; ++var10) {
         this.c.append(" [ ");
         this.b(var3[var10]);
         this.c.append(" - ");
         this.b(var4[var10]);
         this.c.append(" - ").append(var5[var10]).append(" ]");
      }

      this.c.append(var7 ? "\n" : " // invisible\n");
      return this.a(this.c.toString());
   }

   @Override
   public Am35 b(String var1, String var2) {
      return this.a(var1, var2);
   }

   @Override
   public Am35 a(String var1, int var2, String var3) {
      this.c.setLength(0);
      if ((var2 & 32) != 0) {
         this.c.append("open ");
      }

      this.c.append("module ").append(var1).append(" { ").append(var3 == null ? "" : "// " + var3).append("\n\n");
      this.a.add(this.c.toString());
      return this.a(null);
   }

   private void a(String var1, String var2, int var3, String[] var4) {
      this.c.setLength(0);
      this.c.append(this.u).append(var1);
      this.c.append(var2);
      if (var4 != null && var4.length > 0) {
         this.c.append(" to");
      } else {
         this.c.append(';');
      }

      this.e(var3);
      if (var4 != null && var4.length > 0) {
         for(int var7 = 0; var7 < var4.length; ++var7) {
            this.c.append(this.q).append(var4[var7]);
            this.c.append(var7 != var4.length - 1 ? ",\n" : ";\n");
         }
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void c(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ').append(var1 == 188 ? f[var2] : Integer.toString(var2)).append('\n');
      this.a.add(this.c.toString());
   }

   public void e(Unknown35 var1) {
      this.c.setLength(0);
      this.c.append(this.u).append("ATTRIBUTE ");
      this.b(-1, var1.a);
      if (var1 instanceof fJ) {
         if (this.x == null) {
            this.x = new HashMap();
         }

         ((fJ)var1).a(this.c, this.x);
      } else {
         this.c.append(" : unknown\n");
      }

      this.a.add(this.c.toString());
   }

   public Asm33 b() {
      this.a.add(this.q + "default=");
      return this.a("\n");
   }

   @Override
   public Am35 b(String var1, boolean var2) {
      return this.a(var1, var2);
   }

   @Override
   public void a(Object var1) {
      this.c.setLength(0);
      this.c.append(this.q).append("LDC ");
      if (var1 instanceof String) {
         a(this.c, (String)var1);
      } else if (var1 instanceof Unknown357) {
         this.c.append(((Unknown357)var1).f()).append(".class");
      } else {
         this.c.append(var1);
      }

      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void b(String var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("// parameter ");
      this.c(var2);
      this.c.append(' ').append(var1 == null ? "<no name>" : var1).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void b(String var1, int var2, String[] var3) {
      this.a("exports ", var1, var2, var3);
   }

   private void a(byte var1) {
      this.c.append("(byte)").append(var1);
   }

   protected void b(int var1, String var2) {
      if (var1 != 5 && var1 != 2 && var1 != 4) {
         this.c.append(var2);
      } else if (var2 != null) {
         this.c.append("// signature ").append(var2).append('\n');
      }

   }

   @Override
   public void a(int var1, Unknown246 var2) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ');
      this.b(var2);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   private void a(boolean var1) {
      this.c.append(var1);
   }

   private Asm33 a(String var1) {
      Asm33 var2 = this.a();
      this.a.add(var2.a());
      if (var1 != null) {
         this.a.add(var1);
      }

      return var2;
   }

   @Override
   public void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4) {
      this.c.setLength(0);
      this.c.append(this.q).append("TRYCATCHBLOCK ");
      this.b(var1);
      this.c.append(' ');
      this.b(var2);
      this.c.append(' ');
      this.b(var3);
      this.c.append(' ');
      this.b(0, var4);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6) {
      this.c.setLength(0);
      this.c.append(this.q).append("LOCALVARIABLE ").append(var1).append(' ');
      this.b(1, var2);
      this.c.append(' ');
      this.b(var4);
      this.c.append(' ');
      this.b(var5);
      this.c.append(' ').append(var6).append('\n');
      if (var3 != null) {
         this.c.append(this.q);
         this.b(2, var3);
         this.c.append(this.q);
         this.b(var1, var3);
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void a(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("IINC ").append(var1).append(' ').append(var2).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(int var1, String var2, String var3, String var4, Object var5) {
      return this.a(var1, var2, var3, var4, var5);
   }

   protected void b(Unknown246 var1) {
      if (this.x == null) {
         this.x = new HashMap();
      }

      String var2 = (String)this.x.get(var1);
      if (var2 == null) {
         var2 = "L" + this.x.size();
         this.x.put(var1, var2);
      }

      this.c.append(var2);
   }

   private void a(double var1) {
      this.c.append(var1).append('D');
   }

   @Override
   public void d(String var1) {
      this.c.setLength(0);
      this.c.append(this.u).append("PERMITTEDSUBTYPE ");
      this.b(0, var1);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void b(Unknown35 var1) {
      this.a.add("\n");
      this.e(var1);
   }

   @Override
   public Am35 e(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a(var1, var2, var3, var4);
   }

   private void b(int var1) {
      Asm30 var4 = new Asm30(var1);
      switch(var4.b()) {
         case 0:
            this.c.append("CLASS_TYPE_PARAMETER ").append(var4.d());
            break;
         case 1:
            this.c.append("METHOD_TYPE_PARAMETER ").append(var4.d());
            break;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 59:
         case 60:
         case 61:
         case 62:
         case 63:
         default:
            throw new IllegalArgumentException();
         case 16:
            this.c.append("CLASS_EXTENDS ").append(var4.f());
            break;
         case 17:
            this.c.append("CLASS_TYPE_PARAMETER_BOUND ").append(var4.d()).append(", ").append(var4.i());
            break;
         case 18:
            this.c.append("METHOD_TYPE_PARAMETER_BOUND ").append(var4.d()).append(", ").append(var4.i());
            break;
         case 19:
            this.c.append("FIELD");
            break;
         case 20:
            this.c.append("METHOD_RETURN");
            break;
         case 21:
            this.c.append("METHOD_RECEIVER");
            break;
         case 22:
            this.c.append("METHOD_FORMAL_PARAMETER ").append(var4.e());
            break;
         case 23:
            this.c.append("THROWS ").append(var4.g());
            break;
         case 64:
            this.c.append("LOCAL_VARIABLE");
            break;
         case 65:
            this.c.append("RESOURCE_VARIABLE");
            break;
         case 66:
            this.c.append("EXCEPTION_PARAMETER ").append(var4.h());
            break;
         case 67:
            this.c.append("INSTANCEOF");
            break;
         case 68:
            this.c.append("NEW");
            break;
         case 69:
            this.c.append("CONSTRUCTOR_REFERENCE");
            break;
         case 70:
            this.c.append("METHOD_REFERENCE");
            break;
         case 71:
            this.c.append("CAST ").append(var4.a());
            break;
         case 72:
            this.c.append("CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT ").append(var4.a());
            break;
         case 73:
            this.c.append("METHOD_INVOCATION_TYPE_ARGUMENT ").append(var4.a());
            break;
         case 74:
            this.c.append("CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT ").append(var4.a());
            break;
         case 75:
            this.c.append("METHOD_REFERENCE_TYPE_ARGUMENT ").append(var4.a());
      }

   }

   @Override
   public void b(String var1) {
      this.c.setLength(0);
      this.c.append("  // package ").append(var1).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 c(int var1, Unknown186 var2, String var3, boolean var4) {
      this.a.add("\n");
      return this.a(var1, var2, var3, var4);
   }

   @Override
   public void a(String var1, String var2) {
      this.c.setLength(0);
      if (var1 != null) {
         this.c.append(this.u).append("// compiled from: ").append(var1).append('\n');
      }

      if (var2 != null) {
         this.c.append(this.u).append("// debug info: ").append(var2).append('\n');
      }

      if (this.c.length() > 0) {
         this.a.add(this.c.toString());
      }

   }

   @Override
   public Am35 b(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a(var1, var2, var3, var4);
   }

   private void f(int var1) {
      this.c.append(var1);
   }

   @Override
   public void a(Unknown246 var1) {
      this.c.setLength(0);
      this.c.append(this.r);
      this.b(var1);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(int var1, Unknown186 var2, String var3, boolean var4) {
      this.c.setLength(0);
      this.c.append(this.q).append("TRYCATCHBLOCK @");
      this.b(1, var3);
      this.c.append('(');
      this.a.add(this.c.toString());
      this.c.setLength(0);
      this.c.append(") : ");
      this.b(var1);
      this.c.append(", ").append(var2);
      this.c.append(var4 ? "\n" : " // invisible\n");
      return this.a(this.c.toString());
   }

   @Override
   public void a(int var1, String var2) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ');
      this.b(0, var2);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   private void b(String var1, String var2) {
      pE var5 = new pE(this.v);
      new p8(var2).b(var5);
      this.c.append("// declaration: ");
      if (var5.e() != null) {
         this.c.append(var5.e());
         this.c.append(' ');
      }

      this.c.append(var1);
      this.c.append(var5.b());
      if (var5.f() != null) {
         this.c.append(" throws ").append(var5.f());
      }

      this.c.append('\n');
   }

   private void c(int var1) {
      if ((var1 & 1) != 0) {
         this.c.append("public ");
      }

      if ((var1 & 2) != 0) {
         this.c.append("private ");
      }

      if ((var1 & 4) != 0) {
         this.c.append("protected ");
      }

      if ((var1 & 16) != 0) {
         this.c.append("final ");
      }

      if ((var1 & 8) != 0) {
         this.c.append("static ");
      }

      if ((var1 & 32) != 0) {
         this.c.append("synchronized ");
      }

      if ((var1 & 64) != 0) {
         this.c.append("volatile ");
      }

      if ((var1 & 128) != 0) {
         this.c.append("transient ");
      }

      if ((var1 & 1024) != 0) {
         this.c.append("abstract ");
      }

      if ((var1 & 2048) != 0) {
         this.c.append("strictfp ");
      }

      if ((var1 & 4096) != 0) {
         this.c.append("synthetic ");
      }

      if ((var1 & 32768) != 0) {
         this.c.append("mandated ");
      }

      if ((var1 & 16384) != 0) {
         this.c.append("enum ");
      }

   }

   @Override
   public void d(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ').append(var2).append('\n');
      this.a.add(this.c.toString());
   }

   public Asm33 a(int var1, Unknown186 var2, String var3, boolean var4) {
      this.c.setLength(0);
      this.c.append(this.u).append('@');
      this.b(1, var3);
      this.c.append('(');
      this.a.add(this.c.toString());
      this.c.setLength(0);
      this.c.append(") : ");
      this.b(var1);
      this.c.append(", ").append(var2);
      this.c.append(var4 ? "\n" : " // invisible\n");
      return this.a(this.c.toString());
   }

   @Override
   public void a(String var1, String var2, Unknown137 var3, Object[] var4) {
      this.c.setLength(0);
      this.c.append(this.q).append("INVOKEDYNAMIC").append(' ');
      this.c.append(var1);
      this.b(3, var2);
      this.c.append(" [");
      this.c.append('\n');
      this.c.append(this.k);
      this.a(var3);
      this.c.append('\n');
      this.c.append(this.k).append("// arguments:");
      if (var4.length == 0) {
         this.c.append(" none");
      } else {
         this.c.append('\n');

         for(Object var10 : var4) {
            this.c.append(this.k);
            if (var10 instanceof String) {
               a(this.c, (String)var10);
            } else if (var10 instanceof Unknown357) {
               Unknown357 var11 = (Unknown357)var10;
               if (var11.k() == 11) {
                  this.b(3, var11.f());
               } else {
                  this.a(var11);
               }
            } else if (var10 instanceof Unknown137) {
               this.a((Unknown137)var10);
            } else {
               this.c.append(var10);
            }

            this.c.append(", \n");
         }

         this.c.setLength(this.c.length() - 3);
      }

      this.c.append('\n');
      this.c.append(this.q).append("]\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void i() {
   }

   @Override
   public void b() {
   }

   @Override
   public Am35 c(String var1, boolean var2) {
      return this.d(var1, var2);
   }

   public Asm33 a(int var1, String var2, String var3, String var4, Object var5) {
      this.c.setLength(0);
      this.c.append('\n');
      if ((var1 & 131072) != 0) {
         this.c.append(this.u).append("// DEPRECATED\n");
      }

      this.c.append(this.u);
      this.e(var1);
      if (var4 != null) {
         this.c.append(this.u);
         this.b(2, var4);
         this.c.append(this.u);
         this.b(var2, var4);
      }

      this.c.append(this.u);
      this.c(var1);
      this.b(1, var3);
      this.c.append(' ').append(var2);
      if (var5 != null) {
         this.c.append(" = ");
         if (var5 instanceof String) {
            this.c.append('"').append(var5).append('"');
         } else {
            this.c.append(var5);
         }
      }

      this.c.append('\n');
      this.a.add(this.c.toString());
      return this.a(null);
   }

   @Override
   public Am35 a(int var1, String var2, String var3, String var4, String[] var5) {
      return this.a(var1, var2, var3, var4, var5);
   }

   @Override
   public void g() {
   }

   @Override
   public void b(String var1, int var2, String var3) {
      this.c.setLength(0);
      this.c.append(this.u).append("requires ");
      if ((var2 & 32) != 0) {
         this.c.append("transitive ");
      }

      if ((var2 & 64) != 0) {
         this.c.append("static ");
      }

      this.c.append(var1).append(';');
      this.e(var2);
      if (var3 != null) {
         this.c.append("  // version ").append(var3).append('\n');
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void a(int var1, int var2, Unknown246 var3, Unknown246[] var4) {
      this.c.setLength(0);
      this.c.append(this.q).append("TABLESWITCH\n");

      for(int var7 = 0; var7 < var4.length; ++var7) {
         this.c.append(this.k).append(var1 + var7).append(": ");
         this.b(var4[var7]);
         this.c.append('\n');
      }

      this.c.append(this.k).append("default: ");
      this.b(var3);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   private void a(char var1) {
      this.c.append("(char)").append(var1);
   }

   @Override
   public void e() {
   }

   @Override
   public Am35 d(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a(var1, var2, var3, var4);
   }

   @Override
   public void c(int var1, String var2, String var3, String var4) {
      this.c.setLength(0);
      this.c.append(this.q).append(h[var1]).append(' ');
      this.b(0, var2);
      this.c.append('.').append(var3).append(" : ");
      this.b(1, var4);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   private void e(int var1) {
      this.c.append("// access flags 0x").append(Integer.toHexString(var1).toUpperCase()).append('\n');
   }

   public Asm33 c(String var1, boolean var2) {
      this.c.setLength(0);
      this.c.append(this.u).append('@');
      this.b(1, var1);
      this.c.append('(');
      this.a.add(this.c.toString());
      return this.a(var2 ? ")\n" : ") // invisible\n");
   }

   public Asm33 a(String var1, boolean var2) {
      this.a.add("\n");
      return this.c(var1, var2);
   }

   static void a(String[] var0, PrintWriter var1, PrintWriter var2) {
      a(
         var0,
         "Prints a disassembled view of the given class.\nUsage: Textifier [-debug] <fully qualified class name or class file name>",
         new Asm33(),
         var1,
         var2
      );
   }

   @Override
   public void d() {
   }

   @Override
   public void c(Unknown35 var1) {
      this.e(var1);
   }

   private void a(Unknown357 var1) {
      this.c.append(var1.b()).append(".class");
   }

   private void d(int var1) {
      if (var1 > 0) {
         this.c.append(", ");
      }

   }

   @Override
   public void a(String var1, String[] var2) {
      this.c.setLength(0);
      this.c.append(this.u).append("provides ");
      this.b(0, var1);
      this.c.append(" with\n");

      for(int var5 = 0; var5 < var2.length; ++var5) {
         this.c.append(this.q);
         this.b(0, var2[var5]);
         this.c.append(var5 != var2.length - 1 ? ",\n" : ";\n");
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void c(String var1) {
      this.c.setLength(0);
      this.c.append("  // main class ").append(var1).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void b(int var1, Unknown246 var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("LINENUMBER ").append(var1).append(' ');
      this.b(var2);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 f(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a(var1, var2, var3, var4);
   }

   private void a(float var1) {
      this.c.append(var1).append('F');
   }

   @Override
   public void d(Unknown35 var1) {
      this.e(var1);
   }

   public Asm33() {
      this(458752);
      if (this.getClass() != Asm33.class) {
         throw new IllegalStateException();
      }
   }

   private void a(int var1, Object[] var2) {
      for(int var3 = 0; var3 < var1; ++var3) {
         if (var3 > 0) {
            this.c.append(' ');
         }

         if (var2[var3] instanceof String) {
            String var4 = (String)var2[var3];
            if (var4.charAt(0) == '[') {
               this.b(1, var4);
            } else {
               this.b(0, var4);
            }
         } else if (var2[var3] instanceof Integer) {
            this.c.append((String)j.get(var2[var3]));
         } else {
            this.b((Unknown246)var2[var3]);
         }
      }

   }

   @Override
   public void a(String var1, int var2, String[] var3) {
      this.a("opens ", var1, var2, var3);
   }

   @Override
   public void a(String var1) {
      this.c.setLength(0);
      this.c.append(this.u).append("NESTMEMBER ");
      this.b(0, var1);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, String var2, String var3) {
      this.c.setLength(0);
      this.c.append(this.u).append("OUTERCLASS ");
      this.b(0, var1);
      this.c.append(' ');
      if (var2 != null) {
         this.c.append(var2).append(' ');
      }

      this.b(3, var3);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 h(String var1) {
      return this.i(var1);
   }

   @Override
   public Am35 d(String var1, boolean var2) {
      return this.b(var1, var2);
   }

   public Asm33 b(String var1, boolean var2) {
      return this.c(var1, var2);
   }

   @Override
   public Am35 j() {
      return this.b();
   }

   public Asm33 d(String var1, boolean var2) {
      return this.c(var1, var2);
   }

   @Override
   public void a(String var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("MULTIANEWARRAY ");
      this.b(1, var1);
      this.c.append(' ').append(var2).append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void g(String var1) {
      this.c.setLength(0);
      this.c.append(this.u).append("uses ");
      this.b(0, var1);
      this.c.append(";\n");
      this.a.add(this.c.toString());
   }

   private void a(short var1) {
      this.c.append("(short)").append(var1);
   }

   @Override
   public void b(String var1, String var2, String var3) {
      this.j(var1);
      this.b(1, var2);
      this.c.append('.').append(var3);
      this.a.add(this.c.toString());
   }

   private void a(long var1) {
      this.c.append(var1).append('L');
   }

   public Asm33 a(int var1, String var2, String var3, String var4, String[] var5) {
      this.c.setLength(0);
      this.c.append('\n');
      if ((var1 & 131072) != 0) {
         this.c.append(this.u).append("// DEPRECATED\n");
      }

      this.c.append(this.u);
      this.e(var1);
      if (var4 != null) {
         this.c.append(this.u);
         this.b(4, var4);
         this.c.append(this.u);
         this.b(var2, var4);
      }

      this.c.append(this.u);
      this.c(var1 & -193);
      if ((var1 & 256) != 0) {
         this.c.append("native ");
      }

      if ((var1 & 128) != 0) {
         this.c.append("varargs ");
      }

      if ((var1 & 64) != 0) {
         this.c.append("bridge ");
      }

      if ((this.v & 512) != 0 && (var1 & 1032) == 0) {
         this.c.append("default ");
      }

      this.c.append(var2);
      this.b(3, var3);
      if (var5 != null && var5.length > 0) {
         this.c.append(" throws ");

         for(String var11 : var5) {
            this.b(0, var11);
            this.c.append(' ');
         }
      }

      this.c.append('\n');
      this.a.add(this.c.toString());
      return this.a(null);
   }

   public Asm33 a(String var1, String var2) {
      this.j(var1);
      this.c.append('@');
      this.b(1, var2);
      this.c.append('(');
      this.a.add(this.c.toString());
      return this.a(")");
   }

   protected Asm33(int var1) {
      super(var1);
      this.q = "    ";
      this.k = "      ";
      this.r = "   ";
   }

   @Override
   public void a(String var1, String var2, String var3, int var4) {
      this.c.setLength(0);
      this.c.append(this.u);
      this.e(var4 & -33);
      this.c.append(this.u);
      this.c(var4);
      this.c.append("INNERCLASS ");
      this.b(0, var1);
      this.c.append(' ');
      this.b(0, var2);
      this.c.append(' ');
      this.b(0, var3);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(int var1, boolean var2) {
      return this.a(var1, var2);
   }

   private void j(String var1) {
      this.c.setLength(0);
      this.d(this.z++);
      if (var1 != null) {
         this.c.append(var1).append('=');
      }

   }

   @Override
   public Am35 a(int var1, String var2, boolean var3) {
      return this.a(var1, var2, var3);
   }

   public Asm33 a(int var1, String var2, boolean var3) {
      this.c.setLength(0);
      this.c.append(this.q).append('@');
      this.b(1, var2);
      this.c.append('(');
      this.a.add(this.c.toString());
      this.c.setLength(0);
      this.c.append(var3 ? ") // parameter " : ") // invisible, parameter ").append(var1).append('\n');
      return this.a(this.c.toString());
   }

   public Asm33 a(int var1, boolean var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("// annotable parameter count: ");
      this.c.append(var1);
      this.c.append(var2 ? " (visible)\n" : " (invisible)\n");
      this.a.add(this.c.toString());
      return this;
   }

   @Override
   public void b(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.q).append("MAXSTACK = ").append(var1).append('\n');
      this.a.add(this.c.toString());
      this.c.setLength(0);
      this.c.append(this.q).append("MAXLOCALS = ").append(var2).append('\n');
      this.a.add(this.c.toString());
   }

   public Asm33 i(String var1) {
      this.j(var1);
      this.c.append('{');
      this.a.add(this.c.toString());
      return this.a("}");
   }

   @Override
   public void a(Unknown246 var1, int[] var2, Unknown246[] var3) {
      this.c.setLength(0);
      this.c.append(this.q).append("LOOKUPSWITCH\n");

      for(int var6 = 0; var6 < var3.length; ++var6) {
         this.c.append(this.k).append(var2[var6]).append(": ");
         this.b(var3[var6]);
         this.c.append('\n');
      }

      this.c.append(this.k).append("default: ");
      this.b(var1);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 b(int var1, String var2, String var3, String var4) {
      this.c.setLength(0);
      this.c.append('\n');
      if ((var1 & 131072) != 0) {
         this.c.append(this.u).append("// DEPRECATED\n");
      }

      this.c.append(this.u);
      this.e(var1);
      if (var4 != null) {
         this.c.append(this.u);
         this.b(2, var4);
         this.c.append(this.u);
         this.b(var2, var4);
      }

      this.c.append(this.u);
      this.c(var1);
      this.b(1, var3);
      this.c.append(' ').append(var2);
      this.c.append('\n');
      this.a.add(this.c.toString());
      return this.a(null);
   }

   @Override
   public void e(String var1) {
      this.c.setLength(0);
      this.c.append(this.u).append("NESTHOST ");
      this.b(0, var1);
      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void a(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      this.c.setLength(0);
      this.c.append(this.r);
      this.c.append("FRAME ");
      switch(var1) {
         case -1:
         case 0:
            this.c.append("FULL [");
            this.a(var2, var3);
            this.c.append("] [");
            this.a(var4, var5);
            this.c.append(']');
            break;
         case 1:
            this.c.append("APPEND [");
            this.a(var2, var3);
            this.c.append(']');
            break;
         case 2:
            this.c.append("CHOP ").append(var2);
            break;
         case 3:
            this.c.append("SAME");
            break;
         case 4:
            this.c.append("SAME1 ");
            this.a(1, var5);
            break;
         default:
            throw new IllegalArgumentException();
      }

      this.c.append('\n');
      this.a.add(this.c.toString());
   }

   @Override
   public void f() {
      this.a.add("}\n");
   }

   protected void a(Unknown137 var1) {
      int var4 = var1.c();
      this.c.append("// handle kind 0x").append(Integer.toHexString(var4)).append(" : ");
      boolean var5 = false;
      switch(var4) {
         case 1:
            this.c.append("GETFIELD");
            break;
         case 2:
            this.c.append("GETSTATIC");
            break;
         case 3:
            this.c.append("PUTFIELD");
            break;
         case 4:
            this.c.append("PUTSTATIC");
            break;
         case 5:
            this.c.append("INVOKEVIRTUAL");
            var5 = true;
            break;
         case 6:
            this.c.append("INVOKESTATIC");
            var5 = true;
            break;
         case 7:
            this.c.append("INVOKESPECIAL");
            var5 = true;
            break;
         case 8:
            this.c.append("NEWINVOKESPECIAL");
            var5 = true;
            break;
         case 9:
            this.c.append("INVOKEINTERFACE");
            var5 = true;
            break;
         default:
            throw new IllegalArgumentException();
      }

      this.c.append('\n');
      this.c.append(this.k);
      this.b(0, var1.b());
      this.c.append('.');
      this.c.append(var1.a());
      if (!var5) {
         this.c.append('(');
      }

      this.b(9, var1.d());
      if (!var5) {
         this.c.append(')');
      }

      if (var1.e()) {
         this.c.append(" itf");
      }

   }
}
