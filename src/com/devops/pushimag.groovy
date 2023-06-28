package org.devops

pipeline {
    agent any 
    stages {
        stage('Build') {            
            steps {
                sh 'docker build -t mi-docker-image .'
            }
        }
        stage('Test') {            
            steps {
                sh 'docker run mi-docker-image npm test'
            }
        }
        stage('Push to Docker Hub') {            
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                }
                sh 'docker tag mi-docker-image username/mi-docker-image:latest'
                sh 'docker push username/mi-docker-image:latest'
            }
        }
    }
}
