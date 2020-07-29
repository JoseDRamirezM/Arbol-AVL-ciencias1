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
public class NodoArbol<E> {
    
    private E numero;
    private NodoArbol<E> ladoIzquierdo;
    private NodoArbol<E> ladoDerecho;
    NodoArbol<E> padre;
    int altura, fe;
    private int esHijo; //-1 Izquierdo, 0 Raiz, 1 Derecho

    public NodoArbol(E n, NodoArbol<E> padre){
      this.numero = n;
      this.padre = padre;
      this.ladoIzquierdo=null;
      this.ladoDerecho=null;
    }

    public NodoArbol<E> getPadre(){
      return padre;
    }

    public NodoArbol<E> getHijoAlto(){
      try {
        if (getLadoDerecho().getAltura() > getLadoIzquierdo().getAltura()) {
          return getLadoDerecho();
        }
      } catch (NullPointerException e){
          if(getLadoDerecho() != null){
              return getLadoDerecho();
          }
      }
      return getLadoIzquierdo();
    }

    public NodoArbol<E> agregarNodo(E dato){
      if(((Comparable<E>)dato).compareTo(getNumero())>=0){
        if( getLadoDerecho()==null){
                setLadoDerecho(new NodoArbol<E>(dato, this));
          return getLadoDerecho();
        }else{
          return getLadoDerecho().agregarNodo(dato);
        }
      }else{
        if( getLadoIzquierdo()==null){
                setLadoIzquierdo(new NodoArbol<E>(dato, this));
          return getLadoIzquierdo();
        }else{
          return getLadoIzquierdo().agregarNodo(dato);
        }
      }
    }

    public boolean calcularFE(){
      if(getLadoIzquierdo() != null && getLadoDerecho() != null){
        fe = getLadoIzquierdo().getAltura()-getLadoDerecho().getAltura();
        return getLadoIzquierdo().calcularFE()|getLadoDerecho().calcularFE()|fe>1|fe<-1;
      }
      if(getLadoIzquierdo() == null && getLadoDerecho() == null){
        fe = 0;
        return false;
      }
      if(getLadoDerecho() == null){
        fe = getLadoIzquierdo().getAltura();
        return getLadoIzquierdo().calcularFE()|fe>1|fe<-1;
      }
      if(getLadoIzquierdo() == null){
        fe = -getLadoDerecho().getAltura();
        return getLadoDerecho().calcularFE()|fe>1|fe<-1;
      }
      return false;
    }

    public int getAltura(){
      return altura;
    }

    public int getFe(){
      return fe;
    }
    
    public int calcularAltura(){
      int h = 1;
      try{
        h += Math.max(getLadoIzquierdo().calcularAltura(), getLadoDerecho().calcularAltura());
      }catch(NullPointerException e){
        try{
          h +=  getLadoIzquierdo().calcularAltura();
        }catch(NullPointerException e1){}
        try{
          h +=  getLadoDerecho().calcularAltura();
        }catch(NullPointerException e1){}
      }
      altura = h;
      return altura;
    }
//:)
    public void recorrerIRD(){
      try{
            getLadoIzquierdo().recorrerIRD();
      }catch(Exception e){}
      System.out.println(getNumero());
      try{
            getLadoDerecho().recorrerIRD();
      }catch(Exception e){}
    }

    public void recorrerRID(){
      System.out.println(getNumero());
      try{
            getLadoIzquierdo().recorrerRID();
      }catch(Exception e){}
      try{
            getLadoDerecho().recorrerRID();
      }catch(Exception e){}
    }

    public void recorrerRDI(){
      System.out.println(getNumero());
      try{
            getLadoDerecho().recorrerRID();
      }catch(Exception e){}
      try{
            getLadoIzquierdo().recorrerRID();
      }catch(Exception e){}
    }

    public void recorrerDRI(){
      try{
            getLadoDerecho().recorrerDRI();
      }catch(Exception e){}
      System.out.println(getNumero());
      try{
            getLadoIzquierdo().recorrerDRI();
      }catch(Exception e){}
    }

    public int cantidadHijos(){
      int cantidad = 0;
      if (getLadoDerecho() != null){
        cantidad += 1 + getLadoDerecho().cantidadHijos();
      }
      if (getLadoIzquierdo() != null){
        cantidad += 1 + getLadoIzquierdo().cantidadHijos();
      }
      return cantidad;
    }

    //Indica si un nodo esta lleno
    public boolean nodoLLeno(){
      if (getLadoDerecho() != null && getLadoIzquierdo() != null){
        return true;
      } else if(getLadoDerecho() == null && getLadoIzquierdo() == null){
        return true;
      }
      return false;
    }  

    /**
     * @return the numero
     */
    public E getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(E numero) {
        this.numero = numero;
    }

    /**
     * @return the ladoIzquierdo
     */
    public NodoArbol<E> getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    /**
     * @param ladoIzquierdo the ladoIzquierdo to set
     */
    public void setLadoIzquierdo(NodoArbol<E> ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    /**
     * @return the ladoDerecho
     */
    public NodoArbol<E> getLadoDerecho() {
        return ladoDerecho;
    }

    /**
     * @param ladoDerecho the ladoDerecho to set
     */
    public void setLadoDerecho(NodoArbol<E> ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }

    /**
     * @return the esHijo
     */
    public int getEsHijo() {
        return esHijo;
    }

    /**
     * @param esHijo the esHijo to set
     */
    public void setEsHijo(int esHijo) {
        this.esHijo = esHijo;
    }
    
}
