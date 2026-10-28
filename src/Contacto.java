public class Contacto {
    //atributos privados
    private String nombre;
    private String telefono;
    private String correo;

    //Constructor
    public Contacto(String nombre, String telefono, String correo){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    //usar getters y setters
    public String getNombre () {
        return nombre;
    }
    public void setNombre(String nombre){
    this.nombre = nombre;}

    public String getTelefono () {
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;}

    public String getCorreo () {
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;}

    //formato de salida
    @Override
    public String toString(){
    return nombre + " Teléfono: " + telefono + "Correo: " + correo;
    }

}

