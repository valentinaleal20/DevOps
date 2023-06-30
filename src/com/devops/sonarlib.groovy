package com.devops

def scanner(repo_name){

    def scannerHome = tool 'sonarscan'
    
    withSonarQubeEnv('serversonarqube'){
     sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey='${repo_name}'\
        -Dsonar.projectName='${repo_name}' \
        -Dsonar.sources=${env.WORKSPACE} "
    }
}

