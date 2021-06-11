pipeline {
    triggers {
        pollSCM('') // Enabling being build on Push
    }
    agent any
	options {
		buildDiscarder(logRotator(numToKeepStr:'50'))
		disableConcurrentBuilds()
	}
	
	stages {
        stage('Clone sources') {
            steps {
                git url: 'git@github.com:cyber-geiger/toolbox-cor.git',credentialsId: 'GEIGER_deployment', branch: env.BRANCH_NAME
            }
        }

        stage('Gradle build') {
            steps {
                sh './gradlew clean build jar javadoc --no-daemon' 
            }
        }

        stage('Main test') {
            steps {
				script{
					try {
						sh './gradlew test --no-daemon' //run a gradle task
					} finally {
						junit '**/build/test-results/test/*.xml' 
					}
                }
            }
        }

        stage('Gradle publish') {
            steps {
                sh './gradlew -Dgradle.user.home=$HOME/.gradle publish --no-daemon'
            }
        }

    }
    post {
        always {
          publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'toolbox-core/build/reports/tests/test/', reportFiles: 'index.html', reportName: 'GEIGER core Report', reportTitles: 'GEIGER-core'])
        }
        success {
            archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
			step([$class: 'JavadocArchiver', javadocDir: 'toolbox-core/build/docs/javadoc', keepAll: false])
            updateGitlabCommitStatus(name: 'build', state: 'success')
        }
        failure {
          updateGitlabCommitStatus(name: 'build', state: 'failed')
        }
    }
}