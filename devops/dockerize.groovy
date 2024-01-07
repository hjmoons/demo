def REGISTRY_URL=

pipeline {
    agent any

    tools {
        maven('Maven 3.9.6')
    }

    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean package -Dmaven.test.skip=true"
                sh "ls -al target/"
            }
        }

        stage("DOCKERIZE") {
            steps {
                docker.withRegistry('hub.docker.com', 'docker-token') {
                    app = docker.build("mhj592/demo")
                    app.push("latest")
                }
            }
        }
    }

}