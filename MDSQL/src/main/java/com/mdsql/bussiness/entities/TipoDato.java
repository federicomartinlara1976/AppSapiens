package com.mdsql.bussiness.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TipoDato implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3830188509430991350L;
	
	private String valor;
}
