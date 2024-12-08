package Maths;

public class AddDigits {
    public int addDigits(int num) {
        int temp = num;
        int sum = 0;

        if(num < 10) return num;

        while(temp > 0){
            sum += temp%10;
            temp = temp/10;
            if(temp == 0 && sum>=10) {
                temp = sum;
                sum = 0;
            }
        }
        return sum;
    }
}
