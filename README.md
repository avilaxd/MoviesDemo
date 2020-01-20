# MoviesDemo

<img src="https://user-images.githubusercontent.com/9456286/72633334-dcd4f480-391d-11ea-877e-9e5ece3f0b2b.gif" width="250" align="right">

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
- [Retrofit:][7] a type-safe HTTP client.
- [ConstraintLayout:][8] a ViewGroup that allows you to position and size widgets in a flexible way.
- [RecyclerView:][9] a flexible view for providing a limited window into a large data set.
- [Picasso:][10] a powerful image downloading and caching library for Android.


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

## Screenshots
<p float="left">
  <img src="https://user-images.githubusercontent.com/9456286/72633336-dcd4f480-391d-11ea-85fc-13cedf81b73a.png" width="250" />
  <img src="https://user-images.githubusercontent.com/9456286/72633337-dcd4f480-391d-11ea-9a75-4ced89786011.png" width="250" /> 
  <img src="https://user-images.githubusercontent.com/9456286/72633333-dc3c5e00-391d-11ea-9904-7e3ccb937280.png" width="250" />
</p>

## Changelog
- **Jan 10, 2020:** initial commit.
