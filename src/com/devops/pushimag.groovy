/*package com.devops

class MyDevOpsLibrary {
    def call() {
        buildDockerImage()
        runTests()
        pushToDockerHub()
    }

    static def buildDockerImage() {
        sh 'docker build -t mi-docker-image .'
    }

    static def runTests() {
        sh 'docker run mi-docker-image npm test'
    }

    static def pushToDockerHub() {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
            sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
        }
        sh 'docker tag mi-docker-image username/mi-docker-image:latest'
        sh 'docker push username/mi-docker-image:latest'
    }
}*/
