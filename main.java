import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // ask the user how many password they want and the length of the password
        System.out.println("How many random passwords do you want generated?");
        int total = in.nextInt();
        System.out.println("How many characters long do you want them to be?");
        int length = in.nextInt();

        // create an array to store random passwords
        String[] randomPasswords = new String[total];
        // loop through total number of passwords
        for(int i = 0; i < total; i++){
            // generate one random password
            String randomPassword="";
            for(int j = 0; j < length; j++){
                // generate one random character
                randomPassword += randomCharacter();
            }

            // add one random password to array
            randomPasswords[i] = randomPassword;
        }

        // print our array of passwords
        printPasswords(randomPasswords);

        // print our password strength
        System.out.println(getPasswordStrength(length));
    }

    public static String getPasswordStrength(int length){
        if(length < 5){
            return "weak";
        } else if(length < 10){
            return "medium";
        } else {
            return "strong";
        }
    }

    public static void printPasswords(String[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static char randomCharacter(){
        // generate a random number that represent all the possible characters in our password
        // 10 digits + 26 uppercase letters + 26 lowercase letters + 10 special characters = 72 possible characters
        int rand = (int)(Math.random()*72);
    
        // break up rand into intervals to represent numbers, uppercase letters, lowercase letters, and special characters
        // rand is between 0 - 71 inclusive 
        // if rand is between 0 and 9 => number
        // if rand is between 10-35 => uppercase
        // if rand is betn 36-61 => lowercase
        // if rand is betn 62-71 => special characters
        if(rand <=9){
            // number: rand is between 0-9 => 48-57 in ASCII
            int ascii = rand + 48; // 48-0=48
            return (char)(ascii);
        }
        else if(rand <= 35){
            // uppercase letter: rand is between 10-35 => 65-90 in ASCII
            int ascii = rand + 55; // 55-10=55
            return (char)(ascii);
        }
        else if(rand <= 61){
            // lowercase letter: rand is between 36-61 => 97-122 in ASCII
            int ascii = rand + 61; // 97-36=61
            return (char)(ascii);
        }
        else {
            // special character: rand is between 62-71 => 33, 35-38, 42, 64, 94, 95 in ASCII
            int[] specialAscii = {33, 35, 36, 37, 38, 42, 64, 94, 95};
            return (char)(specialAscii[rand-62]);
        }
    }
    
}
