pipeline {
    agent any

    tools {
        maven('Maven 3.9.6')
    }

    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean package -Dmaven.test.skip=true"
            }
        }

        stage("UPLOAD") {
            steps {
                sh "ls -al target/"
                // sh "curl -u https://nexus_repository_url"
            }
        }

    }

}
