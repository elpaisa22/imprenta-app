/**
 * appl-frontend-web [10/6/2015 18:40:23]
 */
package org.ambar.appl.frontend.viewbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.dto.ChequeDTO;
import org.ambar.appl.dto.CompraDTO;
import org.ambar.appl.dto.DetallePagoDTO;
import org.ambar.appl.dto.PagoDTO;
import org.ambar.appl.services.BancoServices;
import org.ambar.appl.services.CompraServices;
import org.ambar.core.commons.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * <p>
 * Bean utilizado en el ABM de Pago.
 * </p>
 *
 * @author Sebastian
 *
 */
public class ABMPagoBean implements Serializable {

	private static final long serialVersionUID = -879597802943765141L;

	private CompraServices compraServices;
	private BancoServices bancoServices;

	private RequestContext requestContext;

	private List<DetallePagoDTO> detalleCompras;
    private List<DetallePagoDTO> detalleComprasSelected;

    private List<BancoDTO> listaBancos;
	private ChequeDTO cheque;

	private BigDecimal saldoImporte;

	/**
	 * Constructor.
	 * */
	public ABMPagoBean() {
		this.cheque = new ChequeDTO();
	}

	/**
	 * @return Retorna el valor del atributo compraServices.
	 */
	public CompraServices getCompraServices() {
		return compraServices;
	}

