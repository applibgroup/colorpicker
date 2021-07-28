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

package com.fourmob.colorpicker.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.colors.RgbPalette;
import ohos.agp.components.Button;
import ohos.agp.window.dialog.ToastDialog;
import com.fourmob.colorpicker.ColorPickerDialog;
import com.fourmob.colorpicker.ColorPickerPalette;
import com.fourmob.colorpicker.ResourceTable;

/**
 * Main Ability Slice.
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        int numColumns = 3;
        final ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this);
        colorPickerDialog.initialize(ResourceTable.String_dialog_title, new RgbColor[] { RgbPalette.CYAN, RgbPalette
                .LIGHT_GRAY, RgbPalette.BLACK, RgbPalette.BLUE, RgbPalette.GREEN, RgbPalette.MAGENTA, RgbPalette
                .RED, RgbPalette.GRAY, RgbPalette.YELLOW }, RgbPalette.YELLOW, numColumns, ColorPickerPalette
                .SMALL_SWATCH);
        colorPickerDialog.setOnColorSelectedListener(color -> new ToastDialog(MainAbilitySlice.this)
                .setText("selectedColor : " + color.asArgbInt()).show());
        Button showbtn = (Button) findComponentById(ResourceTable.Id_button);
        showbtn.setClickedListener(component -> colorPickerDialog.show());

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
