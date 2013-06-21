package org.ptolemy.xtext.generator;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class TreeAppendableUtil {

	@Inject private XbaseCompiler xbaseCompiler;
	@Inject private TypeReferenceSerializer typeReferenceSerializer;
	@Inject private JvmTypesBuilder jvmTypesBuilder;

	public ITreeAppendable operator_doubleLessThan(ITreeAppendable appendable, CharSequence content) {
		if (content != null) {
			if (content.length() > 0) {
				preAppend(appendable, content.charAt(0));
			}
			appendable.append(content);
			if (content.length() > 0) {
				postAppend(appendable, content.charAt(content.length() - 1));
			}
		}
		return appendable;
	}
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, CharSequence content) {
		operator_doubleLessThan(appendable.getKey(), content);
		return appendable;
	}

	public ITreeAppendable preAppend(ITreeAppendable appendable, char c) {
		switch (c) {
			case '}': {
				appendable.decreaseIndentation(); appendable.newLine(); break;
			}
		}
		return appendable;
	}

	public ITreeAppendable postAppend(ITreeAppendable appendable, char c) {
		switch (c) {
			case '\n': {
				appendable.newLine(); break;
			}
			case '{': {
				appendable.increaseIndentation(); appendable.newLine(); break;
			}
			case ';': {
				appendable.newLine(); break;
			}
			case '}': {
				appendable.newLine(); break;
			}
		}
		return appendable;
	}
	
	public ITreeAppendable operator_doubleLessThan(ITreeAppendable appendable, char c) {
		preAppend(appendable, c);
		appendable.append(String.valueOf(c));
		postAppend(appendable, c);
		return appendable;
	}
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, char c) {
		operator_doubleLessThan(appendable.getKey(), c);
		return appendable;
	}

	public ITreeAppendable operator_doubleLessThan(ITreeAppendable appendable, XExpression expression) {
		try {
			xbaseCompiler.toJavaExpression(expression, appendable);
		} catch (RuntimeException e) {
			appendable.append("<<" + e + ">>");
		}
		return appendable;
	}
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, XExpression expression) {
		operator_doubleLessThan(appendable.getKey(), expression);
		return appendable;
	}

	public ITreeAppendable operator_doubleLessThan(ITreeAppendable appendable, JvmType type) {
		try {
			appendable.append(type);
		} catch (RuntimeException e) {
			appendable.append("<<" + e + ">>");
		}
		return appendable;
	}
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, JvmType type) {
		operator_doubleLessThan(appendable.getKey(), type);
		return appendable;
	}

	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, JvmTypeReference type) {
		try {
			typeReferenceSerializer.serialize(type, appendable.getValue(), appendable.getKey());
		} catch (RuntimeException e) {
			appendable.getKey().append("<<" + e + ">>");
		}
		return appendable;
	}
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, Class<?> c) {
		operator_doubleLessThan(appendable, jvmTypesBuilder.newTypeRef(appendable.getValue(), c));
		return appendable;
	}

	// pattern from http://stackoverflow.com/questions/5205339/regular-expression-matching-fully-qualified-java-classes
	private static Pattern classNamePattern = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)+\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
	
	public Pair<ITreeAppendable,? extends EObject> operator_doubleLessThan(Pair<ITreeAppendable,? extends EObject> appendable, String content) {
		if (content != null && classNamePattern.matcher(content).matches()) {
			operator_doubleLessThan(appendable, jvmTypesBuilder.newTypeRef(appendable.getValue(), content));
		} else {
			operator_doubleLessThan(appendable.getKey(), content);
		}
		return appendable;
	}
}
