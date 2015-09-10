/**
 * application-dto [2/7/2015 16:13:54]
 */
package org.ambar.appl.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ambar.core.dto.DTO;
import org.ambar.core.dto.TrackInfoDTO;
import org.ambar.core.dto.TrackingableDTO;
import org.ambar.core.dto.VersionableDTO;

/**
 * <p>
 * DTO a ser usado en las transacciones CRUD correspondiente a la
 * entidad {@link org.ambar.appl.be.CuentaBancaria}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CuentaBancariaDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -5965084642116374480L;

	private Long id;

	private BigDecimal saldo;
	private String idBanco;
	private String descripcionBanco;
	private String sucursal;

	private List<MovimientoCuentaBancariaDTO> coleccionMovimientos;

	private TrackInfoDTO trackInfo;
	private int version;


	/**
	 * Constructor default.
	 * */
	public CuentaBancariaDTO() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaBancariaDTO>();
		this.saldo = BigDecimal.ZERO;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.DTO#setId(java.lang.Object)
	 */
	@Override
	public void setId(Long pId) {
		this.id = pId;
	}

	/**
	 * @return Retorna el valor del atributo saldo.
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param pSaldo Establece el valor del atributo saldo.
	 */
	public void setSaldo(BigDecimal pSaldo) {
		saldo = pSaldo;
	}

	/**
	 * @return Retorna el valor del atributo idBanco.
	 */
	public String getIdBanco() {
		return idBanco;
	}

	/**
	 * @param pIdBanco Establece el valor del atributo idBanco.
	 */
	public void setIdBanco(String pIdBanco) {
		idBanco = pIdBanco;
	}

	/**
	 * @return Retorna el valor del atributo descripcionBanco.
	 */
	public String getDescripcionBanco() {
		return descripcionBanco;
	}

	/**
	 * @param pDescripcionBanco Establece el valor del atributo descripcionBanco.
	 */
	public void setDescripcionBanco(String pDescripcionBanco) {
		descripcionBanco = pDescripcionBanco;
	}

	/**
	 * @return Retorna el valor del atributo sucursal.
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param pSucursal Establece el valor del atributo sucursal.
	 */
	public void setSucursal(String pSucursal) {
		sucursal = pSucursal;
	}

	/**
	 * @return Retorna el valor del atributo coleccionMovimientos.
	 */
	public List<MovimientoCuentaBancariaDTO> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaBancariaDTO> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaBancariaDTO pElement) {
		this.coleccionMovimientos.add(pElement);
		pElement.setIdCuentaBancaria(this.getId());
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaBancariaDTO pElement) {
		this.coleccionMovimientos.remove(pElement);
		pElement.setIdCuentaBancaria(null);
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#getTrackInfo()
	 */
	@Override
	public TrackInfoDTO getTrackInfo() {
		return this.trackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.TrackingableDTO#setTrackInfo(org.ambar.core.dto.TrackInfoDTO)
	 */
	@Override
	public void setTrackInfo(TrackInfoDTO pTrackInfo) {
		this.trackInfo = pTrackInfo;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#getVersion()
	 */
	@Override
	public int getVersion() {
		return this.version;
	}

	/* (non-JSDoc)
	 * @see org.ambar.core.dto.VersionableDTO#setVersion(int)
	 */
	@Override
	public void setVersion(int pVersion) {
		this.version = pVersion;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object pObj) {
		if (this == pObj) {
			return true;
		}
		if (pObj == null) {
			return false;
		}
		if (!(pObj instanceof CuentaBancariaDTO)) {
			return false;
		}
		CuentaBancariaDTO other = (CuentaBancariaDTO) pObj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/* (non-JSDoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CuentaBancariaDTO [id=");
		builder.append(this.id);

		builder.append(", saldo=");
		builder.append(this.saldo);
		builder.append(", trackInfo=");
		builder.append(this.trackInfo);
		builder.append(", version=");
		builder.append(this.version);
		builder.append("]");
		return builder.toString();
	}
}
