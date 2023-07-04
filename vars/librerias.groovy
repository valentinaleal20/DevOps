import com.devops.

def call(Map params) {
    pipeline {
        agent any
        tools {
            nodejs 'node'
        }
        stages {
            stage('hi') {
                steps {
                    script {
                        def buildnpm = new buildimagen()
                        buildnpm.buildimagen()
                    }
                }
            }
            stage('scan') {
                steps {
                    script {
                        def scann = new sonarlib()
                        scann.scanner()
                    }
                }        
            }
            stage('imagencont') {
                steps {
                    script {
                        def buildimag = new imagen()
                        buildimag.buildimagen()
                    }  
                }
            }
        }
    }
}