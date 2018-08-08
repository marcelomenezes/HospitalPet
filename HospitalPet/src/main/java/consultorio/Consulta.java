package consultorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import modelo.Medico;
import modelo.Pet;

@RestController
public class Consulta {
	
	private Map<Integer, Pet> consultas;
	
	public Consulta() {

		ArrayList<Medico> listaMedico = new ArrayList();
		ArrayList<Pet> listaPet = new ArrayList(),  listaConsulta = new ArrayList();
		ArrayList<Pet> listaConsultaPriori = new ArrayList();
		
		consultas = new HashMap<Integer, Pet>();
		
		//Adiciona exemplos pra teste
 		Pet pet1 = new Pet(1, "Laika", "cachorro", "poodle", false, "Cardiologista");
 		Pet pet2 = new Pet(2, "shera", "cachorro", "pastor", false, "Cardiologista");
 		Pet pet3 = new Pet(3, "Anastacia", "cachorro", "poodle", false, "Pediatra");
 		Pet pet4 = new Pet(4, "Frevo", "gato ","vira-lata", true, "Pediatra");
 		
 		listaPet.add(pet1);
 		listaPet.add(pet2);
 		listaPet.add(pet3);
 		listaPet.add(pet4);
 		
		//Adiciona médicos
		Medico med1 = new Medico(1, "João", "Pediatra");
		Medico med2 = new Medico(2, "José", "Cardiologista");
		
		listaMedico.add(med1);
		listaMedico.add(med2);
		
		listaConsulta = (ArrayList<Pet>)listaPet.clone();

		//Escalona os atendimentos prioritários adicionando-os numa lista prioritária
		for(Pet pet: listaPet) { 
			if (pet.isUrgente()) {
				if(pet.getNecessita() == pet.getNecessita())
				listaConsultaPriori.add(pet);
				listaConsulta.remove(pet);
			}
		}
		//adiciona o atendimentos normais na lista de prioritária, para que, estes fiquem atrás das prioridades
		listaConsultaPriori.addAll(listaConsulta);
		for(Medico medico: listaMedico) {
		for(Pet pet: listaConsultaPriori) {
			if(pet.getNecessita().equals(medico.getEspecialidade())) {
				System.out.println("pet: ");
				System.out.println(pet.getNome());
				//Salva através do id do médico o primeiro paciente pet da lista
				consultas.put(medico.getId(), pet);
				break;
			}
		}
		}
 }
//Retorna os valores do pet, salvo no mapeamento, por id do médico
 @RequestMapping(value = "/consulta/{id}", method = RequestMethod.GET)
 public ResponseEntity<Pet> buscar(@PathVariable("id") Integer id) {
   
	 Pet pet = consultas.get(id);
   
   if (pet == null) {
     return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
   }
  
   return new ResponseEntity<Pet>(pet, HttpStatus.OK);
 }	

}
