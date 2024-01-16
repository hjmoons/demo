pipeline {
    agent any

    tools {
        maven('Maven 3.6.3')
    }

    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean compile deploy -s setting.xml -Dmaven.test.skip=true"
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
