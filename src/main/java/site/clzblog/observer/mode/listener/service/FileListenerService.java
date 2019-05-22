package site.clzblog.observer.mode.listener.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Service;
import site.clzblog.observer.mode.listener.file.FileListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FileListenerService {
    public void startListener() throws Exception {
        String home = "/Users/chengli.zou/Downloads/bigdata";
        long millis = TimeUnit.SECONDS.toMillis(5);
        IOFileFilter dirs = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".txt"));
        IOFileFilter filter = FileFilterUtils.or(dirs, files);
        FileAlterationObserver observer = new FileAlterationObserver(new File(home), filter);
        observer.addListener(new FileListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor(millis, observer);
        monitor.start();
        log.info("Started listen home -> {}", home);
    }
}
