/**
 * application-dto [15/6/2015 16:37:45]
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
 * entidad {@link org.ambar.appl.be.CuentaCorriente}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class CuentaCorrienteProveedorDTO implements DTO<Long>, TrackingableDTO, VersionableDTO {

	private static final long serialVersionUID = -6574079586472606013L;

	private Long id;
	private Long idProveedor;
	private String razonSocialProveedor;
	private String cuitProveedor;

	private BigDecimal saldo;

	private List<MovimientoCuentaCorrienteProveedorDTO> coleccionMovimientos;

	private TrackInfoDTO trackInfo;
	private int version;

	/**
	 * Constructor default.
	 * */
	public CuentaCorrienteProveedorDTO() {
		this.coleccionMovimientos = new ArrayList<MovimientoCuentaCorrienteProveedorDTO>();
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
	 * @return Retorna el valor del atributo idProveedor.
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param pIdProveedor Establece el valor del atributo idProveedor.
	 */
	public void setIdProveedor(Long pIdProveedor) {
		idProveedor = pIdProveedor;
	}

	/**
	 * @return Retorna el valor del atributo razonSocialProveedor.
	 */
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	/**
	 * @param pRazonSocialProveedor Establece el valor del atributo razonSocialProveedor.
	 */
	public void setRazonSocialProveedor(String pRazonSocialProveedor) {
		razonSocialProveedor = pRazonSocialProveedor;
	}

	/**
	 * @return Retorna el valor del atributo cuitProveedor.
	 */
	public String getCuitProveedor() {
		return cuitProveedor;
	}

	/**
	 * @param pCuitProveedor Establece el valor del atributo cuitProveedor.
	 */
	public void setCuitProveedor(String pCuitProveedor) {
		cuitProveedor = pCuitProveedor;
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
	 * @return Retorna el valor del atributo coleccionMovimientos.
	 */
	public List<MovimientoCuentaCorrienteProveedorDTO> getColeccionMovimientos() {
		return coleccionMovimientos;
	}

	/**
	 * @param pColeccionMovimientos Establece el valor del atributo coleccionMovimientos.
	 */
	public void setColeccionMovimientos(List<MovimientoCuentaCorrienteProveedorDTO> pColeccionMovimientos) {
		coleccionMovimientos = pColeccionMovimientos;
	}

	/**
	 * Agrega una Movimiento.
	 * @param pElement Movimiento a agregar
	 */
	public void agregarMovimiento(final MovimientoCuentaCorrienteProveedorDTO pElement) {
		this.coleccionMovimientos.add(pElement);
		pElement.setIdCuentaCorriente(this.getId());
	}

	/**
	 * Remueve una Movimiento.
	 * @param pElement Movimiento a remover
	 */
	public void removerMovimiento(final MovimientoCuentaCorrienteProveedorDTO pElement) {
		this.coleccionMovimientos.remove(pElement);
		pElement.setIdCuentaCorriente(null);
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
		result = prime * result + ((this.idProveedor == null) ? 0 : this.idProveedor.hashCode());
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
		if (!(pObj instanceof CuentaCorrienteProveedorDTO)) {
			return false;
		}
		CuentaCorrienteProveedorDTO other = (CuentaCorrienteProveedorDTO) pObj;
		if (this.idProveedor == null) {
			if (other.idProveedor != null) {
				return false;
			}
		} else if (!this.idProveedor.equals(other.idProveedor)) {
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
		builder.append("CuentaCorrienteProveedorDTO [id=");
		builder.append(this.id);
		builder.append(", idProveedor=");
		builder.append(this.idProveedor);
		builder.append(", razonSocialProveedor=");
		builder.append(this.razonSocialProveedor);

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
