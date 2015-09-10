/**
 * appl-frontend-desktop [31/05/2012 20:18:31]
 */
package org.ambar.appl.components.lookup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.ambar.appl.helpers.SpringHelper;
import org.ambar.core.be.Persistible;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dictionary.services.DictionaryServices;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.results.ResultObjectDTO;
import org.ambar.core.services.DataServices;

/**
 * <p>
 * Componente LookUp.
 * </p>
 *
 * @author Sebastian
 *
 */
public class LookUp extends JComponent {

	private LookUpWindow myWindow = null;
	private String services;
	private String entity;
	private List<String> visibleFields;
	private RequestContext requestContext;

	private LookUpResult lookUpResult = new LookUpResult();

	private JLabel lblDescripcion = null;

	/**
	 * Constructor default.
	 * */
	public LookUp() {
		setLayout(new BorderLayout(0, 0));

		fldCodigo = new JTextField();
		fldCodigo.setColumns(10);
		fldCodigo.setEditable(false);
		fldCodigo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent pE) {
				if (!fldCodigo.getText().equals("")) {
					loadFromText(fldCodigo.getText());
				}
			}

			@Override
			public void insertUpdate(DocumentEvent pE) {
				if (!fldCodigo.getText().equals("")) {
					loadFromText(fldCodigo.getText());
				}
			}

			@Override
			public void changedUpdate(DocumentEvent pE) {
			}

			private void loadFromText(String pText) {

				@SuppressWarnings("unchecked")
				DataServices<Object, DTO<Object>, Object, Persistible<Object>> servicesBean =
						(DataServices<Object, DTO<Object>, Object, Persistible<Object>>)
							SpringHelper.getContext().getBean(services);

				requestContext = (RequestContext) SpringHelper.getContext().getBean("requestContext");

				Object value = castValue(idClass, pText);
				if (value != null) {
                    ResultObjectDTO<DTO<Object>> result = servicesBean.getById(value, requestContext);
					if (result.getResult() != null) {
						fldCodigo.setBackground(Color.getColor("e3e3e3"));
						try {
							String fieldName;
						    Class<?> c = result.getResult().getClass();

						    if (lblDescripcion != null) {
						    	fieldName = myWindow.getDescField();
						    	Field field = c.getDeclaredField(fieldName);
							    field.setAccessible(true);
							    value = field.get(result.getResult());
							    String text = value.toString();
							    lblDescripcion.setText(text);
						    }

						 } catch (Exception e) {
							 e.printStackTrace();
						 }
					} else {
						fldCodigo.setBackground(Color.RED);
						if (lblDescripcion != null) {
							lblDescripcion.setText("");
						}
					}
				} else {
					fldCodigo.setBackground(Color.RED);
					if (lblDescripcion != null) {
						lblDescripcion.setText("");
					}
				}
			}

