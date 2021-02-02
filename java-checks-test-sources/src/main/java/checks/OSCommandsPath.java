package checks;

import java.io.File;
import java.io.IOException;

public class OSCommandsPath {
  private static final String NON_COMPLIANT_COMMAND = "make";
  private static final String COMPLIANT_COMMAND_UNIX_ABSOLUTE = "/usr/bin/make";
  private static final String COMPLIANT_COMMAND_UNIX_PARENT = "../make";
  private static final String COMPLIANT_COMMAND_UNIX_CURRENT = "./make";
  private static final String COMPLIANT_COMMAND_WINDOWS_ABSOLUTE = "Z:\\make";
  private static final String COMPLIANT_COMMAND_WINDOWS_PARENT = "..\\make";
  private static final String COMPLIANT_COMMAND_WINDOWS_CURRENT = ".\\make";

  private static final String[] NON_COMPLIANT_COMMAND_ARRAY = new String[]{"make"};
  private static final String[] COMPLIANT_COMMAND_ARRAY = new String[]{"/usr/bin/make.exe"};

  private static final String[] ENVIRONMENT = new String[]{"DEBUG=true"};
  private static final File FILE = null;

  public void execString() throws IOException {
    Runtime.getRuntime().exec("make");  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make.exe");

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE);

    String nonCompliantCommand = "make";
    Runtime.getRuntime().exec(nonCompliantCommand); // Compliant FN Cannot read from non-final strings
    String compliantCommand = "/usr/bin/make.exe";
    Runtime.getRuntime().exec(compliantCommand);

    Runtime.getRuntime().exec("make", ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make.exe", ENVIRONMENT);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE, ENVIRONMENT);

    Runtime.getRuntime().exec(nonCompliantCommand, ENVIRONMENT); // Compliant FN Cannot read from non-final strings
    Runtime.getRuntime().exec(compliantCommand, ENVIRONMENT);

    Runtime.getRuntime().exec("make", ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec("/usr/bin/make.exe", ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_UNIX_ABSOLUTE);

    Runtime.getRuntime().exec(nonCompliantCommand, ENVIRONMENT, FILE); // Compliant FN Cannot read from non-final strings
    Runtime.getRuntime().exec(compliantCommand, ENVIRONMENT, FILE);
  }

  private void execArray() throws IOException {
    Runtime.getRuntime().exec(new String[]{"make"});  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make.exe"});

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY);

    String[] nonCompliantCommandArray = new String[]{"make"};
    Runtime.getRuntime().exec(nonCompliantCommandArray);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    String[] compliantCommandArray = new String[]{"/usr/bin/make.exe"};
    Runtime.getRuntime().exec(compliantCommandArray);

    Runtime.getRuntime().exec(new String[]{"make"}, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make.exe"}, ENVIRONMENT);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY, ENVIRONMENT);

    Runtime.getRuntime().exec(nonCompliantCommandArray, ENVIRONMENT);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(compliantCommandArray, ENVIRONMENT);

    Runtime.getRuntime().exec(new String[]{"make"}, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(new String[]{"/usr/bin/make.exe"}, ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(NON_COMPLIANT_COMMAND_ARRAY, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(COMPLIANT_COMMAND_ARRAY, ENVIRONMENT, FILE);

    Runtime.getRuntime().exec(nonCompliantCommandArray, ENVIRONMENT, FILE);  // Noncompliant {{Make sure the "PATH" used to find this command includes only what you intend.}}
    Runtime.getRuntime().exec(compliantCommandArray, ENVIRONMENT, FILE);
  }
}
