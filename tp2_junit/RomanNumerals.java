package tp2_junit;

public class RomanNumerals {
	
	public static int toInteger(String text){
		return text.chars().map(RomanNumerals::toIntegerLetter).sum();
	}
	
	public static int toIntegerLetter(int text) {
		switch(text) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		default :
			throw new IllegalArgumentException("unknow "+text);
		}
	}
	
    public static String ToRomanNumerals(int number) {
        StringBuilder str = new StringBuilder("");
        int temp = number;
        while(temp > 0) {

            if (temp >= 100) {
                str.append("C");
                temp -= 100;
            }
            if(temp >= 90 && temp < 100){
                str.append("XC");
                temp -= 90;
            }
            if (temp >= 50 && temp < 90) {
                str.append("L");
                temp -= 50;
            }
            if(temp >= 40 && temp < 50){
                str.append("XL");
                temp -= 40;
            }
            if (temp >= 10 && temp < 40) {
                str.append("X");
                temp -= 10;
            }
            if(temp >= 9 && temp < 10){
                str.append("IX");
                temp -= 9;
            }
            if (temp >= 5 && temp < 9) {
                str.append("V");
                temp -= 5;
            }
            if(temp >= 4 && temp < 5){
                str.append("IV");
                temp -= 4;
            }
            if (temp >= 1 && temp < 4) {
                str.append("I");
                temp -= 1;
            }
        }

        return str.toString();
    }

	
}
