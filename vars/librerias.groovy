import com.devops.MyDevOpsLibrary

def call(Map params){
    
    pipeline {
        agent any
        tools {
            nodejs 'node'
            }

        stages {
            stage('hi') {
                steps {
                    script {
                        def buildnpm = new com.devops.buildlib()
                        buildnpm.build()
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
            stage('DevOps Workflow') {
                MyDevOpsLibrary pushimag = new MyDevOpsLibrary()
                pushimag()
            }
         }
    }
}