def call(Map params){

    pipeline {
        agent any

        stages {
            stage('hi') {
                steps {
                    script {
                        def build = new com.devops.buildlib()
                        build()
                    }
                }
                
            }
        
            stage('scan') {
                steps {
                    script {
                        def scann = new com.devops.sonarlib()
                        scann.scanner()
                    }  
                }        
            }
       
            stage('imagencont') {
                steps {
                    script {
                        def buildimag = new com.devops.imagen()
                        buildimag.buildimagen()
            }  
        }
    }
}
    }
}