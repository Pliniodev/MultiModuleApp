object Versions {
    const val lifecycleExtensionsVersion = "2.2.0"
    const val lifecycleViewModelVersion = "2.3.1"
    const val lifecycleLiveDataVersion = "2.4.0"
    const val coroutinesVersion = "1.4.3"
    const val koinVersion = "3.0.2"
    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.8.6"
    const val gsonConverterVersion = "2.9.0"
    const val okHttpVersion = "4.9.1"
    const val okHttpLoggingVersion = "4.9.1"
    const val roomRuntimeVersion = "2.3.0"
    const val roomCompilerVersion = "2.3.0"
    const val dataBindingCompilerVersion = "3.1.4"
    const val rxJavaVersion = "3.0.0"
    const val rxKotlinVersion = "3.0.0"
    const val gradleVersion = "7.0.3"
    const val kotlinVersion = "1.5.31"
    const val androidXCoreVersion = "1.6.0"
    const val appCompatVersion = "1.4.0"
    const val materialVersion = "1.4.0"
    const val constraintLayoutVersion = "2.1.2"
    const val jUnitVersionVersion = "4.13.2"
    const val androidJUnitVersion = "1.1.3"
    const val espressoVersion = "3.4.0"
    const val glideVersion = "4.12.0"
    const val glideCompilerVersion = "4.12.0"
    const val mockkVersion = "1.12.1"
    const val assertjVersion = "3.21.0"
    //Compose
    const val activityComposeVersion = "1.3.1"
    const val composeMaterialVersion = "1.0.5"
    const val composeAnimationsVersion = "1.0.5"
    const val composeUiToolingVersion = "1.0.5"
    const val composeViewModelLifeCycleVersion = "1.0.0-alpha07"
    const val composeThemeAdapterVersion = "1.0.5"

}

object ConfigData {
    const val compileSdkVersion = 31
    const val minSdkVersion = 23
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildPlugins {
    val gradle_build = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    val kotlin_build = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Dependencies {
    val lifecycleExtensions =  "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"
    val lifecycleLiveData =  "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLiveDataVersion}"
    val koin = "io.insert-koin:koin-android:${Versions.koinVersion}"
    val koinExt = "io.insert-koin:koin-android-ext:${Versions.koinVersion}"
    val koinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koinVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterVersion}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingVersion}"
    val room = "androidx.room:room-runtime:${Versions.roomRuntimeVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompilerVersion}"
    val roomForCoroutines = "androidx.room:room-ktx:${Versions.roomRuntimeVersion}"
    val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxJavaVersion}"
    val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJavaVersion}"
    val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxKotlinVersion}"
    val rxAdapter = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxJavaVersion}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    val androidXCore = "androidx.core:core-ktx:${Versions.androidXCoreVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    val material = "com.google.android.material:material:${Versions.materialVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompilerVersion}"
    val dataBindingCompiler = "com.android.databinding:compiler:${Versions.dataBindingCompilerVersion}"
    val jUnit = "junit:junit:${Versions.jUnitVersionVersion}"
    val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"

    val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnitVersion}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    val assertj = "org.assertj:assertj-core:${Versions.assertjVersion}"
    //Compose
    val activityCompose = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterialVersion}"
    val composeAnimations = "androidx.compose.animation:animation:${Versions.composeAnimationsVersion}"
    val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUiToolingVersion}"
    val composeViewModelLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModelLifeCycleVersion}"
    val composeThemeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.composeThemeAdapterVersion}"
}

object AndroidModule {
    val main = listOf(
        Dependencies.lifecycleExtensions,
        Dependencies.lifecycleViewModel,
        Dependencies.lifecycleLiveData,
        Dependencies.androidXCore,
        Dependencies.appCompat,
        Dependencies.material,
        Dependencies.constraintLayout,
        Dependencies.dataBindingCompiler
    )
}

object DiModule {
    val main = listOf(
        Dependencies.koin,
        Dependencies.koinExt,
        Dependencies.koinWorkManager
    )
}

object AnnotationProcessorsModule{
    val main = listOf(
        Dependencies.roomCompiler,
        Dependencies.glideCompiler,

    )
}

object RoomModule {
    val main = listOf(
        Dependencies.room,
        Dependencies.roomForCoroutines
    )
}

object NetworkModule {
    val withCoroutines = listOf(
        Dependencies.coroutines,
        Dependencies.gson,
        Dependencies.gsonConverter,
        Dependencies.retrofit,
        Dependencies.okHttp,
        Dependencies.okHttpLogging
    )

    val withRx = listOf(
        Dependencies.rxAndroid,
        Dependencies.rxJava,
        Dependencies.rxKotlin,
        Dependencies.rxAdapter,
        Dependencies.gson,
        Dependencies.gsonConverter,
        Dependencies.retrofit,
        Dependencies.okHttp,
        Dependencies.okHttpLogging
    )
}

object Compose {
    val main = listOf(
        Dependencies.activityCompose,
        Dependencies.composeMaterial,
        Dependencies.composeAnimations,
        Dependencies.composeUiTooling,
        Dependencies.composeViewModelLifeCycle,
        Dependencies.composeThemeAdapter,
    )
}

object TestModule {
    val main = listOf(
        Dependencies.jUnit,
        Dependencies.mockk,
        Dependencies.coroutinesTest,
        Dependencies.assertj
    )
}

object AndroidTestModule {
    val main = listOf(
        Dependencies.androidJUnit,
        Dependencies.espresso,
        Dependencies.mockkAndroid
    )
}