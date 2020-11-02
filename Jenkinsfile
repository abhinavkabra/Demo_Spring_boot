pipeline {
    agent any
    tools {
        maven 'mvn-install'
        jdk 'jdk'
    }
    stages {
        stage('Checkout Code') {
        	steps {
           		git changelog: false, credentialsId: 'aa94d5c1-c73f-4f50-9b7d-871104846693', poll: false, url: 'https://github.com/abhinavkabra/Jenkins-Example.git'	            
	        }
        }
        stage('Build Code') {
        	steps {
           		bat "mvn clean install"            
        	}
        }
        stage('Push Code to artifact repo') {
           
        }
    }
}