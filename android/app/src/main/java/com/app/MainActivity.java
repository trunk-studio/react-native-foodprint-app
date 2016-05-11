package com.app;

import com.facebook.react.ReactActivity;
import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdaterPackage;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdater;
import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdater.ReactNativeAutoUpdaterUpdateType;
import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdater.ReactNativeAutoUpdaterFrequency;
import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdaterActivity;
import com.aerofs.reactnativeautoupdater.ReactNativeAutoUpdaterPackage;

import javax.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ReactNativeAutoUpdaterActivity {

    /**
     *  Name of the JS Bundle file shipped with the app.
     *  This file has to be added as an Android Asset.
     * */
    @Nullable
    @Override
    protected String getBundleAssetName() {
        return "main.jsbundle";
    }

    /**
     *  URL for the metadata of the update.
     * */
    @Override
    protected String getUpdateMetadataUrl() {
        return "https://s3-ap-northeast-1.amazonaws.com/s3.trunksys.com/hiking/qa/packager/metadata.json";
    }

    /**
     * Name of the metadata file shipped with the app.
     * This metadata is used to compare the shipped JS code against the updates.
     * */
    @Override
    protected String getMetadataAssetName() {
        return "metadata.android.json";
    }

    /**
     *  If your updates metadata JSON has a relative URL for downloading
     *  the JS bundle, set this hostname.
     * */
    @Override
    protected String getHostnameForRelativeDownloadURLs() {
        return "https://s3-ap-northeast-1.amazonaws.com/s3.trunksys.com/hiking";
    }

    /**
     *  Decide what type of updates to download.
     * Available options -
     *  MAJOR - will download only if major version number changes
     *  MINOR - will download if major or minor version number changes
     *  PATCH - will download for any version change
     * default value - PATCH
     * */
    @Override
    protected ReactNativeAutoUpdaterUpdateType getAllowedUpdateType() {
        return ReactNativeAutoUpdater.ReactNativeAutoUpdaterUpdateType.MINOR;
    }

    /**
     *  Decide how frequently to check for updates.
     * Available options -
     *  EACH_TIME - each time the app starts
     *  DAILY     - maximum once per day
     *  WEEKLY    - maximum once per week
     * default value - EACH_TIME
     * */
    @Override
    protected ReactNativeAutoUpdaterFrequency getUpdateFrequency() {
        return ReactNativeAutoUpdaterFrequency.EACH_TIME;
    }

    /**
     *  To show progress during the update process.
     * */
    @Override
    protected boolean getShowProgress() {
        return true;
    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "App";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            new ReactNativeAutoUpdaterPackage()
        );
    }
}
