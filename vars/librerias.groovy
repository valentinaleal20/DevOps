def call(Map params){

    pipeline {
        agent any

        stages {
            stage('hello') {
                steps {
                    script {
                        def v = new com.devops.buildlib()
                        v.hello(name: params.name)
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