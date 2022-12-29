package sample02_1_KeyListener;
import java.io.File;
public class FileExistsCheck {
	public static void main(String[] args) {
//		File file = new File("../../../bin");
//		
//		if(file.exists()) {
//			System.out.println("ファイルが存在します");
//		}else {
//			System.out.println("ファイルが存在しません");
//		}

    String path = "src";
    File dir = new File(path);
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
        File file = files[i];
        System.out.println((i + 1) + ":    " + file);
    }
	}

}
