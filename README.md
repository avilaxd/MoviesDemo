# MoviesDemo

<img src="https://user-images.githubusercontent.com/9456286/77485076-e1bc9580-6df1-11ea-8a26-7fa62eb86da9.gif" width="250" align="right">

MoviesDemo is a demo project developed by me (Armando Ávila Bueno) as part of my resume in order to show recruiters the way 
I code and the knowledge I have about Android development.

The app shows a list of recent movies and if you click on one of those movies it'll take you to the detail of that movie, 
displaying stuff like title, rating, synopsis, cast members and some images related to the movie. It gets its data from the [TMDB](https://www.themoviedb.org) API.
The app is entirely written in Kotlin following the MVVM pattern.

The project is meant to keep updating with new features, implementing best practices and the latests Android technologies.

## Project Setup

Setup should be pretty straight forward, you'll only need Android Studio 3.5 or later to open the project and an Android 
device/emulator running Android 21+ if you want to install it.

## Libraries Used
- [Android Jetpack:][0] a suite of libraries, tools, and guidance to help developers write high-quality apps easier.
  - [Live Data:][1] an observable class with lifecycle awareness.
  - [Navigation:][2] new and easier ways to navigate across your app.
  - [ViewModel:][3] stores and manage UI-related data in a lifecycle conscious way.
  - [ViewPager2:][4] improved version of the ViewPager library.
  - [AndroidX][5] an improvement to the [Support Library][6].
  - [RecyclerView:][9] a flexible view for providing a limited window into a large data set.
  - [Room:][12] provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
  - [Databinding:][13] bind UI components in your layouts to data sources in your app using a declarative format.
  - [Hilt:][14] is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- [Retrofit:][7] a type-safe HTTP client.
- [ConstraintLayout:][8] a ViewGroup that allows you to position and size widgets in a flexible way.
- [Picasso:][10] a powerful image downloading and caching library for Android.
- [Dagger2:][11] is a fully static, compile-time dependency injection framework for both Java and Android.
- [Coroutines:][15] is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.


[0]: https://developer.android.com/jetpack
[1]: https://developer.android.com/topic/libraries/architecture/livedata
[2]: https://developer.android.com/guide/navigation/
[3]: https://developer.android.com/topic/libraries/architecture/viewmodel
[4]: https://developer.android.com/training/animation/vp2-migration
[5]: https://developer.android.com/jetpack/androidx
[6]: https://developer.android.com/topic/libraries/support-library/index
[7]: https://square.github.io/retrofit/
[8]: https://developer.android.com/reference/android/support/constraint/ConstraintLayout
[9]: https://developer.android.com/reference/android/support/v7/widget/RecyclerView
[10]: https://square.github.io/picasso/
[11]: https://dagger.dev/
[12]: https://developer.android.com/jetpack/androidx/releases/room
[13]: https://developer.android.com/jetpack/androidx/releases/databinding
[14]: https://developer.android.com/training/dependency-injection/hilt-android
[15]: https://developer.android.com/kotlin/coroutines

## Screenshots
<p float="left">
  <img src="https://user-images.githubusercontent.com/9456286/77485085-e7b27680-6df1-11ea-8cf8-db5128655292.png" width="250"/>
  <img src="https://user-images.githubusercontent.com/9456286/77485093-e97c3a00-6df1-11ea-9600-3c3392273f97.png" width="250"/> 
  <img src="https://user-images.githubusercontent.com/9456286/77485090-e8e3a380-6df1-11ea-94c0-15f7dfe5315c.png" width="250"/>
  <img src="https://user-images.githubusercontent.com/9456286/77485089-e84b0d00-6df1-11ea-9349-7a05507a1b95.png" width="250"/>
</p>

## Changelog
- **Jun 24, 2020:** implementation of Coroutines.
- **Jun 17, 2020:** migrating dependency injection from Dagger to Hilt.
- **Jun 12, 2020:** implementation of Databinding with Android Jetpack.
- **Mar 24, 2020:** implementation of a SQLite database for favorites using Room.
- **Feb 23, 2020:** implementation of Dependency Injection using Dagger2.
- **Jan 10, 2020:** initial commit.
