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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

/**
 * This class represents that portion of the user interface that displays the
 * words on the operand stack.
 *
 * @author Bill Venners
 */
class OperandStackPanel extends Panel {

	private static final String CENTER = "Center";

	private static final String TIMES_ROMAN = "TimesRoman";

	private static final String HELVETICA = "Helvetica";

	private static final long serialVersionUID = 1L;

	private int memoryLocationsVisibleCount;

	private Label[] pointer;
	private Label[] address;
	private Label[] wordValue;
	private Label[] logicalValue;

	private int currentOptopRow;

	private ColoredLabel optopRegister;

	OperandStackPanel(int maxStack) {

		// Add one to maxStack so that "optop>" has somewhere to go
		// when the stack is full.
		memoryLocationsVisibleCount = maxStack + 1;
		pointer = new Label[memoryLocationsVisibleCount];
		address = new Label[memoryLocationsVisibleCount];
		wordValue = new Label[memoryLocationsVisibleCount];
		logicalValue = new Label[memoryLocationsVisibleCount];

		// Initialize the title
		Label title = new Label(StringTable.OPERAND_STACK, Label.CENTER);
		title.setFont(new Font(HELVETICA, Font.BOLD, 11));

		// Initialize the labelled pc register panel
		Panel registerPanel = new Panel();
		registerPanel.setLayout(new BorderLayout(5, 5));
		optopRegister = new ColoredLabel("0000", Label.CENTER, Color.lightGray);
		optopRegister.setFont(new Font(TIMES_ROMAN, Font.PLAIN, 11));
		Label pcRegTitle = new Label(StringTable.OPTOP, Label.RIGHT);
		pcRegTitle.setFont(new Font(HELVETICA, Font.ITALIC, 11));
		registerPanel.add("East", optopRegister);
		registerPanel.add(CENTER, pcRegTitle);

		// Put the title and the pc register panel on the same panel
		Panel titleRegisterPanel = new Panel();
		titleRegisterPanel.setLayout(new BorderLayout());
		titleRegisterPanel.add("West", registerPanel);
		titleRegisterPanel.add(CENTER, title);

		// Initialize column titles
		Panel columnTitles = new Panel();
		int[] hComponentCellWidths = { 2, 2, 2, 3 };
		columnTitles.setLayout(new GridSnapLayout(1, 9, hComponentCellWidths));
		columnTitles.setFont(new Font(HELVETICA, Font.ITALIC, 11));
		columnTitles.add(new Label("", Label.CENTER));
		columnTitles.add(new Label(StringTable.OFFSET, Label.CENTER));
		columnTitles.add(new Label(StringTable.HEX_VALUE, Label.CENTER));
		columnTitles.add(new Label(StringTable.VALUE, Label.LEFT));

		// Initialize the 4 column view of the method
		Panel methodView = new Panel();
		methodView.setLayout(new GridSnapLayout(memoryLocationsVisibleCount, 9, hComponentCellWidths));
		methodView.setBackground(Color.lightGray);
		Font plainFont = new Font(TIMES_ROMAN, Font.PLAIN, 11);
		methodView.setFont(plainFont);
		Font italicFont = new Font(TIMES_ROMAN, Font.ITALIC, 11);

		for (int i = 0; i < memoryLocationsVisibleCount; ++i) {

			pointer[i] = new Label("", Label.RIGHT);
			pointer[i].setFont(italicFont);
			methodView.add(pointer[i]);

			address[i] = new Label("", Label.CENTER);
			methodView.add(address[i]);

			wordValue[i] = new Label("", Label.CENTER);
			methodView.add(wordValue[i]);

			logicalValue[i] = new Label("", Label.LEFT);
			methodView.add(logicalValue[i]);
		}

		Panel methodViewWithTitles = new Panel();
		methodViewWithTitles.setLayout(new BorderLayout());
		methodViewWithTitles.add("North", columnTitles);
		methodViewWithTitles.add(CENTER, methodView);

		setLayout(new BorderLayout());
		add("North", titleRegisterPanel);
		add(CENTER, methodViewWithTitles);
	}

	public void updateView(int optop, Object[] operandStack) {
		// Assume length of array is one less that memoryLocationsVisibleCount,
		// which should equal maxStack + 1.
		int len = operandStack.length;
		int i = 0;
		while (i < len) {

			address[i].setText(Integer.toString(i));

			Object locVar = operandStack[i];
			if (locVar == null) {
				wordValue[i].setText("");
				logicalValue[i].setText("");
			} else if (locVar instanceof Integer) {

				Integer value = (Integer) locVar;
				HexString wordValueHexString = new HexString(value.intValue(), 8);
				wordValue[i].setText(wordValueHexString.getString());
				logicalValue[i].setText(value.toString());
			} else if (locVar instanceof Float) {

				Float wrapperVal = (Float) locVar;
				float fVal = wrapperVal.floatValue();
				int floatBits = Float.floatToIntBits(fVal);
				HexString wordValueHexString = new HexString(floatBits, 8);
				wordValue[i].setText(wordValueHexString.getString());
				logicalValue[i].setText(wrapperVal.toString());
			} else if (locVar instanceof Long) {
				Long value = (Long) locVar;
				long longValue = value.longValue();
				int lowerWord = (int) longValue;
				int upperWord = (int) (longValue >>> 32);
				HexString lowerWordHexString = new HexString(lowerWord, 8);
				HexString upperWordHexString = new HexString(upperWord, 8);
				wordValue[i].setText(lowerWordHexString.getString());
				wordValue[i + 1].setText(upperWordHexString.getString());
				logicalValue[i].setText(value.toString() + "L");
				++i; // must increment i twice in long case
			} else if (locVar instanceof Double) {
				Double value = (Double) locVar;
				double doubleValue = value.doubleValue();
				long longBits = Double.doubleToLongBits(doubleValue);
				int lowerWord = (int) longBits;
				int upperWord = (int) (longBits >>> 32);
				HexString lowerWordHexString = new HexString(lowerWord, 8);
				HexString upperWordHexString = new HexString(upperWord, 8);
				wordValue[i].setText(lowerWordHexString.getString());
				wordValue[i + 1].setText(upperWordHexString.getString());
				logicalValue[i].setText(value.toString());
				++i; // must increment i twice in double case
			} else if (locVar instanceof ReturnAddress) {

				ReturnAddress wrapper = (ReturnAddress) locVar;
				HexString wordValueHexString = new HexString(wrapper.getReturnAddress(), 8);
				wordValue[i].setText(wordValueHexString.getString());
				logicalValue[i].setText("RET ADDR");
			} else {
				// Its an object
				wordValue[i].setText(" OBJREF ");
				logicalValue[i].setText((locVar.getClass()).getName());
			}
			++i;
		}

		optopRegister.setLabelText("    " + Integer.toString(optop));

		// Erase the old "optop>" pointer
		pointer[currentOptopRow].setText("");

		// Place the "optop>" pointer
		pointer[optop].setText(StringTable.OPTOP_POINTER);
		currentOptopRow = optop;
	}

	@Override
	public Insets getInsets() {
		return new Insets(5, 5, 5, 5);
	}
}
