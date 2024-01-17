import java.util.HashMap;
import java.util.Map;
public class TestProgram10 {
    public static void main(String[] args) {
        // Case 1 : String as a key in hashmap
        Map<String, String> map =new HashMap<>();
        String e1 = new String("AJAY");
        System.out.println("hashcode = " + e1.hashCode());
        String e2 = new String("AJAY");
        System.out.println("hashcode = " + e1.hashCode());
        System.out.println(e1 == e2);
        map.put(e1,"I");
        map.put(e2,"M2");
        System.out.println(map.get(e1));
        System.out.println(map.get(e2));
        System.out.println("--------------------------------------");
        // Case 2 : Integer as a key in hashmap
        Map<Integer, String> map1 = new HashMap<>();
        Integer i1 = new Integer(10);
        System.out.println("hashcode = " + i1.hashCode());
        Integer i2 = new Integer(10);
        System.out.println("hashcode = " + i1.hashCode());
        System.out.println(i1 == i2);
        map1.put(i1, "Hi");
        map1.put(i2, "Hi again");
        System.out.println(map1.get(i1));
        System.out.println(map1.get(i2));
        System.out.println("--------------------------------------");
        // Case 3 : Custom mutable object - Pen as a key in hashmap
        Map<Pen, String> map2 = new HashMap<>();
        Pen p1 = new Pen("Blue");
        System.out.println("hashcode = " + p1.hashCode());
        Pen p2 = new Pen("Blue");
        System.out.println("hashcode = " + p2.hashCode());
        System.out.println(p1 == p2);
        map2.put(p1, "Shop No 1");
        map2.put(p2, "Shop No 2");
        System.out.println(map2.get(p1));
        System.out.println(map2.get(p2));
        System.out.println("--------------------------------------");
        // Case 4 : Custom immutable object - Notebook (with own implementation of equals and hashcode) as a key in hashmap
        Map<Notebook, Integer> notebookMap = new HashMap<>();
        Notebook nb1 = new Notebook(200, 70.82);
        System.out.println("hashcode = " + nb1.hashCode());
        Notebook nb2 = new Notebook(200, 70.82);
        System.out.println("hashcode = " + nb2.hashCode());
        System.out.println(p1 == p2);
        notebookMap.put(nb1, 20);
        notebookMap.put(nb2, 30);
        System.out.println(notebookMap.get(nb1));
        System.out.println(notebookMap.get(nb2));
        // Since we have implemented equals() and hashcode() for Notebook object, which is immutable, we can have issues while fetching a mutated object
        // comment down below implementation of equals() and hashcode() for different result;
        Notebook nb3 = new Notebook(160, 50.52);
        nb2 = nb3;
        nb2.setNumberOfPages(nb2.getNumberOfPages()+100);
        nb2.setPrice(nb2.getPrice()+20);
        System.out.println(nb2);
        System.out.println(notebookMap.get(nb2));
        System.out.println("--------------------------------------");
    }
}
class Pen{
    private String inkColor;
    public Pen(String inkColor) {
        this.inkColor = inkColor;
    }
}
class Notebook{
    private int numberOfPages;
    private Double price;
    Notebook(){}
    public Notebook(int numberOfPages, Double price) {
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Notebook [numberOfPages=" + numberOfPages + ", price=" + price + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numberOfPages;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (numberOfPages != other.numberOfPages)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }    
}


// output
/*
 * hashcode = 2009633
 * hashcode = 2009633
 * false
 * M2
 * M2
 * --------------------------------------
 * hashcode = 10
 * hashcode = 10
 * false
 * Hi again
 * Hi again
 * --------------------------------------
 * hashcode = 140435067
 * hashcode = 1450495309
 * false
 * Shop No 1
 * Shop No 2
 * --------------------------------------
 * hashcode = -1592379801
 * hashcode = -1592379801
 * false
 * 30
 * 30
 * Notebook [numberOfPages=260, price=70.52000000000001]
 * null
 * --------------------------------------
 */