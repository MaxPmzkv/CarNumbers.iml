import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String chars[] = new String[]{"А","В","Е","К","М","Н","О","Р","С","Т","У","Х"};

        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < 10; j++) {
                for(int k = 1; k < 200;k++){
                    String currChar = chars[i];
                    String reg = String.valueOf(k);
                    if(k < 10){
                        reg = "0"+reg;
                    }
                    String number = String.format("%s%d%d%d%s%s%s", currChar, j, j, j, currChar, currChar, reg);
                    System.out.println(number);
                    list.add(number);
                }

            }
        }
        long start = System.currentTimeMillis();
        for (int i = 100; i <= 999; i+=100) {
            for (int j = 0; j < chars.length; j++) {
                for (int j2 = 0; j2 < chars.length; j2++) {
                    for (int k = 0; k < chars.length; k++) {
                        for (int r = 0; r < 200; r++) {
                            String reg = String.valueOf(r);
                            if(r < 10){
                                reg = "0"+reg;
                            }
                           StringBuilder sb = new StringBuilder();
                            sb.append(chars[j]);
                            sb.append(i);
                            sb.append(chars[j2]);
                            sb.append(chars[k]);
                            sb.append(reg);
                            System.out.println(sb.toString());
                            list.add(String.valueOf(sb));

//                            String number = String.format("%s%d%s%s%s", chars[j], i, chars[j2], chars[k], reg);
//                            System.out.println(number);
//                            list.add(number);

//                            String num = chars[j] + i + chars[j2] + chars[k] + reg;
//                            System.out.println(num);
//                            list.add(num);


                        }
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Время создания списка номеров: " + (end - start));


        Collections.sort(list);
        HashSet<String> set = new HashSet<>(list);
        TreeSet<String> set1 = new TreeSet<>(list);
        while (true) {
            System.out.println("Введите номер для поиска");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            long a = System.nanoTime();
            if (list.contains(number)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            long b = System.nanoTime();
            if (Collections.binarySearch(list, number) >= 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            long c = System.nanoTime();
            if (set.contains(number)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            long d = System.nanoTime();
            if (set1.contains(number)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            }
        }
    }
}