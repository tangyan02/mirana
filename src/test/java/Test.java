import java.io.File;

public class Test {
    static public void main(String[] args){
        String path = "src/main/java/mirana/demo/entity";
        File file = new File(path);
        System.out.println(file.list());
    }
}
