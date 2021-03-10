package Views;

import Controllers.TrabajadorController;
import Models.Trabajador.Conductor;
import Models.Trabajador.Trabajador;
import Models.Trabajador.Oficinista;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		try{
			List<Trabajador> listaTrabajadores = new ArrayList<>();
			menu(listaTrabajadores);
		} catch (Exception e){
			System.out.println("Hubo un error");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void menu(List<Trabajador> listaTrabajadores) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		mostrarMenu();
		System.out.println("Selecciona una opción");
		opcion = Integer.parseInt(sc.nextLine());
		elegirOpcion(opcion, listaTrabajadores);
	}
	
	private static void mostrarMenu(){
		System.out.println("\n\n");
		System.out.println("1. Dar de alta a un trabajador");
		System.out.println("2. Mostrar todos los trabajadores");
		System.out.println("3. Mostrar datos de un trabajador por ID");
		System.out.println("4. Mostrar trabajadores por tipo");
		System.out.println("5. Eliminar trabajador por ID");
		System.out.println("6. Modificar trabajador por ID");
		System.out.println("7. Eliminar trabajador por tipo");
		System.out.println("8. Salir");
		System.out.println("9. Crear 50 conductores y 50 oficinistas 'aleatorios'");
	}
	
	private static Trabajador crearTrabajador(){
		Scanner sc = new Scanner(System.in);
		String nombre;
		int id;
		double salario;
		String tipoTrabajador;
		String carnet;
		String departamento;
		List<String> carnets = new ArrayList<>();
		
		System.out.println("Escribe el Nombre del trabajador");
		nombre = sc.nextLine();
		
		System.out.println("Escribe el id del trabajador");
		id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Escribe el salario del trabajador");
		salario = Double.parseDouble(sc.nextLine());
		
		System.out.println("Escribe el tipo de trabajador conductor o oficinista");
		tipoTrabajador = sc.nextLine();
		if (tipoTrabajador.toLowerCase().equals("conductor") ){
			while (true){
				System.out.println("Introduce un carnet o escribe 'no' para salir");
				carnet = sc.nextLine();
				if (carnet.equals("no")){
					break;
				}
				carnets.add(carnet);
				
			}
			
			return new Conductor(id, nombre, salario, carnets);
		}
		else if (tipoTrabajador.toLowerCase().equals("oficinista")){
			System.out.println("Escribe el departamento de la oficina");
			departamento = sc.nextLine();
			return new Oficinista(departamento, id, nombre, salario);
		}
		return crearTrabajador();
	}
	
	
	
	private static void elegirOpcion(int opcion, List<Trabajador> listaTrabajadores) {
		int id;
		Scanner sc = new Scanner(System.in);
		String tipo;
		boolean resultado;
		switch (opcion){
			case 1:
				resultado = TrabajadorController.addTrabajador(listaTrabajadores,
						crearTrabajador());
				if (resultado){
					System.out.println("Trabajador creado correctamente");
				} else{ System.out.println("No se pudo crear el trabajador");}
				break;
				
			case 2:
				TrabajadorController.mostrarTrabajadores(listaTrabajadores);
				break;
				
			case 3:
				System.out.println("Escribe el id del trabajador");
				id = Integer.parseInt(sc.nextLine());
				Trabajador trabajadorBuscado = TrabajadorController.buscarTrabajadorId(
						listaTrabajadores, id);
				TrabajadorController.mostrarSegunTrabajo(trabajadorBuscado);
				break;
				
			case 4:
				System.out.println("Escribe el tipo que quieres mostrar");
				System.out.println("oficinista o conductor");
				tipo = sc.nextLine();
				List<Trabajador> listaResultante = TrabajadorController.extraerTipoTrabajadores(listaTrabajadores, tipo);
				TrabajadorController.mostrarTrabajadores(listaResultante);
				break;
				
			case 5:
				System.out.println("Introduce el ID del trabajador a borrar");
				id = sc.nextInt();
				TrabajadorController.removeTrabajadorId(listaTrabajadores, id);
				break;
				
			case 6:
				modificarTrabajadorTipo(listaTrabajadores);
				break;
				
			case 7:
				System.out.println("Escribe el tipo que quieres borrar");
				System.out.println("oficinista o conductor");
				tipo = sc.nextLine();
				TrabajadorController.removeTrabjadoresTipo(listaTrabajadores, tipo);
				break;
			case 8:
				return;
			case 9:
				testCrear(listaTrabajadores);
				break;
			default:
				System.out.println("Introduce un valor entre el 1 y el 7");
				break;
		}
		menu(listaTrabajadores);
	}
	
	private static void modificarTrabajadorTipo(List<Trabajador> listaTrabajadores) {
		int id;
		String nuevoDato;
		String nombre;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el id del trabajador");
		id = sc.nextInt();
		
		Trabajador trabajadorAModificar = TrabajadorController.buscarTrabajadorId(listaTrabajadores, id);
		if (trabajadorAModificar == null){
			System.out.println("El trabajador no exite");
			return;
		}
		
		System.out.println("Escribe el nuevo nombre de " + trabajadorAModificar.getNombre());
		nombre = sc.nextLine();
		
		trabajadorAModificar.setNombre(nombre);
		
		switch (trabajadorAModificar.getTipoTrabajador()) {
			case "oficinista":
				System.out.println("Escribe el nuevo departamento para " + trabajadorAModificar.getNombre());
				break;
			case "conductor":
				System.out.println("Escribe el nuevo carnet para " + trabajadorAModificar.getNombre());
				break;
			default:
				System.out.println("El tipo de trabajador no está implementado");
				return;
		}
		nuevoDato = sc.nextLine();
		TrabajadorController.modificarTrabajador(trabajadorAModificar, nuevoDato);
	}
	
	private static void testCrear(List<Trabajador> listaTrabajadores) {
		List<String> probar = new ArrayList<>();
		probar.add("a");
		for (int i = 0; i < 50; i++){
			TrabajadorController.addTrabajador(listaTrabajadores,
					new Conductor(i, "Nombre" + i, i*1300, probar)
			);
		}
		for (int i = 100; i < 150; i++){
			TrabajadorController.addTrabajador(listaTrabajadores,
					new Oficinista("RRHH"+i, i, "NOMBRE"+i, i*400)
			);
		}
		System.out.println("50 oficinistas y 50 trabajadores creados");
		
	}
	
	
}
