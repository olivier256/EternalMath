/*
* Copyright (c) 1996, 1997 Bill Venners. All Rights Reserved.
*
* This Java source file is part of the Interactive Illustrations Web
* Site, which is delivered in the applets directory of the CD-ROM
* that accompanies the book "Inside the Java Virtual Machine" by Bill
* Venners, published by McGraw-Hill, 1997,ISBN: 0-07-913248-0. This
* source file is provided for evaluation purposes only, but you can
* redistribute it under certain conditions, described in the full
* copyright notice below.
*
* Full Copyright Notice:
*
* All the web pages and Java applets delivered in the applets
* directory of the CD-ROM, consisting of ".html," ".gif," ".class,"
* and ".java" files, are copyrighted (c) 1996, 1997 by Bill
* Venners, and all rights are reserved.  This material may be copied
* and placed on any commercial or non-commercial web server on any
* network (including the internet) provided that the following
* guidelines are followed:
*
* a. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files), including the source code, that are delivered
* in the applets directory of the CD-ROM that
* accompanies the book must be published together on the same web
* site.
*
* b. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files) must be published "as is" and may not be altered
* in any way.
*
* c. All use and access to this web site must be free, and no fees
* can be charged to view these materials, unless express written
* permission is obtained from Bill Venners.
*
* d. The web pages and Java Applets may not be distributed on any
* media, other than a web server on a network, and may not accompany
* any book or publication.
*
* BILL VENNERS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
* SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR PARTICULAR PURPOSE, OR NON-INFRINGEMENT.  BILL VENNERS
* SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY A LICENSEE AS A
* RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
* DERIVATIVES.
*/
package com.artima.jvmsim;

/**
 * This class stores the user interface strings used by the simulation applets.
 *
 * @author Bill Venners
 */
class StringTable {

	private StringTable() {
		// One should not instantiate this class
	}

