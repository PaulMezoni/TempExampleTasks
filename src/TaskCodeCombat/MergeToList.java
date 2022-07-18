package TaskCodeCombat;

import java.util.Arrays;

public class MergeToList {
    public static void main(String[] args) {
//        List<Integer> list1 = List.of(1, 2, 4);
//        List<Integer> list2 = List.of(1, 3, 4);
        int[] list1 = {1, 2, 3, 5, 3, 2, 3};
        int[] list2 = {2, 2, 4};
        int length = list2.length - list1.length;

        System.out.println(Arrays.toString(mergeTwoLists(list1, list2)));
    }

    static int[] mergeTwoLists(int[] list1, int[] list2) {
        int[] list;
        int length;

        if (list1.length == 0 || list2.length == 0 || list1.length == list2.length) {
            return new int[]{-1};
        }
        if (list1.length > list2.length) {
            length = list1.length - list2.length;
            list = new int[length];
            for (int i = 0; i < list1.length; i++) {
                if (length > 0) {
                    list[i] += list1[list1.length - 1 - i];
                    length--;
                }
            }
        } else {
            length = list2.length - list1.length;
            list = new int[length];
            for (int i = 0; i < list2.length; i++) {
                if (length > 0) {
                    list[i] += list2[i];
                    length--;
                }
            }
        }
        return list;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
