/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String pipelineType){

  figlet 'Maven'

  if (pipelineType == 'CI'){
    figlet 'Integracion Continua'

    stage('Compile') {
      STAGE = env.STAGE_NAME
      bat 'mvnw.cmd clean compile -e'
    }

    stage('Test') {
      STAGE = env.STAGE_NAME
     // bat './mvnw.bat clean test -e'
    }

    stage('Jar') {
      STAGE = env.STAGE_NAME
     // bat './mvnw.bat clean package -e'
    }
  } else {
    figlet 'Delivery Continuo'
    
    stage('Run') {
      STAGE = env.STAGE_NAME
     // bat 'nohup bash mvnw.bat spring-boot:run &'
     // sleep 20
    }
    
   /* stage('TestApp') {
      STAGE = env.STAGE_NAME
      sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
    }  */
  }

}

return this;