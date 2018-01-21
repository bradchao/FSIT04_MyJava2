import java.io.File;

public class Brad72 {

	public static void main(String[] args) {
		sayYa("Brad");
		sayYa(new File("/"), "file1", "file2");
	}

	static void sayYa(String name) {
		System.out.println("A");
	}

	static void sayYa(File root, String... filename) {

	}
	
}
