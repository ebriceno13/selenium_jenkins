pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                    sh "docker build -t=ebriceno13/testbuild ."
            }
        }
        stage('Push Image') {
            steps {
                     withCredentials([usernamePassword(credentialsId: 'dockerhub2', passwordVariable: 'pass', usernameVariable: 'user')]) {
                     //sh
                     bat "docker login --username=${user} --password=${pass}"
                     bat "docker push ebriceno13/testbuild:latest"
                            }
                   }
        }
    }
}