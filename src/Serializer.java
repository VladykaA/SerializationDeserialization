import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer implements Serializable {

    public static void serializer(Object obj, String path) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        StringBuilder sb = new StringBuilder();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(f.getModifiers())) {
                    f.setAccessible(true);
                    sb.append(f.getName()).append("=");
                    if (f.getType() == int.class) {
                        sb.append(f.getInt(obj));
                    } else {
                        sb.append(f.get(obj).toString());
                    }
                    sb.append(",");
                }
            }
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
                out.writeObject(sb);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Serialization successful");
    }
}
