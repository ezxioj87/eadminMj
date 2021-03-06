package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	
	private DocumentoMapper mapper ;
	
	@Autowired
	public RepositorioDocumentoImpl(DocumentoMapper mapper) {
		this.mapper = mapper;
	}

	
	
	@Override
	public void altaDocumento(Documento documento) {
		this.mapper.insertarDocumento(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		this.mapper.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
	
		
		this.mapper.eliminarDocumento(codigo);
		
		
	}
	
	
	



}


