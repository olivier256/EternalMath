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

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Map;

/**
 * An applet that simulates the Java Virtual Machine executing a sequence of
 * bytecodes.
 *
 * @author Bill Venners
 */
@SuppressWarnings("deprecation")
public abstract class JVMSimulator extends Applet implements Runnable {

	static final Map<Integer, String> EXPLANATION_MAP = new HashMap<>();
	static {
		EXPLANATION_MAP.put(OpCode.AALOAD, StringTable.AALOAD_TEXT);
		EXPLANATION_MAP.put(OpCode.ALOAD_0, StringTable.ALOAD_0_TEXT);
		EXPLANATION_MAP.put(OpCode.ALOAD_1, StringTable.ALOAD_1_TEXT);
		EXPLANATION_MAP.put(OpCode.ALOAD_2, StringTable.ALOAD_2_TEXT);
		EXPLANATION_MAP.put(OpCode.ALOAD_3, StringTable.ALOAD_3_TEXT);
		EXPLANATION_MAP.put(OpCode.ASTORE, StringTable.ASTORE_TEXT);
		EXPLANATION_MAP.put(OpCode.ASTORE_0, StringTable.ASTORE_0_TEXT);
		EXPLANATION_MAP.put(OpCode.ASTORE_1, StringTable.ASTORE_1_TEXT);
		EXPLANATION_MAP.put(OpCode.ASTORE_2, StringTable.ASTORE_2_TEXT);
		EXPLANATION_MAP.put(OpCode.ASTORE_3, StringTable.ASTORE_3_TEXT);
		EXPLANATION_MAP.put(OpCode.BIPUSH, StringTable.BIPUSH_TEXT);
		EXPLANATION_MAP.put(OpCode.BREAKPOINT, StringTable.BREAKPOINT_TEXT);
		EXPLANATION_MAP.put(OpCode.DCMPG, StringTable.DCMPG_TEXT);
		EXPLANATION_MAP.put(OpCode.DCONST_0, StringTable.DCONST_0_TEXT);
		EXPLANATION_MAP.put(OpCode.DCONST_1, StringTable.DCONST_1_TEXT);
		EXPLANATION_MAP.put(OpCode.DDIV, StringTable.DDIV_TEXT);
		EXPLANATION_MAP.put(OpCode.DLOAD, StringTable.DLOAD_TEXT);
		EXPLANATION_MAP.put(OpCode.DLOAD_0, StringTable.DLOAD_0_TEXT);
		EXPLANATION_MAP.put(OpCode.DLOAD_2, StringTable.DLOAD_2_TEXT);
		EXPLANATION_MAP.put(OpCode.DMUL, StringTable.DMUL_TEXT);
		EXPLANATION_MAP.put(OpCode.DSTORE, StringTable.DSTORE_TEXT);
		EXPLANATION_MAP.put(OpCode.DSTORE_0, StringTable.DSTORE_0_TEXT);
		EXPLANATION_MAP.put(OpCode.DSTORE_2, StringTable.DSTORE_2_TEXT);
		EXPLANATION_MAP.put(OpCode.DSUB, StringTable.DSUB_TEXT);
		EXPLANATION_MAP.put(OpCode.FCONST_0, StringTable.FCONST_0_TEXT);
		EXPLANATION_MAP.put(OpCode.FCONST_2, StringTable.FCONST_2_TEXT);
		EXPLANATION_MAP.put(OpCode.FLOAD_0, StringTable.FLOAD_0_TEXT);
		EXPLANATION_MAP.put(OpCode.FMUL, StringTable.FMUL_TEXT);
		EXPLANATION_MAP.put(OpCode.FSTORE_0, StringTable.FSTORE_0_TEXT);
		EXPLANATION_MAP.put(OpCode.FSUB, StringTable.FSUB_TEXT);
		EXPLANATION_MAP.put(OpCode.GETSTATIC, StringTable.GETSTATIC_TEXT);
		EXPLANATION_MAP.put(OpCode.GOTO, StringTable.GOTO_TEXT);
		EXPLANATION_MAP.put(OpCode.I2B, StringTable.I2B_TEXT);
		EXPLANATION_MAP.put(OpCode.IADD, StringTable.IADD_TEXT);
		EXPLANATION_MAP.put(OpCode.IAND, StringTable.IAND_TEXT);
		EXPLANATION_MAP.put(OpCode.IASTORE, StringTable.IASTORE_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_0, StringTable.ICONST_0_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_1, StringTable.ICONST_1_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_2, StringTable.ICONST_2_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_3, StringTable.ICONST_3_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_4, StringTable.ICONST_4_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_5, StringTable.ICONST_5_TEXT);
		EXPLANATION_MAP.put(OpCode.ICONST_M1, StringTable.ICONST_M1_TEXT);
		EXPLANATION_MAP.put(OpCode.IDIV, StringTable.IDIV_TEXT);
		EXPLANATION_MAP.put(OpCode.IF_ICMPGT, StringTable.IF_ICMPGT_TEXT);
		EXPLANATION_MAP.put(OpCode.IF_ICMPLT, StringTable.IF_ICMPLT_TEXT);
		EXPLANATION_MAP.put(OpCode.IF_ICMPNE, StringTable.IF_ICMPNE_TEXT);
		EXPLANATION_MAP.put(OpCode.IFEQ, StringTable.IFEQ_TEXT);
		EXPLANATION_MAP.put(OpCode.IFLT, StringTable.IFLT_TEXT);
		EXPLANATION_MAP.put(OpCode.IFNE, StringTable.IFNE_TEXT);
		EXPLANATION_MAP.put(OpCode.IINC, StringTable.IINC_TEXT);
		EXPLANATION_MAP.put(OpCode.ILOAD_0, StringTable.ILOAD_0_TEXT);
		EXPLANATION_MAP.put(OpCode.ILOAD_1, StringTable.ILOAD_1_TEXT);
		EXPLANATION_MAP.put(OpCode.ILOAD_2, StringTable.ILOAD_2_TEXT);
		EXPLANATION_MAP.put(OpCode.ILOAD_3, StringTable.ILOAD_3_TEXT);
		EXPLANATION_MAP.put(OpCode.IMUL, StringTable.IMUL_TEXT);
		EXPLANATION_MAP.put(OpCode.INVOKESTATIC, StringTable.INVOKESTATIC_TEXT);
		EXPLANATION_MAP.put(OpCode.IOR, StringTable.IOR_TEXT);
		EXPLANATION_MAP.put(OpCode.IREM, StringTable.IREM_TEXT);
		EXPLANATION_MAP.put(OpCode.ISHL, StringTable.ISHL_TEXT);
		EXPLANATION_MAP.put(OpCode.ISTORE, StringTable.ISTORE_TEXT);
		EXPLANATION_MAP.put(OpCode.ISTORE_0, StringTable.ISTORE_0_TEXT);
		EXPLANATION_MAP.put(OpCode.ISTORE_1, StringTable.ISTORE_1_TEXT);
		EXPLANATION_MAP.put(OpCode.ISTORE_2, StringTable.ISTORE_2_TEXT);
		EXPLANATION_MAP.put(OpCode.ISTORE_3, StringTable.ISTORE_3_TEXT);
		EXPLANATION_MAP.put(OpCode.IXOR, StringTable.IXOR_TEXT);
		EXPLANATION_MAP.put(OpCode.JSR, StringTable.JSR_TEXT);
		EXPLANATION_MAP.put(OpCode.LADD, StringTable.LADD_TEXT);
		EXPLANATION_MAP.put(OpCode.LCONST_1, StringTable.LCONST_1_TEXT);
		EXPLANATION_MAP.put(OpCode.LDC2_W, StringTable.LDC2_W_TEXT);
		EXPLANATION_MAP.put(OpCode.LLOAD, StringTable.LLOAD_TEXT);
		EXPLANATION_MAP.put(OpCode.LLOAD_0, StringTable.LLOAD_0_TEXT);
		EXPLANATION_MAP.put(OpCode.LLOAD_2, StringTable.LLOAD_2_TEXT);
		EXPLANATION_MAP.put(OpCode.LSTORE, StringTable.LSTORE_TEXT);
		EXPLANATION_MAP.put(OpCode.LSTORE_0, StringTable.LSTORE_0_TEXT);
		EXPLANATION_MAP.put(OpCode.LSTORE_2, StringTable.LSTORE_2_TEXT);
		EXPLANATION_MAP.put(OpCode.MULTIANEWARRAY, StringTable.MULTIANEWARRAY_TEXT);
		EXPLANATION_MAP.put(OpCode.POP, StringTable.POP_TEXT);
		EXPLANATION_MAP.put(OpCode.RET, StringTable.RET_TEXT);
		EXPLANATION_MAP.put(OpCode.TABLESWITCH, StringTable.TABLESWITCH_TEXT);

	}

