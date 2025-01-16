package com.jspiders.requirement;


public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "Java is a programming language"; 

        System.out.println("Character Frequencies:");

  
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); 
            
           
            if (ch != ' ' && str.indexOf(ch) == i) {
                int count = 1;
                
             
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == ch) {
                        count++;
                    }
                }
                
             
                System.out.println(ch + " - " + count);
            }
        }
    }
}

//write a java program to print the characters presents inside a string along with frequency take a text "Java is a programming language"s
