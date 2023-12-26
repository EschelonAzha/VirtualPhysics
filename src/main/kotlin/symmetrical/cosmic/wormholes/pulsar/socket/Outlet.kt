package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spacial.Beam

open class Outlet  {

    protected var records : Beam = Beam(2)
    protected var closed  : Boolean   = false
    constructor() {

    }

    open fun getClassId() : String {
        return getLocalClassId()
    }

    fun hasRecords() : Boolean {
        return records.size() > 0
    }
    fun pop() : Any? {
        return records.popLeft()
    }
    fun receiveRecords() : Beam {
        var result = records;
        records = Beam(2)
        return result
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Outlet::class)
    }
}