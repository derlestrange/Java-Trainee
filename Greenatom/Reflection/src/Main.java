import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Test> mClassObject = Test.class;
        Method method = mClassObject.getMethod("somethingMethod");
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation mAnnotation = (MyAnnotation) annotation;
                System.out.println(mAnnotation.something());
            }
        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String something() default "hello world";
}


class Test {
    @MyAnnotation()
    public void somethingMethod() {
    }
}
