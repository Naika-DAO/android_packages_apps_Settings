package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;

public class NaikaVersionPreferenceController extends BasePreferenceController {

    @VisibleForTesting
    static final String NAIKA_VERSION = "ro.naika.version";

    public NaikaVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return !TextUtils.isEmpty(SystemProperties.get(NAIKA_VERSION)) ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(NAIKA_VERSION,
                mContext.getString(R.string.device_info_default));
    }
}
