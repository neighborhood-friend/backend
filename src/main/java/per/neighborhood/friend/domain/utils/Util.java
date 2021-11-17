package per.neighborhood.friend.domain.utils;

public class Util {

    public static <T> T checkChange(T oldValue, T newValue) {
        return newValue != null ? newValue : oldValue;
    }
}
