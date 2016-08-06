
package peluchito;

import java.util.Scanner;


public class Producto {
    //Atributos
    private String nombre;
    private int cantidad,precio;
    private Scanner lector;
    int pointer=0;
    //Producto(String name, int cant, String price){

    //}  
    //Métodos
    public void Agregar_Producto(){
      lector = new Scanner(System.in);
      System.out.print("Agregar nombre producto: ");
      nombre = lector.next();
      System.out.print("Agregar cantidad producto: ");
      cantidad = lector.nextInt();
      System.out.print("Agregar precio producto: ");
      precio = lector.nextInt();
      pointer++;
    }
    
    public void Mostrar(){
        System.out.print("El nombre del producto es :"+nombre);
        System.out.print("EL precio del producto es :"+precio);
        System.out.print("la cantidad de producto es :"+cantidad);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   

    
}
