package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public abstract class DocumentoTest extends AbstractoModeloBeanTest<Documento>{
	
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	
	private Documento documento;
	
	@Before
	public void inicializarCadaTest() {
		this.entityA1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO,
				FECHA_CREACION, FECHA_ULTIMA_MODIFICACION, DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO);
		this.entityA2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO,
				FECHA_CREACION, FECHA_ULTIMA_MODIFICACION, DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO);
		this.entityB = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
				FECHA_ULTIMA_MODIFICACION, false,EstadoDocumento.APROBADO);
	}
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(EstadoDocumento.ACTIVO, documento.getEstado());
	}
	
}
