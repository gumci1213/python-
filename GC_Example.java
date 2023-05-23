/*
동적으로 할당된 메모리 영역에서 더 이상 사용할 수 없게 된(불필요한) 메모리 영역을 자동으로 청소해주는 역할을 Garbage Collector가 하는데
Garbage Collector가 주기적으로 메모리 누수를 방지하기 위해 메모리를 청소하는 과정을 Garbage Collection(이하 GC)라고 한다. 

Garbage Collector를 사용하면 프로그래머가 굳이 동적으로 할당된 메모리 영역을 해제해줄 필요가 없어진다.

C같은 경우 메모리 할당 후 프로그래머가 직접 free()를 실행해줘야 하는데 자바나 파이썬 같은 경우 Garbage Collector가 자동으로 청소를 해준다.
*/


public class GC_Example {
    public static void main(String[] args) {
        // 객체 생성
        MyClass obj1 = new MyClass("obj1");
        MyClass obj2 = new MyClass("obj2");

        // obj2에 대한 참조를 수동으로 해제
        obj2 = null;

        // 명시적으로 가비지 컬렉션 호출(권장되지 않음)
        System.gc();
    }
}

class MyClass {
	String obj;
    // 생성자
    public MyClass(String obj) {
    	this.obj = obj;
        System.out.println(obj+"객체 생성");
    }

    // 소멸자(자바에서는 따로 구현해주지 않을 경우 자동으로 실행됨)
    @Override
    protected void finalize() throws Throwable {
        System.out.println(obj+"객체 소멸");
    }
}
