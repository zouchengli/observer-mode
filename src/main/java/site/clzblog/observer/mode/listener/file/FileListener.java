package site.clzblog.observer.mode.listener.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

@Slf4j
public class FileListener extends FileAlterationListenerAdaptor {

    @Override
    public void onStart(FileAlterationObserver observer) {
        log.info("FileAlterationObserver on start");
    }

    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
    }

    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
    }

    @Override
    public void onFileCreate(File file) {
        log.info("{} file created", file.getAbsolutePath());
    }

    @Override
    public void onFileChange(File file) {
        log.info("{} file changed", file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file) {
        log.info("{} file deleted", file.getAbsolutePath());
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        log.info("FileAlterationObserver on stop");
        super.onStop(observer);
    }
}
