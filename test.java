public class test {
    public static void main(String[] args) 
    {
        int num = 53;   // 51을 넣었을 때 과제 예시처럼 "AZ"가 나오는지 확인한 것.
        System.out.println(decimalToAlphabetBase(num));
    }

    public static String decimalToAlphabetBase(int num)
    {
        String res = "";
        int ch;
        do
        {
            ch = num % 26 + 'A';  
            num /= 26;
            if (num == 0)
                res += (char) (ch - 1);
            else
                res += (char) ch;
        }   
        while(num > 0);

        return (reverseString(res));
    }

    public static String reverseString(String original)
    {
        String ret = "";
        int idx = original.length() - 1;
        
        while (idx >= 0)
        {
            ret += original.charAt(idx);
            idx--;
        }
        return ret;
    }
}
