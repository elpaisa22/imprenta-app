/**
 * appl-frontend-desktop [31/05/2012 20:19:20]
 */
package org.ambar.appl.components.lookup;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.ambar.core.be.Persistible;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dictionary.domain.entities.Entity;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.results.ResultListDTO;
import org.ambar.core.services.DataServices;



/**
 * <p>
 * Ventana que despliega el LookUp.
 * </p>
 *
 * @author Sebastian
 *
 */
public class LookUpWindow extends JDialog {

	/**
	 * Constructor default.
	 * */
	public LookUpWindow() {
		setTitle("LookUp");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LookUpWindow.class.getResource("find.png")));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getFldBuscar(), GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getBtnBuscar(), GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getBtnAceptar())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtnCancelar())))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getFldBuscar(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBtnBuscar(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtnCancelar())
						.addComponent(getBtnAceptar()))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		setModal(true);

	}

	public void excecuteLookUp() {
		ResultListDTO<DTO<Object>> data =
                getServices().getFilteredList(null, this.requestContext);

		getAmbarLookUpTableModel().setValueField(this.valueField);
		getAmbarLookUpTableModel().setDescField(this.descField);
		getAmbarLookUpColumnTableModel().setValueField(this.valueField);
		getAmbarLookUpColumnTableModel().setDescField(this.descField);
		getAmbarLookUpColumnTableModel().setEntity(this.entity);
		getAmbarLookUpColumnTableModel().setVisibleFields(this.visibleFields);

		getAmbarLookUpTableModel().setData(data.getResultList(), entity);

		setVisible(true);
		setLocationRelativeTo(null);
	}


	private DataServices<Object, DTO<Object>, Object, Persistible<Object>> services;
	private RequestContext requestContext;
	private String valueField;
	private String descField;
	private JTextField fldBuscar;
	private JTable tableGrid;
	private TableRowSorter<TableModel> sorter;

	private AmbarLookUpTableModel ambarLookUpTableModel;
	private AmbarLookUpColumnTableModel ambarLookUpColumnTableModel;

	private LookUpResult lookUpResult;



	/**
	 * @return Retorna el valor del atributo services.
	 */
	public DataServices<Object, DTO<Object>, Object, Persistible<Object>> getServices() {
		return services;
	}
	/**
	 * @param pServices Establece el valor del atributo services.
	 */
	public void setServices(DataServices<Object, DTO<Object>, Object, Persistible<Object>> pServices) {
		services = pServices;
	}
	/**
	 * @return Retorna el valor del atributo requestContext.
	 */
	public RequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @return Retorna el valor del atributo valueField.
	 */
	public String getValueField() {
		return valueField;
	}
	/**
	 * @param pValueField Establece el valor del atributo valueField.
	 */
	public void setValueField(String pValueField) {
		valueField = pValueField;
	}
	/**
	 * @return Retorna el valor del atributo descField.
	 */
	public String getDescField() {
		return descField;
	}
	/**
	 * @param pDescField Establece el valor del atributo descField.
	 */
	public void setDescField(String pDescField) {
		descField = pDescField;
	}

	/**
	 * @return Retorna el valor del atributo lookUpResult.
	 */
	public LookUpResult getLookUpResult() {
		return lookUpResult;
	}

	/**
	 * @param pLookUpResult Establece el valor del atributo lookUpResult.
	 */
	public void setLookUpResult(LookUpResult pLookUpResult) {
		lookUpResult = pLookUpResult;
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 1054544511205934816L;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private Entity entity;
	private List<String> visibleFields;

	private JTextField getFldBuscar() {
		if (fldBuscar == null) {
			fldBuscar = new JTextField();
			fldBuscar.setColumns(10);			
		}
		return fldBuscar;
	}

	private JTable getJTable() {
		if (tableGrid == null) {
			tableGrid = new JTable();
			tableGrid.setRowHeight(25);
			Font headerFont = new Font("Arial", Font.BOLD, 12);
			tableGrid.getTableHeader().setFont(headerFont);
			Font gridFont = new Font("Arial", Font.PLAIN, 11);
			tableGrid.setFont(gridFont);
			tableGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableGrid.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tableGrid.setModel(getAmbarLookUpTableModel());
			tableGrid.setColumnModel(getAmbarLookUpColumnTableModel());
			tableGrid.setRowSorter(getSorter(getAmbarLookUpTableModel()));
		}
		return tableGrid;
	}

	private AmbarLookUpTableModel getAmbarLookUpTableModel() {
		if (ambarLookUpTableModel == null) {
			ambarLookUpTableModel = new AmbarLookUpTableModel();
		}
		return ambarLookUpTableModel;
	}

	private AmbarLookUpColumnTableModel getAmbarLookUpColumnTableModel() {
		if (ambarLookUpColumnTableModel == null) {
			ambarLookUpColumnTableModel = new AmbarLookUpColumnTableModel();
		}
		return ambarLookUpColumnTableModel;
	}

	private TableRowSorter<TableModel> getSorter(AmbarLookUpTableModel pTableModel) {
		if (sorter == null) {
			sorter = new TableRowSorter<TableModel>(pTableModel);
		}
		return sorter;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Seleccionar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent pEvent) {
					int rowIndex = getJTable().getSelectedRow();
					if (rowIndex >= 0) {
						DTO<Object> selectedDTO =
								(DTO<Object>) getAmbarLookUpTableModel().getData().
                                              get(getJTable().convertRowIndexToModel(getJTable().getSelectedRow()));
						Object value = null;
						try {
							String fieldName;
						    Class<?> c = selectedDTO.getClass();
					    	fieldName = getValueField();
					    	Field field = c.getDeclaredField(fieldName);
						    field.setAccessible(true);
						    value = field.get(selectedDTO);
						    getLookUpResult().setValue(value.toString());

					    	fieldName = getDescField();
					    	field = c.getDeclaredField(fieldName);
						    field.setAccessible(true);
						    value = field.get(selectedDTO);
						    getLookUpResult().setDescription(value.toString());

						 } catch (Exception e) {
						 } finally {
							 setVisible(false);
						 }
					} else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un valor.");
					}
				}
			});
			ImageIcon icon = new ImageIcon(LookUpWindow.class.getResource("button_ok.png"));
			btnAceptar.setIcon(icon);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLookUpResult().setValue(null);
					getLookUpResult().setDescription(null);
					setVisible(false);
				}
			});
			ImageIcon icon = new ImageIcon(LookUpWindow.class.getResource("button_cancel.png"));
			btnCancelar.setIcon(icon);
		}
		return btnCancelar;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			scrollPane.setViewportView(getJTable());
		}
		return scrollPane;
	}
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
			ImageIcon icon = new ImageIcon(LookUpWindow.class.getResource("search.png"));
			btnBuscar.setIcon(icon);
			btnBuscar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent pActionEvent) {
	              String text = getFldBuscar().getText();
	              if (text.length() == 0) {
	                sorter.setRowFilter(null);
	              } else {
	                sorter.setRowFilter(RowFilter.regexFilter(text));
	              }
	            }
	          });
		}
		return btnBuscar;
	}

	public void setEntity(Entity entityMetaData) {
		this.entity = entityMetaData;
		
	}

	public void setVisibleFields(List<String> pVisibleFields) {
		this.visibleFields = pVisibleFields;
		
	}
} // @jve:decl-index=0:visual-constraint="10,10"

