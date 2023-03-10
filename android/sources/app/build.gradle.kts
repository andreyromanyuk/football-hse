plugins { id("goshka133.football.app") }

android { namespace = "goshka133.football.app" }

dependencies {
  implementation(libs.compose.activity)
  implementation(libs.bundles.compose)
  implementation(libs.coroutines)

  implementation(libs.dagger)
  kapt(libs.dagger.compiler)

  implementation(libs.modo)
  implementation(project(":ui_kit"))

  // #region Di Dependencies
  implementation(project(":core_di"))
  implementation(project(":core_elmslie"))
  implementation(project(":core_navigation"))
  implementation(project(":core_network"))

  implementation(libs.okhttp)
  implementation(libs.retrofit)

  implementation(project(":domain_auth"))
  implementation(project(":feature_auth"))
}
