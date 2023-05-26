package org.devops

def buildimagen(Map params){
    sh "docker build -t ${params.builimagen} ."  
}