	private static final long serialVersionUID = 1L;
	ColoredLabel explanationLabel = new ColoredLabel("", Label.CENTER, Color.lightGray);
	GrayButton stepButton = new GrayButton(StringTable.STEP);
	GrayButton resetButton = new GrayButton(StringTable.RESET);
	GrayButton runButton = new GrayButton(StringTable.RUN);
	GrayButton stopButton = new GrayButton(StringTable.STOP);
	MethodAreaPanel methodAreaPanel;
	LocalVarsPanel localVarsPanel;
	OperandStackPanel operandStackPanel;
	int pcRegister;
	int optopRegister;
	transient StackFrame currentFrame;
	transient Method currentMethod;
	int bytecodeViewSize;
	int[] theProgram;
	String[] bytecodeMnemonics;
	int maxStack;
	int maxLocals;
	transient ExceptionTableEntry[] exceptionTable;
	transient ConstantPoolEntry[] constantPool;
	boolean stoppedThreadWhenLeftPage = false;

	// If the "run" button is pushed, a separate thread will be invoked that
	// will cause the JVM to execute until the "stop" button is pressed.
	transient Thread runner;
	static final int MILLISECONDS_DELAY_BETWEEN_STEPS = 250;
	boolean running;

	@Override
	public void init() {

		theProgram = getTheProgram();
		bytecodeMnemonics = getBytecodeMnemonics();
		bytecodeViewSize = getBytecodeViewSize();
		maxStack = getMaxStack();
		maxLocals = getMaxLocals();
		exceptionTable = getExceptionTable();
		constantPool = getConstantPool();

		methodAreaPanel = new MethodAreaPanel(bytecodeViewSize, theProgram, bytecodeMnemonics);
		localVarsPanel = new LocalVarsPanel(maxLocals);
		operandStackPanel = new OperandStackPanel(maxStack);

		// Set background and layout for the applet panel
		setBackground(getAppletBackgroundColor());
		setLayout(new BorderLayout(5, 5));

		// Initialize the title bar
		ColoredLabel title = new ColoredLabel(getAppletTitle(), Label.CENTER, getTitleColor());
		title.setFont(new Font("Helvetica", Font.BOLD, 12));

		// Initialize the control panel
		Panel controlPanel = new Panel();
		controlPanel.setLayout(new BorderLayout(5, 5));

		// Build the panel of four buttons
		Panel leftButtonPanel = new Panel();
		leftButtonPanel.setLayout(new GridLayout(2, 2, 5, 5));
		leftButtonPanel.add(stepButton);
		resetButton.disable();
		leftButtonPanel.add(runButton);
		leftButtonPanel.add(resetButton);
		leftButtonPanel.add(stopButton);
		stopButton.disable();

		// Initialize the explanation label
		explanationLabel.setBackground(getExplanationLabelColor());
		Font plainFont = new Font("TimesRoman", Font.ITALIC, 12);
		explanationLabel.setFont(plainFont);

		// Place the four button panel and explanation label onto
		// the control panel
		controlPanel.add("West", leftButtonPanel);
		controlPanel.add("Center", explanationLabel);

		// Initialize the panel that holds both the stack and
		// the method area (the twoParts panel)
		Panel twoParts = new Panel();
		twoParts.setLayout(new GridLayout(1, 2, 5, 5));

		Panel stackPanel = new Panel();
		stackPanel.setLayout(new GridLayout(2, 1, 5, 5));
		stackPanel.add(localVarsPanel);
		stackPanel.add(operandStackPanel);
		stackPanel.setBackground(getStackAreaColor());
		methodAreaPanel.setBackground(getMethodAreaColor());

		// Add stack and methodarea panels to the twoParts panel
		twoParts.add(stackPanel);
		twoParts.add(methodAreaPanel);

		// Place the title, controlPanel, and twoParts onto the applet
		// panel.
		add("North", title);
		add("South", controlPanel);
		add("Center", twoParts);

		// Place the bytecodes into a byte array.
		byte[] ba = new byte[theProgram.length];
		for (int i = 0; i < ba.length; ++i) {

			ba[i] = (byte) theProgram[i];
		}

		// Pass byte array to new StackFrame
		currentFrame = new StackFrame(maxStack, maxLocals);
		currentMethod = new Method(currentFrame, ba, exceptionTable, constantPool);

		resetState();
		updateStateDisplay();
	}

