package TaskCodeCombat;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionDistinct {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 1, 2, 4, 11, 10, 3, 44, 33, 22, 3, 3, 3));
        int[] x = {1, 2, 2, 4, 4, 4, 99};
        int[] x1 = {1, 2, 1, 2, 4, 3, 99};
        int target = 4;
        int index = 1;

        System.out.println(removeDuplicates(list) + " 1 ");
//        System.out.println((removeDuplicates(list)));
        System.out.println(Arrays.toString(removeElement(x, target)));
//        System.out.println(Arrays.toString(addElement(x, target)) + " " + x.length);
//        System.out.println(Arrays.toString(replaceElementByIndex(x, target, index)));
//        System.out.println((((Arrays.toString(searchDuplicateElements(x))))) + " searchDuplicateElements");
//        System.out.println(Arrays.toString(removeDuplicateElements(x)) + " remove_Duplicate_Elements");
        String str = "class=\\\"\\\">110,41 pуб. и менее<\\/td><td align=\\\"right\\\">38271<\\/td><\\/tr><\\/table>\",\"buy_order_summary\":\"Запросов на покупку: <span class=\\\"market_commodity_orders_header_promote\\\">38417<\\/span><br>Начальная цена: <span class=\\\"market_commodity_orders_header_promote\\\">115 pуб.<\\/span>\",\"highest_buy_order\":\"11500\",\"lowest_sell_order\":\"12584\",\"buy_order_graph\":[[115,58,\"Заказов по цене 115 pуб. и выше: 58\"]";
        String str2 = "tr><td align=\\\"right\\\" class=\\\"\\\">803,88 pуб.<\\/td><td align=\\\"right\\\">1<\\/td><\\/tr>< tr><td align=\\\"right\\\" class=\\\"\\\">805,46 pуб. и более<\\/td><td align=\\\"right\\\">235<\\/td><\\/tr><\\/table>\",\"sell_order_summary\":\"Лотов на продажу: <span class=\\\" market_commodity_orders_header_promote\\\">242<\\/span><br>Начальная цена: <span class=\\\"market_commodity_orders_header_promote\\\">799,60 паб.<\\/span>\",\"buy_order_table\":\"<table class=\\\"market_commodity_orders_table \\\"><tr><th align=\\\"right\\\">Цена<\\/th><th align=\\\"right\\\">Кол-во<\\/th><\\/tr><tr><td выровнять=\\\" 5152<\\/td><\\/tr><\\/table>\",\"buy_order_summary\":\"Запросы на покупку: <span class=\\\"market_commodity_orders_header_promote\\\">5178<\\/span><br>Начальная цена: < span class=\\\"market_commodity_orders_header_promote\\\">722,43 паб.<\\/span>\",\"highest_buy_order\":\"72243\",\"lowest_sell_order\":\"79960\",\"buy_order_graph\":[[722.43,1,\"Заказов по цена 722,43 паб. и выше: 1\"],[719.78,2,\"Заказов по цене 719,78 паб. и выше: 2\"],[717.57,3,\"Заказов по цене 717,57 паб. и выше: 3\"],[716.84,12,\"Заказов по цене 716,84 паб. и выше: 12\"],[707.32,26,\"Заказов по цене 707,32 паб. и выше: 26\"],[701.46,32,\"Заказов по цене 701,46 паб. и выше: 32\"],[697.82,36,\"Заказов по цене 697, 82 паб. и выше: 36\"],[695.61,41,\"Заказов по цене 695,61 паб. и выше: 41\"],[694.15,50,\"Заказов по цене 694,15 паб. и выше: 50\"],[693.41,55,\"Заказов по цене 693,41 паб. и выше: 55\"],[692.68,58,\"Заказов по цене 692,68 паб. и выше: 58\"],[691.22,220,\"Заказов по цене 691,22 паб. и выше: 220\",[690.49,235,\"Заказов по цене 690,49 паб. и выше: 235\"],[687.55,268,\"Заказов по цене 687,55 паб. и выше: 268\"],[686.82,273,\"Заказов по цене 686,82 паб. и выше: 273\"],[683.16,277,\"Заказов по цене 683,16 паб. и выше: 277\"],[681.74,280,\"Заказов по цене 681,74 паб. и выше: 280\",[681.69,281,\"Заказов по цене 681,69 паб. и выше: 281\"],[679.5,300,\"Заказов по цене 679,50 паб. и выше: 300\"],[676,310,\"Заказов по цене 676 паб. и выше: 310\"], Заказов по цене 654,46 паб. и выше: 503\"],[653.14,504,\"Заказов по цене 653,14 паб. и выше: 504\"],[652.41,507,\"Заказов по цене 652,41 паб. и выше: 507\"],[651.96,510,";
//        System.out.println((parserString(str)));
//        System.out.println(("2 method " + parserString2(str)));
    }

    static String parserString(String doc) {
        System.out.println("     " + doc);

        String[] arr = doc.split("Запросов на покупку:");
//        String[] arr = doc.split("market_commodity_orders_header_promote:");
        System.out.println("arr " + Arrays.toString(arr));

        String[] arr2 = arr[1].split("span");
        System.out.println("arr2 " + Arrays.toString(arr2));
        System.out.println("arr2 " + arr2[3]);

        String[] arr3 = arr2[3].split("\">");
        System.out.println("arr3 " + Arrays.toString(arr3));

        String[] arr4 = arr3[1].split(" ");
        System.out.println("arr4 " + Arrays.toString(arr4));

        return arr4[0].trim().replace(",", ".");

    }

    static String parserString2(String doc) {
        return null;
//        return Arrays.toString(Arrays.stream(str.split("Запросов на покупку:"))
//                .map(s -> s.split("span"))
//                        .collect(Collectors.toList()).get(1)
//                .collect(Collectors.toList()).get(1)).trim().replace(",", ".");
//                Arrays.stream(doc.equals("market_commodity_orders_header_promote"))
//                .map(str -> str.split("market_commodity_orders_header_promote"))
//                .collect(toMap(str -> str[0], str -> str[1]));
    }


    // сделать методы - удаление элемента из массива, добавление, удаление дубликатов
    static int[] replaceElementByIndex(int[] list, int element, int index) {
        int i = 0;
        while (i < list.length) {
            if (i == index) {
                list[i] = element;
                break;
            } else {
                i++;
            }
        }
        return list;
    }

    static int[] addElement(int[] list, int element) {
        int[] x = new int[list.length + 1];
        int i;
        for (i = 0; i < list.length; i++) {
            x[i] += list[i];
        }
        x[i] += element;
        return x;
    }

    public static int[] searchDuplicateElements(int[] arr) {
        return new int[arr.length];
    }

    public static int[] removeDuplicateElements(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static int[] removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            }
        }
        int offset = 0;
        int[] newArr = new int[count];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                newArr[i - offset] += nums[i];
            } else {
                offset++;
            }
        }
        return newArr;
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection).stream().sorted().collect(Collectors.toList());
    }

}
