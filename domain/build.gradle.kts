plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

dependencies {
    api(Dependencies.kotlin)
    api(Dependencies.coroutinesCore)
}