/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fourmob.colorpicker.util;

import ohos.agp.colors.RgbColor;
import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.preferences.Preferences;

/**
 * helper class for saving dialog state.
 */
public class PreferencesHelper {

    private static final String TAG = "PreferencesHelper";
    private static final PreferencesHelper instance = new PreferencesHelper();
    private boolean isInit;
    private RgbColor rgbcolor;
    private Preferences preferences;

    private PreferencesHelper() {
    }

    /**
     * init the preference helper class.
     *
     * @param context context.
     * @param sharePrefName name of the prefernces database.
     * @param selectedcolor initial selected color
     */
    public void init(Context context, String sharePrefName, RgbColor selectedcolor) {
        if (this.isInit) {
            LogUtil.warn(TAG, "PreferencesHelper is already inited");
            return;
        }
        this.isInit = true;
        this.rgbcolor = selectedcolor;
        preferences = new DatabaseHelper(context).getPreferences(sharePrefName);
    }

    public static PreferencesHelper getInstance() {
        return instance;
    }

    /**
     * put the key value pair in the preferences database.
     *
     * @param key key of the stored object.
     * @param value value of the stored object.
     */
    public void putInt(String key, int value) {
        if (!this.isInit) {
            return;
        }
        preferences.putInt(key, value);
        preferences.flushSync();
    }

    /**
     * return the int value corresponding to the key.
     *
     * @param key key of the stored object.
     * @return int value of the stored object.
     */
    public int getInt(String key) {
        if (this.isInit) {
            return preferences.getInt(key, rgbcolor.asArgbInt());
        }
        LogUtil.debug(TAG, "PreferencesHelper is not initiated");
        return rgbcolor.asArgbInt();
    }
}
