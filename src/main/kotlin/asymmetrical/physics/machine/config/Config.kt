package asymmetrical.physics.machine.config




object Config {

    private const val  _PhotonLth             = 1;
    private const val  _ClassIdLth            = 2;
    private const val  _THREAD_SLEEP:Long     = 8;  // Milliseconds
    private const val  _UPDATE_SLEEP:Long     = 2;
    private const val BASE52_ARRAY_SIZE:Int   = 3

    fun getBase52ArraySize() : Int {
        return BASE52_ARRAY_SIZE
    }


    fun getClassIdLth() : Int {
        return _ClassIdLth
    }

    fun getPhotonLength() : Int {
        return _PhotonLth
    }

    fun getThreadSleep() : Long {
        return _THREAD_SLEEP
    }
    fun getUpdateSleep() : Long {
        return _UPDATE_SLEEP
    }

}