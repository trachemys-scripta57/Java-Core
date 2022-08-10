/* https://habr.com/ru/post/130195/ */

package Modul_1_3.Logger;

import java.util.logging.*;

public class SomeClass {
    private static Logger log = Logger.getLogger(SomeClass.class.getName());

    public void someMethod()
    {
        log.info("Some message");
    }
}
