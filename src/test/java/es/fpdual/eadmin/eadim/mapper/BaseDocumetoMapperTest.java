package es.fpdual.eadmin.eadim.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.*;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.*;


public abstract class BaseDocumetoMapperTest {
	
	private  Documento doc;
	@Autowired
	private DocumentoMapper mapper;
	
	@Before
	public void voidinicializarEnCadaTest() {
		doc = new Documento(1,"Documento 1",new Date(),new Date(),true,EstadoDocumento.ACTIVO);
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

}
