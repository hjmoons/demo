pipeline {
    agent any

    tools {
        maven('maven3.9.6')
    }
    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean package -Dmaven.test.skip=true"
            }
        }

        stage("TEST") {
            steps {
                sh "ll target/"
            }
        }

    }

}