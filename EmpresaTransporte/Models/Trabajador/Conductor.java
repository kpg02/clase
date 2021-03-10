package Models.Trabajador;

import java.util.List;

public class Conductor extends Trabajador {
	private	List<String> listaCarnets;

	public Conductor(int id, String nombre, double salario, List<String> carnets) {
		super(id, nombre, salario);
		this.listaCarnets = carnets;
	}

	public boolean agregarCarnet(String nuevoCarnet){
		if(! listaCarnets.contains(nuevoCarnet)){
			listaCarnets.add(nuevoCarnet);
			return true;
		}
		return false;
	}

	public List<String> getCarnets(){
		return this.listaCarnets;
	}

	private String mostrarListaCarnets(){
		String listaCarnetsString = "";
		
		for (String carnet : listaCarnets){
			if (! listaCarnetsString.equals("")){
				listaCarnetsString += ", " + carnet;
			} else listaCarnetsString = carnet;
		}
		
		return listaCarnetsString;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
		+ "Carnets: " + mostrarListaCarnets();
	}
	
	
	
}
