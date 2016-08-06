package peluchito;

import java.util.Scanner;

public class Ppal {

    //static Producto ArrayProductos[];
    static int Ganancias_Totales;
    static int Total_Total_Ventas[] = new int[10];
    static int total_ventas[] = new int[10];
    static int ventas[] = new int[10];
    static String busca;
    static Scanner lector;
    static int cont = 0;
    static Producto ArrayProductos[] = new Producto[10];

    public static void main(String[] args) {
        //Producto ArrayProductos[] = new Producto[10];
        int seleccion;
        //Scanner lector;
        for (int i = 0; i < ArrayProductos.length; i++) {
            ArrayProductos[i] = new Producto();
        }
        do {
            //int j=0;
            lector = new Scanner(System.in);
            System.out.println("0. Agregar producto");
            System.out.println("1. Buscar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Realizar venta");
            System.out.println("5. Mostrar ganancias totales");
            System.out.println("6. Salir");
            System.out.println("Ingrese número de la opción: ");
            seleccion = lector.nextInt();
            switch (seleccion) {
                case 0:
                    ArrayProductos[cont].Agregar_Producto();
                    cont++;
                    break;
                case 1:
                    Buscar_Producto();
                    break;
                case 2:
                    Eliminar_Producto();
                    break;
                case 3:
                    Mostrar_Inventario();
                    break;
                case 4:
                    Realizar_Venta();
                    break;
                case 5:
                    Mostrar_Ganancias_Totales();
                    break;
            }
        } while (seleccion < 6);
    }

    public static void Buscar_Producto() {
        lector = new Scanner(System.in);
        System.out.print("Digite nombre del producto a buscar: ");
        busca = lector.next();
        int coincidencias = 0;
        //cont=0;
        for (int i = 0; i < cont; i++) {
            if (ArrayProductos[i].getNombre().equals(busca)) {
                System.out.println("El nombre del producto es: " + ArrayProductos[i].getNombre());
                System.out.println("La cantiddad es: " + ArrayProductos[i].getCantidad());
                System.out.println("El precio es: " + ArrayProductos[i].getPrecio() + "$");
                coincidencias++;
            }
        }
        if (coincidencias == 0) {
            System.out.println("El producto no tiene existencias en el inventario");
        }

    }

    public static void Eliminar_Producto() {
        String aux;
        lector = new Scanner(System.in);
        System.out.print("Digite nombre del producto a eliminar: ");
        aux = lector.next();
        int coincidencias = 0;
        for (int i = 0; i < cont; i++) {
            if (ArrayProductos[i].getNombre().equals(aux)) {
                for (int j = i; j < cont; j++) {
                    //System.out.print("Digite nombre del producto a eliminar 2:");
                    ArrayProductos[j] = ArrayProductos[j + 1];
                    coincidencias++;
                }
                cont--;
            }

        }
        if (coincidencias == 0) {
            System.out.println("El producto no tiene existencias en el inventario");
        }

    }

    public static void Mostrar_Inventario() {
        lector = new Scanner(System.in);

        for (int i = 0; i < cont; i++) {
            System.out.println("El nombre del producto es: " + ArrayProductos[i].getNombre());
            System.out.println("La cantiddad es: " + ArrayProductos[i].getCantidad());
            System.out.println("El precio es: " + ArrayProductos[i].getPrecio() + "$");

        }

    }

    public static void Realizar_Venta() {
        String vender;
        //int cant;
        lector = new Scanner(System.in);
        System.out.print("Digite nombre del producto a vender: ");
        vender = lector.next();
        int cant;
        int coincidencias = 0;
        for (int i = 0; i < cont; i++) {
            if (ArrayProductos[i].getNombre().equals(vender)) {
                System.out.print("Digite cantidad a vender: ");
                cant = lector.nextInt();
                int r=ArrayProductos[i].getCantidad()-cant;
                ArrayProductos[i].setCantidad(r);
                ventas[i] = cant; 
                total_ventas[i] = ArrayProductos[i].getPrecio()*cant;
                Total_Total_Ventas[i] = +total_ventas[i];
                Ganancias_Totales = +Total_Total_Ventas[i];
                coincidencias++;
            }

        }
        if (coincidencias == 0) {
            System.out.println("El producto no tiene existencias en el inventario");
        }

    }
    public static void Mostrar_Ganancias_Totales() {
        for (int i = 0; i < cont; i++) {
            System.out.println("El nombre del producto es: " + ArrayProductos[i].getNombre());
            System.out.println("La cantiddad de artículos vendidos es: " + ventas[i]);
            System.out.println("El valor total de la venta del producto es: " + Total_Total_Ventas[i]+"$");
        }
        System.out.println("Las ganancias totales son: " + Ganancias_Totales+"$");
    }
}
