/**
 * application-services-impl [23/05/2015 14:23:28]
 */
package org.ambar.appl.mappers.impl;

import org.ambar.appl.be.Banco;
import org.ambar.appl.dto.BancoDTO;
import org.ambar.appl.mappers.BancoMapper;
import org.ambar.core.mappers.EntityMapperImpl;

/**
 * <p>
 * Implementación por default de {@link BancoMapper}.
 * </p>
 *
 * @author Sebastian
 *
 */
public class BancoMapperImpl
       extends EntityMapperImpl<Banco, BancoDTO>
       implements BancoMapper {
}
