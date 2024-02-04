pipeline {
    agent any

    tools {
        maven('Maven 3.6.3')
    }

    stages {

        stage("BUILD") {
            steps {
                //sh "mvn clean compile deploy -s settings.xml -Dmaven.test.skip=true -Dproject.version=${RELEASE_VERION}"
                sh "mvn clean compile deploy -s settings.xml -Dmaven.test.skip=true -Dproject.version=0.0.3"
            }
        }

        stage("UPLOAD") {
            steps {
                sh "ls -al target/"
            }
        }

    }

}
