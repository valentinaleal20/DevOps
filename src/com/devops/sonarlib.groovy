package com.devops

def sonar(){
    def scannerHome = tool "sonarscan" 
    sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=reto \
        -Dsonar.projectName=reto \
        -Dsonar.projectVersion=1.0 \
        -Dsonar.sources=/var/jenkins_home/workspace/jobprueba3 \
        -Dsonar.host.url=http://sonarqube:9000 \
        
}
