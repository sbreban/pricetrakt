pipeline {
    agent any
    tools {
        maven 'MAVEN'
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -D clean package'
            }
        }
    }
}