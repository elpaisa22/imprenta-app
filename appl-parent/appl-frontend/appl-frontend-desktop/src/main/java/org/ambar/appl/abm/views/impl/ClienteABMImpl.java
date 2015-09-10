/**
 * appl-frontend-desktop [24/05/2012 20:08:27]
 */
package org.ambar.appl.abm.views.impl;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ambar.appl.abm.views.api.ClienteABM;
import org.ambar.appl.be.Cliente;
import org.ambar.appl.components.abm.view.impl.AbstractABMImpl;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.main.MainView;

/**
 * <p>
 * Implementacion del ABM de Cliente.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ClienteABMImpl
	extends AbstractABMImpl<Long, ClienteDTO, Long, Cliente>
    implements ClienteABM {

	/**
	 * Constructor default.
	 **/
	public ClienteABMImpl() {
		this.setTitle("Clientes");
	}

	private static final long serialVersionUID = -2661724229654368883L;

	private JPanel centerPanel;
	private JLabel lblTipoDocumento;
	private JComboBox fldTipoDocumento;
	private JLabel lblNroDocumento;
	private JTextField fldNroDocumento;
	private JLabel lblNroCliente;
	private JTextField fldNroCliente;
	private JLabel lblRazonSocial;
	private JTextField fldRazonSocial;
	private JLabel lblTelefono;
	private JTextField fldTelefono;
	private JLabel lblEmail;
	private JTextField fldEmail;
	private JLabel lblDireccin;
	private JTextField fldDireccion;
	private JLabel lblProvincia;
	private JLabel lblPais;
	private JLabel lblCiudad;
	private JTextField fldCiudad;
	private JComboBox fldProvincia;
	private JComboBox fldPais;

	@Override
	protected void loadViewFromDTO() {
		ClienteDTO clienteDTO = (ClienteDTO) dto;

		if (clienteDTO.getId() != null) {
			fldNroCliente.setText(clienteDTO.getId().toString());
		} else {
			fldNroCliente.setText("");
		}
		if (clienteDTO.getNumeroDocumento() != null) {
			fldNroDocumento.setText(clienteDTO.getNumeroDocumento().toString());
		} else {
			fldNroDocumento.setText("");
		}
		if (clienteDTO.getRazonSocial() != null) {
			fldRazonSocial.setText(clienteDTO.getRazonSocial());
		} else {
			fldRazonSocial.setText("");
		}
		if (clienteDTO.getTipoDocumento() != null) {
			fldTipoDocumento.setSelectedItem(clienteDTO.getTipoDocumento());
		} else {
			fldTipoDocumento.setSelectedItem(null);
		}
		if (clienteDTO.getTelefono() != null) {
			fldTelefono.setText(clienteDTO.getTelefono());
		} else {
			fldTelefono.setText("");
		}
		if (clienteDTO.getEmail() != null) {
			fldEmail.setText(clienteDTO.getEmail());
		} else {
			fldEmail.setText("");
		}
		if (clienteDTO.getDireccion() != null) {
			fldDireccion.setText(clienteDTO.getDireccion());
		} else {
			fldDireccion.setText("");
		}
		if (clienteDTO.getCiudad() != null) {
			fldCiudad.setText(clienteDTO.getCiudad());
		} else {
			fldCiudad.setText("");
		}
		if (clienteDTO.getProvincia() != null) {
			fldProvincia.setSelectedItem(clienteDTO.getProvincia());
		} else {
			fldProvincia.setSelectedItem(null);
		}
		if (clienteDTO.getPais() != null) {
			fldPais.setSelectedItem(clienteDTO.getPais());
		} else {
			fldPais.setSelectedItem(null);
		}


	}

	@Override
	protected void loadDTOFromView() {
		ClienteDTO clienteDTO = (ClienteDTO) dto;

		clienteDTO.setNumeroDocumento(fldNroDocumento.getText());
		clienteDTO.setRazonSocial(fldRazonSocial.getText());
		if (fldTipoDocumento.getSelectedItem() != null) {
			clienteDTO.setTipoDocumento(fldTipoDocumento.getSelectedItem().toString());
		}
		clienteDTO.setTelefono(fldTelefono.getText());
		clienteDTO.setEmail(fldEmail.getText());
		clienteDTO.setDireccion(fldDireccion.getText());
		clienteDTO.setCiudad(fldCiudad.getText());
		if (fldProvincia.getSelectedItem() != null) {
			clienteDTO.setProvincia(fldProvincia.getSelectedItem().toString());
		}
		if (fldPais.getSelectedItem() != null) {
			clienteDTO.setPais(fldPais.getSelectedItem().toString());
		}
	}

	@Override
	protected void setIconImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("business_users.png")));
	}

	@Override
	protected void setControlsReadOny() {
		fldNroDocumento.setEditable(false);
		fldRazonSocial.setEditable(false);
		fldTipoDocumento.setEnabled(false);
		fldTelefono.setEditable(false);
		fldEmail.setEditable(false);
		fldDireccion.setEditable(false);
		fldCiudad.setEditable(false);
		fldPais.setEnabled(false);
		fldProvincia.setEnabled(false);
	}

	@Override
	protected void setControlsEnabled() {
		fldNroDocumento.setEditable(true);
		fldRazonSocial.setEditable(true);
		fldTipoDocumento.setEnabled(true);
		fldTelefono.setEditable(true);
		fldEmail.setEditable(true);
		fldDireccion.setEditable(true);
		fldCiudad.setEditable(true);
		fldPais.setEnabled(true);
		fldProvincia.setEnabled(true);
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
			centerPanel.add(getLblNroCliente());
			centerPanel.add(getFldNroCliente());
			centerPanel.add(getLblTipoDocumento());
			centerPanel.add(getLblRazonSocial());
			centerPanel.add(getLblEmail());
			centerPanel.add(getLblDireccin());
			centerPanel.add(getLblProvincia());
			centerPanel.add(getFldDireccion());
			centerPanel.add(getFldEmail());
			centerPanel.add(getFldRazonSocial());
			centerPanel.add(getFldProvincia());
			centerPanel.add(getFldTipoDocumento());
			centerPanel.add(getLblTelefono());
			centerPanel.add(getLblCiudad());
			centerPanel.add(getFldTelefono());
			centerPanel.add(getFldCiudad());
			centerPanel.add(getFldPais());
			centerPanel.add(getLblNroDocumento());
			centerPanel.add(getFldNroDocumento());
			centerPanel.add(getLblPais());
		}
		return centerPanel;
	}

	private JLabel getLblTipoDocumento() {
		if (lblTipoDocumento == null) {
			lblTipoDocumento = new JLabel("Tipo Documento");
			lblTipoDocumento.setBounds(28, 107, 83, 14);
		}
		return lblTipoDocumento;
	}
	private JComboBox getFldTipoDocumento() {
		if (fldTipoDocumento == null) {
			fldTipoDocumento = new JComboBox();
			fldTipoDocumento.setBounds(123, 104, 86, 20);
			fldTipoDocumento.setModel(new DefaultComboBoxModel(new String[] {"CUIT", "DNI", "CUIL"}));
		}
		return fldTipoDocumento;
	}
	private JLabel getLblNroDocumento() {
		if (lblNroDocumento == null) {
			lblNroDocumento = new JLabel("Nro. Documento");
			lblNroDocumento.setBounds(425, 107, 87, 14);
		}
		return lblNroDocumento;
	}
	private JTextField getFldNroDocumento() {
		if (fldNroDocumento == null) {
			fldNroDocumento = new JTextField();
			fldNroDocumento.setBounds(521, 104, 204, 20);
			fldNroDocumento.setColumns(10);
		}
		return fldNroDocumento;
	}
	private JLabel getLblNroCliente() {
		if (lblNroCliente == null) {
			lblNroCliente = new JLabel("Nro. Cliente");
			lblNroCliente.setBounds(28, 25, 83, 14);
		}
		return lblNroCliente;
	}
	private JTextField getFldNroCliente() {
		if (fldNroCliente == null) {
			fldNroCliente = new JTextField();
			fldNroCliente.setBounds(123, 22, 86, 20);
			fldNroCliente.setEditable(false);
			fldNroCliente.setColumns(10);
		}
		return fldNroCliente;
	}
	private JLabel getLblRazonSocial() {
		if (lblRazonSocial == null) {
			lblRazonSocial = new JLabel("Razon Social");
			lblRazonSocial.setBounds(28, 69, 83, 14);
		}
		return lblRazonSocial;
	}
	private JTextField getFldRazonSocial() {
		if (fldRazonSocial == null) {
			fldRazonSocial = new JTextField();
			fldRazonSocial.setBounds(123, 66, 272, 20);
			fldRazonSocial.setColumns(10);
		}
		return fldRazonSocial;
	}
	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Teléfono");
			lblTelefono.setBounds(425, 145, 87, 14);
		}
		return lblTelefono;
	}
	private JTextField getFldTelefono() {
		if (fldTelefono == null) {
			fldTelefono = new JTextField();
			fldTelefono.setBounds(522, 142, 203, 20);
			fldTelefono.setColumns(10);
		}
		return fldTelefono;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-Mail");
			lblEmail.setBounds(28, 145, 83, 14);
		}
		return lblEmail;
	}
	private JTextField getFldEmail() {
		if (fldEmail == null) {
			fldEmail = new JTextField();
			fldEmail.setBounds(123, 142, 272, 20);
			fldEmail.setColumns(10);
		}
		return fldEmail;
	}
	private JLabel getLblDireccin() {
		if (lblDireccin == null) {
			lblDireccin = new JLabel("Dirección");
			lblDireccin.setBounds(28, 183, 83, 14);
		}
		return lblDireccin;
	}
	private JTextField getFldDireccion() {
		if (fldDireccion == null) {
			fldDireccion = new JTextField();
			fldDireccion.setBounds(123, 180, 272, 20);
			fldDireccion.setColumns(10);
		}
		return fldDireccion;
	}
	private JLabel getLblProvincia() {
		if (lblProvincia == null) {
			lblProvincia = new JLabel("Provincia");
			lblProvincia.setBounds(28, 221, 83, 14);
		}
		return lblProvincia;
	}
	private JLabel getLblPais() {
		if (lblPais == null) {
			lblPais = new JLabel("Pais");
			lblPais.setBounds(425, 221, 87, 14);
		}
		return lblPais;
	}
	private JLabel getLblCiudad() {
		if (lblCiudad == null) {
			lblCiudad = new JLabel("Ciudad");
			lblCiudad.setBounds(425, 183, 87, 14);
		}
		return lblCiudad;
	}
	private JTextField getFldCiudad() {
		if (fldCiudad == null) {
			fldCiudad = new JTextField();
			fldCiudad.setBounds(522, 180, 203, 20);
			fldCiudad.setColumns(10);
		}
		return fldCiudad;
	}
	private JComboBox getFldProvincia() {
		if (fldProvincia == null) {
			fldProvincia = new JComboBox();
			fldProvincia.setBounds(123, 218, 169, 20);
			fldProvincia.setModel(new DefaultComboBoxModel(new String[] {"Buenos Aires", "Ciudad Autónoma de B.A.", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucumán"}));
		}
		return fldProvincia;
	}
	private JComboBox getFldPais() {
		if (fldPais == null) {
			fldPais = new JComboBox();
			fldPais.setBounds(522, 218, 203, 20);
			fldPais.setModel(new DefaultComboBoxModel(new String[] {"Argentina"}));
		}
		return fldPais;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
