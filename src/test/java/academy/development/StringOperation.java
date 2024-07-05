package academy.development;

import com.google.common.collect.Ordering;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class StringOperation {

    @Test
    public void makeWordTitleCase() {
        String s = "thisHasASingleLetterWor";
        LinkedList<String> result = new LinkedList<>();
//        for (String w : s.split("(([A-Z]?[a-z]+)|([A-Z]))")) {
//            result.add(w);
//        }
        for (String w : s.split("(?=[A-Z]+)")) {
            result.add(w);
        }
//        log.info(s.replaceAll("(?=[A-Z]+)", " ").trim());
//        log.info(result.toString());

        log.info(Arrays.stream(s.split("(?=[A-Z]+)")).map(StringUtils::capitalize).collect(Collectors.joining(" ")));

    }

    @Test
    public void f() {
        final HashMap<String, String> hashMap = new HashMap<String, String>() {
            {
                put("foo", "foo1");
                put("bar", "bar1");
                put("car", "BMW");
                put("truck", "MAN");
            }
        };
        String template =  "This is '%(foo)' and '%(foo)', but also '%(bar)' '%(bar)' indeed.";


        String res =  hashMap.entrySet().stream()
                .reduce(template, (s, e) -> s.replace("%(" + e.getKey() + ")", e.getValue()), (s, s2) -> s);
        log.info("{}",res);
    }

    @Test void ff() {
        String s = "1100";
        boolean b= false;
        if(isDouble(s)) {
          double value =  Double.valueOf(s);
          b =value >= 0.0;
        }
        System.out.println(b);
    }

    private boolean isDouble(String value) {
        try {
            Double.valueOf(value);
        }
        catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        }
        catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
