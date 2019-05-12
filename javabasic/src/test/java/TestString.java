import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestString {

    @Before
    public void beforeInit() {


    }


    @Test
    public void testVoid() {
        System.out.println("11");
    }

    @Test
    public void testString() {
        String name = "张飞";
        modifyName(name);
        System.out.println(name);


    }

    private void modifyName(String name) {
        name = "刘备";
        System.out.println("modifyName():" + name);
    }

    @Test
    public void testSubstring() {
        String phoneNo = "13512345678";
        phoneNo = phoneNo.substring(0, 5) + "****" + phoneNo.substring(9, 11);
        System.out.println(phoneNo);
    }

    @Test
    public void testListAppend() {
        StringBuffer appendName = new StringBuffer();
        List<String> names = Arrays.asList("jack", "rose", "tom", "jackson");
        for (int i = 0; i < names.size(); i++) {
            if (i != names.size()-1) {
                appendName.append(names.get(i)+"、");
            }else{
                appendName.append(names.get(i));
            }
        }
        System.out.println(appendName);


    }

}
