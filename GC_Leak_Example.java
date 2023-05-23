import java.util.ArrayList;
import java.util.List;

public class GC_Leak_Example {
    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Object obj = new Object();
            list.add(obj);
            
            /*
             * if(list.size() > 100){
             * 	list.remove();
             * }
             */
            
        }
    }
}

/*
 * 위 코드는 무한루프로 Obnject 객체를 계속 생성하고 list에 추가하는 코드다.
 * list 에 추가 된 객체들은 GC가 처리하지 않으며 계속 메모리를 점유하게 된다.
 * 위와 같은 경우 list에 있는 obj를 주기적으로 삭제하는 것 같은 방법으로 처리해줘야 메모리 사용을 방지할 수 있다.
 */
