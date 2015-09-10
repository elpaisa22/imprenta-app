/**
 * appl-frontend-web [6/11/2014 20:14:41]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.dto.ChequeDTO;
import org.ambar.appl.dto.CobranzaDTO;
import org.ambar.appl.dto.DetalleCobranzaDTO;
import org.ambar.appl.dto.FacturaDTO;
import org.ambar.appl.services.BancoServices;
import org.ambar.appl.services.FacturaServices;
import org.ambar.core.commons.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * <p>
 * Bean utilizado en el ABM de Cobranza.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMCobranzaBean implements Serializable {

	private static final long serialVersionUID = 5282687053223315227L;

	private FacturaServices facturaServices;
	private BancoServices bancoServices;

	private RequestContext requestContext;

	private List<DetalleCobranzaDTO> detalleFacturas;
    private List<DetalleCobranzaDTO> detalleFacturasSelected;

    private List<BancoDTO> listaBancos;
	private ChequeDTO cheque;

	private BigDecimal saldoImporte;

	/**
	 * Constructor default.
	 * */
	public ABMCobranzaBean() {
		this.cheque = new ChequeDTO();
	}

	/**
	 * @return Retorna el valor del atributo facturaServices.
	 */
	public FacturaServices getFacturaServices() {
		return facturaServices;
	}

	/**
	 * @param pFacturaServices Establece el valor del atributo facturaServices.
	 */
	public void setFacturaServices(FacturaServices pFacturaServices) {
		facturaServices = pFacturaServices;
	}

	/**
	 * @return Retorna el valor del atributo bancoServices.
	 */
	public BancoServices getBancoServices() {
		return bancoServices;
	}

	/**
	 * @param pBancoServices Establece el valor del atributo bancoServices.
	 */
	public void setBancoServices(BancoServices pBancoServices) {
		bancoServices = pBancoServices;
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
	 * @return Retorna el valor del atributo detalleFacturas.
	 */
	public List<DetalleCobranzaDTO> getDetalleFacturas() {
		return detalleFacturas;
	}

	/**
	 * @param pDetalleFacturas Establece el valor del atributo detalleFacturas.
	 */
	public void setDetalleFacturas(List<DetalleCobranzaDTO> pDetalleFacturas) {
		detalleFacturas = pDetalleFacturas;
	}

	/**
	 * @return Retorna el valor del atributo detalleFacturasSelected.
	 */
	public List<DetalleCobranzaDTO> getDetalleFacturasSelected() {
		return detalleFacturasSelected;
	}

	/**
	 * @param pDetalleFacturasSelected Establece el valor del atributo detalleFacturasSelected.
	 */
	public void setDetalleFacturasSelected(List<DetalleCobranzaDTO> pDetalleFacturasSelected) {
		detalleFacturasSelected = pDetalleFacturasSelected;
	}

	/**
	 * @return Retorna el valor del atributo listaBancos.
	 */
	public List<BancoDTO> getListaBancos() {
		return listaBancos;
	}

	/**
	 * @param pListaBancos Establece el valor del atributo listaBancos.
	 */
	public void setListaBancos(List<BancoDTO> pListaBancos) {
		listaBancos = pListaBancos;
	}

	/**
	 * @return Retorna el valor del atributo cheque.
	 */
	public ChequeDTO getCheque() {
		return cheque;
	}

	/**
	 * @param pCheque Establece el valor del atributo cheque.
	 */
	public void setCheque(ChequeDTO pCheque) {
		cheque = pCheque;
	}

	/**
	 * @return Retorna el valor del atributo saldoImporte.
	 */
	public BigDecimal getSaldoImporte() {
		return saldoImporte;
	}

	/**
	 * @param pSaldoImporte Establece el valor del atributo saldoImporte.
	 */
	public void setSaldoImporte(BigDecimal pSaldoImporte) {
		saldoImporte = pSaldoImporte;
	}

	/**
	 * Inicializa el bean.
	 * */
	public void init() {
		this.listaBancos = this.bancoServices.getFilteredList(null, this.requestContext).getResultList();
	}

	/**
	 * Crea un cheque.
	 * */
	public void crearCheque() {
		this.cheque = new ChequeDTO();
	}

	public void recalcularTotal(CobranzaDTO pCobranzaDTO){
		pCobranzaDTO.setImporteTotal(BigDecimal.ZERO);
		for (ChequeDTO cheque : pCobranzaDTO.getColeccionCheques()) {
			pCobranzaDTO.setImporteTotal(pCobranzaDTO.getImporteTotal().add(cheque.getMonto()));
		}
		if (pCobranzaDTO.getMontoEfectivo() != null) {
			pCobranzaDTO.setImporteTotal(pCobranzaDTO.getImporteTotal().add(pCobranzaDTO.getMontoEfectivo()));
		}
		if (pCobranzaDTO.getMontoTarjetaCredito() != null) {
			pCobranzaDTO.setImporteTotal(pCobranzaDTO.getImporteTotal().add(pCobranzaDTO.getMontoTarjetaCredito()));
		}
		if (pCobranzaDTO.getMontoTarjetaDebito() != null) {
			pCobranzaDTO.setImporteTotal(pCobranzaDTO.getImporteTotal().add(pCobranzaDTO.getMontoTarjetaDebito()));
		}		
	}

	public void cargarDetalleCobranza(Long pIdCliente, BigDecimal pMonto) {
		
		List<FacturaDTO> facturas = this.facturaServices
				                        .getFacturasPendientesPorCliente(pIdCliente,
				                        		                         this.requestContext).getResultList();
		this.detalleFacturas = new ArrayList<DetalleCobranzaDTO>();
		this.detalleFacturasSelected = new ArrayList<DetalleCobranzaDTO>();
		for (FacturaDTO facturaDTO : facturas) {
			DetalleCobranzaDTO det = new DetalleCobranzaDTO();
			det.setIdFactura(facturaDTO.getId());
			det.setFechaEmisionFactura(facturaDTO.getFechaEmision());
			det.setDescripcionEstadoPagoFactura(facturaDTO.getDescripcionEstadoPago());
			det.setSaldoFactura(facturaDTO.getSaldo());
			det.setSaldo(facturaDTO.getSaldo());
			det.setImporteFactura(facturaDTO.getImporteTotal());
			this.detalleFacturas.add(det);
		}

		this.saldoImporte = pMonto;
	}

	public void calculoAutomatico(BigDecimal pImporte){
		this.saldoImporte = pImporte;
		this.detalleFacturasSelected.clear();
		this.restaurarImportes();
		for (DetalleCobranzaDTO det : this.detalleFacturas) {
			if (this.saldoImporte.compareTo(BigDecimal.ZERO) > 0) {
				if (this.saldoImporte.compareTo(det.getSaldoFactura()) > 0) {
					det.setMontoPagado(det.getSaldoFactura());
					det.setSaldo(BigDecimal.ZERO);
					this.saldoImporte = this.saldoImporte.subtract(det.getSaldoFactura());
				} else {
					det.setMontoPagado(this.saldoImporte);
					det.setSaldo(det.getSaldoFactura().subtract(this.saldoImporte));
					this.saldoImporte = BigDecimal.ZERO;
				}
				this.detalleFacturasSelected.add(det);
			}
		}
	}


	private void restaurarImportes() {
		for (DetalleCobranzaDTO det : this.detalleFacturas) {
			det.setMontoPagado(BigDecimal.ZERO);
			det.setSaldo(det.getSaldoFactura());
		}
	}

	public void montoPagadoChanged(DetalleCobranzaDTO pDet){
		if (this.saldoImporte.subtract(pDet.getMontoPagado()).compareTo(BigDecimal.ZERO) > 0) {
			if (this.saldoImporte.compareTo(pDet.getMontoPagado()) >= 0) {
				this.saldoImporte = this.saldoImporte.subtract(pDet.getMontoPagado());
				if (pDet.getSaldo().compareTo(pDet.getMontoPagado()) <= 0) {
					pDet.setMontoPagado(pDet.getSaldo());
					pDet.setSaldo(BigDecimal.ZERO);
					this.detalleFacturasSelected.add(pDet);
				} else {
					BigDecimal dif = pDet.getSaldoFactura().subtract(pDet.getSaldo());
					if (dif.compareTo(pDet.getMontoPagado()) > 0) {
                        this.saldoImporte = this.saldoImporte.add(dif).subtract(pDet.getMontoPagado());
						pDet.setSaldo(pDet.getSaldoFactura().add(pDet.getMontoPagado()));
						if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) == 0) {
							this.detalleFacturasSelected.remove(pDet);
						}
					} else {
						pDet.setSaldo(pDet.getSaldo().subtract(pDet.getMontoPagado()));
						this.detalleFacturasSelected.add(pDet);
					}
				}
			} else {
				pDet.setMontoPagado(pDet.getSaldoFactura().subtract(pDet.getSaldo()));
			}
		} else if (pDet.getSaldo().compareTo(pDet.getSaldoFactura()) == 0) {
			pDet.setMontoPagado(this.saldoImporte);
			this.saldoImporte = BigDecimal.ZERO;
			pDet.setSaldo(pDet.getSaldoFactura().subtract(pDet.getMontoPagado()));
			if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) != 0) {
				this.detalleFacturasSelected.add(pDet);
			}
		} else if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) != 0) {
			BigDecimal dif = pDet.getSaldoFactura().subtract(pDet.getSaldo());
			if (dif.compareTo(pDet.getMontoPagado()) >= 0) {
				BigDecimal sobrante = dif.subtract(pDet.getMontoPagado());
				this.saldoImporte = sobrante;
				pDet.setSaldo(pDet.getImporteFactura().subtract(pDet.getMontoPagado()));
			} else if (this.saldoImporte.compareTo(BigDecimal.ZERO) != 0) {
				pDet.setMontoPagado(dif.add(this.saldoImporte));
				this.saldoImporte = BigDecimal.ZERO;
				pDet.setSaldo(pDet.getImporteFactura().subtract(pDet.getMontoPagado()));
			} else {
				pDet.setMontoPagado(dif);
			}
		} else if (pDet.getSaldo().compareTo(pDet.getSaldoFactura()) != 0) {
			BigDecimal dif = pDet.getSaldoFactura().subtract(pDet.getSaldo());
			this.saldoImporte = dif;
			pDet.setSaldo(pDet.getSaldoFactura());
			this.detalleFacturasSelected.remove(pDet);
		}
	}

	public void onRowSelect(SelectEvent event) {
        DetalleCobranzaDTO elem = ((DetalleCobranzaDTO) event.getObject());
        if (this.saldoImporte.compareTo(BigDecimal.ZERO) > 0) {
        	if (this.saldoImporte.compareTo(elem.getSaldoFactura()) > 0) {
        		elem.setMontoPagado(elem.getSaldoFactura());
        		elem.setSaldo(BigDecimal.ZERO);
				this.saldoImporte = this.saldoImporte.subtract(elem.getSaldoFactura());
            } else {
            	elem.setMontoPagado(this.saldoImporte);
            	elem.setSaldo(elem.getSaldoFactura().subtract(this.saldoImporte));
				this.saldoImporte = BigDecimal.ZERO;
            }
        } else {
        	this.detalleFacturasSelected.remove(elem);
        }
    }
 
    public void onRowUnselect(UnselectEvent event) {
    	DetalleCobranzaDTO elem = ((DetalleCobranzaDTO) event.getObject());
    	BigDecimal monto = elem.getMontoPagado();
    	elem.setMontoPagado(BigDecimal.ZERO);
		elem.setSaldo(elem.getSaldo().add(monto));
		this.saldoImporte = this.saldoImporte.add(monto);
    }
}
