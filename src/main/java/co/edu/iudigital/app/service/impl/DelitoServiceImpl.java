package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.repository.IDelitoRepository;
import co.edu.iudigital.app.service.iface.IDelitoService;


@Service
public class DelitoServiceImpl implements IDelitoService{
	
	@Autowired
	private IDelitoRepository delitoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<DelitoDto> findAll() {
		List<Delito> delitos = delitoRepository.findAll();
		List<DelitoDto> delitosDto = new ArrayList<>();
		
		for(Delito delito : delitos) {
			
			DelitoDto delitoDto = new DelitoDto();
			delitoDto.setId(delito.getId());
			delitoDto.setNombre(delito.getNombre());
			delitoDto.setDescripcion(delito.getDescripcion());
			delitosDto.add(delitoDto);
		}
		
		return delitosDto;
	}

	@Override
	@Transactional(readOnly = true)
	public Delito findById(Long id) {
		// TODO Auto-generated method stub
		
		return delitoRepository.findById(id).orElse(null);
	}

	@Override
	public Delito save(Delito delito) {
		// TODO Auto-generated method stub
		
		return delitoRepository.save(delito);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub

		Optional<Delito> delito = delitoRepository.findById(id);
		if(delito.isPresent()) {
			delitoRepository.deleteById(id);
		}
	}

}