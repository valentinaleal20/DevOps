package com.devops

def call() {
    withCredentials([string(credentialsId: 'tokendockerhub', variable: 'DOCKER_TOKEN')]) {
        sh "docker build -t fase2 ."
        sh "docker login -u token -p $DOCKER_TOKEN"
        sh 'docker run mi-docker-image npm test'
        sh 'docker tag mi-docker-image username/mi-docker-image:latest'
        sh 'docker push username/mi-docker-image:latest'
    }
}