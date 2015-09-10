package org.ambar.appl.components.abm.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.ambar.appl.components.abm.view.api.AbstractABM;
import org.ambar.appl.components.abm.view.api.States;
import org.ambar.appl.components.navigation.api.NavigationBean;
import org.ambar.core.be.Persistible;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.results.MessageResult;
import org.ambar.core.dto.results.ResultVoidDTO;
import org.ambar.core.services.CrudServices;
/**
 * Clase base para los ABM.
 * @param <K> ID del DTO
 * @param <D> DTO
 * @param <T> ID de la BE
 * @param <E> BE
 * */
public abstract class AbstractABMImpl<K, D extends DTO<K>, T, E extends Persistible<T>>
    extends JFrame
    implements AbstractABM<K, D, T, E> {

	private static final long serialVersionUID = 1L;

	private static final Insets margins =  new Insets(0, 0, 0, 0);

	private JPanel jContentPane = null;
	private JMenuBar jMenuBar = null;
	private JMenu fileMenu = null;
	private JMenuItem saveMenuItem = null;
	private JMenuItem editMenuItem = null;
	private JMenuItem deleteMenuItem = null;
	private JMenuItem addMenuItem = null;
	private JMenuItem printMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem exitMenuItem = null;
	private JPanel southPanel;

	protected CrudServices<K, D, T, E> services;
	protected RequestContext requestContext;
	protected DTO<K> dto;

	protected DTO<K> dtoBackUp;

	protected TrackInfoDTO trackDto;

	protected NavigationBean navigationBean;

	protected States state;

	private JToolBar toolBar;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JPanel northPanel;


	private JLabel lblUsuario;
	private JLabel fldUsuario;
	private JLabel lblFechaCreacion;
	private JLabel fldFechaCreacion;
	private JLabel lblFechaModificacion;
	private JLabel fldFechaModificacion;
	private JLabel lblEstado;
	private JLabel fldEstado;
	private JButton btnDeshacer;

	/**
	 * This is the default constructor.
	 */
	public AbstractABMImpl() {
		super();
		setIconImage();
		initialize();
	}


	/**
	 * This method initializes this.
	 *
	 *
	 */
	protected void initialize() {
		this.setSize(735, 261);
		//this.setJMenuBar(getJJMenuBar());
		this.setMinimumSize(new Dimension(800, 400));
		this.setLocation(new Point(200, 200));
		this.setContentPane(getJContentPane());
		this.addWindowListener(new WindowListener() {
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
				navigationBean.reloadGrid();
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

	/**
	 * @return Retorna el valor del atributo services.
	 */
	public CrudServices<K, D, T, E> getServices() {
		return services;
	}

	/**
	 * @param pServices Establece el valor del atributo services.
	 */
	public void setServices(CrudServices<K, D, T, E> pServices) {
		services = pServices;
	}

	/**
	 * @param pRequestContext Establece el valor del atributo requestContext.
	 */
	public void setRequestContext(RequestContext pRequestContext) {
		requestContext = pRequestContext;
	}

	/**
	 * @param pNavigationBean Establece el valor del atributo navigationBean.
	 */
	public void setNavigationBean(NavigationBean pNavigationBean) {
		navigationBean = pNavigationBean;
	}

	/**
	 * @return Retorna el valor del atributo dto.
	 */
	public DTO<K> getDto() {
		return dto;
	}

	/**
	 * @param pDto Establece el valor del atributo dto.
	 */
	public void setDto(DTO<K> pDto) {
		dto = pDto;
	}


	/**
	 * Carga la vista con los datos de los DTO.
	 * */
	protected abstract void loadViewFromDTO();

	/**
	 * carga el DTO con la vista.
	 * */
	protected abstract void loadDTOFromView();

	/**
	 * Setea todos los controles en modo consulta.
	 * */
	protected abstract void setControlsReadOny();

	/**
	 * Setea todos los controles en modo edicion.
	 * */
	protected abstract void setControlsEnabled();

	/**
	 * Setea el icono del ABM.
	 * */
	protected abstract void setIconImage();


	/**
	 * This method initializes jContentPane.
	 *
	 * @return javax.swing.JPanel
	 */
	protected JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setBackground(Color.WHITE);
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getSouthPanel(), BorderLayout.SOUTH);
			jContentPane.add(getNorthPanel(), BorderLayout.NORTH);

		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar.
	 *
	 * @return javax.swing.JMenuBar
	 */
	protected JMenuBar getJJMenuBar() {
		if (jMenuBar == null) {
			jMenuBar = new JMenuBar();
			jMenuBar.add(getFileMenu());
		}
		return jMenuBar;
	}

	/**
	 * This method initializes jMenu.
	 *
	 * @return javax.swing.JMenu
	 */
	protected JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Archivo");
			fileMenu.add(getAddMenuItem());
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getEditMenuItem());
			fileMenu.add(getCopyMenuItem());
			fileMenu.add(getDeleteMenuItem());
			fileMenu.add(getPrintMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("save.png"));
			saveMenuItem.setIcon(icon);

			saveMenuItem.setText("Guardar");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
					Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), true));
		}
		return saveMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getEditMenuItem() {
		if (editMenuItem == null) {
			editMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("edit.png"));
			editMenuItem.setIcon(icon);

			editMenuItem.setText("Editar");
			editMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
					Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), true));
		}
		return editMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getDeleteMenuItem() {
		if (deleteMenuItem == null) {
			deleteMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("trash_can.png"));
			deleteMenuItem.setIcon(icon);

			deleteMenuItem.setText("Eliminar");
			deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
					Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), true));
		}
		return deleteMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getAddMenuItem() {
		if (addMenuItem == null) {
			addMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("new_page.png"));
			addMenuItem.setIcon(icon);

			addMenuItem.setText("Nuevo");
			addMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), true));
		}
		return addMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getPrintMenuItem() {
		if (printMenuItem == null) {
			printMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("printer.png"));
			printMenuItem.setIcon(icon);

			printMenuItem.setText("Imprimir");
		}
		return printMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();

			ImageIcon icon = new ImageIcon(AbstractABMImpl.class.getResource("copy_paste.png"));
			copyMenuItem.setIcon(icon);

			copyMenuItem.setText("Copiar");

		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem.
	 *
	 * @return javax.swing.JMenuItem
	 */
	protected JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Salir");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent pEvent) {
					if (JOptionPane.showConfirmDialog(null,
							"Realmente desea salir?") == JOptionPane.YES_OPTION) {
						setVisible(false);
						dispose();
					}

				}
			});
		}
		return exitMenuItem;
	}

	protected JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();

			GroupLayout gl_southPanel = new GroupLayout(southPanel);
			gl_southPanel.setHorizontalGroup(
				gl_southPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_southPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblUsuario())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getFldUsuario())
						.addGap(51)
						.addComponent(getLblFechaCreacion())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getFldFechaCreacion())
						.addGap(51)
						.addComponent(getLblFechaModificacion())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getFldFechaModificacion())
						.addGap(65)
						.addComponent(getLblEstado())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getFldEstado())
						.addContainerGap(185, Short.MAX_VALUE))
			);
			gl_southPanel.setVerticalGroup(
				gl_southPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_southPanel.createSequentialGroup()
						.addContainerGap(20, Short.MAX_VALUE)
						.addGroup(gl_southPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblUsuario())
							.addComponent(getFldUsuario())
							.addComponent(getLblFechaCreacion())
							.addComponent(getFldFechaCreacion())
							.addComponent(getLblFechaModificacion())
							.addComponent(getFldFechaModificacion())
							.addComponent(getLblEstado())
							.addComponent(getFldEstado()))
						.addContainerGap())
			);
			southPanel.setLayout(gl_southPanel);
		}
		return southPanel;
	}

	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.add(getBtnNuevo());
			toolBar.add(getBtnEditar());
			toolBar.add(getBtnGuardar());
			toolBar.add(getBtnEliminar());
			toolBar.add(getBtnDeshacer());
		}
		return toolBar;
	}
	private JButton getBtnNuevo() {
		if (btnNuevo == null) {
			btnNuevo = new JButton();
			btnNuevo.setToolTipText("Nuevo");
			btnNuevo.setMargin(margins);
			btnNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNuevo.setIcon(new ImageIcon(AbstractABMImpl.class.getResource("new_page.png")));
			btnNuevo.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent pEvent) {
					try {
						state = States.NEW;
						dto = dto.getClass().newInstance();
						loadViewFromDTO();
						loadEmptyTrackingInfo();
						setControlsEnabled();
						setNewBarState();

					} catch (Exception e) {
					}
				}
			});
		}
		return btnNuevo;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton();
			btnEditar.setToolTipText("Editar");
			btnEditar.setMargin(margins);
			btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEditar.setIcon(new ImageIcon(AbstractABMImpl.class.getResource("edit.png")));
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent pEvent) {
					state = States.EDIT;
					setControlsEnabled();
					setEditBarState();
				}
			});
		}
		return btnEditar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton();
			btnGuardar.setToolTipText("Guardar");
			btnGuardar.setMargin(margins);
			btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnGuardar.setIcon(new ImageIcon(AbstractABMImpl.class.getResource("save.png")));
			btnGuardar.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent pEvent) {
					loadDTOFromView();
					ResultVoidDTO<D> result;
					if (JOptionPane.showConfirmDialog(null,
                            "Desea guardar los cambios?",
                            "Guardar",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (state == States.EDIT) {
							result = services.update((D) dto, requestContext);
						} else {
							result = services.insert((D) dto, requestContext);
						}
						if (result.hasErrors()) {
	                        JOptionPane.showMessageDialog(null,
	                        		                      getErrorMessages(result.getMessages()),
	                        		                      "Errores",
	                        		                      JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
	                                                      getErrorMessages(result.getMessages()),
	                                                      "Operacion Exitosa",
                                                          JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						}
					}

				}
			});
		}
		return btnGuardar;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton();
			btnEliminar.setToolTipText("Eliminar");
			btnEliminar.setMargin(margins);
			btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEliminar.setIcon(new ImageIcon(AbstractABMImpl.class.getResource("trash_can.png")));
			btnEliminar.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent pEvent) {
					if (JOptionPane.showConfirmDialog(null,
                             "Realmente desea eliminar el registro?",
                             "Eliminar",
                             JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ResultVoidDTO<D> result = services.remove((D) dto, requestContext);
						if (result.hasErrors()) {
	                        JOptionPane.showMessageDialog(null,
	                        		                      getErrorMessages(result.getMessages()),
	                        		                      "Errores",
	                        		                      JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
	                                                      getErrorMessages(result.getMessages()),
									                      "Operacion Exitosa",
                                                          JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						}
					}
				}
			});
		}
		return btnEliminar;
	}

	private JButton getBtnDeshacer() {
		if (btnDeshacer == null) {
			btnDeshacer = new JButton("");
			btnDeshacer.setToolTipText("Deshacer");
			btnDeshacer.setMargin(margins);
			btnDeshacer.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnDeshacer.setHorizontalTextPosition(SwingConstants.CENTER);
			btnDeshacer.setIcon(new ImageIcon(AbstractABMImpl.class.getResource("undo.png")));
			btnDeshacer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent pEvent) {
					if (JOptionPane.showConfirmDialog(null,
                        "Realmente desea perder los cambios realizados?",
                        "Deshacer",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

						dto = dtoBackUp;
						if (dto == null) {
							setVisible(false);
						} else {
							state = States.CONSULTANT;
							loadViewFromDTO();
							setControlsReadOny();
							setConsultantBarState();
							loadTrackingInfo();
						}
					}

				}
			});
		}
		return btnDeshacer;
	}


	protected JPanel getNorthPanel() {
		if (northPanel == null) {
			northPanel = new JPanel();
			northPanel.setLayout(new BorderLayout(0, 0));
			northPanel.add(getToolBar());
		}
		return northPanel;
	}

	@Override
	public void open(DTO<K> pDTO, States pStateMode) {

		if (pStateMode.equals(States.EDIT)) {
			this.state = States.EDIT;
			this.dto = pDTO;
			this.dtoBackUp = pDTO;
			setControlsEnabled();
			setEditBarState();
			loadViewFromDTO();
			loadTrackingInfo();

		} else if (pStateMode.equals(States.NEW)) {
			try {
				this.dto = createDTOInstance();
				this.dtoBackUp = null;
				this.state = States.NEW;
				loadViewFromDTO();
				setNewBarState();
				setControlsEnabled();
				loadEmptyTrackingInfo();
			} catch (Exception pException) {
			}
		} else {
			this.dto = pDTO;
			this.dtoBackUp = pDTO;
			setControlsReadOny();
			this.state = States.CONSULTANT;
			setConsultantBarState();
			loadViewFromDTO();
			loadTrackingInfo();
		}

		setVisible(true);
		setLocationRelativeTo(null);
	}

	protected void loadEmptyTrackingInfo() {
		getFldUsuario().setText("--");
		getFldFechaCreacion().setText("--");
		getFldFechaModificacion().setText("--");
		getFldEstado().setText("--");
	}

	protected void loadTrackingInfo() {
		if (dto instanceof TrackingableDTO) {
			trackDto = ((TrackingableDTO) dto).getTrackInfo();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			getFldUsuario().setText(trackDto.getUsuario());


			String fecha = sdf.format(trackDto.getFechaCreacion());
			getFldFechaCreacion().setText(fecha);
			if (trackDto.getFechaModificacion() != null) {
				fecha = sdf.format(trackDto.getFechaModificacion());
				getFldFechaModificacion().setText(fecha);
			} else {
				getFldFechaModificacion().setText("--");
			}

			getFldEstado().setText(trackDto.getEstado());

		} else {
			loadEmptyTrackingInfo();
		}


	}

	private void setNewBarState() {
		this.getBtnNuevo().setEnabled(false);
		this.getBtnEditar().setEnabled(false);
		this.getBtnGuardar().setEnabled(true);
		this.getBtnEliminar().setEnabled(false);
		this.getBtnDeshacer().setEnabled(true);
	}

	private void setConsultantBarState() {
		this.getBtnNuevo().setEnabled(true);
		this.getBtnEditar().setEnabled(true);
		this.getBtnGuardar().setEnabled(false);
		this.getBtnEliminar().setEnabled(true);
		this.getBtnDeshacer().setEnabled(false);
	}

	private void setEditBarState() {
		this.getBtnNuevo().setEnabled(false);
		this.getBtnEditar().setEnabled(false);
		this.getBtnGuardar().setEnabled(true);
		this.getBtnEliminar().setEnabled(false);
		this.getBtnDeshacer().setEnabled(true);
	}

	private String getErrorMessages(List<MessageResult> pMessages) {
		StringBuilder messages = new StringBuilder();
		for (MessageResult messageResult : pMessages) {
			messages.append(messageResult.getMessage());
			messages.append("\n");
		}
		return messages.toString();
	}

	@SuppressWarnings("unchecked")
	protected D createDTOInstance()
    {
        try {
        	Class<D> clazz;

            ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            clazz = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
            return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
    }

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("USUARIO:");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblUsuario.setForeground(Color.GRAY);
		}
		return lblUsuario;
	}
	private JLabel getFldUsuario() {
		if (fldUsuario == null) {
			fldUsuario = new JLabel("vacio");
			fldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
			fldUsuario.setForeground(Color.GRAY);
		}
		return fldUsuario;
	}
	private JLabel getLblFechaCreacion() {
		if (lblFechaCreacion == null) {
			lblFechaCreacion = new JLabel("FECHA CREACIÓN:");
			lblFechaCreacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblFechaCreacion.setForeground(Color.GRAY);
		}
		return lblFechaCreacion;
	}
	private JLabel getFldFechaCreacion() {
		if (fldFechaCreacion == null) {
			fldFechaCreacion = new JLabel("vacio");
			fldFechaCreacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			fldFechaCreacion.setForeground(Color.GRAY);
		}
		return fldFechaCreacion;
	}
	private JLabel getLblFechaModificacion() {
		if (lblFechaModificacion == null) {
			lblFechaModificacion = new JLabel("FECHA MODIFICACIÓN:");
			lblFechaModificacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblFechaModificacion.setForeground(Color.GRAY);
		}
		return lblFechaModificacion;
	}
	private JLabel getFldFechaModificacion() {
		if (fldFechaModificacion == null) {
			fldFechaModificacion = new JLabel("vacio");
			fldFechaModificacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			fldFechaModificacion.setForeground(Color.GRAY);
		}
		return fldFechaModificacion;
	}
	private JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("ESTADO:");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblEstado.setForeground(Color.GRAY);
		}
		return lblEstado;
	}
	private JLabel getFldEstado() {
		if (fldEstado == null) {
			fldEstado = new JLabel("vacio");
			fldEstado.setFont(new Font("Tahoma", Font.PLAIN, 10));
			fldEstado.setForeground(Color.GRAY);
		}
		return fldEstado;
	}

	
} // @jve:decl-index=0:visual-constraint="10,10"
