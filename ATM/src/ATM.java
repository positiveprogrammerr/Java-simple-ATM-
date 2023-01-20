import java.lang.reflect.Executable;
import java.util.*;
import java.util.regex.*;

import static java.lang.System.exit;
import static java.lang.System.inheritedChannel;

public class ATM {


    Scanner scanner = new Scanner(System.in);
    private String name;
    private Map<String,String> stringStringMap = new HashMap<>();
    private Map<String,Double> money_map = new HashMap<>();
    private List<String>loginlist = new LinkedList<>();

    public ATM(String name) {
        this.name = name;
    }
public void print(){
    System.out.println("Welcome to ATM");
    System.out.println("0.Registration page");
    System.out.println("1.Login page\n100.Exit program");
}

       public void log(){
               System.out.println("At present, Uzbekistan has six operators of mobile communications.\nChoose one of them: ");
               System.out.println("2.Beeline\n3.Ucell\n4.MobiUz\n5.Uzmobile\n6.Perfectum\n7.Humans\n100.Exit program");
    }
    public void choose_log(){
        try {
            System.out.print("Enter operation number: ");
            int num = Integer.parseInt(scanner.nextLine());
            if (num==0||num==1 || num==100){
                switch (num) {
                    case 0 -> RegistrationForMoneyPage();
                    case 1 -> Login();
                    case 100 -> System.exit(0);
                    default -> throw new IllegalStateException("Unexpected value: " + num);
                }}}
        catch(Exception e){
        System.out.println("Wrong!");
    }}

    public void choose(){
        try {
            System.out.print("Enter operation number: ");
            int num =scanner.nextInt();
            if (num<=8&&-1<num || num==100) {
                switch (num) {
                    case 2 -> CheckBeeline();
                    case 3 -> CheckUcell();
                    case 4 -> CheckMobiUz();
                    case 5 -> CheckUzmobile();
                    case 6 -> CheckPerfectum();
                    case 7 -> CheckHumans();
                    case 100 -> System.exit(0);
                    default -> throw new IllegalStateException("Unexpected value: " + num);
                }
            }}catch (Exception e){
            System.out.println("Wrong!");
        }}