	// If they leave the page, stop a Run button press, then restart
	// automatically if they come back. In effect, leaving the page is like clicking
	// the Stop button. Returning to the page is like clicking the Run button.
	@Override
	public void start() {
		if (runner == null && stoppedThreadWhenLeftPage) {
			stopButton.enable();
			runButton.disable();
			stepButton.disable();
			resetButton.disable();
			stoppedThreadWhenLeftPage = false;
			running = true;
			runner = new Thread(this);
			runner.start();
		}
	}

	@Override
	public void stop() {
		runButton.enable();
		stepButton.enable();
		resetButton.enable();
		stopButton.disable();
		if (runner != null) {
			// Synchronize on currentMethod to allow the thread
			// to complete execution of the current instruction before
			// killing it.
			synchronized (currentMethod) {
				runner.stop();
			}
			runner = null;
			running = false;
			stoppedThreadWhenLeftPage = true;
		}
	}

	// Pushing the Reset button will cause resetState() to be executed, which will
	// reset all the data to its initial values.
	void resetState() {

		pcRegister = 0;
		optopRegister = 0;

		currentMethod.resetState();
	}

	// updateStateDisplay writes the current state of the JVM to the UI.
	void updateStateDisplay() {

		methodAreaPanel.updateProgramCounter(pcRegister);
		updateExplanationText();

		localVarsPanel.updateView(currentFrame.getLocalVars());
		operandStackPanel.updateView(currentFrame.getOptop(), currentFrame.getOperandStack());
	}

