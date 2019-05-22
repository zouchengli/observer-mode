package site.clzblog.observer.mode;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import site.clzblog.observer.mode.custom.impl.UserObserver;
import site.clzblog.observer.mode.custom.impl.WeChatObserver;
import site.clzblog.observer.mode.jdk.EmailObserver;
import site.clzblog.observer.mode.jdk.MessageObservable;
import site.clzblog.observer.mode.jdk.SmsObserver;
import site.clzblog.observer.mode.listener.file.FileListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ObserverModeApplicationTests {
    public static void main(String[] args) throws Exception {
        MessageObservable observable = new MessageObservable();
        observable.addObserver(new EmailObserver());
        observable.addObserver(new SmsObserver());
        observable.notifyObservers("test Content");
    }

    public void testCustomObserver() {
        WeChatObserver weChatObserver = new WeChatObserver();
        weChatObserver.add(new UserObserver("Jack"));
        weChatObserver.add(new UserObserver("Mike"));
        weChatObserver.setMsg("Test content");
    }

    public void fileListen() throws Exception {
        String home = "/Users/chengli.zou/Downloads/bigdata";
        long millis = TimeUnit.SECONDS.toMillis(5);
        IOFileFilter dirs = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".txt"));
        IOFileFilter filter = FileFilterUtils.or(dirs, files);
        FileAlterationObserver observer = new FileAlterationObserver(new File(home), filter);
        observer.addListener(new FileListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor(millis, observer);
        monitor.start();
    }
}
