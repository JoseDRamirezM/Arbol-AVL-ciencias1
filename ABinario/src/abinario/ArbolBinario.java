/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abinario;

/**
 *
 * @author eskat
 */
public class ArbolBinario<E> {
    
    NodoArbol<E> raiz;
    
    public ArbolBinario(){
      raiz = null;
    }
    
    public boolean esPerfecto(){
      int nodos = 1 + raiz.cantidadHijos();
      if (nodos == Math.pow(2,raiz.getAltura()) - 1){
        return true;
      } else{
        return false;
      }
    }


    public void equilibrar(NodoArbol<E> rev){

      NodoArbol<E> P = null,Q = null;
      while(rev.getFe()<=1 && rev.getFe()>=-1){
        rev = rev.getPadre();
      }
      P = rev;
      Q = P.getHijoAlto();
      
      if(P.getFe() > 0 && Q.getFe() > 0) {
          //rotar p a la derecha
          P.getPadre().setLadoIzquierdo(Q);
          P.getPadre().getLadoIzquierdo().agregarNodo(P.getNumero());
      }
      if(P.getFe() < 0 && Q.getFe() < 0) {
          // rotar p a la izquierda
          P.getPadre().setLadoDerecho(Q);
          P.getPadre().getLadoDerecho().agregarNodo(P.getNumero());
          
      }
      if(P.getFe() > 0 && Q.getFe() < 0) {
          //rotar p a la derecha
          //rotar q a la izquierda
          System.out.println("sapa perra");
      }
      if(P.getFe() < 0 && Q.getFe() > 0){
          //rotar p a la izquierda
          //rotar q a la derecha
      }


    }

    public void agregarNodo(E dato){
      if(raiz == null){
        raiz = new NodoArbol<E>(dato, null);
      }else{
        NodoArbol<E> nodo = raiz.agregarNodo(dato);
        raiz.calcularAltura();
        if(raiz.calcularFE()){
          equilibrar(nodo);
          System.out.println("desequilibrado en "+dato);
        }
      }
    }

    public void recorrerIRD(){
      raiz.recorrerIRD();
    }

    public void recorrerRID(){
      raiz.recorrerRID();
    }

    public void recorrerDRI(){
      raiz.recorrerDRI();
    }

    public void recorrerRDI(){
      raiz.recorrerRDI();
    }
    

   
    
}
