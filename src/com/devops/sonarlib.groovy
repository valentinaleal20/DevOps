package com.devops

def call(script) {
    def sonarScannerHome = tool name: 'serversonarqube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    script.withSonarQubeEnv('serversonarqube') {
    def scannerHome = tool 'serversonarqube'
        withEnv(["PATH+SONARSCANNER=${scannerHome}/bin"]) {
            sh "sonar-scanner"
        }
    }
}
