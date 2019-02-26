/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author duvan
 */
public class Concurso {

    ArrayList<concursos> concursos;

    public Concurso() {
        this.concursos=new ArrayList<>();
    }
    private boolean menu(){

        System.out.println("|1 Agregar Concursos");
        System.out.println("|2 listar Concursos");
        System.out.println("|3 Eliminar Concursos");

        int op=Integer.parseInt(JOptionPane.showInputDialog("elija una opccion"));
        System.out.println("------------------------------------------------------------------------------------------");
        if(op >0 && op<5){
            switch(op){
                case 1:{
                    this.AgregarConcurso();
                    break;
                }
                case 2:{
                    this.listarConcursos();
                    break;
                }
                case 3:{
                    this.eliminarC();
                    break;
                }
                case 4:{
                   
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Opcion no valida");
        }
        return false;
    }
    public void run(){
        while(!menu()){
            
        }
    }
//------------------------------------------------------Agregar concursos -----------------------------------------------------------------------------
    private void  AgregarConcurso(){
        System.out.println("|1  nombre y numero de problemas");
        System.out.println("|2 nombre");
        int op =Integer.parseInt(JOptionPane.showInputDialog("elija una opcion :"));
        
        while(op>3 && op<0){
            JOptionPane.showMessageDialog(null,"Opccion invalida ");
            System.out.println("|1 nombre y numero de problemas");
            System.out.println("|2 agregar nombre");
            op =Integer.parseInt(JOptionPane.showInputDialog("elija una opcion :"));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
        String nom=JOptionPane.showInputDialog("Ingrese Nombre :");
        while(!addDataConcurso(nom)){
            nom=JOptionPane.showInputDialog("este nombre ya existe, Ingrese Nombre :");
        }
        if(op==1){
            this.concursos.add(new concursos(nom, Integer.parseInt(JOptionPane.showInputDialog("ingrese un numero de problemas :"))));
        }else if(op==2){
            this.concursos.add(new concursos(nom));
        }
    }
    private boolean addDataConcurso(String nombre){
        boolean sw=true;
        for (int i = 0; i < this.concursos.size(); i++) {
            if(this.concursos.get(i).getNombre().equals(nombre)){
                JOptionPane.showMessageDialog(null, "este nombre de concurso ya se encuentra registrado ");
                sw = false;
            }
        }
        return sw;
    }
 //----------------------------------------------------Listar concursos ----------------------------------------------------------------------------------
   
    private void listarConcursos(){
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i=0;i<this.concursos.size();i++) {
            System.out.println((i+1)+"| Nombre :"+this.concursos.get(i).getNombre());
        }
        int op=Integer.parseInt(JOptionPane.showInputDialog("inserte una opccion :"))-1;
        while(op>this.concursos.size() || op<0){
            op=Integer.parseInt(JOptionPane.showInputDialog("error de index inserte una opccion valida:"));
        }
        while(submenu(op)){
         

        }
            
        
    }
    private boolean submenu(int o) {
 
        
        boolean sw=true;
        concursos c=this.concursos.get(o);

        int op=0;

        System.out.println("|1 editar nombre del concurso");
        System.out.println("|2 agregar equipos ");
        System.out.println("|3 ver nombre de los equipos");
        System.out.println("|4 envios ");
        System.out.println("|5 atras");
        op=Integer.parseInt(JOptionPane.showInputDialog("elija una opccion"));
         while(op>5 || op<1){
             op=Integer.parseInt(JOptionPane.showInputDialog("error eleccion invalida  elija una opccion"));
         }
         switch(op){

            case 1:{
                this.cambiarNombreConcurso(c);
                break;
            }
            case 2:{
                c.setEquipos(this.getNomEquipos());
                break;
            }
            case 3:{
                this.listarEquipos(c);
                break;
            }
            case 4:{
                this.envios(c);
                break;
            }
            case 5:{
                sw=false;
            }
        }
        this.concursos.set(o, c);
        
        return sw;
    }
  
    

    //------------------------------------------------------------Editar Concurso---------------------------------------------------------

    private void cambiarNombreConcurso(concursos c) {
        c.setNombre(JOptionPane.showInputDialog("Nuevo nombre para :"+c.getNombre()));
    }    
    
    private ArrayList<String> getNomEquipos(){
        int x=Integer.parseInt(JOptionPane.showInputDialog("Dijite la cantidad de equipos que habra en este concurso :"));
        ArrayList<String> aux=new ArrayList<>();
        for (int j = 0; j < x; j++) {
            
            String a=(JOptionPane.showInputDialog("nombre del equipo :"+j));
            if(aux.contains(a)){
                JOptionPane.showMessageDialog(null,"Uno de lo equipos ya se encuentra registrado con este mismo nombre "+a);
                j=j-1;
            }else{
                aux.add(a);
                System.out.println("se ha Agregado "+aux.get(aux.size()-1));
            }
        }
        return aux;
    }
 
    private void listarEquipos(concursos c) {

        if(c.getEquipos().size()>0){
            for (int i = 0; i < c.getEquipos().size(); i++) {
                System.out.println("Nombre :"+c.getEquipos().get(i));
            }
        }

        
    }
    
    private void editarNumPronlemas(concursos c) {  
        int x=Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de problemas para el concurso "));
        c.setNumPro(x);
    }
    
    //--------------------------------------------------------ELIMINAR-------------------------------------------------------------------

    private void eliminarC() {
        if(this.concursos.size()>0){
            int op=Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el indice del concurso que desea eliminar"));
            while(op<1 ||op>this.concursos.size()){
                op=Integer.parseInt(JOptionPane.showInputDialog(null,"error eleccion invalida ingrese l indice del concurso que desea eliminar"));
            }
            deleteC(op);
        }else{
            JOptionPane.showMessageDialog(null,"no existe ningun concurso en la lista");
        }
    }
    private boolean deleteC(int o){
        return null!=this.concursos.remove(o);
    }

    private void envios(concursos c) {
        System.out.println("|1 agregar envio");
        System.out.println("|2 ver envios ");
        int op=Integer.parseInt(JOptionPane.showInputDialog("elija una opccion "));
        while(op>2 ||  op<1){
            op = Integer.parseInt(JOptionPane.showInputDialog("error de indice elija una opccion valida "));
        }
        switch(op){
            case 1:{
                c.registarEnvio(JOptionPane.showInputDialog("ingrese el nombre del equipo"), Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero del problema") ),JOptionPane.showInputDialog("ingrse su respuesta"));
                break;
            }
            case 2:{

                for(int i=0;i<c.getEnvios().size();i++){
                    System.out.println("nombre equipo :"+c.getEnvios().get(i).getNombre()+" numero de problema "+c.getEnvios().get(i).getProblema()+" respuesta :"+c.getEnvios().get(i).getRespuesta());
                }
            }
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Concurso ww=new Concurso();
        while(true){
            ww.menu();
        }
    }
    public String getInput(){
        System.out.println("input escriba :");
        Scanner s=new Scanner(System.in);
        return s.nextLine();
    }
    
}
