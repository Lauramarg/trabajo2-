/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class concursos {
    String nombre;
    int numPro;
    ArrayList<envios> Envios;
    ArrayList<String> Equipos;

    public concursos(String nombre,int pro) {
        this.Envios=new ArrayList<>();
        this.Equipos=new ArrayList<>();
        this.nombre=nombre;
        this.numPro=pro;
    }
    public concursos(String n){
        this.Envios=new ArrayList<>();
        this.Equipos=new ArrayList<>();
        this.nombre=n;
        this.numPro=5;
    }

    public String getNombre() {
        return nombre;
    }
   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }

    public ArrayList<envios> getEnvios() {
        return Envios;
    }

    public void setEnvios(ArrayList<envios> Envios) {
        this.Envios = Envios;
    }

    public ArrayList<String> getEquipos() {
        return Equipos;
    }

    public void setEquipos(ArrayList<String> Equipos) {
        this.Equipos = Equipos;
    }
    
    
    public boolean registarEnvio(String nombre,int numProb,String resp){
        if(this.Equipos.contains(nombre)){
            if(numProb<this.numPro){
                if(!resp.equals("")){
                    this.Envios.add(new envios(nombre, resp, numProb));
                    JOptionPane.showMessageDialog(null, "envio registrado");
                    return false;
                }else{
                    JOptionPane.showMessageDialog(null, "respuesta vacia ");
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "indice del problema exedido");
            }
        }else{
            return false;
        }
        return true;
    }
    
}
