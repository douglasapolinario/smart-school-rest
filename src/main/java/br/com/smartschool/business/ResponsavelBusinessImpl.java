package br.com.smartschool.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import static br.com.smartschool.business.BusinessResponse.BusinessResponseStatus.*;

import br.com.smartschool.dao.ResponsavelDaoImpl;
import br.com.smartschool.model.Responsavel;

public class ResponsavelBusinessImpl implements ResponsavelBusiness {
	
	@Inject
	private ResponsavelDaoImpl responsavelDao;

	@Override
	public BusinessResponse<Responsavel> save(Responsavel responsavel) {
		if (!Optional.ofNullable(responsavel).isPresent()) {
			return BusinessResponse.<Responsavel>builder()
						.messages(Collections.singletonMap("resp", "Responsavel não pode ser nulo"))
						.status(ERROR)
						.build();
		}
		
		Optional<Map<String,String>> validations = responsavel.applyValidations();
		
		if (validations.isPresent()) {
			return BusinessResponse.<Responsavel>builder()
					.messages(validations.get())
					.status(ERROR)
					.build();
		}
		
		Responsavel respFromDB = responsavelDao.findByCPF(responsavel.getCpf());
		
		if (Optional.ofNullable(respFromDB).isPresent()) {
			return BusinessResponse.<Responsavel>builder()
					.messages(Collections.singletonMap("cpf", "CPF já está em uso por outro responsável"))
					.status(ERROR)
					.build();
		}
		
		respFromDB = responsavelDao.findByEmail(responsavel.getEmail());
		
		if (Optional.ofNullable(respFromDB).isPresent()) {
			return BusinessResponse.<Responsavel>builder()
					.messages(Collections.singletonMap("email", "Email já está em uso por outro responsável"))
					.status(ERROR)
					.build();
		}
		
		Responsavel resp = responsavelDao.createOrUpdate(responsavel);
		return BusinessResponse.<Responsavel>builder()
				.content(resp)
				.status(OK)
				.build();
	}

	@Override
	public BusinessResponse<Responsavel> update(Responsavel responsavel) {
		Responsavel respFromDB = responsavelDao.findByCPF(responsavel.getCpf());
		
		if (!Optional.ofNullable(respFromDB).isPresent()) {
			return BusinessResponse.<Responsavel>builder()
					.messages(Collections.singletonMap("resp", "Nenhum responsável encontrado"))
					.status(ERROR)
					.build();
		}
		
		respFromDB.setCelular(responsavel.getCelular());
		respFromDB.setTelefone(responsavel.getTelefone());
		respFromDB.setRg(responsavel.getRg());
		respFromDB.setNome(responsavel.getNome());
		respFromDB.setSobrenome(responsavel.getSobrenome());
		respFromDB.setSenha(responsavel.getSenha());
		
		responsavelDao.createOrUpdate(respFromDB);
		
		return BusinessResponse.<Responsavel>builder()
				.content(respFromDB)
				.status(OK)
				.build();
	}

	@Override
	public BusinessResponse<Responsavel> delete(Responsavel responsavel) {
		responsavelDao.delete(responsavel.getId());
		
		return BusinessResponse.<Responsavel>builder()
				.status(OK)
				.build();
	}
	
	@Override
	public BusinessResponse<Responsavel> findById(Long id) {
		Responsavel respFromDB = responsavelDao.find(id);
		
		if (!Optional.ofNullable(respFromDB).isPresent()) {
			return BusinessResponse.<Responsavel>builder()
					.messages(Collections.singletonMap("resp", "Nenhum responsável encontrado"))
					.status(ERROR)
					.build();
		}
		
		return BusinessResponse.<Responsavel>builder()
				.content(respFromDB)
				.status(OK)
				.build();
	}

	@Override
	public BusinessResponse<Responsavel> findByCPF(String cpf) {
		Responsavel respFromDB = responsavelDao.findByCPF(cpf);
		
		return BusinessResponse.<Responsavel>builder()
				.content(respFromDB)
				.status(OK)
				.build();
	}

	@Override
	public BusinessResponse<Responsavel> findByEmail(String email) {
		Responsavel respFromDB = responsavelDao.findByEmail(email);
		
		return BusinessResponse.<Responsavel>builder()
				.content(respFromDB)
				.status(OK)
				.build();
	}

	@Override
	public BusinessResponse<List<Responsavel>> findAll() {
		Iterable<Responsavel> findAll = responsavelDao.findAll();
		List<Responsavel> responsaveis = new ArrayList<>();
		findAll.forEach(responsaveis::add);
		
		return BusinessResponse.<List<Responsavel>>builder()
				.content(responsaveis)
				.status(OK)
				.build();
	}

}
