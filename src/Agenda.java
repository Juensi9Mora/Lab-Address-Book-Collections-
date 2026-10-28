import java.util.*; // implementa toda la clase util

public class Agenda {
    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> gruposContactos = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto contactosC) {
        if(contactos.containsKey(contactosC.getNombre())) {
        System.out.println("Error: ya existe un contacto con esos datos");
        }  else {
            contactos.put(contactosC.getNombre(), contactosC);
            historial.add(contactosC);
            System.out.println("Contacto agregado: " + contactosC.getNombre());
        }
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }
    public boolean eliminarContacto(String nombre) {
        if (!contactos.containsKey(nombre)) {
            return false;
        }
        Contacto eliminado = contactos.remove(nombre);
        historial.remove(eliminado);
        for (Set<String> miembros : gruposContactos.values()) {
            miembros.remove(nombre);
        }
        return true;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }

    public void listarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        for (Contacto c : historial) {
            System.out.println(c);
        }
    } public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
        } else {
            grupos.add(nombreGrupo);
            gruposContactos.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo '" + nombreGrupo + "' creado");
        }
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        gruposContactos.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }

    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return;
        }
        for (String g : grupos) {
            System.out.println("- " + g);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        Set<String> miembros = gruposContactos.get(nombreGrupo);
        if (miembros.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }
        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombre : miembros) {
            Contacto c = contactos.get(nombre);
            System.out.println("- " + c);
        }
    }
}

