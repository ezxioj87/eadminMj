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
		doc = new Documento(1,"Documento 1",Utilidades.asDate(LocalDate.of(2015, 1, 1)),
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
		Documento documentoActualizado = new Documento(1,"documento mod",Utilidades.asDate(LocalDate.of(2015, 2, 1)),
				Utilidades.asDate(LocalDate.of(2015, 2, 2)),true,EstadoDocumento.APROBADO);
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		final int resultado=mapper.modificarDocumento(doc);
		//Verificacion
		assertThat(documentoActualizado,is(doc));
		
	}
	
	
	@Test
	public void deberiaEliminarUnDocumento() throws Exception {
		//Decalaracion
		
		//Entrenamiento
		mapper.insertarDocumento(doc);
		//Ejecucion
		
		final int resultado=mapper.eliminarDocumento(1);
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
		docume = mapper.selectDocumento(1);
		//Verificacion
		assertThat(docume,is(doc));
	
	}

}