	public static final String STEP = "Step";
	public static final String RESET = "Reset";
	public static final String RUN = "Run";
	public static final String STOP = "Stop";
	public static final String OPERAND = "operand";
	public static final String EXEC_ENV = "exec env";
	public static final String LOCAL_VARS = "local vars";
	public static final String PC_POINTER = "pc >";
	public static final String VARS_POINTER = "vars >";
	public static final String FRAME_POINTER = "frame >";
	public static final String OPTOP_POINTER = "optop >";
	public static final String ADDRESS = "address";
	public static final String OFFSET = "offset";
	public static final String INDEX = "index";
	public static final String BYTECODES = "bytecode";
	public static final String MNEMONICS = "mnemonic";
	public static final String THE_METHOD = "The Method";
	public static final String OPERAND_STACK = "Operand Stack";
	public static final String LOCAL_VARIABLES = "Local Variables";
	public static final String HEX_VALUE = "hex value";
	public static final String VALUE = "value";
	public static final String REGISTERS = "Registers";
	public static final String PC = "pc ";
	public static final String OPTOP = "optop ";
	public static final String FRAME = "frame";
	public static final String VARS = "vars";
	public static final String OBJECT_REFERENCE = "object";
	public static final String RETURN_ADDRESS = "retAddr";
	public static final String OBJECT_REF_HEX_REPREENTATION = "OBJ REF";
	public static final String AALOAD_TEXT = "aaload will pop an index and array reference and push the object ref at that index of the array.";
	public static final String ALOAD_0_TEXT = "aload_0 will push the object ref at local variable 0 onto the stack.";
	public static final String ALOAD_1_TEXT = "aload_1 will push the object ref at local variable 1 onto the stack.";
	public static final String ALOAD_2_TEXT = "aload_2 will push the object ref at local variable 2 onto the stack.";
	public static final String ALOAD_3_TEXT = "aload_3 will push the object ref at local variable 3 onto the stack.";
	public static final String ASTORE_TEXT = "astore will pop object ref off top of stack and store it in local var specified by operand.";
	public static final String ASTORE_0_TEXT = "astore_0 will pop the object ref off the top of the stack and store it in local variable 0.";
	public static final String ASTORE_1_TEXT = "astore_1 will pop the object ref off the top of the stack and store it in local variable 1.";
	public static final String ASTORE_2_TEXT = "astore_2 will pop the object ref off the top of the stack and store it in local variable 2.";
	public static final String ASTORE_3_TEXT = "astore_3 will pop the object ref off the top of the stack and store it in local variable 3.";
	public static final String ATHROW_TEXT = "athrow will pop the object ref off the top of the stack, and look for a catch clause.";
	public static final String BIPUSH_TEXT = "bipush will expand the next byte to an int and push it onto the stack.";
	public static final String BREAKPOINT_TEXT = "breakpoint will stop the simulation.";
	public static final String DCMPG_TEXT = "dcmpg will pop two doubles, compare them, push int result of comparison.";
	public static final String DCONST_0_TEXT = "dconst_0 will push double 0.0 onto the stack.";
	public static final String DCONST_1_TEXT = "dconst_1 will push double 1.0 onto the stack.";
	public static final String DLOAD_TEXT = "dload will push onto the stack the double at the local variables specified by the operand.";
	public static final String DLOAD_0_TEXT = "dload_0 will push the double at local variables 0 and 1 onto the stack.";
	public static final String DLOAD_2_TEXT = "dload_2 will push the double at local variables 2 and 3 onto the stack.";
	public static final String DDIV_TEXT = "ddiv will pop two doubles, divide them, and push the double result.";
	public static final String DMUL_TEXT = "dmul will pop two doubles, multiply them, and push the double result.";
	public static final String DSTORE_TEXT = "dstore will pop the double off the top of the stack and store it in local variable indicated by operand.";
	public static final String DSTORE_0_TEXT = "dstore_0 will pop the double off the top of the stack and store it in local variables 0 and 1.";
	public static final String DSTORE_2_TEXT = "dstore_2 will pop the double off the top of the stack and store it in local variables 2 and 3.";
	public static final String DSUB_TEXT = "dsub will pop two doubles, subtract them, and push the double result.";
	public static final String FCONST_0_TEXT = "fconst_0 will push float 0.0 onto the stack.";
	public static final String FCONST_2_TEXT = "fconst_2 will push float 2.0 onto the stack.";
	public static final String FLOAD_0_TEXT = "fload_0 will push the float at local variable 0 onto the stack.";
	public static final String FMUL_TEXT = "fmul will pop two floats, multiply them, and push the result.";
	public static final String FSTORE_0_TEXT = "fstore_0 will pop the float off the top of the stack and store it in local variable 0.";
	public static final String FSUB_TEXT = "fsub will pop two floats, subtract them, and push the result.";
	public static final String GETSTATIC_TEXT = "getstatic will push a static variable identified by a constant pool item.";
	public static final String GOTO_TEXT = "goto will cause a jump to the specified offset.";
	public static final String IADD_TEXT = "iadd will pop the top two ints off the stack, add them, and push the result back onto the stack.";
	public static final String IAND_TEXT = "iand will pop the top two ints off the stack, bitwise-and them, and push the result back onto the stack.";
	public static final String IASTORE_TEXT = "iastore will pop an int value, an index, and an arrayref and assign arrayref[index] = value.";
	public static final String ICONST_M1_TEXT = "iconst_m1 will push int -1 onto the stack.";
	public static final String ICONST_0_TEXT = "iconst_0 will push int 0 onto the stack.";
	public static final String ICONST_1_TEXT = "iconst_1 will push int 1 onto the stack.";
	public static final String ICONST_2_TEXT = "iconst_2 will push int 2 onto the stack.";
	public static final String ICONST_3_TEXT = "iconst_3 will push int 3 onto the stack.";
	public static final String ICONST_4_TEXT = "iconst_4 will push int 4 onto the stack.";
	public static final String ICONST_5_TEXT = "iconst_5 will push int 5 onto the stack.";
	public static final String IDIV_TEXT = "idiv will pop the top two ints off the stack, divide them, and push the result back onto the stack.";
	public static final String IF_ICMPGT_TEXT = "if_icmpgt will branch if the next to topmost int is greater than the topmost int.";
	public static final String IF_ICMPLT_TEXT = "if_icmplt will branch if the next to topmost int is less than the topmost int.";
	public static final String IF_ICMPNE_TEXT = "if_icmpne will branch if the top two ints are not equal to each other.";
	public static final String IFEQ_TEXT = "ifeq will branch if the topmost int is equal to zero.";
	public static final String IFLT_TEXT = "iflt will branch if the topmost int is less than zero.";
	public static final String IFNE_TEXT = "ifne will branch if the topmost int is not equal to zero.";
	public static final String IINC_TEXT = "iinc will increment the specified local variable by the specified amount.";
	public static final String ILOAD_0_TEXT = "iload_0 will push the integer at local variable 0 onto the stack.";
	public static final String ILOAD_1_TEXT = "iload_1 will push the integer at local variable 1 onto the stack.";
	public static final String ILOAD_2_TEXT = "iload_2 will push the integer at local variable 2 onto the stack.";
	public static final String ILOAD_3_TEXT = "iload_3 will push the integer at local variable 3 onto the stack.";
	public static final String IMUL_TEXT = "imul will pop two integers, multiply them, and push the result.";
	public static final String I2B_TEXT = "i2b will convert the topmost int on the stack to a value valid for the byte type.";
	public static final String INVOKESTATIC_TEXT = "invokestatic will invoke the static method indicated by the specified constant pool entry.";
	public static final String IOR_TEXT = "ior will pop the top two ints off the stack, bitwise-or them, and push the result back onto the stack.";
	public static final String IREM_TEXT = "irem will pop two integers, remainder them, and push the result.";
	public static final String ISHL_TEXT = "ishl will shift the next to topmost int to the left by amount indicated by topmost int.";
	public static final String ISTORE_0_TEXT = "istore_0 will pop the integer off the top of the stack and store it in local variable 0.";
	public static final String ISTORE_1_TEXT = "istore_1 will pop the integer off the top of the stack and store it in local variable 1.";
	public static final String ISTORE_2_TEXT = "istore_2 will pop the integer off the top of the stack and store it in local variable 2.";
	public static final String ISTORE_3_TEXT = "istore_3 will pop the integer off the top of the stack and store it in local variable 3.";
	public static final String ISTORE_TEXT = "istore will pop the int off the top of the stack and store it in local variable indicated by operand.";
	public static final String IXOR_TEXT = "ixor will pop the top two ints off the stack, biwise-xor them, and push the result back onto the stack.";
	public static final String JSR_TEXT = "jsr push a return address and jump to the specified offset.";
	public static final String LADD_TEXT = "ladd will pop the top two longs off the stack, add them, and push the result back onto the stack.";
	public static final String LCONST_1_TEXT = "lconst_1 will push long 1 onto the stack.";
	public static final String LDC2_W_TEXT = "ldc2_w will push the dual-byte value from constant pool entry specifed by the operand.";
	public static final String LLOAD_TEXT = "lload will push onto the stack the long at the local variables specified by the operand.";
	public static final String LLOAD_0_TEXT = "lload_0 will push the long at local variables 0 and 1 onto the stack.";
	public static final String LLOAD_2_TEXT = "lload_2 will push the long at local variables 2 and 3 onto the stack.";
	public static final String LSTORE_TEXT = "lstore will pop the long off the top of the stack and store it in local variable indicated by operand.";
	public static final String LSTORE_0_TEXT = "lstore_0 will pop the long off the top of the stack and store it in local variables 0 and 1.";
	public static final String LSTORE_2_TEXT = "lstore_2 will pop the long off the top of the stack and store it in local variables 2 and 3.";
	public static final String MULTIANEWARRAY_TEXT = "multianewarray will allocate memory for a new multi-dim array and push reference.";
	public static final String POP_TEXT = "pop will pop a word off the top of the stack.";
	public static final String RET_TEXT = "ret will jump to a return address in local var specified by operand .";
	public static final String TABLESWITCH_TEXT = "tableswitch will pop key and jump to a branch offset based on key.";

}
