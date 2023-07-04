package com.devops

def call(Map params) {
    def dockerUsername = params.dockerUsername
    def dockerPassword = params.dockerPassword
    
    sh "docker build -t fase2 ."
    sh "docker login -u ${dockerUsername} -p ${dockerPassword}"
    sh 'docker run mi-docker-image npm test'
    sh 'docker tag mi-docker-image username/mi-docker-image:latest'
    sh 'docker push username/mi-docker-image:latest'
}