package org.nem.log.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.nem.log.boundary.Loggable;

/**
 *
 * @author nemanja.marjanovic
 */
@Loggable
@Interceptor
public class LoggableMethod {

    private static final Logger LOG = Logger.getLogger("METHOD INTERCEPTOR LOG");

    @AroundInvoke
    public Object logMethod(InvocationContext invocationContext)
            throws Exception {

        StringBuilder message = new StringBuilder("CLASS: ");
        message.append(invocationContext.getTarget().getClass().getName());
        message.append(" METHOD: ");
        message.append(invocationContext.getMethod().getName());

        StringBuilder parameters = new StringBuilder(" PARAMETERS: ");
        for (Object parameter : invocationContext.getParameters()) {
            parameters.append(String.valueOf(parameter));
        }
        LOG.log(Level.INFO, "{0}{1}", new Object[]{message, parameters});

        Object result;
        try {
            result = invocationContext.proceed();
        } catch (Exception ex) {
            throw ex;
        }

        StringBuilder value = new StringBuilder(" VALUE: ");
        value.append(String.valueOf(result));
        LOG.log(Level.INFO, "{0}{1}", new Object[]{message, value});

        return result;
    }
}
