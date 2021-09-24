
class Converter {

    static int toArabic(String value) throws Exception {
        if (value.equalsIgnoreCase("I")) return 1;
        if (value.equalsIgnoreCase("II")) return 2;
        if (value.equalsIgnoreCase("III")) return 3;
        if (value.equalsIgnoreCase("IV")) return 4;
        if (value.equalsIgnoreCase("V")) return 5;
        if (value.equalsIgnoreCase("VI")) return 6;
        if (value.equalsIgnoreCase("VII")) return 7;
        if (value.equalsIgnoreCase("VIII")) return 8;
        if (value.equalsIgnoreCase("IX")) return 9;
        if (value.equalsIgnoreCase("X")) {
            return 10;
        } else {
            throw new Exception("введённое число/числа не от 1 до 10");

        }
    }

    static String toRome(Integer num){
        int[] arabDigit = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romeDigit = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<arabDigit.length; i++){
            while((num - arabDigit[i])>=0){
                num -= arabDigit[i];
                result.append(romeDigit[i]);
            }
        }
        return result.toString();
    }
}
