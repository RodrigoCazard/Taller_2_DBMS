
package bd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        ArbolBD miArbolBD = new ArbolBD();
        NodoBD bdActual = new NodoBD(0, "nombre_bd_por_defecto", new Grafo());
        
        int nuevoIdBD, nuevoIdTabla, nuevoIdAtributo;
        String nuevoNombreBD = new String();
        String nuevoNombreTabla = new String();
        String nuevoNombreAtributo = new String();
        
        Scanner escaner = new Scanner(System.in);
        
        while (true) {
            
            mostrarMenuBD();
            int opcion = escaner.nextInt();
            escaner.nextLine();
            
            switch (opcion) {
                case 1:
                    if(miArbolBD.esVacio()){
                        System.out.println("No hay bases de datos creadas.");
                    } else {
                        System.out.println("==== SELECIONA UNA BD ====");
                        miArbolBD.imprimirArbol();
                        System.out.println("==========================");
                        System.out.print("Ingresa ID: ");
                        nuevoIdBD = escaner.nextInt();
                        bdActual = miArbolBD.encontrarNodo(miArbolBD.getRaiz(), nuevoIdBD);
                        if(bdActual == null){
                            System.out.println("Error: Base de datos no encontrada.");
                        } else {
                            ///
                            mostrarMenuTabla();
                            opcion = escaner.nextInt();
                            
                            while(opcion != 6){
                                switch(opcion){
                                    case 1:
                                        System.out.println("========= TABLAS =========");
                                        if(bdActual.getTablas().esVacia()==true){
                                            System.out.println("No hay tablas creadas.");
                                        } else {
                                            System.out.print("\n");
                                            bdActual.getTablas().imprimir(); 
                                        }
                                        break;
                                    case 2:
                                        System.out.println("buenas");
                                        break;
                                    case 3:
                                        System.out.println("====== CREAR TABLA ======");
                                        System.out.print("Ingrese ID de la tabla: ");
                                        nuevoIdTabla = escaner.nextInt();
                                        escaner.nextLine();
                                        System.out.print("Ingrese nombre de la tabla: ");
                                        nuevoNombreTabla = escaner.nextLine();
                                        bdActual.getTablas().agregarNodo(new Tabla(nuevoIdTabla, nuevoNombreTabla));
                                        //System.out.println("Tabla creada de forma exitosa.");
                                        //System.out.println("Ingrese nombre del atributo: ");
                                        //nuevoNombreAtributo = scanner.nextLine();
                                        //bdActual.getTablas().
                                        // no espacios en el nombre
                                        // solamente numeros en id tabla
                                        // no espacios en blanco
                                        // verificar si la tabla ya existe
                                        break;
                                    case 4:
                                    case 5:
                                        System.out.println("buenas");
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor intente denuevo.");
                                }
                                mostrarMenuTabla();
                                opcion = escaner.nextInt();
                            }
                            ///
                        }
                        // No permitir letras
                        // No permitir espacios en blanco
                    }
                    break;
                case 2:
                    System.out.println("===== CREAR BD =====");
                    System.out.print("Ingrese nombre de la bd: ");
                    nuevoNombreBD = escaner.nextLine();
                    System.out.print("Ingrese ID de la bd: ");
                    nuevoIdBD = escaner.nextInt();
                    miArbolBD.insertar(nuevoIdBD, nuevoNombreBD, new Grafo());
                    // no permitir espacios en el nombre de la bd
                    // solo aceptar numeros en el id de la bd
                    // no permitir espacios en blanco
                    // advertir si la bd ya existe
                    break;
                case 3:
                    System.out.println("==== ELIMINAR BD ====");
                    System.out.print("Ingrese ID: ");
                    nuevoIdBD = escaner.nextInt();
                    miArbolBD.eliminar(nuevoIdBD);
                    // solo tomar numeros
                    // no permitir espacios en blanco
                    // advertir si la bd no existe
                    break;
                case 4:
                    System.out.println("==== MODIFICAR BD ====");
                    System.out.print("Ingrese ID: ");
                    nuevoIdBD = escaner.nextInt();
                    escaner.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    nuevoNombreBD = escaner.nextLine();
                    miArbolBD.modificar(nuevoIdBD, nuevoNombreBD);
                    // solo tomar numeros en el id
                    // no permitir espacios en blanco
                    // advertir si la bd no existe
                    // no permitir espacios o texto vacio en el nombre
                    break;
                case 5:
                    System.out.println("Saliendo del menú.");
                    escaner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor intente denuevo");
            }
        } 
    }
    
    private static void mostrarMenuBD() {
        System.out.println("======== MENÚ BD ========");
        System.out.println("1. Usar base de datos");
        System.out.println("2. Crear base de datos");
        System.out.println("3. Eliminar base de datos");
        System.out.println("4. Modificar base de datos");
        System.out.println("5. Salir");
        System.out.println("=========================");
        System.out.print("Ingrese una opción: ");
    }

    private static void mostrarMenuTabla() {
        System.out.println("======= MENU TABLA =======");
        System.out.println("1. Mostrar todas las tablas");
        System.out.println("2. Mostrar una tabla");
        System.out.println("3. Crear tabla");
        System.out.println("4. Eliminar tabla");
        System.out.println("5. Modificar tabla");
        System.out.println("6. Regresar");
        System.out.println("==========================");
        System.out.print("Ingrese una opción: ");
    }
    
}
