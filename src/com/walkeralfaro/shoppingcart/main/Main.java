package com.walkeralfaro.shoppingcart.main;
import com.walkeralfaro.shoppingcart.extra.Colors;
import com.walkeralfaro.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int balance = inputValue("Ingrese el límite de la tarjeta: ");
        int total = 0;
        ArrayList<Product> productsList = new ArrayList<>();
        String operating = "y";

        while (operating.equals("y")) {

            // Ingresa Producto:
            System.out.println("Escriba la decripción del producto: ");
            String productDescriptionInput = keyboard.nextLine();
            int productValueInput = inputValue("Ingrese el valor del producto: ");

            // Acumular precios de los productos
            total += productValueInput;

            if (balance < total) {
                // Si el nuevo producto sobrepasa el saldo, termina el programa
                System.out.println(Colors.RED + "¡Saldo insuficiente!" + Colors.RESET);
                operating = "n";
            } else {
                // Si el valor del nuevo producto al sumar a los demás no pasa el saldo
                Product product = new Product(productDescriptionInput, productValueInput);
                productsList.add(product);

                System.out.println(Colors.GREEN + "Compra realizada!" + Colors.RESET);
                System.out.println("¿Desea ingresar otro producto? [y/n]: ");
                operating = keyboard.nextLine();
            }
        }

        // Calcular el total gastado
        total = 0;
        for (Product product : productsList) {
            total += product.getPrice();
        }
        // El remanente que queda
        int remain = balance - total;

        // Ordenando la lista de productos
        productsList.sort(Comparator.comparing(Product::getPrice));

        // Salida por consola de los productos comprados
        System.out.println("*******************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (Product product : productsList) {
            System.out.println(product.getDescription() + " - " + product.getPrice());
        }
        System.out.println("\n*******************************\n");
        System.out.println("Saldo en la tarjeta: " + remain);
    }

    private static int inputValue(String textStatement) {
        Scanner keyboard = new Scanner(System.in);
        int valueInput = 0;
        boolean valueValidation = true;
        while (valueValidation) {
            System.out.println(textStatement);
            try {
                valueInput = keyboard.nextInt();
                keyboard.nextLine();
                valueValidation = false;
            } catch (Exception e) {
                System.out.println(Colors.RED + "ERROR: ingrese un monto válido" + Colors.RESET);
                keyboard.nextLine();
            }
        }
        return valueInput;
    }
}
