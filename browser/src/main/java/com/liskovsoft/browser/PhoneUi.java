package com.liskovsoft.browser;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneUi extends TitleBarBaseUi {
    private final int mActionBarHeight;
    private final Logger logger = LoggerFactory.getLogger(PhoneUi.class);
    private NavigationBarPhone mNavigationBar;

    public PhoneUi(Activity browser, UiController controller) {
        super(browser, controller);

        logger.info("About to load phone interface");

        setUseQuickControls(BrowserSettings.getInstance().useQuickControls());
        mNavigationBar = (NavigationBarPhone) mTitleBar.getNavigationBar();
        TypedValue heightValue = new TypedValue();
        // below proper way to work with com.android.internal.R.attr.actionBarSize resource
        int actionBarSize = Resources.getSystem().getIdentifier("actionBarSize", "attr", "android");
        browser.getTheme().resolveAttribute(
                actionBarSize, heightValue, true);
        mActionBarHeight = TypedValue.complexToDimensionPixelSize(heightValue.data,
                browser.getResources().getDisplayMetrics());

    }
}
