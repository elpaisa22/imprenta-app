/**
 * appl-frontend-desktop [06/06/2012 18:46:22]
 */
package org.ambar.appl.abm.views.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import org.ambar.appl.abm.views.api.OrdenTrabajoABM;
import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.components.abm.view.impl.AbstractABMImpl;
import org.ambar.appl.components.lookup.LookUp;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.appl.main.MainView;

import com.toedter.calendar.JDateChooser;

/**
 * <p>
 * Implementacion del ABM de Orden de Trabajo.
 * </p>
 *
 * @author Sebastian
 *
 */
public class OrdenTrabajoABMImpl
	extends AbstractABMImpl<Long, OrdenTrabajoDTO, Long, OrdenTrabajo>
	implements OrdenTrabajoABM {

	/**
	 * Constructor default.
	 **/
	public OrdenTrabajoABMImpl() {
		this.setTitle("Órdenes de Trabajo");
	}


	private static final long serialVersionUID = 6335147841329670019L;

	private JPanel centerPanel;
	private JLabel lblNroOrden;
	private JDateChooser fldFecha;
	private JLabel lblFechaIngreso;
	private JTextField fldId;
	private JLabel lblCliente;
	private LookUp fldCliente;
	private JLabel lblRazonsocialcliente;
	private JTextField fldDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblFechaPautada;
	private JDateChooser fldFechaPautada;
	private JFormattedTextField fldImporteTotal;
	private JLabel lblImporteTotal;
	private JLabel lblFechaEntrega;
	private JDateChooser fldFechaEntrega;
	private JLabel lblCantidad;
	private JSpinner fldCantidad;
	private JLabel lblEstadoOrden;
	private JComboBox fldEstadoOrden;
	private JLabel lblAncho;
	private JFormattedTextField fldAncho;
	private JLabel lblAlto;
	private JFormattedTextField fldAlto;
	private JLabel lblTipoMaterial;
	private JTextField fldTipoMaterial;
	private JLabel lblColoresFrontales;
	private JFormattedTextField fldColoresFrontales;
	private JLabel lblColoresTraseros;
	private JTextField fldColoresTraseros;
	private JLabel lblFactura;
	private JTextField fldFactura;
	private JLabel lblRemito;
	private JTextField fldRemito;


	@Override
	protected void loadViewFromDTO() {
		OrdenTrabajoDTO ordenTrabajoDTO = (OrdenTrabajoDTO) dto;
		if (ordenTrabajoDTO.getId() != null) {
			getFldId().setText(ordenTrabajoDTO.getId().toString());
		} else {
			getFldId().setText("");
		}
		if (ordenTrabajoDTO.getFechaInicio() != null) {
			getFldFecha().setDate(ordenTrabajoDTO.getFechaInicio());
		} else {
			getFldFecha().setDate(null);
		}
		if (ordenTrabajoDTO.getFechaPautada() != null) {
			getFldFechaPautada().setDate(ordenTrabajoDTO.getFechaPautada());
		} else {
			getFldFechaPautada().setDate(null);
		}
		if (ordenTrabajoDTO.getFechaEntrega() != null) {
			getFldFechaEntrega().setDate(ordenTrabajoDTO.getFechaEntrega());
		} else {
			getFldFechaEntrega().setDate(null);
		}
		if (ordenTrabajoDTO.getIdCliente() != null) {
			getFldCliente().setValue(ordenTrabajoDTO.getIdCliente().toString());
		} else {
			getFldCliente().setValue(null);
			getLblRazonsocialcliente().setText(null);
		}
		if (ordenTrabajoDTO.getDescripcion() != null) {
			getFldDescripcion().setText(ordenTrabajoDTO.getDescripcion().toString());
		} else {
			getFldDescripcion().setText("");
		}
		if (ordenTrabajoDTO.getCantidad() != null) {
			getFldCantidad().setValue(ordenTrabajoDTO.getCantidad());
		} else {
			getFldCantidad().setValue(new BigDecimal("0"));
		}
		if (ordenTrabajoDTO.getEstadoOrden() != null) {
			getFldEstadoOrden().setSelectedItem(ordenTrabajoDTO.getEstadoOrden());
		} else {
			getFldEstadoOrden().setSelectedItem(null);
		}		
		if (ordenTrabajoDTO.getImporteTotal() != null) {
			getFldImporteTotal().setText(ordenTrabajoDTO.getImporteTotal().toString());
		} else {
			getFldImporteTotal().setText("");
		}		
		if (ordenTrabajoDTO.getAncho() != null) {
			getFldAncho().setText(ordenTrabajoDTO.getAncho().toString());
		} else {
			getFldAncho().setText("");
		}		
		if (ordenTrabajoDTO.getAlto() != null) {
			getFldAlto().setText(ordenTrabajoDTO.getAlto().toString());
		} else {
			getFldAlto().setText("");
		}		
		if (ordenTrabajoDTO.getTipoMaterial() != null) {
			getFldTipoMaterial().setText(ordenTrabajoDTO.getTipoMaterial().toString());
		} else {
			getFldTipoMaterial().setText("");
		}		
		if (ordenTrabajoDTO.getColoresFrontales() != null) {
			getFldColoresFrontales().setText(ordenTrabajoDTO.getColoresFrontales().toString());
		} else {
			getFldColoresFrontales().setText("");
		}
		if (ordenTrabajoDTO.getColoresTraseros() != null) {
			getFldColoresTraseros().setText(ordenTrabajoDTO.getColoresTraseros().toString());
		} else {
			getFldColoresTraseros().setText("");
		}
		if (ordenTrabajoDTO.getIdFactura() != null) {
			getFldFactura().setText(ordenTrabajoDTO.getIdFactura().toString());
		} else {
			getFldFactura().setText("");
		}
		if (ordenTrabajoDTO.getIdRemito() != null) {
			getFldRemito().setText(ordenTrabajoDTO.getIdRemito().toString());
		} else {
			getFldRemito().setText("");
		}
	}

	@Override
	protected void setIconImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("note.png")));
	}

	@Override
	protected void loadDTOFromView() {
		OrdenTrabajoDTO ordenTrabajoDTO = (OrdenTrabajoDTO) dto;
		if (getFldCliente().getValue() != null) {
			ordenTrabajoDTO.setIdCliente(Long.parseLong(getFldCliente().getValue()));
		}
		if (getFldFecha().getDate() != null) {
			ordenTrabajoDTO.setFechaInicio(getFldFecha().getDate());
		}
		if (getFldFechaPautada().getDate() != null) {
			ordenTrabajoDTO.setFechaPautada(getFldFechaPautada().getDate());
		}
		if (getFldFechaEntrega().getDate() != null) {
			ordenTrabajoDTO.setFechaEntrega(getFldFechaEntrega().getDate());
		}
		ordenTrabajoDTO.setDescripcion(getFldDescripcion().getText());
		if (getFldCantidad().getValue() != null) {
			ordenTrabajoDTO.setCantidad((Integer) getFldCantidad().getValue());
		}
		if (getFldEstadoOrden().getSelectedItem() != null) {
			ordenTrabajoDTO.setEstadoOrden(getFldEstadoOrden().getSelectedItem().toString());
		}		
		if (!getFldImporteTotal().getText().equals("")) {
			ordenTrabajoDTO.setImporteTotal(new BigDecimal(getFldImporteTotal().getText()));
		}
		if (!getFldAncho().getText().equals("")) {
			ordenTrabajoDTO.setAncho(new Long(getFldAncho().getText()));
		}
		if (!getFldAlto().getText().equals("")) {
			ordenTrabajoDTO.setAlto(new Long(getFldAlto().getText()));
		}		
		if (!getFldTipoMaterial().getText().equals("")) {
			ordenTrabajoDTO.setTipoMaterial(getFldTipoMaterial().getText());
		}
		if (!getFldColoresFrontales().getText().equals("")) {
			ordenTrabajoDTO.setColoresFrontales(new Integer(getFldColoresFrontales().getText()));
		}
		if (!getFldColoresTraseros().getText().equals("")) {
			ordenTrabajoDTO.setColoresTraseros(new Integer(getFldColoresTraseros().getText()));
		}
		if (!getFldFactura().getText().equals("")) {
			ordenTrabajoDTO.setIdFactura(new Long(getFldFactura().getText()));
		}
		if (!getFldRemito().getText().equals("")) {
			ordenTrabajoDTO.setIdRemito(new Long(getFldRemito().getText()));
		}
	}

	@Override
	protected void setControlsReadOny() {
		getFldFecha().setEnabled(false);
		getFldCliente().setEnabled(false);
		getFldEstadoOrden().setEnabled(false);
		getFldDescripcion().setEditable(false);
		getFldFechaPautada().setEnabled(false);
		getFldFechaEntrega().setEnabled(false);
		getFldCantidad().setEnabled(false);		
		getFldImporteTotal().setEditable(false);
		getFldFechaEntrega().setEnabled(false);
		getFldAncho().setEditable(false);
		getFldAlto().setEditable(false);
		getFldTipoMaterial().setEditable(false);
		getFldColoresFrontales().setEditable(false);
		getFldColoresTraseros().setEditable(false);
	}

	@Override
	protected void setControlsEnabled() {
		getFldFecha().setEnabled(true);
		getFldCliente().setEnabled(true);
		getFldEstadoOrden().setEnabled(true);
		getFldDescripcion().setEditable(true);
		getFldDescripcion().setEnabled(true);
		getFldFechaPautada().setEnabled(true);
		getFldFechaEntrega().setEnabled(true);
		getFldCliente().setEnabled(true);
		getFldCantidad().setEnabled(true);
		getFldImporteTotal().setEditable(true);
		getFldFechaEntrega().setEnabled(true);
		getFldAncho().setEditable(true);
		getFldAlto().setEditable(true);
		getFldTipoMaterial().setEditable(true);
		getFldColoresFrontales().setEditable(true);
		getFldColoresTraseros().setEditable(true);
	}

	@Override
	protected void initialize() {
		super.initialize();

		this.getJContentPane().add(getCenterPanel(), BorderLayout.CENTER);
		
		this.setMinimumSize(new Dimension(800, 500));
	}

	/**
	 * @return Retorna el valor del atributo centerPanel.
	 */
	public JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();

			centerPanel.setLayout(null);
			centerPanel.add(getLblDescripcion());
			centerPanel.add(getLblFechaIngreso());
			centerPanel.add(getLblNroOrden());
			centerPanel.add(getLblCliente());
			centerPanel.add(getLblImporteTotal());
			centerPanel.add(getLblCantidad());
			centerPanel.add(getFldId());
			centerPanel.add(getFldDescripcion());
			centerPanel.add(getLblFechaPautada());
			centerPanel.add(getFldFechaPautada());
			centerPanel.add(getFldCliente());
			centerPanel.add(getFldCantidad());
			centerPanel.add(getFldImporteTotal());
			centerPanel.add(getFldFecha());
			centerPanel.add(getLblEstadoOrden());
			centerPanel.add(getFldEstadoOrden());
			centerPanel.add(getLblFechaEntrega());
			centerPanel.add(getFldFechaEntrega());
			centerPanel.add(getLblRazonsocialcliente());
			centerPanel.add(getLblAncho());
			centerPanel.add(getFldAncho());
			centerPanel.add(getLblAlto());
			centerPanel.add(getFldAlto());
			centerPanel.add(getLblTipoMaterial());
			centerPanel.add(getFldTipoMaterial());
			centerPanel.add(getLblColoresFrontales());
			centerPanel.add(getFldColoresFrontales());
			centerPanel.add(getLblColoresTraseros());
			centerPanel.add(getFldColoresTraseros());
			centerPanel.add(getLblFactura());
			centerPanel.add(getFldFactura());
			centerPanel.add(getLblRemito());
			centerPanel.add(getFldRemito());
			

		}
		return centerPanel;
	}

	/**
	 * @return Retorna el valor del atributo lblNroOrden.
	 */
	public JLabel getLblNroOrden() {
		if (lblNroOrden == null) {
			lblNroOrden = new JLabel("Nro. Orden");
			lblNroOrden.setBounds(22, 24, 73, 14);
		}
		return lblNroOrden;
	}

	/**
	 * @return Retorna el valor del atributo fldId.
	 */
	public JTextField getFldId() {
		if (fldId == null) {
			fldId = new JTextField();
			fldId.setBounds(155, 21, 86, 20);
			fldId.setEditable(false);
			fldId.setColumns(10);
		}
		return fldId;
	}

	/**
	 * @return Retorna el valor del atributo lblFechaIngreso.
	 */
	public JLabel getLblFechaIngreso() {
		if (lblFechaIngreso == null) {
			lblFechaIngreso = new JLabel("Fecha Inicio");
			lblFechaIngreso.setBounds(22, 95, 73, 14);
		}
		return lblFechaIngreso;
	}

	/**
	 * @return Retorna el valor del atributo lblNroOrden.
	 */
	public JDateChooser getFldFecha() {
		if (fldFecha == null) {
			fldFecha = new JDateChooser();
			fldFecha.setBounds(155, 89, 107, 20);
		}
		return fldFecha;
	}

	private JLabel getLblCliente() {
		if (lblCliente == null) {
			lblCliente = new JLabel("Cliente");
			lblCliente.setBounds(22, 127, 51, 14);
		}
		return lblCliente;
	}

	private LookUp getFldCliente() {
		if (fldCliente == null) {
			fldCliente = new LookUp();
			fldCliente.setBounds(155, 120, 107, 25);
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
			lblRazonsocialcliente.setBounds(272, 120, 235, 25);
			lblRazonsocialcliente.setForeground(Color.BLACK);
			lblRazonsocialcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblRazonsocialcliente;
	}
	public JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setBounds(22, 64, 73, 14);
		}
		return lblDescripcion;
	}
	public JTextField getFldDescripcion() {
		if (fldDescripcion == null) {
			fldDescripcion = new JTextField();
			fldDescripcion.setBounds(155, 58, 352, 20);
			fldDescripcion.setColumns(10);
		}
		return fldDescripcion;
	}
	private JLabel getLblFechaPautada() {
		if (lblFechaPautada == null) {
			lblFechaPautada = new JLabel("Fecha Pautada");
			lblFechaPautada.setBounds(325, 95, 82, 14);
		}
		return lblFechaPautada;
	}
	private JDateChooser getFldFechaPautada() {
		if (fldFechaPautada == null) {
			fldFechaPautada = new JDateChooser();
			fldFechaPautada.setBounds(420, 89, 87, 20);
		}
		return fldFechaPautada;
	}
	private JLabel getLblImporteTotal() {
		if (lblImporteTotal == null) {
			lblImporteTotal = new JLabel("Importe Total ($)");
			lblImporteTotal.setBounds(22, 191, 118, 14);
		}
		return lblImporteTotal;
	}
	private JFormattedTextField getFldImporteTotal() {
		if (fldImporteTotal == null) {
			fldImporteTotal = new JFormattedTextField();
			fldImporteTotal.setBounds(155, 188, 107, 20);
		}
		return fldImporteTotal;
	}
	private JLabel getLblFechaEntrega() {
		if (lblFechaEntrega == null) {
			lblFechaEntrega = new JLabel("Fecha Entrega");
			lblFechaEntrega.setBounds(325, 188, 78, 14);
		}
		return lblFechaEntrega;
	}
	private JDateChooser getFldFechaEntrega() {
		if (fldFechaEntrega == null) {
			fldFechaEntrega = new JDateChooser();
			fldFechaEntrega.setBounds(420, 188, 87, 20);
		}
		return fldFechaEntrega;
	}
	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(22, 159, 65, 14);
		}
		return lblCantidad;
	}
	private JSpinner getFldCantidad() {
		if (fldCantidad == null) {
			fldCantidad = new JSpinner();
			fldCantidad.setBounds(155, 156, 107, 20);
		}
		return fldCantidad;
	}
	private JLabel getLblEstadoOrden() {
		if (lblEstadoOrden == null) {
			lblEstadoOrden = new JLabel("Estado");
			lblEstadoOrden.setBounds(325, 24, 43, 14);
		}
		return lblEstadoOrden;
	}
	private JComboBox getFldEstadoOrden() {
		if (fldEstadoOrden == null) {
			fldEstadoOrden = new JComboBox();
			fldEstadoOrden.setModel(new DefaultComboBoxModel(new String[] {"EMITIDA", "COMPLETADA", "FACTURADA"}));
			fldEstadoOrden.setBounds(415, 21, 92, 20);
		}
		return fldEstadoOrden;
	}
	private JLabel getLblAncho() {
		if (lblAncho == null) {
			lblAncho = new JLabel("Ancho (cm)");
			lblAncho.setBounds(22, 224, 86, 14);
		}
		return lblAncho;
	}
	private JFormattedTextField getFldAncho() {
		if (fldAncho == null) {
			fldAncho = new JFormattedTextField();
			fldAncho.setBounds(155, 220, 107, 20);
		}
		return fldAncho;
	}
	private JLabel getLblAlto() {
		if (lblAlto == null) {
			lblAlto = new JLabel("Alto (cm)");
			lblAlto.setBounds(326, 223, 46, 14);
		}
		return lblAlto;
	}
	private JFormattedTextField getFldAlto() {
		if (fldAlto == null) {
			fldAlto = new JFormattedTextField();
			fldAlto.setBounds(420, 218, 87, 20);
		}
		return fldAlto;
	}
	private JLabel getLblTipoMaterial() {
		if (lblTipoMaterial == null) {
			lblTipoMaterial = new JLabel("Tipo Material");
			lblTipoMaterial.setBounds(22, 256, 89, 14);
		}
		return lblTipoMaterial;
	}
	private JTextField getFldTipoMaterial() {
		if (fldTipoMaterial == null) {
			fldTipoMaterial = new JTextField();
			fldTipoMaterial.setBounds(155, 251, 352, 20);
			fldTipoMaterial.setColumns(10);
		}
		return fldTipoMaterial;
	}
	private JLabel getLblColoresFrontales() {
		if (lblColoresFrontales == null) {
			lblColoresFrontales = new JLabel("Colores Frontales");
			lblColoresFrontales.setBounds(21, 287, 118, 14);
		}
		return lblColoresFrontales;
	}
	private JFormattedTextField getFldColoresFrontales() {
		if (fldColoresFrontales == null) {
			fldColoresFrontales = new JFormattedTextField();
			fldColoresFrontales.setBounds(156, 283, 106, 20);
		}
		return fldColoresFrontales;
	}
	private JLabel getLblColoresTraseros() {
		if (lblColoresTraseros == null) {
			lblColoresTraseros = new JLabel("Colores Traseros");
			lblColoresTraseros.setBounds(327, 286, 86, 14);
		}
		return lblColoresTraseros;
	}
	private JTextField getFldColoresTraseros() {
		if (fldColoresTraseros == null) {
			fldColoresTraseros = new JTextField();
			fldColoresTraseros.setBounds(421, 282, 86, 20);
			fldColoresTraseros.setColumns(10);
		}
		return fldColoresTraseros;
	}
	private JLabel getLblFactura() {
		if (lblFactura == null) {
			lblFactura = new JLabel("Factura");
			lblFactura.setBounds(22, 317, 46, 14);
		}
		return lblFactura;
	}
	private JTextField getFldFactura() {
		if (fldFactura == null) {
			fldFactura = new JTextField();
			fldFactura.setEditable(false);
			fldFactura.setBounds(156, 314, 107, 20);
			fldFactura.setColumns(10);
		}
		return fldFactura;
	}
	private JLabel getLblRemito() {
		if (lblRemito == null) {
			lblRemito = new JLabel("Remito");
			lblRemito.setBounds(327, 317, 46, 14);
		}
		return lblRemito;
	}
	private JTextField getFldRemito() {
		if (fldRemito == null) {
			fldRemito = new JTextField();
			fldRemito.setEditable(false);
			fldRemito.setBounds(421, 313, 86, 20);
			fldRemito.setColumns(10);
		}
		return fldRemito;
	}
} // @jve:decl-index=0:visual-constraint="10,10"