			private Object castValue(Class<?> pIdClass, String pText) {
				Object result = null;
				String aux = pText;
				if (!aux.equals("")) {
					if (pIdClass.equals(Long.class)) {
						result = Long.parseLong(aux);
					} else if (pIdClass.equals(String.class)) {
						result = aux;
					} else if (pIdClass.equals(Integer.class)) {
						result = Integer.parseInt(aux);
					}
				}
				return result;
			}
		});

		add(fldCodigo, BorderLayout.CENTER);

		btnBoton = new JButton("");
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pArg) {
				LookUpWindow lkpw = getMyWindow();

				@SuppressWarnings("unchecked")
				DataServices<Object, DTO<Object>, Object, Persistible<Object>> servicesBean =
						(DataServices<Object, DTO<Object>, Object, Persistible<Object>>)
							SpringHelper.getContext().getBean(services);

				requestContext = (RequestContext) SpringHelper.getContext().getBean("requestContext");
				
				DictionaryServices dictionary = (DictionaryServices) SpringHelper.getContext().getBean("dictionaryServices");

				getMyWindow().setRequestContext(requestContext);

				lkpw.setServices(servicesBean);
				lkpw.setEntity(dictionary.getEntityMetaDataById(entity));
				lkpw.setVisibleFields(visibleFields);
				lkpw.excecuteLookUp();
			}
		});
		btnBoton.setSelectedIcon(null);
		btnBoton.setIcon(new ImageIcon(LookUp.class.getResource("find.png")));
		add(btnBoton, BorderLayout.EAST);
	}

	/**
	 * Retorna la ventana del lookup.
	 * @return {@link LookUpWindow} Window
	 * */
	private LookUpWindow getMyWindow() {
		if (myWindow == null) {
			myWindow = new LookUpWindow();
			myWindow.setLocation(200, 100);
			myWindow.setSize(700, 500);
			myWindow.setLookUpResult(getLookUpResult());

			myWindow.addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent pE) {
				}

				@Override
				public void windowIconified(WindowEvent pE) {
				}

				@Override
				public void windowDeiconified(WindowEvent pE) {
				}

				@Override
				public void windowDeactivated(WindowEvent pE) {
					if (getLookUpResult().getValue() != null) {
						fldCodigo.setText(getLookUpResult().getValue());
						if (lblDescripcion != null && getLookUpResult().getDescription() != null) {
							lblDescripcion.setText(getLookUpResult().getDescription());
						}
					}
				}

				@Override
				public void windowClosing(WindowEvent pE) {
				}

				@Override
				public void windowClosed(WindowEvent pE) {
				}

				@Override
				public void windowActivated(WindowEvent pE) {
				}
			});
		}
		return myWindow;
	}

	/**
	 * @param pLblDescripcion Establece el valor del atributo lblDescripcion.
	 */
	public void setLblDescripcion(JLabel pLblDescripcion) {
		lblDescripcion = pLblDescripcion;
	}

	/**
	 * @param pDescField Establece el valor del atributo descField.
	 */
	public void setDescField(String pDescField) {
		getMyWindow().setDescField(pDescField);
	}

	/**
	 * @param pValueField Establece el valor del atributo valueField.
	 */
	public void setValueField(String pValueField) {
		getMyWindow().setValueField(pValueField);
	}

	/**
	 * @param pServices Establece el valor del atributo services.
	 */
	public void setServices(String pServices) {
		this.services = pServices;
	}

	public void setVisibleFields(String pVisibleFields) {
		this.visibleFields = new ArrayList<String>();
		
		List<String> list = Arrays.asList(pVisibleFields.split(","));
		
		for (String field : list) {
			this.visibleFields.add(field.trim());
		}
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return Retorna el valor del atributo lookUpResult.
	 */
	private LookUpResult getLookUpResult() {
		return lookUpResult;
	}

	/**
	 * @param pValue Establece el valor del lookUp.
	 */
	public void setValue(String pValue) {
		getLookUpResult().setValue(pValue);
		getLookUpResult().setDescription(null);
		fldCodigo.setText(pValue);
	}

	/**
	 * @return Establece el valor del lookUp.
	 */
	public String getValue() {
		return getLookUpResult().getValue();
	}

	@Override
	public void setEnabled(boolean pEnabled) {
		fldCodigo.setEditable(pEnabled);
		btnBoton.setEnabled(pEnabled);
		if (lblDescripcion != null) {
			lblDescripcion.setEnabled(pEnabled);
		}
	}

	/**
	 * Setea la clase del ID.
	 * @param pClass Clase del ID.
	 * */
	public void setIdClass(Class<?> pClass) {
		idClass = pClass;
	}

	/**
	 * Setea El titulo de la ventana del LookUp.
	 * @param pWindowName Nombre de la ventana.
	 * */
	public void setWindowName(String pWindowName) {
		getMyWindow().setTitle(pWindowName);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 8525293045435118673L;

	private JTextField fldCodigo;
	private JButton btnBoton;
	private Class<?> idClass;

}
