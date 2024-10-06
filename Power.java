public class Power {
    public static boolean PowerOfThree(int num) {
       
        if(num == 3) {
        
        return true;
       }
       if(num == 0) {
        return false;
       }
       return PowerOfThree(num/3);
        
        
    }
    public static void main(String[] args) {
        System.out.println(PowerOfThree(45));
       
    }
}
