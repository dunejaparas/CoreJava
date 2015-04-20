package com.pd.core.patterns.behavioral.command.example.filesystem;

public class FileSystemReceiverUtil {
    public static IFileSystemReceiver getUnderlyingFileSystem() {
	final String osName = System.getProperty("os.name");
	System.out.println("Underlying OS is:" + osName);
	if (osName.contains("Windows")) {
	    return new WindowsFileSystemReceiver();
	} else {
	    return new UnixFileSystemReceiver();
	}
    }
}
