def call(Map params){

    pipeline {
        agent any

        stages {
            stage('saludo') {
                steps {
                    script {
                        def build = new com.devops.buildlib()
                        build.hello()
                    }
                }
                
            }
        
            stage('scan') {
                steps {
                    script {
                        def scann = new com.devops.sonarlib()
                        scann.sonar()
                    }  
                }        
            }
        }
    }
}