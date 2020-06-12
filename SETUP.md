# Setup Notes

This process contains information for building on Ubuntu 18.

1. Install Java ```sudo apt-get install default-jdk```
2. Install Gradle (https://gradle.org/install/)
   1. Install SDKMAN! (https://sdkman.io/install)
      1. ```curl -s "https://get.sdkman.io" | bash```
      2. ```source "$HOME/.sdkman/bin/sdkman-init.sh"```
      3. ```sdk version```
   2. Install Gradle using SDKMAN! ```sdk install gradle 6.5```
3. Make a directory for the repository ```mkdir ccri-neighborhood-exercise```
4. Change to the project directory ```cd ccri-neighborhood-exercise```
5. Initialize the directory as a Gradle project ```gradle init --type java-application```