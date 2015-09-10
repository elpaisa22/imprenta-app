/**
 * 
 */
package org.ambar.appl.views.entities.crud.impl;


import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import org.ambar.appl.be.Cliente;
import org.ambar.appl.dto.ClienteDTO;
import org.ambar.core.views.crud.impl.AbstractABMImpl;

/**
 * @author Sebastian
 *
 */
public class ClienteABMImpl extends AbstractABMImpl<Long, ClienteDTO, Long, Cliente> {


	@Override
	protected String getWindowTitle(){
		return "Cliente";
	}
	
	protected Image getWindowIcon() {
		return new Image(this.getClass().getResourceAsStream("/images/business_users_16.png"));
	}

	@Override
	protected ClienteDTO crearNuevoDTO() {
		return new ClienteDTO();
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

	@Override
	protected void cargarComponentesABM(BorderPane pCenterPane) {
		// TODO Auto-generated method stub
		
	}
}
