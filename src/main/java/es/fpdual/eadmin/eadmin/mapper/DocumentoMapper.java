package es.fpdual.eadmin.eadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {
	
	int insertarDocumento(@Param("documento") Documento documento);
	
	int eliminarDocumento(@Param("codigo") int codigo);
	
	int modificarDocumento(@Param("documento") Documento documento);
	
	Documento selectDocumento(@Param("codigo")int codigo );
	
	List<Documento> selectTodosLosDocumentos();
	
	int seleccionarCodigoMaximo();

}
