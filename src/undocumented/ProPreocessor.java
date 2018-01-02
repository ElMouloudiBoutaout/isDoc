package undocumented;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ProPreocessor {

	public static /* boolean */ void process(Class<?> clazz) {

		String className = clazz.getSimpleName();

		System.out.println("Analyzing " + className);

		int classErrors = 0;

		if (clazz.isAnnotationPresent(Doc.class)) {
			for (Method method : clazz.getDeclaredMethods()) {
				int modInt = method.getModifiers();
				String modStr = Modifier.toString(modInt);

				if (!Modifier.isPrivate(modInt)) {

					int methodErrors = 0;

					System.out.print("Method name : " + method.getName()+" ---->");

					if (method.isAnnotationPresent(Doc.class)) {

						Doc doc = method.getAnnotation(Doc.class);

						methodErrors = getNumMissingParams(method, doc);
						if(methodErrors!=0){
						System.out.print(" some ("+methodErrors+") parameters need documenatation ; ");}
						if(!hasReturnDescription(method,doc)){
							methodErrors++;
						System.out.print(" this method  has a  return type , must  be documented ;");}
						
						if(methodErrors==0)
							System.out.print(" no change a needed ; ");
						else{
							System.out.println("you have in general "+methodErrors+ " problems ");
						}
					}
					else{
						System.out.print("this methode is not annotated");
					}

				}
				
				System.out.println();

			}
		}

	}

	private static int getNumMissingParams(Method method, Doc doc) {
		int numMissing = method.getParameterCount() - doc.params().length;
		System.out.print(method.getParameterCount() +"-"+doc.params().length);
		if(numMissing>0)
			return numMissing;
		return 0;
	}
	
	private static boolean  hasReturnDescription(Method method, Doc doc){
		return !method.getReturnType().equals(Void.TYPE) && !doc.returnVal().isEmpty();
		
	}

}