	/**
	 * @param pCompraServices Establece el valor del atributo compraServices.
	 */
	public void setCompraServices(CompraServices pCompraServices) {
		compraServices = pCompraServices;
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
	 * @return Retorna el valor del atributo detalleCompras.
	 */
	public List<DetallePagoDTO> getDetalleCompras() {
		return detalleCompras;
	}

	/**
	 * @param pDetalleCompras Establece el valor del atributo detalleCompras.
	 */
	public void setDetalleCompras(List<DetallePagoDTO> pDetalleCompras) {
		detalleCompras = pDetalleCompras;
	}

	/**
	 * @return Retorna el valor del atributo detalleComprasSelected.
	 */
	public List<DetallePagoDTO> getDetalleComprasSelected() {
		return detalleComprasSelected;
	}

	/**
	 * @param pDetalleComprasSelected Establece el valor del atributo detalleComprasSelected.
	 */
	public void setDetalleComprasSelected(List<DetallePagoDTO> pDetalleComprasSelected) {
		detalleComprasSelected = pDetalleComprasSelected;
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

	public void recalcularTotal(PagoDTO pPagoDTO){
		pPagoDTO.setImporteTotal(BigDecimal.ZERO);
		for (ChequeDTO cheque : pPagoDTO.getColeccionCheques()) {
			pPagoDTO.setImporteTotal(pPagoDTO.getImporteTotal().add(cheque.getMonto()));
		}
		if (pPagoDTO.getMontoEfectivo() != null) {
			pPagoDTO.setImporteTotal(pPagoDTO.getImporteTotal().add(pPagoDTO.getMontoEfectivo()));
		}
		if (pPagoDTO.getMontoTarjetaCredito() != null) {
			pPagoDTO.setImporteTotal(pPagoDTO.getImporteTotal().add(pPagoDTO.getMontoTarjetaCredito()));
		}
		if (pPagoDTO.getMontoTarjetaDebito() != null) {
			pPagoDTO.setImporteTotal(pPagoDTO.getImporteTotal().add(pPagoDTO.getMontoTarjetaDebito()));
		}		
	}

	public void cargarDetallePago(Long pIdProveedor, BigDecimal pMonto) {
		
		List<CompraDTO> compras = this.compraServices
				                        .getComprasPendientesPorProveedor(pIdProveedor,
				                        		                         this.requestContext).getResultList();
		this.detalleCompras = new ArrayList<DetallePagoDTO>();
		this.detalleComprasSelected = new ArrayList<DetallePagoDTO>();
		for (CompraDTO compraDTO : compras) {
			DetallePagoDTO det = new DetallePagoDTO();
			det.setIdCompra(compraDTO.getId());
			det.setFechaCompra(compraDTO.getFecha());
			det.setDescripcionEstadoPagoCompra(compraDTO.getDescripcionEstadoPago());
			det.setSaldoCompra(compraDTO.getSaldo());
			det.setSaldo(compraDTO.getSaldo());
			det.setImporteCompra(compraDTO.getImporteTotal());
			this.detalleCompras.add(det);
		}

		this.saldoImporte = pMonto;
	}

	public void calculoAutomatico(BigDecimal pImporte){
		this.saldoImporte = pImporte;
		this.detalleComprasSelected.clear();
		this.restaurarImportes();
		for (DetallePagoDTO det : this.detalleCompras) {
			if (this.saldoImporte.compareTo(BigDecimal.ZERO) > 0) {
				if (this.saldoImporte.compareTo(det.getSaldoCompra()) > 0) {
					det.setMontoPagado(det.getSaldoCompra());
					det.setSaldo(BigDecimal.ZERO);
					this.saldoImporte = this.saldoImporte.subtract(det.getSaldoCompra());
				} else {
					det.setMontoPagado(this.saldoImporte);
					det.setSaldo(det.getSaldoCompra().subtract(this.saldoImporte));
					this.saldoImporte = BigDecimal.ZERO;
				}
				this.detalleComprasSelected.add(det);
			}
		}
	}


	private void restaurarImportes() {
		for (DetallePagoDTO det : this.detalleCompras) {
			det.setMontoPagado(BigDecimal.ZERO);
			det.setSaldo(det.getSaldoCompra());
		}
	}

	public void montoPagadoChanged(DetallePagoDTO pDet){
		if (this.saldoImporte.subtract(pDet.getMontoPagado()).compareTo(BigDecimal.ZERO) > 0) {
			if (this.saldoImporte.compareTo(pDet.getMontoPagado()) >= 0) {
				this.saldoImporte = this.saldoImporte.subtract(pDet.getMontoPagado());
				if (pDet.getSaldo().compareTo(pDet.getMontoPagado()) <= 0) {
					pDet.setMontoPagado(pDet.getSaldo());
					pDet.setSaldo(BigDecimal.ZERO);
					this.detalleComprasSelected.add(pDet);
				} else {
					BigDecimal dif = pDet.getSaldoCompra().subtract(pDet.getSaldo());
					if (dif.compareTo(pDet.getMontoPagado()) > 0) {
                        this.saldoImporte = this.saldoImporte.add(dif).subtract(pDet.getMontoPagado());
						pDet.setSaldo(pDet.getSaldoCompra().add(pDet.getMontoPagado()));
						if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) == 0) {
							this.detalleComprasSelected.remove(pDet);
						}
					} else {
						pDet.setSaldo(pDet.getSaldo().subtract(pDet.getMontoPagado()));
						this.detalleComprasSelected.add(pDet);
					}
				}
			} else {
				pDet.setMontoPagado(pDet.getSaldoCompra().subtract(pDet.getSaldo()));
			}
		} else if (pDet.getSaldo().compareTo(pDet.getSaldoCompra()) == 0) {
			pDet.setMontoPagado(this.saldoImporte);
			this.saldoImporte = BigDecimal.ZERO;
			pDet.setSaldo(pDet.getSaldoCompra().subtract(pDet.getMontoPagado()));
			if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) != 0) {
				this.detalleComprasSelected.add(pDet);
			}
		} else if (pDet.getMontoPagado().compareTo(BigDecimal.ZERO) != 0) {
			BigDecimal dif = pDet.getSaldoCompra().subtract(pDet.getSaldo());
			if (dif.compareTo(pDet.getMontoPagado()) >= 0) {
				BigDecimal sobrante = dif.subtract(pDet.getMontoPagado());
				this.saldoImporte = sobrante;
				pDet.setSaldo(pDet.getImporteCompra().subtract(pDet.getMontoPagado()));
			} else if (this.saldoImporte.compareTo(BigDecimal.ZERO) != 0) {
				pDet.setMontoPagado(dif.add(this.saldoImporte));
				this.saldoImporte = BigDecimal.ZERO;
				pDet.setSaldo(pDet.getImporteCompra().subtract(pDet.getMontoPagado()));
			} else {
				pDet.setMontoPagado(dif);
			}
		} else if (pDet.getSaldo().compareTo(pDet.getSaldoCompra()) != 0) {
			BigDecimal dif = pDet.getSaldoCompra().subtract(pDet.getSaldo());
			this.saldoImporte = dif;
			pDet.setSaldo(pDet.getSaldoCompra());
			this.detalleComprasSelected.remove(pDet);
		}
	}

	public void onRowSelect(SelectEvent event) {
        DetallePagoDTO elem = ((DetallePagoDTO) event.getObject());
        if (this.saldoImporte.compareTo(BigDecimal.ZERO) > 0) {
        	if (this.saldoImporte.compareTo(elem.getSaldoCompra()) > 0) {
        		elem.setMontoPagado(elem.getSaldoCompra());
        		elem.setSaldo(BigDecimal.ZERO);
				this.saldoImporte = this.saldoImporte.subtract(elem.getSaldoCompra());
            } else {
            	elem.setMontoPagado(this.saldoImporte);
            	elem.setSaldo(elem.getSaldoCompra().subtract(this.saldoImporte));
				this.saldoImporte = BigDecimal.ZERO;
            }
        } else {
        	this.detalleComprasSelected.remove(elem);
        }
    }
 
    public void onRowUnselect(UnselectEvent event) {
    	DetallePagoDTO elem = ((DetallePagoDTO) event.getObject());
    	BigDecimal monto = elem.getMontoPagado();
    	elem.setMontoPagado(BigDecimal.ZERO);
		elem.setSaldo(elem.getSaldo().add(monto));
		this.saldoImporte = this.saldoImporte.add(monto);
    }
}
