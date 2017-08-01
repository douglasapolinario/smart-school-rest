package br.com.smartschool.business;

import java.util.Collections;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import br.com.smartschool.business.BusinessResponse.BusinessResponseStatus;
import br.com.smartschool.cdi.WeldJUnit4Runner;
import br.com.smartschool.model.Responsavel;
import br.com.smartschool.util.AbstractTest;

@RunWith(WeldJUnit4Runner.class)
public class ResponsavelBusinessTest extends AbstractTest {

	@Inject
	private ResponsavelBusiness responsavelBusiness;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldThrowExceptionRespNull() {
		BusinessResponse<Responsavel> response = responsavelBusiness.save(null);
		Assert.assertEquals(Collections.singletonMap("resp", "Responsavel não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespNomeNull() {
		Responsavel responsavel = Responsavel.builder()
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("nome", "Nome responsável não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespSobrenomeNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("sobrenome", "Sobrenome responsável não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespRGNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("rg", "RG responsável inválido"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespCPFNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("cpf", "CPF responsável inválido"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespCelularNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("celular", "Celular responsável não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespTelefoneNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("telefone", "Telefone responsável não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespEmailNull() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertEquals(Collections.singletonMap("email", "Email responsável não pode ser nulo"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespCPFInvalid() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		responsavelBusiness.save(responsavel);
		
		Responsavel respDuplicado = Responsavel.builder()
				.nome("Otavio")
				.sobrenome("Souza")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(respDuplicado);
		
		Assert.assertEquals(Collections.singletonMap("cpf", "CPF já está em uso por outro responsável"), response.getMessages());
	}
	
	@Test
	public void shouldThrowExceptionRespEmailInvalid() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		responsavelBusiness.save(responsavel);
		
		Responsavel respDuplicado = Responsavel.builder()
				.nome("Otavio")
				.sobrenome("Souza")
				.rg("441889786")
				.cpf("23289434098")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		BusinessResponse<Responsavel> response = responsavelBusiness.save(respDuplicado);
		
		Assert.assertEquals(Collections.singletonMap("email", "Email já está em uso por outro responsável"), response.getMessages());
	}
	
	@Test
	public void shouldSaveResp() {
		Responsavel responsavel = Responsavel.builder()
				.nome("Douglas")
				.sobrenome("Oliveira Apolinario")
				.rg("441889786")
				.cpf("23289434099")
				.celular("(11) 999887766")
				.telefone("(11) 47890000")
				.email("douglas@gmail.com")
				.build();
		
		BusinessResponse<Responsavel> response = responsavelBusiness.save(responsavel);
		Assert.assertNotNull(responsavel.getId());
		Assert.assertEquals(response.getStatus(), BusinessResponseStatus.OK);
	}
	
}
