package com.devops

def call(script){
    script.withSonarQubeEnv('sonarqube'){
        bat "mvn clean verify sonar:sonar"
        }
    script.withSonarQubeEnv('sonarqube'){
        timeout(time: 3, unit: 'MINUTES'){
        waitForQualityGate abortPipeline: true 
        }
    }
}
