public class test {
    public static void main(String[] args) 
    {
        int num = 51;   // 51을 넣었을 때 과제 예시처럼 "AZ"가 나오는지 확인한 것.
        System.out.println(decimalToAlphabetBase(num));
    }

    public static String decimalToAlphabetBase(int num)
    {
        String res = "";
        int i = 0;

        do
        {
            int ch = num % 26 + 'A' - i;
            num /= 26;
            res += (char) ch;
            i++;
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
