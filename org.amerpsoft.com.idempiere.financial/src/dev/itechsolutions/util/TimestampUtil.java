package dev.itechsolutions.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class TimestampUtil {
	
	/**
	 * @author Argenis Rodríguez
	 * @return
	 */
	public static Timestamp now() {
		return Timestamp.valueOf(LocalDateTime.now());
	}
}
