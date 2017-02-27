package es.codelines.mascotasmenufragments.pojo;

/**
 * Created by abraham on 26/2/17.
 */

public class Foto {

    public int foto;
    public String raiting;

    public Foto(int foto, String raiting) {
        this.foto = foto;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }
}
