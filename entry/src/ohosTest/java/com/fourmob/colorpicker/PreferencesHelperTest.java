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
package com.fourmob.colorpicker;

import static org.junit.Assert.assertEquals;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.colors.RgbColor;
import ohos.agp.colors.RgbPalette;
import ohos.app.Context;
import com.fourmob.colorpicker.util.PreferencesHelper;
import org.junit.Test;

public class PreferencesHelperTest {
    private Context context;
    private PreferencesHelper helper;

    private final static String PREF_NAME = "Test";
    private final static String KEY_VALUE = "check";
    private final static RgbColor color = RgbPalette.YELLOW;

    @Test
    public void testgetPositiveInt() {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        helper = PreferencesHelper.getInstance();
        helper.init(context, PREF_NAME, color);
        helper.putInt(KEY_VALUE,1);
        int val = helper.getInt(KEY_VALUE);
        assertEquals(1, val);
    }

    @Test
    public void testgetNegativeInt() {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        helper = PreferencesHelper.getInstance();
        helper.init(context, PREF_NAME, color);
        helper.putInt(KEY_VALUE,-10);
        int val = helper.getInt(KEY_VALUE);
        assertEquals(-10, val);
    }

    @Test
    public void testgetIntWithNull() {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        helper = PreferencesHelper.getInstance();
        helper.init(context, PREF_NAME, color);
        int val = helper.getInt("firstcheck");
        assertEquals(color.asArgbInt(), val);
    }
}
