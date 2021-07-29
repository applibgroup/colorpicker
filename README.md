[![Build](https://github.com/applibgroup/colorpicker/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/colorpicker/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_colorpicker&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_colorpicker)

# ColorPicker
HarmonyOS library that allows us to pick a color from a color palette.

![ColorPicker_Sample](https://user-images.githubusercontent.com/77639268/127439758-fcbf330c-c1f8-44e5-a7c5-5b7d47b0e2c9.gif)

# Source
This library is inspired by [ColorPicker](https://github.com/flavienlaurent/colorpicker) library.

# Features
* This library allows user to select a color from the palette. 
* User can also add different colors to the palette as per his wish.
* Also allows the user to set the default selected color.
* User can also set the title of the dialog.

# Dependency
1. For using ColorPicker module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/colorpicker.har.
``` java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar', '*.har'])
    testImplementation 'junit:junit:4.13'
    implementation project(':colorpicker')
}
```
2. For using ColorPicker in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
``` java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.har'])
    testImplementation 'junit:junit:4.13'
}
```

# Usage
The usage of this library is very simple. In the main ability slice, Create an object of `ColorPickerDialog`. Then initialize it by passing the titleId (for the dialog title), colors (that will be displayed on the palette), the default selected color, number of columns of the palette and the size of the swatch (ColorPickerPalette.SMALL_SWATCH for small size and ColorPickerPalette.LARGE_SWATCH for large size)

The selected color from the palette can be retrieved using `setOnColorSelectedListener`.

```java
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
```

# License
```
Copyright 2013 Flavien Laurent

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
