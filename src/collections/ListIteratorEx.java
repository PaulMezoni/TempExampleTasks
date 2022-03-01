package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {
    public static void main(String[] args) {
        String str = "madam";
        List<Character> characterList = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            characterList.add(ch);
        }
        ListIterator<Character> listIterator = characterList.listIterator();
        ListIterator<Character> reverseList = characterList.listIterator(characterList.size());
        boolean isPalindrome = true;
        while (listIterator.hasNext() && reverseList.hasPrevious()) {
            if (listIterator.next() != reverseList.previous()) {
                isPalindrome = false;
                break;
            }
        }
        if (!isPalindrome) {
            System.out.println("NOT PALINDROME");
        } else {
            System.out.println("YES it's PALINDROME");
        }
    }

}
