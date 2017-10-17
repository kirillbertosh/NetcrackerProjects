package lesson2.homeTask;

import java.text.Collator;

public class ExpressionHelper {

    static boolean isBigger(Object value, Object filter) {
         return Collator.getInstance().compare(value.toString(), filter.toString()) > 0;
    }

    static boolean isLower(Object value, Object filter) {
        return Collator.getInstance().compare(value, filter) < 0;
    }
}
