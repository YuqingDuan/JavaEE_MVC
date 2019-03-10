package ca.laurentian.util;

public class TextUtil {
    /**
     * Determines whether a string is empty.
     *
     * @param sequence a string
     * @return empty or no not empty
     */
    public static boolean isEmpty(CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }
}
