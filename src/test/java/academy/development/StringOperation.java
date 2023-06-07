package academy.development;

import com.google.common.collect.Ordering;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StringOperation {

    @Test
    public void makeWordTitleCase() {
        String s = "thisHasASingleLetterWor";
        LinkedList<String> result = new LinkedList<String>();
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
}
