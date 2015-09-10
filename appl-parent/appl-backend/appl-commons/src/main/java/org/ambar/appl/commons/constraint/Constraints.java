/**
 * appl-commons [28/02/2012 21:39:54]
 */
package org.ambar.appl.commons.constraint;

import java.math.BigDecimal;

/**
 * <p>
 * Constantes a ser utilizadas en la configuración de entidades de negocio y tests.
 * </p>
 *
 * @author Sebastian
 *
 *
 */
public final class Constraints {

	/**
	 * Cantidad maxima de 2 dígitos de precision en un importe.
	 */
	public static final int IMP2_FRAC_MAX = 2;
	/**
	 * Cantidad maxima de 7 digitos de precision en un importe.
	 */
	public static final int IMP7_FRAC_MAX = 7;
	/**
	 * Cantidad maxima de 10 dígitos enteros en un importe.
	 */
	public static final int IMP10_INT_MAX = 10;
	/**
	 * Cantidad maxima de 17 dígitos enteros en un importe.
	 */
	public static final int IMP17_INT_MAX = 17;
	/**
	 * Cantidad maxima de 19 dígitos enteros en un importe.
	 */
	public static final int IMP19_INT_MAX = 19;
	/**
	 * Cantidad maxima de 1 digitos enteros.
	 */
	public static final int INT1_DIGITS_MAX = 1;
	/**
	 * Cantidad maxima de 2 digitos enteros.
	 */
	public static final int INT2_DIGITS_MAX = 2;
	/**
	 * Cantidad maxima de 3 digitos enteros.
	 */
	public static final int INT3_DIGITS_MAX = 3;
	/**
	 * Cantidad maxima de 4 digitos enteros.
	 */
	public static final int INT4_DIGITS_MAX = 4;
	/**
	 * Cantidad maxima de 5 digitos enteros.
	 */
	public static final int INT5_DIGITS_MAX = 5;
	/**
	 * Cantidad maxima de 6 digitos enteros.
	 */
	public static final int INT6_DIGITS_MAX = 6;
	/**
	 * Cantidad maxima de 7 digitos enteros.
	 */
	public static final int INT7_DIGITS_MAX = 7;
	/**
	 * Cantidad maxima de 10 digitos enteros.
	 */
	public static final int INT10_DIGITS_MAX = 10;
	/**
	 * Cantidad maxima de 11 digitos enteros.
	 */
	public static final int INT11_DIGITS_MAX = 11;
	/**
	 * Cantidad maxima de 12 digitos enteros.
	 */
	public static final int INT12_DIGITS_MAX = 12;
	/**
	 * Cantidad maxima de 14 digitos enteros.
	 */
	public static final int INT14_DIGITS_MAX = 14;
	/**
	 * Cantidad maxima de 15 digitos enteros.
	 */
	public static final int INT15_DIGITS_MAX = 15;
	/**
	 * Cantidad maxima de 16 digitos enteros.
	 */
	public static final int INT16_DIGITS_MAX = 16;
	/**
	 * Cantidad maxima de 17 digitos enteros.
	 */
	public static final int INT17_DIGITS_MAX = 17;
	/**
	 * Cantidad maxima de 18 digitos enteros.
	 */
	public static final int INT18_DIGITS_MAX = 18;
	/**
	 * Cantidad maxima de 19 digitos enteros.
	 */
	public static final int INT19_DIGITS_MAX = 19;
	/**
	 * Milisegundos al dia.<br><br>
	 * <i>Resulta de: 24 horas * 60 minutos * 60 segundos * 1000 milisegundos = 86400000</i>
	 */
	public static final long MILLSECS_PER_DAY = 86400000;
	/**
	 * Cantidad maxima de 2 digitos de precision en un porcentaje.
	 */
	public static final int POR2_FRACTION_MAX = 2;
	/**
	 * Cantidad maxima de 6 digitos de precision en un porcentaje.
	 */
	public static final int POR_FRACTION_MAX = 6;
	/**
	 * Cantidad maxima de 7 digitos de precision en un porcentaje.
	 */
	public static final int POR7_FRACTION_MAX = 7;
	/**
	 * Cantidad maxima de 6 digitos enteros en un porcentaje.
	 */
	public static final int POR_INT_MAX = 6;
	/**
	 * Cantidad maxima de 10 digitos enteros en un porcentaje.
	 */
	public static final int POR10_INT_MAX = 10;
	/**
	 * Precision de 10 decimales al dividir.
	 */
	public static final int PRECISION_DIVIDE10 = 10;
	/**
	 * Cantidad maxima de 1 caracteres en un String.
	 */
	public static final int STRING1_SIZE_MAX = 1;
	/**
	 * Cantidad maxima de 2 caracteres en un String.
	 */
	public static final int STRING2_SIZE_MAX = 2;
	/**
	 * Cantidad maxima de 3 caracteres en un String.
	 */
	public static final int STRING3_SIZE_MAX = 3;
	/**
	 * Cantidad maxima de 4 caracteres en un String.
	 */
	public static final int STRING4_SIZE_MAX = 4;
	/**
	 * Cantidad maxima de 5 caracteres en un String.
	 */
	public static final int STRING5_SIZE_MAX = 5;
	/**
	 * Cantidad maxima de 6 caracteres en un String.
	 */
	public static final int STRING6_SIZE_MAX = 6;
	/**
	 * Cantidad maxima de 9 caracteres en un String.
	 */
	public static final int STRING9_SIZE_MAX = 9;
	/**
	 * Cantidad maxima de 10 caracteres en un String.
	 */
	public static final int STRING10_SIZE_MAX = 10;
	/**
	 * Cantidad maxima de 12 caracteres en un String.
	 */
	public static final int STRING12_SIZE_MAX = 12;
	/**
	 * Cantidad maxima de 14 caracteres en un String.
	 */
	public static final int STRING14_SIZE_MAX = 14;
	/**
	 * Cantidad maxima de 15 caracteres en un String.
	 */
	public static final int STRING15_SIZE_MAX = 15;
	/**
	 * Cantidad maxima de 18 caracteres en un String.
	 */
	public static final int STRING18_SIZE_MAX = 18;
	/**
	 * Cantidad maxima de 20 caracteres en un String.
	 */
	public static final int STRING20_SIZE_MAX = 20;
	/**
	 * Cantidad maxima de 22 caracteres en un String.
	 */
	public static final int STRING22_SIZE_MAX = 22;
	/**
	 * Cantidad maxima de 24 caracteres en un String.
	 */
	public static final int STRING24_SIZE_MAX = 24;
	/**
	 * Cantidad maxima de 30 caracteres en un String.
	 */
	public static final int STRING30_SIZE_MAX = 30;
	/**
	 * Cantidad maxima de 40 caracteres en un String.
	 */
	public static final int STRING40_SIZE_MAX = 40;
	/**
	 * Cantidad maxima de 60 caracteres en un String.
	 */
	public static final int STRING60_SIZE_MAX = 60;
	/**
	 * Cantidad maxima de 80 caracteres en un String.
	 */
	public static final int STRING80_SIZE_MAX = 80;
	/**
	 * Cantidad maxima de 255 caracteres en un String.
	 */
	public static final int STRING255_SIZE_MAX = 255;
	/**
	 * Int que representa el porcentaje 100%.
	 */
	public static final int PORCENTAJE_100 = 100;
	/**
	 * BigDecimal que representa el porcentaje 100%.
	 */
	public static final BigDecimal PORCENTAJE_100_BD = new BigDecimal(PORCENTAJE_100);

	/**
	 * Constructor por default.
	 */
	private Constraints() {
	}
}
