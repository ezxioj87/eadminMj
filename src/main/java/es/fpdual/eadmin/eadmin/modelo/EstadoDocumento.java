package es.fpdual.eadmin.eadmin.modelo;

import org.assertj.core.util.Arrays;

public enum EstadoDocumento {
	
	ACTIVO(1), APROBADO(2), ELIMINADO(3);
	
	private final int codigo;
	
	private EstadoDocumento(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
//	public static EstadoDocumento obenenerPorCodigo(Integer codigo) {
//		return Arrays.asList(EstadoDocumento.values()).stream().filter(codigoLista -> codigoLista.getCodigo()).findFirst().orElse(null);
//	}

}
