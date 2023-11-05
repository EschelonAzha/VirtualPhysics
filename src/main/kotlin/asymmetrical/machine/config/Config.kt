package asymmetrical.machine.config

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString


object Config {

    private val WEB_ROOT = QString("/Users/eschelonazha/Volume/PhysicsMonastery/Development/KotlinWEB/build/developmentExecutable")
  //  private val WEB_ROOT = QString("/Users/eschelonazha/Volume/PhysicsMonastery/Development/TestResponse/index.html")

    private const val  _RUNNABLE              = "http://localhost:63342/src/base/threads/Runnable.js";

    private const val  _RESIDENT_SERVER       = "";
    private const val  _RESIDENT_PORT         = 1;

    private const val  _CANVAS_WIDTH          = 1920.0;
    private const val  _CANVAS_HEIGHT         = 1080.0;

    private const val  _FIELD_DELIMITER       = "^_^";
    private const val  _BEGIN_ARRAY_DELIMITER = "~~[";
    private const val  _END_ARRAY_DELIMITER   = "]~~";

    private const val  _PhotonLth             = 1;
    private const val  _ClassIdLth            = 2;
    private const val  _THREAD_SLEEP:Long     = 8;  // Milliseconds
    private const val  _UPDATE_SLEEP:Long     = 2;
    private const val  _WEB_TIMEOUT :Long     = 100000
    private const val  _PING_REQUIRED:Long    = 30000

    private const val BASE52_ARRAY_SIZE:Int   = 3

    fun getBase52ArraySize() : Int {
        return BASE52_ARRAY_SIZE
    }
    fun getBeginArrayDelimiter() : String  {
        return _BEGIN_ARRAY_DELIMITER
    }
    fun getCanvasHeight() : Double {
        return _CANVAS_HEIGHT
    }

    fun getCanvasWidth() : Double {
        return _CANVAS_WIDTH
    }
    fun getClassIdLth() : Int {
        return _ClassIdLth
    }

    fun getEndArrayDelimiter() : String  {
        return _END_ARRAY_DELIMITER
    }

    fun getFieldDelimiter() : String  {
        return _FIELD_DELIMITER
    }

    fun getPhotonLength() : Int {
        return _PhotonLth
    }

    fun getResidentServer(): String  {
        return _RESIDENT_SERVER
    }

    fun getRunnable() : String  {
        return _RUNNABLE
    }

    fun getResidentPort() : Int {
        return _RESIDENT_PORT
    }
    fun getThreadSleep() : Long {
        return _THREAD_SLEEP
    }
    fun getUpdateSleep() : Long {
        return _UPDATE_SLEEP
    }
    fun getWebRoot() : QString {
        return WEB_ROOT
    }
    fun getWebTimeout() : Long {
        return _WEB_TIMEOUT
    }
    fun getPingRequired() : Long {
        return _PING_REQUIRED
    }
}