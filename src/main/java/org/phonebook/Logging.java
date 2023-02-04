package org.phonebook;
import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.File;
public class Logging {
    static Logger LOGGER;
    static String FILE_NAME_LOGCONF = "log.config";

    static {
        try (FileInputStream ins = new FileInputStream(Filemanager.FILE_PATH + FILE_NAME_LOGCONF)){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }

    }
}
