/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

/**
 *
 * @author duvan
 */
public class envios {
    String nombre;
    String respuesta;
    int problema;

    public envios(String nombre, String respuesta, int problema) {
        this.nombre = nombre;
        this.respuesta = respuesta;
        this.problema = problema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getProblema() {
        return problema;
    }

    public void setProblema(int problema) {
        this.problema = problema;
    }
    
}
