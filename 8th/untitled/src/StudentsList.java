import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StudentsList {
    String name;
    int score;
    StudentsList next;

    StudentsList head = null;

    // Add student data to the linked list
    public void add(String name, int score) {
        StudentsList newNode = new StudentsList();
        newNode.name = name;
        newNode.score = score;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            StudentsList current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Convert linked list to array
    public StudentsList[] toArray() {
        List<StudentsList> list = new ArrayList<>();
        StudentsList current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list.toArray(new StudentsList[0]);
    }

    public void mergeSort(StudentsList[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(StudentsList[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        StudentsList[] L = new StudentsList[n1];
        StudentsList[] R = new StudentsList[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].score >= R[j].score) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public void displayTopStudents(StudentsList[] sortedArr) {
        HashSet<String> seen = new HashSet<>();
        for (StudentsList node : sortedArr) {
            if (!seen.contains(node.name)) {
                System.out.println(node.name + ": " + node.score);
                seen.add(node.name);
            }
        }
    }
}