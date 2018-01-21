
public class Brad70 {
	public static void main(String[] args) {
		Test12 obj1 = new Test12();
		test(obj1);
		
	
		test(new Test11() {
			@Override
			public int m1(int a, int b) {
				int r = 2*a + b;
				return r;
			}
		});
		
		// Lambda
		test((int a, int b)->{
			int r = 2*a+b;
			return r;
			});
		
		test((a, b)->{
			int r = 2*a+b;
			return r;
			});
	
		test((a, b)->{
			return 2*a+b;
			});

		test((a, b)->2*a+b);
		
		Test11 obj2 = (a, b)->2*a+b;
		System.out.println("=> " +obj2.m1(2, 3));
		Test13 obj3 = ()->{
			return 2;
		};
		
	}
	static void test(Test11 obj) {
		System.out.println(obj.m1(3, 4));
	}
}

interface Test11 {
	int m1(int a, int b);
}
class Test12 implements Test11 {
	public int m1(int a, int b) {
		//System.out.println("OK");
		int r = 2*a + b;
		return r;
	}
}
interface Test13 {
	int m2();
}