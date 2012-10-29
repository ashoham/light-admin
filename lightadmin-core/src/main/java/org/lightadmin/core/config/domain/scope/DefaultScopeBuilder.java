package org.lightadmin.core.config.domain.scope;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;

public class DefaultScopeBuilder implements ScopeBuilder {

	private final List<Scope> scopes = newLinkedList();

	private Scope currentScope = null;

	@Override
	public ScopeBuilder scope( final String name, final Scope scope ) {
		currentScope = ScopeUtils.scope( scope );
		scopes.add( currentScope.name( name ) );
		return this;
	}

	@Override
	public ScopeBuilder scope( final Scope scope ) {
		currentScope = ScopeUtils.scope( scope );
		scopes.add( currentScope );
		return this;
	}

	@Override
	public ScopeBuilder defaultScope() {
		if ( currentScope != null ) {
			currentScope.defaultScope( true );
			currentScope = null;
		}
		return this;
	}

	@Override
	public Scopes build() {
		if ( scopes.isEmpty() ) {
			return new Scopes( newArrayList( ScopeUtils.all().defaultScope( true ) ) );
		}
		return new Scopes( scopes );
	}
}