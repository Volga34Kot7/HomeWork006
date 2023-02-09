// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
// Например: “Введите цифру, соответствующую необходимому критерию: 
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class program {

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "4", "1000", "Windows", "grey");
        Notebook notebook2 = new Notebook("Asus", "4", "1000", "Linux", "black");
        Notebook notebook3 = new Notebook("Asus", "4", "2000", "Windows", "black");
        Notebook notebook4 = new Notebook("MacBook", "16", "1000", "Mac", "grey");
        Notebook notebook5 = new Notebook("Huawei", "8", "1000", "Windows", "black");

        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
                notebook3, notebook4, notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out.print("You want to choose a criterion?(y/n): ");
            String question = scanner();
            if (question.equals("n")) {
                break;
            } else if (question.equals("y")){

                System.out.println(
                        "Enter the number corresponding to the required criteria: \n 1 - Title \n 2 - RAM \n 3 - Railway volume \n 4 - Operating system \n 5 - Colour");
                String key = scanner();
                System.out.println("Enter the values for the selected criterion: ");
                String value = scanner();

                resultCriterias.put(key, value);
            }else{
                System.out.println("Error");
            }
        }
        System.out.println(resultCriterias);
        return resultCriterias;

    }

    public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) {

        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {

            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                for (Object pair1 : criterias.keySet()) {

                    if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                        temp.remove(notebook);

                    }
                    for (Object pair2 : criterias.keySet()) {

                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                            temp.remove(notebook);

                        }
                        for (Object pair3 : criterias.keySet()) {

                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                                temp.remove(notebook);

                            }
                            for (Object pair4 : criterias.keySet()) {

                                if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                                    temp.remove(notebook);

                                }
                            }
                        }
                    }
                }
            }

        }
        if (temp.isEmpty()) {
            System.out.println("Nothing was found according to the entered criteria!");
            selectCriteria();
        } else {
            System.out.print("Here's what we can offer: \n" + temp.toString() + "\b ");
        }

    }

}