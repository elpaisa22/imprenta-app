/**
 * appl-frontend-web [24/06/2012 13:59:33]
 */
package org.ambar.appl.frontend.helpers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ambar.core.dto.results.MessageKind;
import org.ambar.core.dto.results.MessageResult;

/**
 * <p>
 * Helper para agregar mensajes en las vistas de front-end.
 * </p>
 *
 * @author Sebastian
 */
public class MessageHelper {

	public void addErrorMessages(List<MessageResult> pMessages) {
		for (MessageResult message : pMessages) {
			if (message.getKind().equals(MessageKind.Error)) {
				FacesMessage facesMessage = new FacesMessage();
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				facesMessage.setDetail(message.getMessage());
				facesMessage.setSummary(message.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			} else if (message.getKind().equals(MessageKind.Info)) {
				FacesMessage facesMessage = new FacesMessage();
				facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
				facesMessage.setDetail(message.getMessage());
				facesMessage.setSummary(message.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			} else if (message.getKind().equals(MessageKind.Warning)) {
				FacesMessage facesMessage = new FacesMessage();
				facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
				facesMessage.setDetail(message.getMessage());
				facesMessage.setSummary(message.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
		}
	}

	public void addErrorMessages(String message) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		facesMessage.setDetail(message);
		facesMessage.setSummary(message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void addInfoMessages(String message) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		facesMessage.setDetail(message);
		facesMessage.setSummary(message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void addWarningMessages(String message) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		facesMessage.setDetail(message);
		facesMessage.setSummary(message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}
