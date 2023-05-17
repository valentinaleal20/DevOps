def call(Map params){

    pipeline {
        agent any

        stages {
            /*stage('build') {
                steps {
                    script {
                        def build = new com.devops.BuildLib()
                        build.hello(mensaje: params.mensaje, variable: params.variable)
                    }
                }
                
            }*/
        
            stage('scan') {
                steps {
                    script {
                        def x = new com.devops.sonarqube()
                        x.scan()
                    }  
                }        
            }
        }
    }
}