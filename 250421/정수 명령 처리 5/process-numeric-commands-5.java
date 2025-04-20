import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");

            if(parts[0].equals("push_back")) {
                int target = Integer.parseInt(parts[1]);
                list.add(target);
            }
            else if(parts[0].equals("pop_back")) {
                list.remove(list.size() - 1);
            }
            else if(parts[0].equals("size")) {
                System.out.println(list.size());
            }
            else if(parts[0].equals("get")) {
                int target = Integer.parseInt(parts[1]) - 1;
                System.out.println(list.get(target));
            }
        }
    }
}