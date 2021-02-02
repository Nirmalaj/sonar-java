package checks;

import java.io.File;
import java.io.IOException;

public class OSCommandsPath {
  private static final String NON_COMPLIANT_COMMAND = "make";
  private static final String NON_COMPLIANT_COMMAND_UNIX_PARENT = "m../ake";
  private static final String NON_COMPLIANT_COMMAND_UNIX_CURRENT = "mak./e";
  private static final String NON_COMPLIANT_COMMAND_UNIX_HOME = "bin~/make";
  private static final String NON_COMPLIANT_COMMAND_WINDOWS_ABSOLUTE = "7:\\\\make";
  private static final String NON_COMPLIANT_COMMAND_WINDOWS_PARENT = "m..\\ake";
  private static final String NON_COMPLIANT_COMMAND_WINDOWS_CURRENT = "ma.\\ke";
  private static final String NON_COMPLIANT_COMMAND_WINDOWS_NETWORK = "SERVER\\make";

  private static final String COMPLIANT_COMMAND_UNIX_ABSOLUTE = "/usr/bin/make";
  private static final String COMPLIANT_COMMAND_UNIX_PARENT = "../make";
  private static final String COMPLIANT_COMMAND_UNIX_CURRENT = "./make";
  private static final String COMPLIANT_COMMAND_UNIX_HOME = "~/bin/make";
  private static final String COMPLIANT_COMMAND_WINDOWS_ABSOLUTE = "Z:\\make";
  private static final String COMPLIANT_COMMAND_WINDOWS_PARENT = "..\\make";
  private static final String COMPLIANT_COMMAND_WINDOWS_CURRENT = ".\\make";
  private static final String COMPLIANT_COMMAND_WINDOWS_NETWORK = "\\\\SERVER\\make";

  private static final String[] NON_COMPLIANT_COMMAND_ARRAY = new String[]{"make"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_UNIX_PARENT = new String[]{"m../ake"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_UNIX_CURRENT = new String[]{"m./ake"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_UNIX_HOME = new String[]{"m~/ake"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_ABSOLUTE = new String[]{"7:\\\\make"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_PARENT = new String[]{"m..\\ake"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_CURRENT = new String[]{"m.\\ake"};
  private static final String[] NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_NETWORK = new String[]{"SERVER\\make"};

  private static final String[] COMPLIANT_COMMAND_ARRAY = new String[]{"/usr/bin/make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_UNIX_PARENT = new String[]{"../make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_UNIX_CURRENT = new String[]{"./make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_UNIX_HOME = new String[]{"~/bin/make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_WINDOWS_ABSOLUTE = new String[]{"W:\\\\make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_WINDOWS_PARENT = new String[]{"..\\bin\\make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_WINDOWS_CURRENT = new String[]{".\\make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY_WINDOWS_NETWORK = new String[]{"\\\\SERVER\\make"};

  private static final String[] ENVIRONMENT = new String[]{"DEBUG=true"};
  private static final File FILE = null;

  public void execString() throws IOException {
    Runtime.getRuntime().exec("make");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("usr/bin/make");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("m./ake");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("m../ake");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("bin~/make");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("7:\\\\../ake");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("SERVER\\make");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make");
    Runtime.getRuntime().exec("../make");
    Runtime.getRuntime().exec("./make");
    Runtime.getRuntime().exec("~/bin/make");
    Runtime.getRuntime().exec("Z:\\make");
    Runtime.getRuntime().exec("..\\make");
    Runtime.getRuntime().exec(".\\make");
    Runtime.getRuntime().exec("\\\\SERVER\\make");

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_UNIX_PARENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_UNIX_CURRENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_UNIX_HOME);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_WINDOWS_ABSOLUTE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_WINDOWS_PARENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_WINDOWS_CURRENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_WINDOWS_NETWORK);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_PARENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_CURRENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_HOME);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_WINDOWS_ABSOLUTE);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_WINDOWS_PARENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_WINDOWS_CURRENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_WINDOWS_NETWORK);


    String nonCompliantCommand = "make";
    Runtime.getRuntime().exec(nonCompliantCommand); // Compliant FN Cannot read from non-final strings
    String compliantCommand = "/usr/bin/make";
    Runtime.getRuntime().exec(compliantCommand);

    Runtime.getRuntime().exec("make", ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make", ENVIRONMENT);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE, ENVIRONMENT);

    Runtime.getRuntime().exec(nonCompliantCommand, ENVIRONMENT); // Compliant FN Cannot read from non-final strings
    Runtime.getRuntime().exec(compliantCommand, ENVIRONMENT);

    Runtime.getRuntime().exec("make", ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make", ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE);

    Runtime.getRuntime().exec(nonCompliantCommand, ENVIRONMENT, FILE); // Compliant FN Cannot read from non-final strings
    Runtime.getRuntime().exec(compliantCommand, ENVIRONMENT, FILE);
  }

  private void execArray() throws IOException {
    Runtime.getRuntime().exec(new String[]{"make"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"usr/bin/make"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"m./ake"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"m../ake"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"bin~/make"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"7:\\\\../ake"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"SERVER\\make"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make"});
    Runtime.getRuntime().exec(new String[]{"../make"});
    Runtime.getRuntime().exec(new String[]{"./make"});
    Runtime.getRuntime().exec(new String[]{"~/bin/make"});
    Runtime.getRuntime().exec(new String[]{"Z:\\make"});
    Runtime.getRuntime().exec(new String[]{"..\\make"});
    Runtime.getRuntime().exec(new String[]{".\\make"});
    Runtime.getRuntime().exec(new String[]{"\\\\SERVER\\make"});

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_UNIX_PARENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_UNIX_CURRENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_UNIX_HOME);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_ABSOLUTE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_PARENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_CURRENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY_WINDOWS_NETWORK);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_UNIX_PARENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_UNIX_CURRENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_UNIX_HOME);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_WINDOWS_ABSOLUTE);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_WINDOWS_PARENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_WINDOWS_CURRENT);
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY_WINDOWS_NETWORK);

    String[] nonCompliantCommandArray = new String[]{"make"};
    Runtime.getRuntime().exec(nonCompliantCommandArray);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    String[] compliantCommandArray = new String[]{"/usr/bin/make"};
    Runtime.getRuntime().exec(compliantCommandArray);

    Runtime.getRuntime().exec(new String[]{"make"}, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make"}, ENVIRONMENT);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY, ENVIRONMENT);

    Runtime.getRuntime().exec(nonCompliantCommandArray, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(compliantCommandArray, ENVIRONMENT);

    Runtime.getRuntime().exec(new String[]{"make"}, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make"}, ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY, ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(nonCompliantCommandArray, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(compliantCommandArray, ENVIRONMENT, FILE);
  }
}
