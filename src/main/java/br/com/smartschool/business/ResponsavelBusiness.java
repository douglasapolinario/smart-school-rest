package br.com.smartschool.business;

import java.util.List;

import br.com.smartschool.model.Responsavel;

public interface ResponsavelBusiness {
	
	public BusinessResponse<Responsavel> save(Responsavel responsavel);
	
	public BusinessResponse<Responsavel> update(Responsavel responsavel);
	
	public BusinessResponse<Responsavel> delete(Responsavel responsavel);
	
	public BusinessResponse<Responsavel> findById(Long id);
	
	public BusinessResponse<Responsavel> findByCPF(String cpf);
	
	public BusinessResponse<Responsavel> findByEmail(String email);
	
	public BusinessResponse<List<Responsavel>> findAll();

}
