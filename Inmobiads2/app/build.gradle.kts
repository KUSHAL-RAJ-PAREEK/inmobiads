import org.gradle.internal.impldep.bsh.commands.dir

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.testapp.inmobiads"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.testapp.inmobiads"
        minSdk = 24
        multiDexEnabled = true
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation("com.inmobi.monetization:inmobi-ads:10.1.3")


    //google play service client libraries
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    //chrome custom library
    implementation("androidx.browser:browser:1.4.0")

    //picaso library for Ad assets
    implementation("com.squareup.picasso:picasso:2.8")

    //supporting page scroll library
    implementation("androidx.viewpager:viewpager:1.0.0")

    //androidx recyclerview library
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    //Ad set libraries
    implementation("com.google.android.gms:play-services-appset:16.0.2")
    implementation("com.google.android.gms:play-services-tasks:18.0.2")

    //multidex library
    implementation("androidx.multidex:multidex:2.0.1")


}