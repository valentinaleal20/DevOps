def call(Map params) {
    def script = params.script
    def sonarScannerHome = script.tool name: 'serversonarqube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    script.withSonarQubeEnv('serversonarqube') {
        def scannerHome = script.tool 'serversonarqube'
        script.withEnv(["PATH+SONARSCANNER=${scannerHome}/bin"]) {
            script.sh "sonar-scanner"
        }
    }
}
