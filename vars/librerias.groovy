def call(Map params){

    pipeline {
        agent any

        stages {
            stage('build') {
                steps {
                    script {
                        def build = new com.devops.buildlib()
                        build.hello(name: params.name)
                    }
                }
                
            }
        
            stage('scan') {
                steps {
                    script {
                        def x = new com.devops.sonarlib()
                        x.sonar()
                    }  
                }        
            }
        }
    }
}