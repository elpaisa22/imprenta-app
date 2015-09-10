package org.ambar.appl.frontend.controllers.restservices;

import java.util.List;

import org.ambar.appl.dto.ClienteDTO;
import org.ambar.appl.services.ClienteServices;
import org.ambar.core.commons.context.RequestContext;
import org.ambar.core.dto.results.ResultVoidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/clientes/")
public class ClienteServiceController {

	@Autowired
	private RequestContext requestContext;
 
	@Autowired
	private ClienteServices clienteService;
	           
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ClienteDTO getById(@PathVariable long id) {
		ClienteDTO cliente = clienteService.getById(id, this.requestContext).getResult();
		return cliente;
	}
	 
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ClienteDTO> getAll() {
		List<ClienteDTO> clientes = clienteService.getFilteredList(null, this.requestContext).getResultList();
		return clientes;
	}
 
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody ResultVoidDTO<ClienteDTO> insert(@RequestBody ClienteDTO pCliente) {
	    return clienteService.insert(pCliente, this.requestContext);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public @ResponseBody ResultVoidDTO<ClienteDTO> update(@RequestBody ClienteDTO pCliente) {
	    return clienteService.update(pCliente, this.requestContext);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResultVoidDTO<ClienteDTO> remove(@PathVariable long id) {
		ClienteDTO cliente = this.clienteService.getById(id, this.requestContext).getResult();
		return clienteService.remove(cliente, this.requestContext);
	}
 
}
