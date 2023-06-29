package com.devops

def buildimagen(){
    sh "docker build -t fase2 ."  
}