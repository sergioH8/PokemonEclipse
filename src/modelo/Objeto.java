package modelo;

public class Objeto {


    private String nombre;
    private int aumento;
    private int disminucion;
    private int precio;
    private String descripcion;

    /**
     * Constructor por defecto
     *
     */
    public Objeto() {
        super();
        this.nombre = "";
        this.aumento = 0;
        this.disminucion = 0;
        this.precio = 0;
        this.descripcion = "";
    }

    /**
     * Constructor copia
     *
     * @param object
     */
    public Objeto(Objeto object) {
        this.nombre = object.nombre;
        this.aumento = object.aumento;
        this.disminucion = object.disminucion;
        this.precio = object.precio;
        this.descripcion = object.descripcion;
    }

    /**
     * Constructor completo.
     *
     * @param nombre
     * @param aumento
     * @param disminucion
     * @param precio
     * @param descripcion
     */
    public Objeto(String nombre, int aumento, int disminucion, int precio, String descripcion) {
        super();
        this.nombre = nombre;
        this.aumento = aumento;
        this.disminucion = disminucion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAumento() {
        return aumento;
    }

    public void setAumento(int aumento) {
        this.aumento = aumento;
    }

    public int getDisminucion() {
        return disminucion;
    }

    public void setDisminucion(int disminucion) {
        this.disminucion = disminucion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precioCompra) {
        this.precio = precioCompra;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Aumenta las estadisticas de un Pokemon en base al Atributo Objeto de este.
     *
     * @param p
     */
    public void equipar(Pokemon p) {

        switch (this.nombre.toUpperCase()) {

            case "pesa":
                p.setObjeto(this);
                p.setAtaque(p.getAtaque() + (p.getAtaque() * this.aumento / 100));
                p.setDefensa(p.getDefensa() + (p.getDefensa() * this.aumento / 100));
                p.setVelocidad(p.getVelocidad() - (p.getVelocidad() * this.disminucion / 100));
                break;
            case "pluma":
                p.setObjeto(this);
                p.setVelocidad(p.getVelocidad() + (p.getVelocidad() * this.aumento / 100));
                p.setDefensa(p.getDefensa() - (p.getDefensa() * this.aumento / 100));
                p.setDefensaEspecial(p.getDefensaEspecial() - (p.getDefensaEspecial() * this.aumento / 100));
                break;
            case "chaleco":
                p.setObjeto(this);
                p.setDefensa(p.getDefensa() + (p.getDefensa() * this.aumento / 100));
                p.setDefensaEspecial(p.getDefensaEspecial() + (p.getDefensaEspecial() * this.aumento / 100));
                p.setVelocidad(p.getVelocidad() - (p.getVelocidad() * this.disminucion / 100));
                p.setAtaque(p.getAtaque() - (p.getAtaque() * this.disminucion / 100));
                break;
            case "anilloUnico":

                break;

            default:
                break;
        }

    }

    /**
     * Disminuye las estadisticas de un Pokemon en base al Atributo Objeto de este
     * teniendo en cuenta el valor aumentado/disminudo anteriormente por el Objeto.
     *
     * @param p
     */
    public void quitar(Pokemon p) {
        switch (this.nombre.toUpperCase()) {
            case "pesa":
                p.setAtaque(p.getAtaque() * 100 / (this.aumento + 100));
                p.setDefensa(p.getDefensa() * 100 / (this.aumento + 100));
                p.setVelocidad(p.getVelocidad() * 100 / (100 - this.disminucion));
                break;
            case "pluma":
                p.setVelocidad(p.getVelocidad() * 100 / (this.aumento + 100));
                p.setDefensa(p.getDefensa() * 100 / (100 - this.disminucion));
                p.setDefensaEspecial(p.getDefensaEspecial() * 100 / (100 - this.disminucion));
                break;
            case "chaleco":
                p.setDefensa(p.getDefensa() * 100 / (this.aumento + 100));
                p.setDefensaEspecial(p.getDefensaEspecial() * 100 / (this.aumento + 100));
                p.setVelocidad(p.getVelocidad() * 100 / (100 - this.disminucion));
                p.setAtaque(p.getAtaque() * 100 / (100 - this.disminucion));
                break;
            case "anillounico":
                // Aquí iría la lógica para quitar los efectos del anillo único
                break;
            default:
                break;
        }
        p.setObjeto(null); // Quitamos el objeto asignado al Pokémon
    }

}