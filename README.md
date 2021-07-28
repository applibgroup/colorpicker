# ColorPicker
HarmonyOS library that allow us to pick a color from a palette.

# Source
This library is inspired by [ColorPicker](https://github.com/flavienlaurent/colorpicker) library.

# Features
This library allows us to select a color from the palette. We can also add different colors to the palette.

# Dependency
1. For using ExpandableRecyclerView module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/colorpicker.har.
``` java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar', '*.har'])
    testImplementation 'junit:junit:4.13'
    implementation project(':colorpicker')
}
```
2. For using ExpandableRecyclerView in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
``` java
dependencies {
	implementation fileTree(dir: 'libs', include: ['*.har'])
	testImplementation 'junit:junit:4.13'
}
```

# Usage
