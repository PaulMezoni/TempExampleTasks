package Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employees {



    public static void main(String[] args) {
        Emp emp1 = new Emp(1, "Ramon");
        Emp emp2 = new Emp(3, "Cassio");
        Emp emp3 = new Emp(1, "Paul");
        Emp emp4 = new Emp(1, "Max");
        List<Emp> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        System.out.println("NON Sorted " + empList);
        Collections.sort(empList);
        System.out.println("Sorted " + empList);


    }

    static class Emp implements Comparable<Emp> {
        Integer id;
        String name;

        public Emp(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Emp o) {

            int res = this.id.compareTo(o.id);
            if (res == 0) {
                res = this.name.compareTo(o.name);
            }
            return res;
        }
    }
}
