/**
 * 
 */
package org.ambar.appl.views.entities.crud.impl;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import org.ambar.appl.be.OrdenTrabajo;
import org.ambar.appl.dto.OrdenTrabajoDTO;
import org.ambar.core.views.crud.components.lookup.LookUp;
import org.ambar.core.views.crud.impl.AbstractABMImpl;

/**
 * @author Sebastian
 *
 */
public class OrdenTrabajoABMImpl extends AbstractABMImpl<Long, OrdenTrabajoDTO, Long, OrdenTrabajo> {

	@Override
	protected String getWindowTitle() {
		return "Orden de Trabajo";
	}

	@Override
	protected Image getWindowIcon() {
		return new Image(this.getClass().getResourceAsStream("/images/note_16.png"));
	}

	@Override
	protected OrdenTrabajoDTO crearNuevoDTO() {
		return new OrdenTrabajoDTO();
	}

	@Override
	protected void cargarComponentesABM(BorderPane pCenterPane) {

		LookUp lookUpCliente = new LookUp("lkp_cliente");
		Label lblRazonSocialCliente = new Label();
		lookUpCliente.setDescriptionField(lblRazonSocialCliente);

		pCenterPane.getChildren().add(lookUpCliente);
		pCenterPane.getChildren().add(lblRazonSocialCliente);

	}

	@Override
	protected void setearControlesModoConsulta() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setearControlesModoEdicion() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void asignarVistaDesdeObjeto() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void asignarObjetoDesdeVista() {
		// TODO Auto-generated method stub
	}

}
