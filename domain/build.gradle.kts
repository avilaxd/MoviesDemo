plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

dependencies {
    implementation(fileTree(Dependencies.fileTree))
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coroutinesCore)
}