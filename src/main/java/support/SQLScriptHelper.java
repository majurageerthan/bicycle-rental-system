package support;

import java.util.Arrays;
import java.util.List;

import static support.Constant.*;

public class SQLScriptHelper {
    public static List<String> getInitializeDumbValueScripts() {
        return Arrays.asList(SQL_FILE_LOAD_USER,
                SQL_FILE_LOAD_STORE_MANAGER,
                SQL_FILE_LOAD_STORE,
                SQL_FILE_LOAD_STORE_CACHIER,
                SQL_FILE_LOAD_CUSTOMER,
                SQL_FILE_LOAD_BICYCLE,
                SQL_FILE_LOAD_PAYMENT_STATUS,
                SQL_FILE_LOAD_RENTAL,
                SQL_FILE_LOAD_ADDRESS
        );

    }
}
