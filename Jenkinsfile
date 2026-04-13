pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/SNEHALSJUVEKAR/MyMavenSeleniumApp03.git',
                    credentialsId: 'GitHubCredential'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo ' Build and Test successful!'
        }
        failure {
            echo ' Build failed!'
        }
    }
}
