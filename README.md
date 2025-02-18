## Kotlin Multiplatform multi-module template for Android/iOS

<p>
  <img src="https://img.shields.io/badge/kotlin-multiplatform-A97BFF.svg"/>
  <img src="https://img.shields.io/badge/compose-multiplatform-5675DF.svg"/>
  <img src="https://img.shields.io/badge/platform-android-green.svg"/>
  <img src="https://img.shields.io/badge/platform-iOS-black.svg"/>
</p>

This template is based on [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) and [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/) for developing both Andorid and iOS apps.
It is modularized into several *feature* modules and *core* modules, and **new modules can be easily added** using already defined Custom Gradle Plugins and Version Catalog.
In addition, **essential libraries** that support multi-platforms such as [coil](https://coil-kt.github.io/coil/), [ktor](https://ktor.io/), and [koin](https://insert-koin.io/) have been added, and **awesome lint tools** such as [spotless](https://github.com/diffplug/spotless) and [detekt](https://detekt.dev/) have already been applied in optimal configuration.
**Now let’s create a KMP multi-module project quickly and easily!**

<br>

## Support
- Kotlin 2.1.10
- Compose Multiplatform 1.7.1
- AGP 8.8.0

<br>

## Multi Module
<p align="center">
<img width="720" src="https://github.com/user-attachments/assets/e01f0ac2-befc-40ba-a30a-5d4cb3c15ebe" />
</p>

<table>
  <tr>
   <td><strong>Name</strong>
   </td>
   <td><strong>Responsibilities</strong>
   </td>
  </tr>
  <tr>
   <td><code>app</code>
   </td>
   <td>Brings everything together required for the app to function correctly. This includes UI scaffolding and navigation. 
   </td>
  </tr>
  <tr>
   <td><code>feature:main</code><br>
   </td>
   <td>Functionality associated with a specific feature or user journey. Typically contains UI components and ViewModels which read data from other modules.<br>
   </td>
  </tr>
  <tr>
   <td><code>core:data</code>
   </td>
   <td>Fetching app data from multiple sources, shared by different features.
   </td>
  </tr>
  <tr>
   <td><code>core:designsystem</code>
   </td>
   <td>Design system which includes Core UI components such as customized Material 3 components. 
   </td>
  </tr>
  <tr>
   <td><code>core:ui</code>
   </td>
   <td>Composite UI components and resources used by feature modules. Unlike the <code>designsystem</code> module, it is dependent on the data layer since it renders models. 
   </td>
  </tr>
  <tr>
   <td><code>core:common</code>
   </td>
   <td>Common classes shared between modules.
   </td>
  </tr>
  <tr>
   <td><code>core:network</code>
   </td>
   <td>Making network requests and handling responses from a remote data source.
   </td>
  </tr>
  <tr>
   <td><code>core:datastore</code>
   </td>
   <td>Storing persistent data using DataStore.
   </td>
  </tr>
  <tr>
   <td><code>core:database</code>
   </td>
   <td>Local database storage using Room.
   </td>
  </tr>
  <tr>
   <td><code>core:model</code>
   </td>
   <td>Model classes used throughout the app.
   </td>
  </tr>
</table>

> Now you can add feature modules as you want!

<br>

## Dependencies

### Kotlin
- kotlinx-coroutines
- kotlinx-datetime
- kotlinx-serialization

### Navigation
- navigation-compose

### Data
- [Okio](https://square.github.io/okio/)
- DataStore
- SQLite
- Room
- [Ktor](https://ktor.io/)
- [Ktorfit](https://foso.github.io/Ktorfit/)

### DI
- [Koin](https://insert-koin.io/)

### Image
- [Coil](https://coil-kt.github.io/coil/)

### Lint
- [Spotless](https://github.com/diffplug/spotless)
- [Ktlint](https://github.com/pinterest/ktlint)
- [detekt](https://detekt.dev/)
- [twitter-compose-rule](https://github.com/twitter/compose-rules)

<br>

## How to use
1. First, modify `rootProject.name` on root `settings.gradle.kts`.
2. Replace all `dev.yjyoon.template` string to your package name. (Use `cmd(ctrl)`+`shift`+`R` on Android Studio)
3. Replace all `template` string to your project name.
4. Rename all package directories to your package name. (You can change all package directory names at once through Android Studio)
5. Input your name to license header on `SpotlessPlugin.kt` 
6. Finally, `clean` your project.

### Gradle tasks
```java
// format your codes with ktlint rules
./gradlew spotlessCheck
./gradlew spotlessApply

// run code static analysis with twitter compose rules
./gradlew detekt

// generate project dependency graph (need to install graphviz)
./gradlew projectDependencyGraph
```

<br>

## References
Thanks to all the projects that helped create this template!
- https://github.com/android/nowinandroid
- https://github.com/DroidKaigi/conference-app-2024
- https://github.com/droidknights/DroidKnightsApp
- https://github.com/serbelga/Todometer-KMP

