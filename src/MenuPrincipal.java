import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = 0;

            while (opcion != 10) {
                System.out.println("\n=== AGENDA DE CONTACTOS ===");
                System.out.println("1. Agregar contacto");
                System.out.println("2. Buscar contacto");
                System.out.println("3. Eliminar contacto");
                System.out.println("4. Listar contactos (orden alfabetico)");
                System.out.println("5. Listar historial (orden de insercion)");
                System.out.println("6. Agregar grupo");
                System.out.println("7. Agregar contacto a grupo");
                System.out.println("8. Listar grupos");
                System.out.println("9. Mostrar contactos por grupo");
                System.out.println("10. Salir");
                System.out.print("Elige una opcion: ");


                if (!scanner.hasNextInt()) {
                    System.out.println("Opcion invalida, intenta de nuevo");
                    scanner.nextLine();
                    continue;
                }

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("--- AGREGA CONTACTO ---");
                        System.out.print("Nombre: ");
                        String nom = scanner.nextLine();
                        System.out.print("Telefono: ");
                        String tel = scanner.nextLine();
                        System.out.print("Email: ");
                        String em = scanner.nextLine();
                        agenda.agregarContacto(new Contacto(nom, tel, em));
                        break;
                    case 2:
                        System.out.print("Nombre a buscar: ");
                        String bus = scanner.nextLine();
                        Contacto encontrado = agenda.buscarContacto(bus);
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Contacto no encontrado: " + bus);
                        }
                        break;
                    case 3:
                        System.out.print("Nombre a eliminar: ");
                        String elim = scanner.nextLine();
                        if (agenda.eliminarContacto(elim)) {
                            System.out.println("Contacto eliminado: " + elim);
                        } else {
                            System.out.println("Contacto no encontrado: " + elim);
                        }
                        break;
                    case 4:
                        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
                        agenda.listarContactos();
                        break;
                    case 5:
                        System.out.println("--- HISTORIAL (orden de insercion) ---");
                        agenda.listarHistorial();
                        break;
                    case 6:
                        System.out.print("Nombre del grupo: ");
                        String gp = scanner.nextLine();
                        agenda.agregarGrupo(gp);
                        break;
                    case 7:
                        System.out.print("Nombre del contacto: ");
                        String cG = scanner.nextLine();
                        System.out.print("Nombre del grupo: ");
                        String gC = scanner.nextLine();
                        agenda.agregarContactoAGrupo(cG, gC);
                        break;
                    case 8:
                        System.out.println("--- LISTA DE GRUPOS ---");
                        agenda.listarGrupos();
                        break;
                    case 9:
                        System.out.print("Nombre del grupo: ");
                        String gVer = scanner.nextLine();
                        agenda.mostrarContactosPorGrupo(gVer);
                        break;
                    case 10:
                        System.out.println("Saliendo de la agenda...");
                        break;
                    default:
                        System.out.println("Opcion invalida, intenta de nuevo");
                }
            }
            scanner.close();
        }
    }
}

