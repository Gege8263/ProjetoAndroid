// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google() // Repositório do Google para bibliotecas do Android
        mavenCentral() // Repositório Maven Central
        maven("https://maven.google.com") // Repositório Maven do Android
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2") // Versão correta do Android Gradle Plugin
    }
}






