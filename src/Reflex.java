import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by user on 06.03.2019.
 */
public class Reflex {
    public void reflexString () throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class mClassObject = String.class;
        Class mClassObject1 = Class.forName("java.lang.String");

        String fullClassName = mClassObject.getName();
        String justClassName = mClassObject.getSimpleName();
        System.out.println(fullClassName);
        System.out.println(justClassName);

        int classModifiers = mClassObject.getModifiers();
        System.out.println(Modifier.isAbstract(classModifiers));
        System.out.println(Modifier.isFinal(classModifiers));
        System.out.println(Modifier.isInterface(classModifiers));
        System.out.println(Modifier.isNative(classModifiers));
        System.out.println(Modifier.isPrivate(classModifiers));
        System.out.println(Modifier.isProtected(classModifiers));
        System.out.println(Modifier.isPublic(classModifiers));
        System.out.println(Modifier.isStatic(classModifiers));
        System.out.println(mClassObject.getSuperclass());
        Class [] interfaces = mClassObject.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        Constructor[] constructors = mClassObject.getConstructors();
        Constructor constructor = mClassObject.getConstructor(String.class);
        Class [] parameters = constructor.getParameterTypes();
        System.out.println(Arrays.toString(constructors));
        System.out.println(constructor);
        System.out.println(Arrays.toString(parameters));
        String myObject = (String) constructor.newInstance("Ура");
        System.out.println(myObject);
        Field[] fields = mClassObject.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        Field field = mClassObject.getDeclaredField("value");
        field.setAccessible(true);
        System.out.println(field);
        String fieldName = field.getName();
        System.out.println(fieldName);
        Object fieldType = field.getType();
        System.out.println(fieldType);
        String instance = new String("Рефлексия");
        System.out.println(instance);
       // field.set(instance, "Рефлексия - наше все");
        System.out.println(instance);
        Method[] methods = mClassObject.getMethods();
        System.out.print(Arrays.toString(methods));
        Method method = mClassObject.getMethod("compareTo", new Class[]{Object.class});
        System.out.print(method);


    }
}
