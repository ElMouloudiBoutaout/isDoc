package undocumented;

@Doc(desc = "Calculatrice")

public class MathUtils {
	
	void sayHello(int a, int b) {
		System.out.println("Hello");
	}
	
	private void sayHello2(int a, int b) {
		System.out.println("Hello2");
	}
	

	@Doc(desc = "adding", params = { "a","b" }, returnVal = "add a to b")
	int add(int a, int b) {
		System.out.println("add");
		return a+b;
	}

	@Doc(desc = "sub", params = { "a" }, returnVal = "add a to b")
	 int substruct(int a, int b) {
		System.out.println("substruct");
		return a-b;
	}

	@Doc(desc = "div")
	int divide(int a, int b) {
		System.out.println("divide");
		return a+b;
	}

	int multiplie(int a, int b) {
		System.out.println("multiplie");
		return a*b;
	}

}
