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
        
            stage('codeanalysis'){
                steps{
                    script{
                    sonarlib(this)
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