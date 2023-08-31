package ordenamientoDouble;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int opcion, n;
        Double[] randomArray = null;
        long startTime;
        long endTime;
        do {
            menu();
            opcion = Integer.parseInt(consola.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de numeros que desea tener en el arreglo.\n");
                    n = Integer.parseInt(consola.nextLine());
                    randomArray = generarArreglo(n);
                    break;
                case 2:
                    try {
                        startTime = System.nanoTime();
                        randomArray = insercion(randomArray);
                        endTime = System.nanoTime();
                        System.out.println("El metodo de insercion tardo " + (endTime-startTime) + " nanosegundos.\n");
                        imprimirArray(randomArray);
                    } catch (Exception e) {
                        System.out.println("El arreglo no fue inicializado.\nElija la opcion 1 para inicializarlo.\n");
                        break;
                    }
                    break;
                case 3:
                    try {
                        startTime = System.nanoTime();
                        randomArray = shellsort(randomArray);
                        endTime = System.nanoTime();
                        System.out.println("El metodo de shellsort tardo " + (endTime-startTime) + " nanosegundos.\n");
                        imprimirArray(randomArray);
                    } catch (Exception e) {
                        System.out.println("El arreglo no fue inicializado.\nElija la opcion 1 para inicializarlo.\n");
                        break;
                    }
                    break;
                case 4:
                    try {
                        startTime = System.nanoTime();
                        randomArray = quicksort(randomArray, 0, randomArray.length - 1);
                        endTime = System.nanoTime();
                        System.out.println("El metodo de quicksort tardo " + (endTime-startTime) + " nanosegundos.\n");
                        imprimirArray(randomArray);
                    } catch (Exception e) {
                        System.out.println("El arreglo no fue inicializado.\nElija la opcion 1 para inicializarlo.\n");
                        break;
                    }
                    break;
                case 0:
                    System.out.println("Adios.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);
        consola.close();
    }

    public static void menu() {
        System.out.println("Ingrese una opcion.");
        System.out.println("1)Generar arreglo con numeros random.");
        System.out.println("2)Ordenar arreglo por insercion.");
        System.out.println("3)Ordenar arreglo por shellsort");
        System.out.println("4)Ordenar arreglo por quicksort.");
        System.out.println("0)Salir.\n");
    }

    public static Double[] generarArreglo(int n) {
        Double[] randomArray = new Double[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(1000)+random.nextDouble();
        }
        return randomArray;
    }

    public static Double[] insercion(Double[] a) {
        Double aux;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    aux = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = aux;
                }
            }
        }
        return a;
    }

    public static Double[] shellsort(Double[] a) {
        for (int i = (a.length) / 2; i > 0; i = i / 2) {

            for (int j = i; j < (a.length); j++) {
                int k;
                Double aux = a[j];

                for (k = j; k >= i && a[k - i] > aux; k = k - i) {
                    a[k] = a[k - i];
                }

                a[k] = aux;
            }
        }
        return a;
    }

    public static Double[] quicksort(Double[] item, int left, int right) {
        int i, j;
        Double temp;
        i = left;
        j = right;
        do {
            while (item[j] > item[i] && j > i)
                j--;
            if (i < j) {
                temp = item[i];
                item[i] = item[j];
                item[j] = temp;
                i++;
            }
            while (item[i] < item[j] && i < j)
                i++;
            if (i < j) {
                temp = item[i];
                item[i] = item[j];
                item[j] = temp;
                j--;
            }
        } while (i < j);
        if (left < j)
            quicksort(item, left, j - 1);
        if (i < right)
            quicksort(item, i + 1, right);
        return item;
    }

    public static void imprimirArray(Double[] a) {
        System.out.println("Arreglo ordenado:\n");
        for (Double i : a) {
            System.out.println(i);
        }
    }
}
