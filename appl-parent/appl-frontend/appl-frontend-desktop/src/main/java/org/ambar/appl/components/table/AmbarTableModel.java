/**
 * appl-frontend-desktop [24/04/2012 18:49:49]
 */
package org.ambar.appl.components.table;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dto.DTO;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
public class AmbarTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -2136588511952803103L;

	private List<DTO<Object>> data;
	private Entity metaData;
	private Hashtable<String, Method> metodosPorNombre;
	private Hashtable<Integer, String> headers;


	/**
	 * Default constructor.
	 * */
	public AmbarTableModel() {
		this.data = new ArrayList<DTO<Object>>();
	}

	@Override
	public int getRowCount() {
		if (data != null) {
			return data.size();
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		int result = 0;

		if (metaData == null) {
			if (data.size() > 0) {
				Object elem = data.get(0);
				if (elem != null) {
					result = metodosPorNombre.size();
				}

			}
		} else {
			result = metaData.getAttributes().size();
		}

		return result;
	}

	/**
	 * Varifica si el metodo es un "getter".
	 * @param pMethod Metodo
	 * @return {@link Boolean} True si el metodo es un getter.
	 * */
	private Boolean isGetter(Method pMethod) {
		if (!pMethod.getName().startsWith("get")) {
			return false;
		}
		if (pMethod.getParameterTypes().length != 0) {
			return false;
		}
		if (void.class.equals(pMethod.getReturnType())) {
			return false;
		}

		return true;
	}

	@Override
	public String getColumnName(int pIndex) {
		if (metaData != null) {
			return metaData.getAttributes().get(pIndex).getId().toUpperCase();
		}
		return headers.get(pIndex).toUpperCase();
	}

	@Override
	public Object getValueAt(int pRowIndex, int pColumnIndex) {
		Object elem = data.get(pRowIndex);
		Object[] arglist = null;

		Object result = null;

		String stringResult = null;

		if (metaData == null) {
			try {
				String property = headers.get(pColumnIndex).toUpperCase();
                result = metodosPorNombre.get(property).invoke(elem, arglist);
                if (result != null) {
                	stringResult = result.toString();
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String property = metaData.getAttributes().get(pColumnIndex).getId().toUpperCase();

			try {
				result = metodosPorNombre.get(property).invoke(elem, arglist);
				if (result != null) {
					if (result.getClass().getSimpleName().equals("Date")) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						stringResult = sdf.format(result);
					} else {
						stringResult = result.toString();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return stringResult;
	}

	/**
	 * @return Retorna el valor del atributo data.
	 */
	public List<DTO<Object>> getData() {
		return data;
	}

	/**
	 * Setea nuevos datos a la tabla.
	 * @param pList Datos
	 * @param pEntityMetadata Entity Metadata
	 * */
	public void setData(List<DTO<Object>> pList, Entity pEntityMetadata) {
		this.loadSetterMethods(pList);
		metaData = pEntityMetadata;
		data = pList;
		fireTableChanged(null); // notify everyone that we have a new table.
	}

	/**
	 * Guarda los setters y los headers de las columnas.
	 * @param pList coleccion de datos
	 * */
	private void loadSetterMethods(List<DTO<Object>> pList) {
		metodosPorNombre = new Hashtable<String, Method>();
		headers = new Hashtable<Integer, String>();

		if (pList != null && pList.size() > 0) {
			Object object = pList.get(0);
			Method[] methods = object.getClass().getMethods();
			Integer index = 0;
			for (Method method : methods) {
				String propertyName = method.getName().substring(3);
				if (isGetter(method)) {
					metodosPorNombre.put(propertyName.toUpperCase(), method);
					headers.put(index, propertyName.toUpperCase());
					index++;
				}
			}
		}
	}
}
