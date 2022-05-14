
public class test_cbtarr {
    public static void main(String[] args) 
    {
        CBT_array arr = new CBT_array(10);
        StringBuilder sb = new StringBuilder();
        
        arr.levelOrderTraverse(sb, 0);
        System.out.print(sb);
    }    
}
