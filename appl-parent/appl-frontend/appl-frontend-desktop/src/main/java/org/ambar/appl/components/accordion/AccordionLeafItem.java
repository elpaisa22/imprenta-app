/**
 * appl-frontend-desktop [19/04/2012 22:46:06]
 */
package org.ambar.appl.components.accordion;

import javax.swing.ImageIcon;

import org.ambar.appl.components.tree.TreeEntry;

/**
 * Clase que representa una hoja del accordion.
 *
 * @author Sebastian
 * */
public class AccordionLeafItem extends TreeEntry {

	/**
	 * Constructor por default.
	 * @param pTitulo Titulo
	 * @param pIcono Icono
	 * @param pFiltro Filtro
	 * @param pEntity Entidad
	 * */
    public AccordionLeafItem(String pTitulo, ImageIcon pIcono, String pFiltro, String pEntity) {
		super(pTitulo, pIcono, pFiltro, pEntity);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -4256805339524124487L;


}
