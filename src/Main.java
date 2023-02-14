import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String string= "the quick brown fox jumps over the lazy dog arrays the final final record";
        String string1= string.toLowerCase();
        String[]arr = string.split(" ");
        System.out.println("В тексте "+arr.length+" слов");
        System.out.println("ТОР 10: ");
        Arrays.stream(arr)
                .collect(Collectors.toMap(o->o,o1->1,Integer::sum)).entrySet().stream()
                .sorted((o1,o2)-> {
                    int equal= (o2.getValue().compareTo(o1.getValue()));
                    if(equal ==0 ){
                        equal = o1.getKey().compareTo(o2.getKey());
                    }
                    return equal;

                })
                .limit(10)
                .forEach(e-> System.out.println(e.getValue()+" - " +e.getKey()));


    }
}