import java.util.*;
public class PasswordAnalyser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter password:");
        String input=sc.nextLine();
        Password pwd=new Password(input);
        PasswordChecker checker=new PasswordChecker();
        ArrayList<String> suggestions=new ArrayList<>();
        int score=checker.strength(pwd, suggestions);
        String strength=checker.strengthLevel(score);
        System.out.println("\nScore: "+score+"/10");
        System.out.println("Strength: "+strength);
        if(suggestions.isEmpty()){
            System.out.println("Strong Password! No suggestions.");
        }
        else{
            System.out.println("Suggestions:");
            for(String s:suggestions){
                System.out.println("-"+s);
            }
        }
        sc.close();
    }
}