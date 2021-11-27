# Overview

Android OS 12以降では、システムのデフォルトスプラッシュ画面が、すべてのアプリのコールドスタートおよびウォームスタートに常に適用される。<br>
OS12のスプラッシュ画面の仕組みについては https://developer.android.com/about/versions/12/features/splash-screen#how 参照。<br>
これにより、アプリでカスタムのスプラッシュ画面を作成している場合、以下の問題が発生します<br>
- OS:12以降で「システムのデフォルトのスプラッシュ画面」とカスタムのスプラッシュ画面が２つ表示される
- OS:11までとOS:12以降で表示するスプラッシュ画面が異なってしまう

本リポジトリでは、互換ライブラリを使用し、全てのOSバージョンで同じスプラッシュ画面を適用するサンプルアプリを公開しています.<br>

# capture

| Pixel 4 OS12 | Pixel 4 OS8 |
|:---|:---:|
|<img src="https://user-images.githubusercontent.com/16476224/143677726-69bbd10f-d75c-4ed8-b9a8-7fba87cc85e7.gif" width=320 /> |<img src="https://user-images.githubusercontent.com/16476224/143677731-88fd9eac-8d5d-4888-b0ab-8301353c6474.gif" width=320 /> |

# coding flow
https://github.com/LeoAndo/android12-splash-screen/pulls?q=is%3Apr+is%3Aclosed<br>

# refs
https://github.com/LeoAndo/android-dev-summit-2021/issues/5#issuecomment-970318757<br>
https://developer.android.com/guide/topics/ui/splash-screen/migrate<br>
https://developer.android.com/about/versions/12/features/splash-screen<br>
