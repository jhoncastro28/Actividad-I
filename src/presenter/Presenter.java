package presenter;

import java.util.ArrayList;
import view.View;
import model.Matriz;

public class Presenter {

    View view;
    Matriz matriz;

    public Presenter() {
        view = new View();
        matriz = new Matriz();
    }
    
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.readData();
    }

    public void readData() {
        int filas = Integer.parseInt(view.readData("Ingrese el número de filas: "));
        int columnas = Integer.parseInt(view.readData("Ingrese el número de columnas: "));

        for (int i = 0; i < filas; i++) {
            matriz.getMatriz().add(new ArrayList<>());
            for (int j = 0; j < columnas; j++) {
                int value = Integer.parseInt(view.readData("Ingrese el valor para la posición (" + (i + 1) + "," + (j + 1) + "): "));
                matriz.getMatriz().get(i).add(value);
            }
        }

        view.showMatrizTranspuesta("Matriz Original", matriz.getMatriz());

        int option = 0;
        do {
            try {
                option = view.menu();
                switch (option) {
                    case 1:
                        ArrayList<ArrayList<Integer>> matrizTranspuesta = matriz.calcularMatrizTranspuesta(matriz.getMatriz());
                        view.showMatrizTranspuesta("Matriz Transpuesta", matrizTranspuesta);
                        break;
                    case 2:
                        readData();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        view.showMessage("Programa finalizado");
                }
            } catch (NumberFormatException e) {
                view.showMessage("¡Opción inválida!");
            }
        } while (option != 4);

    }
}
