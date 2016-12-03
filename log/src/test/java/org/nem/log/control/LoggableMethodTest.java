package org.nem.log.control;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import javax.interceptor.InvocationContext;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nemanja
 */
public class LoggableMethodTest {

    private InvocationContext invocationContext;
    private TestClass testSubject;

    @Test
    public void test1() {
        LoggableMethod lm = new LoggableMethod();
        try {
            lm.logMethod(this.invocationContext);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Before
    public void initInjectionPoint() {
        this.testSubject = new TestClass();
        this.invocationContext = new InvocationContext() {
            @Override
            public Object getTarget() {
                return LoggableMethodTest.this.testSubject;
            }

            @Override
            public Object getTimer() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Method getMethod() {
                try {
                    return TestClass.class
                            .getMethod("testMethod", String.class);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }

            @Override
            public Constructor<?> getConstructor() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Object[] getParameters() {
                try {
                    return new String[]{"Question?"};
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }

            @Override
            public void setParameters(Object[] params) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Map<String, Object> getContextData() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Object proceed() throws Exception {
                return LoggableMethodTest.this.testSubject.
                        testMethod("Question?");
            }
        };
    }

}
