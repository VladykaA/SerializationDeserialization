import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Deserializer implements Serializable {

    public static void deserialiser(String path, Object obj) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        String[] strings = in.readObject().toString().split(",");

        for (String s : strings) {
            String[] keyValues = s.split("=");
            String key = keyValues[0];
            String value = keyValues[1];

            Field field = obj.getClass().getDeclaredField(key);

            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }

            if (field.getType() == int.class) {
                field.setInt(obj, Integer.parseInt(value));
            } else {
                field.set(obj, value);
            }
        }
        in.close();
        System.out.println("Deserialization is successful");
    }
}
