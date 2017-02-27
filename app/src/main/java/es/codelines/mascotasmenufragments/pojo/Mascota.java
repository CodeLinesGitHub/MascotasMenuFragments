package es.codelines.mascotasmenufragments.pojo;

/**
 * Created by abraham on 16/2/17.
 */

public class Mascota {

    public String nombreMascota;
    public int foto;
    public int raiting;

    public Mascota(String nombreMascota, int foto, int raiting) {

        this.nombreMascota = nombreMascota;
        this.foto = foto;
        this.raiting = raiting;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
