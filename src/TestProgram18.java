// https://medium.com/@anil.java.story/you-dont-know-hashmap-do-you-465bcbf67f8
import java.util.HashMap;
import java.util.Map;

public class TestProgram18 {
  public static void main(String[] args) {

    Map<Key, String> map = new HashMap<>(); //1
    map.put(new Key("key1"), "anil"); //2
    map.put(new Key("key2"), "bhavna"); //3
    map.put(new Key("key2"), "daniel"); //4
    System.out.println(map.get(new Key("key2"))); //5
    System.out.println(map.size()); //6
    System.out.println(map.get(new Key("key1"))); //7

    // map
    System.out.println(map.toString());

    // print hashcode of all keys
    map.keySet().forEach(k -> System.out.print(k.hashCode() + " "));
    System.out.println();
    System.out.println(new Key("key4").equals(new Key("key4")));
  }
  
  static class Key {
    String key;

    Key(String key) {
      this.key = key;
    }

    // @Override
    // public int hashCode() {
    //   return 1;
    // }
    // @Override
    // public int hashCode() {
    //   final int prime = 31;
    //   int result = 1;
    //   result = prime * result + ((key == null) ? 0 : key.hashCode());
    //   return result;
    // }
    // @Override
    // public boolean equals(Object obj) {
    //   if (this == obj)
    //     return true;
    //   if (obj == null)
    //     return false;
    //   if (getClass() != obj.getClass())
    //     return false;
    //   Key other = (Key) obj;
    //   if (key == null) {
    //     if (other.key != null)
    //       return false;
    //   } else if (!key.equals(other.key))
    //     return false;
    //   return true;
    // }
    
  }
}
