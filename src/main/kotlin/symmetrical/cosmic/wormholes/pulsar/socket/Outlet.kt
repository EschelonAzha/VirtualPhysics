package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class Outlet  {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    protected var records : Beam      = Beam(2)
    protected var closed  : Boolean   = false
    constructor() {

    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Outlet::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }

    fun hasRecords() : Boolean {
        return records.size() > 0
    }
    fun receiveRecords() : Beam {
        var result = records;
        records = Beam(2)
        return result
    }
    fun pop() : Any? {
        return records.popLeft()
    }
}