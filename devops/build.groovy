def RELEASE_VERSION = params.RELEASE_VERSION

pipeline {
    agent any

    tools {
        maven('Maven 3.6.3')
    }

    stages {

        stage("BUILD") {
            steps {
                sh "mvn clean compile deploy -s settings.xml -Dmaven.test.skip=true -Dproject.version=${RELEASE_VERION}"
            }
        }

        stage("UPLOAD") {
            steps {
                sh "ls -al target/"
            }
        }

    }

}
