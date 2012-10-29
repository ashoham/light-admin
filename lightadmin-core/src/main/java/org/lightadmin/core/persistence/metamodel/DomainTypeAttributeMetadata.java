package org.lightadmin.core.persistence.metamodel;

import javax.persistence.metamodel.Attribute;

public interface DomainTypeAttributeMetadata {

	/**
	 * Name of the attribute.
	 *
	 * @return name of the attribute.
	 */
	String getName();

	/**
	 * The type of this attribute.
	 *
	 * @return type of this attribute.
	 */
	Class<?> getType();

	/**
	 * The element type of this attribute, if this attribute is a "plural"-like attribute (a Collection, Map, etc...).
	 *
	 * @return Class of element type or {@literal null} if not a plural attribute.
	 */
	Class<?> getElementType();

	/**
	 * Can this attribute look like a {@link java.util.Collection}?
	 *
	 * @return {@literal true} if attribute is a Collection, {@literal false} otherwise.
	 */
	boolean isCollectionLike();

	/**
	 * Can this attribute look like a {@link java.util.Set}?
	 *
	 * @return {@literal true} if attribute is a Set, {@literal false} otherwise.
	 */
	boolean isSetLike();

	/**
	 * Can this attribute look like a {@link java.util.Map}?
	 *
	 * @return {@literal true} if attribute is a Map, {@literal false} otherwise.
	 */
	boolean isMapLike();

	/**
	 * Get the path of this attribute.
	 *
	 * @param target The entity to inspect for this attribute.
	 * @return attribute value
	 */
	Object getValue( Object target );

	Attribute getAttribute();
}