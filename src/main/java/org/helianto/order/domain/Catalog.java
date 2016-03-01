package org.helianto.order.domain;

import javax.persistence.DiscriminatorValue;

import org.helianto.document.domain.DocumentFolder;

/**
 * Catalog.
 * 
 * @author mauriciofernandesdecastro
 */
@javax.persistence.Entity
@DiscriminatorValue("P")
public class Catalog extends DocumentFolder {

	private static final long serialVersionUID = 1L;

}
