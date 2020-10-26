pipeline {
    agent any
    stages {
        stage('Checkout Code') {
           git changelog: false, credentialsId: 'aa94d5c1-c73f-4f50-9b7d-871104846693', poll: false, url: 'https://github.com/abhinavkabra/simple-app.git'
        }
        stage('Build Code') {
           mvn clean install
        }
    }
}