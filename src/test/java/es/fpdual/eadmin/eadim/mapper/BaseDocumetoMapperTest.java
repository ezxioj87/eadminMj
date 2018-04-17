package es.fpdual.eadmin.eadim.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.*;
import es.fpdual.eadmin.eadmin.util.Utilidades;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumetoMapperTest {
	
	private  Documento doc;
	@Autowired
	private DocumentoMapper mapper;
	
	@Before
	public void voidinicializarEnCadaTest() {
		doc = new Documento(-1,"Documento 1",Utilidades.asDate(LocalDate.of(2015, 1, 1)),
				Utilidades.asDate(LocalDate.of(2015, 1, 2)),true,EstadoDocumento.ACTIVO);
	}
	
	
	
	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		//Decalaracion
		
		//Entrenamiento
		
		//Ejecucion
		final int resultado=mapper.insertarDocumento(doc);
		//Verificacion
		assertThat(resultado,is(1));
		
	}
	
	@Test
	public void deberiaModificarUnDocumento() throws Exception {
		//Decalaracion
		Documento documentoActualizado = new Documento(-1,"documento mod",Utilidades.asDate(LocalDate.of(2015, 2, 1)),
				Utilidades.asDate(LocalDate.of(2015, 2, 2)),true,EstadoDocumento.APROBADO);
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		final int resultado=mapper.modificarDocumento(documentoActualizado);
		//Verificacion
		assertThat(resultado,is(1));
		
		Documento documentoModificado = mapper.selectDocumento(-1);
		
		assertThat(documentoModificado,is(documentoActualizado));
		
	}
	
	
	@Test
	public void deberiaEliminarUnDocumento() throws Exception {
		//Decalaracion
		
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		
		final int resultado=mapper.eliminarDocumento(-1);
		//Verificacion
		assertThat(resultado,is(1));
		
	}
	
	@Test
	public void deberiaSelecionarUnDocumento() throws Exception {
		//Decalaracion
		Documento docume;
		
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		docume = mapper.selectDocumento(-1);
		//Verificacion
		assertThat(docume,is(doc));
	
	}
	
	@Test
	public void deberiaSelecionarTodosLosDocumentos() throws Exception {
		//Decalaracion
		List<Documento> documentos;
		
		//Entrenamiento
		Documento doc1 = new Documento(-2,"documento 2",Utilidades.asDate(LocalDate.of(2015, 2, 1)),
				Utilidades.asDate(LocalDate.of(2015, 2, 2)),true,EstadoDocumento.ACTIVO);
		mapper.insertarDocumento(doc);
		mapper.insertarDocumento(doc1);
		//Ejecucion
		documentos = mapper.selectTodosLosDocumentos();
		//Verificacion
		assertThat(documentos,hasSize(2));
		assertThat(documentos, hasItems(this.doc,doc1));
	
	}
	
	@Test
	public void deberiaSelecionarCodigoMaximo() throws Exception {
		//Decalaracion
		int docume;
		
		//Entrenamiento
		//Ejecucion
		docume = mapper.seleccionarCodigoMaximo();
		//Verificacion
		assertEquals(docume,2);
	
	}
	
	@Test
	public void deberiaSelecionarCodigoSiguiente() throws Exception {
		//Decalaracion
		int docume;
		
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		docume = mapper.seleccionarCodigoMaximo();
		//Verificacion
		assertEquals(docume,0);
	
	}


}
