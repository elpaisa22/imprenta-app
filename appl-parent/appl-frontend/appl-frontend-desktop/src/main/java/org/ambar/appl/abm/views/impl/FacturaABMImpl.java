/**
 * 
 */
package org.ambar.appl.abm.views.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.ambar.appl.abm.views.api.FacturaABM;
import org.ambar.appl.be.Factura;
import org.ambar.appl.components.abm.view.impl.AbstractABMImpl;
import org.ambar.appl.components.lookup.LookUp;
import org.ambar.appl.components.table.simple.AmbarSimpleColumn;
import org.ambar.appl.components.table.simple.AmbarSimpleTableColumnModel;
import org.ambar.appl.components.table.simple.AmbarSimpleTableModel;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.main.MainView;
import org.ambar.core.dictionary.domain.entities.DataType;

import com.toedter.calendar.JDateChooser;

/**
 * @author Sebastian
 *
 */
public class FacturaABMImpl
	extends AbstractABMImpl<Long, FacturaDTO, Long, Factura>
	implements FacturaABM {

	public FacturaABMImpl() {
		this.setTitle("Facturas");
		this.setSize(800, 600);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6233860711262587650L;

	private JPanel centerPanel;
	private JTable tableOrdenesDeTrabajo;
	private JScrollPane scrollPanelOrdenesTrabajo;
	private JLabel lblNroFactura;
	private JTextField fldNroFactura;
	private JLabel lblFechaEmision;
	private JDateChooser fldFechaEmision;
	private JLabel lblRemito;
	private LookUp fldRemito;
	private JLabel lblDescripcionremito;
	private JLabel lblCliente;
	private LookUp fldCliente;
	private JLabel lblRazonsocialcliente;
	private JComboBox fldCondicionPago;
	private JLabel lblCondicionVenta;
	private JLabel lblEstadoPago;
	private JComboBox fldEstadoPago;
	private JLabel lblOrdenesDeTrabajo;
	private JLabel lblPagos;
	private JTable tablePagos;
	private JScrollPane scrollPane;

	@Override
	protected void loadViewFromDTO() {
		FacturaDTO facturaDTO = (FacturaDTO) dto;

		if (facturaDTO.getId() != null) {
			getFldNroFactura().setText(facturaDTO.getId().toString());
		} else {
			getFldNroFactura().setText("");
		}
		if (facturaDTO.getFechaEmision() != null) {
			getFldFechaEmision().setDate(facturaDTO.getFechaEmision());
		} else {
			getFldFechaEmision().setDate(null);
		}
		if (facturaDTO.getIdCliente() != null) {
			getCliente().setValue(facturaDTO.getIdCliente().toString());
		} else {
			getCliente().setValue(null);
			getLblRazonsocialcliente().setText(null);
		}
		if (facturaDTO.getIdRemito() != null) {
			getRemito().setValue(facturaDTO.getIdRemito().toString());
		} else {
			getRemito().setValue(null);
			getLblDescripcionremito().setText(null);
		}
		if (facturaDTO.getEstadoPago() != null) {
			getFldEstadoPago().setSelectedItem(facturaDTO.getEstadoPago());
		} else {
			getFldEstadoPago().setSelectedItem(null);
		}
		if (facturaDTO.getCondicionVenta() != null) {
			getFldCondicionPago().setSelectedItem(facturaDTO.getCondicionVenta());
		} else {
			getFldCondicionPago().setSelectedItem(null);
		}
		
		((AmbarSimpleTableModel) this.tableOrdenesDeTrabajo.getModel()).setData(facturaDTO.getColeccionOrdenesTrabajo());
		tableOrdenesDeTrabajo.doLayout();
		
		((AmbarSimpleTableModel) this.tablePagos.getModel()).setData(facturaDTO.getColeccionPagos());
		tablePagos.doLayout();
		
		
		
	}

	@Override
	protected void loadDTOFromView() {
		FacturaDTO facturaDTO = (FacturaDTO) dto;

		if (getFldFechaEmision().getDate() != null) {
			facturaDTO.setFechaEmision(getFldFechaEmision().getDate());
		}
		if (getCliente().getValue() != null) {
			facturaDTO.setIdCliente(Long.parseLong(getCliente().getValue()));
		}
		if (getRemito().getValue() != null) {
			facturaDTO.setIdRemito(Long.parseLong(getRemito().getValue()));
		}
		if (getFldEstadoPago().getSelectedItem() != null) {
			facturaDTO.setEstadoPago(getFldEstadoPago().getSelectedItem().toString());
		}
		if (getFldCondicionPago().getSelectedItem() != null) {
			facturaDTO.setCondicionVenta(getFldCondicionPago().getSelectedItem().toString());
		}
		
	}

	@Override
	protected void setControlsReadOny() {
		getFldFechaEmision().setEnabled(false);
		getCliente().setEnabled(false);
		getRemito().setEnabled(false);
		getFldEstadoPago().setEnabled(false);
		getFldCondicionPago().setEnabled(false);
	}

	@Override
	protected void setControlsEnabled() {
		getFldNroFactura().setEnabled(true);
		getFldFechaEmision().setEnabled(true);
		getCliente().setEnabled(true);
		getRemito().setEnabled(true);
		getFldEstadoPago().setEnabled(true);
		getFldCondicionPago().setEnabled(true);
		
	}

	@Override
	protected void setIconImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("paper_16.png")));
	}
	
	@Override
	protected void initialize() {
		super.initialize();

		this.getJContentPane().add(getCenterPanel(), BorderLayout.CENTER);
	}

	/**
	 * @return Retorna el valor del atributo centerPanel.
	 */
	public JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setLayout(null);
			centerPanel.add(getScrollPane());
			centerPanel.add(getScrollPanelOrdenesTrabajo());
			centerPanel.add(getLblNroFactura());
			centerPanel.add(getLblFechaEmision());
			centerPanel.add(getLblRemito());
			centerPanel.add(getLblCliente());
			centerPanel.add(getFldFechaEmision());
			centerPanel.add(getLblDescripcionremito());
			centerPanel.add(getRemito());
			centerPanel.add(getFldNroFactura());
			centerPanel.add(getCliente());
			centerPanel.add(getLblCondicionVenta());
			centerPanel.add(getLblEstadoPago());
			centerPanel.add(getFldEstadoPago());
			centerPanel.add(getFldCondicionPago());
			centerPanel.add(getLblRazonsocialcliente());
			centerPanel.add(getLblOrdenesDeTrabajo());
			centerPanel.add(getLblPagos());
		}
		return centerPanel;
	}

	private Component getScrollPanelOrdenesTrabajo() {
		if (scrollPanelOrdenesTrabajo == null) {
			scrollPanelOrdenesTrabajo = new JScrollPane();			
			scrollPanelOrdenesTrabajo.setBounds(10, 167, 826, 131);
			scrollPanelOrdenesTrabajo.setViewportView(getTableOrdenesDeTrabajo());
		}
		return scrollPanelOrdenesTrabajo;
	}

	private Component getTableOrdenesDeTrabajo() {
		if (tableOrdenesDeTrabajo == null) {
			Map<Integer, AmbarSimpleColumn> columns = new HashMap<Integer, AmbarSimpleColumn>();
			columns.put(0, new AmbarSimpleColumn("id", "Nro Orden", 120, DataType.Number));
			columns.put(1, new AmbarSimpleColumn("descripcion", "Descripción", 300, DataType.String));
			columns.put(2, new AmbarSimpleColumn("razonSocialCliente", "Nombre Cliente", 200, DataType.Number));
			columns.put(3, new AmbarSimpleColumn("fechaInicio", "Fecha Ingreso", 200, DataType.DateTime));
			columns.put(4, new AmbarSimpleColumn("estadoOrden", "Estado", 100, DataType.String));
			columns.put(5, new AmbarSimpleColumn("fechaPautada", "Fecha Pautada", 200, DataType.DateTime));
			columns.put(6, new AmbarSimpleColumn("importeTotal", "Importe Total", 200, DataType.Money));
			
			AmbarSimpleTableColumnModel ambarDetailTableColumnModel = new AmbarSimpleTableColumnModel(columns);
			AmbarSimpleTableModel ambarDetailTableModel = new AmbarSimpleTableModel(columns);
			tableOrdenesDeTrabajo = new JTable(ambarDetailTableModel, ambarDetailTableColumnModel);
			tableOrdenesDeTrabajo.createDefaultColumnsFromModel();
		}
		return tableOrdenesDeTrabajo;
	}

	private JTextField getFldNroFactura() {
		if (fldNroFactura == null) {
			fldNroFactura = new JTextField();
			fldNroFactura.setBounds(143, 21, 135, 20);
			fldNroFactura.setEditable(false);
			fldNroFactura.setColumns(10);
		}
		return fldNroFactura;
	}

	private Component getLblNroFactura() {
		if (lblNroFactura == null) {
			 lblNroFactura = new JLabel("Nro. Factura");
			 lblNroFactura.setBounds(10, 24, 114, 14);
		}
		return lblNroFactura;
	}
	
	private JLabel getLblFechaEmision() {
		if (lblFechaEmision == null) {
			lblFechaEmision = new JLabel("Fecha de Emisión");
			lblFechaEmision.setBounds(10, 53, 114, 14);
		}
		return lblFechaEmision;
	}

	private JDateChooser getFldFechaEmision() {
		if (fldFechaEmision == null) {
			fldFechaEmision = new JDateChooser();
			fldFechaEmision.setBounds(143, 47, 106, 20);
		}
		return fldFechaEmision;
	}
	
	private JLabel getLblRemito() {
		if (lblRemito == null) {
			lblRemito = new JLabel("Remito");
			lblRemito.setBounds(10, 84, 114, 14);
		}
		return lblRemito;
	}
	
	private LookUp getRemito() {
		if (fldRemito == null) {
			fldRemito = new LookUp();
			fldRemito.setBounds(143, 73, 135, 25);
			fldRemito.setLblDescripcion(getLblDescripcionremito());
			fldRemito.setValueField("id");
			fldRemito.setDescField("razonSocialCliente");
			fldRemito.setServices("remitoServices");
			fldRemito.setVisibleFields("id, razonSocialCliente, fechaEmision");
			fldRemito.setEntity("remito");
			fldRemito.setIdClass(Long.class);
			fldRemito.setWindowName("Seleccione un Remito");
		}
		return fldRemito;
	}
	
	private JLabel getLblDescripcionremito() {
		if (lblDescripcionremito == null) {
			lblDescripcionremito = new JLabel("");
			lblDescripcionremito.setBounds(253, 104, 0, 0);
			lblDescripcionremito.setForeground(Color.BLACK);
			lblDescripcionremito.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblDescripcionremito;
	}
	
	private JLabel getLblCliente() {
		if (lblCliente == null) {
			lblCliente = new JLabel("Cliente");
			lblCliente.setBounds(10, 115, 114, 14);
		}
		return lblCliente;
	}
	
	private LookUp getCliente() {
		if (fldCliente == null) {
			fldCliente = new LookUp();
			fldCliente.setBounds(143, 104, 135, 25);
			fldCliente.setLblDescripcion(getLblRazonsocialcliente());
			fldCliente.setValueField("id");
			fldCliente.setDescField("razonSocial");
			fldCliente.setServices("clienteServices");
			fldCliente.setVisibleFields("id, razonSocial, numeroDocumento");
			fldCliente.setEntity("cliente");
			fldCliente.setIdClass(Long.class);
			fldCliente.setWindowName("Seleccione un Cliente");
		}
		return fldCliente;
	}
	private JLabel getLblRazonsocialcliente() {
		if (lblRazonsocialcliente == null) {
			lblRazonsocialcliente = new JLabel("");
			lblRazonsocialcliente.setBounds(282, 129, 0, 0);
			lblRazonsocialcliente.setForeground(Color.BLACK);
			lblRazonsocialcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblRazonsocialcliente;
	}
	
	private JLabel getLblCondicionVenta() {
		if (lblCondicionVenta == null) {
			lblCondicionVenta = new JLabel("Condición Venta");
			lblCondicionVenta.setBounds(422, 24, 126, 14);
		}
		return lblCondicionVenta;
	}
	
	private JComboBox getFldCondicionPago() {
		if (fldCondicionPago == null) {
			fldCondicionPago = new JComboBox();
			fldCondicionPago.setBounds(584, 21, 168, 20);
			fldCondicionPago.setModel(new DefaultComboBoxModel(new String[] {"CONTADO", "CUENTA_CORRIENTE"}));
		}
		return fldCondicionPago;
	}
	
	private JLabel getLblEstadoPago() {
		if (lblEstadoPago == null) {
			lblEstadoPago = new JLabel("Estado Pago");
			lblEstadoPago.setBounds(422, 50, 126, 14);
		}
		return lblEstadoPago;
	}
	private JComboBox getFldEstadoPago() {
		if (fldEstadoPago == null) {
			fldEstadoPago = new JComboBox();
			fldEstadoPago.setBounds(584, 47, 168, 20);
			fldEstadoPago.setModel(new DefaultComboBoxModel(new String[] {"PAGADA", "PARCIAL", "PENDIENTE"}));
		}
		return fldEstadoPago;
	}
	private JLabel getLblOrdenesDeTrabajo() {
		if (lblOrdenesDeTrabajo == null) {
			lblOrdenesDeTrabajo = new JLabel("Ordenes de Trabajo:");
			lblOrdenesDeTrabajo.setBounds(10, 147, 135, 14);
			lblOrdenesDeTrabajo.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblOrdenesDeTrabajo;
	}
	private JLabel getLblPagos() {
		if (lblPagos == null) {
			lblPagos = new JLabel("Pagos:");
			lblPagos.setBounds(10, 343, 114, 14);
			lblPagos.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblPagos;
	}
	private JTable getTablePagos() {
		if (tablePagos == null) {
			Map<Integer, AmbarSimpleColumn> columns = new HashMap<Integer, AmbarSimpleColumn>();
			columns.put(0, new AmbarSimpleColumn("id", "Nro Pago", 120, DataType.Number));
			columns.put(1, new AmbarSimpleColumn("monto", "Monto", 120, DataType.Money));
			columns.put(2, new AmbarSimpleColumn("modoPago", "Modo de Pago", 120, DataType.String));
			columns.put(3, new AmbarSimpleColumn("razonSocialCliente", "Cliente", 150, DataType.String));
			columns.put(4, new AmbarSimpleColumn("fecha", "Fecha", 120, DataType.DateTime));

			AmbarSimpleTableColumnModel ambarDetailTableColumnModel = new AmbarSimpleTableColumnModel(columns);
			AmbarSimpleTableModel ambarDetailTableModel = new AmbarSimpleTableModel(columns);
			tablePagos = new JTable(ambarDetailTableModel, ambarDetailTableColumnModel);
			tablePagos.createDefaultColumnsFromModel();
		}
		return tablePagos;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 363, 826, 133);
			scrollPane.setViewportView(getTablePagos());
		}
		return scrollPane;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
