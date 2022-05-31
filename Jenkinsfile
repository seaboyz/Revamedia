Jenkinsfile (Declarative Pipeline)
pipeline {
    agent { docker { image 'maven:3.8.5-openjdk-8' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                bat 'set'
            }
        }
        
        stage('Deploy') {
                    steps {
                        retry(3) {
                            sh './flakey-deploy.sh'
                        }

                        timeout(time: 3, unit: 'MINUTES') {
                            sh './health-check.sh'
                        }
                    }
                }
    }
}