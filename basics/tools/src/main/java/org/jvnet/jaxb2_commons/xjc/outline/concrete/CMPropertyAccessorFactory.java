package org.jvnet.jaxb2_commons.xjc.outline.concrete;

import org.apache.commons.lang.Validate;
import org.jvnet.jaxb2_commons.util.FieldAccessorFactory;
import org.jvnet.jaxb2_commons.xjc.outline.FieldAccessorEx;
import org.jvnet.jaxb2_commons.xjc.outline.MPropertyAccessor;
import org.jvnet.jaxb2_commons.xjc.outline.MPropertyAccessorFactory;
import org.jvnet.jaxb2_commons.xjc.outline.MPropertyOutline;

import com.sun.codemodel.JExpression;
import com.sun.tools.xjc.outline.FieldOutline;

public class CMPropertyAccessorFactory implements MPropertyAccessorFactory {

	private final FieldAccessorFactory fieldAccessorFactory;
	private final MPropertyOutline propertyOutline;
	private final FieldOutline fieldOutline;

	public CMPropertyAccessorFactory(MPropertyOutline propertyOutline,
			FieldAccessorFactory fieldAccessorFactory, FieldOutline fieldOutline) {
		Validate.notNull(propertyOutline);
		Validate.notNull(fieldAccessorFactory);
		Validate.notNull(fieldOutline);
		this.propertyOutline = propertyOutline;
		this.fieldAccessorFactory = fieldAccessorFactory;
		this.fieldOutline = fieldOutline;
	}

	@Override
	public MPropertyAccessor createPropertyAccessor(JExpression target) {
		FieldAccessorEx fieldAccessor = fieldAccessorFactory
				.createFieldAccessor(fieldOutline, target);
		return new CMPropertyAccessor(propertyOutline, fieldAccessor);
	}

}
