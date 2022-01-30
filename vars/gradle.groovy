/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String pipelineType){

	figlet 'Gradle'

	if (pipelineType == 'CI'){
		figlet 'Integracion Continua'

		stage('build & unit test'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
			bat "./gradlew.bat clean build"
		}
			
		stage('sonar') {
		STAGE = env.STAGE_NAME
		figlet "Stage: ${env.STAGE_NAME}"
			steps {
				script {
					def scannerHome = tool 'sonar-scanner';
					withSonarQubeEnv('sonarqube-server') {
					  bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.sources=src -Dsonar.java.binaries=build"
					}
				}
			}
		}
						
		stage('Run'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('Test'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('UploadSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
	} else {
		figlet 'Delivery Continuo'

		stage('DownloadSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('RunSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('TestSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('UploadReleaseJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
	}
}

return this;