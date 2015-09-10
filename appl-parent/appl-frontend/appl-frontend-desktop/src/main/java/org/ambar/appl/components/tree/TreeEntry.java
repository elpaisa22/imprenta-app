package org.ambar.appl.components.tree;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
*
* Clase que representa una entrada en el arbol JTree.
*
* @author Sebatian Ecclesia
*/
public class TreeEntry extends JComponent {

    private static final long serialVersionUID = -6760669475898112410L;

	private String titulo;
    private ImageIcon icono;
    private ArrayList<TreeEntry> hijos;
    private String entity;
    private String filtro;

    /**
     * Constructor con parámetros.
     * @param pTitulo Titulo del nodo
     * @param pIcono Icono
     * @param pFiltro Filtro
     * @param pEntity Entidad
     * */
    public TreeEntry(String pTitulo, ImageIcon pIcono, String pFiltro, String pEntity) {
        this();
        setTitle(pTitulo);
        setIcon(pIcono);
        setFiltro(pFiltro);
        setEntity(pEntity);
    }

    /**
     * Constructor sin parametros.
     * */
    public TreeEntry() {
        this.hijos = new ArrayList<TreeEntry>();
    }

    /**
     * Setea el titulo.
     * @param pTitulo Titulo.
     * */
    public void setTitle(String pTitulo) {
        this.titulo = pTitulo;
    }

    /**
     * Setea el icono.
     * @param pIcono Icono.
     * */
    public void setIcon(ImageIcon pIcono) {
        if (pIcono != null)	{
             this.icono = pIcono;
        }
    }

    /**
     * Retorna el titulo.
     * @return {@link String} titulo.
     * */
    public String getTitle() {
        return titulo;
    }

    /**
     * Retorna el icono.
     * @return {@link ImageIcon} icono.
     * */
    public ImageIcon getIcon() {
        return icono;
    }

    /**
     * Retorna todos los hijos.
     * @return ArrayList<{@link TreeEntry}> entries.
     * */
   public ArrayList<TreeEntry> getEntries() {
        return hijos;
    }

   /**
    * Retorna el indice de uno de los hijos.
    * @param pChild elemento
    * @return int posicion
    * */
    public int indexOf(Object pChild) {
        return hijos.indexOf(pChild);
    }

    /**
     * Retorna la cantidad.
     * @return {@link int} cantidad
     * */
    public int count() {
        return hijos.size();
    }

    /**
     * Retorna un elemento.
     * @param pIndex Indice
     * @return {@link Object} Elemento
     * */
    public Object get(int pIndex) {
        return hijos.get(pIndex);
    }

    /**
     * Agrega un elemento.
     * @param pTreeEntry Entry
     * */
    public void add(TreeEntry pTreeEntry) {
        hijos.add(pTreeEntry);
    }

	/**
	 * Setea un filtro.
	 * @param pFiltro Filtro
	 * */
    public void setFiltro(String pFiltro) {
		this.filtro = pFiltro;
	}

    /**
     * Retorna el filtro.
     * @return {@link String} Filtro
     * */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * Setea una entidad.
	 * @param pEntity Entidad
	 * */
	public void setEntity(String pEntity) {
		this.entity = pEntity;
	}

	/**
	 * Retorna una entidad.
	 * @return {@link String} Entidad
	 * */
	public String getEntity() {
		return entity;
	}

}
