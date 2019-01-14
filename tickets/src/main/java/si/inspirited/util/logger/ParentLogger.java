package si.inspirited.util.logger;

import org.slf4j.Logger;

public abstract class ParentLogger {

    @InjectLogger
    protected static Logger LOGGER;

}
