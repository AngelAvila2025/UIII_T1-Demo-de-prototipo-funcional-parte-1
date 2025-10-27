plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}


android {
    namespace = "mx.edu.utez.carrazosv3"
    compileSdk = 36

    defaultConfig {
        applicationId = "mx.edu.utez.carrazosv3"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    // 🚀 Habilita Jetpack Compose
    buildFeatures {
        compose = true
    }

}

dependencies {
    // ===== Compose BOM (controla versiones internas automáticamente) =====
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))

    // ===== Componentes principales de Jetpack Compose =====
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.runtime:runtime")

    // ===== Material 3 (Botones, estilos, tipografía, etc.) =====
    implementation("androidx.compose.material3:material3")

    // ===== Navegación en Compose =====
    implementation("androidx.navigation:navigation-compose:2.8.3")

    // ===== Activity Compose (para setContent en actividades) =====
    implementation("androidx.activity:activity-compose:1.9.3")

    // ===== Librerías base de AndroidX =====
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")

    // ===== Material Design clásico (opcional, por compatibilidad) =====
    implementation("com.google.android.material:material:1.12.0")

    // ===== Dependencias para pruebas =====
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // ===== Herramientas de depuración =====
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
