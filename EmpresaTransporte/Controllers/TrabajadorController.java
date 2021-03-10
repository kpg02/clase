package Controllers;

import Models.Trabajador.Trabajador;
import Models.Trabajador.Oficinista;
import Models.Trabajador.Conductor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrabajadorController {

//	public static void main(String[] args) {
//		List<Trabajador> pruebaLista = new ArrayList<>();
//		Trabajador test = new Oficinista("rrhh",1 ,"rrhh",1.0 );
//		pruebaLista.add(test);
//		mostrarTrabajadores(pruebaLista);
//	}
	public static boolean addTrabajador(List<Trabajador> listaTrabajadores, Trabajador trabajadorAInsertar) {
		Trabajador resultadoTrabajador = buscarTrabajadorId(listaTrabajadores,
															trabajadorAInsertar.getId());
		if (resultadoTrabajador == null){
			insertarEnOrdern(trabajadorAInsertar, listaTrabajadores, 0, 
							 listaTrabajadores.size());
			return true;
		}
		return false;
	}

	public static Trabajador buscarTrabajadorId(List<Trabajador> listaTrabajadores,
												int id){
		for (Trabajador comprobarTrabajador : listaTrabajadores){
			if (comprobarTrabajador.getId() == id){
				return comprobarTrabajador;
			}
		}
		return null;
	}

	public static void insertarEnOrdern(Trabajador nuevoTrabajador, 
										List<Trabajador> listaTrabajadores,
										int posicionBaja, int posicionAlta){
		int posicionMedio;
		int id = nuevoTrabajador.getId();

		if (id >= posicionAlta || posicionAlta == posicionBaja){
			listaTrabajadores.add(nuevoTrabajador);
			return;
		} else if (id < posicionBaja){
			listaTrabajadores.add(0 ,nuevoTrabajador);
			return;
		} 

		posicionMedio = (posicionBaja / posicionAlta);

		if (id == posicionMedio){
			listaTrabajadores.add(posicionMedio, nuevoTrabajador);
			return;
		}

		if (id > posicionMedio){
			insertarEnOrdern(nuevoTrabajador, listaTrabajadores, posicionMedio, posicionAlta);
		} else{
			insertarEnOrdern(nuevoTrabajador, listaTrabajadores, posicionBaja, posicionMedio);
		}

	}
	
	public static void mostrarSegunTrabajo(Trabajador trabajadorMostrar){
			if (trabajadorMostrar == null){
				System.out.println("No existe el trabajador");
				return;
			}
		switch (trabajadorMostrar.getTipoTrabajador()) {
			case "oficinista":
				Oficinista oficinistaMostrar = (Oficinista) trabajadorMostrar;
				System.out.println(oficinistaMostrar.toString());
				break;
			case "conductor":
				Conductor conductorMostrar = (Conductor) trabajadorMostrar;
				System.out.println(conductorMostrar.toString());
				break;
			default:
				System.out.println("El tipo de trabajador no está implementado");
				break;
		}
	}

	public static void mostrarTrabajadores(List<Trabajador> listaTrabajadores){
		for (Trabajador trabajadorMostrar : listaTrabajadores){
			mostrarSegunTrabajo(trabajadorMostrar);
		}

	}

	public static List<Trabajador> extraerTipoTrabajadores(List<Trabajador> listaTrabajadores, String tipoTrabajador){
		List<Trabajador> listaResultante = new ArrayList<>();
		for (Trabajador trabajadorComprobar : listaTrabajadores){
			if (trabajadorComprobar.getTipoTrabajador().equals(tipoTrabajador)){
				listaResultante.add(trabajadorComprobar);
			}
		} 
		return listaResultante;
	}

//	public static void mostrarTipoTrabajadores(List<Trabajador> listaTrabajadores,
//										   	   String tipoTrabajador){
//		if (tipoTrabajador.equals("oficinista") || tipoTrabajador.equals("conductor") ){
//			mostrarTrabajadores(extraerTipoTrabajadores(listaTrabajadores, tipoTrabajador));
//			return;
//		}
//		System.out.println("No se encontró ese tipo de trabajador");
//	}


	public static void removeTrabjadoresTipo(List<Trabajador> listaTrabajadores, String tipo){
		Iterator trabajadoresComprobar = listaTrabajadores.iterator();
		while(trabajadoresComprobar.hasNext()){
			Trabajador trabajadorMirar = (Trabajador) trabajadoresComprobar.next();
			if (trabajadorMirar.getTipoTrabajador().equals(tipo)){
				trabajadoresComprobar.remove();
			}
		}
		
	}
	
	public static boolean removeTrabajadorId(List<Trabajador> listaTrabajadores, int id) {
		Trabajador trabajadorBorrar = buscarTrabajadorId(listaTrabajadores, id);
		if (trabajadorBorrar == null){
			return false;
		}
		listaTrabajadores.remove(trabajadorBorrar);
		return true;
	}
	
	public static boolean modificarTrabajador(Trabajador trabajadorAModificar, String nuevoDato){
		
		boolean resultadoModificar;
		switch (trabajadorAModificar.getTipoTrabajador()) {
			case "oficinista":
				Oficinista oficinistaModificar = (Oficinista) trabajadorAModificar;
				resultadoModificar = oficinistaModificar.setDepartamento(nuevoDato);
				if (resultadoModificar){
					System.out.println("Se cambió el departamento correctamente");
				}
				else System.out.println("El departamento es el mismo al anterior");
				
			case "conductor":
				Conductor conductorModificar = (Conductor) trabajadorAModificar;
				resultadoModificar = conductorModificar.agregarCarnet(nuevoDato);
				if (resultadoModificar){
					System.out.println("Se agrego el carnet correctamente");
				} else	System.out.println("Ya tiene el carnet que estás intentando agregar");
				break;
			default:
				System.out.println("El tipo de trabajador no está implementado");
				break;
		}
		return true;
	}
}
