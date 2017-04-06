package br.com.escola.model.relationship.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface RelationshipType {

	 String ALUNO = "ALUNO";
	 String APRENDE = "APRENDE";
	 String TEM = "TEM";
	 String RESPONSAVEL = "RESPONSAVEL";
	 String LECIONA = "LECIONA";
	 String GRADE = "GRADE";
	 String PROFESSOR = "PROFESSOR";
	 String FUNCIONARIO = "FUNCIONARIO";
	 String SERIES = "SERIES";
	
}