    public void RegistrationForMoneyPage() {
        try {
            System.out.print("Enter your username: ");
            String user = scanner.nextLine();
            if (isValidUsername(user)) {
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                if (isValid(password)) {
                    System.out.println("Password accepted");
                    System.out.println("Successful registration");
                    stringStringMap.put(user, password);
                    Login();
                } else {
                    while(true) {
                        System.out.println("Invalid Password");
                        System.out.print("Enter your password: ");
                        String pass = scanner.nextLine();
                        if (isValid(pass)) {
                            System.out.println("Password accepted");
                            System.out.println("Successful registration");
                            stringStringMap.put(user, pass);
                            Login();
                            break;
                        }
                    }

                }
            }
            else {
                System.out.println("Wrong Username!");
                RegistrationForMoneyPage();
            }
        }catch (Exception e){
            System.out.println("Wrong!");
            RegistrationForMoneyPage();
        }

    }
    public static boolean isValidUsername(String name)
    {

        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (name == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(name);

        // Return if the username
        // matched the ReGex
        return m.matches();
    }

    public void Login() {
        System.out.print("Enter your username: ");
        String user = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (stringStringMap.containsKey(user) && stringStringMap.get(user).equals(password)) {
            loginlist.add(user);
                System.out.print("Enter your money: ");
                double m = scanner.nextDouble();
                money_map.put(user,m);
        }else{
            System.out.println("Wrong login!");
            Login();
        }
        {
            log();
        }
        choose();



    }


    public static boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        } else {
            char c;
            int count = 1;
            for (int i = 0; i < password.length() - 1; i++) {
                c = password.charAt(i);
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                } else if (Character.isDigit(c)) {
                    count++;
                    if (count < 2)   {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void CheckBeeline(){
            System.out.print("Enter number(+998): ");
            int num = scanner.nextInt();
            String temp = Integer.toString(num);
            char[] newGuess = temp.toCharArray();
            if (((newGuess[0] == '9' && newGuess[1] == '0')||(newGuess[0] == '9' && newGuess[1] == '1')) && temp.length() == 9 ) {
                System.out.println("Your phone number has been accepted..");
                pay(num);
            } else {
                System.out.println("Wrong Beeline code");
                CheckBeeline();
            }
        }

    public void pay(int num) {
        System.out.print("Enter the amount of money you want to pay: ");
        int amount = scanner.nextInt();
        if (money_map.get(loginlist.get(loginlist.size() - 1)) >= amount) {
            System.out.println("Paid successfully");
            money_map.put(loginlist.get(loginlist.size() - 1), money_map.get(loginlist.get(loginlist.size() - 1)) - amount);
            info(num,amount);
            log();
            choose();
        } else if (money_map.get(loginlist.get(loginlist.size() - 1)) < amount) {
            System.out.println("You haven't got so much money!");
            pay();
        }else{
            pay();
        }
    }
    public void pay() {
        System.out.print("Enter the amount of money you want to pay: ");
        int amount = scanner.nextInt();
        if (money_map.get(loginlist.get(loginlist.size() - 1)) >= amount) {
            System.out.println("Paid successfully");
            money_map.put(loginlist.get(loginlist.size() - 1), money_map.get(loginlist.get(loginlist.size() - 1)) - amount);
        } else if (money_map.get(loginlist.get(loginlist.size() - 1)) < amount){
            System.out.println("You haven't got so much money!");
            pay();
        }else {
            System.out.println("Wrong!!");
        }
    }



    public void CheckUcell(){
        try{
            System.out.print("Enter number(+998): ");
            int num = scanner.nextInt();
            String temp = Integer.toString(num);
            char[] newGuess = temp.toCharArray();
            if (temp.length() == 9 && (newGuess[0] == '9' && newGuess[1] == '3') ||
                    (newGuess[0] == '9' && newGuess[1] == '4')) {
                System.out.println("Your phone number has been accepted..");
                    pay(num);
            }
        else {
            System.out.println("Wrong Ucell code");
            CheckUcell();
        }} catch (Exception e){
            System.out.println("Wrong!");
            CheckUcell();
        }
    }

    public void CheckMobiUz() {
        try {
            System.out.print("Enter number(+998): ");
            int num = scanner.nextInt();
            String temp = Integer.toString(num);
            char[] newGuess = temp.toCharArray();
            if (temp.length() == 9 && newGuess[0] == '9' && newGuess[1] == '7' ||
                    newGuess[0] == '8' && newGuess[1] == '8') {
                System.out.println("Your phone number has been accepted..");
                pay(num);
            }

         else{
            System.out.println("Wrong MobiUz code");
            CheckMobiUz();
        }

    }catch (Exception e){
            System.out.println("Wrong!");
            CheckMobiUz();
        }
    }

    public void CheckUzmobile() {
        try {
            System.out.println("Chose type of your number (GSM - 1)(CDMA - 2)");
            System.out.println("Enter: ");
            int c = scanner.nextInt();
            if (c == 1) {
                System.out.print("Enter number(+998): ");
                int num = scanner.nextInt();
                String temp = Integer.toString(num);
                char[] newGuess = temp.toCharArray();
                if (newGuess.length == 9 && newGuess[0] == '9' && newGuess[1] == '5') {
                    System.out.println("Your phone number has been accepted..");
                        pay(num);
                }
                }
                else {
                    System.out.println("Wrong Uzmobile code");
                    CheckUzmobile();
            }
            if (c == 2) {
                System.out.print("Enter number(+998): ");
                int num = scanner.nextInt();
                String temp = Integer.toString(num);
                char[] newGuess = temp.toCharArray();
                if (temp.length() == 9 && newGuess[0] == '9' && newGuess[1] == '9') {
                    System.out.println("Your phone number has been accepted..");
                    System.out.print("Do you pay by card or cash(cash - 1 | card - 2): ");
                    int c2 = scanner.nextInt();
                    if (c2 == 1) {
                        pay(num);
                    }
                    else {
                        System.out.println("Wrong number!!");
                        CheckUzmobile();
                }
            }else {
                    System.out.println("Wrong Uzmobile code");
                    CheckUzmobile();
                }
        }} catch (Exception e) {
            System.out.println("Wrong!");
            CheckUzmobile();
        }
    }
    public void info(int num,int num2){
        System.out.println("\n--------------------Your Chek----------------------");
        System.out.println(num2 +" is payed to "+num+" number.\nYour money is "+money_map.get(loginlist.get(loginlist.size() - 1))+"\n");
        {
            log();
        }
        choose();
    }

    public void CheckPerfectum(){
        try{
            System.out.print("Enter number(+998): ");
            int num = scanner.nextInt();
            String temp = Integer.toString(num);
            char[] newGuess = temp.toCharArray();
            if (temp.length() == 9 && newGuess[0] == '9' && newGuess[1] == '8') {
                System.out.println("Your phone number has been accepted..");
                pay(num);
            }
            else {
                System.out.println("Wrong Perfectum code");
                CheckPerfectum();
        }

        }
        catch (Exception e){
            System.out.println("Wrong!");
            CheckPerfectum();
        }
    }

    public void CheckHumans() {
        try {
            System.out.print("Enter number(+998): ");
            int num = scanner.nextInt();
            String temp = Integer.toString(num);
            char[] newGuess = temp.toCharArray();
            if (temp.length() == 9 && newGuess[0] == '3' && newGuess[1] == '3') {
                System.out.println("Your phone number has been accepted..");
                pay(num);
            } else {
                    System.out.println("Wrong Humans code");
                    CheckHumans();
                }
            } catch(Exception e){
            System.out.println("Wrong!");
            CheckHumans();
        }
    }


    }


