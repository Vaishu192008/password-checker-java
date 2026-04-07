import java.util.*;
public class PasswordChecker {
    public int strength(Password pwdobj,ArrayList<String> suggestions){
        String password=pwdobj.getPassword();
        int score=0;
        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasDigits=false;
        boolean hasSpecial=false;
        HashSet<Character> SpecialChars=new HashSet<>();
        char[] Sp = {'!', '@', '#', '$', '%', '^', '&', '*'};
        for(char c:Sp){
            SpecialChars.add(c);
        }
        if(password.length()>=8) score+=2;
        else suggestions.add("Password should be at least 8 characters long.");
        for(char c:password.toCharArray()){
            if(Character.isUpperCase(c))hasUpper=true;
            if(Character.isLowerCase(c))hasLower=true;
            if(Character.isDigit(c))hasDigits=true;
            if(SpecialChars.contains(c))hasSpecial=true;
        }
        if(hasUpper) score+=2;
        else suggestions.add("Add at least one uppercase letter.");
        if(hasLower)score+=2;
        else suggestions.add("Add at least one lowercase letter.");
        if(hasDigits)score+=2;
        else suggestions.add("Include at least one digit.");
        if(hasSpecial)score+=2;
        else suggestions.add("Include at least one special character.");
        return score;
    }
    public String strengthLevel(int score){
        if(score<=4)return "Weak";
        else if(score<=8)return "Medium";
        else return "Strong";
    }
}
