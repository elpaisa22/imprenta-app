/**
 * appl-frontend-desktop [09/06/2012 15:15:19]
 */
package org.ambar.appl.components.breadcrumb;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

/**
 * <p>
 * Insertar descripción funcional.
 * </p>
 *
 * @author Sebastian
 *
 */
public class AmbarTreeEntry implements TreeNode {

	private String titulo;
    private ImageIcon icono;
    private ArrayList<AmbarTreeEntry> hijos;
    private String entity;
    private String filtro;
    private AmbarTreeEntry parent;

    /**
     * Constructor con parámetros.
     * @param pTitulo Titulo del nodo
     * @param pIcono Icono
     * @param pFiltro Filtro
     * @param pEntity Entidad
     * @param pParent Parent
     *
     * */
    public AmbarTreeEntry(String pTitulo, ImageIcon pIcono, String pFiltro, String pEntity, AmbarTreeEntry pParent) {
        super();
        setTitle(pTitulo);
        setIcon(pIcono);
        setFiltro(pFiltro);
        setEntity(pEntity);
        setParent(pParent);
        this.hijos = new ArrayList<AmbarTreeEntry>();
    }

    /**
     * Constructor sin parametros.
     * */
    public AmbarTreeEntry() {
        this.hijos = new ArrayList<AmbarTreeEntry>();
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
     * @return ArrayList<{@link AmbarTreeEntry}> entries.
     * */
   public ArrayList<AmbarTreeEntry> getEntries() {
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
    public void add(AmbarTreeEntry pTreeEntry) {
        hijos.add(pTreeEntry);
    }

	/**
	 * Setea un filtro.
	 * @param pFiltro Filtro
	 * */
    private void setFiltro(String pFiltro) {
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
	private void setEntity(String pEntity) {
		this.entity = pEntity;
	}

	/**
	 * Setea el padre.
	 * @param pEntity Entidad
	 * */
	private void setParent(AmbarTreeEntry pEntity) {
		this.parent = pEntity;
	}

	/**
	 * Retorna una entidad.
	 * @return {@link String} Entidad
	 * */
	public String getEntity() {
		return entity;
	}

	@Override
	public TreeNode getChildAt(int pChildIndex) {
		return this.hijos.get(pChildIndex);
	}

	@Override
	public int getChildCount() {
		return this.hijos.size();
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public int getIndex(TreeNode pNode) {
		return hijos.indexOf(pNode);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return this.hijos.size() == 0;
	}

	@Override
	public Enumeration<AmbarTreeEntry> children() {
		return new Enumeration<AmbarTreeEntry>() {
			private int index = 0;

			@Override
			public boolean hasMoreElements() {
				return  hijos.size() > index;
			}

			@Override
			public AmbarTreeEntry nextElement() {
				AmbarTreeEntry elem = hijos.get(index);
				index++;
				return elem;
			}
		};
	}

}

