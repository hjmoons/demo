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
                sh "docker --version"
            }
        }

        stage("DOCKERIZE") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-token') {
                        app = docker.build("mhj592/demo")
                        app.push("latest")
                    }
                }
            }
        }

    }
}