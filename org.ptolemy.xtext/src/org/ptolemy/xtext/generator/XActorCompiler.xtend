package org.ptolemy.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.ptolemy.ecore.kernel.Nameable

class XActorCompiler extends XbaseCompiler {

	@Inject extension IJvmModelAssociations
	@Inject extension ActionPatternHelper
	
	override void _toJavaExpression(XAbstractFeatureCall call, ITreeAppendable it) {
		val feature = call.getFeature();
		if (feature instanceof JvmField) {
			val field = (feature as JvmField);
			val sourceElement = field.primarySourceElement;
			if (sourceElement.isTokenVariable) {
				it.append('''«(sourceElement as Nameable).methodName("_get%sValue")»()''')
//				tokenValueExpression('''this.«field.simpleName».getToken()''', field.type, sourceElement, it)
				return
			}
		}
		super._toJavaExpression(call, it);
	}
}
