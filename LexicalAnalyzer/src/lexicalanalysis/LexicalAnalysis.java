
/*
Author: Lindster Carlo A. Catalma
Email: LindsterCatalma@gmail.com
*/
package lexicalanalysis;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LexicalAnalysis {

    private static HashMap<String,String> Lexeme = getLexemes();
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String str = "";
        String input;
        
        String s;
        String word;
        
        System.out.print("Enter Statements \n"
                + "Press ENTER twice to proceed to Lexical Analysis \n\n");
        
        do{
            
            input = scan.nextLine();
            if(input.equals("")){
                System.out.println("\nanayzing... \n");
                break;
            }
            else
            {
                str+=input + " ";
            }
        }while(true);

        StringTokenizer token = new StringTokenizer(str);
        
        while(token.hasMoreTokens()){
            s = token.nextToken();
            word = "";
            char[] c = s.toCharArray();
            for(int x = 0 ; x < c.length ; x++){
                
                if (checkSymbol(word)) {
                    System.out.println(word + "\t\t\tkeyword");
                    word = "";
                } else if (checkSymbol(String.valueOf(c[x]))) {
                    if (!word.equals("")) {
                    System.out.println(word + "\t\t\tidentifier");
                    }
                    System.out.println(c[x] + "\t\t\t" + Lexeme.get(String.valueOf(c[x])));
                }
                else{
                    word += c[x];
                }
                
                if (word.equals("cout") && (c[x+1] == '<') && (c[x+2] == '<')) {
                        word = "cout<<";
                        x+=2;
                }
                if (checkSymbol(word)) {
                    System.out.println(word + "\t\t\tkeyword");
                    word = "";
                } 
            }
            
        }
    }
    
    private static boolean checkSymbol(String c){
        
        if (Lexeme.containsKey(c)) {
            return true;
        }
        else{
            return false;
        }
    }
    
   private static HashMap<String,String> getLexemes(){
        HashMap<String,String> lexeme = new HashMap<>();
        lexeme.put("#","header");
        lexeme.put("!","not");
        lexeme.put(";","semicolon");
        lexeme.put(":","colon");
        lexeme.put("?","question mark");
        lexeme.put("\"","quotation mark");
        lexeme.put("'","apostrophe");
        lexeme.put(",","comma");
        lexeme.put(".","period");
        lexeme.put("/","forward slash");
        lexeme.put("\\","backward slash");
        lexeme.put("|","pipe");
        lexeme.put("||","double pipe");
        lexeme.put("&","ampersand");
        lexeme.put("&&","double ampersand");
        lexeme.put("<","left angle");
        lexeme.put("<<","double left angle");
        lexeme.put(">","right angle");
        lexeme.put(">>","double right angle");
        lexeme.put("(","left parenthesis");
        lexeme.put(")","right parenthesis");
        lexeme.put("{","left curly brace");
        lexeme.put("}","right curly brace");
        lexeme.put("[","left square bracket");
        lexeme.put("]","right square bracet");
        lexeme.put("+","addition");
        lexeme.put("-","subtraction");
        lexeme.put("*","multiplication");
        lexeme.put("/","division");
        lexeme.put("%","modulo");
        lexeme.put("=","equal");
        lexeme.put("include","Keyword");
        lexeme.put("iostream","Keyword");
        lexeme.put("using","Keyword");
        lexeme.put("namespace","Keyword");
        lexeme.put("std","Keyword");
        lexeme.put("cout","Keyword");
        lexeme.put("cin","Keyword");
        lexeme.put("return","Keyword");
        lexeme.put("cout<<", "Keyword");
        return lexeme;
    }
}
