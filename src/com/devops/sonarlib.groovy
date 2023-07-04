package com.devops

def call(script){
    script.withSonarQubeEnv('serversonarqube'){
        bat "mvn clean verify sonar:sonar"
        }
    script.withSonarQubeEnv('serversonarqube'){
        timeout(time: 3, unit: 'MINUTES'){
        waitForQualityGate abortPipeline: true 
        }
    }
}
