plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        //applicationId = "com.exsolv.tempglovo"
        minSdk = 21
        targetSdk = 32
        //versionCode = 1
        //versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //testInstrumentationRunner = "com.exsolv.tempglovo.HiltTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFile("proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    /*compileOptions {
           sourceCompatibility JavaVersion.VERSION_1_8
           targetCompatibility JavaVersion.VERSION_1_8
       }
       kotlinOptions {
           jvmTarget = '1.8'
       }*/
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("com.google.android.material:material:1.6.0")
    implementation("io.reactivex.rxjava3:rxjava:3.1.4")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.0")


    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.41")
    //annotationProcessor("androidx.hilt:hilt-compiler:2.41")

    implementation("androidx.room:room-runtime:2.4.2")
    implementation("androidx.room:room-ktx:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")
    //annotationProcessor("androidx.room:room-compiler:2.4.2")



    //implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    //implementation 'androidx.core:core-ktx:1.7.0'
    //implementation 'androidx.appcompat:appcompat:1.4.2'
    //implementation 'com.google.android.material:material:1.6.1'
    //implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("org.mockito:mockito-inline:4.5.1")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("io.mockk:mockk-android:1.12.4")
    testImplementation("androidx.test:runner:1.4.0")
    testImplementation("androidx.test.ext:junit:1.1.3")
    testImplementation("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation("androidx.test:core:1.4.0")
    testImplementation("androidx.test:rules:1.4.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("com.jraska.livedata:testing-ktx:1.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
    //testImplementation 'junit:junit:4.13.2'
    //androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    //androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("org.mockito:mockito-core:2.21.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:core:1.4.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
    androidTestImplementation("androidx.room:room-testing:2.4.2")

    androidTestImplementation("com.google.dagger:hilt-android-testing:2.41")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.41")


}