//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {






    public static void main(String[] args) {
        StudentsList list = new StudentsList();

        list.add("Alice", 78);
        list.add("Bob", 82);
        list.add("Alice", 91);
        list.add("David", 76);
        list.add("Bob", 89);

        StudentsList[] arr = list.toArray();
        list.mergeSort(arr, 0, arr.length - 1);
        list.displayTopStudents(arr);

    }

    }
