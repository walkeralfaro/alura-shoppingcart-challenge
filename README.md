# Shopping Cart Challenge

Este es un reto propuesto por la plataforma Alura como parte de su bootcamp de formación de desarrollo web backen con **Java**.

## Solución

### Lógica
Los **productos** son instancias de la clase `Product`, que tiene dos atributos, **description** y **price**, cuando se ingresa por teclado el precio del producto este se guarda en `Product.price()` con el constructor de la clase.

Los productos son almacenados en un Lista `ArrayList` de productos para utilizar la propiedad de ordenamiento `sort`.

### Ordenamiento
Se utilizó la interfaz `Comparator` y su método `comparing`:

```java
productsList.sort(Comparator.comparing(Product::getPrice));
```

### Manejo excepción
Se reutiliza la función **inputValue** que se encarga de verificar que los montos que se ingresan sean número enteros, caso contrario maneja la excepcion:

```java
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
```

### Colores
Se agregó una clase `Colors` que retorna atributos de colores para pintar el texto en consola.


