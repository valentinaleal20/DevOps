package org.devops

def buildimagen(){
    sh "docker build -t ${params.buildimagen} ."  
}