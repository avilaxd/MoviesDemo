plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

dependencies {
    api(project(Modules.domain))
    implementation(fileTree(Dependencies.fileTree))
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.hilt)
}