pipeline {
    agent any

    tools {
        maven('Maven 3.6.3')
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
                script {
                    //docker.withRegistry('https://registry.hub.docker.com', 'docker-token') {
                    docker.withRegistry('http://192.168.0.27:5000', 'nexus-account') {
                        app = docker.build("demo/demo:0.0.1")
                        app.push("0.0.1")
                    }
                }
            }
        }

    }
}