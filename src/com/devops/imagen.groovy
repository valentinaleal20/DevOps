package com.devops

def call() {
    withCredentials([string(credentialsId: 'tockendockerhub', variable: 'DOCKER_TOKEN')]) {
        sh "docker build -t fase2 ."
        
        docker.withRegistry('https://registry-1.docker.io', 'dockerhub-tockendockerhub') {
            sh 'docker login -u token -p $DOCKER_TOKEN'
            sh 'docker run mi-docker-image npm test'
            sh 'docker tag mi-docker-image username/mi-docker-image:latest'
            sh 'docker push username/mi-docker-image:latest'
        }
    }
}