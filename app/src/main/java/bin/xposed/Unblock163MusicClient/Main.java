package bin.xposed.Unblock163MusicClient;

import net.androidwing.hotxposed.HotXposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Main implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(CloudMusicPackage.PACKAGE_NAME)) {
            HotXposed.hook(HookerDispatcher.class, lpparam);
        }

        if (lpparam.packageName.equals(BuildConfig.APPLICATION_ID)) {
            HotXposed.hook(HookerDispatcherSelf.class, lpparam);
        }
    }
}