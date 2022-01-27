# Overview

Starting with Android OS 12, the system default splash screen always applies to cold and warm starts for all apps. <br>
See https://developer.android.com/about/versions/12/features/splash-screen#how for how the OS12 splash screen works. <br>
This causes the following issues if you are creating a custom splash screen in your app <br>
- On OS: 12 or later, "System default splash screen" and custom splash screens are displayed.
- The splash screen displayed up to OS: 11 and after OS: 12 are different.

In this repository, we have released a sample application that uses a compatible library and applies the same splash screen to all OS versions. <br>

[日本語版README](https://github.com/LeoAndo/android12-splash-screen/blob/main/readme/README_JP.md)

# development environment

<img width="686" alt="スクリーンショット 2022-01-27 13 56 37" src="https://user-images.githubusercontent.com/16476224/151294522-b048519a-04c4-4ddc-a220-7b9fbece1b8e.png">


# capture

| Pixel 4 OS12 | Pixel 4 OS8 |
|:---|:---:|
|<img src="https://user-images.githubusercontent.com/16476224/143677726-69bbd10f-d75c-4ed8-b9a8-7fba87cc85e7.gif" width=320 /> |<img src="https://user-images.githubusercontent.com/16476224/143677731-88fd9eac-8d5d-4888-b0ab-8301353c6474.gif" width=320 /> |

# coding flow
https://github.com/LeoAndo/android12-splash-screen/pulls?q=is%3Apr+label%3AcodingFlow+is%3Aclosed<br>

# java code
https://github.com/LeoAndo/android12-splash-screen/tree/main/BasicAppSample/app/src/javaVersion/java/com/example/basicappsample<br>

# kotlin code
https://github.com/LeoAndo/android12-splash-screen/tree/main/BasicAppSample/app/src/kotlinVersion/java/com/example/basicappsample<br>

# compose code
https://github.com/LeoAndo/android12-splash-screen/tree/main/BasicComposeAppSample<br>

# refs
https://github.com/LeoAndo/android-dev-summit-2021/issues/5#issuecomment-970318757<br>
https://developer.android.com/guide/topics/ui/splash-screen/migrate<br>
https://developer.android.com/about/versions/12/features/splash-screen<br>
