package org.ptolemy.xtext.scoping;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Singleton;

@Singleton
public class OperatorMapping extends org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping {
	
	protected void initializeMapping() {
		super.initializeMapping();
		map.put(QualifiedName.create("#"), QualifiedName.create(OP_PREFIX+"index"));
	}
}	
