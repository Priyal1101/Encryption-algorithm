import java.util.*;
class Krypton
{
    //function to generate key
    static String generatekey(String str, String keyword)
    {
        int x = str.length();

        for(int i=0;i<x;i++)
        {
            if(keyword.length()==str.length())
            {
                break;
            }
            else
            {
                keyword+=keyword.charAt(i);
            }
        }
        return keyword;
    }

    //function to encrypt text
    static String encrypttext(String str, String keyword, int shift)
    {
        String cipher_text="";

        for(int i=0;i<str.length();i++)
        {
            int x = (str.charAt(i) + keyword.charAt(i) + (char)shift) % 26;

            x+='A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    //function to return original text after encryption
    static String decrypttext(String cipher_text, String keyword, int shift)
    {
        String original_text="";

        for(int i=0;i<cipher_text.length() && i<keyword.length();i++)
        {
            int x = (cipher_text.charAt(i) - (char)shift - keyword.charAt(i) + 26) % 26;

            x+='A';

            original_text+=(char)(x);
        }
        return original_text;
    }

    //function to convert text to uppercase
    static String LowertoUpper(String s)
    {
        StringBuffer str=new StringBuffer(s);
        for(int i=0;i<s.length();i++)
        {
            if(Character.isLowerCase(s.charAt(i)))
            {
                str.setCharAt(i,Character.toUpperCase(s.charAt(i)));
            }
        }
        s=str.toString();
        return s;
    }

    //main function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted:");
        String text = sc.nextLine();
        String Keyword = "KRYPTON";
        int shiftkey = 4;

        String str = LowertoUpper(text);
        String key = LowertoUpper(Keyword);

        String keyword = generatekey(str, key);
        String cipher_text = encrypttext(str, keyword, shiftkey);

        System.out.println("Encrypted text: "+cipher_text);
        System.out.println("Original text: "+decrypttext(cipher_text, keyword, shiftkey));
    }
}