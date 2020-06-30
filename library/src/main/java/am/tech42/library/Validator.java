package am.tech42.library;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class Validator {
    public static List<String> validate(Object object) throws IllegalAccessException {
	List<String> errors = new ArrayList<>();
        Class clazz = object.getClass();
        Field[] fields = null;
	String message = "";

        while (clazz != null) {
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object fieldValue = field.get(object);
		String fieldName = field.getName();

                if (fieldValue instanceof char[] && !validCharArray((char[]) fieldValue)) {
			message = fieldName + " field cannot be empty";
                } else if (fieldValue instanceof Integer && !validInt((int) fieldValue)) {
			message = fieldName + " field must be greater than 0";
		} else if (fieldValue instanceof String && !validString((String) fieldValue)) {
			message = fieldName + " field cannot be empty";
                }
		
		if(!"".equals(message)) {
			errors.add(message);
			message = "";
		}
            }
            clazz = clazz.getSuperclass();
        }

	return errors;
    }

    private static boolean validString(String fieldValue) {
	return fieldValue != null && fieldValue.length() > 0;
    }

    private static boolean validInt(int fieldValue) {
	return fieldValue > 0;
    }

    private static boolean validCharArray(char[] fieldValue) {
	return fieldValue.length > 0;
    }
}