	public void run() {
		while (running) {
			try {
				pcRegister = currentMethod.executeNextInstruction();
			} catch (BreakpointException be) {
				// On a breakpoint, kill the thread.
				runButton.enable();
				stepButton.enable();
				resetButton.enable();
				stopButton.disable();
				if (runner != null) {
					Thread runnerAboutToStop = runner;
					runner = null;
					runnerAboutToStop.stop();
				}
			}
			updateStateDisplay();
			try {
				Thread.sleep(MILLISECONDS_DELAY_BETWEEN_STEPS);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	// updateExplanationText() prints out a line of text to the bottom of the
	// applet that describes the next opcode to execute.
	private void updateExplanationText() {

		int nextOpCode = theProgram[pcRegister];

		String label = EXPLANATION_MAP.get(nextOpCode);
		if (label == null) {
			label = "";
		}
		explanationLabel.setLabelText(label);

	}

	// Make pretty border around entire applet panel
	@Override
	public Insets insets() {
		return new Insets(5, 5, 5, 5);
	}

	@Override
	public boolean action(Event evt, Object arg) {
		if (evt.target instanceof Button) {
			String bname = (String) arg;
			if (bname.equals(StringTable.RESET)) {

				stopButton.disable();
				runButton.enable();
				stepButton.enable();
				resetButton.disable();
				resetState();
				updateStateDisplay();
			} else if (bname.equals(StringTable.STEP)) {

				resetButton.enable();
				try {
					pcRegister = currentMethod.executeNextInstruction();
				} catch (BreakpointException be) {
					// Ignore this. User can reset.
				}
				updateStateDisplay();
			} else if (bname.equals(StringTable.RUN)) {

				stopButton.enable();
				runButton.disable();
				stepButton.disable();
				resetButton.disable();
				if (runner == null) {
					runner = new Thread(this);
					runner.start();
				}
			} else if (bname.equals(StringTable.STOP)) {

				runButton.enable();
				stepButton.enable();
				resetButton.enable();
				stopButton.disable();
				if (runner != null) {
					// Synchronize on currentMethod to allow the thread
					// to complete execution of the current instruction before
					// killing it.
					synchronized (currentMethod) {
						runner.stop();
					}
					runner = null;
				}
			}
		}
		return true;
	}

	public abstract int[] getTheProgram();

	public abstract String[] getBytecodeMnemonics();

	public abstract int getBytecodeViewSize();

	public abstract int getMaxStack();

	public abstract int getMaxLocals();

	public abstract Color getMethodAreaColor();

	public abstract Color getStackAreaColor();

	public abstract Color getExplanationLabelColor();

	public abstract Color getTitleColor();

	public abstract Color getAppletBackgroundColor();

	public abstract String getAppletTitle();

	// Some methods don't have an exception table. They can
	// use this default implementation of getExceptionTable
	public ExceptionTableEntry[] getExceptionTable() {
		return new ExceptionTableEntry[] {};
	}

	// All methods have a constant pool, but not all simulations
	// use it. Those that don't use a constant pool can
	// use this default implementation of getConstantPool
	public ConstantPoolEntry[] getConstantPool() {
		return new ConstantPoolEntry[] {};
	}
}
