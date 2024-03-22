# Declarative Gradle - Unified Plugin Prototypes - AGP version

`unified-prototype/plugin-android` contains wrapper that has all proper `@required` annotations that 
translates DSL to AGP

`testbed-android` empty declarative android application with `build.gradle.something` file. 
You can open PSD and try changing/adding properties there. Editing of `something` file is supported
by current `studio-main` branch.


### Limitations

The Android example is currently limited, and does not support many use cases such as adding tests or running the `publish` task.
It requires JDK >= 17 to build.

### Running 
From the `testbed-android` directory, run `build` using the Gradle wrapper in the parent directory:

```shell
cd testbed-android
../gradlew build
```

to build debug and release `aar`s for the example Android project build in the `testbed-android/build/outputs/aar` directory.

You can also build the `Debug` and `Release` variants separately:

```shell 
cd testbed-android
../gradlew :testbed-android:assembleDebug
```

```shell 
cd testbed-android
../gradlew :testbed-android:assembleRelease
```