package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.b7;
import de.jpx3.intave.eP;
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
public class Asm34 extends Am35 {
   private static final String s;
   private static final String r;
   protected final int o;
   private static final int q = 1048576;
   private static final Map p;
   private static final String i;
   private static final String v;
   private static final String n;
   private static final List k = Collections.unmodifiableList(
      Arrays.asList("Opcodes.TOP", "Opcodes.INTEGER", "Opcodes.FLOAT", "Opcodes.DOUBLE", "Opcodes.LONG", "Opcodes.NULL", "Opcodes.UNINITIALIZED_THIS")
   );
   protected Map y;
   private static final String t;
   private static final int m = 2097152;
   protected final String j;
   private static final String x;
   private static final String w;
   private static final int u = 262144;
   private static final int l = 524288;

   @Override
   public void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4) {
      this.c.setLength(0);
      this.c(var1);
      this.c(var2);
      this.c(var3);
      this.c.append(this.j).append(".visitTryCatchBlock(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void e() {
      this.a.add("moduleVisitor.visitEnd();\n");
   }

   public Asm34 a() {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".visitAnnotationDefault();\n");
      this.a.add(this.c.toString());
      Asm34 var3 = this.a("annotationVisitor", 0);
      this.a.add(var3.a());
      this.a.add("}\n");
      return var3;
   }

   @Override
   public void a(String var1) {
      this.c.setLength(0);
      this.c.append("classWriter.visitNestMember(");
      this.b(var1);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void b(String var1, int var2, String var3) {
      this.c.setLength(0);
      this.c.append("moduleVisitor.visitRequire(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2 | 2097152);
      this.c.append(", ");
      this.b(var3);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void d(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitVarInsn(").append(h[var1]).append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 a(String var1, int var2, Unknown186 var3, String var4, boolean var5) {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".").append(var1).append("(").append(var2);
      if (var3 == null) {
         this.c.append(", null, ");
      } else {
         this.c.append(", TypePath.fromString(\"").append(var3).append("\"), ");
      }

      this.b(var4);
      this.c.append(", ").append(var5).append(");\n");
      this.a.add(this.c.toString());
      Asm34 var8 = this.a("annotationVisitor", 0);
      this.a.add(var8.a());
      this.a.add("}\n");
      return var8;
   }

   @Override
   public void a(Unknown35 var1) {
      this.e(var1);
   }

   @Override
   public void b(String var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitParameter(");
      a(this.c, var1);
      this.c.append(", ");
      this.b(var2);
      this.a.add(this.c.append(");\n").toString());
   }

   public Asm34 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a("visitTryCatchAnnotation", var1, var2, var3, var4);
   }

   @Override
   public void c(String var1) {
      this.c.setLength(0);
      this.c.append("moduleVisitor.visitMainClass(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 d(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.c(var1, var2, var3, var4);
   }

   @Override
   public Am35 j() {
      return this.a();
   }

   @Override
   public Am35 a(int var1, String var2, boolean var3) {
      return this.a(var1, var2, var3);
   }

   @Override
   public void a(String var1, Object var2) {
      this.c.setLength(0);
      this.c.append("annotationVisitor").append(this.o).append(".visit(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   protected void b(Unknown246 var1) {
      this.c.append((String)this.y.get(var1));
   }

   private void b(int var1) {
      boolean var4 = true;
      if ((var1 & 1) != 0) {
         this.c.append("ACC_PUBLIC");
         var4 = false;
      }

      if ((var1 & 2) != 0) {
         this.c.append("ACC_PRIVATE");
         var4 = false;
      }

      if ((var1 & 4) != 0) {
         this.c.append("ACC_PROTECTED");
         var4 = false;
      }

      if ((var1 & 16) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         if ((var1 & 2097152) == 0) {
            this.c.append("ACC_FINAL");
         } else {
            this.c.append("ACC_TRANSITIVE");
         }

         var4 = false;
      }

      if ((var1 & 8) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_STATIC");
         var4 = false;
      }

      if ((var1 & 32) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         if ((var1 & 262144) == 0) {
            if ((var1 & 2097152) == 0) {
               this.c.append("ACC_SYNCHRONIZED");
            } else {
               this.c.append("ACC_TRANSITIVE");
            }
         } else {
            this.c.append("ACC_SUPER");
         }

         var4 = false;
      }

      if ((var1 & 64) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         if ((var1 & 524288) == 0) {
            if ((var1 & 2097152) == 0) {
               this.c.append("ACC_BRIDGE");
            } else {
               this.c.append("ACC_STATIC_PHASE");
            }
         } else {
            this.c.append("ACC_VOLATILE");
         }

         var4 = false;
      }

      if ((var1 & 128) != 0 && (var1 & 786432) == 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_VARARGS");
         var4 = false;
      }

      if ((var1 & 128) != 0 && (var1 & 524288) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_TRANSIENT");
         var4 = false;
      }

      if ((var1 & 256) != 0 && (var1 & 786432) == 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_NATIVE");
         var4 = false;
      }

      if ((var1 & 16384) != 0 && (var1 & 1835008) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_ENUM");
         var4 = false;
      }

      if ((var1 & 8192) != 0 && (var1 & 1310720) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_ANNOTATION");
         var4 = false;
      }

      if ((var1 & 1024) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_ABSTRACT");
         var4 = false;
      }

      if ((var1 & 512) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_INTERFACE");
         var4 = false;
      }

      if ((var1 & 2048) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_STRICT");
         var4 = false;
      }

      if ((var1 & 4096) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_SYNTHETIC");
         var4 = false;
      }

      if ((var1 & 131072) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         this.c.append("ACC_DEPRECATED");
         var4 = false;
      }

      if ((var1 & 32768) != 0) {
         if (!var4) {
            this.c.append(" | ");
         }

         if ((var1 & 262144) == 0) {
            this.c.append("ACC_MANDATED");
         } else {
            this.c.append("ACC_MODULE");
         }

         var4 = false;
      }

      if (var4) {
         this.c.append('0');
      }

   }

   @Override
   public void c(Unknown35 var1) {
      this.c.setLength(0);
      this.c.append("// ATTRIBUTE ").append(var1.a).append('\n');
      if (var1 instanceof eP) {
         if (this.y == null) {
            this.y = new HashMap();
         }

         this.c.append("{\n");
         ((eP)var1).a(this.c, "attribute", this.y);
         this.c.append(this.j).append(".visitAttributeExperimental(attribute);\n");
         this.c.append("}\n");
      }

      this.a.add(this.c.toString());
   }

   static void a(String[] var0, PrintWriter var1, PrintWriter var2) {
      a(
         var0,
         "Prints the ASM code to generate the given class.\nUsage: ASMifier [-debug] <fully qualified class name or class file name>",
         new Asm34(),
         var1,
         var2
      );
   }

   @Override
   public void b(String var1, String var2, String var3) {
      this.c.setLength(0);
      this.c.append("annotationVisitor").append(this.o).append(".visitEnum(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, String var2, String var3, int var4) {
      this.c.setLength(0);
      this.c.append("classWriter.visitInnerClass(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4 | 1048576);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 f(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.f(var1, var2, var3, var4);
   }

   @Override
   public void a(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      String var9;
      if (var3 == null) {
         var9 = "module-info";
      } else {
         int var10 = var3.lastIndexOf(47);
         if (var10 == -1) {
            var9 = var3;
         } else {
            this.a.add("package asm." + var3.substring(0, var10).replace('/', '.') + ";\n");
            var9 = var3.substring(var10 + 1).replaceAll("[-\\(\\)]", "_");
         }
      }

      this.a.add("import org.objectweb.asm.AnnotationVisitor;\n");
      this.a.add("import org.objectweb.asm.Attribute;\n");
      this.a.add("import org.objectweb.asm.ClassReader;\n");
      this.a.add("import org.objectweb.asm.ClassWriter;\n");
      this.a.add("import org.objectweb.asm.ConstantDynamic;\n");
      this.a.add("import org.objectweb.asm.FieldVisitor;\n");
      this.a.add("import org.objectweb.asm.Handle;\n");
      this.a.add("import org.objectweb.asm.Label;\n");
      this.a.add("import org.objectweb.asm.MethodVisitor;\n");
      this.a.add("import org.objectweb.asm.Opcodes;\n");
      this.a.add("import org.objectweb.asm.RecordComponentVisitor;\n");
      this.a.add("import org.objectweb.asm.Type;\n");
      this.a.add("import org.objectweb.asm.TypePath;\n");
      this.a.add("public class " + var9 + "Dump implements Opcodes {\n\n");
      this.a.add("public static byte[] dump () throws Exception {\n\n");
      this.a.add("ClassWriter classWriter = new ClassWriter(0);\n");
      this.a.add("FieldVisitor fieldVisitor;\n");
      this.a.add("RecordComponentVisitor recordComponentVisitor;\n");
      this.a.add("MethodVisitor methodVisitor;\n");
      this.a.add("AnnotationVisitor annotationVisitor0;\n\n");
      this.c.setLength(0);
      this.c.append("classWriter.visit(");
      String var12 = (String)p.get(var1);
      if (var12 != null) {
         this.c.append(var12);
      } else {
         this.c.append(var1);
      }

      this.c.append(", ");
      this.b(var2 | 262144);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(", ");
      this.b(var5);
      this.c.append(", ");
      if (var6 != null && var6.length > 0) {
         this.c.append("new String[] {");

         for(int var11 = 0; var11 < var6.length; ++var11) {
            this.c.append(var11 == 0 ? " " : ", ");
            this.b(var6[var11]);
         }

         this.c.append(" }");
      } else {
         this.c.append("null");
      }

      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 h(String var1) {
      return this.a(var1);
   }

   @Override
   public void g() {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitEnd();\n");
      this.a.add(this.c.toString());
   }

   public Asm34 a(String var1, boolean var2) {
      return this.e(var1, var2);
   }

   protected Asm34(int var1, String var2, int var3) {
      super(var1);
      this.j = var2;
      this.o = var3;
   }

   @Override
   public void b() {
      this.c.setLength(0);
      this.c.append("annotationVisitor").append(this.o).append(".visitEnd();\n");
      this.a.add(this.c.toString());
   }

   public Asm34 a(int var1, String var2, String var3, String var4, Object var5) {
      this.c.setLength(0);
      this.c.append("{\n");
      this.c.append("fieldVisitor = classWriter.visitField(");
      this.b(var1 | 524288);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(", ");
      this.b(var5);
      this.c.append(");\n");
      this.a.add(this.c.toString());
      Asm34 var8 = this.a("fieldVisitor", 0);
      this.a.add(var8.a());
      this.a.add("}\n");
      return var8;
   }

   @Override
   public void a(String var1, int var2, String[] var3) {
      this.a("moduleVisitor.visitOpen(", var1, var2, var3);
   }

   @Override
   public Am35 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".visitLocalVariableAnnotation(").append(var1);
      if (var2 == null) {
         this.c.append(", null, ");
      } else {
         this.c.append(", TypePath.fromString(\"").append(var2).append("\"), ");
      }

      this.c.append("new Label[] {");

      for(int var10 = 0; var10 < var3.length; ++var10) {
         this.c.append(var10 == 0 ? " " : ", ");
         this.b(var3[var10]);
      }

      this.c.append(" }, new Label[] {");

      for(int var11 = 0; var11 < var4.length; ++var11) {
         this.c.append(var11 == 0 ? " " : ", ");
         this.b(var4[var11]);
      }

      this.c.append(" }, new int[] {");

      for(int var12 = 0; var12 < var5.length; ++var12) {
         this.c.append(var12 == 0 ? " " : ", ").append(var5[var12]);
      }

      this.c.append(" }, ");
      this.b(var6);
      this.c.append(", ").append(var7).append(");\n");
      this.a.add(this.c.toString());
      Asm34 var13 = this.a("annotationVisitor", 0);
      this.a.add(var13.a());
      this.a.add("}\n");
      return var13;
   }

   @Override
   public void g(String var1) {
      this.c.setLength(0);
      this.c.append("moduleVisitor.visitUse(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(int var1, String var2, String var3, String var4, String[] var5) {
      return this.a(var1, var2, var3, var4, var5);
   }

   public Asm34 a(int var1, boolean var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitAnnotableParameterCount(").append(var1).append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
      return this;
   }

   @Override
   public Am35 e(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.g(var1, var2, var3, var4);
   }

   @Override
   public Am35 d(String var1, boolean var2) {
      return this.a(var1, var2);
   }

   protected void b(Object var1) {
      if (var1 == null) {
         this.c.append("null");
      } else if (var1 instanceof String) {
         a(this.c, (String)var1);
      } else if (var1 instanceof Unknown357) {
         this.c.append("Type.getType(\"");
         this.c.append(((Unknown357)var1).f());
         this.c.append("\")");
      } else if (var1 instanceof Unknown137) {
         this.c.append("new Handle(");
         Unknown137 var4 = (Unknown137)var1;
         this.c.append("Opcodes.").append(e[var4.c()]).append(", \"");
         this.c.append(var4.b()).append("\", \"");
         this.c.append(var4.a()).append("\", \"");
         this.c.append(var4.d()).append("\", ");
         this.c.append(var4.e()).append(")");
      } else if (var1 instanceof b7) {
         this.c.append("new ConstantDynamic(\"");
         b7 var7 = (b7)var1;
         this.c.append(var7.c()).append("\", \"");
         this.c.append(var7.b()).append("\", ");
         this.b(var7.d());
         this.c.append(", new Object[] {");
         int var5 = var7.e();

         for(int var6 = 0; var6 < var5; ++var6) {
            this.b(var7.a(var6));
            if (var6 != var5 - 1) {
               this.c.append(", ");
            }
         }

         this.c.append("})");
      } else if (var1 instanceof Byte) {
         this.c.append("new Byte((byte)").append(var1).append(')');
      } else if (var1 instanceof Boolean) {
         this.c.append((Boolean)var1 ? "Boolean.TRUE" : "Boolean.FALSE");
      } else if (var1 instanceof Short) {
         this.c.append("new Short((short)").append(var1).append(')');
      } else if (var1 instanceof Character) {
         this.c.append("new Character((char)").append((Character)var1).append(')');
      } else if (var1 instanceof Integer) {
         this.c.append("new Integer(").append(var1).append(')');
      } else if (var1 instanceof Float) {
         this.c.append("new Float(\"").append(var1).append("\")");
      } else if (var1 instanceof Long) {
         this.c.append("new Long(").append(var1).append("L)");
      } else if (var1 instanceof Double) {
         this.c.append("new Double(\"").append(var1).append("\")");
      } else if (var1 instanceof byte[]) {
         byte[] var8 = (byte[])var1;
         this.c.append("new byte[] {");

         for(int var16 = 0; var16 < var8.length; ++var16) {
            this.c.append(var16 == 0 ? "" : ",").append(var8[var16]);
         }

         this.c.append('}');
      } else if (var1 instanceof boolean[]) {
         boolean[] var9 = (boolean[])var1;
         this.c.append("new boolean[] {");

         for(int var17 = 0; var17 < var9.length; ++var17) {
            this.c.append(var17 == 0 ? "" : ",").append(var9[var17]);
         }

         this.c.append('}');
      } else if (var1 instanceof short[]) {
         short[] var10 = (short[])var1;
         this.c.append("new short[] {");

         for(int var18 = 0; var18 < var10.length; ++var18) {
            this.c.append(var18 == 0 ? "" : ",").append("(short)").append(var10[var18]);
         }

         this.c.append('}');
      } else if (var1 instanceof char[]) {
         char[] var11 = (char[])var1;
         this.c.append("new char[] {");

         for(int var19 = 0; var19 < var11.length; ++var19) {
            this.c.append(var19 == 0 ? "" : ",").append("(char)").append(var11[var19]);
         }

         this.c.append('}');
      } else if (var1 instanceof int[]) {
         int[] var12 = (int[])var1;
         this.c.append("new int[] {");

         for(int var20 = 0; var20 < var12.length; ++var20) {
            this.c.append(var20 == 0 ? "" : ",").append(var12[var20]);
         }

         this.c.append('}');
      } else if (var1 instanceof long[]) {
         long[] var13 = (long[])var1;
         this.c.append("new long[] {");

         for(int var21 = 0; var21 < var13.length; ++var21) {
            this.c.append(var21 == 0 ? "" : ",").append(var13[var21]).append('L');
         }

         this.c.append('}');
      } else if (var1 instanceof float[]) {
         float[] var14 = (float[])var1;
         this.c.append("new float[] {");

         for(int var22 = 0; var22 < var14.length; ++var22) {
            this.c.append(var22 == 0 ? "" : ",").append(var14[var22]).append('f');
         }

         this.c.append('}');
      } else if (var1 instanceof double[]) {
         double[] var15 = (double[])var1;
         this.c.append("new double[] {");

         for(int var23 = 0; var23 < var15.length; ++var23) {
            this.c.append(var23 == 0 ? "" : ",").append(var15[var23]).append('d');
         }

         this.c.append('}');
      }

   }

   @Override
   public void f() {
      this.a.add("classWriter.visitEnd();\n\n");
      this.a.add("return classWriter.toByteArray();\n");
      this.a.add("}\n");
      this.a.add("}\n");
   }

   @Override
   public void a(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      this.c.setLength(0);
      switch(var1) {
         case -1:
         case 0:
            this.a(var2, var3);
            this.a(var4, var5);
            if (var1 == -1) {
               this.c.append(this.j).append(".visitFrame(Opcodes.F_NEW, ");
            } else {
               this.c.append(this.j).append(".visitFrame(Opcodes.F_FULL, ");
            }

            this.c.append(var2).append(", new Object[] {");
            this.b(var2, var3);
            this.c.append("}, ").append(var4).append(", new Object[] {");
            this.b(var4, var5);
            this.c.append('}');
            break;
         case 1:
            this.a(var2, var3);
            this.c.append(this.j).append(".visitFrame(Opcodes.F_APPEND,").append(var2).append(", new Object[] {");
            this.b(var2, var3);
            this.c.append("}, 0, null");
            break;
         case 2:
            this.c.append(this.j).append(".visitFrame(Opcodes.F_CHOP,").append(var2).append(", null, 0, null");
            break;
         case 3:
            this.c.append(this.j).append(".visitFrame(Opcodes.F_SAME, 0, null, 0, null");
            break;
         case 4:
            this.a(1, var5);
            this.c.append(this.j).append(".visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {");
            this.b(1, var5);
            this.c.append('}');
            break;
         default:
            throw new IllegalArgumentException();
      }

      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   private void b(int var1, Object[] var2) {
      for(int var5 = 0; var5 < var1; ++var5) {
         if (var5 > 0) {
            this.c.append(", ");
         }

         if (var2[var5] instanceof String) {
            this.b(var2[var5]);
         } else if (var2[var5] instanceof Integer) {
            this.c.append((String)k.get(var2[var5]));
         } else {
            this.b((Unknown246)var2[var5]);
         }
      }

   }

   public Asm34 g(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.d(var1, var2, var3, var4);
   }

   @Override
   public Am35 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a(var1, var2, var3, var4);
   }

   @Override
   public void c() {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitEndExperimental();\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 b(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.e(var1, var2, var3, var4);
   }

   public Asm34 a(String var1, String var2) {
      this.c.setLength(0);
      this.c.append("{\n").append("AnnotationVisitor annotationVisitor").append(this.o + 1).append(" = annotationVisitor");
      this.c.append(this.o).append(".visitAnnotation(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(");\n");
      this.a.add(this.c.toString());
      Asm34 var5 = this.a("annotationVisitor", this.o + 1);
      this.a.add(var5.a());
      this.a.add("}\n");
      return var5;
   }

   private void a(String var1, String var2, int var3, String[] var4) {
      this.c.setLength(0);
      this.c.append(var1);
      this.b(var2);
      this.c.append(", ");
      this.b(var3 | 2097152);
      if (var4 != null && var4.length > 0) {
         this.c.append(", new String[] {");

         for(int var7 = 0; var7 < var4.length; ++var7) {
            this.c.append(var7 == 0 ? " " : ", ");
            this.b(var4[var7]);
         }

         this.c.append(" }");
      }

      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 b(String var1, String var2) {
      return this.a(var1, var2);
   }

   @Override
   public void b(String var1) {
      this.c.setLength(0);
      this.c.append("moduleVisitor.visitPackage(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void d() {
      this.a.add(this.j + ".visitCode();\n");
   }

   @Override
   public void a(Unknown246 var1) {
      this.c.setLength(0);
      this.c(var1);
      this.c.append(this.j).append(".visitLabel(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(int var1) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitInsn(").append(h[var1]).append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(int var1, String var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitTypeInsn(").append(h[var1]).append(", ");
      this.b(var2);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public Am35 a(String var1, int var2, String var3) {
      this.c.setLength(0);
      this.c.append("ModuleVisitor moduleVisitor = classWriter.visitModule(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2 | 2097152);
      this.c.append(", ");
      this.b(var3);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
      Asm34 var6 = this.a("moduleVisitor", 0);
      this.a.add(var6.a());
      this.a.add("}\n");
      return var6;
   }

   public Asm34 a(String var1) {
      this.c.setLength(0);
      this.c.append("{\n");
      this.c.append("AnnotationVisitor annotationVisitor").append(this.o + 1).append(" = annotationVisitor");
      this.c.append(this.o).append(".visitArray(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
      Asm34 var4 = this.a("annotationVisitor", this.o + 1);
      this.a.add(var4.a());
      this.a.add("}\n");
      return var4;
   }

   @Override
   public Am35 a(String var1, boolean var2) {
      return this.b(var1, var2);
   }

   @Override
   public void b(int var1, Unknown246 var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitLineNumber(").append(var1).append(", ");
      this.b(var2);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void i() {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitEnd();\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(Unknown246 var1, int[] var2, Unknown246[] var3) {
      this.c.setLength(0);

      for(Unknown246 var9 : var3) {
         this.c(var9);
      }

      this.c(var1);
      this.c.append(this.j).append(".visitLookupSwitchInsn(");
      this.b(var1);
      this.c.append(", new int[] {");

      for(int var10 = 0; var10 < var2.length; ++var10) {
         this.c.append(var10 == 0 ? " " : ", ").append(var2[var10]);
      }

      this.c.append(" }, new Label[] {");

      for(int var11 = 0; var11 < var3.length; ++var11) {
         this.c.append(var11 == 0 ? " " : ", ");
         this.b(var3[var11]);
      }

      this.c.append(" });\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void b(String var1, int var2, String[] var3) {
      this.a("moduleVisitor.visitExport(", var1, var2, var3);
   }

   @Override
   public void a(String var1, String var2, Unknown137 var3, Object[] var4) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitInvokeDynamicInsn(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", new Object[]{");

      for(int var7 = 0; var7 < var4.length; ++var7) {
         this.b(var4[var7]);
         if (var7 != var4.length - 1) {
            this.c.append(", ");
         }
      }

      this.c.append("});\n");
      this.a.add(this.c.toString());
   }

   public Asm34 a(int var1, String var2, String var3, String var4) {
      this.c.setLength(0);
      this.c.append("{\n");
      this.c.append("recordComponentVisitor = classWriter.visitRecordComponentExperimental(");
      this.b(var1 | 524288);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(");\n");
      this.a.add(this.c.toString());
      Asm34 var7 = this.a("recordComponentVisitor", 0);
      this.a.add(var7.a());
      this.a.add("}\n");
      return var7;
   }

   @Override
   public Am35 a(int var1, String var2, String var3, String var4, Object var5) {
      return this.a(var1, var2, var3, var4, var5);
   }

   @Override
   public void a(String var1, String[] var2) {
      this.c.setLength(0);
      this.c.append("moduleVisitor.visitProvide(");
      this.b(var1);
      this.c.append(",  new String[] {");

      for(int var5 = 0; var5 < var2.length; ++var5) {
         this.c.append(var5 == 0 ? " " : ", ");
         this.b(var2[var5]);
      }

      this.c.append(" });\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void c(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitIntInsn(").append(h[var1]).append(", ").append(var1 == 188 ? f[var2] : Integer.toString(var2)).append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 b(String var1, boolean var2) {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".visitAnnotationExperimental(");
      this.b(var1);
      this.c.append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
      Asm34 var5 = this.a("annotationVisitor", 0);
      this.a.add(var5.a());
      this.a.add("}\n");
      return var5;
   }

   @Override
   public Am35 a(int var1, boolean var2) {
      return this.a(var1, var2);
   }

   @Override
   public Am35 c(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.b(var1, var2, var3, var4);
   }

   static {
      HashMap var11 = new HashMap();
      var11.put(196653, "V1_1");
      var11.put(46, "V1_2");
      var11.put(47, "V1_3");
      var11.put(48, "V1_4");
      var11.put(49, "V1_5");
      var11.put(50, "V1_6");
      var11.put(51, "V1_7");
      var11.put(52, "V1_8");
      var11.put(53, "V9");
      var11.put(54, "V10");
      var11.put(55, "V11");
      var11.put(56, "V12");
      var11.put(57, "V13");
      var11.put(58, "V14");
      p = Collections.unmodifiableMap(var11);
   }

   public Asm34() {
      this(458752, "classWriter", 0);
      if (this.getClass() != Asm34.class) {
         throw new IllegalStateException();
      }
   }

   @Override
   public void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitLocalVariable(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(", ");
      this.b(var5);
      this.c.append(", ").append(var6).append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 c(String var1, boolean var2) {
      return this.e(var1, var2);
   }

   public Asm34 b(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.d(var1, var2, var3, var4);
   }

   @Override
   public void a(int var1, String var2, String var3, String var4, boolean var5) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitMethodInsn(").append(h[var1]).append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(", ");
      this.c.append(var5 ? "true" : "false");
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   protected Asm34 a(String var1, int var2) {
      return new Asm34(this.b, var1, var2);
   }

   @Override
   public void e(String var1) {
      this.c.setLength(0);
      this.c.append("classWriter.visitNestHost(");
      this.b(var1);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void c(int var1, String var2, String var3, String var4) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitFieldInsn(").append(h[var1]).append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 e(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a("visitInsnAnnotation", var1, var2, var3, var4);
   }

   private void a(int var1, Object[] var2) {
      for(int var3 = 0; var3 < var1; ++var3) {
         if (var2[var3] instanceof Unknown246) {
            this.c((Unknown246)var2[var3]);
         }
      }

   }

   @Override
   public Am35 b(String var1, boolean var2) {
      return this.c(var1, var2);
   }

   @Override
   public void a(int var1, int var2, Unknown246 var3, Unknown246[] var4) {
      this.c.setLength(0);

      for(Unknown246 var10 : var4) {
         this.c(var10);
      }

      this.c(var3);
      this.c.append(this.j).append(".visitTableSwitchInsn(").append(var1).append(", ").append(var2).append(", ");
      this.b(var3);
      this.c.append(", new Label[] {");

      for(int var11 = 0; var11 < var4.length; ++var11) {
         this.c.append(var11 == 0 ? " " : ", ");
         this.b(var4[var11]);
      }

      this.c.append(" });\n");
      this.a.add(this.c.toString());
   }

   protected void c(Unknown246 var1) {
      if (this.y == null) {
         this.y = new HashMap();
      }

      String var4 = (String)this.y.get(var1);
      if (var4 == null) {
         var4 = "label" + this.y.size();
         this.y.put(var1, var4);
         this.c.append("Label ").append(var4).append(" = new Label();\n");
      }

   }

   @Override
   public void a(int var1, Unknown246 var2) {
      this.c.setLength(0);
      this.c(var2);
      this.c.append(this.j).append(".visitJumpInsn(").append(h[var1]).append(", ");
      this.b(var2);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, String var2) {
      this.c.setLength(0);
      this.c.append("classWriter.visitSource(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, String var2, String var3) {
      this.c.setLength(0);
      this.c.append("classWriter.visitOuterClass(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   public void e(Unknown35 var1) {
      this.c.setLength(0);
      this.c.append("// ATTRIBUTE ").append(var1.a).append('\n');
      if (var1 instanceof eP) {
         if (this.y == null) {
            this.y = new HashMap();
         }

         this.c.append("{\n");
         ((eP)var1).a(this.c, "attribute", this.y);
         this.c.append(this.j).append(".visitAttribute(attribute);\n");
         this.c.append("}\n");
      }

      this.a.add(this.c.toString());
   }

   @Override
   public void a(String var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitMultiANewArrayInsn(");
      this.b(var1);
      this.c.append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void b(Unknown35 var1) {
      this.e(var1);
   }

   @Override
   public void a(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitIincInsn(").append(var1).append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
   }

   @Override
   public void a(Object var1) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitLdcInsn(");
      this.b(var1);
      this.c.append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 c(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a("visitTypeAnnotationExperimental", var1, var2, var3, var4);
   }

   @Override
   public void d(Unknown35 var1) {
      this.e(var1);
   }

   public Asm34 a(int var1, String var2, boolean var3) {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".visitParameterAnnotation(").append(var1).append(", ");
      this.b(var2);
      this.c.append(", ").append(var3).append(");\n");
      this.a.add(this.c.toString());
      Asm34 var6 = this.a("annotationVisitor", 0);
      this.a.add(var6.a());
      this.a.add("}\n");
      return var6;
   }

   @Override
   public Am35 b(int var1, String var2, String var3, String var4) {
      return this.a(var1, var2, var3, var4);
   }

   @Override
   public void d(String var1) {
      this.c.setLength(0);
      this.c.append("classWriter.visitPermittedSubtypeExperimental(");
      this.b(var1);
      this.c.append(");\n\n");
      this.a.add(this.c.toString());
   }

   public Asm34 f(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.d(var1, var2, var3, var4);
   }

   @Override
   public Am35 c(String var1, boolean var2) {
      return this.d(var1, var2);
   }

   public Asm34 e(String var1, boolean var2) {
      this.c.setLength(0);
      this.c.append("{\n").append("annotationVisitor0 = ").append(this.j).append(".visitAnnotation(");
      this.b(var1);
      this.c.append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
      Asm34 var5 = this.a("annotationVisitor", 0);
      this.a.add(var5.a());
      this.a.add("}\n");
      return var5;
   }

   @Override
   public void b(int var1, int var2) {
      this.c.setLength(0);
      this.c.append(this.j).append(".visitMaxs(").append(var1).append(", ").append(var2).append(");\n");
      this.a.add(this.c.toString());
   }

   public Asm34 d(String var1, boolean var2) {
      return this.e(var1, var2);
   }

   public Asm34 a(int var1, String var2, String var3, String var4, String[] var5) {
      this.c.setLength(0);
      this.c.append("{\n");
      this.c.append("methodVisitor = classWriter.visitMethod(");
      this.b(var1);
      this.c.append(", ");
      this.b(var2);
      this.c.append(", ");
      this.b(var3);
      this.c.append(", ");
      this.b(var4);
      this.c.append(", ");
      if (var5 != null && var5.length > 0) {
         this.c.append("new String[] {");

         for(int var8 = 0; var8 < var5.length; ++var8) {
            this.c.append(var8 == 0 ? " " : ", ");
            this.b(var5[var8]);
         }

         this.c.append(" }");
      } else {
         this.c.append("null");
      }

      this.c.append(");\n");
      this.a.add(this.c.toString());
      Asm34 var9 = this.a("methodVisitor", 0);
      this.a.add(var9.a());
      this.a.add("}\n");
      return var9;
   }

   public Asm34 d(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a("visitTypeAnnotation", var1, var2, var3, var4);
   }
}
