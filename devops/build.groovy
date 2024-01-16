pipeline {
    agent any

    tools {
        maven('Maven 3.6.3')
    }

    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean compile deploy -s settings.xml -Dmaven.test.skip=true -Dmaven.project.version=0.0.2"
            }
        }

        stage("UPLOAD") {
            steps {
                sh "ls -al target/"
            }
        }

    }

}
