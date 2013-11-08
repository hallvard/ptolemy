package org.ptolemy.xtext.launch.swixml;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * A text field that fire text change events for every actual change 
 * @author hal
 *
 */
public class XTextField extends JTextField {
	
	private static final long serialVersionUID = 1L;
	public static final String TEXT_PROPERTY = "text";

	public XTextField() {
		this(0);
	}

	public XTextField(int nbColumns) {
		super("", nbColumns);
		this.setDocument(new ADocument());
	}

	@SuppressWarnings("serial")
	private class ADocument extends PlainDocument {

		private boolean ignoreEvents = false;

		@Override
		public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			String oldValue = XTextField.this.getText();
			this.ignoreEvents = true;
			super.replace(offset, length, text, attrs);
			this.ignoreEvents = false;
			String newValue = XTextField.this.getText();
			if (!oldValue.equals(newValue)) {
			    XTextField.this.firePropertyChange(TEXT_PROPERTY, oldValue, newValue);
			}
		}

		@Override
		public void remove(int offs, int len) throws BadLocationException {
			String oldValue = XTextField.this.getText();
			super.remove(offs, len);
			String newValue = XTextField.this.getText();
			if (!ignoreEvents && !oldValue.equals(newValue)) {
			    XTextField.this.firePropertyChange(TEXT_PROPERTY, oldValue, newValue);
			}
		}
	}
}