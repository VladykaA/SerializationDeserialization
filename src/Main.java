import java.io.IOException;

public class Main {
    public static void main(String[] args){

        Test test = new Test(5, "Hello");

        try {
            Serializer.serializer(test, "C:\\Users\\oleksandr.vladyka\\Documents\\forTest1\\testResult.txt");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Deserializer.deserialiser("C:\\Users\\oleksandr.vladyka\\Documents\\forTest1\\testResult.txt", test);
        } catch (IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
