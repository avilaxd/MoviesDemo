plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

dependencies {
    api(project(Modules.domain))
    api(Dependencies.hilt)
}