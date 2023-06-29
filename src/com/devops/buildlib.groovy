package com.devops

def hello(Map params){
    sh 'node -v'
    sh 'npm install'
}
