def call(Map params){

    pipeline {
        agent any

        stages {
            stage('hi') {
                steps {
                    script {
                        def build = new com.devops.buildlib()
                        build.hello(saludo:'hola')
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
       
            stage('Run') {
                steps {
                        sh 'docker run -d --name reto -p 8087:5500 fase2'
                    }
            }  
        }
    }
}