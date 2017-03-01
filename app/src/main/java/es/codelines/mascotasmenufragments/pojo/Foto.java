package es.codelines.mascotasmenufragments.pojo;

/**
 * Created by abraham on 26/2/17.
 */

public class Foto {

    public int foto;
    public int raiting;

    public Foto(int foto, int raiting) {
        this.foto = foto;
        this.raiting = raiting;
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
