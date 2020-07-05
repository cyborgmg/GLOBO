package io.swagger.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.swagger.model.Contato;
import io.swagger.model.ContatoCreate;
import io.swagger.model.ContatoUpdate;

public class ContatoDao {
	
	private static List<Contato> contatos; 
	
	public ContatoDao() {
		contatos = new ArrayList<Contato>();
		
		contatos.add(new Contato(generatetId().toString(), "nome1", "canal1", "100", "obs1"));
		contatos.add(new Contato(generatetId().toString(), "nome2", "canal2", "101", "obs2"));
		contatos.add(new Contato(generatetId().toString(), "nome3", "canal3", "102", "obs3"));
		contatos.add(new Contato(generatetId().toString(), "nome4", "canal4", "103", "obs4"));
		contatos.add(new Contato(generatetId().toString(), "nome5", "canal5", "104", "obs5"));
		contatos.add(new Contato(generatetId().toString(), "nome6", "canal6", "105", "obs6"));
		contatos.add(new Contato(generatetId().toString(), "nome7", "canal7", "106", "obs7"));
		contatos.add(new Contato(generatetId().toString(), "nome8", "canal8", "107", "obs8"));
		contatos.add(new Contato(generatetId().toString(), "nome9", "canal9", "108", "obs9"));
		contatos.add(new Contato(generatetId().toString(), "nome10", "canal10", "110", "obs10"));

		
	}
	
	public List<Contato> todos(){
		return contatos;
	}
	
	public List<Contato> sublist(Integer pag, Integer cont){
		return contatos.subList(pag, cont);
	}
	
	public Contato salva(ContatoCreate contatoCreate) {
		
		Contato contato =  new Contato(generatetId().toString(), contatoCreate.getNome(), contatoCreate.getCanal(), contatoCreate.getValor(), contatoCreate.getObs());
		
		contatos.add(contato);
		
		return contato;
	}
	
	public boolean exclui(String id) {
		
		for (int i = 0; i < contatos.size(); i++) {
			if(contatos.get(i).getId().equals(id)) {
				contatos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Contato consultaPorId(String id) {
		
		for (int i = 0; i < contatos.size(); i++) {
			if(contatos.get(i).getId().equals(id)) {
				return  contatos.get(i);
			}
		}
		return null;
	}
	
	public boolean alteraPorId(String id, ContatoUpdate contatoUpdate) {
		
		for (int i = 0; i < contatos.size(); i++) {
			if(contatos.get(i).getId().equals(id)) {
				contatos.set(i, new Contato(id, contatoUpdate.getNome(), contatoUpdate.getCanal(), contatoUpdate.getValor(), contatoUpdate.getObs()));
				return true;
			}
		}
		return false;
	}
			

	private Integer generatetId() {
		return (int) (Math.random() * 100);
	}
	

}
